package q1;
/**
 * Test 01
 * class used to represent Course
 * @author Pujan Gautam - c0842623
 * @version 1.0.1
 */
public class Course {
	//declaring the variable
	private String name;
	private String courseCode;
	private String description;
	private Textbook txtBook;
	private double credits;
	
	//default constructor
	/**
	 * setting name and course code to "TBD" by default and 
	 * description to empty string and txtBook to null and credits to 0.0;
	 */
	public Course() {
		this.name = this.courseCode = "TBD";
		this.description = "";
		this.txtBook = null;
		this.credits = 0.0;
	}
	
	//parameterized constructor
	/**
	 * five parameters constructors
	 * @param name
	 * @param courseCode
	 * @param description
	 * @param txtBook
	 * @param credits
	 */
	public Course(String name,String courseCode,String description,Textbook txtBook,double credits) {
		this.setName(name);
		this.setCourseCode(courseCode);
		this.setDescription(description);
		this.setTextBook(txtBook);
		this.setCredit(credits);
	}
	
	
	//copy Constructor - Deep copy
	public Course(Course copyCourse) {
		this.setName(copyCourse.name);
		this.setCourseCode(copyCourse.courseCode);
		this.setDescription(copyCourse.description);
		this.setTextBook(copyCourse.txtBook);
		this.setCredit(copyCourse.credits);
	}
	
	//setter
	/**
	 * setting the instance variable name and
	 * if null then assign a default value "TBD"
	 * @param name
	 */
	public void setName(String name) {
		if(name == null || name.length() == 0) this.name = "TBD";
		else this.name = name;
	}
	
	/**
	 * setting the instance variable courseCode and
	 * if null then assign a default value "TBD"
	 * @param courseCode
	 */
	public void setCourseCode(String courseCode) {
		if(courseCode == null || courseCode.length() == 0) this.courseCode = "TBD";
		else this.courseCode = courseCode;
	}
	
	/**
	 *  * setting the instance variable description and
	 * if null then assign a default value "TBD"
	 * @param description
	 */
	
	public void setDescription(String description) {
		if(description == null) this.description = "";
		else this.description = description;
	}
	
	/**
	 * setting the instance variable credits and
	 * if null then assign a default value 0.0
	 * @param credits
	 */
	public void setCredit(double credits) {
		if(credits < 0) this.credits = 0.0;
		else this.credits = credits;
	}
	
	/**
	 *  * setting the instance variable txtBook and
	 * if null then assign a default Textbook Constructor.
	 * @param txtBook
	 */
	public void setTextBook(Textbook txtBook) {
		if(txtBook == null) this.txtBook = new Textbook();
		else this.txtBook = new Textbook(txtBook);
	}
	
	
	//getter method
	/**
	 * return instance variable name
	 * @return name 
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * return instance variable courseCode
	 * @return courseCode
	 */
	public String getCourseCode() {
		return this.courseCode;
	}
	
	/**
	 * return instance variable description
	 * @return description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * return instance variable credits
	 * @return credits
	 */
	public double getCredits() {
		return this.credits;
	}
	
	/**
	 * return instance variable textBook
	 * @return textBook in string format
	 */
	public String getTextBook() {
		return this.txtBook.toString();
	}
	
	//equals method
	/**
	 * @return boolean true or false depending on the condition successed or failed.
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Course) {
			Course courseObj = (Course) obj;
			return this.courseCode == courseObj.courseCode;
		}
		return false;
	}
	
	//toString method
	/**
	 * return object course in well formated string form.
	 */
	public String toString() {
		return "COURSE: "+this.name+ "\n"+
			   "CODE: " +this.courseCode+ "\n"+
			   "CREDITS: "+this.credits+ "\n"+
			   "DESCRIPTIONS: "+this.description+ "\n"+
			   "-----------TEXTBOOK---------------"+"\n"+
			   this.txtBook.toString();
	}
		
}
