package FoodieFinds.Model;

import java.util.ArrayList;

public class Recipe {

private int RecipeId;
private String RecipeName;
private int calories;
private Category category[];
private int prep_time;
private StringBuilder procedure;
private String ImagePath;
private ArrayList<Ingredient> Ingredients;

    public ArrayList<Ingredient> getIngredients() {
        return Ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> Ingredients) {
        this.Ingredients = Ingredients;
    }


public int getRecipeId() {
	
	return RecipeId;
}
public void setRecipeId(int recipeId) {
	RecipeId = recipeId;
}
public String getRecipeName() {
	return RecipeName;
}
public void setRecipeName(String recipeName) {
	RecipeName = recipeName;
}
public int getCalories() {
	return calories;
}
public void setCalories(int calories) {
	this.calories = calories;
}


public Category[] getCategory() {
	return category;
}
public void setCategory(Category category[]) {
	this.category = category;
}
public int getPrep_time() {
	return prep_time;
}
public void setPrep_time(int prep_time) {
	this.prep_time = prep_time;
}
public StringBuilder getProcedure() {
	return procedure;
}
public void setProcedure(StringBuilder procedure) {
	this.procedure = procedure;
}
public String getImagePath() {
	return ImagePath;
}
public void setImagePath(String imagePath) {
	ImagePath = imagePath;
}


   

}
