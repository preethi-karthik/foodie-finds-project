package FoodieFinds.Controller;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import FoodieFinds.Interface.CategoryRepositoryInterface;
import FoodieFinds.Model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/Categories")
public class CategoryController {
	CategoryRepositoryInterface CategoryRepository ;
        @Autowired
	public CategoryController(CategoryRepositoryInterface categoryRepositoryInterface)
	{
		 CategoryRepository = categoryRepositoryInterface ;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ArrayList<Category> getAllCategories()
	{
		
		return CategoryRepository.getAllCategories();
		
	}
        
  
	
}
