/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FoodieFinds.Controller;

import FoodieFinds.Model.Category;
import FoodieFinds.Repository.CategoryRepository;
import java.util.ArrayList;
import java.util.Arrays;
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
public class CategoryControllerTest {
    
     CategoryRepository mockedCategoryRepo ;
     ArrayList<Category> Result = new ArrayList<Category>();
    public CategoryControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       mockedCategoryRepo = mock (CategoryRepository.class);
       Category  category1 = new Category();
        Category  category2 = new Category();
        
        category1.setCategoryId(1);
        category1.setCategoryName("Vegan");
        category2.setCategoryId(2);
        category1.setCategoryName("chinese");
        Result.add(category1);
        Result.add(category2);
        when (mockedCategoryRepo.getAllCategories()).thenReturn(Result);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllCategories method, of class CategoryController.
     */
    @Test
    public void testGetAllCategories() {
        
        System.out.println("getAllCategories");
        CategoryController instance = new CategoryController(mockedCategoryRepo);
        ArrayList<Category> expResult = Result;
        ArrayList<Category> Mresult = instance.getAllCategories();
        assertEquals(expResult, Mresult);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
