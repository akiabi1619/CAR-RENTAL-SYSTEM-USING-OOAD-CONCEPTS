// PaymentForm interface representing common functionality for all payment forms

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;





interface PaymentForm {
    void processPayment();
    
}
// DebitCardForm class implementing PaymentForm for processing debit card payments
class DebitCardForm implements PaymentForm {
    @Override
    public void processPayment() {




interface DatabaseConnection {
    void connect();
    void disconnect();
    ResultSet executeQuery(String query) throws SQLException;
    void executeUpdate(String query) throws SQLException;
}


class RealDatabaseConnection implements DatabaseConnection {
    private Connection connection;

    @Override
    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_reservations", "root", "root");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    @Override
    public void executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }
}

// Proxy class for the database connection
class DatabaseConnectionProxy implements DatabaseConnection {
    private RealDatabaseConnection realConnection;

}

public class CreditForm extends javax.swing.JFrame {
    private DatabaseConnection databaseProxy;

    public CreditForm() {
        initComponents();
        this.setLocation(400, 90);

        // Initialize the database proxy
        databaseProxy = new DatabaseConnectionProxy();
    }

   
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String a, b, e, c, d;
        a = cardno.getText();
        if (a.length() == 16) {
            b = name.getText();
            c = exp.getText();
            d = jour.getText();
            e = vehno.getText();
            int x = 0;
            try {
                // Use the proxy to connect to the database
                databaseProxy.connect();

                // Perform database operations
                ResultSet rs = databaseProxy.executeQuery("select * from details where journey_date = '" + d + "' AND vehicle_no = '" + e + "'");
                if (rs.next()) {
                    databaseProxy.executeUpdate("insert into credit values('" + a + "','" + b + "','" + c + "','" + d + "','" + e + "');");
                    JOptionPane.showMessageDialog(this, "Your ticket has been booked successfully! Thank you for choosing us and please check your vehicle number!");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Journey Date or Vehicle Number!");
                }

            } catch (SQLException f) {
                JOptionPane.showMessageDialog(this, f.getMessage());
            } finally {
                // Disconnect from the database using the proxy
                databaseProxy.disconnect();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Your card number is invalid! Please enter valid credentials");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        /
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CreditForm().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cardno;
    private javax.swing.JTextField exp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jour;
    private javax.swing.JTextField name;
    private javax.swing.JTextField vehno;
    // End of variables declaration//GEN-END:variables
}

       
    }
   
}

// CreditCardForm class implementing PaymentForm for processing credit card payments
class CreditCardForm implements PaymentForm {
    @Override
    public void processPayment() {
        


interface DatabaseConnection {
    void connect();
    void disconnect();
    ResultSet executeQuery(String query) throws SQLException;
    void executeUpdate(String query) throws SQLException;
}


class RealDatabaseConnection implements DatabaseConnection {
    private Connection connection;

    @Override
    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_reservations", "root", "root");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    @Override
    public void executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }
}

// Proxy class for the database connection
class DatabaseConnectionProxy implements DatabaseConnection {
    private RealDatabaseConnection realConnection;

}

public class CreditForm extends javax.swing.JFrame {
    private DatabaseConnection databaseProxy;

    public CreditForm() {
        initComponents();
        this.setLocation(400, 90);

        // Initialize the database proxy
        databaseProxy = new DatabaseConnectionProxy();
    }

   
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String a, b, e, c, d;
        a = cardno.getText();
        if (a.length() == 16) {
            b = name.getText();
            c = exp.getText();
            d = jour.getText();
            e = vehno.getText();
            int x = 0;
            try {
                // Use the proxy to connect to the database
                databaseProxy.connect();

                // Perform database operations
                ResultSet rs = databaseProxy.executeQuery("select * from details where journey_date = '" + d + "' AND vehicle_no = '" + e + "'");
                if (rs.next()) {
                    databaseProxy.executeUpdate("insert into credit values('" + a + "','" + b + "','" + c + "','" + d + "','" + e + "');");
                    JOptionPane.showMessageDialog(this, "Your ticket has been booked successfully! Thank you for choosing us and please check your vehicle number!");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Journey Date or Vehicle Number!");
                }

            } catch (SQLException f) {
                JOptionPane.showMessageDialog(this, f.getMessage());
            } finally {
                // Disconnect from the database using the proxy
                databaseProxy.disconnect();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Your card number is invalid! Please enter valid credentials");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        /
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CreditForm().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cardno;
    private javax.swing.JTextField exp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jour;
    private javax.swing.JTextField name;
    private javax.swing.JTextField vehno;
    // End of variables declaration//GEN-END:variables
}



       
    }
   
}

// Application class using the PaymentForm interface to process payments
public class PaymentApplication {
    private PaymentForm paymentForm;

    public PaymentApplication(PaymentForm paymentForm) {
        this.paymentForm = paymentForm;
    }

    public void processPayment() {
        paymentForm.processPayment();
    }

    
}
