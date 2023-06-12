package classes;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class WithdrawalMenu extends javax.swing.JDialog {

    private final Customer customer;

    public WithdrawalMenu(java.awt.Frame parent, boolean modal, Customer customer) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.customer = customer;
    }

    @SuppressWarnings("unchecked")
                             
    private void initComponents() {

        amountLabel = new javax.swing.JLabel();
        amountField = new javax.swing.JTextField();
        withdrawalButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Deposit Menu");
        getContentPane().setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        amountLabel.setText("Withdrawal Amount:");
        getContentPane().add(amountLabel);
        getContentPane().add(amountField);

        withdrawalButton.setText("Withdrawal");
        withdrawalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawalButtonActionPerformed(evt);
            }
        });
        getContentPane().add(withdrawalButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);

        pack();
    }                       

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        this.dispose();
    }                                            

    private void withdrawalButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        StringBuilder warnings = new StringBuilder();
        if(amountField.getText().isEmpty()){
            warnings.append("Withdrawal amount is required!\n");
        }
        else {
            double amount = 0;
            try {
                 amount = Double.parseDouble(amountField.getText());
                 int result = JOptionPane.showConfirmDialog(this, "Withdraw $" + String.format("%.2f", amount) + " from the account?\nTransaction fee: $" + String.format("%.2f", customer.getAccount().getTransactionFee()));
                 if(result == JOptionPane.OK_OPTION) {
                     try {
                         customer.getAccount().withdraw(amount);
                         this.dispose();
                     } catch (InsufficientFundsException ex) {
                         warnings.append("Insufficient funds to complete transaction!\n");
                     }
                 }
             }
             catch(NumberFormatException ex){
                 warnings.append("Withdrawal amount must be a number!\n");
             }
        }
        if(warnings.length() > 0) {
            JOptionPane.showMessageDialog(this, warnings.toString(), "Withdrawal Warnings", JOptionPane.WARNING_MESSAGE);
        }
    }                                                
                    
    private javax.swing.JTextField amountField;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton withdrawalButton;                  
}