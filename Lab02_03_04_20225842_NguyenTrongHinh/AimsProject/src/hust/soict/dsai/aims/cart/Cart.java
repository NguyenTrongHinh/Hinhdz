package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.*;

public class Cart {
    // Nguyễn Trọng Hinh - 20225842 - Attribute
    private final ArrayList<Media> itemsOrdered = new ArrayList<>();

    // Nguyễn Trọng Hinh - 20225842 - Properties
    public void addMedia(Media item) {
        if (itemsOrdered.contains(item)) {
            System.out.println(item.getTitle() + " is already in the cart!");
        } else {
            itemsOrdered.add(item);
            System.out.println(item.getTitle() + " is now in your cart!");
        }
    }

    public void removeMedia(Media item) {
        if (itemsOrdered.contains(item)) {
            itemsOrdered.remove(item);
            System.out.println(item.getTitle() + " has been removed from your cart.");
        } else {
            System.out.println(item.getClass().getSimpleName() + " " + item.getTitle() + " is not in the cart!");
        }
    }

    public float totalCost() {
        float sum = 0;
        for (Media item : itemsOrdered) {
            sum += item.getCost();
        }
        return sum;
    }

    public void print() {
        StringBuilder output = new StringBuilder("*************CART**************************\nOrdered items:\n");
        if (itemsOrdered.isEmpty()) {
            output.append("No items\n");
        } else {
            int i = 1;
            for (Media item : itemsOrdered) {
                output.append(i)
                        .append(". [")
                        .append(item.getTitle())
                        .append("] - [")
                        .append(item.getCategory())
                        .append("] - ")
                        .append(item.getCost())
                        .append(" $\n");
                i++;
            }
        }
        output.append("Total: ")
              .append(totalCost())
              .append(" $\n");
        output.append("================================================\n");
        System.out.println(output);
    }

    public void searchById(int id) {
        if (id > itemsOrdered.size() || id <= 0) {
            System.out.println("No match found!");
        } else {
            Media item = itemsOrdered.get(id - 1);
            System.out.println("Result: [" + item.getTitle() +
                    "] - [" + item.getCategory() + "] - " + item.getCost() + " $\n");
        }
    }

    public void searchByTitle(String title) {
        for (Media item : itemsOrdered) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Result: [" + item.getTitle() +
                        "] - [" + item.getCategory() + "] - " + item.getCost() + " $\n");
                return;
            }
        }
        System.out.println("No match found");
    }

    public Media findMedia(String title) {
        for (Media item : itemsOrdered) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }

    public void emptyCart() {
        itemsOrdered.clear();
    }

    public void sortByTitleCost() {
        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
    }
}




/* public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final DigitalVideoDisc[] dvds;
    private int qtyOrdered;
  
    public Cart() {
        dvds = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
        qtyOrdered = 0;
    }
  
    // Add a DVD to the cart
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            dvds[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("NTH-The DVD \"" + disc.getTitle() + "\" has been successfully added to the cart.");
        } else {
            System.out.println("NTH-The cart is full.");
        }
    }
    public int addDigitalVideoDisc(DigitalVideoDisc... dvdArray) {
        int addCount = 0;
        for (DigitalVideoDisc disc : dvdArray) {
            if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is almost full. Can't add more discs");
                break;
            } else {
                dvds[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("The DVD " + '\"' + disc.getTitle() + '\"' + " has been added!");
                addCount++;
            }
        }
        return addCount;
    }
    //Ham them 2 dia DVD
    public int addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 1 >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full. Can't add more discs");
            return 0;
        } else {
            dvds[qtyOrdered] = dvd1;
            qtyOrdered++;
            System.out.println("The DVD " + '\"' + dvd1.getTitle() + '\"' + " has been added!");

            dvds[qtyOrdered] = dvd2;
            qtyOrdered++;
            System.out.println("The DVD " + '\"' + dvd2.getTitle() + '\"' + " has been added!");

            return 2; //Tra ve so dia DVD da them duoc
        }
    }
    // Remove a DVD from the cart
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (dvds[i].equals(disc)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    dvds[j] = dvds[j + 1];
                }
                dvds[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("NTH-The disc \"" + disc.getTitle() + "\" has been removed from the cart.");
                return;
            }
        }
        System.out.println("NTH-DVD not found in the cart.");
    }
  
    // Calculate the total cost of DVDs in the cart
    public float totalCost() {
        float totalCost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            totalCost += dvds[i].getCost();
        }
        return totalCost;
    }
  
    public void print() {
        StringBuilder output = new StringBuilder("*********************CART************************** \nOrdered items: \n");
        for (int i = 0; i < qtyOrdered; i++) {
            output.append(i + 1)
                  .append(". [")
                  .append(dvds[i].getTitle())
                  .append("] - [")
                  .append(dvds[i].getCategory())
                  .append("] - [")
                  .append(dvds[i].getDirector())
                  .append("] - [")
                  .append(dvds[i].getLength())
                  .append("]: ")
                  .append(dvds[i].getCost())
                  .append(" $\n");
        }
        output.append("total: ").append(totalCost()).append(" $\n");
        output.append("***************************************************\n");
        System.out.println(output);
    }
    
    public void searchById(int i) {
        if(i > qtyOrdered) {
            System.out.println("No match found !");
        } else {
            System.out.println("Result: " +  "[" + dvds[i-1].getTitle() +
                    "] - [" + dvds[i-1].getCategory() + "] - ["
                    + dvds[i-1].getDirector() + "] - ["
                    + dvds[i-1].getLength() + "]: " +dvds[i-1].getCost() + " $\n");
        }

    }

    public void searchByTitle(String title) {
        for(int i = 0;i < qtyOrdered; i++) {
            if(dvds[i].getTitle().equals(title)) {
                System.out.println("Result: " +  "[" + dvds[i].getTitle() +
                        "] - [" + dvds[i].getCategory() + "] - ["
                        + dvds[i].getDirector() + "] - ["
                        + dvds[i].getLength() + "]: " +dvds[i].getCost() + " $\n");
                return;
            }
        }
        System.out.println("No match found !");
    }
}
 */