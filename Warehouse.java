//provides a menu-driven interface to manage inventory operations such as adding, removing, updating, searching, and displaying items.

import java.util.Scanner;

public class Warehouse {
    private Inventory inventory;
    private Scanner scanner;

    public Warehouse() {
        inventory = new Inventory();
        scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            System.out.println("\n--- Warehouse Inventory System ---");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Update Item Quantity");
            System.out.println("4. Search Item by ID");
            System.out.println("5. Search Item by Name");
            System.out.println("6. Display All Items");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    updateQuantity();
                    break;
                case 4:
                    searchById();
                    break;
                case 5:
                    searchByName();
                    break;
                case 6:
                    inventory.displayAllItems();
                    break;
                case 7:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);
    }

    private void addItem() {
        System.out.print("Enter Item ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Item Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int qty = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        Item item = new Item(id, name, qty, price);
        inventory.addItem(item);
    }

    private void removeItem() {
        System.out.print("Enter Item ID to remove: ");
        String id = scanner.nextLine();
        inventory.removeItem(id);
    }

    private void updateQuantity() {
        System.out.print("Enter Item ID to update: ");
        String id = scanner.nextLine();
        System.out.print("Enter new quantity: ");
        int qty = scanner.nextInt();
        scanner.nextLine(); // consume newline
        inventory.updateQuantity(id, qty);
    }

    private void searchById() {
        System.out.print("Enter Item ID: ");
        String id = scanner.nextLine();
        Item item = inventory.searchById(id);
        System.out.println(item != null ? item : "Item not found.");
    }

    private void searchByName() {
        System.out.print("Enter Item Name: ");
        String name = scanner.nextLine();
        Item item = inventory.searchByName(name);
        System.out.println(item != null ? item : "Item not found.");
    }

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        warehouse.start();
    }
}
