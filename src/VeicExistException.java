public class VeicExistException extends Exception {
    public VeicExistException() {
        System.out.println("Já existe um Veículo com esta placa cadastrado\n");
    }
}
