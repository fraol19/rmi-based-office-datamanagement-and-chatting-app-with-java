package com.client;

import chat.Profile;
import loginpackage.DialogFrame;
import chatpackage.ChatRoom;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.JTextComponent;
import remoteserver.RemoteServerInterface;

public class FrameUI extends javax.swing.JFrame {

    private static RemoteServerInterface server;
    private ArrayList<Map<String, Object>> map;
    private ArrayList<JTextComponent> textFileds;
    private ButtonGroup group1, group2;

    private ChatRoom chatclass;
    private JDialog chatbox;
    private static Profile profile;

    private static Statistics statInstance;

    String query = "";
    int row;

    public FrameUI() {
        initComponents();
        initRadios();
        chatclass = new ChatRoom();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    if (ChatRoom.timer != null) {
                        if (ChatRoom.timer.isRunning()) {
                            ChatRoom.timer.stop();
                            ChatRoom.timer2.stop();
                        }
                    }
                    server.removeActiveUser(DialogFrame.logindialog.getUserId());
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Remote Log out error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        setIconImage(new ImageIcon(getClass().getResource("/icons/Related Companies.png")).getImage());
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initChatbox();
            }
        });

        //hide input and display panels from the frame
        hideContainer(true, "entry");
        hideContainer(true, "display");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainWorkspace = new javax.swing.JPanel();
        homepan1 = new javax.swing.JPanel();
        homelabel6 = new javax.swing.JLabel();
        Id_home = new javax.swing.JLabel();
        branch_home = new javax.swing.JLabel();
        stat_panel = new javax.swing.JPanel();
        BudgetPan = new javax.swing.JPanel();
        homelabel3 = new javax.swing.JLabel();
        budgetlabel1 = new javax.swing.JLabel();
        sellPan = new javax.swing.JPanel();
        homelabel5 = new javax.swing.JLabel();
        sell_label = new javax.swing.JLabel();
        buyPan = new javax.swing.JPanel();
        homelabel4 = new javax.swing.JLabel();
        buylabel = new javax.swing.JLabel();
        homeliner1 = new javax.swing.JSeparator();
        Systempanel = new javax.swing.JPanel();
        homelabel1 = new javax.swing.JLabel();
        homelabel2 = new javax.swing.JLabel();
        menuLayer = new javax.swing.JPanel();
        menuicon1 = new javax.swing.JLabel();
        displaytab = new javax.swing.JLabel();
        addtab = new javax.swing.JLabel();
        chat_tab = new javax.swing.JLabel();
        logout_tab = new javax.swing.JLabel();
        insert_Tpane = new javax.swing.JPanel();
        E_tabbedpane = new javax.swing.JTabbedPane();
        budget_Tpane = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        entrylabel1 = new javax.swing.JLabel();
        entrylabel2 = new javax.swing.JLabel();
        entrylabel3 = new javax.swing.JLabel();
        b_field = new javax.swing.JFormattedTextField();
        bdate_field = new javax.swing.JFormattedTextField();
        fund_field = new javax.swing.JFormattedTextField();
        budget_go = new javax.swing.JButton();
        budget_clear = new javax.swing.JButton();
        sales_Tpane = new javax.swing.JPanel();
        panel2 = new javax.swing.JPanel();
        entrylabel5 = new javax.swing.JLabel();
        entrylabel6 = new javax.swing.JLabel();
        entrylabel7 = new javax.swing.JLabel();
        sale_price = new javax.swing.JFormattedTextField();
        sale_profit = new javax.swing.JFormattedTextField();
        total_sales = new javax.swing.JLabel();
        sale_name = new javax.swing.JTextField();
        entrylabel8 = new javax.swing.JLabel();
        sale_qt = new javax.swing.JFormattedTextField();
        enlabel9 = new javax.swing.JLabel();
        sell_id = new javax.swing.JTextField();
        sale_buyer = new javax.swing.JTextField();
        enlabel10 = new javax.swing.JLabel();
        entrylabel18 = new javax.swing.JLabel();
        sale_go = new javax.swing.JButton();
        sale_clear = new javax.swing.JButton();
        scrollpane9 = new javax.swing.JScrollPane();
        salereport = new javax.swing.JTextPane();
        buy_Tpane = new javax.swing.JPanel();
        panel3 = new javax.swing.JPanel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        buy_price = new javax.swing.JFormattedTextField();
        total_purchase = new javax.swing.JLabel();
        buy_name = new javax.swing.JTextField();
        enlabel11 = new javax.swing.JLabel();
        buy_qt = new javax.swing.JFormattedTextField();
        enlabel12 = new javax.swing.JLabel();
        buy_seller = new javax.swing.JTextField();
        buy_id = new javax.swing.JTextField();
        entrylabel17 = new javax.swing.JLabel();
        pur_go = new javax.swing.JButton();
        pur_clear = new javax.swing.JButton();
        scrollpane6 = new javax.swing.JScrollPane();
        purchase_report = new javax.swing.JTextPane();
        Emp_Tpane = new javax.swing.JPanel();
        panel4 = new javax.swing.JPanel();
        entrylabel9 = new javax.swing.JLabel();
        entrylabel10 = new javax.swing.JLabel();
        entrylabel11 = new javax.swing.JLabel();
        emp_name = new javax.swing.JTextField();
        entrylabel12 = new javax.swing.JLabel();
        emp_age = new javax.swing.JFormattedTextField();
        enlabel13 = new javax.swing.JLabel();
        emp_job = new javax.swing.JTextField();
        femal_radio = new javax.swing.JRadioButton();
        male_radio = new javax.swing.JRadioButton();
        emp_address = new javax.swing.JTextField();
        entrylabel13 = new javax.swing.JLabel();
        entrylabel14 = new javax.swing.JLabel();
        entrylabel15 = new javax.swing.JLabel();
        emp_phone = new javax.swing.JFormattedTextField();
        emp_salary = new javax.swing.JFormattedTextField();
        DOA = new javax.swing.JFormattedTextField();
        total_employee = new javax.swing.JLabel();
        scrollpane5 = new javax.swing.JScrollPane();
        emp_report = new javax.swing.JTextPane();
        entrylabel16 = new javax.swing.JLabel();
        emp_go = new javax.swing.JButton();
        emp_clear = new javax.swing.JButton();
        display_Tpane = new javax.swing.JPanel();
        tabbedPane = new javax.swing.JTabbedPane();
        disp_sTpane = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        sale_tabel = new javax.swing.JTable();
        disp_pTpane = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        purchase_tabel = new javax.swing.JTable();
        disp_eTpane = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        emp_tabel = new javax.swing.JTable();
        tabbedpane2 = new javax.swing.JTabbedPane();
        searchtab2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        idradio = new javax.swing.JRadioButton();
        nameradio = new javax.swing.JRadioButton();
        dateradio = new javax.swing.JRadioButton();
        priceradio = new javax.swing.JRadioButton();
        search_input = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        disp_search = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        rowIndicator = new javax.swing.JLabel();
        tabbb = new javax.swing.JPanel();
        scrollpane4 = new javax.swing.JScrollPane();
        report_display = new javax.swing.JTextPane();
        updateReport = new javax.swing.JButton();
        deletebut = new javax.swing.JButton();
        disp_refresh = new javax.swing.JButton();
        menuicon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RB Office DataManager");
        setResizable(false);

        mainWorkspace.setBackground(new java.awt.Color(32, 47, 90));
        mainWorkspace.setLayout(null);

        homepan1.setBackground(new java.awt.Color(32, 47, 90));
        homepan1.setLayout(null);

        homelabel6.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        homelabel6.setForeground(new java.awt.Color(255, 204, 204));
        homelabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homelabel6.setText("Statistical Preview");
        homepan1.add(homelabel6);
        homelabel6.setBounds(190, 150, 540, 40);

        Id_home.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        Id_home.setForeground(new java.awt.Color(255, 204, 204));
        Id_home.setText("ID: ");
        homepan1.add(Id_home);
        Id_home.setBounds(590, 70, 220, 30);

        branch_home.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        branch_home.setForeground(new java.awt.Color(255, 204, 204));
        branch_home.setText("Branch : ");
        homepan1.add(branch_home);
        branch_home.setBounds(590, 10, 360, 40);

        mainWorkspace.add(homepan1);
        homepan1.setBounds(120, 230, 1000, 190);

        stat_panel.setBackground(new java.awt.Color(32, 47, 90));

        BudgetPan.setBackground(new java.awt.Color(106, 116, 145));
        BudgetPan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BudgetPanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BudgetPanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BudgetPanMouseExited(evt);
            }
        });
        BudgetPan.setLayout(null);

        homelabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homelabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Sales Performance.png"))); // NOI18N
        BudgetPan.add(homelabel3);
        homelabel3.setBounds(31, 74, 206, 133);

        budgetlabel1.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        budgetlabel1.setForeground(new java.awt.Color(255, 255, 255));
        budgetlabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        budgetlabel1.setText("Final Budget");
        BudgetPan.add(budgetlabel1);
        budgetlabel1.setBounds(42, 7, 180, 54);

        sellPan.setBackground(new java.awt.Color(106, 116, 145));
        sellPan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sellPanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sellPanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sellPanMouseExited(evt);
            }
        });
        sellPan.setLayout(null);

        homelabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homelabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Sale.png"))); // NOI18N
        sellPan.add(homelabel5);
        homelabel5.setBounds(31, 80, 210, 133);

        sell_label.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        sell_label.setForeground(new java.awt.Color(255, 255, 255));
        sell_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sell_label.setText("Sales");
        sellPan.add(sell_label);
        sell_label.setBounds(50, 10, 170, 54);

        buyPan.setBackground(new java.awt.Color(106, 116, 145));
        buyPan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buyPanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buyPanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buyPanMouseExited(evt);
            }
        });
        buyPan.setLayout(null);

        homelabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homelabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Buy.png"))); // NOI18N
        buyPan.add(homelabel4);
        homelabel4.setBounds(50, 80, 190, 133);

        buylabel.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        buylabel.setForeground(new java.awt.Color(255, 255, 255));
        buylabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buylabel.setText("Purchases");
        buyPan.add(buylabel);
        buylabel.setBounds(70, 10, 150, 54);

        javax.swing.GroupLayout stat_panelLayout = new javax.swing.GroupLayout(stat_panel);
        stat_panel.setLayout(stat_panelLayout);
        stat_panelLayout.setHorizontalGroup(
            stat_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stat_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stat_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(stat_panelLayout.createSequentialGroup()
                        .addComponent(homeliner1)
                        .addContainerGap())
                    .addGroup(stat_panelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(BudgetPan, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(sellPan, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(buyPan, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        stat_panelLayout.setVerticalGroup(
            stat_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stat_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeliner1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(stat_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BudgetPan, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sellPan, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buyPan, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        mainWorkspace.add(stat_panel);
        stat_panel.setBounds(120, 420, 1000, 270);

        Systempanel.setForeground(new java.awt.Color(255, 255, 255));
        Systempanel.setLayout(null);

        homelabel1.setFont(new java.awt.Font("Segoe UI Historic", 1, 48)); // NOI18N
        homelabel1.setForeground(new java.awt.Color(0, 51, 153));
        homelabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homelabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Workspace.png"))); // NOI18N
        homelabel1.setText("Manage Your Office Data");
        homelabel1.setIconTextGap(11);
        Systempanel.add(homelabel1);
        homelabel1.setBounds(10, 70, 770, 120);

        homelabel2.setBackground(new java.awt.Color(255, 255, 255));
        homelabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        homelabel2.setForeground(new java.awt.Color(102, 0, 102));
        homelabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Related Companies.png"))); // NOI18N
        homelabel2.setText("RB Data Manager");
        homelabel2.setIconTextGap(7);
        Systempanel.add(homelabel2);
        homelabel2.setBounds(10, 10, 210, 40);

        mainWorkspace.add(Systempanel);
        Systempanel.setBounds(120, 0, 1000, 230);

        menuLayer.setBackground(new java.awt.Color(32, 47, 90));
        menuLayer.setForeground(new java.awt.Color(255, 255, 255));
        menuLayer.setLayout(null);

        menuicon1.setBackground(new java.awt.Color(255, 255, 255));
        menuicon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Double Left.png"))); // NOI18N
        menuicon1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuicon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuicon1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuicon1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuicon1MouseExited(evt);
            }
        });
        menuLayer.add(menuicon1);
        menuicon1.setBounds(60, 10, 50, 40);

        displaytab.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        displaytab.setForeground(new java.awt.Color(51, 237, 215));
        displaytab.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        displaytab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Show Property.png"))); // NOI18N
        displaytab.setText("Display");
        displaytab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displaytabMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                displaytabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                displaytabMouseExited(evt);
            }
        });
        menuLayer.add(displaytab);
        displaytab.setBounds(0, 210, 120, 50);

        addtab.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        addtab.setForeground(new java.awt.Color(51, 237, 215));
        addtab.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        addtab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Add User.png"))); // NOI18N
        addtab.setText("Entry");
        addtab.setIconTextGap(6);
        addtab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addtabMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addtabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addtabMouseExited(evt);
            }
        });
        menuLayer.add(addtab);
        addtab.setBounds(0, 150, 120, 50);

        chat_tab.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        chat_tab.setForeground(new java.awt.Color(51, 237, 215));
        chat_tab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Chat.png"))); // NOI18N
        chat_tab.setText("Chat");
        chat_tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chat_tabMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                chat_tabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                chat_tabMouseExited(evt);
            }
        });
        menuLayer.add(chat_tab);
        chat_tab.setBounds(0, 280, 120, 50);

        logout_tab.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        logout_tab.setForeground(new java.awt.Color(51, 237, 215));
        logout_tab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Logout.png"))); // NOI18N
        logout_tab.setText("Logout");
        logout_tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logout_tabMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logout_tabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logout_tabMouseExited(evt);
            }
        });
        menuLayer.add(logout_tab);
        logout_tab.setBounds(0, 350, 120, 50);

        mainWorkspace.add(menuLayer);
        menuLayer.setBounds(0, 0, 120, 690);

        insert_Tpane.setBackground(new java.awt.Color(32, 47, 90));
        insert_Tpane.setLayout(null);

        E_tabbedpane.setBackground(new java.awt.Color(106, 116, 145));
        E_tabbedpane.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        E_tabbedpane.setName(""); // NOI18N

        budget_Tpane.setBackground(new java.awt.Color(32, 47, 90));
        budget_Tpane.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        budget_Tpane.setLayout(null);

        panel1.setBackground(new java.awt.Color(32, 47, 90));
        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Budget and Information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(204, 204, 204))); // NOI18N
        panel1.setLayout(null);

        entrylabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        entrylabel1.setForeground(new java.awt.Color(204, 204, 204));
        entrylabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        entrylabel1.setText("Budget Amount :");
        panel1.add(entrylabel1);
        entrylabel1.setBounds(80, 80, 170, 40);

        entrylabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        entrylabel2.setForeground(new java.awt.Color(204, 204, 204));
        entrylabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        entrylabel2.setText("Approval Date :(yyyy-mm-dd)");
        panel1.add(entrylabel2);
        entrylabel2.setBounds(30, 160, 220, 40);

        entrylabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        entrylabel3.setForeground(new java.awt.Color(204, 204, 204));
        entrylabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        entrylabel3.setText("Fundings :");
        panel1.add(entrylabel3);
        entrylabel3.setBounds(40, 240, 210, 40);

        b_field.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        b_field.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        panel1.add(b_field);
        b_field.setBounds(290, 80, 256, 40);

        bdate_field.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        bdate_field.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        panel1.add(bdate_field);
        bdate_field.setBounds(290, 160, 256, 40);

        fund_field.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        fund_field.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        panel1.add(fund_field);
        fund_field.setBounds(290, 240, 256, 40);

        budget_Tpane.add(panel1);
        panel1.setBounds(30, 60, 950, 400);

        budget_go.setBackground(new java.awt.Color(161, 198, 210));
        budget_go.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        budget_go.setText("ADD");
        budget_go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                budget_goActionPerformed(evt);
            }
        });
        budget_Tpane.add(budget_go);
        budget_go.setBounds(880, 530, 80, 40);

        budget_clear.setBackground(new java.awt.Color(161, 198, 210));
        budget_clear.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        budget_clear.setText("Clear");
        budget_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                budget_clearActionPerformed(evt);
            }
        });
        budget_Tpane.add(budget_clear);
        budget_clear.setBounds(780, 530, 80, 40);

        E_tabbedpane.addTab("Budget", new javax.swing.ImageIcon(getClass().getResource("/icons/tabcoins.png")), budget_Tpane); // NOI18N

        sales_Tpane.setBackground(new java.awt.Color(32, 47, 90));
        sales_Tpane.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sales_Tpane.setLayout(null);

        panel2.setBackground(new java.awt.Color(32, 47, 90));
        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sales Information", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 24), new java.awt.Color(204, 204, 204))); // NOI18N
        panel2.setLayout(null);

        entrylabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        entrylabel5.setForeground(new java.awt.Color(204, 204, 204));
        entrylabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        entrylabel5.setText("Name of the object :");
        panel2.add(entrylabel5);
        entrylabel5.setBounds(20, 60, 150, 40);

        entrylabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        entrylabel6.setForeground(new java.awt.Color(204, 204, 204));
        entrylabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        entrylabel6.setText("Sale Price :");
        panel2.add(entrylabel6);
        entrylabel6.setBounds(530, 60, 110, 40);

        entrylabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        entrylabel7.setForeground(new java.awt.Color(204, 204, 204));
        entrylabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        entrylabel7.setText("Buyer :");
        panel2.add(entrylabel7);
        entrylabel7.setBounds(70, 180, 100, 40);

        sale_price.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        sale_price.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panel2.add(sale_price);
        sale_price.setBounds(650, 60, 260, 40);

        sale_profit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        sale_profit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panel2.add(sale_profit);
        sale_profit.setBounds(650, 120, 260, 40);

        total_sales.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        total_sales.setForeground(new java.awt.Color(204, 204, 204));
        total_sales.setText("Total Sales : ");
        panel2.add(total_sales);
        total_sales.setBounds(570, 260, 360, 30);
        panel2.add(sale_name);
        sale_name.setBounds(190, 60, 260, 40);

        entrylabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        entrylabel8.setForeground(new java.awt.Color(204, 204, 204));
        entrylabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        entrylabel8.setText("Profit :");
        panel2.add(entrylabel8);
        entrylabel8.setBounds(540, 120, 100, 40);

        sale_qt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        panel2.add(sale_qt);
        sale_qt.setBounds(190, 120, 260, 40);

        enlabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        enlabel9.setForeground(new java.awt.Color(204, 204, 204));
        enlabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        enlabel9.setText("Transaction ID :");
        panel2.add(enlabel9);
        enlabel9.setBounds(530, 180, 110, 40);
        panel2.add(sell_id);
        sell_id.setBounds(650, 180, 260, 40);
        panel2.add(sale_buyer);
        sale_buyer.setBounds(190, 180, 260, 40);

        enlabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        enlabel10.setForeground(new java.awt.Color(204, 204, 204));
        enlabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        enlabel10.setText("Quantity :");
        panel2.add(enlabel10);
        enlabel10.setBounds(70, 120, 100, 40);

        sales_Tpane.add(panel2);
        panel2.setBounds(20, 10, 950, 300);

        entrylabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        entrylabel18.setForeground(new java.awt.Color(204, 204, 204));
        entrylabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        entrylabel18.setText("Write down any necessary Report");
        sales_Tpane.add(entrylabel18);
        entrylabel18.setBounds(310, 328, 380, 22);

        sale_go.setBackground(new java.awt.Color(161, 198, 210));
        sale_go.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        sale_go.setText("ADD");
        sale_go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_goActionPerformed(evt);
            }
        });
        sales_Tpane.add(sale_go);
        sale_go.setBounds(890, 580, 80, 40);

        sale_clear.setBackground(new java.awt.Color(161, 198, 210));
        sale_clear.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        sale_clear.setText("Clear");
        sale_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_clearActionPerformed(evt);
            }
        });
        sales_Tpane.add(sale_clear);
        sale_clear.setBounds(790, 580, 80, 40);

        scrollpane9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        scrollpane9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        salereport.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        salereport.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        salereport.setToolTipText("please! give your report nice format");
        salereport.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        scrollpane9.setViewportView(salereport);

        sales_Tpane.add(scrollpane9);
        scrollpane9.setBounds(20, 360, 950, 210);

        E_tabbedpane.addTab("Sales Report", new javax.swing.ImageIcon(getClass().getResource("/icons/tabsales.png")), sales_Tpane); // NOI18N

        buy_Tpane.setBackground(new java.awt.Color(32, 47, 90));
        buy_Tpane.setLayout(null);

        panel3.setBackground(new java.awt.Color(32, 47, 90));
        panel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Purchasing Information", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 24), new java.awt.Color(204, 204, 204))); // NOI18N
        panel3.setLayout(null);

        label3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label3.setForeground(new java.awt.Color(204, 204, 204));
        label3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label3.setText("Name of the object :");
        panel3.add(label3);
        label3.setBounds(30, 50, 150, 40);

        label4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label4.setForeground(new java.awt.Color(204, 204, 204));
        label4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label4.setText("Purchasing Price :");
        panel3.add(label4);
        label4.setBounds(490, 50, 130, 40);

        label5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label5.setForeground(new java.awt.Color(204, 204, 204));
        label5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label5.setText("Seller :");
        panel3.add(label5);
        label5.setBounds(70, 190, 110, 40);

        buy_price.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        buy_price.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panel3.add(buy_price);
        buy_price.setBounds(630, 50, 260, 40);

        total_purchase.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        total_purchase.setForeground(new java.awt.Color(204, 204, 204));
        total_purchase.setText("Total Purchases : ");
        panel3.add(total_purchase);
        total_purchase.setBounds(520, 250, 380, 40);
        panel3.add(buy_name);
        buy_name.setBounds(200, 50, 260, 40);

        enlabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        enlabel11.setForeground(new java.awt.Color(204, 204, 204));
        enlabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        enlabel11.setText("Transaction ID :");
        panel3.add(enlabel11);
        enlabel11.setBounds(510, 120, 110, 40);

        buy_qt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        panel3.add(buy_qt);
        buy_qt.setBounds(200, 120, 260, 40);

        enlabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        enlabel12.setForeground(new java.awt.Color(204, 204, 204));
        enlabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        enlabel12.setText("Quantity :");
        panel3.add(enlabel12);
        enlabel12.setBounds(70, 120, 110, 40);
        panel3.add(buy_seller);
        buy_seller.setBounds(200, 190, 260, 40);
        panel3.add(buy_id);
        buy_id.setBounds(630, 120, 260, 40);

        buy_Tpane.add(panel3);
        panel3.setBounds(20, 10, 950, 300);

        entrylabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        entrylabel17.setForeground(new java.awt.Color(204, 204, 204));
        entrylabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        entrylabel17.setText("Write down any necessary Report");
        buy_Tpane.add(entrylabel17);
        entrylabel17.setBounds(260, 320, 380, 20);

        pur_go.setBackground(new java.awt.Color(161, 198, 210));
        pur_go.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        pur_go.setText("ADD");
        pur_go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pur_goActionPerformed(evt);
            }
        });
        buy_Tpane.add(pur_go);
        pur_go.setBounds(890, 580, 80, 40);

        pur_clear.setBackground(new java.awt.Color(161, 198, 210));
        pur_clear.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        pur_clear.setText("Clear");
        pur_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pur_clearActionPerformed(evt);
            }
        });
        buy_Tpane.add(pur_clear);
        pur_clear.setBounds(790, 580, 80, 40);

        scrollpane6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        scrollpane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        purchase_report.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        purchase_report.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        purchase_report.setToolTipText("please! give your report nice format");
        purchase_report.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        scrollpane6.setViewportView(purchase_report);

        buy_Tpane.add(scrollpane6);
        scrollpane6.setBounds(10, 350, 960, 220);

        E_tabbedpane.addTab("Purchasing Report", new javax.swing.ImageIcon(getClass().getResource("/icons/tabbuy.png")), buy_Tpane); // NOI18N

        Emp_Tpane.setBackground(new java.awt.Color(32, 47, 90));
        Emp_Tpane.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Emp_Tpane.setLayout(null);

        panel4.setBackground(new java.awt.Color(32, 47, 90));
        panel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Insert Profile", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 24), new java.awt.Color(204, 204, 204))); // NOI18N
        panel4.setLayout(null);

        entrylabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        entrylabel9.setForeground(new java.awt.Color(204, 204, 204));
        entrylabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        entrylabel9.setText("Salary :");
        panel4.add(entrylabel9);
        entrylabel9.setBounds(500, 170, 100, 40);

        entrylabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        entrylabel10.setForeground(new java.awt.Color(204, 204, 204));
        entrylabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        entrylabel10.setText("Sex :");
        panel4.add(entrylabel10);
        entrylabel10.setBounds(10, 110, 120, 30);

        entrylabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        entrylabel11.setForeground(new java.awt.Color(204, 204, 204));
        entrylabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        entrylabel11.setText("Work Field :");
        panel4.add(entrylabel11);
        entrylabel11.setBounds(490, 240, 110, 40);

        emp_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panel4.add(emp_name);
        emp_name.setBounds(160, 40, 260, 40);

        entrylabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        entrylabel12.setForeground(new java.awt.Color(204, 204, 204));
        entrylabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        entrylabel12.setText("Address :");
        panel4.add(entrylabel12);
        entrylabel12.setBounds(20, 170, 110, 40);

        emp_age.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        emp_age.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panel4.add(emp_age);
        emp_age.setBounds(160, 240, 70, 40);

        enlabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        enlabel13.setForeground(new java.awt.Color(204, 204, 204));
        enlabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        enlabel13.setText("Age :");
        panel4.add(enlabel13);
        enlabel13.setBounds(20, 240, 110, 40);

        emp_job.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panel4.add(emp_job);
        emp_job.setBounds(620, 240, 250, 40);

        femal_radio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        femal_radio.setForeground(new java.awt.Color(204, 204, 204));
        femal_radio.setText("Female ");
        panel4.add(femal_radio);
        femal_radio.setBounds(280, 110, 80, 30);

        male_radio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        male_radio.setForeground(new java.awt.Color(204, 204, 204));
        male_radio.setText("Male");
        panel4.add(male_radio);
        male_radio.setBounds(160, 110, 70, 30);

        emp_address.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panel4.add(emp_address);
        emp_address.setBounds(160, 170, 260, 40);

        entrylabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        entrylabel13.setForeground(new java.awt.Color(204, 204, 204));
        entrylabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        entrylabel13.setText("Full Name :");
        panel4.add(entrylabel13);
        entrylabel13.setBounds(10, 40, 120, 40);

        entrylabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        entrylabel14.setForeground(new java.awt.Color(204, 204, 204));
        entrylabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        entrylabel14.setText("Date of Admission :");
        panel4.add(entrylabel14);
        entrylabel14.setBounds(470, 40, 130, 40);

        entrylabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        entrylabel15.setForeground(new java.awt.Color(204, 204, 204));
        entrylabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        entrylabel15.setText("Phone No :");
        panel4.add(entrylabel15);
        entrylabel15.setBounds(510, 100, 90, 40);

        try {
            emp_phone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        emp_phone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panel4.add(emp_phone);
        emp_phone.setBounds(620, 100, 250, 40);

        emp_salary.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#bir##,##0.00"))));
        emp_salary.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panel4.add(emp_salary);
        emp_salary.setBounds(620, 170, 250, 40);

        DOA.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        DOA.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        panel4.add(DOA);
        DOA.setBounds(620, 40, 250, 40);

        total_employee.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        total_employee.setForeground(new java.awt.Color(204, 204, 204));
        total_employee.setText("Total Employees : ");
        panel4.add(total_employee);
        total_employee.setBounds(520, 300, 420, 40);

        Emp_Tpane.add(panel4);
        panel4.setBounds(10, 10, 950, 350);

        scrollpane5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        scrollpane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        emp_report.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        emp_report.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        emp_report.setToolTipText("please! give your report nice format");
        emp_report.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        scrollpane5.setViewportView(emp_report);

        Emp_Tpane.add(scrollpane5);
        scrollpane5.setBounds(10, 400, 960, 170);

        entrylabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        entrylabel16.setForeground(new java.awt.Color(204, 204, 204));
        entrylabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        entrylabel16.setText("Write down any necessary Information");
        Emp_Tpane.add(entrylabel16);
        entrylabel16.setBounds(310, 360, 360, 30);

        emp_go.setBackground(new java.awt.Color(161, 198, 210));
        emp_go.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        emp_go.setText("ADD");
        emp_go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_goActionPerformed(evt);
            }
        });
        Emp_Tpane.add(emp_go);
        emp_go.setBounds(890, 580, 80, 40);

        emp_clear.setBackground(new java.awt.Color(161, 198, 210));
        emp_clear.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        emp_clear.setText("Clear");
        emp_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_clearActionPerformed(evt);
            }
        });
        Emp_Tpane.add(emp_clear);
        emp_clear.setBounds(780, 580, 80, 40);

        E_tabbedpane.addTab("New Employee", new javax.swing.ImageIcon(getClass().getResource("/icons/Empprofile.png")), Emp_Tpane); // NOI18N

        insert_Tpane.add(E_tabbedpane);
        E_tabbedpane.setBounds(0, 10, 990, 680);

        mainWorkspace.add(insert_Tpane);
        insert_Tpane.setBounds(120, 0, 990, 690);

        display_Tpane.setBackground(new java.awt.Color(32, 47, 90));
        display_Tpane.setLayout(null);

        tabbedPane.setBackground(new java.awt.Color(106, 116, 145));
        tabbedPane.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tabbedPane.setName(""); // NOI18N
        tabbedPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbedPaneMouseClicked(evt);
            }
        });

        disp_sTpane.setBackground(new java.awt.Color(32, 47, 90));
        disp_sTpane.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        disp_sTpane.setLayout(null);

        sale_tabel.setBackground(new java.awt.Color(32, 47, 90));
        sale_tabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sale_tabel.setForeground(new java.awt.Color(255, 255, 255));
        sale_tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", "", null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Product", "Quantitiy", "Price", "Buyer", "Profit", "Total profit", "Date", "Branch", "TransactionID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sale_tabel.setColumnSelectionAllowed(true);
        sale_tabel.setGridColor(new java.awt.Color(255, 255, 255));
        sale_tabel.setIntercellSpacing(new java.awt.Dimension(2, 5));
        sale_tabel.setRowHeight(20);
        sale_tabel.setShowHorizontalLines(false);
        sale_tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sale_tabelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(sale_tabel);
        sale_tabel.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        disp_sTpane.add(jScrollPane2);
        jScrollPane2.setBounds(0, 0, 980, 300);

        tabbedPane.addTab("Sales", new javax.swing.ImageIcon(getClass().getResource("/icons/tabsales.png")), disp_sTpane); // NOI18N

        disp_pTpane.setBackground(new java.awt.Color(32, 47, 90));
        disp_pTpane.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        disp_pTpane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disp_pTpaneMouseClicked(evt);
            }
        });
        disp_pTpane.setLayout(null);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        purchase_tabel.setBackground(new java.awt.Color(32, 47, 90));
        purchase_tabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        purchase_tabel.setForeground(new java.awt.Color(255, 255, 255));
        purchase_tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Product", "Quantitiy", "Price", "Seller", "Branch", "Date", "TransactionID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        purchase_tabel.setColumnSelectionAllowed(true);
        purchase_tabel.setGridColor(new java.awt.Color(213, 255, 255));
        purchase_tabel.setRowHeight(20);
        purchase_tabel.setRowMargin(5);
        purchase_tabel.setShowHorizontalLines(false);
        purchase_tabel.getTableHeader().setReorderingAllowed(false);
        purchase_tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                purchase_tabelMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(purchase_tabel);
        purchase_tabel.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        disp_pTpane.add(jScrollPane3);
        jScrollPane3.setBounds(0, 0, 980, 370);

        tabbedPane.addTab("Purchase", new javax.swing.ImageIcon(getClass().getResource("/icons/tabbuy.png")), disp_pTpane); // NOI18N

        disp_eTpane.setBackground(new java.awt.Color(32, 47, 90));
        disp_eTpane.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        disp_eTpane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disp_eTpaneMouseClicked(evt);
            }
        });
        disp_eTpane.setLayout(null);

        emp_tabel.setBackground(new java.awt.Color(32, 47, 90));
        emp_tabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emp_tabel.setForeground(new java.awt.Color(255, 255, 255));
        emp_tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Sex", "Address", "Age", "DOA", "Phone", "Salary", "WorkField"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        emp_tabel.setColumnSelectionAllowed(true);
        emp_tabel.setGridColor(new java.awt.Color(213, 255, 255));
        emp_tabel.setRowHeight(20);
        emp_tabel.setRowMargin(5);
        emp_tabel.setShowHorizontalLines(false);
        emp_tabel.getTableHeader().setReorderingAllowed(false);
        emp_tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emp_tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(emp_tabel);
        emp_tabel.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        disp_eTpane.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 980, 370);

        tabbedPane.addTab("My Employees", new javax.swing.ImageIcon(getClass().getResource("/icons/Empprofile.png")), disp_eTpane); // NOI18N

        display_Tpane.add(tabbedPane);
        tabbedPane.setBounds(10, 10, 980, 340);

        tabbedpane2.setBackground(new java.awt.Color(32, 47, 90));
        tabbedpane2.setToolTipText("Click a row to diplay a report");
        tabbedpane2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        searchtab2.setBackground(new java.awt.Color(32, 47, 90));
        searchtab2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        searchtab2.setLayout(null);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Search BY . . .");
        searchtab2.add(jLabel7);
        jLabel7.setBounds(20, 10, 110, 30);

        idradio.setBackground(new java.awt.Color(32, 47, 90));
        idradio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idradio.setForeground(new java.awt.Color(255, 255, 255));
        idradio.setSelected(true);
        idradio.setText("ID");
        idradio.setIconTextGap(6);
        searchtab2.add(idradio);
        idradio.setBounds(140, 20, 60, 25);

        nameradio.setBackground(new java.awt.Color(32, 47, 90));
        nameradio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameradio.setForeground(new java.awt.Color(255, 255, 255));
        nameradio.setSelected(true);
        nameradio.setText("Name");
        nameradio.setIconTextGap(6);
        searchtab2.add(nameradio);
        nameradio.setBounds(210, 20, 80, 25);

        dateradio.setBackground(new java.awt.Color(32, 47, 90));
        dateradio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dateradio.setForeground(new java.awt.Color(255, 255, 255));
        dateradio.setSelected(true);
        dateradio.setText("Date (yyyy-mm-dd)");
        dateradio.setIconTextGap(6);
        searchtab2.add(dateradio);
        dateradio.setBounds(300, 20, 180, 25);

        priceradio.setBackground(new java.awt.Color(32, 47, 90));
        priceradio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        priceradio.setForeground(new java.awt.Color(255, 255, 255));
        priceradio.setSelected(true);
        priceradio.setText("Price");
        priceradio.setIconTextGap(6);
        searchtab2.add(priceradio);
        priceradio.setBounds(490, 20, 70, 25);

        search_input.setBackground(new java.awt.Color(32, 47, 90));
        search_input.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        search_input.setForeground(new java.awt.Color(204, 255, 255));
        search_input.setBorder(null);
        search_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_inputActionPerformed(evt);
            }
        });
        searchtab2.add(search_input);
        search_input.setBounds(160, 60, 430, 30);
        searchtab2.add(jSeparator2);
        jSeparator2.setBounds(160, 90, 430, 10);

        disp_search.setBackground(new java.awt.Color(153, 153, 153));
        disp_search.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        disp_search.setForeground(new java.awt.Color(255, 255, 255));
        disp_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        disp_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disp_searchActionPerformed(evt);
            }
        });
        searchtab2.add(disp_search);
        disp_search.setBounds(610, 40, 60, 50);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Keyword ->");
        searchtab2.add(jLabel9);
        jLabel9.setBounds(50, 60, 90, 40);

        rowIndicator.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        rowIndicator.setForeground(new java.awt.Color(204, 255, 255));
        rowIndicator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Info_1.png"))); // NOI18N
        rowIndicator.setText("Edit the data on the above table and hit refresh to update the data");
        searchtab2.add(rowIndicator);
        rowIndicator.setBounds(30, 140, 520, 30);

        tabbedpane2.addTab("Search", searchtab2);

        tabbb.setBackground(new java.awt.Color(32, 47, 90));

        scrollpane4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        scrollpane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        report_display.setBackground(new java.awt.Color(32, 47, 90));
        report_display.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        report_display.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        report_display.setToolTipText("please! give your report nice format");
        report_display.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        scrollpane4.setViewportView(report_display);

        updateReport.setBackground(new java.awt.Color(204, 255, 204));
        updateReport.setText("Update Report");
        updateReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabbbLayout = new javax.swing.GroupLayout(tabbb);
        tabbb.setLayout(tabbbLayout);
        tabbbLayout.setHorizontalGroup(
            tabbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollpane4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabbbLayout.createSequentialGroup()
                .addContainerGap(848, Short.MAX_VALUE)
                .addComponent(updateReport, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        tabbbLayout.setVerticalGroup(
            tabbbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabbbLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollpane4, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateReport)
                .addGap(7, 7, 7))
        );

        tabbedpane2.addTab("Report", tabbb);

        display_Tpane.add(tabbedpane2);
        tabbedpane2.setBounds(10, 420, 980, 260);

        deletebut.setBackground(new java.awt.Color(255, 153, 153));
        deletebut.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deletebut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash.png"))); // NOI18N
        deletebut.setText("Delete");
        deletebut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebutActionPerformed(evt);
            }
        });
        display_Tpane.add(deletebut);
        deletebut.setBounds(850, 360, 140, 50);

        disp_refresh.setBackground(new java.awt.Color(204, 204, 255));
        disp_refresh.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        disp_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/RefreshSmall.png"))); // NOI18N
        disp_refresh.setText("Update");
        disp_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disp_refreshActionPerformed(evt);
            }
        });
        display_Tpane.add(disp_refresh);
        disp_refresh.setBounds(710, 360, 130, 50);

        mainWorkspace.add(display_Tpane);
        display_Tpane.setBounds(120, 0, 990, 690);

        menuicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Double Right.png"))); // NOI18N
        menuicon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuicon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuiconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuiconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuiconMouseExited(evt);
            }
        });
        mainWorkspace.add(menuicon);
        menuicon.setBounds(10, 10, 50, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainWorkspace, javax.swing.GroupLayout.PREFERRED_SIZE, 1116, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainWorkspace, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
//set the server object for the current running frame   

    public static void setServer(RemoteServerInterface server) {
        FrameUI.server = server;
        statInstance = new Statistics(server);
    }
//register new client on the server   

    public void activateClient() {
        try {
            server.addActiveUser(DialogFrame.logindialog.getUserId());
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Remote Connect Error", JOptionPane.ERROR_MESSAGE);
        } 
    }

//empty input checker    
    public boolean hasEmpty(ArrayList<JTextComponent> components) {
        for (JTextComponent c : components) {
            if (c.getText().isEmpty()) {
                return true;
            }
        }
        return false;
    }

//init chat box
    private void initChatbox() {
        chatbox = new JDialog(new JFrame(), "Chat", false);
        chatbox.setIconImage(new ImageIcon(getClass().getResource("/icons/Chat.png")).getImage());
        JFXPanel jfxpanel = new JFXPanel();
        chatbox.add(jfxpanel);
        chatbox.setSize(900, 730);
        chatbox.setResizable(false);
        chatbox.setLocationRelativeTo(null);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                chatclass.initComponents(jfxpanel);
            }
        });

    }

    //init radios
    private void initRadios() {
        group1 = new ButtonGroup();
        group1.add(male_radio);
        group1.add(femal_radio);
        group2 = new ButtonGroup();
        group2.add(idradio);
        group2.add(nameradio);
        group2.add(dateradio);
        group2.add(priceradio);

    }

