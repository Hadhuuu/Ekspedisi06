import java.util.Random;
import java.util.Scanner;

public class Ekspedisi06 {
    //Databasae Pelanggan (50 Orang max) dam Database Kota
    static String[][] databasePelanggan = new String[50][12];
    // Database Rute kota (bersifat dinamis) bisa ditambahkan melalui admin..
    static String[][] ruteKota = {
            {"Malang", "Surabaya", "90"},
            {"Malang", "Probolinggo", "70"},
            {"Malang", "Banyuwangi", "300"},
            {"Malang", "Madiun", "180"},
            {"Surabaya", "Probolinggo", "100"},
            {"Surabaya", "Banyuwangi", "290"},
            {"Surabaya", "Madiun", "160"},
            {"Probolinggo", "Banyuwangi", "190"},
            {"Madiun", "Probolinggo", "244"},
            {"Banyuwangi", "Madiun", "440"},
        };
    // Database MEtodde pembayaran (dinamis) bsa ditambahkan melalui admin..
    static String[] metodePembayaran = {
        "Cash", "BCA", "BRI","PayPal"
        };
    // Database Id kasir (bersifat dinamis) bisa ditambahkan melalui admin..
    static String[] idkasir = {
        "Andi112","Yuna552"
        };
    // Database Id Staf (bersifat dinamis) bisa ditambahkan melalui admin..
    static String[] idStaf = {
        "Redo009","Putra556"
        };
    // pasword mutlak untuk login admin
    static String passwordAdmin = "12345";

    public static void main(String[] args) {
        // Tampilan Awal (Portal) pemilihan bahasa
        System.out.println("Language/Bahasa : ");
        System.out.println("1. Indonesia");
        System.out.println("2. English");
        Scanner sc = new Scanner(System.in);
        int z=0;
        // Perulangan pilihan
        while (z<1) {
            System.out.println("choose/pilih  :  (1/2)");
            int pilihan = sc.nextInt();
            if (pilihan==1) {
                Indonesia();
                z++;
            } else if (pilihan==2) {
                English();
                z++;
            }   else {
                System.out.println("mohon masukkan angka yang valid / \n please enter a valid number");
            }
        }
    }

    static void Indonesia () {
        // Tampilan utama (Bahasa Indonesia)
        System.out.println("=== Akses level ===");
        System.out.println("1. Admin (Master)");
        System.out.println("2. Pegawai");
        System.out.println("3. Exit");
        Scanner sc = new Scanner(System.in);
        int z=0;
        while (z<1) {
            System.out.println("pilih (1/2)");
            int pilihan = sc.nextInt();
            if (pilihan==1) {
                int u = 0;
                while (u<1) {
                    // Penyamaan password sesuai database
                    System.out.println("Masukkan PASSWORD Admin : ");
                    String pass = sc.next();
                    if (pass.equalsIgnoreCase(passwordAdmin)) {
                        Adminlevel();
                        u++;
                    } else {
                        // Syntax pasword salah
                        System.out.println("Password salah...");
                        u++;
                    }               
                }
            } else if (pilihan==2) {
                PegawaiLevel();
            } else if (pilihan==3) {
                System.out.println("==================| T E R I M A   K A S I H |==================");
                // System exit dan program telah finish berjalan
                System.exit(0);
            } else {
                System.out.println("mohon masukkan angka yang valid");
            }
        }

    }

