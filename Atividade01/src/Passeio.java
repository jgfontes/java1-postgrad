final public class Passeio extends Veiculo {
    private int qtdPassageiros;

    //Default constructor
    public Passeio() {
        super();
        this.qtdPassageiros = 0;
    }

    //Constructor with inputs
    public Passeio (String placa, String marca, String modelo, String cor, float velocMax, int qtdRodas, Motor motor, int qtdPassageiros) {
        super(placa, marca, modelo, cor, velocMax, qtdRodas, motor);
        this.qtdPassageiros = qtdPassageiros;
    }

    public int getQtdPassageiros() {
        return qtdPassageiros;
    }

    public void setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }

    @Override
    public float calcVel(float velocMax) {
        return velocMax/1000; //return value in m/h
    }

    @Override
    public String toString() {
        String returnString = " - QtdPassageiros: " + this.getQtdPassageiros() + "\n";
        returnString += super.toString();
        return returnString;
    }
}
