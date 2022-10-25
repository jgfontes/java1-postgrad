final public class Carga extends Veiculo implements Calcular {
    private int cargaMax;
    private int tara;

    //Default constructor
    public Carga () {
        super();
        this.cargaMax = 0;
        this.tara = 0;
    }

    //Constructor with inputs
    public Carga (String placa, String marca, String modelo, String cor, float velocMax, int qtdRodas, Motor motor, int cargaMax, int tara) {
        super(placa, marca, modelo, cor, velocMax, qtdRodas, motor);
        this.cargaMax = cargaMax;
        this.tara = tara;
    }

    @Override
    public float calcVel(float velocMax) {
        return velocMax*100000;
    }

    public int getCargaMax() {
        return cargaMax;
    }

    final public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    public int getTara() {
        return tara;
    }

    final public void setTara(int tara) {
        this.tara = tara;
    }

    @Override
    public String toString() {
        String returnString =
                "O Veiculo possui os seguintes atributos:\n" +
                " - cargaMax: " + getCargaMax() + "\n" +
                " - tara: " + getTara() + "\n" +
                " - Velocidade Máxima: " + calcVel(getVelocMax()) + " cm/h" + "\n";
        returnString += super.toString();
        return returnString;
    }

    @Override
    public int calcular() {
        return 0;
    }
}
