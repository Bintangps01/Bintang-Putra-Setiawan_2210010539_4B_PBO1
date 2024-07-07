package program;

public class DompetDigital {
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
