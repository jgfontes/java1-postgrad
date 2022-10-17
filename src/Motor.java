public class Motor {
    private int qtdPist;
    private int potencia;

    //Constructor without inputs (Default)
    public Motor() {
        this.qtdPist = 0;
        this.potencia = 0; //Unit of measure: CV
    }

    //Constructor with inputs
    public Motor(int qtdPist, int potencia) {
        this.qtdPist = qtdPist;
        this.potencia = potencia;
    }

    public int getQtdPist() {
        return qtdPist;
    }

    public void setQtdPist(int qtdPist) {
        this.qtdPist = qtdPist;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        String returnString =
                "O motor possui: \n" +
                " - Pistões: " + this.qtdPist + "\n" +
                " - Potência: " + this.potencia + " CV\n" +
                "*********************";
        return returnString;
    }
}
