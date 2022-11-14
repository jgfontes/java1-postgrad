import java.util.ArrayList;

public class Teste {
    private static Leitura leituraObj = new Leitura();
    private static ArrayList<Veiculo> cargaArray = new ArrayList<Veiculo>(5);
    private static ArrayList<Veiculo> passeioArray = new ArrayList<Veiculo>(5);

    public static void main(String[] args) {
        boolean continuaPrograma = true;
        int opcaoMenuInt = 0;
        boolean continuaLoop = true;
        BDVeiculos bancoDeDadosVeiculos = new BDVeiculos();

        while(continuaPrograma) {
            continuaLoop = true;
            String opcaoMenu = leituraObj.entDados(
                    "Sistema de Gestão de Veículos - Menu Inicial\n\n" +
                    "1. Cadastrar Veículo de Passeio\n" +
                    "2. Cadastrar Veículo de Carga\n" +
                    "3. Imprimir Todos os Veículos de Passeio\n" +
                    "4. Imprimir Todos os Veículos de Carga\n" +
                    "5. Imprimir Veículo de Passeio pela Placa\n" +
                    "6. Imprimir Veículo de Carga pela Placa\n" +
                    "7. Sair do Sistema\n\n" +
                    "Digitar Opção: ");

            try {
                opcaoMenuInt = Integer.parseInt(opcaoMenu);
            }
            catch (NumberFormatException nfe) {
                System.out.println("Opção do Menu nã encontrada. O valor entrado deve ser inteiro, maior que 1 e menor que 7.\n");
                leituraObj.entDados("Aperte <ENTER> para continuar.\n\n");
            }

            switch (opcaoMenuInt) {
                case 1:
                    while(continuaLoop) {
                        //Validate if passeio array is full
                        if (passeioArray.size() >= 5) {
                            System.out.println("Lista de Veículos passeio já está cheia. Finalizando operação.\n");
                            leituraObj.entDados("Aperte <ENTER> para continuar\n\n");
                            break;
                        }

                        String newPlacaP = leituraObj.entDados(" Inserir numero da placa: ");
                        //Validate if Placa already exists
                        if (buscaVeiculoPorPlaca(newPlacaP, passeioArray) != null) {
                            System.out.println("Um veículo com esta placa já foi cadastrado. Tente novamente. \n");
                            leituraObj.entDados("Aperte <ENTER> para continuar\n\n");
                            break;
                        }

                        bancoDeDadosVeiculos.cadastraPasseio(newPlacaP);
                        if (!checaNovoCadastro()) { continuaLoop = false; }
                    }
                    break;

                case 2:
                    while(continuaLoop) {
                        //Validate if carga array is full
                        if (cargaArray.size() >= 5) {
                            System.out.println("Lista de Veículos carga já está cheia. Finalizando operação.");
                            leituraObj.entDados("Aperte <ENTER> para continuar");
                            break;
                        }

                        String newPlacaC = leituraObj.entDados(" Inserir numero da placa: ");

                        //Validate if Placa already exists
                        if (buscaVeiculoPorPlaca(newPlacaC, cargaArray) != null) {
                            System.out.println("Um veículo com esta placa já foi cadastrado. Finalizando operação. \n");
                            leituraObj.entDados("Aperte <ENTER> para continuar");
                            break;
                        }

                        bancoDeDadosVeiculos.cadastraCarga(newPlacaC);
                        if (!checaNovoCadastro()) { continuaLoop = false; }
                    }
                    break;

                case 3:
                    if (bancoDeDadosVeiculos.getPasseioArray().isEmpty()) {
                        System.out.println("Não há veículos de passeio armazenados!\n\n");
                        break;
                    }
                    bancoDeDadosVeiculos.getPasseioArray().forEach(System.out::println);
                    break;

                case 4:
                    if (bancoDeDadosVeiculos.getCargaArray().isEmpty()) {
                        System.out.println("Não há veículos de carga armazenados!\n\n");
                        break;
                    }
                    bancoDeDadosVeiculos.getCargaArray().forEach(System.out::println);
                    break;

                case 5:
                    String buscarPlacaP = leituraObj.entDados(" Insera a placa do Veículo Passeio a ser buscado: ");
                    Veiculo passeioBusca = bancoDeDadosVeiculos.buscaVeiculoPorPlaca(buscarPlacaP, bancoDeDadosVeiculos.getPasseioArray());
                    if(passeioBusca == null) {
                        System.out.println("Veículo Passeio não encontrado. Tente novamente.\n\n");
                        break;
                    }
                    System.out.println("Veículo encontrado: \n\n" + passeioBusca);
                    break;

                case 6:
                    String buscarPlacaC = leituraObj.entDados(" Insera a placa do Veículo Carga a ser buscado: ");
                    Veiculo cargaBusca = bancoDeDadosVeiculos.buscaVeiculoPorPlaca(buscarPlacaC, bancoDeDadosVeiculos.getCargaArray());
                    if(cargaBusca == null) {
                        System.out.println("Veículo Carga não encontrado. Tente novamente.\n\n");
                        break;
                    }
                    System.out.println("Veículo encontrado: \n\n" + cargaBusca);
                    break;

                case 7:
                    continuaPrograma = false;
                    break;

                default:
                    System.out.println("Opção não encontrada. Por favor, selecionar opção >= 1 e <= 7");
            }
        }

    }

