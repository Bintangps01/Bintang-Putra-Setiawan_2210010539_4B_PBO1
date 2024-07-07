# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini adalah contoh sederhana aplikasi pengolahan data Dompet Digital menggunakan Java sebagai tugas akhir dari mata kuliah pemrograman berbasis objek 1.

## Deskripsi

Aplikasi ini menerima input berupa angka untuk menampilkan pilihan operasi yang bisa dilakukan di dalam program ini
berikut list pilihan tersebut:
1. Buat Dompet Digital
2. Buat Dompet Premium
3. Tambah Saldo
4. Kurangi Saldo
5. Info Dompet
6. Keluar

User dapat mendaftarkan dompet digital biasa dan dompet digital premium dengan memasukan nama pemilik dan jumlah saldo awal. Kemudian user juga dapat melakukan penambahan dan pengurangan saldo. User juga dapat menampilkan list dompet yang sudah terdaftar ke dalam program tersebut.

Aplikasi ini mengimplementasikan beberapa konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance, Overloading, Overriding, Seleksi, Perulangan, IO Sederhana, Array, dan Error Handling.

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:

1. **Class** adalah template atau blueprint dari object. Pada kode ini, `DompetDigital`, `DompetPremium`, dan `Main` adalah contoh dari class.

```bash
public class Dompet Digital {
    private String pemilik;
    private double saldo;
    
    DompetDigital(String pemilik, double saldoAwal) {
        this.pemilik = pemilik;
        this.saldo = saldoAwal;
    }
    
    DompetDigital() {
        System.out.println("Data Tidak Boleh Kosong");
    }
    
    String getPemilik() {
        return pemilik;
    }
    
    double getSaldo() {
        return saldo;
    }
    
    void setPemilik(String pemilik) {
        this.pemilik = pemilik;
    }
    
    void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    void tambahSaldo(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
        } else {
            System.out.println("Jumlah Tidak Valid");
        }
    }
    
    void kurangSaldo(double jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
        } else {
            System.out.println("Jumlah Tidak Valid");
        }
    }
    
    void infoDompet() {
        System.out.println("Pemilik : "+getPemilik());
        System.out.println("saldo :"+getSaldo());
    }
}

public class DompetPremium extends DompetDigital{
    private double cashbackRate;
    
    DompetPremium(String pemilik, double saldoAwal, double cashbackRate) {
        super(pemilik, saldoAwal);
        this.cashbackRate = cashbackRate;
    }
    
    DompetPremium() {
        System.out.println("Data Tidak Boleh Kosong!");
    }
    
    double getCashbackRate() {
        return cashbackRate;
    }
    
    void setCashbackRate(double cashbackRate) {
        this.cashbackRate = cashbackRate;
    }
    
    @Override
    void tambahSaldo(double jumlah) {
        if (jumlah > 0) {
            double cashback = jumlah * cashbackRate;
            super.tambahSaldo(jumlah + cashback);
            System.out.println("Jumlah Cashback" + cashback);
        } else {
            System.out.println("Jumlah Harus Positif!");
        }
    }
    
    @Override
    void infoDompet() {
        super.infoDompet();
        System.out.println("Cashback Rate: "+getCashbackRate());
    }
}

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
                        System.out.print("Masukan Nama Pemilik : ");
                        String pemilik = scanner.nextLine();
                        System.out.print("Masukan Saldo Awal : ");
                        double saldoAwal = Double.parseDouble(scanner.nextLine());
                        daftarDompet.add(new DompetDigital(pemilik, saldoAwal));
                        break;

                    case 2:
                        System.out.print("Masukan Nama Pemilik: ");
                        pemilik = scanner.nextLine();
                        System.out.print("Masukan Saldo Awal : ");
                        saldoAwal = Double.parseDouble(scanner.nextLine());
                        System.out.print("Masukan Cashback Rate : ");
                        double cashbackRate = Double.parseDouble(scanner.nextLine());
                        daftarDompet.add(new DompetPremium(pemilik, saldoAwal, cashbackRate));
                        break;

                    case 3:
                        System.out.print("Masukan Indeks Dompet: ");
                        int indeks = Integer.parseInt(scanner.nextLine());
                        System.out.print("Masukan Jumlah Saldo Yang Ingin di Tambah : ");
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
                        System.out.print("Masukan Jumlah Saldo Yang Ingin di Kurangi : ");
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
```

2. **Object** adalah instance dari class. Pada kode ini, `daftarDompet.add(new DompetDigital(pemilik, saldoAwal));` dan `daftarDompet.add(new DompetPremium(pemilik, saldoAwal, cashbackRate));` adalah contoh pembuatan object.

