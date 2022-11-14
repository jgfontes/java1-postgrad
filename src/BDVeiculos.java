import java.util.ArrayList;

public class BDVeiculos {
    private static ArrayList<Veiculo> cargaArray = new ArrayList<Veiculo>(5);
    private static ArrayList<Veiculo> passeioArray = new ArrayList<Veiculo>(5);
    private static Leitura leituraObj = new Leitura();

    public BDVeiculos() {
    }

    public boolean cadastraPasseio(Passeio novoVeiculoPasseio) throws VeicExistException {
        //Validate if Veiculo already exist
        if(this.buscaVeiculoPorPlaca(novoVeiculoPasseio.getPlaca(), this.getPasseioArray()) != null) {
            throw new VeicExistException();
        }

        passeioArray.add(novoVeiculoPasseio);
        return true;
    }

    public boolean cadastraCarga(Carga novoVeiculoCarga) throws VeicExistException {
        //Validate if Veiculo already exists
        if(this.buscaVeiculoPorPlaca(novoVeiculoCarga.getPlaca(), this.getCargaArray()) != null) {
            throw new VeicExistException();
        }

        cargaArray.add(novoVeiculoCarga);
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
