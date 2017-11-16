public class Department {
   private int id;
   private String name;
   private Collection<Student> students;
 
   public Department(){
      students = new ArrayList<Student>();
   }

      
   public int getId() {
      return id;
   }
    
   public void setId(int id) {
        this.id = id;
   }

   
   public String getName() {
        return name;
   }
    
   public void setName(String deptName) {
        this.name = deptName;
   }

   public void addStudent(Student student) {

      if ( getStudents().contains(student) == false ) {
           getStudents().add(student);
      }

    

      if ( student.getDepartments().contains(this) == false ) {
           student.getDepartments().add(this);
      }
   }

   public Collection<Student> getStudents() {
      return students;
   }

   public void setStudent( Collection<Student> students ) {
      this.students = students;
   }

   

   public String toString() {
      String s = "Department: " + name + "\n";

      s = s + "Students: ";
      if ( students.size() == 0 )
         s = s + " none \n";
      else {
         Iterator iterator1 = students.iterator();
         while ( iterator1.hasNext() != false ) {
            Student student = (Student) iterator1.next();
            s = s + student.getName() + " ";
         }
         s = s + "\n";
      }

      return s;
   }
}

