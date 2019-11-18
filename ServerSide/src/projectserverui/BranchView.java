package projectserverui;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BranchView extends javax.swing.JDialog {

    private final Validator validator;                //input validator
    private int currentSelection;                     //current row selection for update and delete purpose
    private ArrayList<Map<String, Object>> map;       //mapped result set from remote database server
    
    
    public BranchView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lookAndFeel();
        setIconImage(new ImageIcon(getClass().getResource("/icons/openbranch.png")).getImage());
        validator = new Validator();
        fillTabel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        branchTable = new javax.swing.JTable();
        refresh_but = new javax.swing.JButton();
        info = new javax.swing.JLabel();
        delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Diplay Branches");
        setResizable(false);

        mainpanel.setBackground(new java.awt.Color(5, 16, 72));

        jSeparator1.setForeground(new java.awt.Color(204, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 29)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Branch List");

        branchTable.setBackground(new java.awt.Color(5, 16, 72));
        branchTable.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        branchTable.setForeground(new java.awt.Color(204, 255, 255));
        branchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        branchTable.setRowHeight(30);
        branchTable.setRowMargin(10);
        branchTable.setShowVerticalLines(false);
        branchTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                branchTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(branchTable);

        refresh_but.setBackground(new java.awt.Color(204, 255, 255));
        refresh_but.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        refresh_but.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/RefreshSmall.png"))); // NOI18N
        refresh_but.setText("Refresh");
        refresh_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_butActionPerformed(evt);
            }
        });

        info.setBackground(new java.awt.Color(255, 255, 255));
        info.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        info.setForeground(new java.awt.Color(255, 255, 255));
        info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Info_1.png"))); // NOI18N
        info.setText("Select row and edit any cell, then click Refresh !");

        delete.setBackground(new java.awt.Color(255, 153, 153));
        delete.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash.png"))); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(info, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refresh_but)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refresh_but, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

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

    private void checkedInsert() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) branchTable.getModel();
        String name = model.getValueAt(currentSelection, 1).toString();
        String add = model.getValueAt(currentSelection, 2).toString();
        String Id = model.getValueAt(currentSelection, 0).toString();
        try {
            if (validator.isEmpty(name, add)) {
                JOptionPane.showMessageDialog(null, "Name and Address must be provided", "Empty Input", JOptionPane.WARNING_MESSAGE);
            } else {
                String query = "UPDATE branch SET Name='"+ name + "',Address='" + add + "' WHERE ID='" + Id + "'";
                ServerUI.getServer().updateDb(query);
                JOptionPane.showMessageDialog(null, "Data refreshed Successfully!!", "Update Success", JOptionPane.INFORMATION_MESSAGE);
               
            }
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Remote Error", JOptionPane.ERROR_MESSAGE);
        }

    }
/**updating row data handler method**/
    private void refresh_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_butActionPerformed
        if (branchTable.isEditing()) {
            branchTable.getCellEditor().stopCellEditing();
        }
        currentSelection = branchTable.getSelectedRow();
        if (currentSelection >= 0) {
            try {
                checkedInsert();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage(),"SQL Error",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No row is edited!!\nyou have to edit first", "Edit Unavailable", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_refresh_butActionPerformed
/**branch row selection indicator**/
    private void branchTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_branchTableMouseClicked
        if (branchTable.getSelectedRow() >= 0) {
            info.setText("You Selected ID >> " + branchTable.getModel().getValueAt(branchTable.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_branchTableMouseClicked
/**deleting branch handler method**/
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int row;
        DefaultTableModel model;
        String query;
        row = branchTable.getSelectedRow();
        model = (DefaultTableModel) branchTable.getModel();
        if (row >= 0) {
            int confirm = JOptionPane.showConfirmDialog(null, "Are You sure to delete this data ?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(confirm == JOptionPane.YES_OPTION){
               query = "DELETE FROM branch WHERE ID='" + model.getValueAt(row, 0).toString() + "'";
            try {
                ServerUI.getServer().deleteFromDb(query);
                model.removeRow(row);
                branchTable.setModel(model);
                JOptionPane.showMessageDialog(null, "Branch Deleted Successfully!", "Data Removed", JOptionPane.INFORMATION_MESSAGE);
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Remote Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
            }
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "No row is selected", "Empty Selection", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_deleteActionPerformed
/**table cleaner used before filling the table**/
    private void cleanTabel(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = table.getRowCount();
        if (rowCount > 0) {
            for (int i = rowCount - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            table.setModel(model);
        }
    }
/**table filler used after cleaner**/
    private void fillTabel() {
        initResultSet("SELECT * FROM branch");
        cleanTabel(branchTable);
        DefaultTableModel model = (DefaultTableModel) branchTable.getModel();
        Object[] attributes = new Object[3];
        if(!map.isEmpty()){
            for(int j=0 ; j<map.size() ; j++){
                attributes[0] = map.get(j).get("ID");
                attributes[1] = map.get(j).get("Name");
                attributes[2] = map.get(j).get("Address");
                model.addRow(attributes);  
            }
        }
        branchTable.setModel(model);
    }
/**Swing look and feel for Nimbus**/
    private void lookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BranchView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
/**get mapped resultset based on the query type**/
    private void initResultSet(String query){
        try {
            map = ServerUI.getServer().selectFromDb(query);
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Remote Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"SQL Error",JOptionPane.ERROR_MESSAGE);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable branchTable;
    private javax.swing.JButton delete;
    private javax.swing.JLabel info;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JButton refresh_but;
    // End of variables declaration//GEN-END:variables
}