    static void Adminlevel () {
        // Tampilan admin level (master)
         Scanner sc = new Scanner (System.in);
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n SELAMAT DATANG DI EKSPEDISI  'G V H' (Admin)");
            int menu;
            int z = 0;
            //Perulangan menu UTAMA (dgn Switch Case)
            while (z < 1) {
                System.out.println("\n===== Menu Ekspedisi ===== ");
                System.out.println("1. Penambahan Data Kota");
                System.out.println("2. Penambahan Id Kasir");
                System.out.println("3. Penambahan Id Staf");
                System.out.println("4. Penambahan Metode Pembayaran");
                System.out.println("5. Laporan Pendapatan");
                System.out.println("6. Selesai");
                System.out.println("==== Pilih Menu (1-5) ==== ");
                menu = sc.nextInt();
                // Pemecahan masing masing fungsi berdasarkan kegunaannya masing - masing
                switch (menu) {
                case 1:
                    // Penambahan Rute Kota baru
                    System.out.println("Rute Kota Sebelum Penambahan:");
                    tampilkanRuteKota();
                    // Inputan untuk Kota 1, Kota 2, serta jaraknya
                    System.out.println("\nMasukkan rute baru : ");
                    System.out.print("Kota Asal: ");
                    String kotaAsal = scanner.next();
            
                    System.out.print("Kota Tujuan: ");
                    String kotaTujuan = scanner.next();
            
                    System.out.print("Jarak (km) : ");
                    String jarak = scanner.next();

                    // Menambahkan rute baru
                    tambahKota(kotaAsal, kotaTujuan, jarak);           
                    // Menampilkan rute kota setelah penambahan
                    System.out.println("\nRute Kota Setelah Penambahan:");
                    tampilkanRuteKota();                                  
                    break;
                case 2:
                    // Penambahan Daftar Id kasir baru
                    System.out.println("Daftar Id kasir Sebelum Penambahan :");
                    tampilkankasir();
            
                    System.out.println("\nMasukkan id baru (contoh 'lina123') : ");
                    String Idbaru = scanner.next();
                    
                    String[] newArray = new String[idkasir.length + 1];

                    // penyalinan rute
                    for (int i = 0; i < idkasir.length; i++) {
                        newArray[i] = idkasir[i];
                    }

                    // Menambahkan id staf ke array baru
                    newArray[idkasir.length] = Idbaru;

                    // Mengganti array lama dengan array baru
                    idkasir = newArray;

                    System.out.println("\nId kasir Setelah Penambahan :");
                    tampilkankasir();                                  
                    break;
                case 3:
                    System.out.println("Daftar Id Staf Sebelum Penambahan :");
                    tampilkanStaf();
            
                    System.out.println("\nMasukkan id baru (contoh 'lina123') : ");
                    String Idbaruu = scanner.next();
                    
                    String[] newArrayy = new String[idStaf.length + 1];

                    // penyalinan staf
                    for (int i = 0; i < idStaf.length; i++) {
                        newArrayy[i] = idStaf[i];
                    }

                    // Menambahkan satf baru ke array baru
                    newArrayy[idStaf.length] = Idbaruu;

                    // Mengganti array lama dengan array baru
                    idStaf = newArrayy;

                    System.out.println("\n Id Staf Setelah Penambahan :");
                    tampilkanStaf();                       
                    break;
                case 4:
                    System.out.println("Daftar Metode Pembayaran Sebelum Penambahan :");
                    tampilkanmetod();
            
                    System.out.println("\nMasukkan Metode baru  : ");
                    String metodep = scanner.next();
                    
                    String[] newArrayyy = new String[metodePembayaran.length + 1];

                    // penyalinan metode
                    for (int i = 0; i < metodePembayaran.length; i++) {
                        newArrayyy[i] = metodePembayaran[i];
                    }

                    // Menambahkan metode baru ke array baru
                    newArrayyy[metodePembayaran.length] = metodep;

                    // Mengganti array lama dengan array baru
                    metodePembayaran = newArrayyy;

                    System.out.println("\n Metode pembayaran Setelah Penambahan :");
                    tampilkanmetod();                       
                    break;
                case 5:
                    // Total pendapatan dari seluruh database pelanggan pada kolom ke 7
                    Double Pendapatan = 0.0;
                    for (int i = 0; i < databasePelanggan.length; i++) {
                        if (databasePelanggan[i][0]!=null)
                        Pendapatan += Double.parseDouble(databasePelanggan[i][7]);
                    }
                    System.out.println("Total (sementara) pendapatan hari ini sebesar : ");
                    System.out.println("Rp. "+Pendapatan.intValue());
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan program Ekspedisi 'G V H' ");
                    z++;
                    break;
                default:
                    System.out.println("Menu tidak valid. Silakan pilih menu 1-5.");
                    break;
            }
            Indonesia();
        }
    }

    static void tambahKota(String kotaAsal, String kotaTujuan, String jarak) {
        // Array baru dengan ukuran besar
        String[][] newArray = new String[ruteKota.length + 1][3];

        // penyalinan rute
        for (int i = 0; i < ruteKota.length; i++) {
            newArray[i] = ruteKota[i];
        }

        // Menambahkan rute baru ke array baru
        newArray[ruteKota.length] = new String[] {kotaAsal, kotaTujuan, jarak};

        // Mengganti array lama dengan array baru
        ruteKota = newArray;
    }

