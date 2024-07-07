package program;

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