//hidden items at the start
    private void hiddenComponents() {
        menuLayer.setVisible(false);
    }
//container visibility modifier    

    private void hideContainer(boolean bool, String key) {
        switch (key) {
            case "entry":
                insert_Tpane.setVisible(!bool);
                break;
            case "home":
                Systempanel.setVisible(!bool);
                stat_panel.setVisible(!bool);
                homepan1.setVisible(!bool);
                break;
            case "display":
                display_Tpane.setVisible(!bool);
            default:
                break;

        }
    }
//drawer button        
    private void menuicon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuicon1MouseClicked
        hiddenComponents();
        hideContainer(false, "home");
        hideContainer(true, "entry");
        hideContainer(true, "display");
    }//GEN-LAST:event_menuicon1MouseClicked

    private void menuicon1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuicon1MouseEntered
        menuicon1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.WHITE, Color.PINK));
    }//GEN-LAST:event_menuicon1MouseEntered

    private void menuicon1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuicon1MouseExited
        menuicon1.setBorder(BorderFactory.createEmptyBorder());
    }//GEN-LAST:event_menuicon1MouseExited
    
    private void filler(){
       try {
            TableFiller.fillSaleTable(sale_tabel, server, "1");
            TableFiller.fillBuyTable(purchase_tabel, server, "1");
            TableFiller.fillEmployeeTable(emp_tabel, server, "1");
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Remote Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }

//diplay tab handlers
    private void displaytabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displaytabMouseClicked
        hideContainer(true, "home");
        hideContainer(true, "entry");
        hideContainer(false, "display");
        filler();
    }//GEN-LAST:event_displaytabMouseClicked

    private void displaytabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displaytabMouseEntered
        displaytab.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
    }//GEN-LAST:event_displaytabMouseEntered

    private void displaytabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displaytabMouseExited
        displaytab.setBorder(null);
    }//GEN-LAST:event_displaytabMouseExited
