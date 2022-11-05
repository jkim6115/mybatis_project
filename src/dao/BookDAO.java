package dao;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.BookDTO;

public class BookDAO {
	private SqlSession session;
	
	public BookDAO() {
		String resource = "config/configuration.xml";
		
		try (Reader reader = Resources.getResourceAsReader(resource)) {
			SqlSessionFactoryBuilder sqlBuilder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = sqlBuilder.build(reader);
			session = factory.openSession(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<BookDTO> listMethod() {
		return session.selectList("book.list");
	}
	
	public int insertMethod(BookDTO dto) {
		int chk = -1;
		chk = session.insert("book.bookInsert", dto);
		return chk;
	}
	
	public int updateMethod(HashMap<String, Object> hmap) {
		int chk = -1;
		chk = session.update("book.bookUpdate", hmap);
		return chk;
	}
	
	public int deleteMethod(int num) {
		int chk = -1;
		chk = session.delete("book.bookDelete", num);
		return chk;
	}
	
	public List<BookDTO> searchMethod(String data) {
		return session.selectList("book.bookSearch", data);
	}
}
