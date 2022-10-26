import java.util.ArrayList;

public class Teste {
    private static Leitura leituraObj = new Leitura();
    private static ArrayList<Carga> cargaArray = new ArrayList<Carga>();
    private static ArrayList<Passeio> passeioArray = new ArrayList<Passeio>();

    public static void main(String[] args) {

        String opcaoMenu = leituraObj.entDados(
                "Sistema de Gestão de Veículos - Menu Inicial\n" +
                "1. Cadastrar Veículo de Passeio\n" +
                "2. Cadastrar Veículo de Carga\n" +
                "3. Imprimir Todos os Veículos de Passeio\n" +
                "4. Imprimir Todos os Veículos de Carga\n" +
                "5. Imprimir Veículo de Passeio pela Placa\n" +
                "6. Imprimir Veículo de Carga pela Placa\n" +
                "7. Sair do Sistema\n\n" +
                "Digitar Opção: ");

        switch (Integer.parseInt(opcaoMenu)) {
            case 1:
                String newPlacaP = leituraObj.entDados(" Inserir numero da placa: ");
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
                System.out.println("VEÍCULO PASSEIO CADASTRADO COM SUCESSO!\n\n");
                break;

            case 2:
                String newPlacaC = leituraObj.entDados(" Inserir numero da placa: ");
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
                System.out.println("VEÍCULO CARGA CADASTRADO COM SUCESSO!\n\n");

            case 3:
                if(passeioArray.isEmpty()) {
                    System.out.println("NÃO HÁ VEÍCULOS DE PASSEIO ARMAZENADOS!\n\n");
                    break;
                }
                passeioArray.forEach(System.out::println);
                break;

            case 4:
                if(cargaArray.isEmpty()) {
                    System.out.println("NÃO HÁ VEÍCULOS DE CARGA ARMAZENADOS!\n\n");
                    break;
                }
                cargaArray.forEach(System.out::println);
                break;

            case 5:
                String buscarPlacaP = leituraObj.entDados(" Insera a placa do Veículo Passeio a ser buscado: ");
                for(Veiculo buscarVeiculo : passeioArray) {
                    if(buscarVeiculo.getPlaca() == buscarPlacaP) {
                        System.out.println("Veículo encontrado: \n\n" + buscarVeiculo);
                        break;
                    }
                }
                System.out.println("Veículo passeio não encontrado. Tente novamente.");
                break;

            case 6:
                String buscarPlacaC = leituraObj.entDados(" Insera a placa do Veículo Carga a ser buscado: ");
                for(Veiculo buscarVeiculo : cargaArray) {
                    if(buscarVeiculo.getPlaca() == buscarPlacaC) {
                        System.out.println("Veículo encontrado: \n\n" + buscarVeiculo);
                        break;
                    }
                }
                System.out.println("Veículo Carga não encontrado. Tente novamente.");
                break;

            default:
                System.out.println("Opção não encontrada. Por favor, selecionar opção >= 1 e <= 7");
        }
    }






}
