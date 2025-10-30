import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    Scanner sc = new Scanner(System.in);
    Connection conn = DbConnection.getConnection();

    public Employee() {
        conn = DbConnection.getConnection();

    }

    // TAKING INPUT OF EMPLOYEE DETAILS FROM USER

    public void takeEmployeeDetailsFromUser() {
        System.out.println("Enter Employee ID: ");
        this.id = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.println("Enter Employee Name: ");
        this.name = sc.nextLine();
        System.out.println("Enter Employee Department: ");
        this.department = sc.nextLine();
        System.out.println("Enter Employee Salary: ");
        this.salary = sc.nextDouble();
    }

    // CREATE NEW EMPLOYEE
    public void addEmployee() {
        String query = "INSERT INTO employee_table (id,employee_name, department, salary) VALUES (?,?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query);) {
            takeEmployeeDetailsFromUser();
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, department);
            ps.setDouble(4, salary);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee added successfully!");
            } else {
                System.out.println("Failed to add employee.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // DELETE EMPLOYEE
    public void deleteEmployee() {
        System.out.println("Enter Employee ID to delete: ");
        int empId = sc.nextInt();
        sc.nextLine(); // Consume newline
        String DELETE_QUERY = "DELETE FROM employee_table WHERE id=?";

        try (PreparedStatement ps = conn.prepareStatement(DELETE_QUERY);) {
            ps.setInt(1, empId);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("No employee found with the given ID.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // UPDATE EMPLOYEE SALARY
    public void updateEmployeeSalary() {

        System.out.println("Enter Employee ID to update salary: ");
        int empId = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.println("Enter new Salary: ");
        double newSalary = sc.nextDouble();
        String UPDATE_QUERY = "UPDATE employee_table SET salary=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_QUERY);) {
            ps.setDouble(1, newSalary);
            ps.setInt(2, empId);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee salary updated successfully!");
            } else {
                System.out.println("No employee found with the given ID.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // VIEW ALL EMPLOYEES
    public void getAllEmployees() {
        String SELECT_QUERY = "SELECT * FROM employee_table";
        try (PreparedStatement ps = conn.prepareStatement(SELECT_QUERY);) {
            var rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("employee_name")
                        + ", Department: " + rs.getString("department") + ", Salary: " + rs.getDouble("salary"));
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
