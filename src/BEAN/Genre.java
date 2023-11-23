
package BEAN;

public class Genre {
    
    private int GenreId;
    private String Name;

    public Genre(int GenreId, String Name) {
        this.GenreId = GenreId;
        this.Name = Name;
    }

    public Genre() {
    }

    public int getGenreId() {
        return GenreId;
    }

    public void setGenreId(int GenreId) {
        this.GenreId = GenreId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    
}
