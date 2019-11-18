package remoteserver;

import chat.MessageContent;
import chat.Profile;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;


public interface RemoteServerInterface extends Remote{
    
//methods used for database service
    
    public void insertToDb(String query) throws RemoteException,SQLException;
    public void updateDb(String query) throws RemoteException,SQLException;
    public void deleteFromDb(String query) throws RemoteException,SQLException;
    public ArrayList<Map<String,Object>> selectFromDb(String query) throws RemoteException,SQLException;
    public int getMinMaxDate(String tablename,int key) throws RemoteException,SQLException;
    public Map<Integer,Double> getCalculatedData(String tablename) throws RemoteException, SQLException;
    public Map<Integer,Double> getExtraStatistics(String tablename) throws RemoteException, SQLException;
    public int getCounted(String tablename,String branch) throws RemoteException,SQLException;
 
//methods used for chat service
    public void addActiveUser(int id) throws RemoteException;
    public void removeActiveUser(int id) throws RemoteException;
    public ArrayList<Profile> getAllUsers(int id) throws RemoteException,SQLException;
    
    public ArrayList<MessageContent> checkMessage(int from,int to) throws RemoteException,SQLException,IOException;
    public void uploadFile(MessageContent content) throws RemoteException,IOException,SQLException;
    public ArrayList<Integer>getActiveUsers() throws RemoteException;
    public ArrayList<MessageContent> getGroupMessages() throws RemoteException,SQLException;
    
    
    
}
