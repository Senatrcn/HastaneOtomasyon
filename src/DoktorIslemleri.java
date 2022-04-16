import java.util.List;

public class DoktorIslemleri {

    public static void doktorGirisEkrani(){
        System.out.println("Hangi hastanede çalışıyorsunuz?");
        VeriBankasi.hastaneListesi();
        String hastaneSecimStr=Main.scan.nextLine();
        try {
            int hastaneSecim = Integer.parseInt(hastaneSecimStr.replaceAll("\\D",""));
            Hastane hastane= new Hastane();
            hastane.setId(hastaneSecim);
            for (Hastane h : VeriBankasi.hastaneler){
                if (h.getId()==hastaneSecim) {
                    hastane= h;
                    doktorGirisi(hastane);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Hatalı seçim.Tekrar deneyin");
            Main.girisEkrani();
        }
    }

    private static void doktorGirisi(Hastane hastane){
        boolean login=false;
        System.out.println("İsminizi girin");
        String isim = Main.scan.nextLine();
        System.out.println("Soyisminizi girin");
        String soyisim = Main.scan.nextLine();

        for (Doktor doktor: hastane.doktorlar){
            if (doktor.getIsim().equalsIgnoreCase(isim)&&doktor.getSoyIsim().equalsIgnoreCase(soyisim)){
                login=true;
                System.out.println("Giriş başarılı");
                randevuListele(doktor);
                System.out.println("Randevu iptal etmek için 0\nÇıkmak için herhangi bir rakam girin");
                int secim=Main.scan.nextInt();
                Main.scan.nextLine();
                if (secim==0) {
                    randevuIptal(doktor);
                }
                break;
            }
        }
        if (!login) Main.girisEkrani();
    }

    private static void randevuListele(Doktor doktor) {

        System.out.println("Sayın Dr."+doktor.getIsim()+" "+doktor.getSoyIsim()+ " mevcut randevularınız listelenmiştir");
        if (doktor.getRandevular().isEmpty()){
            System.out.println("Randevunuz bulunmamakta");
        }else{
            for (Randevu randevu: doktor.getRandevular()){
                System.out.println("Randevu Id : "+ randevu.getId()+" "+randevu.getHasta()+" Randevu Tarihi ve Saati : "+randevu.getRandevuTarih()+" "+randevu.getRandevuSaat());
            }
        }
    }

    private static void randevuIptal(Doktor doktor){
        List<Randevu> tempRandevuList = doktor.getRandevular();
        System.out.println("İptal etmek istediginiz randevu id'sini girin");
        try {
            int randevuId = Main.scan.nextInt();
            Main.scan.nextLine();
            for (Randevu r : tempRandevuList) {
                if (r.getId() == randevuId) {
                    doktor.getRandevular().remove(r);
                    System.out.println("Randevunuz silindi");
                    break;
                }
            }
        }catch (Exception e){
            //System.out.println("İşlem başarısız");
        }
    }
}