    static void tampilkanRuteKota() {
        for (String[] rute : ruteKota) {
            System.out.println(rute[0] + " ke " + rute[1] + ": " + rute[2] + " km");
        }
    }

    static void tampilkankasir() {
        for (String id : idkasir) {
            System.out.println(id);
        }
    }

    static void tampilkanStaf() {
        for (String id : idStaf) {
            System.out.println(id);
        }
    }

    static void tampilkanmetod () {
        for (String met : metodePembayaran) {
            System.out.println(met);
        }
    }

    static void PegawaiLevel () {

        System.out.println("=== Pengguna ===");
        System.out.println("1. Kasir");
        System.out.println("2. Staf");
        System.out.println("3. Exit");
        Scanner sc = new Scanner(System.in);
        int z=0;
        while (z<1) {
            System.out.println("pilih (1/2)");
            int pilihan = sc.nextInt();
            if (pilihan==1) {
                int u = 0;
                while (u<1) {
                    int k = 0;
                    System.out.println("Masukkan id Kasir : ");
                    String pass = sc.next();
                    for (int x=0 ; x < idkasir.length ; x++) {
                        if (pass.equalsIgnoreCase(idkasir[x])) {
                            k+=10;
                            modeKasir();
                        } else {
                            k--;
                        }
                    }
                    if (k<0) {
                        System.out.println("Id tidak terdaftar...");
                        u++;
                    }          
                }   
            } else if (pilihan==2) {
                int u = 0;
                while (u<1) {
                    int k = 0;
                    System.out.println("Masukkan id Staf : ");
                    String pass = sc.next();
                    for (int x=0 ; x < idStaf.length ; x++) {
                        if (pass.equalsIgnoreCase(idStaf[x])) {
                            k+=10;
                            modeStaf();
                        } else {
                            k--;
                        }
                    }
                    if (k<0) {
                        System.out.println("Id tidak terdaftar...");
                        u++;
                    }          
                }   
            } else if (pilihan==3) {
                z++;
            } else {
                System.out.println("mohon masukkan angka yang valid");
            }
        }
        Indonesia();

    }

    static void modeStaf () {
        Scanner sc = new Scanner (System.in);

            System.out.println("\n SELAMAT DATANG DI EKSPEDISI  'G V H' (Staf) ");
            int menu;
            int z = 0;
            //Perulangan menu UTAMA (dgn Switch Case)
            while (z < 1) {
                    System.out.println("\n===== Menu Ekspedisi ===== ");
                    System.out.println("1. Update Pengiriman");
                    System.out.println("2. Label Pengiriman");
                    System.out.println("3. Exit");
                    System.out.println("==== Pilih Menu (1-3) ==== ");
                    menu = sc.nextInt();
                    // Pemecahan masing masing fungsi berdasarkan kegunaannya masing - masing
                    switch (menu) {
                    case 1:
                        updatePengiriman();                   
                        break;
                    case 2:
                        melihatPesanan();                   
                        break;
                    case 3:
                        System.out.println("Terima kasih telah menggunakan program Ekspedisi 'G V H' ");
                        z++;
                        break;
                    default:
                        System.out.println("Menu tidak valid. Silakan pilih menu 1-3.");
                }
            }
            Indonesia();
    }

    static void modeKasir () {
            Scanner sc = new Scanner (System.in);

            System.out.println("\n SELAMAT DATANG DI EKSPEDISI  'G V H' (Kasir) ");
            int menu;
            int z = 0;
            //Perulangan menu UTAMA (dgn Switch Case)
            while (z < 1) {
                System.out.println("\n===== Menu Ekspedisi ===== ");
                System.out.println("1. Penambahan Pesanan");
                System.out.println("2. Manajemen Paket");
                System.out.println("3. Estimasi Biaya");
                System.out.println("4. Metode pembayaran ");
                System.out.println("5. Jadwal Pengiriman");
                System.out.println("6. Pemilihan Jenis Pesanan");
                System.out.println("7. Promo dan Diskon");
                System.out.println("8. Penambahan Kendala dan Keamanan");
                System.out.println("9. Mencari rincian Pesanan");
                System.out.println("10. EXIT.");
                System.out.println("==== Pilih Menu (1-10) ==== ");
                menu = sc.nextInt();
                // Pemecahan masing masing fungsi berdasarkan kegunaannya masing - masing
                switch (menu) {
                case 1:
                    tambahPesanan();
                    
                    break;
                case 2:
                    ManajemenPaket();
                     
                    break;
                case 3:
                    estimasiBiaya();
                    
                    break;
                case 4:
                    jenispembayaran();

                    break;
                case 5:
                    jadwalPengiriman();
                    
                    break;
                case 6:
                    pemilihanJenisPesanan();
                    
                    break;
                case 7:
                    promoDanDiskon();
                    
                    break;
                case 8:
                    penambahanKendala();
                    
                    break;
                case 9:
                    melihatPesanan();
                    
                    break;
                case 10:
                    System.out.println("Terima kasih telah menggunakan program Ekspedisi 'G V H' ");
                    z++;
                    break;
                default:
                    System.out.println("Menu tidak valid. Silakan pilih menu 1-9.");
            }
        }
        Indonesia();
    }

