public class Hasta {

    private static int idCount=1000;

    private String isim;
    private String soyIsim;
    private int hastaID;
    private Durum hastaDurumu= new Durum();


    Hasta(){
        this.hastaID = ++idCount;
    }
    Hasta(String isim, String soyIsim){
        this.hastaID = ++idCount;
        this.isim = isim;
        this. soyIsim = soyIsim;
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

    public int getHastaID() {
        return hastaID;
    }

    public void setHastaID(int hastaID) {
        this.hastaID = hastaID;
    }

    public Durum getHastaDurumu() {
        return hastaDurumu;
    }

    public void setHastaDurumu(Durum hastaDurumu) {
        this.hastaDurumu = hastaDurumu;
    }

    @Override
    public String toString() {
        return "\nİsim-Soyisim : "+ isim+" "+soyIsim+
                "   HastaID :"+hastaID
                ;
    }
}
