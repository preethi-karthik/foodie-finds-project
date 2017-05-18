package FoodieFinds.Controller;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import FoodieFinds.Interface.RecipeRepositoryInterface;

import FoodieFinds.Model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
@RequestMapping("/Recipe")
public class RecipeController {
RecipeRepositoryInterface RecipeRepository;
	@Autowired
	public RecipeController(RecipeRepositoryInterface recipeRepositoryInterface)
	{
		RecipeRepository = recipeRepositoryInterface;
	}
	
	 @RequestMapping(method = RequestMethod.GET )
	 @ResponseBody
	public ArrayList<Recipe> getAllRecipe()
	{
		
            return RecipeRepository.getAllRecipe();
		
	}
	 @RequestMapping(method = RequestMethod.GET,params = { "RecipeId" } )
	 @ResponseBody

	public Recipe getRecipeById(@RequestParam("RecipeId") int RecipeId )
	{
		return RecipeRepository.getRecipeById(RecipeId);
		
	}
	 @RequestMapping(method = RequestMethod.GET,params = { "CategoryToSearch", "IngredientToSearch"} )
	 @ResponseBody
	 
	public ArrayList<Recipe> FilterRecipe(@RequestParam("CategoryToSearch")ArrayList<Integer> CategoryToSearch ,
			@RequestParam("IngredientToSearch")ArrayList<Integer> IngredientToSearch)
	{
		return RecipeRepository.FilterRecipe(CategoryToSearch,IngredientToSearch);
		
	}
	
}

