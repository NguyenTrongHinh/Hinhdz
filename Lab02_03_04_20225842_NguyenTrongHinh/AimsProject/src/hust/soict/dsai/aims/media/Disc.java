package hust.soict.dsai.aims.media;
public class Disc extends Media{
    // Nguyễn Trọng Hinh - 20225842 - Attribute
    private String director;
    private float length;

    // Nguyễn Trọng Hinh - 20225842 - Constructor
    public Disc(int id, String title, String category, float cost, String director, float length) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    public Disc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    // Nguyễn Trọng Hinh - 20225842 - Getters and Setters
    public String getDirector() { return director; }
    @Override
    public float getLength() { return length; }

    public void setLength(float length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "DVD: " +
                " {id = "  + getId() +
                ", title = '" + getTitle() + '\'' +
                ", category = '" + getCategory() + '\'' +
                ", director: " + getDirector() +
                ", length = " + getLength() + ", cost= " + getCost() + "$}";
    }
}
