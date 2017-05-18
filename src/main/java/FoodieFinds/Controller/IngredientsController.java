package FoodieFinds.Controller;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import FoodieFinds.Interface.IngredientRepositoryInterface;
import FoodieFinds.Model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/Ingredient")
public class IngredientsController {
	IngredientRepositoryInterface IngredientRepository;
@Autowired
	public IngredientsController(IngredientRepositoryInterface ingredientRepositoryInterface)
	{
		IngredientRepository = ingredientRepositoryInterface ;
	}
	   @RequestMapping(method = RequestMethod.GET )
	 @ResponseBody
		public ArrayList<Ingredient> GetAllIngredient()
		{
			return IngredientRepository.getAllIngredient();
			
		}
		
}
