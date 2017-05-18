package FoodieFinds.Repository;

import java.util.ArrayList;

import FoodieFinds.Interface.CategoryRepositoryInterface;
import FoodieFinds.Model.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository implements CategoryRepositoryInterface  {
private DataSource dataSource;
    
    public CategoryRepository(){
      dataSource = getDataSource();
    }
	/* (non-Javadoc)
	 * @see project1.Repositary.CategoryRepositoryInterface#getAllCategories()
	 */
    public DataSource getDataSource() {
		return  DataSourceBuilder.create().username("root").password("******")
        .url("jdbc:mysql://localhost:3306/FoodieFinds?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")
        .driverClassName("com.mysql.jdbc.Driver")
        .build();
             
	}
	@Override
	public ArrayList<Category> getAllCategories() {
		
		// TODO Auto-generated method stub
                String sql = "SELECT CategoryId,CategoryName FROM FoodieFinds.Category;";

		Connection conn = null;

		try {
                        
			conn = dataSource.getConnection();                        
			PreparedStatement ps = conn.prepareStatement(sql);			
                        ArrayList<Category> CategoryArrayList;
                        CategoryArrayList = new ArrayList<Category>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
                            Category Category = new Category();
                            	Category.setCategoryId(rs.getInt("CategoryId"));
				Category.setCategoryName(rs.getString("CategoryName"));	
                            CategoryArrayList.add(Category);
			}
                        
			rs.close();
			ps.close();
			return CategoryArrayList;
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

	


