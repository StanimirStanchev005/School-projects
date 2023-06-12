package classes;

public class Savings extends Account{
    private static String accountType="Savings";
    
        Savings(double initialDeposit){
        super();
        this.setBalance(initialDeposit);
        this.checkInterest(0);
        this.setTransactionFee(5);
    }
    
    @Override
    public String toString(){
        return "Account type: " + accountType + " Account\n" +
               "Account Number: " + this.getAccountNumber() +"\n" +
               "Balance: " + this.getBalance() +"\n" +
               "Interest rate: " + (this.getInterest()*100) + "%\n";
    }

    @Override
    public String getAccountType() {
        return accountType;
    }
}

