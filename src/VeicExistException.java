public class VeicExistException extends Exception {
    public VeicExistException() {
    }

    @Override
    public void printStackTrace() {
        System.out.println("Já existe um Veículo com esta placa cadastrado\n");
    }
}
