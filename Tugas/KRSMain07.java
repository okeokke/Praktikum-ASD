import java.util.Scanner;

public class KRSMain07 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    AntrianKRS07 antri = new AntrianKRS07(10);
    int pilih;

    do {
      System.out.println("\n== MENU KRS DPA ==");
      System.out.println("1. Tambah Mahasiswa");
      System.out.println("2. Proses Antrian KRS");
      System.out.println("3. Lihat Semua Antrian");
      System.out.println("4. Lihat 2 Antrian Depan");
      System.out.println("5. Lihat Antrian Belakang");
      System.out.println("6. Informasi KRS");
      System.out.println("7. Kosongkan Antrian");
      System.out.println("0. Keluar");
      System.out.print("Pilih: ");
      pilih = sc.nextInt();
      sc.nextLine();

      switch (pilih) {
        case 1:
          System.out.print("NIM   : "); String nim = sc.nextLine();
          System.out.print("Nama  : "); String nama = sc.nextLine();
          System.out.print("Prodi : "); String prodi = sc.nextLine();
          System.out.print("Kelas : "); String kelas = sc.nextLine();
          antri.masukAntrian(new Mahasiswa07(nim, nama, prodi, kelas));
          break;
        case 2:
          antri.prosesKRS();
          break;
        case 3:
          antri.lihatSemua();
          break;
        case 4:
          antri.duaDepan();
          break;
        case 5:
          antri.palingBelakang();
          break;
        case 6:
          antri.infoKRS();
          break;
        case 7:
          antri.hapusAntrian();
          break;
        case 0:
          System.out.println("Selesai.");
          break;
        default:
          System.out.println("Pilihan tidak dikenal.");
      }
    } while (pilih != 0);
    sc.close();
  }
}
