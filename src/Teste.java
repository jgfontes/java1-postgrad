import java.util.ArrayList;

public class Teste {
    private static Leitura leituraObj = new Leitura();

    public static void main(String[] args) throws VelocException {
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

                //Cadastrar Veiculo passeio
                case 1:
                    while(continuaLoop) {
                        //Validate if passeio array is full
                        if (bancoDeDadosVeiculos.getPasseioArray().size() >= 5) {
                            System.out.println("Lista de Veículos passeio já está cheia. Finalizando operação.\n");
                            leituraObj.entDados("Aperte <ENTER> para continuar\n\n");
                            break;
                        }

                        //Create instance of the new Veiculo and set values
                        Passeio novoVeiculoPasseio = new Passeio();
                        novoVeiculoPasseio.setPlaca(leituraObj.entDados(" Inserir numero da placa: "));
                        novoVeiculoPasseio.setMarca(leituraObj.entDados(" Inserir marca: "));
                        novoVeiculoPasseio.setModelo(leituraObj.entDados(" Inserir o nome do modelo: "));
                        novoVeiculoPasseio.setCor(leituraObj.entDados(" Inserir a cor do carro: "));
                        try {
                            novoVeiculoPasseio.setVelocMax(Float.parseFloat(leituraObj.entDados(" Inserir a Veloc Max do carro (Km/h): ")));
                        } catch (VelocException e) {
                            e.printStackTrace();
                            System.out.println("Por padrão, a velocidade máxima de 100 Km/h será atribuída ao Veículo passeio.\n");
                            novoVeiculoPasseio.setVelocMax(100);
                        }
                        novoVeiculoPasseio.setQtdRodas(Integer.parseInt(leituraObj.entDados(" Inserir a quantidade de rodas do veículo: ")));
                        novoVeiculoPasseio.getMotor().setQtdPist(Integer.parseInt(leituraObj.entDados(" Inserir a quantidade de pistões do motor do carro: ")));
                        novoVeiculoPasseio.getMotor().setPotencia(Integer.parseInt(leituraObj.entDados(" Inserir a potência do motor do carro: ")));
                        novoVeiculoPasseio.setQtdPassageiros(Integer.parseInt(leituraObj.entDados(" Inserir a quantidade de passageiros: ")));

                        //Try to add Veiculo in the Database class
                        try {
                            bancoDeDadosVeiculos.cadastraPasseio(novoVeiculoPasseio);
                        } catch (VeicExistException e) {
                            e.printStackTrace();
                            break;
                        }

                        if (!checaNovoCadastro()) { continuaLoop = false; }
                    }
                    break;

                //Cadastrar Veículo de Carga
                case 2:
                    while(continuaLoop) {
                        //Validate if carga array is full
                        if (bancoDeDadosVeiculos.getCargaArray().size() >= 5) {
                            System.out.println("Lista de Veículos carga já está cheia. Finalizando operação.");
                            leituraObj.entDados("Aperte <ENTER> para continuar");
                            break;
                        }

                        //Create instance of the new Carga and set values
                        Carga novoVeiculoCarga = new Carga();
                        novoVeiculoCarga.setPlaca(leituraObj.entDados(" Inserir numero da placa: "));
                        novoVeiculoCarga.setMarca(leituraObj.entDados(" Inserir marca: "));
                        novoVeiculoCarga.setModelo(leituraObj.entDados(" Inserir o nome do modelo: "));
                        novoVeiculoCarga.setCor(leituraObj.entDados(" Inserir a cor do carro: "));
                        try {
                            novoVeiculoCarga.setVelocMax(Float.parseFloat(leituraObj.entDados(" Inserir a Veloc Max do carro (Km/h): ")));
                        } catch (VelocException e) {
                            e.printStackTrace();
                            System.out.println("Por padrão, a velocidade máxima de 100 Km/h será atribuída ao Veículo passeio.\n");
                            novoVeiculoCarga.setVelocMax(100f);
                        }
                        novoVeiculoCarga.setQtdRodas(Integer.parseInt(leituraObj.entDados(" Inserir a quantidade de rodas do veículo: ")));
                        novoVeiculoCarga.getMotor().setQtdPist(Integer.parseInt(leituraObj.entDados(" Inserir a quantidade de pistões do motor do carro: ")));
                        novoVeiculoCarga.getMotor().setPotencia(Integer.parseInt(leituraObj.entDados(" Inserir a potência do motor do carro: ")));
                        novoVeiculoCarga.setTara(Integer.parseInt(leituraObj.entDados(" Inserir a tara do veículo: ")));
                        novoVeiculoCarga.setCargaMax(Integer.parseInt(leituraObj.entDados(" Inserir a carga Max: ")));
                        try {
                            bancoDeDadosVeiculos.cadastraCarga(novoVeiculoCarga);
                        } catch (VeicExistException e) {
                            e.printStackTrace();
                            break;
                        }

                        if (!checaNovoCadastro()) { continuaLoop = false; }
                    }
                    break;

                //Imprimir Todos os Veículos de Passeio
                case 3:
                    if (bancoDeDadosVeiculos.getPasseioArray().isEmpty()) {
                        System.out.println("Não há veículos de passeio armazenados!\n\n");
                        break;
                    }
                    bancoDeDadosVeiculos.getPasseioArray().forEach(System.out::println);
                    break;

                //Imprimir Todos os Veículos de Carga
                case 4:
                    if (bancoDeDadosVeiculos.getCargaArray().isEmpty()) {
                        System.out.println("Não há veículos de carga armazenados!\n\n");
                        break;
                    }
                    bancoDeDadosVeiculos.getCargaArray().forEach(System.out::println);
                    break;

                //Imprimir Veículo de Passeio pela Placa
                case 5:
                    String buscarPlacaP = leituraObj.entDados(" Insera a placa do Veículo Passeio a ser buscado: ");
                    Veiculo passeioBusca = bancoDeDadosVeiculos.buscaVeiculoPorPlaca(buscarPlacaP, bancoDeDadosVeiculos.getPasseioArray());
                    if(passeioBusca == null) {
                        System.out.println("Veículo Passeio não encontrado. Tente novamente.\n\n");
                        break;
                    }
                    System.out.println("Veículo encontrado: \n\n" + passeioBusca);
                    break;

                //Imprimir Veículo de Carga pela Plac
                case 6:
                    String buscarPlacaC = leituraObj.entDados(" Insera a placa do Veículo Carga a ser buscado: ");
                    Veiculo cargaBusca = bancoDeDadosVeiculos.buscaVeiculoPorPlaca(buscarPlacaC, bancoDeDadosVeiculos.getCargaArray());
                    if(cargaBusca == null) {
                        System.out.println("Veículo Carga não encontrado. Tente novamente.\n\n");
                        break;
                    }
                    System.out.println("Veículo encontrado: \n\n" + cargaBusca);
                    break;

                //Sair do Sistema
                case 7:
                    continuaPrograma = false;
                    break;

                default:
                    System.out.println("Opção não encontrada. Por favor, selecionar opção >= 1 e <= 7");
            }
        }

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
