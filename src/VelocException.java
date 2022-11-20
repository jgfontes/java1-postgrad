public class VelocException extends Exception{
    public VelocException() {
        System.out.println("Velocidade não está de acordo com os limites brasileiros. Velocidade Máxima deve ser maior que 80km/h e menor que 110km/h\n");
    }
}
