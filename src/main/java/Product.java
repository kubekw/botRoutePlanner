public class Product {

    private String name;
    private int x;
    private int y;
    private int n;
    private double accssTime;

    public Product(String name, int x, int y, int n) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.n = n;
    }

    public double getAccssTime() {
        return accssTime;
    }

    public void setAccssTime(double accssTime) {
        this.accssTime = accssTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
