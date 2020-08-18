package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.ImportedProduct;
import model.entities.Product;
import model.entities.UsedProduct;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> products = new ArrayList<Product>();
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Product #" + i + " data");
			System.out.print("Common, used or imported (c/u/i)? ");
			char result = sc.next().charAt(0);
			sc.nextLine();
			if (result == 'c') {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				Product product = new Product(name, price);
				products.add(product);
			}
			else if (result == 'i') {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("Customs fee: ");
				double customFee = sc.nextDouble();
				Product importedProduct = new ImportedProduct(name, price, customFee);
				products.add(importedProduct);
			}
			else if (result == 'u') {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				Product usedProduct = new UsedProduct(name, price, manufactureDate);
				products.add(usedProduct);
			}
			else {
				System.out.println("It's just 'c', 'u' or 'i'!!!");
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product x : products) {
			System.out.println(x);
		}
		
		sc.close();
		
	}
}