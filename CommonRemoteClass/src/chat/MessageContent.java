package chat;

import java.io.Serializable;
import java.util.Date;

//a class used for storing message content and associated informations

public class MessageContent implements Serializable{
    
    private int from;
    private String message;
    private int to;
    private boolean hasfile;
    private String url;
    private int type=1;
    private String filename;
    private byte[] bytedata;
    private Date time;
    private boolean seen;
          
    public MessageContent(int from,int to,String message) {
        this.from = from;
        this.to = to;
        this.message = message;
        this.hasfile = false;
        this.url = null;
    }
    
    public MessageContent(int from,int to,String message,String filename,byte[] bytedata){
        this.from = from;
        this.to = to;
        this.type = 2;
        this.message = message;
        this.filename = filename;
        this.bytedata = bytedata;
        this.hasfile = true;
    
    }

    public int getFrom() {
        return from;
    }
    
    public int getTo(){
        return to;
    }
    
    public String getMessage() {
        return message;
    }

    public void setDate(Date time) {
        this.time = time;
    }
    
    public Date getTime(){
        return time; 
    }
    
    public void setSeen(boolean seen){
        this.seen = seen;
    }
    
    public boolean getSeen(){
       return this.seen;
    }
    
    public boolean hasFile(){
      return hasfile;
    }

    public String getFileName(){
      return filename;
    }
    public byte[] getFile(){
      return bytedata;
    }
    
    public String getUrl(){
      return this.url;
    }
    
   
    
}
