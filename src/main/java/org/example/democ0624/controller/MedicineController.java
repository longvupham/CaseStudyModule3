package org.example.democ0624.controller;

import org.example.democ0624.model.Medicine;
import org.example.democ0624.service.IMedicineService;
import org.example.democ0624.service.MedicineService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "MedicineController", urlPatterns = "/medicines/*")
public class MedicineController extends HttpServlet {
    private IMedicineService medicineService;

    @Override
    public void init() {
        medicineService = new MedicineService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();
        if (action == null) action = "/list";

        switch (action) {
            case "/list":
                listMedicines(request, response);
                break;
            case "/medicine-form":
                showMedicineForm(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/delete":
                deleteMedicine(request, response);
                break;
            default:
                listMedicines(request, response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            int medicineId = Integer.parseInt(id);
            Medicine medicine = medicineService.getById(medicineId);
            request.setAttribute("medicine", medicine);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/medicine-form.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void showMedicineForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            int medicineId = Integer.parseInt(id);
            Medicine medicine = medicineService.getById(medicineId);
            request.setAttribute("medicine", medicine);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/medicine-form.jsp");
        dispatcher.forward(request, response);
    }

    private void listMedicines(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("medicines", medicineService.getAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/medicine-list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();
        if ("/add".equals(action)) {
            addMedicine(request, response);
        } else if ("/update".equals(action)) {
            updateMedicine(request, response);
        }
    }

    private void addMedicine(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Medicine medicine = new Medicine(
                0,
                request.getParameter("name"),
                request.getParameter("manufacturer"),
                Double.parseDouble(request.getParameter("price")),
                Integer.parseInt(request.getParameter("stock"))
        );
        medicineService.save(medicine);
        response.sendRedirect("list");
    }

    private void updateMedicine(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Medicine medicine = new Medicine(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("name"),
                request.getParameter("manufacturer"),
                Double.parseDouble(request.getParameter("price")),
                Integer.parseInt(request.getParameter("stock"))
        );
        medicineService.update(medicine);
        response.sendRedirect("list");
    }

    private void deleteMedicine(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        medicineService.delete(id);
        response.sendRedirect("list");
    }
}