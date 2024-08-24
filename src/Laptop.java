public class Laptop {
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Laptop(int ram, int storage, String os, String color) {
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }
    public int getRam() {
        return ram;
    }
    public int getStorage() {
        return storage;
    }
    public String getOs() {
        return os;
    }
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Laptop{" + ", " +
                "ram=" + ram + "," + " " +
                "storage=" + storage + "," + " " +
                "os='" + os + '\'' + "," + " " +
                "color='" + color + '\'' + '}';
    }
}
