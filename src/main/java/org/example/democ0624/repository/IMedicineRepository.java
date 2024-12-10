package org.example.democ0624.repository;

import org.example.democ0624.model.Medicine;

import java.util.List;

public interface IMedicineRepository {
    List<Medicine> getAll();
    Medicine getById(int id);
    boolean save(Medicine medicine);
    boolean update(Medicine medicine);
    boolean delete(int id);
}