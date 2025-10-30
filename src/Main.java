import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("======= Welcome to the Employee Management System  =======");
      
    //   employee object
        Employee emp = new Employee();

        String reapetMenu;

        do {
            int choice;
            System.out.println("Choose an option:");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee Salary");
            System.out.println("3. View All Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    emp.addEmployee();
                    break;
                case 2:
                    emp.updateEmployeeSalary();
                    break;
                case 3:
                    emp.getAllEmployees();
                    break;
                case 4:
                    emp.deleteEmployee();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println("Do you want to perform another operation? (yes/no): ");
            reapetMenu = sc.next();
        } while (reapetMenu.equalsIgnoreCase("yes"));

    }
}
