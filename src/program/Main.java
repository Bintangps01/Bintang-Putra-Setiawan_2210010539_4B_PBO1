package program;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<DompetDigital> daftarDompet = new ArrayList<>();
        
        boolean running = true;
        while (running) {
            System.out.println("1. Buat Dompet Digital");
            System.out.println("2. Buat Dompet Premium");
            System.out.println("3. Tambah Saldo");
            System.out.println("4. Kurangi Saldo");
            System.out.println("5. Info Dompet");
            System.out.println("6. Keluar");
            System.out.print("Pilih Operasi :");
            
            try {
                int pilihan = Integer.parseInt(scanner.nextLine());
            
                switch (pilihan) {
                    case 1:
                        System.out.print("Masukan Nama Pemilik :");
                        String pemilik = scanner.nextLine();
                        System.out.print("Masukan Saldo Awal :");
                        double saldoAwal = Double.parseDouble(scanner.nextLine());
                        daftarDompet.add(new DompetDigital(pemilik, saldoAwal));
                        break;

                    case 2:
                        System.out.print("Masukan Nama Pemilik:");
                        pemilik = scanner.nextLine();
                        System.out.print("Masukan Saldo Awal :");
                        saldoAwal = Double.parseDouble(scanner.nextLine());
                        System.out.print("Masukan Cashback Rate :");
                        double cashbackRate = Double.parseDouble(scanner.nextLine());
                        daftarDompet.add(new DompetPremium(pemilik, saldoAwal, cashbackRate));
                        break;

                    case 3:
                        System.out.print("Masukan Indeks Dompet: ");
                        int indeks = Integer.parseInt(scanner.nextLine());
                        System.out.print("Masukan Jumlah Saldo Yang Ingin di Tambah :");
                        double jumlah = Double.parseDouble(scanner.nextLine());
                        if (indeks >= 0 && indeks < daftarDompet.size()) {
                            daftarDompet.get(indeks).tambahSaldo(jumlah);
                        } else {
                            System.out.println("Input Tidak Valid");
                        }
                        break;

                    case 4:
                        System.out.print("Masukan Indeks Dompet: ");
                        indeks = Integer.parseInt(scanner.nextLine());
                        System.out.print("Masukan Jumlah Saldo Yang Ingin di Kurangi :");
                        jumlah = Double.parseDouble(scanner.nextLine());
                        if (indeks >= 0 && indeks < daftarDompet.size()) {
                            daftarDompet.get(indeks).kurangSaldo(jumlah);
                        } else {
                            System.out.println("Input Tidak Valid");
                        }
                        break;

                    case 5:
                        if (daftarDompet.isEmpty()) {
                            System.out.println("Daftar Dompet Kosong");
                        } else {
                            for (int i = 0; i < daftarDompet.size(); i++) {
                                System.out.println("Indeks: "+i);
                                daftarDompet.get(i).infoDompet();
                                System.out.println();
                            }
                        }
                        break;

                    case 6:
                        running = false;
                        break;

                    default:
                        System.out.println("Pilihan Tidak Ada");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input Tidak Valid, Silahkan Masukan Angka!");
            } catch (Exception e) {
                System.out.println("Terjadi Kesalahan..." + e.getMessage());
            }
        }
        
        scanner.close();
    }
}
