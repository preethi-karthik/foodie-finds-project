package FoodieFinds.Repository;

import java.util.ArrayList;

import FoodieFinds.Interface.RecipeRepositoryInterface;
import FoodieFinds.Model.Ingredient;
import FoodieFinds.Model.Recipe;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Repository;

@Repository
public class RecipeRepository implements RecipeRepositoryInterface {

private DataSource dataSource;
    
    public RecipeRepository(){
      dataSource = getDataSource();
    }
	/* (non-Javadoc)
	 * @see project1.Repositary.RecipeRepositoryInterface#getAllRecipe()
	 */
     public DataSource getDataSource() {
		return  DataSourceBuilder.create().username("root").password("******")
        .url("jdbc:mysql://localhost:3306/FoodieFinds?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")
        .driverClassName("com.mysql.jdbc.Driver")
        .build();
             
	}
	@Override
	public ArrayList<Recipe> getAllRecipe() {
		// TODO Auto-generated method stub
                String sql = "SELECT rec.RecipeId,rec.RecipeName,rec.Calories,rec.Prep_time,rec.procedure FROM FoodieFinds.Recipe rec; ";

		Connection conn = null;

		try {
                        
			conn = dataSource.getConnection();
                        
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
                        ArrayList<Recipe> RecipeArrayList;
                        RecipeArrayList = new ArrayList<Recipe>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
                            Recipe recipe = new Recipe();
                            	recipe.setRecipeId(rs.getInt("RecipeId"));
				recipe.setRecipeName(rs.getString("RecipeName"));
                                recipe.setCalories(rs.getInt("Calories"));
                                recipe.setPrep_time(rs.getInt("Prep_time"));
                                recipe.setProcedure(new StringBuilder(rs.getString("procedure")));                              
                            RecipeArrayList.add(recipe);
			}         
			rs.close();
			ps.close();
			return RecipeArrayList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	/* (non-Javadoc)
	 * @see project1.Repositary.RecipeRepositoryInterface#getRecipeById(int)
	 */
	@Override
	public Recipe getRecipeById(int recipeId) {
		
            
		String sql = "SELECT rec.RecipeId,rec.RecipeName,rec.Calories,rec.Prep_time,rec.procedure FROM FoodieFinds.Recipe rec WHERE rec.RecipeId= ? ;";
String sql2 = "SELECT IngredientId,IngredientName ,Quantity from FoodieFinds.Ingedient INNER JOIN\n" +
" IngedientRecipeMapping ON IngredientId = Ingedient_IngredientId WHERE Recipe_RecipeId =?;";
		Connection conn = null;

		try {
                         DataSource dataSource =getDataSource();
			conn = dataSource.getConnection();
                        
			PreparedStatement ps = conn.prepareStatement(sql);
                        
                        
                        ps.setInt(1, recipeId);
                       
                        Recipe recipe = new Recipe();
                        
                        
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
                           
                            	recipe.setRecipeId(rs.getInt("RecipeId"));
				recipe.setRecipeName(rs.getString("RecipeName"));
                                recipe.setCalories(rs.getInt("Calories"));
                                recipe.setPrep_time(rs.getInt("Prep_time"));
                                recipe.setProcedure(new StringBuilder(rs.getString("procedure")));                              
                           
			}  
                        
                        PreparedStatement ps2 = conn.prepareStatement(sql2);
                         ps2.setInt(1, recipeId);
                        ResultSet rs2 = ps2.executeQuery();
                        
                          ArrayList<Ingredient> IngredientList;
                        IngredientList = new ArrayList<Ingredient>(); 
                         
			while (rs2.next()) {
                          Ingredient ing = new Ingredient();
                       ing.setIngredientId(rs2.getInt("IngredientId"));
                         ing.setIngredientName(rs2.getString("IngredientName"));
                         ing.setQuantity(rs2.getString("Quantity"));
                         IngredientList.add(ing);
				                         
                           
			}  
                        recipe.setIngredients(IngredientList);
                        
			rs.close();
			ps.close();
                        rs2.close();
			ps2.close();
			return recipe;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}



	/* (non-Javadoc)
	 * @see project1.Repositary.RecipeRepositoryInterface#FilterRecipe(java.util.ArrayList, java.util.ArrayList, java.lang.String)
	 */
	@Override
	public ArrayList<Recipe> FilterRecipe(ArrayList<Integer> categoryToSearch,
			ArrayList<Integer> ingredientToSearch) {
          
  String categoryPlaceholder =getPlaceholder(categoryToSearch);
  String IngredientPlaceholder=getPlaceholder(ingredientToSearch);
            
 String sql = "SELECT DISTINCT rec.RecipeID, rec.RecipeName,rec.Calories,rec.Prep_time,rec.procedure \n" +
"FROM FoodieFinds.Recipe rec  LEFT OUTER JOIN FoodieFinds.IngedientRecipeMapping  \n" +
"ON rec.RecipeID = Recipe_RecipeId \n" +
"LEFT OUTER JOIN FoodieFinds.CategoryRecipeMapping  catmap ON rec.RecipeID = catmap.Recipe_RecipeId\n" +
"WHERE Ingedient_IngredientId  IN "+IngredientPlaceholder+"  &&  catmap.Category_CategoryId IN "
         + categoryPlaceholder+";";

		Connection conn = null;

		try {
                         DataSource dataSource =getDataSource();
			conn = dataSource.getConnection();
                        
			PreparedStatement ps = conn.prepareStatement(sql);
                      
                        int paramNum =1;
                        
                        for(int ingId : ingredientToSearch){
                        ps.setInt(paramNum++,ingId);
                      }
                        for(int catId : categoryToSearch){
                        ps.setInt(paramNum++,catId);
                      }


                        ArrayList<Recipe> FilterRecipeArrayList;
                        FilterRecipeArrayList = new ArrayList<Recipe>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
                            Recipe recipe = new Recipe();
                            	recipe.setRecipeId(rs.getInt("RecipeId"));
				recipe.setRecipeName(rs.getString("RecipeName"));
                                recipe.setCalories(rs.getInt("Calories"));
                                recipe.setPrep_time(rs.getInt("Prep_time"));
                                recipe.setProcedure(new StringBuilder(rs.getString("procedure")));                              
                            FilterRecipeArrayList.add(recipe);
			}         
			rs.close();
			ps.close();
			return FilterRecipeArrayList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}

        
        private String getPlaceholder (ArrayList<Integer> list) 
        {
            String temp ="(";
            for(int i=0;i<list.size();i++)
                {
                    temp+=",?";
                }
            if(list.size() == 0){
                temp+="1=1";
            }
                temp=temp.replaceFirst(",","");
                temp+=")";
            return temp;

}

}
