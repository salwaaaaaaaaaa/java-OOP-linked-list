
package pkgUas;

public class cTransaksi {
    cTransaksi next, prev;
    private cBarang brg;
    private String pembeli;
    private int kode, jmlh, status;
    private char member;
    
    cTransaksi(int k, String pb, cBarang b, int j, char m){
        brg = b;
        kode = k;
        pembeli = pb;
        jmlh = j;
        status = 0;
        member=m;
        next = null; prev =null;
    }
    public void setStatus(int s){
        status=s;
    }
    public int getStatus(){
        return status;
    }
    public int getJumlah(){
        return jmlh;
    }
    public cBarang getBarang(){
        return brg;
    }
    public String getPembeli(){
        return pembeli;
    }
    public int getKode(){
        return kode;
    }
    public char getMember(){
        return member;
    }
    public String ToString(){
        String t= kode+"-"+ pembeli+"-"+brg.getNama();
        t = t + "-"+jmlh+"-"+status;
        return t;
    }
}
