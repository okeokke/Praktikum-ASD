public class AntrianKRS07 {
  int depan, belakang, size, max, sudahKRS;
  Mahasiswa07[] antrian;

  public AntrianKRS07(int maks) {
    max = maks;
    antrian = new Mahasiswa07[max];
    size = 0;
    depan = 0;
    belakang = -1;
    sudahKRS = 0;
  }

  public boolean cekKosong() {
    return size == 0;
  }

  public boolean cekPenuh() {
    return size == max;
  }

  public void masukAntrian(Mahasiswa07 m) {
    if (cekPenuh()) {
      System.out.println("Antrian penuh! Tidak bisa menambah.");
      return;
    }
    belakang = (belakang + 1) % max;
    antrian[belakang] = m;
    size++;
    System.out.println(m.nama + " masuk antrian KRS.");
  }

  public void prosesKRS() {
    if (cekKosong()) {
      System.out.println("Antrian kosong, tidak ada yang diproses.");
      return;
    }
    if (sudahKRS >= 30) {
      System.out.println("Kuota DPA habis, semua sudah diproses.");
      return;
    }

    int mauProses;
    if (size >= 2) {
      mauProses = 2;
    } else {
      mauProses = 1;
    }
    if (sudahKRS + mauProses > 30) {
      mauProses = 30 - sudahKRS;
    }

    System.out.println("Memproses " + mauProses + " mahasiswa:");
    for (int i = 0; i < mauProses; i++) {
      System.out.print("  ");
      antrian[depan].tampilkanData();
      depan = (depan + 1) % max;
      size--;
      sudahKRS++;
    }
    if (size == 0) {
      depan = 0;
      belakang = -1;
    }
    System.out.println("Sudah diproses: " + sudahKRS + "/30");
  }

  public void lihatSemua() {
    if (cekKosong()) {
      System.out.println("Antrian kosong.");
      return;
    }
    System.out.println("Daftar Antrian KRS:");
    for (int i = 0; i < size; i++) {
      int idx = (depan + i) % max;
      System.out.print((i + 1) + ". ");
      antrian[idx].tampilkanData();
    }
  }

  public void duaDepan() {
    if (cekKosong()) {
      System.out.println("Antrian kosong.");
      return;
    }
    int n = size >= 2 ? 2 : size;
    System.out.println(n + " antrian terdepan:");
    for (int i = 0; i < n; i++) {
      int idx = (depan + i) % max;
      System.out.print("  ");
      antrian[idx].tampilkanData();
    }
  }

  public void palingBelakang() {
    if (cekKosong()) {
      System.out.println("Antrian kosong.");
      return;
    }
    System.out.print("Antrian terakhir: ");
    antrian[belakang].tampilkanData();
  }

  public void infoKRS() {
    int sisa = 30 - sudahKRS;
    System.out.println("== Info Antrian KRS ==");
    System.out.println("Kosong ? " + (cekKosong() ? "Ya" : "Tidak"));
    System.out.println("Penuh  ? " + (cekPenuh() ? "Ya" : "Tidak"));
    System.out.println("Antrian: " + size + " mahasiswa");
    System.out.println("Selesai: " + sudahKRS + " mahasiswa");
    System.out.println("Sisa   : " + sisa + " mahasiswa");
  }

  public void hapusAntrian() {
    depan = 0;
    belakang = -1;
    size = 0;
    System.out.println("Antrian dikosongkan.");
  }
}
