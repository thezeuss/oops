/*
========================================================
DAY 1 - OBJECT ORIENTED PROGRAMMING (JAVA)

Topics Covered:
1. Class
2. Object
3. Constructors
4. this keyword
5. new keyword
6. Memory allocation when object is created

Author: Parth Darji
========================================================
*/


/*
--------------------------------------------------------
1. CLASS
--------------------------------------------------------

A Class is a blueprint or template used to create objects.

It defines:
1. State  -> Variables
2. Behavior -> Methods

Example real world analogy:
Class = Car blueprint
Object = Actual car built using blueprint

Important:
Class itself DOES NOT allocate memory for instance variables.
Memory is allocated only when an object is created.
*/

class Employee {

    // Instance variables (STATE of object)
    String name;
    int age;
    double salary;


    /*
    --------------------------------------------------------
    2. CONSTRUCTOR
    --------------------------------------------------------

    A constructor is a special method that is executed
    automatically when an object is created.

    Properties:
    - Same name as class
    - No return type
    - Used to initialize objects
    */

    Employee() {
        System.out.println("Default Constructor Called");
    }


    /*
    Parameterized Constructor

    Used to initialize object with values at creation time.
    */

    Employee(String name, int age, double salary) {

        /*
        --------------------------------------------------------
        3. this KEYWORD
        --------------------------------------------------------

        'this' refers to the current object.

        Why needed?
        Because constructor parameters have same names
        as instance variables.

        Without this:
        name = name;  -> ambiguous

        With this:
        this.name refers to instance variable
        */

        this.name = name;
        this.age = age;
        this.salary = salary;
    }


    /*
    Behavior of Employee object
    */
    void displayEmployeeInfo() {

        System.out.println("Employee Name: " + name);
        System.out.println("Employee Age: " + age);
        System.out.println("Employee Salary: " + salary);
    }
}



/*
--------------------------------------------------------
MAIN CLASS (PROGRAM ENTRY POINT)
--------------------------------------------------------

JVM starts execution from main() method.
*/

public class Main {

    static void main(String[] args) {


        /*
        --------------------------------------------------------
        4. OBJECT CREATION
        --------------------------------------------------------

        Syntax:

        ClassName referenceVariable = new ClassName();
        */

        Employee emp1 = new Employee();


        /*
        --------------------------------------------------------
        5. new KEYWORD
        --------------------------------------------------------

        'new' is responsible for:

        1. Allocating memory in HEAP
        2. Calling constructor
        3. Returning reference to object
        */

        emp1.name = "John Doe";
        emp1.age = 28;
        emp1.salary = 75000;

        emp1.displayEmployeeInfo();



        /*
        Creating object using parameterized constructor
        */

        Employee emp2 = new Employee("Alice", 30, 90000);

        emp2.displayEmployeeInfo();




        /*
        --------------------------------------------------------
        INTERNAL JVM WORKING (OBJECT CREATION)
        --------------------------------------------------------

        Line executed:
        Employee emp1 = new Employee();


        STEP 1
        JVM checks if Employee class is loaded.

        STEP 2
        Memory allocated in HEAP for object.

        Heap Memory
        -----------------------
        name   -> null
        age    -> 0
        salary -> 0.0
        -----------------------


        STEP 3
        Constructor is executed.


        STEP 4
        Reference variable stores memory address.


        STACK MEMORY
        -----------------------
        emp1 -> reference to heap object
        -----------------------


        VISUAL REPRESENTATION

        STACK                HEAP

        emp1 -------->   Employee Object
                         ------------------
                         name   = John
                         age    = 28
                         salary = 75000
                         ------------------
        */

    }
}