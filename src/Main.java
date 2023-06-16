import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String userName = "Serkan";
        String password = "Ser123";

        Scanner giris = new Scanner(System.in);

        System.out.println("ATM'ye Hoş Geldiniz!");

        int right = 3;

        while (right > 0) {
            System.out.print("Kullanıcı Adı : ");
            String kullaniciAdi = giris.nextLine();

            System.out.print("Şifre : ");
            String sifre = giris.nextLine();

            if (kullaniciAdi.equals(userName) && sifre.equals(password)) {
                System.out.println("Giriş başarılı!");
                atmIslemleriniYap();
                break;
            } else {
                right--;
                System.out.println("Geçersiz kullanıcı adı veya şifre! Kalan giriş hakkı : " + right);
                if (right == 0) {
                    System.out.println("Giriş hakkınız tükendi. ATM kartınız bloke edildi.");
                }
            }
        }
    }

public static void atmIslemleriniYap() {
        Scanner input = new Scanner(System.in);
        int balance = 1000;

        while (true) {
            System.out.println("1. Bakiye Sorgulama");
            System.out.println("2. Para Yatırma");
            System.out.println("3. Para Çekme");
            System.out.println("4. Çıkış");
            System.out.print("Lutfen yapmak istediğiniz işlemi seçiniz : ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Bakiyeniz : " + balance + " TL ");
                    // Bakiye sorgulama
                    break;
                case 2:
                    System.out.print("Yatırmak istediğiniz miktarı girin : ");
                    int yatirilanMiktar = input.nextInt();
                    balance += yatirilanMiktar;
                    System.out.println("Yeni bakiyeniz : " + balance + " TL");
                    break;
                case 3:
                    System.out.print("Çekmek istediğiniz miktarı girin : ");
                    int cekilenMiktar = input.nextInt();
                    if (cekilenMiktar > balance) {
                        System.out.println("Yetersiz bakiye!");
                    } else {
                        balance -= cekilenMiktar;
                        System.out.println("Yeni bakiyeniz : " + balance + " TL");
                    }
                    break;
                case 4:
                    System.out.println("Çıkış yapılıyor...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Geçersiz bir seçim yaptınız.");
                    break;
            }
            System.out.println(); // Boş bir satır bırakarak menünün daha okunabilir olmasını sağlıyoruz.
        }
    }
}