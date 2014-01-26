import java.util.ArrayList;
import java.util.List;

public class LibraryMember extends LibraryPatron {
	private Library myLibrary;
	private List<Book> myBorrowedBooks;
	/**
	*  register with Library and obtain a user ID
	*/
	public LibraryMember(String patronName){
		this.patronName = patronName;
		myBorrowedBooks = new ArrayList<Book>();
	}
	public void register(Library lib){
		myLibrary = lib;
		int membershipNum = myLibrary.getId(patronName);
		setLibraryId(membershipNum);
	}
	/**
	*  returns the library where the library member has membership
	*/
	public Library getLibrary(){
		return myLibrary;
	}
	/**
	*  adds a book to the myBorrowedBooks list
	*/
	public void borrowBook(String title){
		Book loanBook = myLibrary.takeBook(title);
		myBorrowedBooks.add(loanBook);
	}
	/**
	*  returns a list with the titles of all the books they are currently borrowing
	*/
	public String[] getBorrowedbooks(){
		Book bookArray = myBorrowedBooks.toArray(Book[myBorrowedBooks.size()]);
		String result = new String[bookArray.length()];
		for(int i=0;i<bookList.length();i++){
			result[i] = bookArray[i].getTitle();
		}
		return result;
	}
}