package controller;

import java.util.HashMap;
import java.util.List;

import dao.BookDAO;
import dto.BookDTO;

public class BookController {
	private BookDAO dao;
	
	public BookController() {
		dao = new BookDAO();
	}
	
	public List<BookDTO> listProcess() {
		return dao.listMethod();
	}
	
	public int insertProcess(BookDTO dto) {
		return dao.insertMethod(dto);
	}
	
	public int updateProcess(HashMap<String, Object> hmap) {
		return dao.updateMethod(hmap);
	}
	
	public int deleteProcess(int num) {
		return dao.deleteMethod(num);
	}
	
	public List<BookDTO> searchProcess(String data){
		return dao.searchMethod(data);
	}
}
