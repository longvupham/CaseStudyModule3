package org.example.democ0624;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet(name = "MedicineServlet", value = "/medicines")
public class MedicineServlet extends HttpServlet {
    private MedicineModel medicineModel;

    @Override
    public void init() throws ServletException {
        medicineModel = new MedicineModel();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        List<Medicine> medicines = medicineModel.getAllMedicines();

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Danh sách thuốc</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Manufacturer</th><th>Price</th><th>Stock</th></tr>");

        for (Medicine medicine : medicines) {
            out.println("<tr>");
            out.println("<td>" + medicine.getId() + "</td>");
            out.println("<td>" + medicine.getName() + "</td>");
            out.println("<td>" + medicine.getManufacturer() + "</td>");
            out.println("<td>" + medicine.getPrice() + "</td>");
            out.println("<td>" + medicine.getStock() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body></html>");
    }
}