    static void tambahPesanan () {
           //Penambahan Pesanan untuk setiap pelanggan

           Scanner scanner = new Scanner (System.in);
           // Resi didapatkan dengan memanfaatkan Random dengan jarak 1000000
           Random random = new Random();
           int nomorResi = random.nextInt(1000000);
   
           System.out.print("Masukkan Nama Pelanggan: ");
           String namaPelanggan = scanner.nextLine();
   
           System.out.print("Masukkan Deskripsi Barang: ");
           String deskripsiBarang = scanner.nextLine();
   
           System.out.println("Pilih Kota Pengirim :");
           tampilkanKota();
           System.out.print("Pilihan Anda: ");
           String kotaPengirim = scanner.next();
   
           System.out.println("Pilih Kota Penerima :");
           tampilkanKota();
           System.out.print("Pilihan Anda: ");
           String kotaPenerima = scanner.next();
   
           int index = cariIndexKosong(databasePelanggan);
           if (index != -1) {
               // Syntax UTAMA untuk input data
               databasePelanggan[index][0] = String.valueOf(nomorResi);
               databasePelanggan[index][1] = namaPelanggan;
               databasePelanggan[index][2] = deskripsiBarang;
               databasePelanggan[index][3] = kotaPengirim;
               databasePelanggan[index][4] = kotaPenerima;
   
               System.out.println("Pesanan berhasil ditambahkan.");
           } else {
               // Apabila fungsi cariIndexKosong tidak menemukan Data null pada database
               System.out.println("Database pelanggan penuh. Tidak dapat menambahkan pesanan.");
           }   
    }

    static void ManajemenPaket () {
        // Fungsi untuk memanajemen Paket
        Scanner scanner = new Scanner(System.in);
        tampilkanDataPelanggan();

        System.out.print("Pilih Pelanggan untuk me-Manage Paket (Nama): ");
        String nama = scanner.next();

        int index = cariIndexPelanggan(nama);
        if (index != -1) {
            System.out.print("Masukkan berat barang (Kg) " + databasePelanggan[index][2] + " :");
            int beratBarang = scanner.nextInt();
            System.out.println("Masukkan ukuran barang (cm) " + databasePelanggan[index][2]);
            System.out.print("panjang  : ");
            int panjang = scanner.nextInt();
            System.out.print("lebar \t : ");
            int lebar = scanner.nextInt();
            System.out.print("tinggi \t : ");
            int tinggi = scanner.nextInt();

            int volume = panjang*lebar*tinggi;
            // Syarat syarat agar barang tidak melebihi batas (Berat & Besar barang) dari setiap pelanggan
            if ((panjang>40) || (lebar>40) || (tinggi>40)) {
                System.out.println("Barang terlalu besar !");
            }
            else if (beratBarang>25) {
                System.out.println("Barang terlalu berat !");
            } else {
                System.out.println("Volume dan berat barang tidak melebihi batas (Berhasil Dimasukkan)");
                // Syntax UTAMA untuk input berat serta volume barang
                databasePelanggan[index][5] = String.valueOf(beratBarang);
                databasePelanggan[index][6] = String.valueOf(volume);
            }
        } else {
            System.out.println("Data pelanggan tidak ditemukan.");
        }
    }