```bash
daftarDompet.add(new DompetDigital(pemilik, saldoAwal));
daftarDompet.add(new DompetPremium(pemilik, saldoAwal, cashbackRate));
```

3. **Atribut** adalah variabel yang ada dalam class. Pada kode ini, `pemilik`, `saldo`, dan `cashbackRate` adalah contoh atribut.

```bash
private String pemilik;
private double saldo;
private double cashbackRate;
```

4. **Constructor** adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di dalam class `DompetDigital` dan `DompetPremium`.

```bash
DompetDigital(String pemilik, double saldoAwal) {
        this.pemilik = pemilik;
        this.saldo = saldoAwal;
}

DompetPremium(String pemilik, double saldoAwal, double cashbackRate) {
        super(pemilik, saldoAwal);
        this.cashbackRate = cashbackRate;
}
```

5. **Mutator** atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, `setPemilik`, `setSaldo`, dan `setCashbackRate` adalah contoh method mutator.

```bash
void setPemilik(String pemilik) {
        this.pemilik = pemilik;
}
    
void setSaldo(double saldo) {
        this.saldo = saldo;
}

void setCashbackRate(double cashbackRate) {
        this.cashbackRate = cashbackRate;
}
```

6. **Accessor** atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, `getPemilik`, `getSaldo`, `getCashbackRate` adalah contoh method accessor.

```bash
String getPemilik() {
        return pemilik;
}
    
    double getSaldo() {
        return saldo;
}

double getCashbackRate() {
        return cashbackRate;
}
```

7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, atribut `pemilik`, `saldo`, dan `cashbackRate` dienkapsulasi dan hanya bisa diakses melalui method getter dan setter.

```bash
private String pemilik;
private double saldo;
private double cashbackRate;
```

8. **Inheritance** adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, `DompetDigital` mewarisi `pemilik` dan `saldo` dengan sintaks `extends`.

```bash
public class DompetPremium extends DompetDigital{
    private double cashbackRate;
    
    DompetPremium(String pemilik, double saldoAwal, double cashbackRate) {
        super(pemilik, saldoAwal);
        this.cashbackRate = cashbackRate;
    }
}
```

9. **Polymorphism** adalah konsep di mana sebuah nama dapat digunakan untuk merujuk ke beberapa tipe atau bentuk objek berbeda. Ini memungkinkan metode-metode dengan nama yang sama untuk berperilaku berbeda tergantung pada tipe objek yang mereka manipulasi, polymorphism bisa berbentuk Overloading ataupun Overriding. Pada kode ini, method `DompetDigital()` di `DompetDigital` merupakan overloading method `DompetDigital(String pemilik, double saldoAwal)` dan `infoDompet()` di `DompetPremium` merupakan override dari method `infoDompet()` di `DompetDigital`.

```bash
DompetDigital(String pemilik, double saldoAwal) {
        this.pemilik = pemilik;
        this.saldo = saldoAwal;
}

    DompetDigital() {
        System.out.println("Data Tidak Boleh Kosong");
}

void infoDompet() {
        System.out.println("Pemilik : "+getPemilik());
        System.out.println("saldo :"+getSaldo());
    }

@Override
void infoDompet() {
        super.infoDompet();
        System.out.println("Cashback Rate: "+getCashbackRate());
    }
}
```

10. **Seleksi** adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi `if else` dalam case 3,4,5 dan seleksi `switch` dalam class Main.

```bash
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
```

11. **Perulangan** adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada kode ini, digunakan loop `for` dan `while` untuk meminta input dan menampilkan data.

```bash
for (int i = 0; i < daftarDompet.size(); i++) {
    System.out.println("Indeks: "+i);
    daftarDompet.get(i).infoDompet();
    System.out.println();
}
```

```bash
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
```

12. **Input Output Sederhana** digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class `Scanner` untuk menerima input dan method `System.out.println` untuk menampilkan output.

```bash
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
```

13. **Array** adalah struktur data yang digunakan untuk menyimpan beberapa nilai dalam satu variabel. Pada kode ini, `ArrayList<DompetDigital> daftarDompet = new ArrayList<>();` adalah contoh penggunaan array.

```bash
ArrayList<DompetDigital> daftarDompet = new ArrayList<>();;
```

14. **Error Handling** digunakan untuk menangani error yang mungkin terjadi saat runtime. Pada kode ini, digunakan `try catch` untuk menangani error.

```bash
try {
    // code that might throw an exception
} catch (NumberFormatException e) {
    System.out.println("Input Tidak Valid, Silahkan Masukan Angka!");
} catch (Exception e) {
    System.out.println("Terjadi Kesalahan..." + e.getMessage());
}
```

## Usulan nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat

Nama: Bintang Putra Setiawan
NPM: 2210010539
