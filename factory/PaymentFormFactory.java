package e_reservation;

import javax.swing.JFrame;

public class PaymentFormFactory {
    
    
    private PaymentFormFactory() {}
    
    
    public enum PaymentMethod {
        CREDIT_CARD,
        DEBIT_CARD,
        UPI,
        
    }
    
    
    public static JFrame createPaymentForm(PaymentMethod method) {
        switch(method) {
            case CREDIT_CARD:
                return new CreditCardForm();
            case DEBIT_CARD:
                return new DebitCardForm();
            case UPI:
                return new UPIForm();
            
            default:
                throw new IllegalArgumentException("Invalid payment method");
        }
    }
}


JFrame creditCardForm = PaymentFormFactory.createPaymentForm(PaymentFormFactory.PaymentMethod.CREDIT_CARD);
creditCardForm.setVisible(true);

JFrame debitCardForm = PaymentFormFactory.createPaymentForm(PaymentFormFactory.PaymentMethod.DEBIT_CARD);
debitCardForm.setVisible(true);


JFrame upiForm = PaymentFormFactory.createPaymentForm(PaymentFormFactory.PaymentMethod.UPI);
upiForm.setVisible(true);

