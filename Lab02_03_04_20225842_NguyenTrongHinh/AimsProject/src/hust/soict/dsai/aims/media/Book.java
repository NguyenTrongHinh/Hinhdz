// Nguyễn Trọng Hinh - 20225842
//Class "Book" extend "Media"
package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    // Nguyễn Trọng Hinh - 20225842 - Kế thừa các thuộc tính id, title, category, cost
    private List<String> authors = new ArrayList<>();

    // Nguyễn Trọng Hinh - 20225842 - Constructor
    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    // Nguyễn Trọng Hinh - 20225842 - Getters and Setters
    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    // Nguyễn Trọng Hinh - 20225842 - Properties
    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println(authorName + " is already in the list!");
        } else {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        } else {
            System.out.println(authorName + " is not in the list!");
        }
    }

    // Nguyễn Trọng Hinh - 20225842 - Implementing the getLength() method
    @Override
    public float getLength() {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder("Book: " +
                " {id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", authors: ");
        for (String a : authors) {
            print.append(a);
            print.append(" ");
        }
        print.append(", cost: ");
        print.append(getCost());
        print.append("$}");

        return print.toString();
    }
}
