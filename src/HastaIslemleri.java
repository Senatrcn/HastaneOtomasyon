import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class HastaIslemleri {

    public static void hastaGirisi(){

        System.out.println("İsminizi girin");
        String isim = Main.scan.nextLine();
        System.out.println("Soyisminizi girin");
        String soyisim = Main.scan.nextLine();
        Hasta hasta = new Hasta(isim,soyisim);

        hastaneSec(hasta);

    }

    private static void hastaneSec(Hasta hasta) {
        System.out.println("Hangi hastaneden randevu almak istersiniz?");
        VeriBankasi.hastaneListesi();
        try {
            int id = Main.scan.nextInt();
            Main.scan.nextLine();
            if (id>0 && id<=VeriBankasi.hastaneler.size()){
                for (Hastane hastane: VeriBankasi.hastaneler){
                    if (id==hastane.getId()){
                        hastane.hastalar.add(hasta);
                        bolumSec(hastane,hasta);
                    }
                }
            }else{
                System.out.println("Hatalı secim. Tekrar deneyin");
                hastaneSec(hasta);
            }
        } catch (Exception e) {
            Main.scan.nextLine();
            System.out.println("Hatalı secim. Tekrar deneyin");
            hastaneSec(hasta);
        }
    }

    private static void bolumSec(Hastane hastane,Hasta hasta) {
        hastane.getBolumler();
        System.out.println("Randevu almak istediginiz bölümü secin\nHangi bölümü sececeginizi bilmiyorsanız 0 tuşlayın");
        try {
            String bolumSecimStr= Main.scan.nextLine();
            int bolumSecim = Integer.parseInt(bolumSecimStr.replaceAll("\\D",""))-1;
            if (bolumSecim==-1){
                bolumSecim = hastane.bolumler.indexOf(HastaIslemleri.durumaGoreRandevu(hasta));
            }
            randevuOlustur(hastane,hasta,bolumSecim);
        } catch (Exception e) {
            System.out.println("Hatalı secim. Tekrar deneyin");
            bolumSec(hastane,hasta);
        }
    }

    private static void randevuOlustur(Hastane hastane, Hasta hasta, int bolumSecim) {

        Randevu randevu = new Randevu();
        randevu.setHasta(hasta);

        if (Randevu.isEmpty(randevu.getDoktor())) doktorSec(hastane,bolumSecim,randevu);
        if (Randevu.isEmpty(randevu.getRandevuTarih())) randevuTarihBelirle(randevu);
        if (Randevu.isEmpty(randevu.getRandevuSaat())) randevuSaatBelirle(randevu);

        randevu.getDoktor().setRandevular(randevu);
        System.out.println(randevu.getDoktor()+"\n"+randevu.getRandevuTarih()+"     "+randevu.getRandevuSaat()+" randevu oluşturulmuştur.");
    }

    private static void doktorSec(Hastane hastane, int bolumSecim, Randevu randevu) {
        List<Integer> tempIdList = new ArrayList<>();
        System.out.println(hastane.bolumler.get(bolumSecim)+" bölümünde bulunan doktorlarımız");
        for (Doktor doktor: hastane.doktorlar) {
            if(doktor.getBolum().equals(hastane.bolumler.get(bolumSecim))){
                tempIdList.add(doktor.getId());
                System.out.println("DR."+doktor.getIsim()+" "+doktor.getSoyIsim()+" : "+doktor.getId());
            }
        }
        int secilenDoktorId = 0;
        try {
            System.out.println("Randevu olusturmak istediginiz doktor id'sini girin");
            secilenDoktorId = Main.scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Hatalı giriş yaptınız");
        }
        Main.scan.nextLine();

        if(tempIdList.contains(secilenDoktorId)){
            randevu.setDoktor(hastane.getDoktorById(secilenDoktorId));
        }else {
            System.out.println("Geçersiz id girdiniz.Randevu alabileceğiniz doktor : "+hastane.getDoktorById(tempIdList.get(0)));
            randevu.setDoktor(hastane.getDoktorById(tempIdList.get(0)));
        }
    }

    private static void randevuTarihBelirle(Randevu randevu) {
        DateTimeFormatter tarihFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println("Randevu olusturmak istediginiz tarihi girin : dd.mm.yyyy");
        try {
            String randevuTarih = Main.scan.nextLine();
            LocalDate tarih= LocalDate.parse(randevuTarih,tarihFormatter);
            if (tarih.isAfter(LocalDate.now())){
                randevu.setRandevuTarih(tarih);

            }else{
                System.out.println(LocalDate.now()+" tarihinden sonrası için randevu oluşturabilirsiniz");
                randevuTarihBelirle(randevu);
            }
        } catch (Exception e) {
            System.out.println("Randevu tarihiniz "+LocalDate.now().plusDays(1)+" olarak belirlendi");
            randevu.setRandevuTarih(LocalDate.now().plusDays(1));
        }
    }

    private static void randevuSaatBelirle(Randevu randevu) {

        System.out.println("Randevu olusturmak istediginiz saati girin : hh:mm");
        try {
            String randevuSaat = Main.scan.nextLine();
            if (randevuSaat.contains(".")) randevuSaat=randevuSaat.replace(".",":");
            LocalTime saat =LocalTime.parse(randevuSaat);
            if (saat.isAfter(LocalTime.of(8,59))&&saat.isBefore(LocalTime.of(17,31))){
                randevu.setRandevuSaat(saat);

            }else{
                System.out.println("Mesai Saatleri => 09:00 - 17:30");
                randevuSaatBelirle(randevu);
            }

        } catch (Exception e) {
            System.out.println("Randevu saatiniz 09:00 olarak belirlendi");
            randevu.setRandevuSaat(LocalTime.of(9,0));
        }
    }

    private static String durumaGoreRandevu(Hasta hasta) {

        hasta.getHastaDurumu().setAktuelDurum();
        System.out.println("Sayın "+ hasta.getIsim().toUpperCase()+" "+hasta.getSoyIsim().toUpperCase()+"\nDurum : "+hasta.getHastaDurumu().getAktuelDurum()+"\nAciliyet : "+hasta.getHastaDurumu().isAciliyet());
        if(hasta.getHastaDurumu().getAktuelDurum().equals("Alerji"))  return "Dermatoloji";
        if(hasta.getHastaDurumu().getAktuelDurum().equals("Mide ülseri")) return "Gastroenteroloji ";
        if(hasta.getHastaDurumu().getAktuelDurum().equals("Diyabet")) return "Beslenme ve Diyet";
        if(hasta.getHastaDurumu().getAktuelDurum().equals("Soguk algınlıgı")) return "Dahiliye";
        if(hasta.getHastaDurumu().getAktuelDurum().equals("Migren")) return "Nöroloji";
        if(hasta.getHastaDurumu().getAktuelDurum().equals("Kalp hastalıgı"))return "Kardiyoloji";
        else{
            return "Acil Servis";
        }
    }


}