    static void estimasiBiaya () {
          // Fungsi untuk Perhitungan biaya setiap pelanggan
          Scanner scanner = new Scanner(System.in);
          tampilkanDataPelanggan();
  
          System.out.print("Pilih Pelanggan untuk Estimasi Biaya (Nama): ");
          String nama = scanner.next();
  
          int index = cariIndexPelanggan(nama);
          if (index != -1) {
              int jarak=0;
              int patokan=5;
  
              for (int i=0; i<ruteKota.length; i++) {
                  // Perulangan untuk penyamaan nama kota pengirim dan penerima pada databasePelanggan dan databseKota (Untuk menyesuaikan jarak)
                  // Terdapat dua logika, dikarenakan DataBase Kota bisa pengirim dan penerima yang terbalik dalam arary tersebut
                  if ((databasePelanggan[index][3].equalsIgnoreCase(ruteKota[i][0]))&&(databasePelanggan[index][4].equalsIgnoreCase(ruteKota[i][1]))) {
                      jarak=Integer.parseInt(ruteKota[i][2]);
  
                      // Standart harga untuk setiap Jarak(km), Berat(Kg), Volume(cm^3)
                      int hargaJarak=200*jarak;
                      int hargaBerat=300*Integer.parseInt(databasePelanggan[index][5]);
                      Double hargaVol=0.2*Integer.parseInt(databasePelanggan[index][6]);
                      int hargaVoll=hargaVol.intValue();
  
                      int hargaAkhir = hargaJarak+hargaBerat+hargaVoll;
                      // Syntax UTAMA untuk input Harga
                      databasePelanggan[index][7]=String.valueOf(hargaAkhir);
                      System.out.println("Total harga dari pesanan ini adalah Rp."+hargaAkhir);
                      System.out.println("Harga Berhasil Dimasukkan...!");
                      patokan+=30;
                      break;
                  }
                  else if ((databasePelanggan[index][3].equalsIgnoreCase(ruteKota[i][1]))&&(databasePelanggan[index][4].equalsIgnoreCase(ruteKota[i][0]))) {
                      jarak=Integer.parseInt(ruteKota[i][2]);
  
                      // Standart harga untuk setiap Jarak(km), Berat(Kg), Volume(cm^3)
                      int hargaJarak=200*jarak;
                      int hargaBerat=300*Integer.parseInt(databasePelanggan[index][5]);
                      Double hargaVol=0.2*Integer.parseInt(databasePelanggan[index][6]);
                      int hargaVoll=hargaVol.intValue();
  
                      int hargaAkhir = hargaJarak+hargaBerat+hargaVoll;
                      // Syntax UTAMA untuk input Harga
                      databasePelanggan[index][7]=String.valueOf(hargaAkhir);
                      System.out.println("Total harga dari pesanan ini adalah Rp."+hargaAkhir);
                      System.out.println("Harga Berhasil Dimasukkan...!");
                      // Patokan 30 hanya sebagai logika untuk menghentikan program. (kenapa 30 karena butuh banyak) 
                      patokan+=30;
                      break;
                  }
                   else {
                      patokan--;
                  }
              }
              if (patokan<5) {
                  System.out.println("Kota dalam pesanan ini tidak ada dalam data...");
              }
          } else {
              System.out.println("Data pelanggan tidak ditemukan.");
          }  
    }

    static void jenispembayaran () {
        // Fungsi untuk memasukkan Jenis Pembayaran
        Scanner scanner = new Scanner(System.in);
        tampilkanDataPelanggan();

        System.out.print("Pilih Data Pelanggan yang Ingin dipilih Metode Pembayaran (Nama): ");
        String nama = scanner.next();

        int index = cariIndexPelanggan(nama);
        if (index != -1) {
            System.out.print("Metode Pengiriman : ");
            System.out.println();
            for (int i = 0; i < metodePembayaran.length ; i++) {
                System.out.println((i+1)+". " + metodePembayaran[i]);
            }
            int x = 0;
            while (x<1) {
                System.out.println("Masukkan pilihan : (1,2,...)");
                int pilihan = scanner.nextInt();
                if (pilihan<=metodePembayaran.length) {
                    databasePelanggan[index][10]=metodePembayaran[pilihan-1];
                    System.out.println("Metode pembayaran " + metodePembayaran[pilihan-1] + " Berhasil dimasukkan");
                    x++;
                } else {
                    System.out.println("Pilihan anda salah");
                }
            }
            
        } else {
            System.out.println("Data pelanggan tidak ditemukan.");
        }
    }

