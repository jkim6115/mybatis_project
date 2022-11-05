package dto;

public class BookDTO {
	private int num;
	private String title;
	private String author;
	private String publisher;
	private String publisher_date;
	private int price;
	
	public BookDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public BookDTO(String title, String author, String publisher, String publisher_date, int price) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publisher_date = publisher_date;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublisher_date() {
		return publisher_date;
	}

	public void setPublisher_date(String publisher_date) {
		this.publisher_date = publisher_date;
	}
}
