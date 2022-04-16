import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        VeriBankasi.hastaneOlustur();
        girisEkrani();
    }

    public static void girisEkrani(){
        System.out.println("Hasta girişi için: 1\nDoktor girişi için: 2\nHastane girişi için : 3\nÇıkış için: 4");
        String girisSecimStr = scan.nextLine();
        try {
            int girisSecim = Integer.parseInt(girisSecimStr.replaceAll("\\D",""));
            if (girisSecim ==1){
                HastaIslemleri.hastaGirisi();
            }else if (girisSecim ==2){
                DoktorIslemleri.doktorGirisEkrani();
            }else if (girisSecim ==3){
               HastaneIslemleri.hastaneGirisEkrani();
            }else if (girisSecim==4){
                System.exit(0);
            }
            girisEkrani();

        } catch (Exception e) {
            System.out.println("Hatalı giriş.Tekrar deneyin");
            girisEkrani();

        }

    }











}
