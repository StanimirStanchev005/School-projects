package classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainMenu extends javax.swing.JFrame {
    private Bank bank;
    private String saveLocation = null;
    
    public MainMenu() {
        initComponents();
        setLocationRelativeTo(null);
        bank = new Bank();
    }

    @SuppressWarnings("unchecked")
                     
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        addAccountButton = new javax.swing.JButton();
        removeAccountButton = new javax.swing.JButton();
        depositButton = new javax.swing.JButton();
        withdrawalButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        accountTable = new javax.swing.JTable();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bank Application");

        addAccountButton.setText("Add Account");
        addAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAccountButtonActionPerformed(evt);
            }
        });

        removeAccountButton.setText("Remove Account");
        removeAccountButton.setEnabled(false);
        removeAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAccountButtonActionPerformed(evt);
            }
        });

        depositButton.setText("Deposit");
        depositButton.setEnabled(false);
        depositButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositButtonActionPerformed(evt);
            }
        });

        withdrawalButton.setText("Withdrawal");
        withdrawalButton.setEnabled(false);
        withdrawalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawalButtonActionPerformed(evt);
            }
        });

        accountTable.setAutoCreateRowSorter(true);
        accountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "Account Number", "Balance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        accountTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        accountTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        accountTable.getTableHeader().setReorderingAllowed(false);
        accountTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(accountTable);
        if (accountTable.getColumnModel().getColumnCount() > 0) {
            accountTable.getColumnModel().getColumn(0).setResizable(false);
            accountTable.getColumnModel().getColumn(1).setResizable(false);
            accountTable.getColumnModel().getColumn(2).setResizable(false);
            accountTable.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addComponent(addAccountButton)
                .addGap(18, 18, 18)
                .addComponent(removeAccountButton)
                .addGap(18, 18, 18)
                .addComponent(depositButton)
                .addGap(18, 18, 18)
                .addComponent(withdrawalButton)
                .addContainerGap(101, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addAccountButton)
                    .addComponent(removeAccountButton)
                    .addComponent(depositButton)
                    .addComponent(withdrawalButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
        );

        fileMenu.setText("File");
        fileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuActionPerformed(evt);
            }
        });

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        openMenuItem.setText("Open");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveMenuItem.setText("Save");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveAsMenuItem.setText("Save As...");
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }                        

    private void addAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        AddAccountMenu menu = new AddAccountMenu(this, true, bank);
        menu.setVisible(true);
        if(menu.getCustomer()!=null){
            addCustomerToTable(menu.getCustomer());
        }
    }                                                

    private void removeAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        int selectedRow = accountTable.getSelectedRow();
        if(selectedRow>=0){
            Customer customer = getSelectedCustomer(selectedRow);
            if(customer != null) {
                bank.removeCustomer(customer); 
                removeCustomerFromTable(selectedRow);
            }
        }
    }                                                   

    private void depositButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        int selectedRow = accountTable.getSelectedRow();
        Customer customer = getSelectedCustomer(selectedRow);
        if(customer != null) {
            DepositMenu menu = new DepositMenu(this, true, customer);
            menu.setVisible(true);
            reloadCustomerRowData(selectedRow, customer);
        }
    }                                             

    private void withdrawalButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        int selectedRow = accountTable.getSelectedRow();
        Customer customer = getSelectedCustomer(selectedRow);
        if(customer != null) {
            WithdrawalMenu menu = new WithdrawalMenu(this, true, customer);
            menu.setVisible(true);
            reloadCustomerRowData(selectedRow, customer);
        }
    }                                                

    private void accountTableMouseClicked(java.awt.event.MouseEvent evt) {                                          
        setAccountButtonsActive(true);
        if(evt.getClickCount() == 2) {
            int selectedRow = accountTable.getSelectedRow();
            Customer customer = getSelectedCustomer(selectedRow);
            if(customer != null) {
                AccountDetailsPage page = new AccountDetailsPage(this, true, customer);
                page.setVisible(true);
            }
        }
    }                                         

    private void fileMenuActionPerformed(java.awt.event.ActionEvent evt) {                                         

    }                                        

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                             
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new BofFilter());
        chooser.setAcceptAllFileFilterUsed(false);
        int result = chooser.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION) {
            if(!chooser.getSelectedFile().toString().toLowerCase().endsWith(".bof")) {
                JOptionPane.showMessageDialog(this, "Unsupported file type selected!", "Unsupported File", JOptionPane.ERROR_MESSAGE);
            }
            else {
                try {
                    FileInputStream fIn = new FileInputStream(chooser.getSelectedFile());
                    ObjectInputStream objIn = new ObjectInputStream(fIn);
                    Object bankData = objIn.readObject();
                    if(bankData instanceof Bank) {
                    bank = (Bank) bankData;
                    reloadTable();                   
                }
                    saveLocation = chooser.getSelectedFile().toString();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }                                            

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if(saveLocation != null) {
            saveFile(saveLocation);
        }
        else {
            saveAsMenuItemActionPerformed(evt);        }
    }                                            

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                               
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new BofFilter());
        chooser.setAcceptAllFileFilterUsed(false);
        int result = chooser.showSaveDialog(this);
        if(result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            String fileName = file.toString();
            if(!fileName.toLowerCase().endsWith(".bof")) {
                fileName += ".bof";
            }
            boolean saved = saveFile(fileName);
            if(saved) {
                saveLocation = fileName;
            }
        }
        
    }                                              
    
    private boolean saveFile(String fileName) {
        try {
            FileOutputStream fOut = new FileOutputStream(fileName);
            ObjectOutputStream objOut = new ObjectOutputStream(fOut);
            objOut.writeObject(bank);
            objOut.close();
            fOut.close();
            return true;
        }  catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
    }
    
    private Customer getSelectedCustomer(int selectedRow){
        Customer customer = null;
        if(selectedRow >= 0){
            int accountNumber = (int) accountTable.getValueAt(selectedRow, 2);
            customer = bank.getCustomerByAccountNumber(accountNumber);
        }
        return customer;
    }
    private void addCustomerToTable(Customer customer){
        DefaultTableModel model = (DefaultTableModel) accountTable.getModel();
        model.addRow(new Object[]{});
        reloadCustomerRowData(model.getRowCount() - 1, customer);
    }
    private void removeCustomerFromTable(int row){
        DefaultTableModel model = (DefaultTableModel) accountTable.getModel();
        model.removeRow(row);
    }
    private void reloadCustomerRowData(int selectedRow, Customer customer) {
        DefaultTableModel model = (DefaultTableModel) accountTable.getModel();
        model.setValueAt(customer.getFirstName(), selectedRow, 0);
        model.setValueAt(customer.getLastName(), selectedRow, 1);
        model.setValueAt(customer.getAccount().getAccountNumber(), selectedRow, 2);
        model.setValueAt(String.format("%.2f",customer.getAccount().getBalance()), selectedRow, 3);
    }
    private void reloadTable(){
        for(Customer c : bank.getCustomers()) {
            addCustomerToTable(c);
        }
    }
    private void setAccountButtonsActive(boolean active) {
        removeAccountButton.setEnabled(active);
        depositButton.setEnabled(active);
        withdrawalButton.setEnabled(active);
    }
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }
                   
    private javax.swing.JTable accountTable;
    private javax.swing.JButton addAccountButton;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton depositButton;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JButton removeAccountButton;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JButton withdrawalButton;           
}