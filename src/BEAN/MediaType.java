
package BEAN;


public class MediaType {
    
     private int MediaTypeId;
     private String Name;

    public MediaType(int MediaTypeId, String Name) {
        this.MediaTypeId = MediaTypeId;
        this.Name = Name;
    }
     
    public MediaType() {
    }

    public int getMediaTypeId() {
        return MediaTypeId;
    }

    public void setMediaTypeId(int MediaTypeId) {
        this.MediaTypeId = MediaTypeId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    
    
}
