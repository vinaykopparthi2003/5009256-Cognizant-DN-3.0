class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        } else {
            System.out.println("Employee list is full. Cannot add more employees.");
        }
    }

    // Search for an employee by ID
    public Employee searchEmployeeById(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null; // Employee not found
    }

    // Delete an employee by ID
    public boolean deleteEmployeeById(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                // Shift elements to the left to fill the gap
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null; // Remove reference to the last element
                return true; // Employee deleted
            }
        }
        return false; // Employee not found
    }

    // Traverse and print all employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }
}

public class EmployeeManagementSystemDemo {

    public static void main(String[] args) {
        EmployeeManagementSystem empSystem = new EmployeeManagementSystem(5);

        // Adding employees
        empSystem.addEmployee(new Employee(1, "Alice Johnson", "Manager", 85000));
        empSystem.addEmployee(new Employee(2, "Bob Smith", "Developer", 70000));
        empSystem.addEmployee(new Employee(3, "Charlie Brown", "Designer", 65000));
        
        // Traversing employees
        System.out.println("All Employees:");
        empSystem.traverseEmployees();

        // Searching for an employee
        System.out.println("\nSearching for Employee ID 2:");
        Employee emp = empSystem.searchEmployeeById(2);
        System.out.println(emp != null ? emp : "Employee not found");

        // Deleting an employee
        System.out.println("\nDeleting Employee ID 2:");
        boolean deleted = empSystem.deleteEmployeeById(2);
        System.out.println(deleted ? "Employee deleted successfully" : "Employee not found");

        // Traversing employees after deletion
        System.out.println("\nAll Employees After Deletion:");
        empSystem.traverseEmployees();
    }
}
