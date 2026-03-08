package com.example.employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public void addEmployee(Employee emp) throws SQLException {
        String sql = "INSERT INTO employee(empid, firstname, lastname, primaryskill, location) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, emp.getEmpid());
            ps.setString(2, emp.getFirstname());
            ps.setString(3, emp.getLastname());
            ps.setString(4, emp.getPrimaryskill());
            ps.setString(5, emp.getLocation());
            ps.executeUpdate();
        }
    }

    public List<Employee> listEmployees() throws SQLException {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT empid, firstname, lastname, primaryskill, location FROM employee";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmpid(rs.getString("empid"));
                emp.setFirstname(rs.getString("firstname"));
                emp.setLastname(rs.getString("lastname"));
                emp.setPrimaryskill(rs.getString("primaryskill"));
                emp.setLocation(rs.getString("location"));
                list.add(emp);
            }
        }
        return list;
    }

    public Employee getEmployee(String empid) throws SQLException {
        String sql = "SELECT empid, firstname, lastname, primaryskill, location FROM employee WHERE empid = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, empid);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Employee(
                            rs.getString("empid"),
                            rs.getString("firstname"),
                            rs.getString("lastname"),
                            rs.getString("primaryskill"),
                            rs.getString("location")
                    );
                }
            }
        }
        return null;
    }

    public void updateEmployee(Employee emp) throws SQLException {
        String sql = "UPDATE employee SET firstname=?, lastname=?, primaryskill=?, location=? WHERE empid=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, emp.getFirstname());
            ps.setString(2, emp.getLastname());
            ps.setString(3, emp.getPrimaryskill());
            ps.setString(4, emp.getLocation());
            ps.setString(5, emp.getEmpid());
            ps.executeUpdate();
        }
    }

    public void deleteEmployee(String empid) throws SQLException {
        String sql = "DELETE FROM employee WHERE empid = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, empid);
            ps.executeUpdate();
        }
    }
}
