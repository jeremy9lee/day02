package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HRSalary {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("월급[min max]>");

		int minSalary = scanner.nextInt();
		int maxSalary = scanner.nextInt();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select first_name||' '||last_name, salary"
				+ " from employees" + " where salary < ? and salary >?"
				+ " order by salary";
		// 2. Connection 생성
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		try {
			conn = DriverManager.getConnection(url, "hr", "hr");
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, maxSalary);
			pstmt.setInt(2, minSalary);

			rs = pstmt.executeQuery();

			int count = 0;
			while (rs.next()) {
				System.out.println(rs.getString(1) + " \t\t" + rs.getInt(2));
				count++;
			}
			System.out.println(count + "건이 검색되었습니다. ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
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
		scanner.close();

	}
}
