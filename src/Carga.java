final public class Carga extends Veiculo {
    private int cargaMax;
    private int tara;

    //Default constructor
    public Carga () {
        super();
        this.cargaMax = 0;
        this.tara = 0;
    }

    //Constructor with inputs
    public Carga (String placa, String marca, String modelo, String cor, float velocMax, int qtdRodas, Motor motor, int qtdPassageiros, int cargaMax, int tara) {
        super(placa, marca, modelo, cor, velocMax, qtdRodas, motor);
        this.cargaMax = cargaMax;
        this.tara = tara;
    }

    @Override
    public float calcVel(float velocMax) {
        return velocMax/100000;
    }

    public int getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    public int getTara() {
        return tara;
    }

    public void setTara(int tara) {
        this.tara = tara;
    }

    @Override
    public String toString() {
        String returnString = " - cargaMax: " + getCargaMax() + "\n" +
                " - tara: " + getTara() + "\n";
        returnString += super.toString();
        return returnString;
    }
}
