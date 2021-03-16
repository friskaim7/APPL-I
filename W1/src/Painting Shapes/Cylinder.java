public class Cylinder extends Shape {
    private double radius, height;

    public Cylinder(double radius, double height) {
        super("Cylinder");
        this.radius = radius;
        this.height = height;
    }

    public double area() {
        return Math.PI * this.radius * this.radius * this.height;
    }

    public String toString() {
        return super.toString() + " of radius " + this.radius + " and height " + this.height;
    }
}