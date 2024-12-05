//Nguyễn Trọng Hinh
//Abstract class Media
package hust.soict.dsai.aims.media;

import java.util.*;

public abstract class Media {
    // Nguyễn Trọng Hinh - 20225842 - Attribute
    private final int id; 
    private String title;
    private String category;
    private float cost;

    // Nguyễn Trọng Hinh - 20225842 - Attribute
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    // Nguyễn Trọng Hinh - 20225842 - Constructor
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Nguyễn Trọng Hinh - 20225842 - Getters
    public int getId() {return id;}

    public String getTitle() {return title;}

    public String getCategory() {return category;}

    public float getCost() {return cost;}

    // Nguyễn Trọng Hinh - 20225842 - override equals
    boolean equals(Media o2) {
        return title.equals(o2.getTitle());
    }

    // Nguyễn Trọng Hinh - 20225842 - Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    public abstract float getLength();
    // Nguyễn Trọng Hinh - 20225842 - override toString()
    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " {id= " + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", cost= " + cost + " $}";
    }
}
