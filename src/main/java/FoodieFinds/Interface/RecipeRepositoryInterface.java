package FoodieFinds.Interface;

import java.util.ArrayList;


import FoodieFinds.Model.Recipe;

public interface RecipeRepositoryInterface {
	ArrayList<Recipe> getAllRecipe();

	Recipe getRecipeById(int recipeId);

	ArrayList<Recipe> FilterRecipe(ArrayList<Integer> categoryToSearch, ArrayList<Integer> ingredientToSearch);
}
