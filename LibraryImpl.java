import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class LibraryImpl implements Library {
	private int maxBorrowedBooks;
	private String libraryName;
	private Map memberIds;
	private List<Book> bookList;
	
	public LibraryImpl(String libraryName){
		this.libraryName = libraryName;
		memberIds = new HashMap();
		bookList = new ArrayList<Book>();
	}
	/**
	*  @return library name
	*/
	public String getLibrary(){
		return libraryName;
	}
	/**
	*  sets maximum number of books borrowed by the same person
	*  @param 
	*/
	public void setMaxBooksPerUser(int max){
		maxBorrowedBooks = max;
	}
	/**
	*  @return maximum number of books borrowed by the same person
	*/
	public int getMaxBooksPerUser(){
		return maxBorrowedBooks;
	}
	/**
	*  gets the library membership ID corresponding to the name passed to the method
	*  If the person does not have an ID yet, a new unique ID is created and returned.
	*  @param name of library member
	*  @return library membership ID
	*/ 
	public int getId(String name){
		int key;
		if(memberIds.isEmpty()){
			key = (name.hashCode()) % 10000;
			memberIds.put(key,name);
			return key;
		} else if(!memberIds.containsValue(name)) {
			key = (name.hashCode()) % 10000;
			memberIds.put(key,name);
			return key;
		} else {
			key = (name.hashCode()) % 10000;
			return key;
		}
	}
	/**
	*  Adds a new book to the list of books in this library.
	*/
	public void addBook(String title, String author){
		Book newBook = new AndrewsBook(title,author);
		bookList.add(newBook);
	}
	/**
	*  If the book is not taken, marks the book as taken and returns it. 
	*  If the book is taken, null is returned.
	*/	
	public Book takeBook(String title){
		for(Book next: bookList){
			if(next.getTitle().equals(title)){
				if(next.availableForLoan()){
					next.setStatus(false);
					return next;
				} else {
					return null;
				}
			}
		}
		return null;
	}
	/**
	*  Marks the book as not taken.
	*/			
	public void returnBook(Book book){
		String bTitle = book.getTitle();
		for(Book next: bookList){
			if(next.getTitle().equals(bTitle)){
				next.setStatus(true);
					return;
			}
		}
	}
	/*
	*  returns the number of users registered in this library.
	*/
	public int getReaderCount(){
		return memberIds.size();
	}
	/**
	*  returns the number of books in this library. 
	*/
	public int getBookCount(){
		return bookList.size();
	}
	/**
	*  returns the number of borrowed books in this library.
	*/
	public int getBookBorrowedCount(){
		int result = 0;
		for(Book next: bookList){
			if(!next.availableForLoan()){
				result++;
			}
		}
		return result;
	}
}
















































