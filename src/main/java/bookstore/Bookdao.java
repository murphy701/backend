package bookstore;

import java.util.*;

import bookstore.book;

public class Bookdao {

	private ArrayList<book> listOfBooks = new ArrayList<book>();

	public Bookdao() {
		book html = new book(1, "programming", "html세상");
		html.setWriter("홍길동");
		html.setDescrip("html을 배울 수 있는 교과서입니다.");
		html.setPrice(10000);
		html.setStock(100);
		html.setSoldout("재고 있음");


		listOfBooks.add(html);

	}

	public ArrayList<book> getAllBooks() {
		return listOfBooks;
	}
}