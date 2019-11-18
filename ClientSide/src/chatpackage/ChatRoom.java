package chatpackage;

import chat.MessageContent;
import chat.Profile;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.sun.javafx.tk.FontMetrics;
import com.sun.javafx.tk.Toolkit;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javafx.application.Platform;
import javax.swing.Timer;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import loginpackage.DialogFrame;
import remoteserver.RemoteServerInterface;

public class ChatRoom implements Serializable {

    private HBox mainbox;
    private VBox sidebox;
    private JFXListView<HBox> chatArea;
    private JFXListView<Profile> onlinelist;
    private JFXTextArea messageInput;
    private JFXButton sendbut, filebut;
    private HBox bottom;
    private TextFlow textflow;

    public static RemoteServerInterface server;
    private int id= 0;
    public static Timer timer, timer2;
    
    ArrayList<MessageContent> ppMessages;
    ArrayList<MessageContent> gMessages;
    ArrayList<Integer> activeUList;
    
    public void initComponents(JFXPanel jfxpanel) {
        mainbox = new HBox();
        mainbox.setFillHeight(true);
        mainbox.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("chat.jpg")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        mainbox.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        sidebox = new VBox(10);
        sidebox.setPrefSize(700, 700);

        messageInput = new JFXTextArea();
        messageInput.setMaxSize(400, 70);
        messageInput.setPromptText("Write message...");

        sendbut = new JFXButton("Send");
        filebut = new JFXButton("File");
//        groupsend = new JFXButton("Group Text");
        filebut.getStyleClass().add("filebut");
        sendbut.getStyleClass().add("sendbut");
        FontAwesomeIconView icon = new FontAwesomeIconView(FontAwesomeIcon.PAPERCLIP);
        icon.setSize("16");
        filebut.setGraphic(icon);
        sendbut.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.SEND));
//        groupsend.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.GROUP));
//        groupsend.setGraphicTextGap(5);
        filebut.setGraphicTextGap(5);
        sendbut.setGraphicTextGap(5);

        bottom = new HBox(20);
        bottom.setPrefSize(615, 80);
        bottom.setAlignment(Pos.CENTER);
        VBox buttonholder = new VBox(6, filebut, sendbut);
        buttonholder.setAlignment(Pos.BOTTOM_CENTER);
        bottom.getChildren().addAll(messageInput, buttonholder);

        onlinelist = new JFXListView<>();
        onlinelist.getStyleClass().add("userlist");
        onlinelist.setPrefSize(200, 700);
        onlinelist.setVerticalGap(new Double(20));
        onlinelist.setExpanded(true);
        chatArea = new JFXListView<>();
        chatArea.setVerticalGap(new Double(25));
        chatArea.setExpanded(true);
        chatArea.setPrefSize(700, 600);
        chatArea.setCellFactory((ListView<HBox> L) -> new UsersCell());
        onlinelist.setCellFactory((ListView<Profile> P) -> new OnlineCell());

        sidebox.getChildren().addAll(chatArea, bottom);
        mainbox.getChildren().addAll(onlinelist, sidebox);

        onlinelist.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (onlinelist.getSelectionModel().getSelectedItem() != null) {
                    if(id != onlinelist.getSelectionModel().getSelectedItem().getID()){
                        chatArea.getItems().removeAll(chatArea.getItems());
                        id = onlinelist.getSelectionModel().getSelectedItem().getID(); 
                        try {
                            ArrayList<MessageContent> messages = server.checkMessage(id, DialogFrame.logindialog.getUserId());
                            printMessages(messages);
                        } catch (SQLException | IOException ex) {
                           JOptionPane.showMessageDialog(null,ex.getMessage(),"Exception",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }

        });
        //single message send   
        sendbut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (id != 0 && id != DialogFrame.logindialog.getUserId()) {
                        if (!messageInput.getText().trim().isEmpty()) {
                          String query = "INSERT INTO chat (Message,SentBy,RecievedBy) VALUES('"+messageInput.getText()+"',"+
                                  String.valueOf(DialogFrame.logindialog.getUserId())+","+String.valueOf(id)+")";
                          server.insertToDb(query);
                          HBox box = prettyView(messageInput.getText(),"right", calculateTime());
                          chatArea.getItems().add(box);
                          messageInput.setText("");
                          Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    chatArea.scrollTo(box);
                                }
                             });
                        }
                    }
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Remote Connection Error",JOptionPane.ERROR_MESSAGE); 
                } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null,ex.getMessage(),"SQL ERROR",JOptionPane.ERROR_MESSAGE); 
                }
            }
        });
        //filesend button handler
        filebut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser filechose = new FileChooser();
                filechose.getExtensionFilters().addAll(new ExtensionFilter("All File", "*.*"));
                File file = filechose.showOpenDialog(new Stage());
                    if (file != null && !file.isDirectory() && id != DialogFrame.logindialog.getUserId() && id != 0) {
                        int source = DialogFrame.logindialog.getUserId();
                        MessageContent message = new MessageContent(source,id,messageInput.getText(),file.getName(),getByteArray(file));
                        try {
                          server.uploadFile(message);
                          HBox box = prettyFileView(messageInput.getText(),"right",calculateTime(), file);
                          chatArea.getItems().add(box);
                          messageInput.setText("");
                          Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    chatArea.scrollTo(box);
                                }
                             });
                        } catch (RemoteException ex) {
                           JOptionPane.showMessageDialog(null,ex.getMessage(),"Remote Connection ERROR",JOptionPane.ERROR_MESSAGE); 
                        } catch (IOException ex) {
                           JOptionPane.showMessageDialog(null,ex.getMessage(),"File upload Failed",JOptionPane.ERROR_MESSAGE);  
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage(),"SQL Error",JOptionPane.ERROR_MESSAGE); 
                        }
                        
                    }

            }
        });

