package es.ufv.dis.final2024.ALB.model;

public class ShipRequest {
    private String ship;

    public ShipRequest() {
    }

    public ShipRequest(String ship) {
        this.ship = ship;
    }

    public String getShip() { return ship; }
    public void setShip(String ship) { this.ship = ship; }
}
