
import java.util.ArrayList;
import java.util.Scanner;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }
}


//class fullTimeEmployee extending the Employee class.
class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

// class partTimeEmployee extending the Employee class.
class PartTimeEmployee extends Employee {

    // declaring all the attributes.
	private int hoursWorked;
	private double hourlyRate;


    // Constructor for the partTimeEmployee
	public PartTimeEmployee(String name,int id,int hoursWorked,double hourlyRate) {
		super(name,id);
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
	}
	
	@Override
	public double calculateSalary() {
		return hoursWorked*hourlyRate;
	}
}


class PayrollSystem {
	private ArrayList<Employee> employeeList ;
	
//	Constructor to initialize all the ArrayList.
	public PayrollSystem() {
		employeeList = new ArrayList<>();
	}
	
//	Will be adding the employee object in the arrayList.
	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}
	
	
//	Method to remove the employee from the list. The employee id to be removed will be given as the parameter.
	public void removeEmployee(int id) {
		Employee employeeToRemove = null;
		for(Employee employee:employeeList) {
			if(employee.getId() == id) {
				employeeToRemove = employee;
				break;
			}
		}
        if(employeeToRemove!=null) {
            employeeList.remove(employeeToRemove);
        }
        else {
            System.out.println("Employee doesn't exist. Please Enter a Valid ID.");
        }
	}
	
//	Function to display all the employees.
	public void displayEmployees() {
		for(Employee employee: employeeList) {
			System.out.println(employee);
		}
	}
}

public class Main {
	public static void main(String[] args) {
		PayrollSystem payrollSystem = new PayrollSystem();
		FullTimeEmployee emp1 = new FullTimeEmployee("Vikas",1,70000.0);
		PartTimeEmployee emp2 = new PartTimeEmployee("Alexander",2,40,100); 
		
		
//		Accessing the payroll system to add the employees in the employeeList.
		payrollSystem.addEmployee(emp1);
		payrollSystem.addEmployee(emp2);
		System.out.println("Initial Employee Details: ");
		payrollSystem.displayEmployees();
		
		
		System.out.println("Removing Employees : ");

        // Takes the input for which employee to remove among all the employees that are present.
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        sc.close();
		payrollSystem.removeEmployee(id);
		System.out.println("Remaining Employee Details: ");
		payrollSystem.displayEmployees();
	}
}