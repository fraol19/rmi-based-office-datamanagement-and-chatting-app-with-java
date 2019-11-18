package chat;

import java.io.Serializable;

//a class used for storing user profile data
public class Profile implements Serializable{
    
    private int id;
    private String name;
    private String branchid;
    
    public Profile(int id,String name,String branchid) {
        this.name = name;
        this.id = id;
        this.branchid = branchid;
    }

    public String getName() {
        return name;
    }
  
    public int getID(){
        return this.id;
    }
    public String getBranchId(){
       return this.branchid;
    }
   
}
