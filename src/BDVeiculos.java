import java.util.ArrayList;

public class BDVeiculos {
    private static ArrayList<Veiculo> cargaArray = new ArrayList<Veiculo>(5);
    private static ArrayList<Veiculo> passeioArray = new ArrayList<Veiculo>(5);
    private static Leitura leituraObj = new Leitura();

    public BDVeiculos() {
    }

    public static boolean cadastraPasseio(String newPlacaP) {
        String newMarca = leituraObj.entDados(" Inserir marca: ");
        String newModeloP = leituraObj.entDados(" Inserir o nome do modelo: ");
        String newCorP = leituraObj.entDados(" Inserir a cor do carro: ");
        String newVelocMaxP = leituraObj.entDados(" Inserir a Veloc Max do carro (Km/h): ");
        String newQtdRodasP = leituraObj.entDados(" Inserir a quantidade de rodas do veículo: ");
        String newQtdPistP = leituraObj.entDados(" Inserir a quantidade de pistões do motor do carro: ");
        String newPotenciaP = leituraObj.entDados(" Inserir a potência do motor do carro: ");
        String newQtdPassageirosP = leituraObj.entDados(" Inserir a quantidade de passageiros: ");

        passeioArray.add(new Passeio(
                newPlacaP,
                newMarca,
                newModeloP,
                newCorP,
                Integer.parseInt(newVelocMaxP),
                Integer.parseInt(newQtdRodasP),
                new Motor(
                        Integer.parseInt(newQtdPistP),
                        Integer.parseInt(newPotenciaP)
                ),
                Integer.parseInt(newQtdPassageirosP)
        ));

        return true;
    }

    public static boolean cadastraCarga(String newPlacaC) {
        String newMarcaC = leituraObj.entDados(" Inserir marca: ");
        String newModeloC = leituraObj.entDados(" Inserir o nome do modelo: ");
        String newCorC = leituraObj.entDados(" Inserir a cor do carro: ");
        String newVelocMaxC = leituraObj.entDados(" Inserir a Veloc Max do carro (Km/h): ");
        String newQtdRodasC = leituraObj.entDados(" Inserir a quantidade de rodas do veículo: ");
        String newQtdPistC = leituraObj.entDados(" Inserir a quantidade de pistões do motor do carro: ");
        String newPotenciaC = leituraObj.entDados(" Inserir a potência do motor do carro: ");
        String newTaraC = leituraObj.entDados(" Inserir a tara do veículo: ");
        String newCargaMaxC = leituraObj.entDados(" Inserir a carga Max: ");

        cargaArray.add(new Carga(
                newPlacaC,
                newMarcaC,
                newModeloC,
                newCorC,
                Integer.parseInt(newVelocMaxC),
                Integer.parseInt(newQtdRodasC),
                new Motor(
                        Integer.parseInt(newQtdPistC),
                        Integer.parseInt(newPotenciaC)
                ),
                Integer.parseInt(newTaraC),
                Integer.parseInt(newCargaMaxC)
        ));

        return true;
    }

    public ArrayList<Veiculo> getCargaArray() {
        return cargaArray;
    }

    public ArrayList<Veiculo> getPasseioArray() {
        return passeioArray;
    }

    protected Veiculo buscaVeiculoPorPlaca(String placaVeiculo, ArrayList<Veiculo> veiculoArray) {
        for(Veiculo buscarVeiculo : veiculoArray) {
            if(buscarVeiculo.getPlaca().equals(placaVeiculo)) {
                return buscarVeiculo;
            }
        }
        return null;
    }
}
