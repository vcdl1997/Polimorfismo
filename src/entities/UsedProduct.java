package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{
	private Date manufactureDate;

	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public String getManufactureDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		return sdf.format(this.manufactureDate);
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	@Override
	public String priceTag() {
		StringBuilder strBuilder = new StringBuilder();
		
		return strBuilder
			.append(this.getName())
			.append(" $ ")
			.append(String.format("%.2f", super.getPrice()))
			.append(" (Manufacture date: ")
			.append(this.getManufactureDate())
			.append(")")
			.toString();
	}
}
