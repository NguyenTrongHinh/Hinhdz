package hust.soict.hedspi.test.cart;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
public class TestCart {
    public static void main(String[] args) {
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("One Piece", "Anime", "Oda", 148, 29.5f);

        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Songoku", "Action", "Toriyama", 136, 19.0f);
        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Naruto", "Anime", "Kishimoto", 169, 24.5f);
        anOrder.addDigitalVideoDisc(dvd3);

        anOrder.print();

        //Test search by ID method
        anOrder.searchById(2);
        anOrder.searchById(3);

        //Test search by Title method
        anOrder.searchByTitle("One Piece");
        anOrder.searchByTitle("Songoku");
    }
}