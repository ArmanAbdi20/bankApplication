import java.util.Scanner;

public class Main {

    public static Scanner scan= new Scanner(System.in);
    public static void main(String[] args) {


    Customer customer1 = new Customer("abdi", "0020","1453","0555","abdi@abdi.com",10000);


    // Kullanıcıya hesap numarası ve şifresi sorularak kontrol sağlanır. doğruysa sisteme girer
        // yanlışsa sisteme girene kadar soru tekrarlanır

        // ana menüyü yazdır





    // kullanıcı giriş yaptıktan sonra ana menüde bazı seçeneklerle karşılaşır
    /*
    1-bakiye yazdır
    2-Para yatır
    3- para çek
    4- bilgileri değiştir.
    5- çıkış yap
     */

    // her işlem sonunda kullanıcıya başka bir işlem yapmak isteyip istemediği sorulacak
        // evet denirse menü tekrardan yazdırılarak ana menüye gidilecek
        // hayır denirse sistemden çıkış yapılacak
        while (true) {
            starPrint("banka uygulamamıza hoş geldiniz :");
            System.out.print("Lütfen hesap numaranızı giriniz :");
            String inputAccountNo= scan.next();
            if(inputAccountNo.equals(customer1.accountNumer)){
                System.out.print("Lütfen şifrenizi giriniz");
                String inputPassword=scan.next();
                if (inputPassword.equals(customer1.password)){
                    System.out.println("Sayın "+ customer1.name.toUpperCase()+ ", Hoşgeldiniz");
                    break;
                }else {
                    System.out.println("Lütfen şifrenizi doğru giriniz.");
                }
            } else{
                System.out.println("lütfen hessap numaranızı doğru giriniz.");
            }


        }
        int devam=1;
        while (devam==1){

            anaMenu();
            int islem =scan.nextInt();
            // kullanıcıdan işlem girdisi al
            //işleme göre metod oluşturp call et

            switch (islem){
                case 1:
                    bakiyeYazdır(customer1);
                    devam= devamMı();
                    break;
                case 2:
                    paraYatir(customer1);
                    devam= devamMı();
                    break;
                case 3:
                    paraCek(customer1);
                    devam= devamMı();
                    break;
                case 4:
                    customer1.changePassword();
                    devam= devamMı();
                    break;
                case 5:
                    devam=0;
                    starPrint("Bizi tercih ettiğiniz için teşekkürler, yine bekleriz");
                    break;

            }

        }





        }// main sonu

    public static int devamMı() {
        System.out.println("Başka işlem yapmak istiyor musunuz \n evet : 1 \n hayır :0");
        int devamInput= scan.nextInt();
        return devamInput;
    }

    public static void paraCek(Customer customer1) {
        System.out.println("Kaç para çekmek istiyorsunuz? ");
        double inputMiktar=scan.nextDouble();
        if (pozitifMi(inputMiktar)){
            customer1.withdrawMoney(inputMiktar);
        } else {
            System.out.println("Lütfen pozitif bir sayı giriniz");
            paraYatir(customer1);
        }

    }

    public static void paraYatir(Customer customer1) {
        System.out.println("kaç para yatırmak istiyorsunuz? ");
        double inputMiktar=scan.nextDouble();
        if (pozitifMi(inputMiktar)){
            customer1.addBalance(inputMiktar);
        } else {
            System.out.println("Lütfen pozitif bir sayı giriniz");
            paraYatir(customer1);
        }

    }

    public static boolean pozitifMi(double i) {
        if (i>0){
            return true;
        }
        return false;
    }

    public static void bakiyeYazdır(Customer customer) {
        customer.printBalance();

    }

    public static void starPrint(String text){
        System.out.println("*********************************************************\n");
        System.out.println(text);
        System.out.println("*********************************************************\n");
    }

    public static void anaMenu (){
        starPrint("Lütfen yapacağınız işlemi seçiniz \n " +
                "1-bakiye yazdır\n"+
                "2-Para yatır \n"+
                "3-Para çek \n"+
                "4-Bilgileri değiştir\n"+
                "5- Çıkış yap");

    }
}