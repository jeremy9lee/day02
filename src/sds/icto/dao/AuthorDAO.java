package sds.icto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sds.icto.vo.AuthorVo;

public class AuthorDAO {

	public Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Connection con = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		con = DriverManager.getConnection(url, "icto55", "icto55");
		return con;

	}

	public List<AuthorVo> fetch() throws ClassNotFoundException, SQLException {
		List<AuthorVo> list = new ArrayList<AuthorVo>();

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from author";

		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			list.add(new AuthorVo(rs.getInt(1), rs.getString(2), rs
					.getString(3)));
		}

		if (rs != null) {
			rs.close();
		}
		if (pstmt != null) {
			pstmt.close();

		}

		if (con != null) {
			con.close();
		}
		return list;
	}

	public void insertAuthor(AuthorVo vo) throws ClassNotFoundException,
			SQLException {

		Connection con = getConnection();
		PreparedStatement pstmt = null;

		String sql = "insert into author values(seq_author.nextval, ?, ?)";
		// 2. Connection 생성

		pstmt = con.prepareStatement(sql);

		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getBio());

		int count = pstmt.executeUpdate();

		System.out.println(count + "건이 입력되었습니다. ");

		if (pstmt != null) {
			pstmt.close();

		}

		if (con != null) {
			con.close();
		}
	}

}
