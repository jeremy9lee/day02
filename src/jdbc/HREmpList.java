package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HREmpList {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		
		String name = sc.nextLine();
		

		try {
			// 1. 드라이브 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 생성
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			conn = DriverManager.getConnection(url, "hr", "hr");

			// 3. PrepareStatement 준비

			// 4. SQL문 날리기
			String sql = "select first_name, email, phone_number, hire_date from employees "
					+ "WHERE first_name LIKE ? OR last_name LIKE ? ";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+name+"%");
			stmt.setString(2, "%"+name+"%");
			rs = stmt.executeQuery();

			// 5. 결과출력
			while (rs.next()) {
				System.out.println("name : " + rs.getString(1) + " "
						+ rs.getString(2)+" : "+rs.getString(3)+" : "+rs.getString(4));
			}

		} catch (ClassNotFoundException e) {
			System.out.println("oracle library 가 없습니다.");
		} catch (SQLException e) {
			System.out.println("DB 연결에 실패했습니다.");
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
