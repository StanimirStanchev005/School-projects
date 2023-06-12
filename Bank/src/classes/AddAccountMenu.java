package classes;

import javax.swing.JOptionPane;

public class AddAccountMenu extends javax.swing.JDialog {
    private Bank bank;
    private Customer customer;
    
    public AddAccountMenu(java.awt.Frame parent, boolean modal, Bank bank) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.bank=bank;
        customer = null;
    }

   
    @SuppressWarnings("unchecked")
                        
    private void initComponents() {

        firstNameLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        identificationNumberLabel = new javax.swing.JLabel();
        identificationNumberField = new javax.swing.JTextField();
        depositLabel = new javax.swing.JLabel();
        depositField = new javax.swing.JTextField();
        typeLabel = new javax.swing.JLabel();
        typeBox = new javax.swing.JComboBox<>();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Account Menu");
        getContentPane().setLayout(new java.awt.GridLayout(6, 2, 5, 5));

        firstNameLabel.setText("First Name:");
        getContentPane().add(firstNameLabel);

        firstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(firstNameField);

        lastNameLabel.setText("Last Name:");
        getContentPane().add(lastNameLabel);
        getContentPane().add(lastNameField);

        identificationNumberLabel.setText("Identification Number:");
        getContentPane().add(identificationNumberLabel);

        identificationNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identificationNumberFieldActionPerformed(evt);
            }
        });
        getContentPane().add(identificationNumberField);

        depositLabel.setText("Initial Deposit:");
        getContentPane().add(depositLabel);
        getContentPane().add(depositField);

        typeLabel.setText("Account Type:");
        getContentPane().add(typeLabel);

        typeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Checking", "Savings" }));
        getContentPane().add(typeBox);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        getContentPane().add(okButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);

        pack();
    }                   

    private void firstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {                                               

    }                                              

    private void identificationNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                          

    }                                                         

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        this.dispose();
    }                                            

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        StringBuilder warnings = new StringBuilder();
        String firstName = "", lastName = "";
        double amount = 0;
        if(firstNameField.getText().isEmpty()){
            warnings.append("First name is required!\n");
        }
        else {
          firstName = firstNameField.getText();
        }
        if(lastNameField.getText().isEmpty()){
            warnings.append("Last name is required!\n");
        }
         else {
          lastName = lastNameField.getText();
        }
        if(identificationNumberField.getText().length()>10||identificationNumberField.getText().length()<10){
            warnings.append("Identification number must be 10 digits!\n");
        }
         if(depositField.getText().isEmpty()){
            warnings.append("Initial deposit is required!\n");
        }
         else {
             try {
                 amount = Double.parseDouble(depositField.getText());
             }
             catch(NumberFormatException ex){
                 warnings.append("Initial deposit must be a number!");
             }
         }
        if(warnings.length()>0){
            JOptionPane.showMessageDialog(this, warnings.toString(), "Warnings", JOptionPane.WARNING_MESSAGE);
        }
        else {
            Account account = null;
            if(typeBox.getSelectedItem().toString()=="Checking"){
                if(amount>=100) {
                account = new Checking(amount);
                }
                else {
                warnings.append("Initial deposit must be at least $100 for Checking accounts!");
                }
            }
            else {
                if(typeBox.getSelectedItem().toString()=="Savings"){
                    if(amount>=50) {
                        account = new Checking(amount);
                    }
                    else {
                        warnings.append("Initial deposit must be at least $50 for Savings accounts!");
                    }
                }
            }
            if(account != null){
                customer = new Customer(firstName, lastName, identificationNumberField.getText(), account);
                bank.addCustomer(customer);
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(this, warnings.toString(), "Warnings", JOptionPane.WARNING_MESSAGE);
            }
        }
    }                                        
                    
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField depositField;
    private javax.swing.JLabel depositLabel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField identificationNumberField;
    private javax.swing.JLabel identificationNumberLabel;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox<String> typeBox;
    private javax.swing.JLabel typeLabel;             

    Customer getCustomer() {
     return customer;
    }
}