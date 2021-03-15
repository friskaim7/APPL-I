public class Commission extends Hourly {
    double totalSales;
    double commissionRate;

    public Commission(String eName, String eAddress, String ePhone, String socSecNumber, double rate, double comRate) {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        this.commissionRate = comRate;
    }

    public void addSales(double totalSales) {
        this.totalSales += totalSales;
    }

    @Override
    public double pay() {
        double temp = this.totalSales;
        this.totalSales = 0;
        return super.pay() + (this.commissionRate * temp);
    }

    @Override
    public String toString() {
        return super.toString() + "\nTotal Sales: " + this.totalSales;
    }
}
