package lombokdemo.app.service;

import java.util.ArrayList;
import java.util.List;

import lombokdemo.app.beans.Book;

public class BookService {
	
	public static void main(String[] args) {
		
		Book book = new Book(1, "mybook");
		Book book1 = new Book(2, "mybook2");
		Book book2 = new Book(3, "mybook3");
		
		List<Book> books = new ArrayList<Book>();
		
		books.add(book);
		books.add(book1);
		books.add(book2);
		
		System.out.println(books);
	}
}
