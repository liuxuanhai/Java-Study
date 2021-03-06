import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Test {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO 自动生成的方法存根
		test();
	}

	public static void test() throws SQLException, ClassNotFoundException {
		//1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2.建立连接
		String url = "jdbc:mysql://localhost:3306/db_jdbc";
		String username = "root";
		String password = "root";
		Connection conn = (Connection) DriverManager.getConnection(url, username, password);
		
		//3.创建语句
		Statement st = (Statement) conn.createStatement();
		
		//4.执行查询语句
		ResultSet rs = st.executeQuery("select * from t_user");
		
		//5.处理结果
		while (rs.next()) {
			for (int i = 1; i <= 4; i++) 
				System.out.print(rs.getObject(i)+"  ");
			System.out.println("");
		}
		
		//6.释放资源
		rs.close();
		st.close();
		conn.close();
	}
}
