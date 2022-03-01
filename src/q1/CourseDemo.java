package q1;
/**
 * Test 01
 * class used to represent Main Class.
 * @author Pujan Gautam - c0842623
 * @version 1.0.1
 */
public class CourseDemo {

	public static void main(String[] args) {
		
		// Declaring first Textbook object and Course object
		Textbook txtBook1 = new Textbook("Java","Lambton","978-0-13-404167-4",2,300);
		Course course1 = new Course("CSAC","2580","This is full stack course",txtBook1,30);
		System.out.print("The First Course Informations are: \n");
		System.out.println(course1.toString());
		System.out.println();
		System.out.println();
		System.out.println("----------------------------------------------------------");
		
		// Declaring second Textbook object and Course object
		Textbook txtBook2 = new Textbook("Java","Lambton",null,2,300);
		Course course2 = new Course("CSAC","258","This is full stack course",txtBook2,30);
		System.out.println("The Second Course Informations are: \n");
		System.out.println(course2.toString());
		System.out.println("----------------------------------------------------------");
		System.out.println();
		System.out.println();
		System.out.println("Are Course 1 and course 2 Equal: "+course1.equals(course2));

	}

}