//        groupsend.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                if (!messageInput.getText().trim().isEmpty()) {
//                    
//                    try{
//                     String query = "INSERT INTO chat (MessageType,Message,SentBy) values(3,'"+messageInput.getText()+"',"+
//                             String.valueOf(DialogFrame.logindialog.getUserId())+")";  
//                     server.insertToDb(query);
//                    } catch (RemoteException ex) {
//                       JOptionPane.showMessageDialog(null,ex.getMessage(),"Remote Connection ERROR",JOptionPane.ERROR_MESSAGE); ;
//                    } catch (SQLException ex) {
//                        JOptionPane.showMessageDialog(null,ex.getMessage(),"SQL Error",JOptionPane.ERROR_MESSAGE);  
//                    }
//                }
//
//            }
//        });

        Scene scene = new Scene(mainbox, 900, 700);
        jfxpanel.setScene(scene);

  
    }

    public void startListening() {
        timer = new Timer(200, new Listener());
        timer2 = new Timer(1000, new Listener2());
        timer2.start();
        timer.start();
    }

//pretty view
    public HBox prettyView(String message, String orientation, String time) {
        HBox tmp = new HBox(5);
        FontMetrics metric = Toolkit.getToolkit().getFontLoader().getFontMetrics(Font.getDefault());
        float swidth = metric.computeStringWidth(message);
        textflow = new TextFlow();
        Text text = new Text();
        if (swidth > 400) {
            text.wrappingWidthProperty().set(400);
            textflow.prefWidthProperty().bind(text.wrappingWidthProperty());
        }
        text.setStyle("-fx-font-family: \'Adobe Hebrew\';");
        text.setText(message + "\n\n");
        Text t2 = new Text(time);
        t2.setStyle("-fx-text-fill: #e6e6e6;");
        t2.textAlignmentProperty().set(TextAlignment.RIGHT);
        textflow.getChildren().addAll(text,t2);
        
        if (orientation.equalsIgnoreCase("left")) {
            textflow.getStyleClass().add("leftmessage");
            tmp.setAlignment(Pos.CENTER_LEFT);
        } else {
            textflow.getStyleClass().add("rightmessage");
            tmp.setAlignment(Pos.CENTER_RIGHT);
        }

        tmp.getChildren().add(textflow);
        return tmp;
    }

//pretty view forfile   
    public HBox prettyFileView(String message, String orientation, String time, File file) {
        HBox tmp = new HBox(5);
        FontMetrics metric = Toolkit.getToolkit().getFontLoader().getFontMetrics(Font.getDefault());
        float swidth = metric.computeStringWidth(message);
        textflow = new TextFlow();
        Text t2 = new Text();
        if (swidth > 400) {
            t2.wrappingWidthProperty().set(400);
            textflow.prefWidthProperty().bind(t2.wrappingWidthProperty());
        }
        t2.setStyle("-fx-font-family: \'Adobe Hebrew\';");
        t2.setText("   "+file.getName()+"\n\n"+message+"\n\n");
        Text t3 = new Text( time + "\n");
        t3.setStyle("-fx-text-fill: #e6e6e6;");
        t3.textAlignmentProperty().set(TextAlignment.RIGHT);
        FontAwesomeIconView dicon = new FontAwesomeIconView(FontAwesomeIcon.FILE);
        dicon.setSize("20");
        textflow.getChildren().addAll(dicon,t2,t3);
        textflow.getStyleClass().add("hoverable");
        textflow.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                   JOptionPane.showMessageDialog(null,ex.getMessage(),"File Can't Open",JOptionPane.ERROR_MESSAGE); 
                }
            }

        });
        if (orientation.equalsIgnoreCase("left")) {
            textflow.getStyleClass().add("leftmessage");
            tmp.setAlignment(Pos.CENTER_LEFT);
        } else {
            textflow.getStyleClass().add("rightmessage");
            tmp.setAlignment(Pos.CENTER_RIGHT);
        }
        
        tmp.getChildren().addAll(textflow);
        return tmp;
    }

