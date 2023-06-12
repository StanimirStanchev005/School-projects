package classes;
public class AccountDetailsPage extends javax.swing.JDialog {

    public AccountDetailsPage(java.awt.Frame parent, boolean modal, Customer customer) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setTitle(String.format("Account Details Page - %s %s", customer.getFirstName(), customer.getLastName()));
        firstNameField.setText(customer.getFirstName());
        lastNameField.setText(customer.getLastName());
        identificationNumberField.setText(customer.getIdentificationNumber());
        typeField.setText(customer.getAccount().getAccountType());
        accountNumberField.setText(String.valueOf(customer.getAccount().getAccountNumber()));
        balanceField.setText(String.format("$%.2f", customer.getAccount().getBalance()));
        interestField.setText(String.valueOf(customer.getAccount().getInterest()*100) + "%");
        feeField.setText(String.format("$%.2f", customer.getAccount().getTransactionFee()));
        
    }
    @SuppressWarnings("unchecked")
                         
    private void initComponents() {

        firstNameLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        lastNameField = new javax.swing.JLabel();
        identificationNumberLabel = new javax.swing.JLabel();
        identificationNumberField = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        typeField = new javax.swing.JLabel();
        accountNumberLabel = new javax.swing.JLabel();
        accountNumberField = new javax.swing.JLabel();
        balanceLabel = new javax.swing.JLabel();
        balanceField = new javax.swing.JLabel();
        interestLabel = new javax.swing.JLabel();
        interestField = new javax.swing.JLabel();
        feeLabel = new javax.swing.JLabel();
        feeField = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(8, 2, 5, 5));

        firstNameLabel.setText("First Name:");
        getContentPane().add(firstNameLabel);
        getContentPane().add(firstNameField);

        lastNameLabel.setText("Last Name:");
        getContentPane().add(lastNameLabel);
        getContentPane().add(lastNameField);

        identificationNumberLabel.setText("Identification Number:");
        getContentPane().add(identificationNumberLabel);
        getContentPane().add(identificationNumberField);

        typeLabel.setText("Account Type:");
        getContentPane().add(typeLabel);
        getContentPane().add(typeField);

        accountNumberLabel.setText("Account Number:");
        getContentPane().add(accountNumberLabel);
        getContentPane().add(accountNumberField);

        balanceLabel.setText("Balance:");
        getContentPane().add(balanceLabel);
        getContentPane().add(balanceField);

        interestLabel.setText("Interest Rate:");
        getContentPane().add(interestLabel);
        getContentPane().add(interestField);

        feeLabel.setText("Transaction Fee:");
        getContentPane().add(feeLabel);
        getContentPane().add(feeField);

        pack();
    }                      
                 
    private javax.swing.JLabel accountNumberField;
    private javax.swing.JLabel accountNumberLabel;
    private javax.swing.JLabel balanceField;
    private javax.swing.JLabel balanceLabel;
    private javax.swing.JLabel feeField;
    private javax.swing.JLabel feeLabel;
    private javax.swing.JLabel firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel identificationNumberField;
    private javax.swing.JLabel identificationNumberLabel;
    private javax.swing.JLabel interestField;
    private javax.swing.JLabel interestLabel;
    private javax.swing.JLabel lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel typeField;
    private javax.swing.JLabel typeLabel;               
}