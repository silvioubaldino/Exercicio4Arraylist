package application;

import java.util.List;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println("");

		List<Employee> employees = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			System.out.println("Employess #" + (i + 1) + ": ");
			System.out.print("Id: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			System.out.println("");
			employees.add(new Employee(id, name, salary));
			
		}

		System.out.print("Enter the employee id that will have salary increase:  ");
		int idToIncrease = sc.nextInt();
		
		Employee employeeToIncrease = null;
		for (Employee each : employees) {
			if (each.getId() == idToIncrease) {
				employeeToIncrease = each;
				System.out.print("Enter the percentage: ");
				double percentage = sc.nextDouble();
				employeeToIncrease.increaseSalary(percentage);

			} 
		}
		if(employeeToIncrease == null) {
			System.out.println("This id does not exist!");
		}
		System.out.println("");
		System.out.println("List of Employees: ");
		for (Employee each : employees) {
			System.out.println(each.getId() + ", " + each.getName() + ", " + String.format("%.2f" , each.getSalary()));
		}

		sc.close();
	}

}
