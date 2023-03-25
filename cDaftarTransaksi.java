
package pkgUas;

public class cDaftarTransaksi {
    cTransaksi front, rear;
    int jmlh;
    
    cDaftarTransaksi(){
        front=rear=null;
        jmlh=0;
    }
    public cTransaksi getFront(){
        return front;
    }
    public cTransaksi getRear(){
        return rear;
    }
    public int getJumlah(){
        return jmlh;
    }
    public void tambahTransaksi(cTransaksi baru){
        if(front==null){
            front=rear=baru;
        }else{
            rear.next=baru;
            baru.prev=rear;
            rear=baru;
        }
        jmlh++;
    }
    public void lihatTransaksi(){
        if(front==null){
            System.out.println("Kosong!");
        }else{
            int i=1;
            for (cTransaksi t=front; t!=null; t=t.next) {
                System.out.println(i+".  "+t.ToString());
                i++;
            }
        }
    }
    public cTransaksi hapusTransaksi(int h){
        cTransaksi t=front, prevv=null;
        int i = 1;
        if(h==1){
            if(t.next==null){
               front=rear=null; 
            }else{
                front=front.next;
                front.prev=null;
                t.next=null;
            }
        }else{
            for (; t != null; t=t.next) {
                if(i==h){
                    break;
                }
                i++;
                prevv=t;
            }
            if(t.next==null){
                rear=prevv;
                rear.next=null;
                t.prev=null;
            }else{
               prevv.next=t.next;
               cTransaksi n=t.next;
               n.prev=prevv;
               t.next=null; t.prev=null;
            }
        }
        return t;
    }
    public void checkout(boolean member){
        cTransaksi t = front;
        System.out.println("Kode    : "+t.getKode());
        System.out.println("Pembeli : "+t.getPembeli());
        if(member==true)
            System.out.println("Diskon 5% tiap barang!");
        System.out.println("\nNama Barang    harga    jumlah    total");
        int no=1;
        for (; t !=null; t=t.next) {
            double total=0;
            if(member==false){
                total=t.getJumlah()*t.getBarang().getHarga();
            }else{
                total=t.getJumlah()*t.getBarang().getHarga()*0.95;
            }
            System.out.print(no+". "+t.getBarang().getNama()+"        "+t.getBarang().getHarga()+"      ");
            System.out.println(t.getJumlah()+"        "+total);
            no++;
        }
    }
    public double total(){
        double total=0;
        for (cTransaksi t = front; t != null; t=t.next) {
            if(t.getMember()=='0'){
                total = total + t.getBarang().getHarga()*t.getJumlah();
            }else if(t.getMember()=='1'){
                total = total + t.getBarang().getHarga()*t.getJumlah()*0.95;
            }
        }
        return total;
    }
    public void sambungTransaksi(cTransaksi f,cTransaksi r){
        if(front==null){
            front=f;
            rear=r;
        }else{
            rear.next=f;
            f.prev=rear;
            rear=r;        
        }
    }
    public double prosesTransaksi(cTransaksi t){
        t.setStatus(1);
        double blnj=0;
        if(t.getMember()=='1'){
            blnj = t.getBarang().getHarga()*t.getJumlah()*0.95;
        }
        return blnj;
    }
    public void belumProses(){
        int i=1, blm=0;
        System.out.println("\n\tBelum Diproses");
        for (cTransaksi t= front; t !=null; t=t.next) {
            if(t.getStatus()==0){
                System.out.println(i+".  "+t.ToString());
                i++;
                blm++;
            }
        }
        System.out.println("Belum Diproses : "+blm);
    }
    public double totalTiapProses(int status){
        double total=0;
        int s=status;
        for (cTransaksi t= front; t !=null; t=t.next) {
            if(t.getStatus()==s){
                if(t.getMember()=='0'){
                    total=total+t.getBarang().getHarga()*t.getJumlah();
                }else{
                    total=total+t.getBarang().getHarga()*t.getJumlah()*0.95;
                }
            }
        }
        return total;
    }
    public String grafik(double rkp){
        String g="";
        double x = Math.floor(rkp/10000);
        for (int i = 0; i < x; i++) {
            g=g+"X";
        }
        g=g+" ";
        return g;
    }
}
