import java.util.*;

class MenuItem {
    String name;
    double price;

    MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Order {
    List<MenuItem> items;
    double total;

    Order() {
        items = new ArrayList<>();
        total = 0;
    }

    void addItem(MenuItem item) {
        items.add(item);
        total += item.price;
    }

    double getTotal() {
        return total;
    }
}

public class menupenjualan {
    private List<MenuItem> menu;
    private Scanner scanner;

    public menupenjualan(Scanner scanner) {
        this.menu = new ArrayList<>();
        this.scanner = scanner;
    }

    public void addMenuItem() {
        System.out.println("Tambah menu");
        System.out.println("-----------");
        System.out.println("Nama menu:");
        String name = scanner.nextLine();
        System.out.println("Harga:");
        double price = scanner.nextDouble();
        scanner.nextLine();
        menu.add(new MenuItem(name, price));
        System.out.println("Menu ditambahkan");
    }

    public void displayMenu() {
        System.out.println("------------");
        System.out.println("Daftar menu");
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.get(i);
            System.out.println((i + 1) + ". " + item.name + ": " + item.price);
        }
    }

    public void createOrder() {
        Order order = new Order();
        String choice;
        do {
            displayMenu();
            System.out.println("------------");
            System.out.println("Buat pesanan");
            System.out.println("Pilih nomor menu:");
            int itemNumber = scanner.nextInt();
            scanner.nextLine();
            if (itemNumber > 0 && itemNumber <= menu.size()) {
                MenuItem item = menu.get(itemNumber - 1);
                order.addItem(item);
                System.out.println("Item ditambahkan ke pesanan");
            } else {
                System.out.println("Nomor menu tidak valid");
            }
            System.out.println("Tambah item lagi? (ya/tidak)");
            choice = scanner.nextLine();
        } while (choice.equalsIgnoreCase("ya"));
        System.out.println("----------");
        System.out.println("Total pesanan: " + order.getTotal());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menupenjualan menuPenjualan = new menupenjualan(scanner);
        while (true) {
            System.out.println("Menu Utama");
            System.out.println("1. Tambah Menu");
            System.out.println("2. Tampilkan Menu");
            System.out.println("3. Buat Pesanan");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    menuPenjualan.addMenuItem();
                    break;
                case 2:
                    menuPenjualan.displayMenu();
                    break;
                case 3:
                    menuPenjualan.createOrder();
                    break;
                case 4:
                    System.out.println("Terima kasih! Program selesai.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }
        }
    }
}
