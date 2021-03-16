abstract public class Shape {
    private String shapeName;

    abstract public double area();
    
    public String toString() {
        return this.shapeName;
    }
}
