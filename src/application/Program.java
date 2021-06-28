package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException{
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		List<Product> products = new ArrayList<>();
		
		System.out.println("Enter the number of products: ");
		Integer quantity = scan.nextInt();
		
		for(int i = 0; i < quantity; i++) {
			System.out.println("Product #" + (i+1) + " data:");
			System.out.println("Common, used or imported (c/u/i)? ");
			Character option = scan.next().charAt(0);
			Product product;
			
			System.out.println("Name: ");
			String name = scan.next();
			scan.nextLine();
			
			System.out.println("Price: ");
			Double price = scan.nextDouble();
			
			switch (option) {
				case 'i':
					System.out.println("Customs fee: ");
					Double customsFee = scan.nextDouble();
					product = new ImportedProduct(name, price, customsFee);
				break;
				
				case 'u':
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					System.out.println("Manufacture date (DD/MM/YYYY): ");
					Date manufacute = sdf.parse(scan.next());
					product = new UsedProduct(name, price, manufacute);
				break;

				default:
					product = new Product(name, price);
				break;
			}
			
			products.add(product);
		}
		
		
		if(products.size() > 0) {
			System.out.println("PRICE TAGS:");
			for(Product product : products) {
				System.out.println(product.priceTag() + "\n");
			}
		}
		
		scan.close();
	}
}
