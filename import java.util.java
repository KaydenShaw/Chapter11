import java.util.Date;

class GeometricObject {
    private String color = "white";
    private boolean filled;
    private Date dateCreated;
    protected GeometricObject() {
        dateCreated = new Date();
    }
    protected GeometricObject(String color, boolean filled) {
        this();
        this.color = color;
        this.filled = filled;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public Date getDateCreated() {
        return dateCreated;
    }
    @Override
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }
}
class Triangle extends GeometricObject {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;
    public Triangle() {
    }
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public double getSide1() {
        return side1;
    }
    public double getSide2() {
        return side2;
    }
    public double getSide3() {
        return side3;
    }
    public double getArea() {
        double s = (side1 + side2 + side3) / 2.0;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }
}
public class Main {
    public static void main(String[] args) {
        Triangle t1 = new Triangle();
        System.out.println(t1.toString());
        System.out.println("Area: " + t1.getArea());
        System.out.println("Perimeter: " + t1.getPerimeter());
        Triangle t2 = new Triangle(3.0, 4.0, 5.0);
        System.out.println("\n" + t2.toString());
        System.out.println("Area: " + t2.getArea());
        System.out.println("Perimeter: " + t2.getPerimeter());
    }
}