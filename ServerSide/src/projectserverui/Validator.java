package projectserverui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class Validator {

    private String Id="";
    private ArrayList<String> idlist;               //for storing IDs fetched from database
    private ArrayList<Map<String,Object>> map;      //arraylist-map simulated resultset

    public Validator() {
       idlist = new ArrayList<>();
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public void cleanList(){
      idlist = new ArrayList<>();
    }

    
    
    public void setMap(ArrayList<Map<String,Object>> map) {
        this.map = map;
    }

    //fetch all IDs from the mapped result set
    public void fetchID() throws SQLException{
       if(!map.isEmpty() && map != null) 
         for(int i=0 ; i<map.size() ; i++){
           idlist.add(map.get(i).get("ID").toString());
         }
    }
    
    //generates untile we get accepted ID
    public String getRandomId(){
      while(validate(generateOnce()) == false){
         Id = "";
      }
      return Id;
    }
    
    //Random generator with length of 6
    private String generateOnce(){
      Id = Id + String.valueOf(RandomCharacter.getRandomUpperCaseLetter());
      for(int i=1 ; i<=2 ; i++){
        Id = Id + String.valueOf(RandomCharacter.getRandomLowerCaseLetter());
      }
      for(int i=1 ; i<=3 ; i++){
        Id = Id + String.valueOf(RandomCharacter.getRandomDigitCharacter());
      }
      
      return Id;
    }
    
   //check for Id validity
    public boolean validate(String Id){
      return !(idlist.contains(Id) || Id.length()< 6 || Id.contains(" ") || Id.trim().contains(" ") || Id.trim().isEmpty());
    }
    
    //check for empty name or address
    public boolean isEmpty(String name,String address){
       return name.isEmpty() || address.isEmpty() || name.trim().isEmpty() || address.trim().isEmpty();
    }
}
