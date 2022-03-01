package q1;
/**
 * Test 01
 * class used to represent Textbook
 * @author Pujan Gautam - c0842623
 * @version 1.0.1
 */
public class Textbook {
	//declaring the variables
	private String title;
	private String publisher;
	private Isbn isbn;
	private int edition;
	private int numPages;
	
	//default constructor
	public Textbook() {
		this.title = this.publisher = "TBD";
		this.isbn = null;
		this.edition = this.numPages = 0;
	}
	
	//parameterized constructor
	public Textbook(String title,String publisher,String isbn,int edition, int numPages){
		this.setTitle(title);
		this.setPublisher(publisher);
		this.setIsbn(isbn);
		this.setEdition(edition);
		this.setNumPages(numPages);
	}
	
	//copy constructor
	
	public Textbook(Textbook textBookToCopy) {
		this.setTitle(textBookToCopy.title);
		this.setPublisher(textBookToCopy.publisher);
		this.setIsbn(textBookToCopy.isbn.toString());
		this.setEdition(textBookToCopy.edition);
		this.setNumPages(textBookToCopy.numPages);
	}
	
	//setter
	//setting the title value
	public void setTitle(String title) {
		this.title = title;
	}
	
	//setting the publisher
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	//setting the isbn value
	public void setIsbn(String isbn) {
		if(this.isbn == null) this.isbn = new Isbn();
		if(this.isbn.isValidIsbn(isbn))this.isbn= new Isbn(isbn);
		else this.isbn = new Isbn();
	}
	
	//setting the edition value
	public void setEdition(int edition) {
		if (edition <= 0) this.edition = 1;
		else this.edition = edition;
	}
	//setting the page number
	public void setNumPages(int numPages) {
		if(numPages <= 0) this.numPages = 1;
		else this.numPages = numPages;
	}
	
	
	//getter methods
	//returning object instance title
	public String getTitle() {
		return this.title;
	}
	
	//returning object instance publisher
	public String getPublication() {
		return this.publisher;
	}
	
	//returning object instance ISBN number
	public String getIsbn() {
		return this.isbn.toString();
	}
	
	//returning the edition
	public int getEdition() {
		return this.edition;
	}
	
	//returning the pagenumber
	public int getNumPages() {
		return this.numPages;
	}
	
	/**
	 * returns the informations of Textbook object in formatted manner
	 */
	@Override
	public String toString() {
		String isbn = (this.isbn == null) ? "TBD": this.getIsbn();
		return "TITLE: "+this.title+"\n"+
			   "PUBLISHER: "+this.publisher + "\n"+
			   "ISBN-13: "+isbn+"\n"+
			   "EDITION: "+ this.edition+"\n"+
			   "PAGES: "+ this.numPages + " pgs";
	}
	//equals method
	/**
	 * returns boolean true or false depending upon the condition applied
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Textbook) {
			Textbook textBookObj = (Textbook) obj;
			if(textBookObj.isbn == null || this.isbn == null) {
				return textBookObj.title == this.title && textBookObj.edition == this.edition;
			}
			return textBookObj.isbn == this.isbn;
		}
		return false;
	}
}
