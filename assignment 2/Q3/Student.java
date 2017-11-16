public class Student {
  private String id;
  private ArrayList<Course> courses; // contains all courses the student is registered in

  public String getName() {
  }

  public String getId() {
  }

  // constructor
  public Student(String id, String name) { 
     id=id;
	 name=name;
  }

  public String toString() {
      return String.format(id + " + name" + name);
  }
}
