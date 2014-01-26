/**
*  Users have a name and a library-ID (an int), both of which must be unique in a library.
*/
public abstract class LibraryPatron {
	protected String patronName;
	protected int patronId;
	
	/**
	*  sets library ID
	*/
	public void setLibraryId(int newId){
		patronId = newId;
	}
	/**
	*  gets name of the person
	*/
	public String getPatronName(){
		return patronName;
	}
	/**
	*  gets ID of the person
	*/
	public int getPatronId(){
		return patronId;
	}
}