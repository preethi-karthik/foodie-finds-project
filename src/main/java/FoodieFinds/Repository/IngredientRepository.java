package FoodieFinds.Repository;

import java.util.ArrayList;

import FoodieFinds.Interface.IngredientRepositoryInterface;
import FoodieFinds.Model.Ingredient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Repository;


@Repository
public class IngredientRepository implements IngredientRepositoryInterface  {

    
    private DataSource dataSource;
    
    public IngredientRepository(){
      dataSource = getDataSource();
    }
   
   
	public DataSource getDataSource() {
		return  DataSourceBuilder.create().username("root").password("******")
        .url("jdbc:mysql://localhost:3306/FoodieFinds?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")
        .driverClassName("com.mysql.jdbc.Driver")
        .build();
             
	}
	@Override
	public ArrayList<Ingredient> getAllIngredient() {
		// TODO Auto-generated method stub
                String sql = "SELECT IngredientId,IngredientName FROM FoodieFinds.Ingedient; ";

		Connection conn = null;

		try {
                         
			conn = dataSource.getConnection();
                        
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
                        ArrayList<Ingredient> IngredientArrayList;
                        IngredientArrayList = new ArrayList<Ingredient>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
                            Ingredient Ingredient = new Ingredient();
                            	Ingredient.setIngredientId(rs.getInt("IngredientId"));
				Ingredient.setIngredientName(rs.getString("IngredientName"));	
                            IngredientArrayList.add(Ingredient);
			}
                        
			rs.close();
			ps.close();
			return IngredientArrayList;
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
		
	}


