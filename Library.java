public interface Library {
	/**
	*  @return library name
	*/
	String getLibrary();
	/**
	*  sets maximum number of books borrowed by the same person
	*  @param max number of books borrowed by the same person
	*/
	void setMaxBooksPerUser(int max);
	/**
	*  @return maximum number of books borrowed by the same person
	*/
	int getMaxBooksPerUser();
	/**
	*  gets the library membership ID corresponding to the name passed to the method
	*  If the person does not have an ID yet, a new unique ID is created and returned.
	*  @param name of library member
	*  @return library membership ID
	*/ 
	int getId(String name);
	/**
	*  Adds a new book to the list of books in this library.
	*/
	void addBook(String title, String author);
	/**
	*  If the book is not taken, marks the book as taken and returns it. 
	*  If the book is taken, null is returned.
	*/	
	Book takeBook(String title);
	/**
	*  Marks the book as not taken.
	*/			
	void returnBook(Book book);
	/*
	*  returns the number of users registered in this library.
	*/
	int getReaderCount();
	/**
	*  returns the number of books in this library. 
	*/
	int getBookCount();
	/**
	*  returns the number of borrowed books in this library.
	*/
	int getBookBorrowedCount(); 
}