    static void jadwalPengiriman () {
        // Fungsi untuk memasukkan Jadwal Pengiriman ke dalam Database pelanggan dengan format (YYYY-MM-DD)
        Scanner scanner = new Scanner(System.in);
        tampilkanDataPelanggan();

        System.out.print("Pilih Data Pelanggan yang Ingin Dimasukkan Jadwal Pengiriman (Nama): ");
        String nama = scanner.next();

        int index = cariIndexPelanggan(nama);
        if (index != -1) {
            System.out.print("Masukkan Jadwal Pengiriman (YYYY-MM-DD) : ");
            String jadwal = scanner.next();
            // Syntax UTAMA untuk input jadwal
            databasePelanggan[index][8] = jadwal;

            System.out.println("Jadwal Pengiriman berhasil dimasukkan.");
        } else {
            System.out.println("Data pelanggan tidak ditemukan.");
        }
    }

    static void updatePengiriman () {
        // Fungsi untuk update Pelanggan
        Scanner sc = new Scanner(System.in);
        System.out.print("Untuk melakukan update status pengiriman , masukkan No Resi : ");
        String noResi = sc.next();
        // Penggunaan searching cariIndexresi
        int index = cariIndexResi(noResi);
        if (index != -1) {
            System.out.println("Masukkan Update Lokasi barang : ( contoh : Lawang )");
            String status = sc.next();

            databasePelanggan[index][11] = status;
            System.out.println("Status lokasi barang untuk Resi " + databasePelanggan[index][0] + "\nadalah : " + status);
           
        } else {
            System.out.println("Pelanggan dengan Resi tersebut tidak ditemukan..");
            // Untuk menampilkan nama serta Resi apabila lupa dengan Resi yang diinginkan
            System.out.println("Apakah ingin menampilkan seluruh Resi..? (Y/T)");
            String jwb = sc.next();
            if (jwb.equalsIgnoreCase("Y")) {
            tampilkanDataPelanggan();
            }
        }

        System.out.println("Ingin Update pelanggan lain.. ? (Y/T)");
        String jwbb = sc.next();
        if (jwbb.equalsIgnoreCase("Y")) {
            // Pemanggilan fungsi sendiri
            updatePengiriman();
        }
    }


    static void pemilihanJenisPesanan () {
        // Syntax untuk pemilihan jenis pesanan setiap pelanggan Sekaligus Input penerimaan Tanggal penerimaan
        Scanner scanner = new Scanner(System.in);
        tampilkanDataPelanggan();

        System.out.print("Pilih Data Pelanggan yang Ingin dipilih jenis pesanan (Nama): ");
        String nama = scanner.next();

        int index = cariIndexPelanggan(nama);
        String tglbaru=null;
        if (index != -1) {

            int z=0;
            double biaya = Double.parseDouble(databasePelanggan[index][7]);

            while (z<1) {
                System.out.println("Pilih Jenis Pengiriman:");
                System.out.println("1. Reguler");
                System.out.println("2. Hemat");
                System.out.println("3. Ekspres");
                System.out.print("Pilihan Anda: ");
                int jenisPengiriman=scanner.nextInt();                

                if (jenisPengiriman==1) {
                    // Biaya reguler adalah normal atau x1
                    biaya *=1.0;
                    System.out.println("Biaya Pengiriman setelah pemilihan jenis pesanan: Rp " + biaya);
                    System.out.println("Berhasil input Biaya..!");
                    int n = 2; // Bermakna bahwa 2 Hari adalah jumlah hari yang ditambahkan dari hari pengiriman sebagai hasil dari hari penerimaan
                    tglbaru = tambahanHari(databasePelanggan[index][8],n);
                    //Pengunaan fungsi tambah hari dengan parameter n
                    System.out.println("Jadwal penerimaan barang adalah (Sesuai jenis pengiriman) : " + tglbaru);
                    z++;
                    break;
                } else if (jenisPengiriman==2) {
                    // Biaya Hemat yaitu 0.7x harga awal (lebih murah)
                    biaya *=0.7;
                    System.out.println("Biaya Pengiriman setelah pemilihan jenis pesanan: Rp " + biaya);
                    System.out.println("Berhasil input Biaya..!");
                    int n = 3; // Bermakna bahwa 3 Hari adalah jumlah hari yang ditambahkan dari hari pengiriman sebagai hasil dari hari penerimaan
                    tglbaru = tambahanHari(databasePelanggan[index][8],n);
                    System.out.println("Jadwal penerimaan barang adalah (Sesuai jenis pengiriman) : " + tglbaru);
                    z++;
                    break;
                } else if (jenisPengiriman==3) {
                    // Biaya Ekspress yaitu 1.4x harga awal (lebih mahal)
                    biaya *=1.4;
                    System.out.println("Biaya Pengiriman setelah pemilihan jenis pesanan: Rp " + biaya);
                    System.out.println("Berhasil input Biaya..!");
                    int n = 1; // Bermakna bahwa 1 Hari adalah jumlah hari yang ditambahkan dari hari pengiriman sebagai hasil dari hari penerimaan
                    tglbaru = tambahanHari(databasePelanggan[index][8],n);
                    System.out.println("Jadwal penerimaan barang adalah (Sesuai jenis pengiriman) : " + tglbaru);
                    z++;               
                    break;
                } else {
                    System.out.println("Pilihan jenis pengiriman tidak valid.");
                }
            }
            int biayaa = (int)biaya;
            // Syntax utama untuk input Tanggal penerimaan dan biaya terbaru
            databasePelanggan[index][9]=tglbaru;
            databasePelanggan[index][7]=String.valueOf(biaya);
          
        } else {
            System.out.println("Data pelanggan tidak ditemukan.");
        }
    }

