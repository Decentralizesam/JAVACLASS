

public class Human {
    public String name;
    public int age;
    public double height;
    public double weight;
    private String gender;
    //Constructors
    public Human(String name, int age, double weight){
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Human(String name,int age){
        this.name = name;
        this.age = age;
    }

        
        public void display(){
            System.out.println("Name:"+name);
            System.out.println("Age:"+age);
            System.out.println("gender::"+gender);
            System.out.println("Height:"+height);
            System.out.println("Weight:"+weight+"KG");
        }

        public static void main(String[] args) {
            Human person1 = new Human("Alice",25,45);
            Human person2 = new Human("Bob",35);
            Human person3 = new Human("Charlie",50);

            person1.name="Alice";
            person1.age=25;
            person1.weight=45;

            person2.name="Bob";
            person2.age=35;

            person3.name="Charlie";
            person3.age=50;

            person1.display();
            person2.display();
            person3.display();
        }
    }

        
