import java.util.Scanner;
public class QueueMain07 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Masukkan kapasitas queue: ");
    int n = sc.nextInt();
    Queue07 Q = new Queue07(n);
    int pilih;
    do {
      menu();
      pilih = sc.nextInt();
      switch (pilih) {
        case 1:
          System.out.println("Masukkan data baru: ");
          int dataMasuk = sc.nextInt();
          Q.Enqueue(dataMasuk);
          break;
        case 2:
          int dataKeluar = Q.Dequeue();
          if (dataKeluar != -1) {
            System.out.println("Data yang dikeluarkan: " + dataKeluar);
          }
          break;
        case 3:
          Q.print();
          break;
        case 4:
          Q.peek();
          break;
        case 5:
          Q.clear();
          break;
      }
    } while (pilih >= 1 && pilih <= 5);
    sc.close();
  }

  public static void menu() {
    System.out.println("Masukkan operasi yang diinginkan: ");
    System.out.println("1. Enqueue");
    System.out.println("2. Dequeue");
    System.out.println("3. Print");
    System.out.println("4. Peek");
    System.out.println("5. Clear");
    System.out.println("---------------------------------");
  }
}
