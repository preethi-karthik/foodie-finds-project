package FoodieFinds.Model;

public class Category {
	private int CategoryId;
	private String CategoryName;


		public String getCategoryName() {
			return CategoryName;
		}


		public void setCategoryName(String categoryName) {
			CategoryName = categoryName;
		}


		public int getCategoryId() {
			return CategoryId;
		}


		public void setCategoryId(int categoryId) {
			CategoryId = categoryId;
		}
}
