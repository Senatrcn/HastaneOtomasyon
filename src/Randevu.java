import java.time.LocalDate;
import java.time.LocalTime;

public class Randevu {

    private static int idCount=0;
    private int id;
    private Hasta hasta;
    private Doktor doktor;
    private LocalDate randevuTarih;
    private LocalTime randevuSaat;

    Randevu(){
        this.id = ++idCount;
    }

    public int getId() {
        return id;
    }

    public Hasta getHasta() {
        return hasta;
    }

    public void setHasta(Hasta hasta) {
        this.hasta = hasta;
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    public LocalDate getRandevuTarih() {
        return randevuTarih;
    }

    public void setRandevuTarih(LocalDate randevu) {
        this.randevuTarih = randevu;
    }
    public LocalTime getRandevuSaat() {
        return randevuSaat;
    }

    public void setRandevuSaat(LocalTime randevu) {
        this.randevuSaat= randevu;
    }

    public static boolean isEmpty(Object o) {
        if (o!=null) return false;
        else return true;
    }
    @Override
    public String toString() {
        return  "Doktor : " + doktor.getIsim() +" "+ doktor.getSoyIsim() +
                "\nBölüm : " + doktor.getBolum() +
                "\nRandevu Tarihi : " + randevuTarih +
                "\nRandevu Saati : " + randevuSaat
                ;
    }
}
