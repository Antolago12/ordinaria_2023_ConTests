package es.ufv.dis.final2024.ALB.model;

public class ShipRequestCount {
    private String name;
    private int count;

    public ShipRequestCount() {
    }

    public ShipRequestCount(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }
}
