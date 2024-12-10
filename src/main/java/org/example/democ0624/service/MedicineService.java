package org.example.democ0624.service;

import org.example.democ0624.model.Medicine;
import org.example.democ0624.repository.IMedicineRepository;
import org.example.democ0624.repository.MedicineRepository;

import java.util.List;

public class MedicineService implements IMedicineService {
    private final IMedicineRepository medicineRepository;

    public MedicineService() {
        this.medicineRepository = new MedicineRepository();
    }

    @Override
    public List<Medicine> getAll() {
        return medicineRepository.getAll();
    }

    @Override
    public Medicine getById(int id) {
        return medicineRepository.getById(id);
    }

    @Override
    public boolean save(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @Override
    public boolean update(Medicine medicine) {
        return medicineRepository.update(medicine);
    }

    @Override
    public boolean delete(int id) {
        return medicineRepository.delete(id);
    }
}