//add tab handlers
    private void addtabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addtabMouseClicked
        hideContainer(true, "home");
        hideContainer(true, "display");
        hideContainer(false, "entry");
        DialogFrame.logindialog.setCounts();
    }//GEN-LAST:event_addtabMouseClicked

    private void addtabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addtabMouseEntered
        addtab.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
    }//GEN-LAST:event_addtabMouseEntered

    private void addtabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addtabMouseExited
        addtab.setBorder(null);
    }//GEN-LAST:event_addtabMouseExited
//drawer button1
    private void menuiconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuiconMouseClicked
        menuLayer.setVisible(true);
    }//GEN-LAST:event_menuiconMouseClicked

    private void menuiconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuiconMouseEntered
        menuicon.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.BLACK, Color.PINK));
    }//GEN-LAST:event_menuiconMouseEntered

    private void menuiconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuiconMouseExited
        menuicon.setBorder(BorderFactory.createEmptyBorder());
    }//GEN-LAST:event_menuiconMouseExited
//budget pan handlers
    private void BudgetPanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BudgetPanMouseClicked
        statInstance.budgetStatistics();
    }//GEN-LAST:event_BudgetPanMouseClicked

    private void BudgetPanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BudgetPanMouseEntered
        BudgetPan.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
    }//GEN-LAST:event_BudgetPanMouseEntered

    private void BudgetPanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BudgetPanMouseExited
        BudgetPan.setBorder(null);
    }//GEN-LAST:event_BudgetPanMouseExited
