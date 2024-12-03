public class MedicineView {
    public void printMedicineDetails(int id, String name, String manufacturer, double price, int stock) {
        System.out.println("Medicine Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Price: VND" + price);
        System.out.println("Stock: " + stock);
    }
}
