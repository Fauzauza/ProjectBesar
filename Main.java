import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Locale;
import java.util.Scanner;

// Interface untuk item-menu yang dapat dipesan
interface Orderable {
    String getName();
    double getPrice();
}

// Kelas abstrak untuk merepresentasikan item-menu
abstract class Menu implements Orderable {
    private final String name;
    private final double price;

    public Menu(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - " + Main.formatRupiah(price);
    }
}

// Kelas konkrit untuk merepresentasikan kategori menu
class Category {
    private final String name;
    private final List<Menu> items;

    public Category(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void addItem(Menu item) {
        items.add(item);
    }

    public List<Menu> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }
}

// Kelas untuk merepresentasikan pesanan
class Order {
    private final Map<Orderable, Integer> items;

    public Order() {
        this.items = new HashMap<>();
    }

    public void addItem(Orderable item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Orderable, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public void displayOrder() {
        System.out.println("Ordered Items:");
        for (Map.Entry<Orderable, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey().getName() + " x" + entry.getValue() + " - " + Main.formatRupiah(entry.getKey().getPrice() * entry.getValue()));
        }
        System.out.println("Total: " + Main.formatRupiah(calculateTotal()));
    }
}

public class Main {
    public static void main(String[] args) {
        // Membuat kategori menu
        Category MakananUtama = new Category("Makanan Utama");
        MakananUtama.addItem(new MenuItem("Nasi Goreng", 30000.0));
        MakananUtama.addItem(new MenuItem("Mie Goreng", 25000.0));
        MakananUtama.addItem(new MenuItem("Rendang", 27000.0));
        MakananUtama.addItem(new MenuItem("Soto Ayam", 20000.0));
        MakananUtama.addItem(new MenuItem("Ayam Bakar", 20000.0));

        Category MakananPembuka = new Category("Makanan Pembuka");
        MakananPembuka.addItem(new MenuItem("Sate Ayam", 15000.0));
        MakananPembuka.addItem(new MenuItem("Martabak", 10000.0));
        MakananPembuka.addItem(new MenuItem("Gado-Gado", 15000.0));
        MakananPembuka.addItem(new MenuItem("Perkedel", 7000.0));

        Category desserts = new Category("Desserts");
        desserts.addItem(new MenuItem("Dawet", 15000.0));
        desserts.addItem(new MenuItem("Dadar Gulung", 10000.0));
        desserts.addItem(new MenuItem("Es Teler", 16000.0));
        desserts.addItem(new MenuItem("Klepon", 5000.0));

        // Menampilkan menu
        System.out.println("Menu:");
        displayCategory(MakananUtama);
        displayCategory(MakananPembuka);
        displayCategory(desserts);

        // Membuat pesanan
        Order order = new Order();

        // Memilih makanan
        selectFood(MakananUtama, order);
        selectFood(MakananPembuka, order);
        selectFood(desserts, order);

        // Menampilkan pesanan
        order.displayOrder();
    }

    // Menampilkan kategori menu
    private static void displayCategory(Category category) {
        System.out.println(category.getName() + ":");
        for (Menu item : category.getItems()) {
            System.out.println(item);
        }
        System.out.println();
    }

    // Memilih makanan dan menambahkannya ke pesanan
    private static void selectFood(Category category, Order order) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih makanan dari " + category.getName() + " (masukkan nomor makanan): ");
        for (int i = 0; i < category.getItems().size(); i++) {
            System.out.println((i + 1) + ". " + category.getItems().get(i));
        }

        int foodNumber = scanner.nextInt();
        if (foodNumber >= 1 && foodNumber <= category.getItems().size()) {
            System.out.println("Masukkan jumlah pesanan: ");
            int quantity = scanner.nextInt();
            order.addItem(category.getItems().get(foodNumber - 1), quantity);
            System.out.println("Makanan ditambahkan ke pesanan.\n");
        } else {
            System.out.println("Nomor makanan tidak valid.\n");
        }
    }

    // Format harga ke dalam format Rupiah
    static String formatRupiah(double price) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');

        DecimalFormat rupiahFormat = new DecimalFormat("Rp #,##0.00", symbols);

        return rupiahFormat.format(price);
    }
}

class MenuItem extends Menu {
    public MenuItem(String name, double price) {
        super(name, price);
    }
}
