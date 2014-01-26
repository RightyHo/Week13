import org.junit.*;
import static org.junit.Assert.*;

public class BookTest{
	private String strOutput;
	private String strExpected;
	private int intOutput;
	private int intExpected;
	
	@Before
	public void buildUp(){
		strOutput = "";
		strExpected = "";
		intOutput = 0;
		intExpected = 0;
	}
	@Test
	public void testsBookMethods(){
		Book myBook = new AndrewsBook("War & Peace","Leo Tolstoy");
		//test author name
		strOutput = myBook.getAuthor();
		strExpected = "Leo Tolstoy";
		assertEquals(strExpected,strOutput);
		//test title name
		strOutput = myBook.getTitle();
		strExpected = "War & Peace";
		assertEquals(strExpected,strOutput);
	}
	@Test
	public void testsLibraryPatronMethods(){
		LibraryPatron libUser = new AndrewsLibraryPatron("Laura");
		//test user ID is set and retrieved
		libUser.setLibraryId(4728);
		intOutput = libUser.getPatronId();
		intExpected = 4728;
		assertEquals(intExpected,intOutput);
		//test user name is set and retrieved
		strOutput = libUser.getPatronName();
		strExpected = "Laura";
		assertEquals(strExpected,strOutput);
	}
	@Test
	public void testsLibraryMemberMethods(){
		Library myLibrary = new LibraryImpl("Manor Gardens Library");
		LibraryMember myLibraryMember = new LibraryMember("Dominic");
		// test that method returns the library where the library member has membership
		myLibraryMember.register(myLibrary);
		Library libOutput = myLibraryMember.getLibrary();
		strOutput = libOutput.getLibrary();
		strExpected = myLibrary.getLibrary();
		assertEquals(strExpected,strOutput);
	}
	@Test
	public void testsLibraryMethods(){
		//test library name set & get
		Library testLib = new LibraryImpl("The British Library");
		strOutput = testLib.getLibrary();
		strExpected = "The British Library";
		assertEquals(strExpected,strOutput);
		//test set and get of maximum number of books borrowed by the same person policy
		testLib.setMaxBooksPerUser(7);
		intOutput = testLib.getMaxBooksPerUser();
		intExpected = 7;
		assertEquals(intExpected,intOutput);
		//test get ID when name doesn't exist in Library records
		intOutput = testLib.getId("Andrew");
		intExpected = testLib.getId("Andrew");
		assertEquals(intExpected,intOutput);
		//test get ID when name does exist in Library records
		int id2 =  testLib.getId("Matt");
		intOutput = testLib.getId("Andrew");
		assertEquals(intExpected,intOutput);
		//test add book and take book methods on first element in the list
		testLib.addBook("Game of Thrones","George RR Martin");
		Book loan1 = testLib.takeBook("Game of Thrones");
		strOutput = loan1.getAuthor();
		strExpected = "George RR Martin";
		assertEquals(strExpected,strOutput);	
		//test take book on middle of the list
		testLib.addBook("Bible","Jesus");
		testLib.addBook("Quran","Alah");
		testLib.addBook("Art of War","Sun Tzu");
		Book loan2 = testLib.takeBook("Quran");
		strOutput = loan2.getAuthor();
		strExpected = "Alah";
		assertEquals(strExpected,strOutput);
		//test return Book
		testLib.returnBook(loan1);
		Book bookOutput = testLib.takeBook("Game of Thrones");
		Book bookExpected = loan1;
		assertEquals(bookExpected,bookOutput);
	}
	@Test
	public void testsLibraryCountMethods(){
		Library lib = new LibraryImpl("Wellington Library");
		LibraryMember dominic = new LibraryMember("Dominic");
		LibraryMember james = new LibraryMember("James");
		LibraryMember wade = new LibraryMember("Wade");
		LibraryMember willem = new LibraryMember("Willem");
		LibraryMember oli = new LibraryMember("Oli");
		//test adding 1 to member map
		dominic.register(lib);
		intOutput = lib.getReaderCount();
		intExpected = 1;
		assertEquals(intExpected,intOutput);
		//test adding a few to map of members
		james.register(lib);
		wade.register(lib);
		willem.register(lib);
		oli.register(lib);
		intOutput = lib.getReaderCount();
		intExpected = 5;
		assertEquals(intExpected,intOutput);
		//test book list count with 1 book
		lib.addBook("East of Eden","John Steinbeck");
		intOutput = lib.getBookCount();
		intExpected = 1;
		assertEquals(intExpected,intOutput);
		//test book list count with a few books
		lib.addBook("On the Road","Jack Kerouac");
		lib.addBook("Bloomberg no Bloomberg","Mike Bloomberg");
		intOutput = lib.getBookCount();
		intExpected = 3;
		assertEquals(intExpected,intOutput);
		//test number of books borrowed
		lib.takeBook("East of Eden");
		intOutput = lib.getBookBorrowedCount();
		intExpected = 1;
		assertEquals(intExpected,intOutput);
		lib.takeBook("On the Road");
		intOutput = lib.getBookBorrowedCount();
		intExpected = 2;
		assertEquals(intExpected,intOutput);
	}
	@Test
	public void testsBorrowedBooksMethod(){
		Library lib = new LibraryImpl("Islington Library");
		lib.addBook("East of Eden","John Steinbeck");
		lib.addBook("On the Road","Jack Kerouac");
		lib.addBook("Bloomberg no Bloomberg","Mike Bloomberg");
		lib.addBook("Pride & Prejudice","Jane Austin");
		LibraryMember andrew = new LibraryMember("Andrew");
		andrew.register(lib);
		andrew.borrowBook("On the Road");
		andrew.borrowBook("Pride & Prejudice");
		String[] output = andrew.getBorrowedbooks();
		String[] expected = {"On the Road","Pride & Prejudice"};
		assertArrayEquals(expected,output);
	}
}



















































