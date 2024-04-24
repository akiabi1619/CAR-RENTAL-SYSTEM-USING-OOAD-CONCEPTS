public static class Vehicle {
    private int v_number;
    private String driver_N ;

    public Vehicle(int v_number, String driver_N) {
        this.v_number= v_number;
        this.driver_N= driver_N;
    }

    public void displayDetails() {
        System.out.println("Vehicle NO: " + v_number + " and DRIVER " + driver_N);
    }
}

public static class VehicleFactory {
    public Vehicle createVehicle(String type, String color) {
        return new Vehicle(type, color);
    }
}

private VehicleFactory factory = new VehicleFactory();
jButton2.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
    }