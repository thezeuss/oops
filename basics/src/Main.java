//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
   Student emptyStudent = new Student();
    System.out.println(emptyStudent.marks);
    System.out.println(emptyStudent.name);


    Student s2 = new Student(17, "Parth", 99);
    System.out.println(s2.marks);
    System.out.println(s2.name);
}


class Student {
    int rollNo;
    String name;
    float marks;

  Student() {
      System.out.println("Empty Constructor");
  }
  Student(int rollNo, String name, float marks) {
      System.out.println("Inside parameterized constructor");
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
  }
}
