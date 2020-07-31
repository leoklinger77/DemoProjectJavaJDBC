package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDeparmentDao();

		System.out.println("=== TEST 1: Department findById ====");
		Department dep = departmentDao.findById(2);
		System.out.println(dep);

		System.out.println("\n=== TEST 2: Department findAll ====");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);		
			
		}
		
		System.out.println("\n=== TEST 3: Department delete ====");
		System.out.print("\nEnter id of delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Completed");
		
		
		System.out.println("\n=== TEST 4: Department update ====");
		Department department = departmentDao.findById(1);
		department.setName("KLINGER OLIVEIRA");
		departmentDao.update(department);
		System.out.println("Update Completed");
		
		sc.close();
	}

}
