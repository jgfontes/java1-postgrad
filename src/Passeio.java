final public class Passeio extends Veiculo implements Calcular {
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

    final public void setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }

    @Override
    public float calcVel(float velocMax) {
        return velocMax*1000; //return value in m/h
    }

    @Override
    public String toString() {
        String returnString =
                "O Veiculo possui os seguintes atributos:\n" +
                " - QtdPassageiros: " + this.getQtdPassageiros() + "\n" +
                " - Velocidade Máxima: " + calcVel(getVelocMax()) + " m/h" + "\n";
        returnString += super.toString();
        return returnString;
    }

    @Override
    public int calcular() {
        int somaCaracteres = 0;

        somaCaracteres += getPlaca().length();
        somaCaracteres += getMarca().length();
        somaCaracteres += getModelo().length();
        somaCaracteres += getCor().length();

        return somaCaracteres;
    }
}
