package FoodieFinds.Model;

public class Ingredient {
	private int IngredientId;
	private String IngredientName;
        private String Quantity;
        
	public int getIngredientId() {
		return IngredientId;
	}
	public void setIngredientId(int ingredientId) {
		IngredientId = ingredientId;
	}
	public String getIngredientName() {
		return IngredientName;
	}
	public void setIngredientName(String ingredientName) {
		IngredientName = ingredientName;
	}

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }
      
        
}
