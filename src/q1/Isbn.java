package q1;
/**
 * Test 01
 * class used to represent ISBN number
 * @author Pujan Gautam - c0842623
 * @version 1.0.1
 */
public class Isbn {
	//declaring the variables
	private String prefix;
	private String registrationGroup;
	private String registrant;
	private String publication;
	private String checkDigit;
	private String seperator;
	private String regrex = "[-, ' ']";
	
	//default constructor
	/**
	 * If no value is provided "TBD" is assigned to all the part of ISBN number
	 */
	public Isbn() {
		this.prefix = "TBD";
		this.registrationGroup = "TBD";
		this.registrant = "TBD";
		this.publication = "TBD";
		this.checkDigit = "TBD";
		this.seperator = "-";
	}
	
	//Single Parameter Constructor
	/**
	 * one parameter constructor that takes single string of isbn
	 * seperated by seperator (-) hyphen or (" ") space.
	 * @param isbn in format ddd-d-dd-dddddd-d
	 */
	public Isbn(String isbn) {
		String[] parts = isbn.split(regrex);
		String seperator = Character.toString(isbn.charAt(3));
		if(parts.length == 5) {
			if(this.isValidIsbn(isbn))
				this.setIsbn(parts[0],parts[1],parts[2],parts[3],parts[4],seperator);
		}
		else new Isbn();
	}
	
	/**
	 * six parameter constructor
	 * @param prefix
	 * @param registrationGroup
	 * @param registrant
	 * @param publication
	 * @param checkDigit
	 * @param seperator
	 */
	//parameterized constructor
	public Isbn(String prefix, String registrationGroup,String 
			registrant,String publication,String checkDigit,String seperator) {
		this.setPrefix(prefix);
		this.setRegistrationGroup(registrationGroup);
		this.setRegistrant(registrant);
		this.setPublication(publication);
		this.setCheckDigit(checkDigit);
		this.setSeperator(seperator);
	}
	
	//copy constructor
	
	public Isbn(Isbn isbn) {
		setIsbn(isbn.prefix, isbn.registrationGroup, isbn.registrant, 
				isbn.publication, isbn.checkDigit, isbn.seperator);
	}

	//setting prefix value and checking the required condition
	public void setPrefix(String prefix) {
		if(prefix.length() == 3 && (prefix == "979" || prefix == "978")) 
			this.prefix = prefix;
	}
	
	//setting registrationgroup
	public void setRegistrationGroup(String registrationGroup) {
		if(registrationGroup.length() >= 1 && registrationGroup.length() <=5)
			this.registrationGroup = registrationGroup;
	}
	
	//setting registrant
	public void setRegistrant(String registrant) {
		if(registrant.length() >= 2 && registrant.length() <= 7)
		this.registrant = registrant;
	}
	
	//setting publication
	public void setPublication(String publication) {
		if(publication.length() >= 1 && publication.length() <=6)
		this.publication = publication;
	}
	
	//setting checkDigit
	public void setCheckDigit(String checkDigit) {
		if(checkDigit.length() == 1)
		this.checkDigit = checkDigit;
	}
	
	//setting seperator
	public void setSeperator(String seperator) {
		if(seperator.matches(regrex))
		this.seperator = seperator;
	}
	
	
	//getter methods
	//returning instance prefex value
	public String getPrefix() {
		return this.prefix;
	}
	
	//returning instance registrationGroup value
	public String getRegistrationGroup() {
		return this.registrationGroup;
	}
	
	//returning instance registrant value
	public String getRegistrant() {
		return this.registrant;
	}
	
	//returning publication value
	public String getPublication() {
		return this.publication;
	}
	
	//returning checkdigit value
	public String getCheckDigit() {
		return this.checkDigit;
	}
	
	//returning the seperator value
	public String getSeperator() {
		return this.seperator;
	}
	/**
	 * assign the value to the respective instance variable
	 * @param prefix
	 * @param registrationGroup
	 * @param registrant
	 * @param publication
	 * @param checkDigit
	 * @param seperator
	 */
	
	public void setIsbn(String prefix, String registrationGroup,
			String registrant,String publication,String checkDigit,String seperator) {
		this.prefix = prefix;
		this.registrationGroup = registrationGroup;
		this.registrant = registrant;
		this.publication = publication;
		this.checkDigit = checkDigit;
		this.seperator = seperator;
	}
	
	/**
	 * checks if the given isbn has valid format or not
	 * checks the length , not mixed seperator and isDigit or not
	 * @param isbn
	 * @return isValid
	 */
	
	public boolean isValidIsbn(String isbn) {
		boolean isValid = true;
		if(isbn != null) {
			String[] isbnParts = isbn.split(regrex);
			String isbnDigits = "";
			if(isbn.length() != 17 || (isbn.contains("-") && isbn.contains(" ")) ||
					(!Isbn.calculateCheckDigit(isbn))) isValid = false;
			for(int i = 0;i<isbnParts.length;i++) {
				isbnDigits += isbnParts[i];
			}
			
			for(int i = 0;i<isbnDigits.length();i++) {
				if(!Character.isDigit(isbnDigits.charAt(i))) isValid = false;
			}
		}
		else isValid = false;
		return isValid;
	}
	
	/**
	 * checks weather the digits of isbn provided matches the checkDigit variable 
	 * or not and return boolean true or false based on the algorithm implemented.
	 * @param isbn
	 * @return isValid
	 */
	
	public static boolean calculateCheckDigit(String isbn) {
		boolean isValid = true;
		String[] datas = isbn.split("[-, ' ']");
		String isbnNumbers = "";
		int r = 0;
		for(int i = 0;i<5; i++) {
			isbnNumbers += datas[i];
		}
		for(int i=0;i<isbnNumbers.length() - 1;i++) {
			if(i == 0) {
				r +=  Character.getNumericValue(isbnNumbers.charAt(i));
			}
			else if(i % 2 == 0) {
				r += 3 * Character.getNumericValue(isbnNumbers.charAt(i));
			}
			else {
				r += Character.getNumericValue(isbnNumbers.charAt(i));
			}
		}
		r = 10 - (r%10);
		if(r == Character.getNumericValue(isbnNumbers.charAt(isbnNumbers.length()-1))) 
			isValid = true;
		else isValid = false;
		return isValid;
	}
	
	/**
	 * return boolean true if two Isbn object are equal otherwise return false
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Isbn) {
			Isbn isbnObj = (Isbn) obj;
			return this.prefix == isbnObj.prefix && 
					this.publication == isbnObj.publication && 
					this.registrationGroup == isbnObj.registrationGroup && 
					this.checkDigit == isbnObj.checkDigit &&
					this.registrant == isbnObj.registrant;
		}
		return false;
	}
	
	//toString method
	/**
	 * returns the object parameters in structural manner.
	 */
	@Override
	public String toString() {
		return this.prefix + this.seperator+this.registrationGroup+
				this.seperator+this.registrant + this.seperator+
				this.publication+this.seperator+this.checkDigit;
	}
}