    private static Veiculo buscaVeiculoPorPlaca(String placaVeiculo, ArrayList<Veiculo> veiculoArray) {
        for(Veiculo buscarVeiculo : veiculoArray) {
            if(buscarVeiculo.getPlaca().equals(placaVeiculo)) {
                return buscarVeiculo;
            }
        }
        return null;
    }

    public static void cadastraPasseio(ArrayList<Veiculo> passeioInputArray, String newPlacaP) {
        String newMarca = leituraObj.entDados(" Inserir marca: ");
        String newModeloP = leituraObj.entDados(" Inserir o nome do modelo: ");
        String newCorP = leituraObj.entDados(" Inserir a cor do carro: ");
        String newVelocMaxP = leituraObj.entDados(" Inserir a Veloc Max do carro (Km/h): ");
        String newQtdRodasP = leituraObj.entDados(" Inserir a quantidade de rodas do veículo: ");
        String newQtdPistP = leituraObj.entDados(" Inserir a quantidade de pistões do motor do carro: ");
        String newPotenciaP = leituraObj.entDados(" Inserir a potência do motor do carro: ");
        String newQtdPassageirosP = leituraObj.entDados(" Inserir a quantidade de passageiros: ");

        passeioInputArray.add(new Passeio(
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
    }

    public static void cadastraCarga(ArrayList<Veiculo> cargaInputArray, String newPlacaC) {
        String newMarcaC = leituraObj.entDados(" Inserir marca: ");
        String newModeloC = leituraObj.entDados(" Inserir o nome do modelo: ");
        String newCorC = leituraObj.entDados(" Inserir a cor do carro: ");
        String newVelocMaxC = leituraObj.entDados(" Inserir a Veloc Max do carro (Km/h): ");
        String newQtdRodasC = leituraObj.entDados(" Inserir a quantidade de rodas do veículo: ");
        String newQtdPistC = leituraObj.entDados(" Inserir a quantidade de pistões do motor do carro: ");
        String newPotenciaC = leituraObj.entDados(" Inserir a potência do motor do carro: ");
        String newTaraC = leituraObj.entDados(" Inserir a tara do veículo: ");
        String newCargaMaxC = leituraObj.entDados(" Inserir a carga Max: ");

        cargaInputArray.add(new Carga(
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
    }

    public static boolean checaNovoCadastro() {
        while(true) {
            String novoCadastro = leituraObj.entDados("Veículo cadastrado com sucesso. Gostaria de realizar outro cadastro? Digite 's' para sim e 'n' para não\n");
            if (novoCadastro.equals("n")) {
                return false;
            } else if (novoCadastro.equals("s")) {
                return true;
            }
        }
    }

}
