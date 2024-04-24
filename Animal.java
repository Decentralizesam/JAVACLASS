// Parent class
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

// Child class inheriting from Animal
class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }


// Main class

    public static void main(String[] args) {
        // Creating an object of the child class
        Dog dog = new Dog();
        
        // Calling methods from both parent and child classes
        dog.eat(); // Output: Animal is eating
        dog.bark(); // Output: Dog is barking
    }
}

