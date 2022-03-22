package lombokdemo.app.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
	
	private int bookId;
	private String bookName;

}
