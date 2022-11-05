package view;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import controller.BookController;
import dto.BookDTO;

public class BookMain {
	public static void main(String[] args) {
		BookController bookController = new BookController();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("=== 도서 관리 프로그램 ===");
			System.out.println("1. 도서 추가");
			System.out.println("2. 도서 정보 수정");
			System.out.println("3. 도서 삭제");
			System.out.println("4. 도서 제목으로 조회");
			System.out.println("5. 도서 목록 전체 조회");
			System.out.println("0. 끝내기");
			System.out.println("==========================");
			System.out.print("번호 입력 : ");
			int input = Integer.parseInt(sc.nextLine());
			if(input == 1) {
				insertCall(bookController, sc);
			} else if(input == 2) {
				updateCall(bookController, sc);
			} else if(input == 3) {
				deleteCall(bookController, sc);
			} else if(input == 4) {
				searchCall(bookController, sc);
			} else if(input == 5) {
				listCall(bookController);
			} else if(input == 0) {
				System.out.println("시스템 종료");
				System.exit(0);
			}				
		}
	} // end main()
	
	private static void insertCall(BookController bookController, Scanner sc) {
		System.out.println("=== 도서 추가 ===");
		System.out.print("도서명 : ");
		String title = sc.nextLine();
		System.out.print("작가명 : ");
		String author = sc.nextLine();
		System.out.print("출판사 : ");
		String publisher = sc.nextLine();
		System.out.print("출판일 : ");
		String publisherDate = sc.nextLine();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		BookDTO bdto = new BookDTO(title, author, publisher, publisherDate, price);
		int chk = bookController.insertProcess(bdto);
		if (chk > 0)
			System.out.printf("%d개 삽입\n", chk);
		else
			System.out.println("삽입 실패");
	}
	
	private static void updateCall(BookController bookController, Scanner sc) {
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		System.out.println("======== 도서 수정 ========");
		System.out.println("어떤것을 수정 하시겠습니까?");
		System.out.println("1. 도서명");
		System.out.println("2. 작가명");
		System.out.println("3. 출판사");
		System.out.println("4. 출판일");
		System.out.println("5. 가격");
		System.out.println("===========================");
		System.out.print("번호 입력 : ");
		int input = Integer.parseInt(sc.nextLine());
		System.out.print("수정할 도서 번호 입력 : "); 
		hmap.put("num", Integer.parseInt(sc.nextLine()));
		if(input == 1) {
			System.out.print("도서명 : "); 
			hmap.put("title", sc.nextLine());
		} else if(input == 2) {
			System.out.print("작가명 : ");
			hmap.put("author", sc.nextLine());
		} else if(input == 3) {
			System.out.print("출판사 : ");
			hmap.put("publisher", sc.nextLine());
		} else if(input == 4) {
			System.out.print("출판일 : ");
			hmap.put("publisher_date", sc.nextLine());
		} else if(input == 5) {
			System.out.print("가격 : ");
			hmap.put("price", Integer.parseInt(sc.nextLine()));
		}
		
		int chk = bookController.updateProcess(hmap);
		if (chk > 0)
			System.out.printf("%d개 수정\n", chk);
		else
			System.out.println("수정 실패");
	}
	
	private static void deleteCall(BookController bookController, Scanner sc) {
		System.out.print("삭제할 도서 번호 입력 : ");
		int num = Integer.parseInt(sc.nextLine());
		int chk = bookController.deleteProcess(num);
		if (chk >= 0)
			System.out.printf("%d개 삭제\n", chk);
		else
			System.out.println("삭제 실패");
	}
	
	private static void searchCall(BookController bookController, Scanner sc) {
		System.out.print("검색할 도서명 입력 : ");
		String data = sc.nextLine();
		List<BookDTO> searchBook = bookController.searchProcess(data);
		for(BookDTO bdto : searchBook)
			System.out.printf("%d %s %s %s %s %d\n", bdto.getNum(), bdto.getTitle(), bdto.getAuthor(),
					bdto.getPublisher(), bdto.getPublisher_date(), bdto.getPrice());
	}
	
	private static void listCall(BookController bookController) {
		List<BookDTO> aList = bookController.listProcess();
		for (BookDTO bdto : aList)
			System.out.printf("%d %s %s %s %s %d\n", bdto.getNum(), bdto.getTitle(), bdto.getAuthor(),
					bdto.getPublisher(), bdto.getPublisher_date(), bdto.getPrice());
	}
} // end main()
