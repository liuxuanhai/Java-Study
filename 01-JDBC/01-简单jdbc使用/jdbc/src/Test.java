import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO �Զ����ɵķ������
		test();
	}

	public static void test() throws SQLException {
		//1.ע������
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		//2.��������
		Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_student", "root", "root");
		
		//3.�������
		Statement st = (Statement) conn.createStatement();
		
		//4.ִ�в�ѯ���
		ResultSet rs = st.executeQuery("select * from t_student");
		
		//5.������
		while (rs.next()) {
			for (int i = 1; i <= 4; i++) 
				System.out.print(rs.getObject(i)+"  ");
			System.out.println("");
		}
		
		//6.�ͷ���Դ
		rs.close();
		st.close();
		conn.close();
	}
}
