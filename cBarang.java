
package pkgUas;

public class cBarang {
    private String nama;
    private int harga;
    cBarang(String n, int h){
        nama=n;
        harga=h;
    }
    public void setHarga(int h){
        harga=h;
    }
    public String getNama(){
        return nama;
    }
    public int getHarga(){
        return harga;
    }
    public void ToString(){
        System.out.println(nama+" ["+harga+"]");
    }
}
