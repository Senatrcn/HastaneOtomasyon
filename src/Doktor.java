import java.util.ArrayList;
import java.util.List;

public class Doktor {

    private static int idCount;
    private int id;
    private String isim;
    private String soyIsim;
    private String bolum;
    private List<Randevu> randevular= new ArrayList<>();


    Doktor(){
        this.id=++idCount;
    }
    Doktor(String isim, String soyIsim,String bolum){
        this.id=++idCount;
        this.isim = isim;
        this.soyIsim = soyIsim;
        this.bolum = bolum;
    }

    public int getId() {
        return id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyIsim() {
        return soyIsim;
    }

    public void setSoyIsim(String soyIsim) {
        this.soyIsim = soyIsim;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String unvan) {
        this.bolum = unvan;
    }

    public List<Randevu> getRandevular() {
        return randevular;
    }

    public void setRandevular(Randevu randevu) {
        randevular.add(randevu);
    }

    @Override
    public String toString() {
        return  "\nDr." + isim +" "+ soyIsim +
                "   Bolum : " + bolum ;
    }
}