    static void promoDanDiskon () {
         // Fungsi untuk menambahkan Diskon (Dinamis)
         Scanner scanner = new Scanner(System.in);
         tampilkanDataPelanggan();
 
         System.out.print("Pilih Data Pelanggan yang Ingin Diberi Diskon Tambahan (Nama): ");
         String nama = scanner.next();
 
         int index = cariIndexPelanggan(nama);
         if (index != -1) {
            int x = 0;
            while (x<1) {
                //Inputan dalam persen
                System.out.println("Masukkan Diskon Dalam Persen : ( contoh : 15 )");
                Double diskonn = scanner.nextDouble();
                if (diskonn <= 100) {
                    // Dengan logika 1-(persentase/100)
                    Double hargabaruuh = 1 - (diskonn/100);
                    Double Harga = hargabaruuh*Double.parseDouble(databasePelanggan[index][7]);
                    // Syntax Inputan utama
                    databasePelanggan[index][7]=String.valueOf(Harga);
                    System.out.println("Harga setelah diskon menjadi : Rp. " + databasePelanggan[index][7]);
                    x++;
                } else {
                    System.out.println("Diskon melebihi batas (100%)");
                }
            }
         } else {
             System.out.println("Data pelanggan tidak ditemukan.");
         }
    }
    static void penambahanKendala () {
        // Fungsi untuk penambahan kendala dari databasePelanggan
        Scanner scanner = new Scanner(System.in);
        tampilkanDataPelanggan();

        System.out.print("Pilih Data Pelanggan yang Ingin Ditambahkan Kendala (Nama): ");
        String nama = scanner.next();

        int index = cariIndexPelanggan(nama);
        if (index != -1) {
            String tanggalBru = null;
            System.out.print("Masukkan jumlah delay hari pengiriman (Kendala) : ");
            int jmlkndala=scanner.nextInt();// Input berapa banyak delay hari sebagai penambah kendala
            tanggalBru = tambahanHari(databasePelanggan[index][9], jmlkndala);
            // Pengunaan fungsi tambahHari dengan parameter input sebelumnya       
            System.out.println("Kendala berhasil ditambahkan. Jadwal Pengiriman baru: " + tanggalBru);
            // Syntax UTAMA untuk input tanggal baru setelah delay
            databasePelanggan[index][9]=tanggalBru;
        } else {
            System.out.println("Data pelanggan tidak ditemukan.");
        }

    }

