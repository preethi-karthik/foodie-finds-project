/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FoodieFinds.Controller;

import FoodieFinds.Model.Category;
import FoodieFinds.Model.Ingredient;
import FoodieFinds.Repository.CategoryRepository;
import FoodieFinds.Repository.IngredientRepository;
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
public class IngredientsControllerTest {
    IngredientRepository mockedIngredientRepo ;
     ArrayList<Ingredient> Result = new ArrayList<Ingredient>();
    public IngredientsControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        mockedIngredientRepo = mock (IngredientRepository.class);
       Ingredient Ingredient1 = new Ingredient();
        Ingredient  Ingredient2 = new Ingredient();
        
        Ingredient1.setIngredientId(1);
        Ingredient1.setIngredientName("tomato");
        Ingredient2.setIngredientId(2);
        Ingredient2.setIngredientName("onion");
        Result.add(Ingredient1);
        Result.add(Ingredient2);
        when (mockedIngredientRepo.getAllIngredient()).thenReturn(Result);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of GetAllIngredient method, of class IngredientsController.
     */
    @Test
    public void testGetAllIngredient() {
        System.out.println("GetAllIngredient");
        IngredientsController instance = new IngredientsController(mockedIngredientRepo) ;
        ArrayList<Ingredient> expResult = Result;
        ArrayList<Ingredient> result = instance.GetAllIngredient();
        assertEquals(expResult, result);
       
    }
    
}
