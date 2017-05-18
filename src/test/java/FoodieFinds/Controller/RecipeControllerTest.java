/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FoodieFinds.Controller;

import FoodieFinds.Model.Category;
import FoodieFinds.Model.Ingredient;
import FoodieFinds.Model.Recipe;
import FoodieFinds.Repository.IngredientRepository;
import FoodieFinds.Repository.RecipeRepository;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author preethi
 */
public class RecipeControllerTest {
     RecipeRepository mockedRecipeRepo ;
     ArrayList<Recipe> Result = new ArrayList<Recipe>();
       ArrayList <Integer > categoryToSearch = new ArrayList <Integer >();
        ArrayList <Integer > ingredientToSearch = new ArrayList <Integer >();
          Recipe Recipe1 = new Recipe();
        Recipe  Recipe2 = new Recipe();
    public RecipeControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         mockedRecipeRepo = mock (RecipeRepository.class);
     
        
        Recipe1.setRecipeId(1); 
        Recipe1.setRecipeName("tomato soup");
        Recipe1.setCalories(150);
        Recipe1.setPrep_time(90);
        Recipe1.setProcedure(new StringBuilder("test1"));
        
        Recipe2.setRecipeId(2); 
        Recipe2.setRecipeName(" juice");
        Recipe2.setCalories(240);
        Recipe2.setPrep_time(110);
        Recipe2.setProcedure(new StringBuilder("test2"));
        Result.add(Recipe1);
        Result.add(Recipe2);
        
        
categoryToSearch.add(1);
categoryToSearch.add(2);
ingredientToSearch.add(1);
ingredientToSearch.add(2);
        when (mockedRecipeRepo.getAllRecipe()).thenReturn(Result);
        when (mockedRecipeRepo.getRecipeById(1)).thenReturn(Recipe1);
        when (mockedRecipeRepo.FilterRecipe(categoryToSearch, ingredientToSearch)).thenReturn(Result);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllRecipe method, of class RecipeController.
     */
    @Test
    public void testGetAllRecipe() {
        System.out.println("getAllRecipe");
        RecipeController instance = new RecipeController(mockedRecipeRepo) ;
        ArrayList<Recipe> expResult = Result;
        ArrayList<Recipe> result = instance.getAllRecipe();
        assertEquals(expResult, result);
       
        
    }

    /**
     * Test of getRecipeById method, of class RecipeController.
     */
    @Test
    public void testGetRecipeById() {
        System.out.println("getRecipeById");
        int RecipeId = 1;
        RecipeController instance = new RecipeController(mockedRecipeRepo) ;
        Recipe expResult = Recipe1;
        Recipe result = instance.getRecipeById(RecipeId);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of FilterRecipe method, of class RecipeController.
     */
    @Test
    public void testFilterRecipe() {
        System.out.println("FilterRecipe");
        RecipeController instance = new RecipeController(mockedRecipeRepo) ;
        ArrayList<Recipe> expResult = Result;
        ArrayList<Recipe> result = instance.FilterRecipe(categoryToSearch, ingredientToSearch);
        assertEquals(expResult, result);
        
    }
    
}
