// Written by Toni Huffman
// 2/15/2017

package edu.seminolestate.manageparts;

public class ManufacturedPart extends Part {
	
	private double laborCost;//cost to make part 
	private double materialCost;//amount of material in product
	public static final double DEFAULT_LABOR_COST = 0;
	public static final double DEFAULT_MATERIAL_COST = 0;
	
	// Constructors
	public ManufacturedPart(int id) {
		this(id,DEFAULT_DESCRIPTION,DEFAULT_SELL_PRICE,DEFAULT_LABOR_COST,DEFAULT_MATERIAL_COST);
	}
	
	public ManufacturedPart(int id, double lCost, double mCost) {
		this(id, DEFAULT_DESCRIPTION,DEFAULT_SELL_PRICE,lCost,mCost);
	}
	
	public ManufacturedPart(int id, String desc, double sellPrice, double lCost, double mCost) {
		super(id, desc, sellPrice);
		
		// Labor cost can't be negative
		if (lCost >= 0) {
			setLaborCost(lCost);
		} else {
			setLaborCost(DEFAULT_LABOR_COST);
		}
		
		// Material cost can't be negative
		if (mCost >= 0) {
			setMaterialCost(mCost);
		} else {
			setMaterialCost(DEFAULT_MATERIAL_COST);
		}
	}
	
	// Labor Cost Getter and Setter
	public double getLaborCost() {
		return laborCost;
	}
	public void setLaborCost(double newLaborCost) {
		// Only set if positive
		if (newLaborCost >= 0) {
			laborCost = newLaborCost;
		}
	}
	
	// Material Cost Getter and Setter
	public double getMaterialCost() {
		return materialCost;
	}
	public void setMaterialCost(double newMaterialCost) {
		// Only set if positive
		if (newMaterialCost >= 0) {
			materialCost = newMaterialCost;
		}
	}
	
	// toString
	@Override
	public String toString() {
		return super.toString() + " " + this.getClass() + " [laborCost=" + getLaborCost() + ", materialCost=" + getMaterialCost() + "]";
	}
	
	// Total Cost
	@Override
	public double getTotalCost() {
		return super.getTotalCost() + getMaterialCost() + getLaborCost();
	}
}
