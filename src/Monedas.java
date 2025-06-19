public class Monedas {

    private double pesoArg;
    private double realBr;
    private double pesoCol;

    public Monedas() {
    }

    public Monedas(MonedasRecord monedas) {
        pesoArg = monedas.ARS();
        realBr = monedas.BRL();
        pesoCol = monedas.COP();
    }

    public double usdToArg(double valor){
        double conversion = valor * pesoArg;
        return conversion;
    }

    public double argToUsd(double valor){
        double conversion = valor / pesoArg;
        return conversion;
    }

    public double usdToBr(double valor){
        double conversion = valor * realBr;
        return conversion;
    }

    public double brToUsd(double valor){
        double conversion = valor / realBr;
        return conversion;
    }

    public double usdToCol(double valor){
        double conversion = valor * pesoCol;
        return conversion;
    }

    public double colToUsd(double valor){
        double conversion = valor / pesoCol;
        return conversion;
    }

    public double getPesoArg() {
        return pesoArg;
    }

    public double getRealBr() {
        return realBr;
    }

    public double getPesoCol() {
        return pesoCol;
    }
}
