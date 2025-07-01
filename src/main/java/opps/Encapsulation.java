package opps;

class Bank {
    private int accountNumber;
    private int balance;
    private String accountHolderName;

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.setAccountNumber(123456);
        bank.setAccountHolderName("Deepanshu");
        bank.setBalance(5000);

        bank.deposit(1500);
        bank.withdraw(2000);
        bank.summary();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {

        this.accountNumber = accountNumber;

    }

    public int getBalance() {

        return balance;
    }

    public void setBalance(int balance) {

        this.balance = balance;
    }

    public String getAccountHolderName() {

        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    // Deposit method
    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(int amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Method to print account summary
    public void summary() {
        System.out.println("Account Summary:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }
}

