package bookstore;

import java.util.*;

import bookstore.book;

public class Bookdao {

	private ArrayList<book> listOfBooks = new ArrayList<book>();

	public Bookdao() {
		book html = new book(1, "programming", "html����");
		html.setWriter("ȫ�浿");
		html.setDescrip("html�� ��� �� �ִ� �������Դϴ�.");
		html.setPrice(10000);
		html.setStock(100);
		html.setSoldout("��� ����");


		listOfBooks.add(html);

	}

	public ArrayList<book> getAllBooks() {
		return listOfBooks;
	}
}