//buy pan handlers
    private void buyPanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyPanMouseClicked
        statInstance.buyStatistics();
    }//GEN-LAST:event_buyPanMouseClicked

    private void buyPanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyPanMouseEntered
        buyPan.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
    }//GEN-LAST:event_buyPanMouseEntered

    private void buyPanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyPanMouseExited
        buyPan.setBorder(null);
    }//GEN-LAST:event_buyPanMouseExited
//sell pan handlers
    private void sellPanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sellPanMouseClicked
        statInstance.saleStatistics();
    }//GEN-LAST:event_sellPanMouseClicked

    private void sellPanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sellPanMouseEntered
        sellPan.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
    }//GEN-LAST:event_sellPanMouseEntered

    private void sellPanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sellPanMouseExited
        sellPan.setBorder(null);
    }//GEN-LAST:event_sellPanMouseExited
//chat tab handlers
    private void chat_tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chat_tabMouseClicked
        if (!chatbox.isActive()) {
            ChatRoom.server = server;
            activateClient();
            chatclass.startListening();
             Platform.runLater(new Runnable() {
                @Override
                public void run() {
                  chatclass.fillOnlineUsers();
                }
             });
            
            SwingUtilities.invokeLater(() -> {
                chatbox.setVisible(true);
            });

        }
    }//GEN-LAST:event_chat_tabMouseClicked

    private void chat_tabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chat_tabMouseEntered
        chat_tab.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
    }//GEN-LAST:event_chat_tabMouseEntered

    private void chat_tabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chat_tabMouseExited
        chat_tab.setBorder(null);
    }//GEN-LAST:event_chat_tabMouseExited
