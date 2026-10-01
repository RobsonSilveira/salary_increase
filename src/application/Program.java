package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("\nHow many employees will be registered? ");
		int  numOfEmployees = sc.nextInt();
		
		List<Employee> list = new ArrayList<>();

		for (int i = 1; i <= numOfEmployees; i++) {
		    list.add(createEmployee(sc, list, i));
		}
		increaseEmployeeSalary(sc, list);
		printEmployeeList(list);
		sc.close();
	}
	
	public static Employee findEmployeeById(List<Employee> employeeList, int id) {
		return employeeList.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
	}

	public static void increaseEmployeeSalary(Scanner sc, List<Employee> employeeList) {
		System.out.print("\nEnter the employee id that will have salary increase: ");
		int employeeId = sc.nextInt();
		Employee employee = findEmployeeById(employeeList,employeeId);
		if (employee != null) {
			System.out.print("Enter the percentage: ");
			double increasePercentage = sc.nextDouble();
			employee.increaseSalary(increasePercentage);
		}else {
			System.out.print("This id does not exist!\n");	
		}

	}

	public static void printEmployeeList(List<Employee> employeeList) {
		System.out.println("\nList of employees: ");
		for (Employee employee : employeeList) {
		    employee.printEmployeeData();
		}
	}	

	public static Employee createEmployee(Scanner sc, List<Employee> employeeList, int position) {
		String name;
		double salary;
		System.out.println("\nEmployee #" + position);
		System.out.print("Id: ");
		int id = sc.nextInt();

		Employee employee = findEmployeeById(employeeList, id);
		
		while (employee != null) {
			System.out.print("Id existente, informe outro: ");
			id = sc.nextInt();
			employee = findEmployeeById(employeeList, id);
		}

		System.out.print("Name: ");
		name = sc.next();
		System.out.print("Salary: ");
		salary = sc.nextDouble();

		return new Employee(id, name, salary);
	}

}
