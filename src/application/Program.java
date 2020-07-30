package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TEST 1: Seller findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n=== TEST 2: Seller findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);

		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== TEST 3: Seller findall ====");

		list = sellerDao.findAll();

		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== TEST 4: Seller insert ====");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Seller newSeller = new Seller(null, "Lydia", "lydia@gmail.com", sdf.parse("07/08/1995"), 2000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("INserted! New id = " + newSeller.getId());

		
		System.out.println("\n=== TEST 5: Seller update ====");
		seller = sellerDao.findById(1);
		seller.setName("KLINGER OLIVEIRA");
		sellerDao.update(seller);
		System.out.println("Update Completed");
	}

}
