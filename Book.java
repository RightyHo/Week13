/**
*  Books have authors and titles.
*/
public interface Book {
	/**
	*  Returns author name
	*/
	String getAuthor();
	/**
	*  Returns title name
	*/
	String getTitle();
	/**
	*  gets book loan status
	*/
	boolean availableForLoan();
	/**
	*  sets book loan status
	*/
	void setStatus(boolean availability);
}