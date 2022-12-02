import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cadastraCargaIntGraf implements ActionListener {

    private static JFrame cadastraPasseioTela = new JFrame("Cadastra Passeio");
    private static BDVeiculos bancoDeDadosVeiculos;

    //Declare JLabels -> Text Fields
    private static JLabel taraTxt = new JLabel("qtdPassageirosTxt");
    private static JLabel cargaMaxTxt = new JLabel("qtdPassageirosTxt");
    private static JLabel placaTxt = new JLabel("placaTxt");
    private static JLabel marcaTxt = new JLabel("marcaTxt");
    private static JLabel modeloTxt = new JLabel("modeloTxt");
    private static JLabel corTxt = new JLabel("marcaTxt");
    private static JLabel qtdRodasTxt = new JLabel("qtdRodasTxt");
    private static JLabel velocMaxTxt = new JLabel("VelocMaxTxt");
    private static JLabel qtdPistoesTxt = new JLabel("qtdPistoesTxt");
    private static JLabel potenciaTxt = new JLabel("potenciaTxt");
    //Declare JTextFields -> Input Field
    private static JTextField taraInput = new JTextField(10);
    private static JTextField cargaMaxInput = new JTextField(10);
    private static JTextField placaInput = new JTextField(10);
    private static JTextField marcaInput = new JTextField(10);
    private static JTextField modeloInput = new JTextField(10);
    private static JTextField corInput = new JTextField(10);
    private static JTextField qtdRodasInput = new JTextField(10);
    private static JTextField velocMaxInput = new JTextField(10);
    private static JTextField qtdPistoesInput = new JTextField(10);
    private static JTextField potenciaInput = new JTextField(10);
    //Declare Buttons
    private static JButton cadastrarBtn = new JButton();
    private static JButton limparBtn = new JButton();
    private static JButton novoBtn = new JButton();
    private static JButton sairBtn = new JButton();
    static cadastraCargaIntGraf janela = new cadastraCargaIntGraf();

    public static void main(BDVeiculos bancoDeDados) {
        bancoDeDadosVeiculos = bancoDeDados;
        int larg = 500, alt = 500;
        cadastraPasseioTela.setSize(larg, alt);
        cadastraPasseioTela.setTitle("Cadastra Passeio");
        // “EXIT_ON_CLOSE”: fecha a aplicação toda.
        cadastraPasseioTela.setDefaultCloseOperation(cadastraPasseioTela.EXIT_ON_CLOSE);

        //Set button texts
        cadastrarBtn.setText("Cadastrar");
        limparBtn.setText("Limpar");
        novoBtn.setText("Novo");
        sairBtn.setText("Sair");
        cadastrarBtn.addActionListener((ActionListener) janela);
        limparBtn.addActionListener((ActionListener) janela);
        novoBtn.addActionListener((ActionListener) janela);
        sairBtn.addActionListener((ActionListener) janela);

        //Set fixed text labels
        taraTxt.setText("Tara: ");
        cargaMaxTxt.setText("Carga Max: ");
        placaTxt.setText("Placa: ");
        marcaTxt.setText("Marca: ");
        modeloTxt.setText("Modelo: ");
        corTxt.setText("Cor: ");
        qtdRodasTxt.setText("Quantidade de Rodas: ");
        velocMaxTxt.setText("Velocidade Máxima: ");
        qtdPistoesTxt.setText("Quantidade de pistões: ");
        potenciaTxt.setText("Potência: ");

        //Add input text
        cadastraPasseioTela.add(taraTxt);
        cadastraPasseioTela.add(taraInput);
        cadastraPasseioTela.add(cargaMaxTxt);
        cadastraPasseioTela.add(cargaMaxInput);
        cadastraPasseioTela.add(placaTxt);
        cadastraPasseioTela.add(placaInput);
        cadastraPasseioTela.add(marcaTxt);
        cadastraPasseioTela.add(marcaInput);
        cadastraPasseioTela.add(modeloTxt);
        cadastraPasseioTela.add(modeloInput);
        cadastraPasseioTela.add(corTxt);
        cadastraPasseioTela.add(corInput);
        cadastraPasseioTela.add(qtdRodasTxt);
        cadastraPasseioTela.add(qtdRodasInput);
        cadastraPasseioTela.add(velocMaxTxt);
        cadastraPasseioTela.add(velocMaxInput);
        cadastraPasseioTela.add(qtdPistoesTxt);
        cadastraPasseioTela.add(qtdPistoesInput);
        cadastraPasseioTela.add(potenciaTxt);
        cadastraPasseioTela.add(potenciaInput);
        cadastraPasseioTela.add(cadastrarBtn);
        cadastraPasseioTela.add(limparBtn);
        cadastraPasseioTela.add(novoBtn);
        cadastraPasseioTela.add(sairBtn);

        cadastraPasseioTela.setLayout(new FlowLayout());
        cadastraPasseioTela.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        Object objSource = evt.getSource();

        if (objSource.equals(cadastrarBtn)) {

            Carga novoVeiculoCarga = new Carga();
            novoVeiculoCarga.setPlaca(placaInput.getText());
            novoVeiculoCarga.setMarca(marcaInput.getText());
            novoVeiculoCarga.setModelo(modeloInput.getText());
            novoVeiculoCarga.setCor(corInput.getText());
            try {
                novoVeiculoCarga.setVelocMax(Float.parseFloat(velocMaxInput.getText()));
            } catch (VelocException e) {
                System.out.println("Por padrão, a velocidade máxima de 100 Km/h será atribuída ao Veículo Carga.\n");
                try {
                    novoVeiculoCarga.setVelocMax(100);
                } catch (VelocException ex) {
                    ex.printStackTrace();
                }
            }
            novoVeiculoCarga.setQtdRodas(Integer.parseInt(qtdRodasInput.getText()));
            novoVeiculoCarga.getMotor().setQtdPist(Integer.parseInt(qtdPistoesInput.getText()));
            novoVeiculoCarga.getMotor().setPotencia(Integer.parseInt(potenciaInput.getText()));
            novoVeiculoCarga.setCargaMax(Integer.parseInt(cargaMaxInput.getText()));
            novoVeiculoCarga.setTara(Integer.parseInt(taraInput.getText()));

            //Try to add Veiculo in the Database class
            try {
                bancoDeDadosVeiculos.cadastraCarga(novoVeiculoCarga);
                bancoDeDadosVeiculos.getCargaArray().forEach(System.out::println);
            } catch (VeicExistException e) {
                //ABRIR JANELA DEERRO -> veículo já existe
            }

        } else if (objSource.equals(limparBtn)) {
            taraInput.setText("");
            cargaMaxInput.setText("");
            placaInput.setText("");
            marcaInput.setText("");
            modeloInput.setText("");
            corInput.setText("");
            qtdRodasInput.setText("");
            velocMaxInput.setText("");
            qtdPistoesInput.setText("");
            potenciaInput.setText("");
        }
        else if (objSource.equals(novoBtn)) {
            taraInput.setText("");
            cargaMaxInput.setText("");
            placaInput.setText("");
            marcaInput.setText("");
            modeloInput.setText("");
            corInput.setText("");
            qtdRodasInput.setText("");
            velocMaxInput.setText("");
            qtdPistoesInput.setText("");
            potenciaInput.setText("");
        }
        else if (objSource.equals(sairBtn)) {
            System.exit(0);
        }
    }


}