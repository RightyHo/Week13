public class AndrewsBook implements Book {
	private String title;
	private String author;
	private boolean availableStatus;
	
	public AndrewsBook(String title,String author){
		this.title = title;
		this.author = author;
		availableStatus = true;
	}
	/**
	*  Returns author name
	*/
	public String getAuthor(){
		return author;
	}
	/**
	*  Returns title name
	*/
	public String getTitle(){
		return title;
	}
	/**
	*  gets book loan status
	*/
	public boolean availableForLoan(){
		if(availableStatus){
			return true;
		} else {
			return false;
		}
	}
	/**
	*  sets book loan status
	*/
	public void setStatus(boolean availability){
		if(availability){
			availableStatus = true;
		} else {
			availableStatus = false;
		}
	}
}