import java.sql.SQLException;
import java.util.ArrayList;

import sds.icto.dao.AuthorDAO;
import sds.icto.vo.AuthorVo;


public class AuthorTest {

	public static void main(String[] args)  {
		try {
			insertTest();
			getAllList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void insertTest() throws ClassNotFoundException, SQLException{
		
		AuthorDAO  dao = new AuthorDAO();
		
		AuthorVo vo = new AuthorVo();
		vo.setName("장자");
		vo.setBio("");
	dao.insertAuthor(vo);
		
//		AuthorVo vo2 = new AuthorVo();
//		vo2.setName("순자");
//		vo2.setBio("");
//		dao.insertAuthor(vo2);
	}
	
	public static void getAllList() throws ClassNotFoundException, SQLException{
		
		AuthorDAO dao = new AuthorDAO();
		
		ArrayList<AuthorVo> list =	(ArrayList<AuthorVo>) dao.fetch();
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		
		System.out.println(list.size());
	}
}
