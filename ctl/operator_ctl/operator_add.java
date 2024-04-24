package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;


public class VehicleBuilder {
    private String vehicleName;
    private String vehicleNumber;
    private String fromPlace;
    private String destination;
    private String arrivalTime;
    private String departureTime;
    private String facilityLevel;
    private String driverName;

    public VehicleBuilder setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
        return this;
    }

    public VehicleBuilder setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        return this;
    }

    public VehicleBuilder setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
        return this;
    }

    public VehicleBuilder setDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public VehicleBuilder setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    public VehicleBuilder setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    public VehicleBuilder setFacilityLevel(String facilityLevel) {
        this.facilityLevel = facilityLevel;
        return this;
    }

    public VehicleBuilder setDriverName(String driverName) {
        this.driverName = driverName;
        return this;
    }

    public void build() {
        try {
            Class.forName("java.sql.DriverManager");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_reservations", "root", "root");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into vehicles(vehicle_name, vehicle_no, from_place, destination, arrival_time, departure_time, facility_level, Driver_Name) values('" + vehicleName + "','" + vehicleNumber + "','" + fromPlace + "','" + destination + "','" + arrivalTime + "','" + departureTime + "','" + facilityLevel + "','" + driverName + "');");
            statement.executeUpdate("insert into bill values () ");
            JOptionPane.showMessageDialog(null, "Inserted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
public class AddForm extends javax.swing.JFrame {

    public AddForm() {
        initComponents();
        this.setLocation(400, 90);
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        String vehicleName = jTextField1.getText();
        String vehicleNumber = jTextField2.getText();
        String fromPlace = jTextField3.getText();
        String destination = jTextField4.getText();
        String arrivalTime = jTextField5.getText();
        String departureTime = jTextField6.getText();
        String facilityLevel = jTextField7.getText();
        String driverName = jTextField9.getText();

        new VehicleBuilder()
                .setVehicleName(vehicleName)
                .setVehicleNumber(vehicleNumber)
                .setFromPlace(fromPlace)
                .setDestination(destination)
                .setArrivalTime(arrivalTime)
                .setDepartureTime(departureTime)
                .setFacilityLevel(facilityLevel)
                .setDriverName(driverName)
                .build();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        new SelectForm().setVisible(true);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField1.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField5.setText(null);
        jTextField6.setText(null);
        jTextField7.setText(null);
        jTextField9.setText(null);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
    