//updates when ever new user logged in
    public void updateOnlineList() {    
        try {
                ArrayList<Profile> allusers = server.getAllUsers(DialogFrame.logindialog.getUserId());
                if(!allusers.isEmpty()){
                    if(onlinelist.getItems().size() < allusers.size()){
                        for(int i=onlinelist.getItems().size(); i<allusers.size() ; i++){
                            if(allusers.get(i).getID() != DialogFrame.logindialog.getUserId()){
                               onlinelist.getItems().add(allusers.get(i));
                            }  
                        }
                    }
                }   
             } catch (SQLException ex) {
                 return;
             } catch (IOException ex) {
                 return;
             }
    }

//Online users filler
    public void fillOnlineUsers() {
        try {
            onlinelist.getItems().removeAll(onlinelist.getItems());
            onlinelist.getItems().addAll(server.getAllUsers(DialogFrame.logindialog.getUserId()));
        } catch (RemoteException ex) {
            return;
        } catch (SQLException ex) {
            return;
        }
    }
    
 // clear chat area on logout
    public void clearChatArea(){
       chatArea.getItems().removeAll(chatArea.getItems());
    }
    
//reading bytes from the file
    public byte[] getByteArray(File file) {
        byte[] bytedata = null;
        try {
            bytedata = Files.readAllBytes(file.toPath());
        } catch (IOException ex) {
            return null;
        }

        return bytedata;
    }

//write bytes to a file
    public File writeBytes(String filename, byte[] bytedata) {
        File file = new File(filename);
        if (file.exists()) {
            int lasti = filename.lastIndexOf(".");
            String ext = filename.substring(lasti);
            String fname = filename.replace(ext,"");
            file = new File(fname + String.valueOf(new Random().nextInt(50)) + ext);
        }
        try {
            file.createNewFile();
            Files.write(file.toPath(), bytedata, StandardOpenOption.WRITE);
        } catch (IOException ex) {
            return null;
        }
        return file;
    }

//customized list cell view for online list    
    private class OnlineCell extends ListCell<Profile> {

        @Override
        protected void updateItem(Profile item, boolean empty) {
            super.updateItem(item, empty);
                    getStyleClass().add("leftcell");
                    setGraphic(null);
            if (item != null) {
                setText(item.getName());

            }
        }
    }

//customized list cell view for chat area
    private class UsersCell extends ListCell<HBox> {

        @Override
        protected void updateItem(HBox item, boolean empty) {
            super.updateItem(item, empty);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    getStyleClass().add("cell");
                    setGraphic(null);
                    setText(null);  
                }
            });
            
            if (item != null) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        setGraphic(item);
                    }
                });
            }
        }
    }

//listener for incoming messages for each 50ms
    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            try {
                ppMessages = server.checkMessage(id,DialogFrame.logindialog.getUserId());
                printMessages(ppMessages);
                
             } catch (SQLException ex) {
                 return;
             } catch (IOException ex) {
                 return;
             }
        }

    }

    private class Listener2 implements ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                          updateOnlineList();

                }
            });

        }

    }
    
    public final String calculateTime() {
        Timestamp t = new Timestamp(System.currentTimeMillis());
        Date d = new Date(t.getTime());
        return d.toString();
        
    } 
    
    public String goodDate(Date d){
        Timestamp t = new Timestamp(d.getTime());
        Date date = new Date(t.getTime());
        return date.toString();
    }
    
    public void printMessages(ArrayList<MessageContent> ppMessages){
        if(!ppMessages.isEmpty()){
                    if(chatArea.getItems().size() < ppMessages.size()){
                        for(int i=chatArea.getItems().size(); i<ppMessages.size() ; i++){
                            HBox box;
                            if(ppMessages.get(i).hasFile()){
                              String orient;
                              if(ppMessages.get(i).getFrom() == DialogFrame.logindialog.getUserId()){
                                 orient = "right";
                              }else{
                                 orient = "left";
                              }
                              File file;  
                              if(ppMessages.get(i).getFile() != null) {
                                file = writeBytes(ppMessages.get(i).getFileName(),ppMessages.get(i).getFile()); 
                                 box = prettyFileView(ppMessages.get(i).getMessage(),orient,goodDate(ppMessages.get(i).getTime()), file);
                              }else{
                                 box = prettyView("File Misssing\n" + ppMessages.get(i).getMessage(),orient, goodDate(ppMessages.get(i).getTime()).toString()); 
                              }
                            
                            }else{
                              String orient;
                              if(ppMessages.get(i).getFrom() == DialogFrame.logindialog.getUserId()){
                                 orient = "right";
                              }else{
                                 orient = "left";
                              }  
                              box = prettyView(ppMessages.get(i).getMessage(),orient, goodDate(ppMessages.get(i).getTime()).toString());
                            }
                            chatArea.getItems().add(box);
                             Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    chatArea.scrollTo(box);
                                }
                             });
                            
                        }
                    }
                }
    }

}
