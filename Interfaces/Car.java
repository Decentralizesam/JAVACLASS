
interface carInterface {
    void start();
    void stop();
    String getModel();
    
    String MODEL = "Tesla"; //Constant field
}

// Class
class MyCar implements carInterface 
    {
    private String model;

    // Constructor
    public MyCar(String model) {
        this.model = model;
    }

    //methods
    @Override
    public void start() {
        System.out.println("Starting the car.");
    }

    @Override
    public void stop() {
        System.out.println("Stopping the car.");
    }

    @Override
    public String getModel() {
        return model;
    }
}

// Main class
 class Car{
    public static void main(String[] args) {
        MyCar myCar = new MyCar("Tesla");
        myCar.start();
        System.out.println("Model: " + myCar.getModel());
        myCar.stop();
    }
}

