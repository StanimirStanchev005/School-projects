package classes;

import java.io.Serializable;

public class Customer implements Serializable{

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    private final String firstName;
    private final String lastName;
    private final String identificationNumber;
    private final Account account;
        
    Customer(String firstName, String lastName, String identificationNumber, Account account) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.identificationNumber=identificationNumber;
        this.account=account;
    }

    @Override
    public String toString(){
        return "\n Customer information\n"+
                "First name: "+getFirstName() + "\n"+
                "Last name: "+getLastName() + "\n"+
                "identificationNumber: "+ getIdentificationNumber() +"\n"+
                account;
                }
    public String basicInfo(){
        return  " First name: "+getFirstName() +
                " Last name: "+getLastName() +
                " identificationNumber: "+ getIdentificationNumber() +
                " Account number: "+account.getAccountNumber();
                }
    Account getAccount(){
        return account;
    }
}