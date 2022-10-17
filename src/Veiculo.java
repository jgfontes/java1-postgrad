public class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private float velocMax; //Unit of measure: Km/h
    private int qtdRodas;
    private Motor motor;

    //Constructor without inputs (Default)
    public Veiculo() {
        this.placa = " ";
        this.marca = " ";
        this.modelo = " ";
        this.cor = " ";
        this.velocMax = 0;
        this.qtdRodas = 0;
        this.motor = new Motor();
    }

    //Constructor with inputs
    public Veiculo(String placa, String marca, String modelo, String cor, float velocMax, int qtdRodas, Motor motor) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.velocMax = velocMax;
        this.qtdRodas = qtdRodas;
        this.motor = motor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getVelocMax() {
        return velocMax;
    }

    public void setVelocMax(float velocMax) {
        this.velocMax = velocMax;
    }

    public int getQtdRodas() {
        return qtdRodas;
    }

    public void setQtdRodas(int qtdRodas) {
        this.qtdRodas = qtdRodas;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Override
    public String toString() {
        String returnString =
                "O Veiculo possui: \n" +
                        " - Placa: " + this.placa + "\n" +
                        " - Marca: " + this.marca + "\n" +
                        " - Modelo: " + this.modelo + "\n" +
                        " - Cor: " + this.cor + "\n" +
                        " - VelocidadeMax: " + this.velocMax + " Km/h\n" +
                        " - QtdRodas: " + this.qtdRodas + "\n" +
                        this.motor + "\n";
        return returnString;
    }
}