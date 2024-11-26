package As1_Crops;

public class As1_Crop {
    private String name;
    private double yield; //bu/acres
    private String units;
    private double price;
    private int acres;

    public As1_Crop( String n, double y, String u, double p ){
        name = n;
        yield = y;
        units = u;
        price = p;
        acres = 0;
    }

    public void printMe() {
    System.out.println(
        "Name: " + name + "\n" +
        "Yield: " + yield + " " + units + "\n" +
        "Price: $" + price + "\n" +
        "Acres: " + acres);
    }

    public String toString(){
        return name + ", yield: " + yield + ", units: " + units + ", price: " + price + ", acres: " + acres;
    }
    public String getName() {
        return name;
    }

    public double getYield() {
        return yield;
    }

    public String getUnits() {
        return units;
    }

    public double getPrice() {
        return price;
    }

    public int getAcres() {
        return acres;
    }

    public void setAcres(int acres) {
        this.acres = acres;
    }
}
