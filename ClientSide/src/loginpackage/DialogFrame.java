package loginpackage;

import com.client.FrameUI;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import remoteserver.RemoteServerInterface;


public class DialogFrame extends javax.swing.JDialog {
   
    private RemoteServerInterface server;
    private String Ip=""; 
    private String protocol="";
    private ArrayList<Map<String, Object>> map;
    private FrameUI mainframe;
    public static DialogFrame logindialog;
    public static SignupForm signupForm;
    
    private String branch;
    private String branch_id;
    private String user;
    private int userid=0;
    
    Pattern regx = Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
    public DialogFrame(java.awt.Frame parent,boolean modal) {
        initComponents();
        disableInputs(true);
        mainframe = new FrameUI();
        signupForm = new SignupForm(new JFrame(), true);
        setIconImage(new ImageIcon(getClass().getResource("/icons/Key2.png")).getImage());
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogpanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        server_IP = new javax.swing.JTextField();
        d_cancelbut = new javax.swing.JButton();
        d_okbut = new javax.swing.JButton();
        d_holder_pass = new javax.swing.JPasswordField();
        ipinfo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        toregister = new javax.swing.JLabel();
        d_email = new javax.swing.JTextField();
        emailTip = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImages(null);
        setResizable(false);

        dialogpanel.setBackground(new java.awt.Color(5, 16, 72));
        dialogpanel.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("User Login");
        dialogpanel.add(jLabel2);
        jLabel2.setBounds(100, 10, 370, 50);

        jSeparator1.setForeground(new java.awt.Color(204, 255, 255));
        dialogpanel.add(jSeparator1);
        jSeparator1.setBounds(10, 70, 550, 10);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Server IP :");
        dialogpanel.add(jLabel5);
        jLabel5.setBounds(50, 180, 140, 50);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Email :");
        dialogpanel.add(jLabel6);
        jLabel6.setBounds(40, 300, 150, 50);

        server_IP.setBackground(new java.awt.Color(0,0,0,100));
        server_IP.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        server_IP.setForeground(new java.awt.Color(255, 255, 255));
        server_IP.setBorder(null);
        server_IP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                server_IPActionPerformed(evt);
            }
        });
        dialogpanel.add(server_IP);
        server_IP.setBounds(230, 180, 320, 50);

        d_cancelbut.setBackground(new java.awt.Color(153, 153, 153));
        d_cancelbut.setForeground(new java.awt.Color(255, 255, 255));
        d_cancelbut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/clear.png"))); // NOI18N
        d_cancelbut.setToolTipText("");
        d_cancelbut.setBorder(null);
        d_cancelbut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d_cancelbutActionPerformed(evt);
            }
        });
        dialogpanel.add(d_cancelbut);
        d_cancelbut.setBounds(400, 510, 70, 40);

        d_okbut.setBackground(new java.awt.Color(102, 102, 102));
        d_okbut.setForeground(new java.awt.Color(255, 255, 255));
        d_okbut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/approve.png"))); // NOI18N
        d_okbut.setBorder(null);
        d_okbut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d_okbutActionPerformed(evt);
            }
        });
        dialogpanel.add(d_okbut);
        d_okbut.setBounds(490, 510, 70, 40);

        d_holder_pass.setBackground(new java.awt.Color(0,0,0,100));
        d_holder_pass.setFont(new java.awt.Font("Goudy Stout", 1, 24)); // NOI18N
        d_holder_pass.setForeground(new java.awt.Color(255, 255, 255));
        d_holder_pass.setBorder(null);
        d_holder_pass.setEchoChar('.');
        dialogpanel.add(d_holder_pass);
        d_holder_pass.setBounds(230, 430, 320, 50);

        ipinfo.setForeground(new java.awt.Color(255, 255, 255));
        ipinfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Info_1.png"))); // NOI18N
        ipinfo.setText("Give the IP of your server to run your program");
        dialogpanel.add(ipinfo);
        ipinfo.setBounds(10, 130, 490, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Password :");
        dialogpanel.add(jLabel8);
        jLabel8.setBounds(50, 430, 140, 50);

        toregister.setForeground(new java.awt.Color(153, 255, 153));
        toregister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Add User.png"))); // NOI18N
        toregister.setText("Register Here");
        toregister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toregisterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                toregisterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                toregisterMouseExited(evt);
            }
        });
        dialogpanel.add(toregister);
        toregister.setBounds(20, 570, 160, 40);

        d_email.setBackground(new java.awt.Color(0,0,0,100));
        d_email.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        d_email.setForeground(new java.awt.Color(255, 255, 255));
        d_email.setBorder(null);
        d_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                d_emailKeyPressed(evt);
            }
        });
        dialogpanel.add(d_email);
        d_email.setBounds(230, 300, 320, 50);

        emailTip.setForeground(new java.awt.Color(204, 255, 255));
        dialogpanel.add(emailTip);
        emailTip.setBounds(230, 360, 320, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(dialogpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(dialogpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   
    /***Getters for branchName,UserName,ServerIP**/
    public String getBranch(){
      return branch;
    }
    public String getUserName(){
      return user;
    }
    public String getBranchId(){
       return branch_id;
    }
   
    public static void setBranch(String branch){
       DialogFrame.logindialog.branch = branch;
    }
    static void setUser(String user){
        DialogFrame.logindialog.user = user;
    }
    
    public int getUserId(){
       return userid;
    }
    
    public FrameUI getMainFrame(){
       return mainframe;
    }
    
    /** Sets counted Data for Sale,Purchase and Employee **/
    public void setCounts(){
        try {
            mainframe.total_sales.setText("Total Sales :" + (server.getCounted("sales", getBranch()) ));
            mainframe.total_purchase.setText("Total Purchase :" +(server.getCounted("buy", getBranch())));
            mainframe.total_employee.setText("Total Employees :"+ (server.getCounted("employee", getBranch())));
        } catch (RemoteException ex) {
            mainframe.total_sales.setText("Total Sales : Unknown");
            mainframe.total_purchase.setText("Total Purchase : Unknown");
            mainframe.total_employee.setText("Total Employees : Unknown");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,ex.getMessage(),"SQL Error",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public boolean hasEmpty(String email, String pass){
      if(email.trim().isEmpty() || pass.trim().isEmpty()){
         return true;
      }else
         return false;
    }
    
    /** Input verifier for data **/
    public boolean verifyInput() throws RemoteException,SQLException{ 
      String email = d_email.getText();
      String password = d_holder_pass.getText();
      boolean valid = true;
      if(hasEmpty(email, password)){
         JOptionPane.showMessageDialog(null,"You Must Fill All Fields","Empty Input",JOptionPane.ERROR_MESSAGE); 
         valid = false;
      }else{
         String query = "SELECT * FROM holder WHERE Email='"+email+"' AND Password='"+ password +"'";  
         map = server.selectFromDb(query);
         if(map.isEmpty()){
            JOptionPane.showMessageDialog(null,"Wrong Credentials \n check your email or passsword","Incorrect Input",JOptionPane.WARNING_MESSAGE);
            valid = false;
         }else{
            user = map.get(0).get("Name").toString();
            branch_id = map.get(0).get("BranchID").toString();
            userid= Integer.parseInt(map.get(0).get("ID").toString());
            query = "SELECT Name FROM branch WHERE ID='"+ map.get(0).get("BranchID").toString() + "'";
            map = server.selectFromDb(query);
            if(!map.isEmpty()){
              branch = map.get(0).get("Name").toString();
            }else{
              branch = "Unknown";
            }
            valid = true;
         }
      }

      return valid; 
    }
    
    /** Lookup the Remote Object **/ 
    public void setupServer() throws RemoteException, NotBoundException{
        Ip = server_IP.getText().trim();
        protocol = "rmi://"+ Ip + "/ServerRoom";
        Registry reg = LocateRegistry.getRegistry(Ip, 9010);
        server = (RemoteServerInterface)reg.lookup(protocol);
    
    }
   
    
    /** input field disabler **/
    private void disableInputs(boolean bool){
        d_email.setEnabled(!bool);
        d_holder_pass.setEnabled(!bool);
        d_okbut.setEnabled(!bool);
        toregister.setVisible(!bool);
        if(!bool){
          ipinfo.setVisible(bool);
        }
    }
    
    /** Server-IP action handler **/
    private void server_IPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_server_IPActionPerformed
        try {
            setupServer();
            FrameUI.setServer(server);
            SignupForm.setServer(server);
            disableInputs(false);
            server_IP.setEnabled(false);
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Remote Exception",JOptionPane.ERROR_MESSAGE);
        } catch (NotBoundException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Server Error",JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_server_IPActionPerformed

    /** Cancel button handler(clear input fields) **/
    private void d_cancelbutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d_cancelbutActionPerformed
        d_email.setText("");
        d_holder_pass.setText("");
    }//GEN-LAST:event_d_cancelbutActionPerformed

    /** OK button handler **/
    private void d_okbutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d_okbutActionPerformed
        try {
            if(verifyInput()){
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        mainframe.setVisible(true);
                        logindialog.setVisible(false);
                        mainframe.branch_home.setText("Branch Name : "+ getBranch());
                        mainframe.Id_home.setText("Branch Id : "+ branch_id);
                        setCounts();
                    }
                });
            }
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null,ex.getCause(),"Remote Connection Error",JOptionPane.ERROR_MESSAGE);  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage(),"SQL Error",JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_d_okbutActionPerformed

    private void toregisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toregisterMouseClicked
        logindialog.setVisible(false);
        SignupForm.setSignUpInstance(signupForm);
        signupForm.setLocationRelativeTo(null);
        try {
            signupForm.setupBranch();
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null,ex.getCause(),"Remote Connection Error",JOptionPane.ERROR_MESSAGE);  
            return;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage(),"SQL Error",JOptionPane.ERROR_MESSAGE); 
            return;
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                    signupForm.addWindowListener(new WindowAdapter() {
                    @Override
                     public void windowClosing(WindowEvent e){ 
                        signupForm.dispose();
                        logindialog.setVisible(true);
                     }
                  });
              signupForm.setVisible(true);   
            }
        });
        
    }//GEN-LAST:event_toregisterMouseClicked

    private void toregisterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toregisterMouseEntered
       toregister.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }//GEN-LAST:event_toregisterMouseEntered

    private void toregisterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toregisterMouseExited
       toregister.setBorder(null);
    }//GEN-LAST:event_toregisterMouseExited

    private void d_emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_d_emailKeyPressed
        if(d_email.getText().length() > 10){
          Matcher matcher = regx.matcher(d_email.getText());
          if(!matcher.matches()){  
            emailTip.setText("Use Proper Email format ...");
          }else{
            emailTip.setText("");
          }
        }else{
          emailTip.setText("");
        }
    }//GEN-LAST:event_d_emailKeyPressed
    
   
    
    
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                    logindialog = new DialogFrame(new JFrame(),true);
                    logindialog.addWindowListener(new WindowAdapter() {
                    @Override
                     public void windowClosing(WindowEvent e){
                        System.exit(0);
                     }
                  });
                 logindialog.setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton d_cancelbut;
    private javax.swing.JTextField d_email;
    private javax.swing.JPasswordField d_holder_pass;
    private javax.swing.JButton d_okbut;
    private javax.swing.JPanel dialogpanel;
    private javax.swing.JLabel emailTip;
    private javax.swing.JLabel ipinfo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField server_IP;
    private javax.swing.JLabel toregister;
    // End of variables declaration//GEN-END:variables
}
