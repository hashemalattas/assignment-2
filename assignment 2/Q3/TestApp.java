public class TestApp {
   public static void main(String[] args) {
   // create a couple of departments
   Department ecse=new Department(“Electrical, Computer and Software Engineering”, “ECSE”);
   Department amme=new Department(“Automotive, Mechanical and Mane Engineering”, “AAME”);

   // create some courses
   Course sofe2710 = new Course(“SOFE”, 2710, ecse, “Object Oriented Programming & Design”);
   Course sofe2800 = new Course(“SOFE”, 2800, ecse, “Web Programming”);
   Course sofe4610 = new Course(“SOFE”, 4610, ecse, “Internet of Things”);
   Course elee4350 = new Course(“ELEE”, 4350, ecse, “Microprocessors”);
   Course elee4150 = new Course(“ELEE”, 4150, ecse, “Advanced Control Systems”);
   Course elee3250 = new Course(“ELEE”, 3250, ecse, “Electric Machines”);
   Course engr1015 = new Course(“ENGR”, 1015, ecse, “Intro. to Engineering”);
   Course mane2220 = new Course(“MANE”, 2220, amme, “Structure and Properties of Materials”);
   Course mane4190 = new Course(“AUTE”, 4190, amme, “Principles of Material Removal Processes”);
   Course mece2860 = new Course(“MECE”, 2860, amme, “Fluid Mechanics”);
   Course mece2420 = new Course(“AUTE”, 2420, amme, “Solid Mechanics”);
   Course mece3220 = new Course(“AUTE”, 3220, amme, “Machine Design”);
   Course aute3010 = new Course(“AUTE”, 3010, amme, “Intro. to Auto. Engineering”);
   Course aute4010 = new Course(“AUTE”, 4010, amme, “Vehicle Dynamics & Control”);

   // connect courses to departments
   ecse.offerCourse(sofe2710);
   ecse.offerCourse(sofe2800);
   ecse.offerCourse(sofe4610);
   ecse.offerCourse(elee4350);
   ecse.offerCourse(elee4150);
   ecse.offerCourse(elee3250);
   ecse.offerCourse(engr1015);

   amme.offerCourse(mane2220);
   amme.offerCourse(mane4190);
   amme.offerCourse(mece2860);
   amme.offerCourse(mece2420);
   amme.offerCourse(mece3220);
   amme.offerCourse(aute3010);
   amme.offerCourse(aute4010);

   // create some students
   Student john  = new Student("100232122", "John Maxwell");
   Student sarah = new Student("100523332", "Sarah Lee");
   Student emily = new Student("100512132", "Emily Johnson");
   Student alex  = new Student("100232732", "Alex Williams");
   Student jane  = new Student("100989832", "Jane Wesley");

   // register students
   john.registerFor(sofe2710);
   john.registerFor(sofe2800);
   john.registerFor(sofe4610);
   john.registerFor(elee4150);
   john.registerFor(mane2220);

   sarah.registerFor(sofe2710);
   sarah.registerFor(sofe2800);
   sarah.registerFor(engr1015);
   sarah.registerFor(elee3250);
   sarah.registerFor(elee4350);
   sarah.registerFor(elee4150);

   emily.registerFor(sofe2710);
   emily.registerFor(mece2860);
   emily.registerFor(mece2420);
   emily.registerFor(mece3220);
   emily.registerFor(aute3010);
   emily.registerFor(aute3010);
   emily.registerFor(aute4010);

   alex.registerFor(sofe2710);
   alex.registerFor(aute4010);
   alex.registerFor(aute3010);

   jane.registerFor(elee3250);
   jane.registerFor(aute4010);
   jane.registerFor(mane4190);
   jane.registerFor(mane2220);
   jane.registerFor(engr1015);

   // now check to see if it works
   System.out.println("ECSE Department: "+ecse);
   System.out.println("AMME Department: "+amme);
   System.out.println("\nECSE courses offered: ");
   ecse.printCoursesOffered();
   System.out.println("\nAMME courses offered: ");
   amme.printCoursesOffered();
   System.out.println("\nStudents taking ECSE courses: ");
   ecse.printStudentsByName();
   System.out.println("\nStudents taking AMME courses: ");
   amme.printStudentsByName();
   System.out.println("\nIs John registered in sofe2710: "+john.isRegisteredInCourse(sofe2710));
   System.out.println("Is Joseph registered in sofe2800: "+john.isRegisteredInCourse(sofe2800));
   System.out.println("Is Sarah registered in mece3000: "+sarah.isRegisteredInCourse(mece3220));
   System.out.println("Is Sarah registered in mane3000: "+sarah.isRegisteredInCourse(elee4350));

   System.out.println("Is Emily is registered in ECSE: "+ecse.isStudentRegistered(emily));
   System.out.println("Is Sarah is registered in ECSE: "+ecse.isStudentRegistered(sarah));
   System.out.println("Is Jane is registered in ECSE: "+ecse.isStudentRegistered(jane));

   System.out.println("\nStudents registered in sofe2710: "); 
   ecse.printStudentsRegisteredInCourse(2710);

   System.out.println("\nStudents registered in Web Programming: ");
   ecse.printStudentsRegisteredInCourse(2800);

   System.out.println("\nStudents registered in Internet of Things: ");
   ecse.printStudentsRegisteredInCourse(4610);

   System.out.println("\nStudents registered in Microprocessors: ");
   ecse.printStudentsRegisteredInCourse(4350);
 
   System.out.println("\nStudents registered in Advanced Control Systems: ");
   ecse.printStudentsRegisteredInCourse(4150);

   System.out.println("\nStudents registered in Electric Machines: ");
   ecse.printStudentsRegisteredInCourse(3250);

   System.out.println("\nStudents registered in Intro. to Engineering: ");
   ecse.printStudentsRegisteredInCourse(1015);

   System.out.println("\nStudents registered in Structure and Properties of Materials: ");
   amme.printStudentsRegisteredInCourse(2220);

   System.out.println("\nStudents registered in SPrinciples of Material Removal Processes: ");
   amme.printStudentsRegisteredInCourse(4190);

   System.out.println("\nStudents registered in Fluid Mechanics: ");
   amme.printStudentsRegisteredInCourse(2860);

   System.out.println("\nStudents registered in Solid Mechanics: ");
   amme.printStudentsRegisteredInCourse(2420);

   System.out.println("\n Students registered in Machine Design: ");
   amme.printStudentsRegisteredInCourse(3220);

   System.out.println("\nStudents registered in Intro. to Auto. Engineering: ");
   amme.printStudentsRegisteredInCourse(3010);

   System.out.println("\nStudents registered in Vehicle Dynamics & Control: ");
   amme.printStudentsRegisteredInCourse(4010);

   System.out.println("\nLargest ecse course: "+ecse.largestCourse());
   System.out.println("\nLargest amme course: "+amme.largestCourse());

   }	
}
