public class Person {
    private String name;
    private int age;
    private String stream;

    // Constructor
    public Person(String name, int age, String stream) {
        this.name = name;
        this.age = age;
        this.stream = stream;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    // toString method to represent the object as a string
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", stream='" + stream + '\'' +
                '}';

    }
                    public static void main(String[] args) {
                        // Creating instances of Person class
                        Person person1 = new Person("John", 25, "Engineering");
                        Person person2 = new Person("Alice", 22, "Medicine");
                        Person person3 = new Person("Bob", 28, "Computer Science");
                        Person person4 = new Person("Emily", 24, "Psychology");
                        Person person5 = new Person("Michael", 30, "Business");
                        Person person6 = new Person("Sarah", 21, "Mathematics");
                
                        // Outputting the information of each person
                        System.out.println(person1);
                        System.out.println(person2);
                        System.out.println(person3);
                        System.out.println(person4);
                        System.out.println(person5);
                        System.out.println(person6);
                    }
}

