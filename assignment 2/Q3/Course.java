public class Course
{
    private String courseName;
    private java.util.ArrayList students = new java.util.ArrayList();  
    private int numberOfStudents;
    public Course(String courseName)
    {
        this.courseName = courseName;

   }
    public void addStudent(java.util.ArrayList students)

    {
      students[numberOfStudents] = students;

  }

   

  public java.util.ArrayList getStudents()

  {

      return students;

  }

   

  public int getNumberOfStudents()

  {

      return numberOfStudents;

  }              

   

  public String getCourseName()

  {

      return courseName;

  }

   

  public void dropStudents(java.util.ArrayList students)

  {

      students[numberOfStudents] = students;

      numberOfStudents --;
    }  
}
