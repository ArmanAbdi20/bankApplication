public class Customer {

    public String name;
    public String accountNumer;
    public String password;
    public String phoneNumber;
    public String email;
    public double balance;


    public Customer(String name, String accountNumer, String password, String phoneNumber, String email, double balance) {
        this.name = name;
        this.accountNumer = accountNumer;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.balance = balance;
        printInformation();
    }

    public void printInformation() {
        System.out.println(
                "name= " + name +
                "\naccountNumer= " + accountNumer +
                "\nphoneNumber= " + phoneNumber +
                "\npassWord= " + password +
                "\nemail=" + email );
    }


    public void addBalance(double amount) {//para yatırma methodu
        this.balance+= amount;
        System.out.println("Sayın " + name + ", hesabınıza " + amount + " tl yatırılmıştır");
    }

    public void withdrawMoney (double amount) {// para çekme methodu

        if (amount<=balance){
            this.balance-=amount;
            System.out.println("Sayın " + name + ", hesabınızdan " + amount + " tl çekilmiştir");
        } else {
            System.out.println("Bakiyeniz " + amount + " tl çekmek için yetersiz!!");
        }
    }

    public void printBalance() {// bakiye yazdırma
        System.out.println("Bakiyeniz " + balance);
    }

    public void changePassword(){//şifre değiştirme

    }
}
