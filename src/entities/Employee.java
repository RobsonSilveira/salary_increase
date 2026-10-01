package entities;

public class Employee {

	private int id;
	private String name;
	private double salary;

	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	private void setSalary(double salary) {
		this.salary = salary;
	}

	public void increaseSalary(double percentage) {
		salary += salary * percentage / 100;
	}

	public void printEmployeeData() {
		System.out.printf("%d, %s, %.2f%n", id, name, salary);
	}
}