    static void melihatPesanan () {
        // Fungsi untuk menampilkan Seluruh Rincian Pesanan dari satu pelanggan (Bisa berulang ulng)
        Scanner sc = new Scanner(System.in);
        System.out.print("Untuk menampilkan rincian, masukkan No Resi : ");
        String noResi = sc.next();
        // Penggunaan searching cariIndexresi
        int index = cariIndexResi(noResi);
        if (index != -1) {
            // Syntax UTAMA untuk menampilkan seluruh output dari data pelanggan yang dipilih
            System.out.println("===== Rincian Pesanan Pelanggan 'G V H' =====");
            System.out.println("Nomor Resi        : " + databasePelanggan[index][0]);
            System.out.println("Nama              : " + databasePelanggan[index][1]);
            System.out.println("Deskripsi Barang  : " + databasePelanggan[index][2]);
            System.out.println("Kota Pengirim     : " + databasePelanggan[index][3]);
            System.out.println("Kota Penerima     : " + databasePelanggan[index][4]);
            System.out.println("Berat Barang      : " + databasePelanggan[index][5] + " Kg ");
            System.out.println("Volume Barang     : " + databasePelanggan[index][6] + " cm^3 ");
            System.out.println("Biaya             : Rp." + databasePelanggan[index][7] + " (" + databasePelanggan[index][10] + ") ");
            System.out.println("Jadwal Pengiriman : " + databasePelanggan[index][8]);
            System.out.println("Jadwal Penerimaan : " + databasePelanggan[index][9]);
            System.out.println("Lokasi barang (saat ini) : " + databasePelanggan[index][11]);
           
        } else {
            System.out.println("Pelanggan dengan Resi tersebut tidak ditemukan..");
            // Untuk menampilkan nama serta Resi apabila lupa dengan Resi yang diinginkan
            System.out.println("Apakah ingin menampilkan seluruh Resi..? (Y/T)");
            String jwb = sc.next();
            if (jwb.equalsIgnoreCase("Y")) {
            tampilkanDataPelanggan();
            }
        }

        System.out.println("Ingin mencari rincian pesanan pelanggan  lain.. ? (Y/T)");
        String jwbb = sc.next();
        if (jwbb.equalsIgnoreCase("Y")) {
            // Pemanggilan fungsi sendiri
            melihatPesanan();
        }
    }

    static void tampilkanKota () {
        // Syntax menampilkan Daftar Kota (tanpa duplikasi)
        System.out.println(ruteKota[0][0]);
        for (int i = 1 ; i < ruteKota.length ; i++) {
               if (ruteKota[i][0].equalsIgnoreCase(ruteKota[i-1][0])) {
                // Mengeliminasi nama kota yang sudah tertulis
               } else {
                System.out.println(ruteKota[i][0]);
                }
            }
    }
    

    static int cariIndexKosong(String[][] data) {
        // Fungsi untuk mencari index kosong pada Database pelanggan (digunakan fungsi tambahPesanan untuk menambahkan isian Data yang masi kosong (null))
        for (int i = 0; i < data.length; i++) {
            if (data[i][0] == null) {
                return i;
            }
        }
        return -1;
    }

    static void tampilkanDataPelanggan() {
        // Fungsi untuk menampilkan semua data pelanggan yanga ada (No resi dan Nama saja)
    System.out.println("\nSilahkan Pilih Pelanggan :");
        for (int i = 0; i < databasePelanggan.length; i++) {
            String row[] = databasePelanggan[i];
            if (row[0]!= null) {
                System.out.println((i+1) + ".\t" +(row[0])+ "\t" +(row[1]));
            }
        }
    }

    static int cariIndexPelanggan(String nama) {
        // Fungsi untuk mencari Index pelanggan dari database dengan nama sebagai parameter
        for (int i = 0; i < databasePelanggan.length; i++) {
            if (databasePelanggan[i][0] != null && databasePelanggan[i][1].equalsIgnoreCase(nama)) {
                return i;
            }
        }
        return -1;
    }
    static int cariIndexResi(String noResi) {
        // Fungsi untuk mencari Index pelanggan dari database dengan nomor resi sebagai parameter
        for (int i = 0; i < databasePelanggan.length; i++) {
            if (databasePelanggan[i][0] != null && databasePelanggan[i][0].equals(noResi)) {
                return i;
            }
        }
        return -1;
    }

    static String tambahanHari (String tanggal, int kendala) {
        // Fungsi untuk menambahakan jumlah hari tertentu pada sebuah tanggal (YYYY-MM-DD)

        String[] jadwalArray = tanggal.split("-");
        int tahun = Integer.parseInt(jadwalArray[0]);
        int bulan = Integer.parseInt(jadwalArray[1]);
        int tgl = Integer.parseInt(jadwalArray[2]);
        // Dengan asumsi setiap Bulan adalah 30 hari
        for (int i = 0; i < kendala; i++) {
            tgl++;
            if (tgl > 30) {
                tgl = 1;
                bulan++;
                if (bulan > 12) {
                    bulan = 1;
                    tahun++;
                }
            }
        }
        // Menyatukan ketiga int menjadi satu buah String sebagai format
        String jadwalBaru = String.format("%04d-%02d-%02d", tahun, bulan, tgl);
        return jadwalBaru;

    }

    // ===========================================================

    // BATAS BAHASA (perulangan code dengan inggris)

    // ===========================================================

    static void English() {
    

    
    }


}

