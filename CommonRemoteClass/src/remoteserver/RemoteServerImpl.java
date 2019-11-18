package remoteserver;

import chat.MessageContent;
import chat.Profile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RemoteServerImpl extends UnicastRemoteObject implements RemoteServerInterface {

    private static Connection conn;                                       //our database connector
    private ArrayList<Map<String,Object>> map;                            //arraylist-map simulation of ResultSet for each row
    private ArrayList<Integer> activeusers;                               //Map of active users
    private Map<Integer,Double> statistics;                               //data mapper for statistical preview
    
    public RemoteServerImpl(Connection conn) throws RemoteException {
        RemoteServerImpl.conn = conn;
        map = new ArrayList<>();
        activeusers = new ArrayList<>();
        statistics = new HashMap<>();
    }
    
    
    /**** IMPLEMENTING METHODS ****/
         
   
    
//method for SQL INSERT query types    
    @Override
    public synchronized void insertToDb(String query) throws RemoteException,SQLException{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
        stmt.close();
     
    }
//method for SQL UPDATE query types
    @Override
    public synchronized void updateDb(String query) throws RemoteException,SQLException{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
    }
//method for SQL DELETE query types
    @Override
    public synchronized void deleteFromDb(String query) throws RemoteException,SQLException{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
       
    }
//method for counting row from DB tables
    @Override
    public int getCounted(String tablename, String branch) throws RemoteException, SQLException {
      int count=0;
      ResultSet rs=null;
      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      String query = "SELECT COUNT(*) AS counted FROM "+tablename+ " WHERE Branch='"+branch+"'";
      rs = stmt.executeQuery(query);
      if(rs.next())
        count = rs.getInt("counted");
      rs.close();
      stmt.close();
      return count;
    }    
//method for SQL SELECT query types
    @Override
    public synchronized ArrayList<Map<String,Object>> selectFromDb(String query) throws RemoteException,SQLException{
        ResultSet rs=null;
        map.removeAll(map);
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rs = stmt.executeQuery(query);
           if(rs != null)
              fetchData(rs);
       
        rs.close();
        stmt.close();
        return map;
    }
 //result set fetcher since result set is not serializable   
    public void fetchData(ResultSet rs) throws SQLException{
        ResultSetMetaData metadata = rs.getMetaData();
        ArrayList<String> colNames = new ArrayList<>();
        for(int i=1 ; i<=metadata.getColumnCount() ; i++){
           colNames.add(metadata.getColumnName(i));
        }
       
        int cols = metadata.getColumnCount();
        while(rs.next()){
           Map<String, Object> tmpMap = new HashMap<>();
           for(int i=1 ; i<=cols ; i++){
              tmpMap.put(colNames.get(i-1), rs.getObject(colNames.get(i-1)));
           }
           map.add(tmpMap);
        }
    }

//checks for newmessage in a message container for specific user
    @Override
    public ArrayList<MessageContent> checkMessage(int from,int to) throws RemoteException, SQLException, IOException {
         String query = "SELECT * From chat WHERE SentBy=" +String.valueOf(from)+" AND RecievedBy="+String.valueOf(to)+ " OR SentBy="+
                 String.valueOf(to)+" AND RecievedBy="+ String.valueOf(from)+ " ORDER BY Created ASC"; 
         ArrayList<MessageContent> mlist = new ArrayList<>();
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         ResultSet rs = stmt.executeQuery(query);
         while(rs.next()){
           if(rs.getInt("MessageType") == 1){
             MessageContent message = new MessageContent(rs.getInt("SentBy"),rs.getInt("RecievedBy"), rs.getString("Message"));
             message.setDate(rs.getTimestamp("Created"));
             message.setSeen(rs.getBoolean("Seen"));
             mlist.add(message);
           }else if(rs.getInt("MessageType") == 2){
                File file = new File(rs.getString("Url"));
                byte[] bytedata = null;
                if(file.exists()){
                  bytedata = Files.readAllBytes(file.toPath());  
                }
                bytedata = Files.readAllBytes(file.toPath());
                int sender = rs.getInt("SentBy");
                int reciever = rs.getInt("RecievedBy");
                String text = rs.getString("Message").toString();
                String filename = rs.getString("FileName").toString();
                
               MessageContent message = new MessageContent(sender,reciever,text,filename,bytedata);
               message.setDate(rs.getTimestamp("Created"));
               message.setSeen(rs.getBoolean("Seen"));
               mlist.add(message);
           } 
         }
         rs.close();
         stmt.close();
         query = "UPDATE chat SET Seen="+String.valueOf(1)+" WHERE SentBy="+String.valueOf(from)+" AND RecievedBy="+String.valueOf(to);
         updateDb(query);
       return mlist;  
    }
// upload file first    
    @Override
    public void uploadFile(MessageContent content) throws RemoteException, IOException, SQLException{
        File file = new File(content.getFileName());
        if (file.exists()) {
            int lasti = content.getFileName().lastIndexOf(".");
            String ext = content.getFileName().substring(lasti);
            String fname = content.getFileName().replace(ext,"");
            file = new File(fname+ String.valueOf(new Random().nextInt(50))+ext);
        }
         file.createNewFile();
         Files.write(file.toPath(), content.getFile(), StandardOpenOption.WRITE);
         
         String query = "INSERT INTO chat (MessageType,Message,Url,FileName,SentBy,RecievedBy) values(2,'"+content.getMessage()+"','"
                 +file.getPath()+"','"+content.getFileName()+"',"+String.valueOf(content.getFrom())+","+String.valueOf(content.getTo())+")";
         insertToDb(query);
    }
    
    
//return a calculated statistics for available years in database table    
    @Override
    public Map<Integer,Double> getCalculatedData(String tablename) throws RemoteException, SQLException{
       statistics.clear();
       ArrayList<Integer> datelist;
       String query="";
      
       if(tablename.equalsIgnoreCase("budget")){ 
         datelist = getSQlDate(tablename);
         if(!datelist.isEmpty()){
           for(Integer x : datelist){
             query ="SELECT SUM(Amount) AS total FROM budget WHERE Date LIKE '"+x.toString() + "%'";
             if(getTotalSum(query) != null)
               statistics.put(x, getTotalSum(query));
           }
         } 
       }else if(tablename.equalsIgnoreCase("sales")){
         datelist = getSQlDate(tablename);
         
         if(!datelist.isEmpty()){
           for(Integer x : datelist){
             query ="SELECT SUM(Totalprofit) AS total FROM sales WHERE Date LIKE '"+x.toString() + "%'";
             if(getTotalSum(query) != null)
               statistics.put(x, getTotalSum(query));
           }
         }
       }else{
         datelist = getSQlDate(tablename);
         
         if(!datelist.isEmpty()){
           for(Integer x : datelist){
             query = "SELECT SUM(Totalprice) AS total FROM buy WHERE Date LIKE '"+x.toString() + "%'";
             if(getTotalSum(query) != null)
               statistics.put(x, getTotalSum(query));
           }
         }
       }
  
       return statistics;
    }
//get the calculated fund statistics 
    @Override
    public Map<Integer, Double> getExtraStatistics(String tablename) throws RemoteException, SQLException {
       statistics.clear();
       ArrayList<Integer> datelist;
       String query="";
       if(tablename.equalsIgnoreCase("budget")){ 
         datelist = getSQlDate(tablename);
         if(!datelist.isEmpty()){
           for(Integer x : datelist){
             query ="SELECT SUM(Fundings) AS total FROM budget WHERE Date LIKE '"+x.toString() + "%'";
             if(getTotalSum(query) != null)
               statistics.put(x, getTotalSum(query));
           }
         } 
       }else{
         datelist = getSQlDate(tablename);
         if(!datelist.isEmpty()){
           for(Integer x : datelist){
             query ="SELECT SUM(Totalprice) AS total FROM sales WHERE Date LIKE '"+x.toString() + "%'";
             if(getTotalSum(query) != null)
               statistics.put(x, getTotalSum(query));
           }
         }
       }
      
       return statistics;
    }    
    
//get minimun or maximum from a given database table based on the reading command 0=minimum otherwise maximum    
    @Override
    public int getMinMaxDate(String tablename,int key) throws RemoteException,SQLException{
       Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
       ResultSet rs = null;
       String query;
       
       switch(key){
          case 0:
            query = "SELECT MIN(YEAR(Date)) AS minmax FROM ";
            break;
          default:
            query = "SELECT MAX(YEAR(Date)) AS minmax FROM ";
            break;  
       }
 
       if(tablename.equalsIgnoreCase("budget")){
          query += "budget";
          rs = stmt.executeQuery(query);
          
       }else if(tablename.equalsIgnoreCase("sales")){
          query += "sales";
          rs = stmt.executeQuery(query);
          
       }else{
         query += "buy"; 
         rs = stmt.executeQuery(query);
        
       }
      
      if(rs.next()){
              int yr = rs.getInt("minmax");
              rs.close();
              stmt.close();
              return yr;
      }      
      else{ 
          rs.close();
          stmt.close(); 
          return 0; 
      }    
    }
//gets all year based on the query     
    public ArrayList<Integer> getDate(String query) throws SQLException{
         ArrayList<Integer> datelist = new ArrayList<>();
         ResultSet rs = null;
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         rs = stmt.executeQuery(query);
         while(rs.next()){
           datelist.add(rs.getInt("years"));
         }
         rs.close();
         stmt.close();
      return datelist;
    }
//query selector for selecting year values from Date column in the DB tables    
    public ArrayList<Integer> getSQlDate(String tablename) throws SQLException {
       String query;
       
      if(tablename.equalsIgnoreCase("budget")){
         query = "SELECT DISTINCT YEAR(Date) AS years FROM budget";
         return getDate(query);
      }else if(tablename.equalsIgnoreCase("sales")){
         query = "SELECT DISTINCT YEAR(Date) AS years FROM sales";
         return getDate(query);
      }else{
         query = "SELECT DISTINCT YEAR(Date) AS years FROM buy";
         return getDate(query);
      }
    }
//fetches total sum value based on the query     
    public Double getTotalSum(String query) throws SQLException{
      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
      ResultSet rs = null;
      rs = stmt.executeQuery(query);
      if(rs.next()){
        Double tot =  rs.getDouble("total");
        rs.close();
        stmt.close();
        return tot;
      }  
      else{
        rs.close();
        stmt.close();
        return null;
      }
      
    }


    @Override
    public void addActiveUser(int id) throws RemoteException {
        Integer i = new Integer(id);
        if(!activeusers.contains(i)){
           activeusers.add(i);
        }
    }

    @Override
    public void removeActiveUser(int id) throws RemoteException {
        Integer i = new Integer(id);
        if(activeusers.contains(i)){
           activeusers.remove(i);
        } 
    }

    @Override
    public ArrayList<Integer> getActiveUsers() throws RemoteException {
        return this.activeusers;
    }

    @Override
    public ArrayList<MessageContent> getGroupMessages() throws RemoteException, SQLException {
         String query = "SELECT * FROM chat WHERE MessageType=3";
         ArrayList<MessageContent> mlist = new ArrayList<>();
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         ResultSet rs = stmt.executeQuery(query);
         while(rs.next()){
             MessageContent message = new MessageContent(rs.getInt("SentBy"),0, rs.getString("Message"));
             message.setDate(rs.getDate("Created"));
             mlist.add(message);
         }
         rs.close();
         stmt.close();
       return mlist;   
    }

    @Override
    public ArrayList<Profile> getAllUsers(int id) throws RemoteException, SQLException {
       ArrayList<Profile> allUsers = new ArrayList<>();
       String query = "SELECT * FROM holder WHERE ID<>"+String.valueOf(id)+" ORDER BY Name ASC";
       Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
       ResultSet rs = stmt.executeQuery(query);
       while(rs.next()){
         Profile p = new Profile(rs.getInt("ID"),rs.getString("Name"),rs.getString("BranchID"));
         allUsers.add(p);
       }
       return allUsers;
    }

    
}

