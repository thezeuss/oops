public class Day3_Inheritance {

    static void main() {
        BoxWeight boxWeight = new BoxWeight();
        System.out.println(boxWeight);

        Box box = new BoxWeight();
        box.depth = 10;
        box.width = 10;
        box.height = 10;

        //    cannot access properties of child class since reference variable is of type super class
        //    box.weigth;  Results in compiler error
        System.out.println(box);

        // Parent reference holding a Child object (Upcasting)
        // Allowed in Java. Only parent class members can be accessed via this reference.
        Box box2 = new BoxWeight(10, 20, 15, 8, 10);

        // box2.weight  --> not accessible
        System.out.println(box2);


        // Child reference holding a Parent object
        // Not allowed because parent object does not contain child-specific properties
        // This will cause a compile-time error

        // there are many variables in both parent and child classes
        // you are given access to variables that are in the ref type i.e. BoxWeight
        // hence, you should have access to weight variable
        // this also means, that the ones you are trying to access should be initialized
        // but here, when the obj itself is of type parent class, how will you call the constructor of child class
        // this is why error
//        BoxWeight boxWeight2 = new Box(10, 20, 15, 10);

    }
}


class Box {
    double width;
    double height;
    double depth;
    /* Although subclass includes the members of its superclass
     * it will not be able to access the ones that are private. This
     * variable below will not be accessible in the child class - BoxWeight*/

    private int noOfCorners;

    Box() {
        this.width = 0;
        this.height = 0;
        this.depth = 0;
    }

    Box(double side) {
//        super(); --> Box is parent class, its super class is Object class. Every class extends Object class.
        this.width = side;
        this.height = side;
        this.depth = side;
    }

    Box(double width, double height, double depth, int noOfCorners) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.noOfCorners = noOfCorners;
    }
}

// we used extends keyword for Inheritance
// BoxWeight is the child class, Box is the Parent/Super class
class BoxWeight extends Box {
    double weight;

    public BoxWeight() {
        this.weight = 0;
    }

    BoxWeight(double weight) {
        this.weight = weight;
    }

    public BoxWeight(double width, double height, double depth, int noOfCorners, double weight) {

        /* super keyword is used to access the parent class constructor and initialize the variables that
         * are present in the parent/super class. When clicked on it, will take to the parent class constructor
         * being called */

        this.weight = weight;
        super(width, height, depth, noOfCorners);


        /*
         * With JEP 513 (Java 25), constructors allow certain statements
         * before super() or this(). This part is called the constructor
         * prologue. Simple assignments or validations can occur here
         * before the parent constructor is invoked.
         */

    }

    @Override
    public String toString() {
        return "BoxWeight{" + "weight=" + weight + ", width=" + width + ", height=" + height + ", depth=" + depth + '}';
    }
}


/* For Types of Inheritance - visit
    1. https://www.geeksforgeeks.org/java/inheritance-in-java/
*/