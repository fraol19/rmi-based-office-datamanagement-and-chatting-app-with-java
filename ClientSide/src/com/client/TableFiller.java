package com.client;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import remoteserver.RemoteServerInterface;

public class TableFiller {

    private static ArrayList<Map<String, Object>> rowlist;               //arraylist-map simulated resultSet from DB tables
    private static String query;
    static ArrayList<String> vallist; 
    static ArrayList<String> numlist;
//sale table filler    
    public static void fillSaleTable(JTable table, RemoteServerInterface server, String where) throws RemoteException, SQLException {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        query = "SELECT Name,Qty,Price,Buyer,Profit,Totalprofit,Date,Branch,TransactionID FROM sales WHERE " + where;
        rowlist = server.selectFromDb(query);

        if (!rowlist.isEmpty()) {
            cleanTable(table);
            for (int i = 0; i < rowlist.size(); i++) {
                ArrayList<Object> row = new ArrayList<>();
                row.add(rowlist.get(i).get("Name"));
                row.add(rowlist.get(i).get("Qty"));
                row.add(rowlist.get(i).get("Price"));
                row.add(rowlist.get(i).get("Buyer"));
                row.add(rowlist.get(i).get("Profit"));
                row.add(rowlist.get(i).get("Totalprofit"));
                row.add(rowlist.get(i).get("Date"));
                row.add(rowlist.get(i).get("Branch"));
                row.add(rowlist.get(i).get("TransactionID"));
                model.addRow(row.toArray());
            }
            table.setModel(model);
        }
    }
//purchase table filler    

    public static void fillBuyTable(JTable table, RemoteServerInterface server, String where) throws RemoteException, SQLException {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        query = "SELECT Name,Qty,Price,Seller,Branch,Date,TransactionID FROM buy WHERE " + where;
        rowlist = server.selectFromDb(query);

        if (!rowlist.isEmpty()) {
            cleanTable(table);
            for (int i = 0; i < rowlist.size(); i++) {
                ArrayList<Object> row = new ArrayList<>();
                row.add(rowlist.get(i).get("Name"));
                row.add(rowlist.get(i).get("Qty"));
                row.add(rowlist.get(i).get("Price"));
                row.add(rowlist.get(i).get("Seller"));
                row.add(rowlist.get(i).get("Branch"));
                row.add(rowlist.get(i).get("Date"));
                row.add(rowlist.get(i).get("TransactionID"));
                model.addRow(row.toArray());
            }
            table.setModel(model);
        } 

    }

//employee table filler    
    public static void fillEmployeeTable(JTable table, RemoteServerInterface server, String where) throws RemoteException, SQLException {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        query = "SELECT ID,Name,Sex,Address,Age,DOA,Phone,Salary,Field FROM employee WHERE " + where;
        rowlist = server.selectFromDb(query);

        if (!rowlist.isEmpty()) {
            cleanTable(table);
            for (int i = 0; i < rowlist.size(); i++) {
                ArrayList<Object> row = new ArrayList<>();
                row.add(rowlist.get(i).get("ID"));
                row.add(rowlist.get(i).get("Name"));
                row.add(rowlist.get(i).get("Sex"));
                row.add(rowlist.get(i).get("Address"));
                row.add(rowlist.get(i).get("Age"));
                row.add(rowlist.get(i).get("DOA"));
                row.add(rowlist.get(i).get("Phone"));
                row.add(rowlist.get(i).get("Salary"));
                row.add(rowlist.get(i).get("Field"));
                model.addRow(row.toArray());
            }
            table.setModel(model);
        } 

    }

//sale table updator    
    public static boolean updateSaleTable(JTable table, RemoteServerInterface server, String report, int row) {
        TableModel model = table.getModel();
        vallist = new ArrayList<>();
        vallist.add(model.getValueAt(row, 0).toString());
        vallist.add(model.getValueAt(row, 3).toString());
        numlist = new ArrayList<>();
        numlist.add(model.getValueAt(row, 1).toString());
        boolean updated=true;
        if (isAlpha(vallist) && isDigit(numlist)) {
            if (row >= 0) {
              try {
                  double profit = Double.parseDouble(model.getValueAt(row, 4).toString());
                  double qty = Double.parseDouble(model.getValueAt(row, 1).toString());
                  String total = String.valueOf((profit * qty));
                  model.setValueAt(total, row, 5);
                  query = "UPDATE sales SET Name='" + model.getValueAt(row, 0).toString() + "',Qty=" + model.getValueAt(row, 1).toString()
                          + ",Price=" + model.getValueAt(row, 2).toString() + ",Buyer='" + model.getValueAt(row, 3).toString()
                          + "',Profit=" + model.getValueAt(row, 4).toString() + ",Totalprofit=" + total + ",Date='" + model.getValueAt(row, 6).toString()
                          + "',Branch='" + model.getValueAt(row, 7).toString() + "',Report='" + report + "' WHERE TransactionID='" + model.getValueAt(row, 8).toString() + "'";

                  server.updateDb(query);
                  table.setModel(model);
                  updated=true;
              } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null, ex.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
                  updated=false;
              } catch (NumberFormatException e) {
                  JOptionPane.showMessageDialog(null, "Profit or quantity must be numeric value","Number Format Error", JOptionPane.ERROR_MESSAGE);
                  updated=false;
              } catch (RemoteException ex) {
                  JOptionPane.showMessageDialog(null, ex.getMessage(), "Remote Error", JOptionPane.ERROR_MESSAGE);
                  updated=false;
              }

          } else {
              JOptionPane.showMessageDialog(null, "No row is edited!!\nyou have to edit first", "Edit Unavailable", JOptionPane.INFORMATION_MESSAGE);
              updated=false;
          }  
        }else{
          JOptionPane.showMessageDialog(null, "Names must be alphabetic characters \n Number must be digits", "Value Type Error", JOptionPane.ERROR_MESSAGE);
          updated = false;
        }
        
