package projectserverui;

import database.DBConnector;
import java.awt.Color;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import remoteserver.RemoteServerImpl;
import remoteserver.RemoteServerInterface;

public class ServerUI extends javax.swing.JFrame {

    private static RemoteServerInterface server;           //remote object for creating skeleton
    private String localIP;                                //local Running Ip Address of the Machine
    private String remoteIP = "rmi://";                    //protocol to bind the remote object
    private static boolean running = false;                //current status of the server

    public ServerUI() {
        initComponents();
        infolable.setVisible(false);
        iptip.setVisible(false);
        setIconImage(new ImageIcon(getClass().getResource("/icons/serverlarg.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        iplabel = new javax.swing.JLabel();
        infolable = new javax.swing.JLabel();
        indicateLabel = new javax.swing.JLabel();
        infoindicator = new javax.swing.JLabel();
        iptip = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        serverstart = new javax.swing.JMenuItem();
        addbranch = new javax.swing.JMenuItem();
        showbranch = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RB Server Adminstrator");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mainpanel.setBackground(new java.awt.Color(5, 16, 72));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("IP   :");

        iplabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        iplabel.setForeground(new java.awt.Color(204, 255, 255));
        iplabel.setText("Unknown");

        infolable.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        infolable.setForeground(new java.awt.Color(255, 255, 255));
        infolable.setText("You can add, delete or update branch from here on options menu");

        indicateLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        indicateLabel.setForeground(new java.awt.Color(255, 51, 51));
        indicateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        indicateLabel.setText("Server is Offline...");

        infoindicator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoindicator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Info_1.png"))); // NOI18N
        infoindicator.setLabelFor(infolable);
        infoindicator.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        infoindicator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                infoindicatorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                infoindicatorMouseExited(evt);
            }
        });

        iptip.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        iptip.setForeground(new java.awt.Color(204, 255, 255));
        iptip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Info_1.png"))); // NOI18N
        iptip.setText("use this ip-address to connect with this server from client side");

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(infoindicator, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infolable, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(indicateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
                            .addGroup(mainpanelLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(iplabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(mainpanelLayout.createSequentialGroup()
                                        .addComponent(iptip, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())))
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(indicateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iplabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iptip, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infolable, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(infoindicator, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Option");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        serverstart.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        serverstart.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        serverstart.setText("start server");
        serverstart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverstartActionPerformed(evt);
            }
        });
        jMenu1.add(serverstart);

        addbranch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ADD, java.awt.event.InputEvent.CTRL_MASK));
        addbranch.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        addbranch.setText("add branch");
        addbranch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbranchActionPerformed(evt);
            }
        });
        jMenu1.add(addbranch);

        showbranch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        showbranch.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        showbranch.setText("show branch");
        showbranch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showbranchActionPerformed(evt);
            }
        });
        jMenu1.add(showbranch);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static RemoteServerInterface getServer() {
        return server;
    }
    
/**Method that creates remote object and registry and Rebind the object**/
    private void startServer() throws RemoteException, UnknownHostException {
        localIP = InetAddress.getLocalHost().getHostAddress();
        try {
            DBConnector.getClassInstance().startConnection();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
        if (DBConnector.getClassInstance().getConnection() != null) {
            remoteIP += localIP + "/ServerRoom";
            server = new RemoteServerImpl(DBConnector.getClassInstance().getConnection());
            Registry reg = LocateRegistry.createRegistry(9010);
            reg.rebind(remoteIP, server);
            indicateLabel.setText("Server Running...");
            indicateLabel.setForeground(new Color(204,204,255));
            running = true;
            serverstart.setEnabled(false);
            iplabel.setText(InetAddress.getLocalHost().toString());
            iptip.setVisible(true);
        }
    }

/**BranchAdd frameUI launcher**/
    private void runUI() {
        SwingUtilities.invokeLater(() -> {
            BranchAdd dialog = new BranchAdd(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    dialog.dispose();
                }
            });
            dialog.setVisible(true);
        });
    }
    
/**BranchPreview frameUI launcher**/
    private void runTableUI() {
        SwingUtilities.invokeLater(() -> {
            BranchView dialog2 = new BranchView(new javax.swing.JFrame(), true);
            dialog2.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    dialog2.dispose();
                }
            });
            dialog2.setVisible(true);
        });

    }

/**addBranch menuItem handler **/   
    private void addbranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbranchActionPerformed
        if (running && DBConnector.getClassInstance().getConnection() != null) {
            runUI();
        } else {
            int option = JOptionPane.showConfirmDialog(null, "Server is Offline.........\nDo you want to bootup the server?", "Server Request", JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
            if (option == JOptionPane.YES_OPTION) {
                try {
                    startServer();
                    if (running) {
                        runUI();
                    } else {
                        JOptionPane.showMessageDialog(null, "Check your database server setup\n>you have to run the database server first", "DataBase Offline", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, "Error message\n" + ex.getMessage(), "RemoteConnection Error", JOptionPane.ERROR_MESSAGE);
                    indicateLabel.setText("Remote Error");
                } catch (UnknownHostException ex) {
                    JOptionPane.showMessageDialog(null, "Error message\n" + ex.getMessage(), "UnknownHost Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
    }//GEN-LAST:event_addbranchActionPerformed

/**serverstart menuItem handler**/
    private void serverstartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverstartActionPerformed
        try {
            startServer();
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, "Error message\n" + ex.getMessage(), "RemoteConnection Error", JOptionPane.ERROR_MESSAGE);
            indicateLabel.setText("Remote Error");
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(null, "Error message\n" + ex.getMessage(), "UnknownHost Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_serverstartActionPerformed

/**close the DB connection when the window closes**/    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
//            if (DBConnector.getClassInstance().getConnection() != null) {
                DBConnector.getClassInstance().close();
//            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Connection Close Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formWindowClosing

/**showbranch menuItem handler**/    
    private void showbranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showbranchActionPerformed
        if (running && DBConnector.getClassInstance().getConnection() != null) {
            runTableUI();
        } else {
            int option = JOptionPane.showConfirmDialog(null, "Server is Offline.........\nDo you want to bootup the server?", "Server Request", JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
            if (option == JOptionPane.YES_OPTION) {
                try {
                    startServer();
                    if (running) {
                        runTableUI();
                    } else {
                        JOptionPane.showMessageDialog(null, "Check your database server setup\n>you have to run the database server first", "DataBase Offline", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, "Error message\n" + ex.getMessage(), "RemoteConnection Error", JOptionPane.ERROR_MESSAGE);
                    indicateLabel.setText("Remote Error");
                } catch (UnknownHostException ex) {
                    JOptionPane.showMessageDialog(null, "Error message\n" + ex.getMessage(), "UnknownHost Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
    }//GEN-LAST:event_showbranchActionPerformed

    /****Information label indicator mouse event handlers */
    private void infoindicatorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoindicatorMouseEntered
        infolable.setVisible(true);
    }//GEN-LAST:event_infoindicatorMouseEntered

    private void infoindicatorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoindicatorMouseExited
       infolable.setVisible(false);
    }//GEN-LAST:event_infoindicatorMouseExited

    /** Main Method **/
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new ServerUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addbranch;
    private javax.swing.JLabel indicateLabel;
    private javax.swing.JLabel infoindicator;
    private static javax.swing.JLabel infolable;
    private javax.swing.JLabel iplabel;
    private javax.swing.JLabel iptip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JMenuItem serverstart;
    private javax.swing.JMenuItem showbranch;
    // End of variables declaration//GEN-END:variables
}
