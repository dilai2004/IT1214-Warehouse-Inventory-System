
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
        System.out.println("Item added successfully.");
    }

    public void removeItem(String itemId) {
        Item itemToRemove = searchById(itemId);
        if (itemToRemove != null) {
            items.remove(itemToRemove);
            System.out.println("Item removed successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }

    public void updateQuantity(String itemId, int newQuantity) {
        Item item = searchById(itemId);
        if (item != null) {
            item.setQuantity(newQuantity);
            System.out.println("Quantity updated successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }

    public Item searchById(String itemId) {
        for (Item item : items) {
            if (item.getItemId().equalsIgnoreCase(itemId)) {
                return item;
            }
        }
        return null;
    }

    public Item searchByName(String name) {
        for (Item item : items) {
            if (item.getItemName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public void displayAllItems() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }
}
