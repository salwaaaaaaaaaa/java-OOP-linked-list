
package pkgUas;
import java.util.Scanner;
public class appToko {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilih=0, pilih2=0, kode=062001;
        cDaftarTransaksi jual = new cDaftarTransaksi();
        cBarang brg1= new cBarang("Milo", 10000);
        cBarang brg2= new cBarang("Jahe", 7000);
        cBarang brg3= new cBarang("Kopi", 5000);
        cBarang brg4= new cBarang("Susu", 8000);
        cBarang brg5= new cBarang("STMJ", 15000);
        String idM1="2201", idM2="2202", idM3="2203";
        String passM1="11", passM2="12", passM3="13";
        double rkpMilo=0, rkpJahe=0, rkpKopi=0, rkpSusu=0, rkpStmj=0;
        double blnjM1=0, blnjM2=0, blnjM3=0; 
        String passAdmin="admiN123", passOwner="owneR123";
        
        do{
            System.out.println("\n Aplikasi Warung Bu Nisa'");
            System.out.println("1. Pembeli");
            System.out.println("2. Member");
            System.out.println("3. Admin");
            System.out.println("4. Pemilik");
            System.out.println("5. Exit");
            System.out.print("Pilih : ");
            pilih = sc.nextInt();
            switch(pilih){
                case 1 :
                    //pembeli
                    cDaftarTransaksi beli= new cDaftarTransaksi();
                    System.out.print("\nNama : ");
                    String n = sc.next();
                    do{
                        cTransaksi trans=null;
                        System.out.println("\n\tAkun Pembeli");
                        System.out.println("1. Tambah");
                        System.out.println("2. Hapus");
                        System.out.println("3. Lihat");
                        System.out.println("4. Checkout");
                        System.out.print("Pilih : ");
                        pilih2=sc.nextInt();
                        switch(pilih2){
                            case 1 :
                                System.out.println("\n  Daftar Barang");
                                System.out.println("1. "+brg1.getNama()+"    Rp"+brg1.getHarga());
                                System.out.println("2. "+brg2.getNama()+"    Rp"+brg2.getHarga());
                                System.out.println("3. "+brg3.getNama()+"    Rp"+brg3.getHarga());
                                System.out.println("4. "+brg4.getNama()+"    Rp"+brg4.getHarga());
                                System.out.println("5. "+brg5.getNama()+"    Rp"+brg5.getHarga());
                                System.out.print("Pilih : ");
                                int pilih3= sc.nextInt();
                                System.out.print("Jumlah : ");
                                int j = sc.nextInt();
                                if(pilih3==1){
                                    trans = new cTransaksi(kode, n, brg1, j,'0');
                                }else if(pilih3==2){
                                    trans = new cTransaksi(kode, n, brg2, j,'0');
                                }else if(pilih3==3){
                                    trans = new cTransaksi(kode, n, brg3, j,'0');
                                }else if(pilih3==4){
                                    trans = new cTransaksi(kode, n, brg4, j,'0');
                                }else if(pilih3==5){
                                    trans = new cTransaksi(kode, n, brg5, j,'0');
                                }else{
                                    System.out.println("Pilihan tidak tersedia");
                                }
                                beli.tambahTransaksi(trans);
                                break;
                            case 2 :
                                if(beli.getJumlah()!=0){
                                    System.out.println("\n\tDaftar Pembelian \n");
                                    beli.lihatTransaksi();
                                    System.out.print("Hapus : ");
                                    int h = sc.nextInt();
                                    cTransaksi hps=beli.hapusTransaksi(h);
                                    System.out.print(hps.getBarang().getNama());
                                    System.out.println(" ["+hps.getJumlah()+"] berhasil dihapus!");
                                }else{
                                    System.out.println("Tidak ada pembelian!");
                                }
                                break;
                            case 3 :
                                System.out.println("\n\tPembelian Barang\n");
                                beli.lihatTransaksi();
                                System.out.println("\nTotal : Rp"+beli.total());
                                break;
                            case 4 :
                                if(beli.getJumlah()!=0){
                                    System.out.println("\n\tCheckout\n");
                                    boolean m=false;
                                    beli.checkout(m);
                                    System.out.println("\nTotal : Rp"+beli.total());
                                    System.out.print("\nCheckout?\n1. Ya\n2. Tidak\nPilih : ");
                                    int c = sc.nextInt();
                                    if(c==1){
                                        jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                        kode++;
                                        for (cTransaksi t=beli.getFront(); t!=null; t=t.next) {
                                            n=t.getBarang().getNama();
                                            if(n.equals(brg1.getNama())){
                                                rkpMilo=rkpMilo+brg1.getHarga()*t.getJumlah();
                                            }else if(n.equals(brg2.getNama())){
                                                rkpJahe=rkpJahe+brg2.getHarga()*t.getJumlah();
                                            }else if(n.equals(brg3.getNama())){
                                                rkpKopi=rkpKopi+brg3.getHarga()*t.getJumlah();
                                            }else if(n.equals(brg4.getNama())){
                                                rkpSusu=rkpSusu+brg4.getHarga()*t.getJumlah();
                                            }else if(n.equals(brg5.getNama())){
                                                rkpStmj=rkpStmj+brg5.getHarga()*t.getJumlah();
                                            }
                                        }
                                        System.out.println("Berhasil membuat pesanan!");
                                    }else{
                                        System.out.println("Pesanan batal dibuat!");
                                    } 
                                }else{
                                    System.out.println("Pembelian kosong...");
                                }
                                break;
                            default:
                                System.out.println("Pilihan tidak tersedia!");
                                continue; 
                        }
                    }while(pilih2!=4);
                    break;
                case 2 :
                    //member
                    beli= new cDaftarTransaksi();
                    boolean berhasil=false;
                    String id, simpan="";
                    do{
                        System.out.print("\nID Member : ");
                        id = sc.next();
                        System.out.print("Password  : ");
                        String pass=sc.next();
                        if(id.equals(idM1)&&pass.equals(passM1)){
                            berhasil=true; simpan=passM1;
                        }else if(id.equals(idM2)&&pass.equals(passM2)){
                            berhasil=true; simpan=passM2;
                        }else if(id.equals(idM3)&&pass.equals(passM3)){
                            berhasil=true; simpan=passM3;
                        }
                        if(berhasil==false){
                            System.out.println("ID/Password salah!");
                        }
                    }while(berhasil==false);
                    do{
                        cTransaksi trans=null;
                        System.out.println("\n\tAkun Member");
                        System.out.println("1. Ubah Password");
                        System.out.println("2. Tambah");
                        System.out.println("3. Hapus");
                        System.out.println("4. Lihat");
                        System.out.println("5. Checkout");
                        System.out.print("Pilih : ");
                        pilih2=sc.nextInt();
                        switch(pilih2){
                            case 1: 
                                System.out.println("\n\tUbah Password");
                                System.out.print("Password Lama       : ");
                                String pl = sc.next();
                                if(pl.equals(simpan)){
                                    do{
                                        System.out.print("Password Baru       : ");
                                        String pb=sc.next();
                                        System.out.print("Konfirmasi Password : ");
                                        String kp= sc.next();
                                        berhasil=false;
                                        if(pb.equals(kp)){
                                            if(simpan.equals(passM1)){
                                                passM1=pb; berhasil=true;
                                            }else if(simpan.equals(passM2)){
                                                passM2=pb; berhasil=true;
                                            }else if(simpan.equals(passM3)){
                                                passM3=pb; berhasil=true;
                                            } 
                                            if(berhasil=true){
                                                System.out.println("Password berhasil diubah!");
                                            }
                                        }else{
                                            continue;
                                        }
                                    }while(berhasil==false);
                                }else{
                                    System.out.println("Password salah!");
                                }
                                break;
                            case 2 :
                                System.out.println("\n  Daftar Barang");
                                System.out.println("1. "+brg1.getNama()+"    Rp"+brg1.getHarga());
                                System.out.println("2. "+brg2.getNama()+"    Rp"+brg2.getHarga());
                                System.out.println("3. "+brg3.getNama()+"    Rp"+brg3.getHarga());
                                System.out.println("4. "+brg4.getNama()+"    Rp"+brg4.getHarga());
                                System.out.println("5. "+brg5.getNama()+"    Rp"+brg5.getHarga());
                                System.out.print("Pilih : ");
                                int pilih3= sc.nextInt();
                                System.out.print("Jumlah : ");
                                int j = sc.nextInt();
                                if(pilih3==1){
                                    trans = new cTransaksi(kode, id, brg1, j,'1');
                                }else if(pilih3==2){
                                    trans = new cTransaksi(kode, id, brg2, j,'1');
                                }else if(pilih3==3){
                                    trans = new cTransaksi(kode, id, brg3, j,'1');
                                }else if(pilih3==4){
                                    trans = new cTransaksi(kode, id, brg4, j,'1');
                                }else if(pilih3==5){
                                    trans = new cTransaksi(kode, id, brg5, j,'1');
                                }else{
                                    System.out.println("Pilihan tidak tersedia");
                                }
                                beli.tambahTransaksi(trans);
                                break;
                            case 3 :
                                if(beli.getJumlah()!=0){
                                    System.out.println("\n\tDaftar Pembelian \n");
                                    beli.lihatTransaksi();
                                    System.out.print("Hapus : ");
                                    int h = sc.nextInt();
                                    cTransaksi hps=beli.hapusTransaksi(h);
                                    System.out.print(hps.getBarang().getNama());
                                    System.out.println(" ["+hps.getJumlah()+"] berhasil dihapus!");
                                }else{
                                    System.out.println("Tidak ada pembelian!");
                                }
                                break;
                            case 4 :
                                System.out.println("\n\tPembelian Barang\n");
                                beli.lihatTransaksi();
                                System.out.println("\nTotal : Rp"+beli.total());
                                break;
                            case 5 :
                                if(beli.getJumlah()!=0){
                                    System.out.println("\n\tCheckout\n");
                                    boolean m=true;
                                    beli.checkout(m);
                                    System.out.println("\nTotal  : Rp"+beli.total());
                                    System.out.print("Checkout?\n1. Ya\n2. Tidak\nPilih : ");
                                    int c = sc.nextInt();
                                    if(c==1){
                                        jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                        kode++;
                                        for (cTransaksi t=beli.getFront(); t!=null; t=t.next) {
                                            n=t.getBarang().getNama();
                                            if(n.equals(brg1.getNama())){
                                                rkpMilo=rkpMilo+brg1.getHarga()*t.getJumlah()*0.95;
                                            }else if(n.equals(brg2.getNama())){
                                                rkpJahe=rkpJahe+brg2.getHarga()*t.getJumlah()*0.95;
                                            }else if(n.equals(brg3.getNama())){
                                                rkpKopi=rkpKopi+brg3.getHarga()*t.getJumlah()*0.95;
                                            }else if(n.equals(brg4.getNama())){
                                                rkpSusu=rkpSusu+brg4.getHarga()*t.getJumlah()*0.95;
                                            }else if(n.equals(brg5.getNama())){
                                                rkpStmj=rkpStmj+brg5.getHarga()*t.getJumlah()*0.95;
                                            }
                                        }
                                        System.out.println("Berhasil membuat pesanan!");
                                    }else{
                                        System.out.println("Pesanan batal dibuat!");
                                    } 
                                }else{
                                    System.out.println("Pembelian kosong...");
                                }
                                break;
                            default:
                                System.out.println("Pilihan tidak tersedia!");
                                continue; 
                        }
                    }while(pilih2!=5);
                    break;
                case 3 :
                    //admin
                    berhasil=false;
                    do{
                        System.out.println("\n\tAkun Admin");
                        System.out.print("Password : ");
                        String p = sc.next();
                        if(p.equals(passAdmin)){
                            berhasil=true;
                        }else{
                            System.out.println("Password salah!");
                        }
                    }while(berhasil==false);
                    do{
                        System.out.println("\n\tUSER ADMIN\n");
                        System.out.println("1. Daftar Seluruh Transaksi");
                        System.out.println("2. Transaksi Belum Diproses");
                        System.out.println("3. Pemrosesan Transaksi");
                        System.out.println("4. Kembali");
                        System.out.print("Pilih : ");
                        pilih2 = sc.nextInt();
                        switch(pilih2){
                            case 1 :
                                System.out.println("\n    Seluruh Transaksi");
                                jual.lihatTransaksi();
                                break;
                            case 2 :
                                jual.belumProses();
                                break;
                            case 3 :
                                if(jual.getFront()==null){
                                    System.out.println("Belum ada transaksi!");
                                    break;
                                }
                                cTransaksi t=jual.getFront();
                                do{
                                    if(t.getStatus()==0){
                                        System.out.println("\nKode    : "+t.getKode());
                                        System.out.println("Pembeli : "+t.getPembeli());
                                        System.out.println("Barang  : "+t.getBarang().getNama());
                                        System.out.println("Jumlah  : "+t.getJumlah());
                                        System.out.println("    -Pilih Aksi-");
                                        System.out.print("    1. Proses\n    2. Kembali\n    Pilih : ");
                                        int a = sc.nextInt();
                                        if(a==1){
                                            double belanja = jual.prosesTransaksi(t);
                                            if(belanja!=0){
                                                if(t.getPembeli().equals(idM1)){
                                                    blnjM1=blnjM1+belanja;
                                                }else if(t.getPembeli().equals(idM2)){
                                                    blnjM2=blnjM2+belanja;
                                                }else{
                                                    blnjM3=blnjM3+belanja;
                                                }
                                            }
                                            System.out.println("Berhasil diproses!");
                                        }else{
                                            break;
                                        }
                                    }
                                    t=t.next;
                                }while(t!=null);
                                break;
                            case 4 :
                                System.out.println("\nKembali ke menu utama...\n");
                                break;
                            default :
                                System.out.println("Pilihan tidak tersedia...");
                                continue;
                        }
                    }while(pilih2!=4);
                    break;
                case 4 :
                    //pemilik
                    berhasil=false;
                    do{
                        System.out.println("\n\tAkun Pemilik");
                        System.out.print("Password : ");
                        String p = sc.next();
                        if(p.equals(passOwner)){
                            berhasil=true;
                        }else{
                            System.out.println("Password salah!");
                        }
                    }while(berhasil==false);
                    do{
                        System.out.println("\n\tMENU PEMILIK");
                        System.out.println("1. Total Penjualan Terproses");
                        System.out.println("2. Total Penjualan Belum Terproses");
                        System.out.println("3. Total Penjualan Tiap Barang");
                        System.out.println("4. Total Pembelian Member");
                        System.out.println("5. Grafik Penjualan");
                        System.out.println("6. Ubah Harga Barang");
                        System.out.println("7. Selesai");
                        System.out.print("Pilih : ");
                        pilih2=sc.nextInt();
                        switch(pilih2){
                            case 1 :
                                System.out.println("\nTotal Penjualan Yang Sudah Diproses : ");
                                System.out.println("Rp "+jual.totalTiapProses(1));
                                break;
                            case 2 :
                                System.out.println("\nTotal Penjualan Yang Belum Diproses : ");
                                System.out.println("Rp "+jual.totalTiapProses(0));
                                break;
                            case 3 :
                                System.out.println("\n\tRekap Penjualan");
                                double pendapatan = rkpMilo+rkpJahe+rkpKopi+rkpSusu+rkpStmj;
                                System.out.println("Total Pendapatan : Rp"+pendapatan);
                                System.out.println("1. "+brg1.getNama()+"  : Rp"+rkpMilo);
                                System.out.println("2. "+brg2.getNama()+"  : Rp"+rkpJahe);
                                System.out.println("3. "+brg3.getNama()+"  : Rp"+rkpKopi);
                                System.out.println("4. "+brg4.getNama()+"  : Rp"+rkpSusu);
                                System.out.println("5. "+brg5.getNama()+"  : Rp"+rkpStmj);
                                break;
                            case 4 :
                                System.out.println("\n\tPembelian Member");
                                System.out.println("\n  ID MEMBER       TOTAL");
                                System.out.println("1. "+idM1+"         : Rp"+blnjM1);
                                System.out.println("2. "+idM2+"         : Rp"+blnjM2);
                                System.out.println("3. "+idM3+"         : Rp"+blnjM3);
                                break;
                            case 5 :
                                System.out.println("\n\tGrafik Penjualan\n");
                                String x = jual.grafik(rkpMilo);
                                System.out.println(brg1.getNama()+"  : "+x+rkpMilo);
                                x = jual.grafik(rkpJahe);
                                System.out.println(brg2.getNama()+"  : "+x+rkpJahe);
                                x = jual.grafik(rkpKopi);
                                System.out.println(brg3.getNama()+"  : "+x+rkpKopi);
                                x = jual.grafik(rkpSusu);
                                System.out.println(brg4.getNama()+"  : "+x+rkpSusu);
                                x = jual.grafik(rkpStmj);
                                System.out.println(brg5.getNama()+"  : "+x+rkpStmj);
                                break;
                            case 6 :
                                System.out.println("\n   Ubah Harga");
                                System.out.println("1. "+brg1.getNama()+"  Rp"+brg1.getHarga());
                                System.out.println("2. "+brg2.getNama()+"  Rp"+brg2.getHarga());
                                System.out.println("3. "+brg3.getNama()+"  Rp"+brg3.getHarga());
                                System.out.println("4. "+brg4.getNama()+"  Rp"+brg4.getHarga());
                                System.out.println("5. "+brg5.getNama()+"  Rp"+brg5.getHarga());
                                System.out.print("Pilih : ");
                                int pilih3 = sc.nextInt();
                                System.out.print("Harga Baru : ");
                                int h = sc.nextInt();
                                if(pilih3==1){
                                    brg1.setHarga(h);
                                    System.out.println("Harga berhasil diubah!");
                                }else if(pilih3==2){
                                    brg2.setHarga(h);
                                    System.out.println("Harga berhasil diubah!");
                                }else if(pilih3==3){
                                    brg3.setHarga(h);
                                    System.out.println("Harga berhasil diubah!");
                                }else if(pilih3==4){
                                    brg4.setHarga(h);
                                    System.out.println("Harga berhasil diubah!");
                                }else if(pilih3==5){
                                    brg5.setHarga(h);
                                    System.out.println("Harga berhasil diubah!");
                                }else{
                                    System.out.println("Pilihan tidak tersedia");
                                }
                                break;
                            case 7 :
                                System.out.println("\nKembali ke menu utama...\n");
                                break;
                            default:
                                System.out.println("Pilihan Tidak tersedia...");
                                continue;
                        }
                    }while(pilih2!=7);
                    break;
                case 5 :
                    System.out.println("Terima kasih...");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia!");
                    continue;
            }
        }while(pilih!=5);
        
    }
    
    
}
