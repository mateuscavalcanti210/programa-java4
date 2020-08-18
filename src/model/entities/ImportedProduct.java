package model.entities;

public class ImportedProduct extends Product {
	
	private Double customFee;
	
	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customFee) {
		super(name, price);
		this.customFee = customFee;
	}

	public Double getCustomFee() {
		return customFee;
	}

	public void setCustomFee(Double customFee) {
		this.customFee = customFee;
	}
	
	@Override
	public String priceTag() {
		return "$ " + String.format("%.2f", price+customFee);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + " ");
		sb.append(priceTag());
		sb.append(" (Customs fee: $ ");
		sb.append(String.format("%.2f", customFee) + ")");
		return sb.toString();
	}
	
}
