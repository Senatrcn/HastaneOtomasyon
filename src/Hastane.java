import java.util.ArrayList;
import java.util.List;

public class Hastane extends VeriBankasi{

    private static int idCount;
    private int id;
    private String hastaneIsim;
    protected VeriBankasi veriBankasi;
    protected List<Doktor> doktorlar= new ArrayList<>();
    protected List<String> bolumler=new ArrayList<>();
    protected List<Hasta> hastalar=new ArrayList<>();


    Hastane(){
        this.id=++idCount;
    }
    Hastane(String hastaneIsim){
        this.id=++idCount;
        this.hastaneIsim=hastaneIsim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHastaneIsim() {
        return hastaneIsim;
    }

    public void setHastaneIsim(String hastaneIsim) {
        this.hastaneIsim = hastaneIsim;
    }

    public void getDoktorlar() {
        doktorlar= veriBankasi.doktorListesi(this);
        for (Doktor d : doktorlar){
            System.out.println("DR."+d.getIsim()+" "+d.getSoyIsim()+"               Bölüm : "+d.getBolum());
        }

    }

    public void setDoktorlar(List<Doktor> hDoktorlar) {

    }

    public List<Hasta> gethHastalar() {
        return hastalar;
    }

    public void setHastalar(List<Hasta> hHastalar) {
        this.hastalar = hHastalar;
    }

    public void getBolumler() {
        bolumler = bolumListesi(this);
        for (int i=0; i<this.bolumler.size();i++){
            System.out.println(this.bolumler.get(i)+" : "+(i+1));;
        }
    }

    public void setBolumler(List<String> hBolumler) {
        this.bolumler = hBolumler;
    }

    public Doktor getDoktorById(int id) {
        Doktor secilenDoktor= new Doktor();
        for (Doktor d : doktorlar){
            if (d.getId()==id) {
                secilenDoktor= d;
                break;
            }else {
                secilenDoktor= doktorlar.get(0);
            }
        }
        return secilenDoktor;
    }

    @Override
    public String toString() {
        return "Hastane{" +
                "isim="+ hastaneIsim+
                "hDoktorlar=" + doktorlar +
                ", hBolumler=" + bolumler +
                '}';
    }


}