//logout tab handlers
    private void logout_tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_tabMouseClicked
        DialogFrame.logindialog.setVisible(true);
        this.setVisible(false);
        try {
            if (ChatRoom.timer != null) {
                if (ChatRoom.timer.isRunning()) {
                    ChatRoom.timer.stop();
                    ChatRoom.timer2.stop();
                }
            }
             Platform.runLater(new Runnable() {
                @Override
                public void run() {
                  chatclass.clearChatArea();
                }
             });
            server.removeActiveUser(DialogFrame.logindialog.getUserId());
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Remote Log out error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_logout_tabMouseClicked

    private void logout_tabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_tabMouseEntered
        logout_tab.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
    }//GEN-LAST:event_logout_tabMouseEntered

    private void logout_tabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_tabMouseExited
        logout_tab.setBorder(null);
    }//GEN-LAST:event_logout_tabMouseExited
//budget tab buttons
    private void budget_goActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_budget_goActionPerformed
        textFileds = new ArrayList<>();
        textFileds.add(b_field);
        textFileds.add(bdate_field);
        textFileds.add(fund_field);
        if (!hasEmpty(textFileds)) {
            query = "INSERT INTO budget values(0," + b_field.getText().replaceAll(",", "") + "," + fund_field.getText().replaceAll(",", "") + ",'"
                    + bdate_field.getText() + "','" + DialogFrame.logindialog.getBranch() + "')";
            try {
                server.insertToDb(query);
                
                ImageIcon icon = new ImageIcon(getClass().getResource("/icons/success.png"));
                JOptionPane.showMessageDialog(this, "Insertion Succeed !!", "Success", JOptionPane.PLAIN_MESSAGE,icon);
                budget_clear.doClick();

            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Remote Insertion Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Remote SQL Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "You have to fill all the field", "Empty Input", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_budget_goActionPerformed

    private void budget_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_budget_clearActionPerformed
        b_field.setText("");
        bdate_field.setText("");
        fund_field.setText("");
    }//GEN-LAST:event_budget_clearActionPerformed
//sell tab buttons
    private void sale_goActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_goActionPerformed
        textFileds = new ArrayList<>();
        textFileds.add(sale_name);
        textFileds.add(sale_qt);
        textFileds.add(sale_buyer);
        textFileds.add(sale_price);
        textFileds.add(sale_profit);
        textFileds.add(sell_id);
        if (!hasEmpty(textFileds)) {
            if(Validator.isAlpha(sale_name.getText()) && Validator.isAlpha(sale_buyer.getText())){
                Date date = new Date(new java.util.Date().getTime());
                int qt = Integer.parseInt(sale_qt.getText().replaceAll(",", ""));
                double price = Double.parseDouble(sale_price.getText().replaceAll(",", ""));
                double profit = Double.parseDouble(sale_profit.getText().replaceAll(",", ""));
                String totalPrice = String.valueOf((qt * price));
                String totalProfit = String.valueOf((qt * profit));
                query = "INSERT INTO sales values('" + sell_id.getText() + "','" + sale_name.getText() + "'," + sale_qt.getText().replaceAll(",", "") + ","
                        + sale_price.getText().replaceAll(",", "") + "," + totalPrice + ",'" + sale_buyer.getText() + "','" + DialogFrame.logindialog.getBranch() + "',"
                        + sale_profit.getText().replaceAll(",", "") + "," + totalProfit + ",'" + date + "','" + salereport.getText() + "')";
                try {
                    server.insertToDb(query);
                    ImageIcon icon = new ImageIcon(getClass().getResource("/icons/success.png"));
                    JOptionPane.showMessageDialog(this, "Insertion Succeed !!", "Success", JOptionPane.PLAIN_MESSAGE,icon);
                    sale_clear.doClick();

                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Insertion Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Remote SQL Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
               JOptionPane.showMessageDialog(this, "Names must be alphabetic characters", "Naming Error", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "You have to fill all the field", "Empty Input", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_sale_goActionPerformed

    private void sale_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_clearActionPerformed
        sale_name.setText("");
        sale_qt.setText("");
        sale_buyer.setText("");
        sale_price.setText("");
        sale_profit.setText("");
        sell_id.setText("");
        salereport.setText("");
    }//GEN-LAST:event_sale_clearActionPerformed
//purchase tab buttons
    private void pur_goActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pur_goActionPerformed
        textFileds = new ArrayList<>();
        textFileds.add(buy_name);
        textFileds.add(buy_qt);
        textFileds.add(buy_seller);
        textFileds.add(buy_price);
        textFileds.add(buy_id);
        if (!hasEmpty(textFileds)) {
            if(Validator.isAlpha(buy_name.getText()) && Validator.isAlpha(buy_seller.getText())){
                Date date = new Date(new java.util.Date().getTime());
                int qt = Integer.parseInt(buy_qt.getText().replaceAll(",", ""));
                double price = Double.parseDouble(buy_price.getText().replaceAll(",", ""));
                String totalPrice = String.valueOf((qt * price));
                query = "INSERT INTO buy values('" + buy_name.getText() + "'," + buy_qt.getText().replaceAll(",", "") + "," + buy_price.getText().replaceAll(",", "") + ","
                        + totalPrice + ",'" + buy_seller.getText() + "','" + DialogFrame.logindialog.getBranch() + "','" + date + "','" + purchase_report.getText() + "','" + buy_id.getText() + "')";
                try {
                    server.insertToDb(query);
                    ImageIcon icon = new ImageIcon(getClass().getResource("/icons/success.png"));
                    JOptionPane.showMessageDialog(this, "Insertion Succeed !!", "Success", JOptionPane.PLAIN_MESSAGE,icon);
                    pur_clear.doClick();

                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Insertion Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Remote SQL Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
               JOptionPane.showMessageDialog(this, "Names must be alphabetic characters", "Naming Error", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "You have to fill all the field", "Empty Input", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_pur_goActionPerformed

    private void pur_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pur_clearActionPerformed
        buy_name.setText("");
        buy_qt.setText("");
        buy_seller.setText("");
        buy_price.setText("");
        buy_id.setText("");
        purchase_report.setText("");
    }//GEN-LAST:event_pur_clearActionPerformed
//employee tab buttons
    private void emp_goActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_goActionPerformed
        textFileds = new ArrayList<>();
        textFileds.add(emp_name);
        textFileds.add(emp_address);
        textFileds.add(emp_age);
        textFileds.add(emp_salary);
        textFileds.add(emp_job);
        textFileds.add(DOA);
        String sex = "Male";
        if (femal_radio.isSelected()) {
            sex = "Female";
        }
        if (!hasEmpty(textFileds) && !emp_phone.getText().equals("-")) {
             if(Validator.isAlpha(emp_name.getText()) && Validator.isAlpha(emp_job.getText())){
               query = "INSERT INTO employee values('0','" + emp_name.getText() + "','" + sex + "','" + emp_address.getText() + "'," + emp_age.getText() + ",'"
                    + DOA.getText() + "','" + emp_phone.getText() + "'," + emp_salary.getText().replaceAll(",", "") + ",'"
                    + emp_job.getText() + "','" + emp_report.getText() + "','" + DialogFrame.logindialog.getBranch() + "')";
                try {
                    server.insertToDb(query);
                    ImageIcon icon = new ImageIcon(getClass().getResource("/icons/success.png"));
                    JOptionPane.showMessageDialog(this, "Insertion Succeed !!", "Success", JOptionPane.PLAIN_MESSAGE,icon);
                    emp_clear.doClick();

                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Insertion Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Remote SQL Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
               JOptionPane.showMessageDialog(null, "Names must be alphabetic characters", "Naming Error", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "You have to fill all the field", "Empty Input", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_emp_goActionPerformed

    private void emp_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_clearActionPerformed
        emp_name.setText("");
        male_radio.setSelected(true);
        emp_address.setText("");
        emp_age.setText("");
        emp_phone.setText("");
        emp_salary.setText("");
        emp_job.setText("");
        DOA.setText("");
    }//GEN-LAST:event_emp_clearActionPerformed
//report retreival 
    private void sale_tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sale_tabelMouseClicked
        int selectedRow = sale_tabel.getSelectedRow();
        if (getDataCount("sales", DialogFrame.logindialog.getBranch()) > 0) {
            rowIndicator.setText("Selected Item-> " + sale_tabel.getModel().getValueAt(selectedRow, 0).toString());
            String transID = sale_tabel.getModel().getValueAt(selectedRow, 8).toString();
            query = "SELECT Report from sales WHERE TransactionID='" + transID + "'";
            try {
                map = server.selectFromDb(query);
                if (!map.isEmpty()) {
                    report_display.setText(map.get(0).get("Report").toString());
                }
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Remote Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Remote SQL Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_sale_tabelMouseClicked

    private void emp_tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emp_tabelMouseClicked
        int selectedRow = emp_tabel.getSelectedRow();
        if (getDataCount("employee", DialogFrame.logindialog.getBranch()) > 0) {
            rowIndicator.setText("Selected Person -> "+ emp_tabel.getModel().getValueAt(selectedRow, 1).toString());
            query = "SELECT Report FROM employee WHERE ID='" + emp_tabel.getModel().getValueAt(selectedRow, 0).toString() +"'";
            try {
                map = server.selectFromDb(query);
                if (!map.isEmpty()) {
                    report_display.setText(map.get(0).get("Report").toString());
                }
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Remote Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Remote SQL Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_emp_tabelMouseClicked

    private void purchase_tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchase_tabelMouseClicked
        int selectedRow = purchase_tabel.getSelectedRow(); 
        if (getDataCount("buy", DialogFrame.logindialog.getBranch()) > 0) {
            rowIndicator.setText("Selected Item-> " + purchase_tabel.getModel().getValueAt(selectedRow, 0).toString());
            String transID = purchase_tabel.getModel().getValueAt(selectedRow, 6).toString();
            query = "SELECT Report from buy WHERE TransactionID='" + transID + "'";
            try {
                map = server.selectFromDb(query);
                if (!map.isEmpty()) {
                    report_display.setText(map.get(0).get("Report").toString());
                }
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Remote Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Remote SQL Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_purchase_tabelMouseClicked
//search button handler
    private void disp_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disp_searchActionPerformed
        String where = "";
        if(!search_input.getText().trim().equals("")){
            try {
                if (disp_sTpane.isVisible()) {
                    if(getDataCount("sales", DialogFrame.logindialog.getBranch()) > 0){
                        if (idradio.isSelected()) {
                            where = "TransactionID='" + search_input.getText() + "'";
                        } else if (nameradio.isSelected()) {
                            where = "Name='" + search_input.getText() + "'";
                        } else if (dateradio.isSelected()) {
                            where = "Date='" + search_input.getText() + "'";
                        } else {
                            where = "Price=" + search_input.getText();
                        }
                        TableFiller.fillSaleTable(sale_tabel, server, where);
                    }else{
                      JOptionPane.showMessageDialog(this, "Empty Database! \nNO Data exists about sales of your branch yet", "Empty Data", JOptionPane.INFORMATION_MESSAGE);
                    } 
                } else if (disp_pTpane.isVisible()) {
                    if (getDataCount("buy", DialogFrame.logindialog.getBranch()) > 0) {
                        if (idradio.isSelected()) {
                            where = "TransactionID ='" + search_input.getText() + "'";
                        } else if (nameradio.isSelected()) {
                            where = "Name='" + search_input.getText() + "'";
                        } else if (dateradio.isSelected()) {
                            where = "Date='" + search_input.getText() + "'";
                        } else {
                            where = "Price=" + search_input.getText();
                        }
                        TableFiller.fillBuyTable(purchase_tabel, server, where);
                    }else{
                      JOptionPane.showMessageDialog(this, "Empty Database! \nNO Data exists about purchases of your branch yet", "Empty Data", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else if (disp_eTpane.isVisible()) {
                    if (getDataCount("employee", DialogFrame.logindialog.getBranch()) > 0) {
                        if (idradio.isSelected()) {
                            where = "ID =" + search_input.getText();
                        } else if (nameradio.isSelected()) {
                            where = "Name='" + search_input.getText() + "'";
                        } else if (priceradio.isSelected()) {
                            return;
                        } else {
                            where = "DOA='" + search_input.getText() + "'";
                        }
                        TableFiller.fillEmployeeTable(emp_tabel, server, where);
                    }else{
                      JOptionPane.showMessageDialog(this, "Empty Database! \nNO Data exists about employeess of your branch yet", "Empty Data", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            } catch (RemoteException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Remote Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
          JOptionPane.showMessageDialog(this, "You Have to provide some keyword to search a data", "Empty Key Word", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_disp_searchActionPerformed

    private void search_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_inputActionPerformed
        disp_search.doClick();
    }//GEN-LAST:event_search_inputActionPerformed

    private void tabbedPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedPaneMouseClicked
        if (disp_eTpane.isVisible()) {
            priceradio.setEnabled(false);
        } else {
            priceradio.setEnabled(true);
        }
        rowIndicator.setText("Edit the data on the above table and hit refresh to update the data");
    }//GEN-LAST:event_tabbedPaneMouseClicked
//update button handler
    private void disp_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disp_refreshActionPerformed
    int confirm;
        if (disp_sTpane.isVisible()) {
            if( getDataCount("sales", DialogFrame.logindialog.getBranch()) > 0){
               row = sale_tabel.getSelectedRow();
                if (sale_tabel.isEditing()) {
                    sale_tabel.getCellEditor().stopCellEditing();
                    confirm = JOptionPane.showConfirmDialog(null, "Are You sure to update this data ?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(confirm == JOptionPane.YES_OPTION){
                      if(TableFiller.updateSaleTable(sale_tabel, server, report_display.getText(), row)){
                        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/success.png"));
                        JOptionPane.showMessageDialog(this, "Updated Successfully!!", "Success", JOptionPane.PLAIN_MESSAGE,icon);
                      }else{
                        filler();
                      }  
                    }else{
                      filler();
                    }
                }
                
            }else{
                JOptionPane.showMessageDialog(this, "Empty Database! \nNO Data exists about sales of your branch yet", "Empty Data", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } else if (disp_pTpane.isVisible()) {
            if( getDataCount("buy", DialogFrame.logindialog.getBranch()) > 0){
              row = purchase_tabel.getSelectedRow();
                if (purchase_tabel.isEditing()) {
                    purchase_tabel.getCellEditor().stopCellEditing();
                    confirm = JOptionPane.showConfirmDialog(null, "Are You sure to update this data ?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(confirm == JOptionPane.YES_OPTION){
                      if(TableFiller.updateBuyTable(purchase_tabel, server, report_display.getText(), row)){
                       ImageIcon icon = new ImageIcon(getClass().getResource("/icons/success.png"));
                       JOptionPane.showMessageDialog(this, "Updated Successfully!!", "Success", JOptionPane.PLAIN_MESSAGE,icon);
                      }else{
                        filler();
                      }
                    }else{
                      filler();
                    }
                }
                
            }else{
              JOptionPane.showMessageDialog(this, "Empty Database! \nNO Data exists about purchase of your branch yet", "Empty Data", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } else if (disp_eTpane.isVisible()) {
            if( getDataCount("employee", DialogFrame.logindialog.getBranch()) > 0){
                row = emp_tabel.getSelectedRow();
                if (emp_tabel.isEditing()) {
                    emp_tabel.getCellEditor().stopCellEditing();
                    confirm = JOptionPane.showConfirmDialog(null, "Are You sure to update this data ?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(confirm == JOptionPane.YES_OPTION){
                      if(TableFiller.updateEmployeeTable(emp_tabel, server, report_display.getText(), row)){
                        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/success.png"));
                        JOptionPane.showMessageDialog(this, "Updated Successfully!!", "Success", JOptionPane.PLAIN_MESSAGE,icon);
                      }else{
                        filler();
                      }
                    }else{
                      filler();
                    }
                }
                
            }else{
              JOptionPane.showMessageDialog(this, "Empty Database! \nNO Data exists about employees of your branch yet", "Empty Data", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_disp_refreshActionPerformed
public int getDataCount(String tablename, String branch){
   int count = 0;
            try {
                count = server.getCounted(tablename,branch);
            } catch (RemoteException ex) {
               JOptionPane.showMessageDialog(this, ex.getMessage(), "Remote Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(this, ex.getMessage(), "Remote SQL Error", JOptionPane.ERROR_MESSAGE); 
            }
    return count;        
 }
//delete button handler
    private void deletebutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebutActionPerformed
        DefaultTableModel model;
        int confirm;
        if (disp_sTpane.isVisible()) {
            if( getDataCount("sales", DialogFrame.logindialog.getBranch()) > 0){
                row = sale_tabel.getSelectedRow();
                model = (DefaultTableModel) sale_tabel.getModel();
                if (row >= 0) {
                    confirm = JOptionPane.showConfirmDialog(null, "Are You sure to delete this data ?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(confirm == JOptionPane.YES_OPTION){
                        query = "DELETE FROM sales WHERE TransactionID='" + model.getValueAt(row, 8).toString() + "'";
                        try {
                            server.deleteFromDb(query);
                            model.removeRow(row);
                            sale_tabel.setModel(model);
                            ImageIcon icon = new ImageIcon(getClass().getResource("/icons/Ok.png"));
                            JOptionPane.showMessageDialog(this, "Deleted Successfully!!", "Success", JOptionPane.PLAIN_MESSAGE,icon);
                        } catch (RemoteException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Remote Error", JOptionPane.ERROR_MESSAGE);
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No row is selected", "Empty Selection", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
              JOptionPane.showMessageDialog(this, "Empty Database! \nNO Data exists about sales of your branch yet", "Empty Data", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } else if (disp_pTpane.isVisible()) {
            if( getDataCount("buy", DialogFrame.logindialog.getBranch()) > 0){
                row = purchase_tabel.getSelectedRow();
                model = (DefaultTableModel) purchase_tabel.getModel();
                if (row >= 0) {
                    confirm = JOptionPane.showConfirmDialog(null, "Are You sure to delete this data ?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(confirm == JOptionPane.YES_OPTION){
                        query = "DELETE FROM buy WHERE TransactionID='" + model.getValueAt(row, 6).toString() + "'";
                        try {
                            server.deleteFromDb(query);
                            model.removeRow(row);
                            purchase_tabel.setModel(model);
                            ImageIcon icon = new ImageIcon(getClass().getResource("/icons/success.png"));
                            JOptionPane.showMessageDialog(this, "Deleted Successfully!!", "Success", JOptionPane.PLAIN_MESSAGE,icon);
                        } catch (RemoteException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Remote Error", JOptionPane.ERROR_MESSAGE);
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No row is selected", "Empty Selection", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
              JOptionPane.showMessageDialog(this, "Empty Database! \nNO Data exists about purchases of your branch yet", "Empty Data", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (disp_eTpane.isVisible()) {
            if( getDataCount("employee", DialogFrame.logindialog.getBranch()) > 0){
                row = emp_tabel.getSelectedRow();
                model = (DefaultTableModel) emp_tabel.getModel();
                if (row >= 0) {
                    confirm = JOptionPane.showConfirmDialog(null, "Are You sure to delete this data ?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(confirm == JOptionPane.YES_OPTION){
                        query = "DELETE FROM employee WHERE ID=" + String.valueOf((row + 1));
                        try {
                            server.deleteFromDb(query);
                            model.removeRow(row);
                            emp_tabel.setModel(model);
                            ImageIcon icon = new ImageIcon(getClass().getResource("/icons/success.png"));
                            JOptionPane.showMessageDialog(this, "Deleted Successfully!!", "Success", JOptionPane.PLAIN_MESSAGE,icon);
                        } catch (RemoteException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Remote Error", JOptionPane.ERROR_MESSAGE);
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No row is selected", "Empty Selection", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
              JOptionPane.showMessageDialog(this, "Empty Database! \nNO Data exists about sales of your branch yet", "Empty Data", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_deletebutActionPerformed

    private void disp_pTpaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disp_pTpaneMouseClicked
        try {
            TableFiller.fillBuyTable(purchase_tabel, server, "1");
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Remote Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_disp_pTpaneMouseClicked

    private void disp_eTpaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disp_eTpaneMouseClicked
        try {
            TableFiller.fillEmployeeTable(emp_tabel, server, "1");
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Remote Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_disp_eTpaneMouseClicked

    private void updateReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateReportActionPerformed
        int confirm;
        if (disp_sTpane.isVisible()) {
            if( getDataCount("sales", DialogFrame.logindialog.getBranch()) > 0){
                row = sale_tabel.getSelectedRow();
                if(row >= 0){
                    confirm = JOptionPane.showConfirmDialog(null, "Are You sure to update this data ?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (confirm == JOptionPane.YES_OPTION) {
                        TableModel model = sale_tabel.getModel();
                        String query = "UPDATE sales SET Report='" + report_display.getText() +"' WHERE TransactionID='" + model.getValueAt(row, 8).toString() + "'";
                        try {
                            server.updateDb(query);
                            ImageIcon icon = new ImageIcon(getClass().getResource("/icons/success.png"));
                            JOptionPane.showMessageDialog(this, "Report Updated Successfully!!", "Success", JOptionPane.PLAIN_MESSAGE, icon);
                        }catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
                        } catch (RemoteException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Remote Error", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                }else{
                    JOptionPane.showMessageDialog(this, "You Have to Select A row first", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Empty Database! \nNO Data exists about sales of your branch yet", "Empty Data", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (disp_pTpane.isVisible()) {
            if( getDataCount("buy", DialogFrame.logindialog.getBranch()) > 0){
                row = purchase_tabel.getSelectedRow();
                if(row >= 0){
                    confirm = JOptionPane.showConfirmDialog(null, "Are You sure to update this data ?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (confirm == JOptionPane.YES_OPTION) {
                        TableModel model = purchase_tabel.getModel();
                        String query = "UPDATE buy SET Report='" + report_display.getText() +"' WHERE TransactionID='" + model.getValueAt(row, 6).toString() + "'";
                        try {
                            server.updateDb(query);
                            ImageIcon icon = new ImageIcon(getClass().getResource("/icons/success.png"));
                            JOptionPane.showMessageDialog(this, "Report Updated Successfully!!", "Success", JOptionPane.PLAIN_MESSAGE, icon);
                        }catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
                        } catch (RemoteException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Remote Error", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                }else{
                    JOptionPane.showMessageDialog(this, "You Have to Select A row first", "Success", JOptionPane.INFORMATION_MESSAGE);
                }

            }else{
                JOptionPane.showMessageDialog(this, "Empty Database! \nNO Data exists about purchase of your branch yet", "Empty Data", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (disp_eTpane.isVisible()) {
            if( getDataCount("employee", DialogFrame.logindialog.getBranch()) > 0){
                row = emp_tabel.getSelectedRow();
                if(row >= 0){
                    confirm = JOptionPane.showConfirmDialog(null, "Are You sure to update this data ?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (confirm == JOptionPane.YES_OPTION) {
                        TableModel model = emp_tabel.getModel();
                        String query = "UPDATE employee SET Report='" + report_display.getText() +"' WHERE ID=" + model.getValueAt(row, 0).toString();
                        try {
                            server.updateDb(query);
                            ImageIcon icon = new ImageIcon(getClass().getResource("/icons/success.png"));
                            JOptionPane.showMessageDialog(this, "Report Updated Successfully!!", "Success", JOptionPane.PLAIN_MESSAGE, icon);
                        }catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
                        } catch (RemoteException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Remote Error", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                }else{
                    JOptionPane.showMessageDialog(this, "You Have to Select A row first", "Success", JOptionPane.INFORMATION_MESSAGE);
                }

            }else{
                JOptionPane.showMessageDialog(this, "Empty Database! \nNO Data exists about employees of your branch yet", "Empty Data", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_updateReportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BudgetPan;
    private javax.swing.JFormattedTextField DOA;
    private javax.swing.JTabbedPane E_tabbedpane;
    private javax.swing.JPanel Emp_Tpane;
    public javax.swing.JLabel Id_home;
    private javax.swing.JPanel Systempanel;
    private javax.swing.JLabel addtab;
    private javax.swing.JFormattedTextField b_field;
    private javax.swing.JFormattedTextField bdate_field;
    public javax.swing.JLabel branch_home;
    private javax.swing.JPanel budget_Tpane;
    private javax.swing.JButton budget_clear;
    private javax.swing.JButton budget_go;
    private javax.swing.JLabel budgetlabel1;
    private javax.swing.JPanel buyPan;
    private javax.swing.JPanel buy_Tpane;
    private javax.swing.JTextField buy_id;
    private javax.swing.JTextField buy_name;
    private javax.swing.JFormattedTextField buy_price;
    private javax.swing.JFormattedTextField buy_qt;
    private javax.swing.JTextField buy_seller;
    private javax.swing.JLabel buylabel;
    private javax.swing.JLabel chat_tab;
    private javax.swing.JRadioButton dateradio;
    private javax.swing.JButton deletebut;
    private javax.swing.JPanel disp_eTpane;
    private javax.swing.JPanel disp_pTpane;
    private javax.swing.JButton disp_refresh;
    private javax.swing.JPanel disp_sTpane;
    private javax.swing.JButton disp_search;
    private javax.swing.JPanel display_Tpane;
    private javax.swing.JLabel displaytab;
    private javax.swing.JTextField emp_address;
    private javax.swing.JFormattedTextField emp_age;
    private javax.swing.JButton emp_clear;
    private javax.swing.JButton emp_go;
    private javax.swing.JTextField emp_job;
    private javax.swing.JTextField emp_name;
    private javax.swing.JFormattedTextField emp_phone;
    private javax.swing.JTextPane emp_report;
    private javax.swing.JFormattedTextField emp_salary;
    private javax.swing.JTable emp_tabel;
    private javax.swing.JLabel enlabel10;
    private javax.swing.JLabel enlabel11;
    private javax.swing.JLabel enlabel12;
    private javax.swing.JLabel enlabel13;
    private javax.swing.JLabel enlabel9;
    private javax.swing.JLabel entrylabel1;
    private javax.swing.JLabel entrylabel10;
    private javax.swing.JLabel entrylabel11;
    private javax.swing.JLabel entrylabel12;
    private javax.swing.JLabel entrylabel13;
    private javax.swing.JLabel entrylabel14;
    private javax.swing.JLabel entrylabel15;
    private javax.swing.JLabel entrylabel16;
    private javax.swing.JLabel entrylabel17;
    private javax.swing.JLabel entrylabel18;
    private javax.swing.JLabel entrylabel2;
    private javax.swing.JLabel entrylabel3;
    private javax.swing.JLabel entrylabel5;
    private javax.swing.JLabel entrylabel6;
    private javax.swing.JLabel entrylabel7;
    private javax.swing.JLabel entrylabel8;
    private javax.swing.JLabel entrylabel9;
    private javax.swing.JRadioButton femal_radio;
    private javax.swing.JFormattedTextField fund_field;
    private javax.swing.JLabel homelabel1;
    private javax.swing.JLabel homelabel2;
    private javax.swing.JLabel homelabel3;
    private javax.swing.JLabel homelabel4;
    private javax.swing.JLabel homelabel5;
    private javax.swing.JLabel homelabel6;
    private javax.swing.JSeparator homeliner1;
    private javax.swing.JPanel homepan1;
    private javax.swing.JRadioButton idradio;
    private javax.swing.JPanel insert_Tpane;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel logout_tab;
    private javax.swing.JPanel mainWorkspace;
    private javax.swing.JRadioButton male_radio;
    private javax.swing.JPanel menuLayer;
    private javax.swing.JLabel menuicon;
    private javax.swing.JLabel menuicon1;
    private javax.swing.JRadioButton nameradio;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JRadioButton priceradio;
    private javax.swing.JButton pur_clear;
    private javax.swing.JButton pur_go;
    private javax.swing.JTextPane purchase_report;
    private javax.swing.JTable purchase_tabel;
    private javax.swing.JTextPane report_display;
    private javax.swing.JLabel rowIndicator;
    private javax.swing.JTextField sale_buyer;
    private javax.swing.JButton sale_clear;
    private javax.swing.JButton sale_go;
    private javax.swing.JTextField sale_name;
    private javax.swing.JFormattedTextField sale_price;
    private javax.swing.JFormattedTextField sale_profit;
    private javax.swing.JFormattedTextField sale_qt;
    private javax.swing.JTable sale_tabel;
    private javax.swing.JTextPane salereport;
    private javax.swing.JPanel sales_Tpane;
    private javax.swing.JScrollPane scrollpane4;
    private javax.swing.JScrollPane scrollpane5;
    private javax.swing.JScrollPane scrollpane6;
    private javax.swing.JScrollPane scrollpane9;
    private javax.swing.JTextField search_input;
    private javax.swing.JPanel searchtab2;
    private javax.swing.JPanel sellPan;
    private javax.swing.JTextField sell_id;
    private javax.swing.JLabel sell_label;
    private javax.swing.JPanel stat_panel;
    private javax.swing.JPanel tabbb;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTabbedPane tabbedpane2;
    public javax.swing.JLabel total_employee;
    public javax.swing.JLabel total_purchase;
    public javax.swing.JLabel total_sales;
    private javax.swing.JButton updateReport;
    // End of variables declaration//GEN-END:variables
}
