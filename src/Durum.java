import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Durum {

    static List<String> semptomlar = new ArrayList<>(Arrays.asList("Alerji", "Mide ülseri", "Diyabet", "Soguk Algınlıgı", "Migren", "Kalp hastalıgı"));
    private String aktuelDurum="Durum girilmemiş";
    private boolean aciliyet;

    public String getAktuelDurum() {
        return aktuelDurum;
    }

    public void setAktuelDurum() {
        System.out.println("Asagıdaki seceneklerden size uyan durumu secin");
        for (String s:semptomlar){
            System.out.println(s);
        }
        String aktuelDurum = Main.scan.nextLine();
        for (String s:semptomlar){
            if (s.equalsIgnoreCase(aktuelDurum)){
                this.aktuelDurum=s;
            }
        }
        if (this.aktuelDurum==null) setAktuelDurum();
        else isAciliyet();

    }

    public String isAciliyet() {
        switch(aktuelDurum){
            case "Acil":  this.aciliyet=true; break;
            case "Alerji":  this.aciliyet=false; break;
            case "Mide ülseri": aciliyet=true;break;
            case "Diyabet": aciliyet=false;break;
            case "Soguk algınlıgı":aciliyet=false;break;
            case "Migren": this.aciliyet=true;break;
            case "Kalp hastalıgı":aciliyet=true;break;
        }
        if (aciliyet){
            return "Acil";
        }
        else{
            return "Acil degil";
        }
    }

    public void setAciliyet(boolean aciliyet) {
        this.aciliyet = aciliyet;
    }


    @Override
    public String toString() {
        return "Durum{" +
                "aktuelDurum='" + aktuelDurum + '\'' +
                ", aciliyet=" + aciliyet +
                '}';
    }
}
