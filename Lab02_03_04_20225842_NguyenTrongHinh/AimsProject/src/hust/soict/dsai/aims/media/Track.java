package hust.soict.dsai.aims.media;

public class Track {
    // Nguyễn Trọng Hinh - 20225842 - Attribute
    private final String title;
    private final int length;
    
    // Nguyễn Trọng Hinh - 20225842 - Getters
    public int getLength() { return length; }
    public String getTitle() { return title; }

    // Nguyễn Trọng Hinh - 20225842 - Constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    // Nguyễn Trọng Hinh - 20225842 - override equals
    public boolean equals(Track tmp) {
        return (title.equals(tmp.getTitle())) && (length == tmp.getLength());
    }
}
