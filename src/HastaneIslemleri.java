import java.util.ArrayList;
import java.util.List;

public class HastaneIslemleri {

    public static void hastaneGirisEkrani() {
        System.out.println("Hastane id girin");
        VeriBankasi.hastaneListesi();
        String idStr=Main.scan.nextLine();
        try {
            int id = Integer.parseInt(idStr.replaceAll("\\D",""));
            hastaneGiris(id);
        } catch (Exception e) {
            hastaneGirisEkrani();
        }

    }
    private static void hastaneGiris(int id){
        if (id>0 && id<= VeriBankasi.hastaneler.size()){

            for (Hastane hastane: VeriBankasi.hastaneler){
                if (id==hastane.getId()){

                    System.out.println("Hastanemizde çalışan doktorların listesini görmek icin 1\nHasta kayıtlarını görmek icin 2" +
                            "\nYeni doktor kaydı için 3\nDoktor kaydı silmek için 4\nÇıkmak için 5 girin");
                    int secim= Main.scan.nextInt();
                    Main.scan.nextLine();
                    if (secim==5)Main.girisEkrani();
                    switch(secim){
                        case 1: tumDoktorlar(hastane);break;
                        case 2: tumHastalar(hastane); break;
                        case 3: doktorEkle(hastane); break;
                        case 4: doktorSil(hastane); break;
                    }
                    hastaneGiris(id);

                }
            }
        }else{
            System.out.println("Hatalı secim. Tekrar deneyin");
            hastaneGirisEkrani();
        }
    }

    private static void tumDoktorlar(Hastane hastane){
        System.out.println("*** Hastanemizde yer alan doktorlarımız ***");
        System.out.println(hastane.doktorlar);
    }
    private static void tumHastalar(Hastane hastane){
        System.out.println("*** Kayıtlı Hastalarımız ***");
        System.out.println(hastane.hastalar);
    }
    private static void doktorEkle(Hastane hastane){
        System.out.println("İsim girin");
        String isim=Main.scan.nextLine();
        System.out.println("Soyisim girin");
        String soyisim=Main.scan.nextLine();
        System.out.println("Bölüm girin");
        String bolum=Main.scan.nextLine();
        hastane.doktorlar.add(new Doktor(isim,soyisim,bolum));
        System.out.println("Yeni doktor kaydı tamamlandı");
    }
    private static void doktorSil(Hastane hastane){
        List<Integer> tempIdList = new ArrayList<>();
        for (Doktor d: hastane.doktorlar){
            tempIdList.add(d.getId());
            System.out.println(d.getId()+"  Dr."+d.getIsim()+" "+d.getSoyIsim());
        }
        System.out.println("Kaydını silmek istediginiz doktor id'sini girin");
        try {
            int silinecekId=Main.scan.nextInt();
            if (tempIdList.contains(silinecekId)){
                hastane.doktorlar.remove(hastane.getDoktorById(silinecekId));
                System.out.println("Doktor kaydı silindi");
            }else System.out.println("Böyle bir doktor kaydı bulunamadı");


        } catch (Exception e) {
            System.out.println("İşlem başarısız");
        }

    }
}
