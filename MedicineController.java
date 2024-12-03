public class MedicineController {
    private MedicineModel model;
    private MedicineView view;

    public MedicineController(MedicineModel model, MedicineView view) {
        this.model = model;
        this.view = view;
    }

    public void displayMedicine(int id) {
        Medicine medicine = model.getMedicineById(id);
        if (medicine != null) {
            view.printMedicineDetails(medicine.getId(), medicine.getName(), medicine.getManufacturer(), medicine.getPrice(), medicine.getStock());
        } else {
            System.out.println("Medicine not found!");
        }
    }

    public void updateMedicineStock(int id, int newStock) {
        model.updateMedicineStock(id, newStock);
    }
}
