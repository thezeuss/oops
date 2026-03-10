/*
========================================================
JAVA OOPS NOTES - OBJECT CREATION & INTERNAL WORKING

Topics Covered

1. Calling a constructor from another constructor
2. Why we don't use "new" keyword for primitive data types
3. Memory allocation of "new" keyword
4. Wrapper Classes
5. final keyword
6. Garbage Collection

Author: Parth Darji
========================================================
*/


/*
--------------------------------------------------------
1. CONSTRUCTOR CHAINING
--------------------------------------------------------

Constructor chaining means calling one constructor
from another constructor of the same class.

Why?

To avoid code duplication and centralize initialization logic.

Rules:
- Must use "this()"
- Must be the FIRST statement inside constructor
*/

class Student {

    String name;
    int age;
    String course;

    // Default constructor
    Student() {

        /*
        Calling parameterized constructor
        using constructor chaining
        */

        this("Unknown", 0, "Not Assigned");

        System.out.println("Default constructor executed");
    }

    Student(String name, int age, String course) {

        this.name = name;
        this.age = age;
        this.course = course;
    }

    void display() {
        System.out.println(name + " | " + age + " | " + course);
    }
}


/*
--------------------------------------------------------
2. PRIMITIVE DATA TYPES VS OBJECTS
--------------------------------------------------------

Primitive Data Types

int
double
boolean
char
byte
short
long
float

Primitive variables store the VALUE directly.

Example:

int a = 10;

Memory:
Stack
-----
a = 10

No object is created.


Objects

Objects store REFERENCE to heap memory.

Example:

Student s = new Student();

Stack                Heap
-----                ----
s  --------->     Student Object
*/


/*
--------------------------------------------------------
3. WHY WE DON'T USE "new" FOR PRIMITIVES
--------------------------------------------------------

Because primitives are NOT objects.

They store raw values directly in stack memory.

Example:

int num = 5;

Memory:

Stack
-----
num = 5

If primitives required heap allocation,
performance would be much slower.

Java keeps primitives lightweight for efficiency.
*/


/*
--------------------------------------------------------
4. MEMORY ALLOCATION WHEN USING "new"
--------------------------------------------------------

Example:

Student s1 = new Student();

Steps performed by JVM:

STEP 1
Class is loaded into JVM if not already loaded.

STEP 2
Memory is allocated in HEAP.

Heap Object Layout:

-------------------------
name   -> null
age    -> 0
course -> null
-------------------------

STEP 3
Constructor is called to initialize object.

STEP 4
Reference variable stores memory address.

STACK                HEAP
-----                ----
s1 --------->      Student Object
*/


/*
--------------------------------------------------------
5. WRAPPER CLASSES
--------------------------------------------------------

Wrapper classes convert primitive types into objects.

Primitive     Wrapper Class

int           Integer
double        Double
char          Character
boolean       Boolean
long          Long
float         Float
byte          Byte
short         Short

Why wrapper classes exist?

Because Java Collections work only with objects.

Example:

ArrayList<int> ❌ NOT allowed
ArrayList<Integer> ✅ allowed
*/

class WrapperExample {

    void demo() {

        int a = 10;

        // Boxing (primitive -> object)
        Integer obj = Integer.valueOf(a);

        // Auto-boxing
        Integer obj2 = a;

        // Unboxing (object -> primitive)
        int b = obj;

        System.out.println("Primitive: " + a);
        System.out.println("Wrapper Object: " + obj);
        System.out.println("Unboxed value: " + b);
    }
}


/*
--------------------------------------------------------
6. FINAL KEYWORD
--------------------------------------------------------

final can be used with:

1. Variables
2. Methods
3. Classes


FINAL VARIABLE

Once assigned, value cannot change.
*/

class FinalExample {

    int month;
    int year;


    FinalExample() {
    }

    FinalExample(int month, int year) {
        this.month = month;
        this.year = year;
    }

    final int MAX_USERS = 100;

    void show() {

        System.out.println("Max users allowed: " + MAX_USERS);

        // MAX_USERS = 200; ❌ compile time error
    }
}


/*
--------------------------------------------------------
7. GARBAGE COLLECTION
--------------------------------------------------------

Garbage Collection is the automatic process of
removing unused objects from heap memory.

Java manages memory automatically.

Example:
*/

class GarbageCollectionExample {

    void createObjects() {

        Student s1 = new Student("Alice", 22, "CS");
        Student s2 = new Student("Bob", 23, "IT");

        /*
        If references are removed,
        objects become eligible for GC.
        */

        s1 = null;
        s2 = null;

        /*
        Now these objects have no references.

        JVM marks them as "eligible for garbage collection".
        */

        System.gc(); // Suggests JVM to run GC (not guaranteed)
    }
}



/*
--------------------------------------------------------
MAIN CLASS
--------------------------------------------------------
*/

public class Day1_ObjectCreation_InternalWorking {

    public static void main(String[] args) {

        /*
        Constructor chaining demonstration
        */

        Student student1 = new Student();

        student1.display();


        /*
        Wrapper class demo
        */

        WrapperExample wrapper = new WrapperExample();
        wrapper.demo();


        /*
        Final keyword demo
        */

        FinalExample finalExample = new FinalExample();
        finalExample.show();

        final FinalExample finalExample2 = new FinalExample(3, 2002);

        /*
        Allowed: modifying the object's fields.

        Even though the reference is final,
        the object itself is NOT immutable.

        So we can change its internal state.
        */

        finalExample2.year = 2000;
        finalExample2.month = 12;


        /*
        Not Allowed: changing the reference.

        Since finalExample2 is declared as final,
        it cannot reference a new object.

        This will cause a compile-time error.
        */

        // finalExample2 = new FinalExample(); ❌ Compile-time error


        /*
        Garbage collection demo
        */

        GarbageCollectionExample gc = new GarbageCollectionExample();
        gc.createObjects();
    }
}