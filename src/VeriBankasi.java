import java.util.ArrayList;
import java.util.List;

public class VeriBankasi {

    public static List<Hastane> hastaneler = new ArrayList<>();

    public static void hastaneOlustur(){

        hastaneler.add(new Hastane("Java Hastanesi"));
        hastaneler.add(new Hastane("Yıldız Hastanesi"));
        for(Hastane hastane : hastaneler){
            doktorListesi(hastane);
            bolumListesi(hastane);
            hastaListesi(hastane);
        }
    }
    public static void hastaneListesi(){

        for(Hastane hastane : hastaneler){
            System.out.println(hastane.getId()+"  "+hastane.getHastaneIsim());
        }
    }
    public static List<Doktor> doktorListesi(Hastane hastane){

        switch(hastane.getId()){
            case 1:
                hastane.doktorlar.add(new Doktor("Aziz","Lale","Acil Servis"));
                hastane.doktorlar.add(new Doktor("Baran","Gül","Acil Servis"));
                hastane.doktorlar.add(new Doktor("Ali","Yılmaz","Dermatoloji"));
                hastane.doktorlar.add(new Doktor("Veli","Yılar","Dermatoloji"));
                hastane.doktorlar.add(new Doktor("Mehmet","Yıl","Nöroloji"));
                hastane.doktorlar.add(new Doktor("Ayse","Öz","Nöroloji"));
                hastane.doktorlar.add(new Doktor("Bilal","Söz","Nöroloji"));
                hastane.doktorlar.add(new Doktor("Ali","Han","Beslenme ve Diyet"));
                hastane.doktorlar.add(new Doktor("Nur","Can","Beslenme ve Diyet"));
                hastane.doktorlar.add(new Doktor("Nuray","Mercan","Dahiliye"));
                hastane.doktorlar.add(new Doktor("Mustafa","Sercan","Dahiliye"));
                hastane.doktorlar.add(new Doktor("Nihal","Mutlu","Gastroenteroloji "));
                hastane.doktorlar.add(new Doktor("Nihat","Mutsuz","Gastroenteroloji "));
                hastane.doktorlar.add(new Doktor("Mert","Coşkun","Kardiyoloji"));
                hastane.doktorlar.add(new Doktor("Fatma","Bıkkın","Kardiyoloji"));
                hastane.doktorlar.add(new Doktor("Banu","Civelek","Kardiyoloji"));
                break;
            case 2:
                hastane.doktorlar.add(new Doktor("Yılmaz","Çakar","Acil Servis"));
                hastane.doktorlar.add(new Doktor("Ali","Aslan","Dermatoloji"));
                hastane.doktorlar.add(new Doktor("Veli","Kaplan","Dermatoloji"));
                hastane.doktorlar.add(new Doktor("Mustafa","Çelik","Nöroloji"));
                hastane.doktorlar.add(new Doktor("Hilal","Demir","Nöroloji"));
                hastane.doktorlar.add(new Doktor("Burak","Bakır","Nöroloji"));
                hastane.doktorlar.add(new Doktor("Avni","Çetin","Beslenme ve Diyet"));
                hastane.doktorlar.add(new Doktor("Perihan","Metin","Beslenme ve Diyet"));
                hastane.doktorlar.add(new Doktor("Dudu","Yetin","Beslenme ve Diyet"));
                hastane.doktorlar.add(new Doktor("Yaren","Peynir","Dahiliye"));
                hastane.doktorlar.add(new Doktor("Ahmet","Zeytin","Dahiliye"));
                hastane.doktorlar.add(new Doktor("Muhsin","Kaymak","Dahiliye"));
                hastane.doktorlar.add(new Doktor("Serra","Bahar","Gastroenteroloji "));
                hastane.doktorlar.add(new Doktor("Serhat","Kış","Gastroenteroloji "));
                hastane.doktorlar.add(new Doktor("Serap","Yaz","Gastroenteroloji "));
                hastane.doktorlar.add(new Doktor("Ömer","Hava","Kardiyoloji"));
                hastane.doktorlar.add(new Doktor("Osman","Ateş","Kardiyoloji"));
                hastane.doktorlar.add(new Doktor("Hülya","Su","Kardiyoloji"));
                hastane.doktorlar.add(new Doktor("Özge","Tahta","Kardiyoloji"));
                break;

        }

        return hastane.doktorlar;
    }
    public static List<String> bolumListesi(Hastane hastane){

        for (Doktor d: hastane.doktorlar){
            if (!hastane.bolumler.contains(d.getBolum())){
                hastane.bolumler.add(d.getBolum());
            }
        }
        return hastane.bolumler;
    }
    public static List<Hasta> hastaListesi(Hastane hastane){
        switch (hastane.getId()){
        case 1:
            hastane.hastalar.add(new Hasta("Sevinç","Akaş"));
            hastane.hastalar.add(new Hasta("Cihan","Pazar"));
            hastane.hastalar.add(new Hasta("Kevser","Özpolat"));
            hastane.hastalar.add(new Hasta("Şaban","Özdil"));
            hastane.hastalar.add(new Hasta("Selimcan","Öğredik"));
            hastane.hastalar.add(new Hasta("Meltem","Poslu"));
            hastane.hastalar.add(new Hasta("Zeynep ","Kurtuluş"));
            hastane.hastalar.add(new Hasta("Hayat","Köse"));
            break;
        case 2:
            hastane.hastalar.add(new Hasta("İlke","Kızıl"));
            hastane.hastalar.add(new Hasta("Cemile","Güleç"));
            hastane.hastalar.add(new Hasta("Fatma","Kayar"));
            hastane.hastalar.add(new Hasta("Ahmet","Güven"));
            hastane.hastalar.add(new Hasta("Aybike","Ilık"));
            hastane.hastalar.add(new Hasta("Yiğit","Karacan"));
            hastane.hastalar.add(new Hasta("Oğuz","Güzel"));
            hastane.hastalar.add(new Hasta("Mustafa","Haykır"));
            break;

        }
        return hastane.hastalar;
    }

}