        return updated;
    }
    
//purchase table updator    
    public static boolean updateBuyTable(JTable table, RemoteServerInterface server, String report, int row) {
        TableModel model = table.getModel();
        boolean updated=true;
        vallist = new ArrayList<>();
        vallist.add(model.getValueAt(row, 0).toString());
//        vallist.add(model.getValueAt(row, 3).toString());
        numlist = new ArrayList<>();
        numlist.add(model.getValueAt(row, 1).toString());
         if (isAlpha(vallist) && isDigit(numlist)) {
            if (row >= 0) {
                try {
                    query = "UPDATE buy SET Name='" + model.getValueAt(row, 0).toString() + "',Qty=" + model.getValueAt(row, 1).toString()
                            + ",Price=" + model.getValueAt(row, 2).toString() + ",Seller='" + model.getValueAt(row, 3).toString()
                            + "',Branch='" + model.getValueAt(row, 4).toString() + "',Date='" + model.getValueAt(row, 5).toString()
                            + "',Report='" + report + "' WHERE TransactionID='" + model.getValueAt(row, 6).toString() + "'";

                    server.updateDb(query);
                    table.setModel(model);
                    updated=true;
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
                    updated=false;
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Remote Error", JOptionPane.ERROR_MESSAGE);
                    updated=false;
                }

            } else {
                JOptionPane.showMessageDialog(null, "No row is edited!!\nyou have to edit first", "Edit Unavailable", JOptionPane.INFORMATION_MESSAGE);
                updated=false;
            }
        }else{
          JOptionPane.showMessageDialog(null, "Names must be alphabetic characters \n Number must be digits", "Value Type Error", JOptionPane.ERROR_MESSAGE);
          updated = false;
        }
       return updated;
    }

//employee table updator 
    public static boolean updateEmployeeTable(JTable table, RemoteServerInterface server, String report, int row) {
        TableModel model = table.getModel();
        boolean updated=true;
        vallist = new ArrayList<>();
        vallist.add(model.getValueAt(row, 1).toString());
        vallist.add(model.getValueAt(row, 2).toString());
        vallist.add(model.getValueAt(row, 8).toString());
        numlist = new ArrayList<>();
        numlist.add(model.getValueAt(row, 4).toString());
        numlist.add(model.getValueAt(row, 6).toString());
         if (isAlpha(vallist) && isDigit(numlist)) {
            if(Validator.isDigit(model.getValueAt(row, 4).toString()) && model.getValueAt(row, 4).toString().length() <= 2){
                if (row >= 0) {
                  try {
                      query = "UPDATE employee SET Name='" + model.getValueAt(row, 1).toString() + "',Sex='" + model.getValueAt(row, 2).toString()
                              + "',Address='" + model.getValueAt(row, 3).toString() + "',Age=" + model.getValueAt(row, 4).toString()
                              + ",DOA='" + model.getValueAt(row, 5).toString() + "',Phone='" + model.getValueAt(row, 6).toString() + "',Salary=" + model.getValueAt(row, 7).toString()
                              + ",Field='" + model.getValueAt(row, 8).toString() + "',Report='" + report + "' WHERE ID=" + model.getValueAt(row, 0).toString();

                      server.updateDb(query);
                      table.setModel(model);
                      updated=true;
                  } catch (SQLException ex) {
                      JOptionPane.showMessageDialog(null, ex.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
                      updated=false;        
                  } catch (RemoteException ex) {
                      JOptionPane.showMessageDialog(null, ex.getMessage(), "Remote Error", JOptionPane.ERROR_MESSAGE);
                      updated=false;
                  }
              } else {
                  JOptionPane.showMessageDialog(null, "No row is edited!!\nyou have to edit first", "Edit Unavailable", JOptionPane.INFORMATION_MESSAGE);
                  updated=false;
              }
            
            }else{
              JOptionPane.showMessageDialog(null, "Age Must be a digit with not more than 2", "Value Type Error", JOptionPane.ERROR_MESSAGE);
              updated = false;
            }
             
        }else{
          JOptionPane.showMessageDialog(null, "Names must be alphabetic characters \n Number must be digits", "Value Type Error", JOptionPane.ERROR_MESSAGE);
          updated = false;
        }
        return updated;
    }

//table cleaner used before filler method    
    public static void cleanTable(JTable tabel) {
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        int rowCount = tabel.getRowCount();
        if (rowCount > 0) {
            for (int i = rowCount - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            tabel.setModel(model);
        }
    }
    
    public static boolean isAlpha(ArrayList<String> values){
      boolean is =true;
      for(String x : values){
         if(!Validator.isAlpha(x)){
           is = false;
           break;
         }
      }
      return is;
    }
    
    public static boolean isDigit(ArrayList<String> values){
      boolean is =true;
      for(String x : values){
         if(!Validator.isDigit(x)){
           is = false;
           break;
         }
      }
      return is;
    }

}
