package projectserverui;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class BranchAdd extends javax.swing.JDialog {

    private final Validator validator;                           //input validator,ID duplication checker, and Random ID generator
    private ArrayList<Map<String, Object>> map;                  //mapped resultset From the remote DB server

    public BranchAdd(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lookAndFeel();
        setIconImage(new ImageIcon(getClass().getResource("/icons/openbranch.png")).getImage());
        this.validator = new Validator();
        initResultSet();                        //getall ID from the database
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        branch_name = new javax.swing.JTextField();
        branch_id = new javax.swing.JTextField();
        branch_add = new javax.swing.JTextField();
        approve = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        generatebox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Open Branch");
        setResizable(false);

        mainpanel.setBackground(new java.awt.Color(5, 16, 72));
        mainpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setForeground(new java.awt.Color(204, 255, 255));
        mainpanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 360, 10));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 29)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("OPEN NEW BRANCH");
        mainpanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 363, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Branch Name :");
        mainpanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 137, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Branch ID :");
        mainpanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 110, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Address :");
        mainpanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 130, 40));

        branch_name.setBackground(new java.awt.Color(0,0,0,100));
        branch_name.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        branch_name.setForeground(new java.awt.Color(255, 255, 255));
        mainpanel.add(branch_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 350, 40));

        branch_id.setBackground(new java.awt.Color(0,0,0,100));
        branch_id.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        branch_id.setForeground(new java.awt.Color(255, 255, 255));
        branch_id.setDisabledTextColor(new java.awt.Color(253, 58, 58));
        mainpanel.add(branch_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 350, 40));

        branch_add.setBackground(new java.awt.Color(0,0,0,100));
        branch_add.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        branch_add.setForeground(new java.awt.Color(255, 255, 255));
        mainpanel.add(branch_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 350, 40));

        approve.setBackground(new java.awt.Color(204, 255, 255));
        approve.setForeground(new java.awt.Color(255, 255, 255));
        approve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Ok.png"))); // NOI18N
        approve.setBorder(null);
        approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveActionPerformed(evt);
            }
        });
        mainpanel.add(approve, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 70, 50));

        clear.setBackground(new java.awt.Color(153, 153, 153));
        clear.setForeground(new java.awt.Color(255, 255, 255));
        clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/clear.png"))); // NOI18N
        clear.setToolTipText("");
        clear.setBorder(null);
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        mainpanel.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, 70, 50));

        generatebox.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        generatebox.setForeground(new java.awt.Color(153, 255, 153));
        generatebox.setText("Auto generate");
        generatebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateboxActionPerformed(evt);
            }
        });
        mainpanel.add(generatebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 138, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BranchAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
/**sets the resultset map based on the specific query**/
    private void initResultSet() {
        String query = "SELECT (ID) FROM branch";
        try {
            map = ServerUI.getServer().selectFromDb(query);
            if(map != null){
               validator.setMap(map);
               validator.fetchID();
            }
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Remote Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
/**Adding branch after verification**/
    private void addBranch() throws SQLException {
        String name = branch_name.getText().toLowerCase();
        String Id = branch_id.getText();
        String add = branch_add.getText();
        String query = "INSERT into branch values('"+ Id + "','" + name + "','" + add + "')";
        try {
            ServerUI.getServer().insertToDb(query); 
                clear.doClick();
                JOptionPane.showMessageDialog(null, "Branch added Successfully!!", "Success", JOptionPane.INFORMATION_MESSAGE);      
            
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Remote Error", JOptionPane.ERROR_MESSAGE);
        }

    }

 /**approve button handler**/
    private void approveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveActionPerformed

        if (generatebox.isSelected()) {
            if (validator.isEmpty(branch_name.getText(), branch_add.getText())) {
                JOptionPane.showMessageDialog(null, "Name and Address must be provided !!", "Empty Input", JOptionPane.ERROR_MESSAGE);
                branch_name.setFocusable(true);
            } else {
                try {
                    addBranch();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage() ,"SQL Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            if (validator.validate(branch_id.getText())) {
                if (validator.isEmpty(branch_name.getText(), branch_add.getText())) {
                    JOptionPane.showMessageDialog(null, "Name and Address must be provided !!", "Empty Input", JOptionPane.ERROR_MESSAGE);
                    branch_name.setFocusable(true);
                } else {
                    try {
                        addBranch();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage(),"SQL Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Check the Id!!\n1 > it may be already taken\n2 > id length, at least 6 characters\n3 > remove white spaces",
                        "Incorrect ID", JOptionPane.INFORMATION_MESSAGE);
                branch_id.setFocusable(true);
            }
        }

    }//GEN-LAST:event_approveActionPerformed

/**Random ID generator check box **/   
    private void generateboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateboxActionPerformed
        if (generatebox.isSelected()) {
            branch_id.setEnabled(false);
            branch_id.setText("");
            try {
                validator.setId("");
                validator.cleanList();
                validator.setMap(map);
                validator.fetchID();
                branch_id.setText(validator.getRandomId());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            branch_id.setEnabled(true);
        }
    }//GEN-LAST:event_generateboxActionPerformed

/** Input field cleaner **/
    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        branch_name.setText("");
        branch_id.setText("");
        branch_id.setEnabled(true);
        branch_add.setText("");
        generatebox.setSelected(false);
    }//GEN-LAST:event_clearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approve;
    private javax.swing.JTextField branch_add;
    private javax.swing.JTextField branch_id;
    private javax.swing.JTextField branch_name;
    private javax.swing.JButton clear;
    private javax.swing.JCheckBox generatebox;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mainpanel;
    // End of variables declaration//GEN-END:variables
}
