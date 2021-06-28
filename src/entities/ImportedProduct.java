package entities;

public class ImportedProduct extends Product{
	private Double customsFee;

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	public Double totalPrice() {
		return super.getPrice() + this.getCustomsFee();
	}
	
	@Override
	public String priceTag() {
		StringBuilder strBuilder = new StringBuilder();
		
		return strBuilder
			.append(this.getName())
			.append(" $ ")
			.append(String.format("%.2f", this.totalPrice()))
			.append(" (Customs fee: $ ")
			.append(String.format("%.2f", this.getCustomsFee()))
			.append(")")
			.toString();
	}
}
