package com.example.employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/edit")
public class UpdateEmployeeServlet extends HttpServlet {
    private final EmployeeDAO dao = new EmployeeDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empid = req.getParameter("empid");
        try {
            Employee emp = dao.getEmployee(empid);
            req.setAttribute("employee", emp);
            req.getRequestDispatcher("updateEmployee.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empid = req.getParameter("empid");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String primaryskill = req.getParameter("primaryskill");
        String location = req.getParameter("location");

        Employee emp = new Employee(empid, firstname, lastname, primaryskill, location);
        try {
            dao.updateEmployee(emp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
        resp.sendRedirect(req.getContextPath() + "/view");
    }
}
