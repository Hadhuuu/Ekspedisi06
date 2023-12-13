import java.util.Random;
import java.util.Scanner;

public class Ekspedisi06 {
    //Databasae Pelanggan (30 Orang max) dam Database Kota
    static String[][] databasePelanggan = new String[30][10];
    static String[][] ruteKota = {
            {"Malang", "Surabaya", "90"},
            {"Malang", "Probolinggo", "70"},
            {"Malang", "Banyuwangi", "300"},
            {"Malang", "Madiun", "180"},
            {"Surabaya", "Probolinggo", "100"},
            {"Surabaya", "Banyuwangi", "290"},
            {"Surabaya", "Madiun", "160"},
            {"Probolinggo", "Banyuwangi", "190"},
            {"Probolinggo", "Madiun", "244"},
            {"Banyuwangi", "Madiun", "440"},
        };

    public static void main(String[] args) {
            Scanner sc = new Scanner (System.in);

            System.out.println("\n SELAMAT DATANG DI EKSPEDISI  'G V H' ");
            int menu;
            int z = 0;
            //Perulangan menu UTAMA (dgn Switch Case)
            while (z < 1) {
                System.out.println("\n===== Menu Ekspedisi ===== ");
                System.out.println("1. Penambahan Pesanan");
                System.out.println("2. Manajemen Paket");
                System.out.println("3. Estimasi Biaya");
                System.out.println("4. Jadwal Pengiriman");
                System.out.println("5. Pemilihan Jenis Pesanan");
                System.out.println("6. Promo dan Diskon");
                System.out.println("7. Penambahan Kendala dan Keamanan");
                System.out.println("8. Mencari rincian Pesanan");
                System.out.println("9. EXIT.");
                System.out.println("==== Pilih Menu (1-9) ==== ");
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
                    jadwalPengiriman();
                    
                    break;
                case 5:
                    pemilihanJenisPesanan();
                    
                    break;
                case 6:
                    promoDanDiskon();
                    
                    break;
                case 7:
                    penambahanKendala();
                    
                    break;
                case 8:
                    melihatPesanan();
                    
                    break;
                case 9:
                    System.out.println("Terima kasih telah menggunakan program Ekspedisi 'G V H' ");
                    // Program Telah Selesai digunakan
                    System.exit(0);
                    break;
                default:
                    System.out.println("Menu tidak valid. Silakan pilih menu 1-8.");
            }
        }
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

    }

    static void jadwalPengiriman () {
       
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
            System.out.println("Biaya             : Rp." + databasePelanggan[index][7]);
            System.out.println("Jadwal Pengiriman : " + databasePelanggan[index][8]);
            System.out.println("Jadwal Penerimaan : " + databasePelanggan[index][9]);
           
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
        // Fungsi untuk menampilkan seluruh Kota yang tersediaa
        System.out.println("- Malang");
        System.out.println("- Surabaya");
        System.out.println("- Probolinggo");
        System.out.println("- Banyuwangi");
        System.out.println("- Madiun");
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

}