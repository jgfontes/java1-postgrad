import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CadastraPasseioIntGraf implements ActionListener {

    private JFrame cadastraPasseioTela = new JFrame("Cadastra Passeio");
    private BDVeiculos bancoDeDadosVeiculos = gestaoDeVeiculosIntGraf.bancoDeDadosVeiculos;

    //Declare JLabels -> Text Fields
    private JLabel qtdPassageirosTxt = new JLabel("qtdPassageirosTxt");
    private JLabel placaTxt = new JLabel("placaTxt");
    private JLabel marcaTxt = new JLabel("marcaTxt");
    private JLabel modeloTxt = new JLabel("modeloTxt");
    private JLabel corTxt = new JLabel("marcaTxt");
    private JLabel qtdRodasTxt = new JLabel("qtdRodasTxt");
    private JLabel velocMaxTxt = new JLabel("VelocMaxTxt");
    private JLabel qtdPistoesTxt = new JLabel("qtdPistoesTxt");
    private JLabel potenciaTxt = new JLabel("potenciaTxt");
    //Declare JTextFields -> Input Field
    private JTextField qtdPassageirosInput = new JTextField(10);
    private JTextField placaInput = new JTextField(10);
    private JTextField marcaInput = new JTextField(10);
    private JTextField modeloInput = new JTextField(10);
    private JTextField corInput = new JTextField(10);
    private JTextField qtdRodasInput = new JTextField(10);
    private JTextField velocMaxInput = new JTextField(10);
    private JTextField qtdPistoesInput = new JTextField(10);
    private JTextField potenciaInput = new JTextField(10);
    //Declare Buttons
    private JButton cadastrarBtn = new JButton();
    private JButton limparBtn = new JButton();
    private JButton novoBtn = new JButton();
    private JButton sairBtn = new JButton();

    public void carregarJanela() {
        cadastraPasseioTela.setSize(500, 500);
        cadastraPasseioTela.setTitle("Cadastra Passeio");
        // “EXIT_ON_CLOSE”: fecha a aplicação toda.
        cadastraPasseioTela.setDefaultCloseOperation(cadastraPasseioTela.EXIT_ON_CLOSE);

        //Set button texts
        cadastrarBtn.setText("Cadastrar");
        limparBtn.setText("Limpar");
        novoBtn.setText("Novo");
        sairBtn.setText("Sair");
        cadastrarBtn.addActionListener(this);
        limparBtn.addActionListener(this);
        novoBtn.addActionListener(this);
        sairBtn.addActionListener(this);

        //Set fixed text labels
        qtdPassageirosTxt.setText("QtdPassageiros: ");
        placaTxt.setText("Placa: ");
        marcaTxt.setText("Marca: ");
        modeloTxt.setText("Modelo: ");
        corTxt.setText("Cor: ");
        qtdRodasTxt.setText("Quantidade de Rodas: ");
        velocMaxTxt.setText("Velocidade Máxima: ");
        qtdPistoesTxt.setText("Quantidade de pistões: ");
        potenciaTxt.setText("Potência: ");

        //Add input text
        cadastraPasseioTela.add(qtdPassageirosTxt);
        cadastraPasseioTela.add(qtdPassageirosInput);
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
            cadastraPasseio();

        } else if (objSource.equals(limparBtn)) {
            limpaValores();
        }
        else if (objSource.equals(novoBtn)) {
            limpaValores();
        }
        else if (objSource.equals(sairBtn)) {
            cadastraPasseioTela.dispose();
        }
    }

    public void cadastraPasseio() {
        if(validaCamposVazios()) {
            JOptionPane.showMessageDialog(null,"Todos os campos precisam estar preenchidos." , "ERRO",  JOptionPane.ERROR_MESSAGE);
            return;
        }

        Passeio novoVeiculoPasseio = new Passeio();
        novoVeiculoPasseio.setPlaca(placaInput.getText());
        novoVeiculoPasseio.setMarca(marcaInput.getText());
        novoVeiculoPasseio.setModelo(modeloInput.getText());
        novoVeiculoPasseio.setCor(corInput.getText());
        try {
            novoVeiculoPasseio.setVelocMax(Float.parseFloat(velocMaxInput.getText()));
        } catch (VelocException e) {
            JOptionPane.showMessageDialog(null,"A velocidade não pode ser menor que 80 km/h e maior que 100 km/h.\n" +
                    "Por padrão, a velocidade máxima de 100 Km/h será atribuída ao Veículo passeio." ,
                    "ERRO",
                    JOptionPane.WARNING_MESSAGE);
            try {
                novoVeiculoPasseio.setVelocMax(100);
            } catch (VelocException ex) {}
        }
        novoVeiculoPasseio.setQtdRodas(Integer.parseInt(qtdRodasInput.getText()));
        novoVeiculoPasseio.getMotor().setQtdPist(Integer.parseInt(qtdPistoesInput.getText()));
        novoVeiculoPasseio.getMotor().setPotencia(Integer.parseInt(potenciaInput.getText()));
        novoVeiculoPasseio.setQtdPassageiros(Integer.parseInt(qtdPassageirosInput.getText()));

        //Try to add Veiculo in the Database class
        try {
            bancoDeDadosVeiculos.cadastraPasseio(novoVeiculoPasseio);
            bancoDeDadosVeiculos.getPasseioArray().forEach(System.out::println);
            JOptionPane.showMessageDialog(null,"Veículo Cadastrada com sucesso!" , "SUCESSO",  JOptionPane.INFORMATION_MESSAGE);
        } catch (VeicExistException e) {
            JOptionPane.showMessageDialog(null,"Um veículo com esta placa já existe. Tente novamente." , "ERRO",  JOptionPane.ERROR_MESSAGE);
        }
    }

    //Return 0 if fields are filled // return 1 if any of fields is empty
    public boolean validaCamposVazios() {
        JTextField[] camposArray = {qtdPassageirosInput, placaInput, marcaInput, modeloInput, corInput, qtdRodasInput, velocMaxInput, qtdPistoesInput, potenciaInput};
        for (JTextField campo : camposArray) {
            if (campo.getText().isBlank()) {
                return true;
            }
        }
        return false;
    }

    public void limpaValores() {
        qtdPassageirosInput.setText("");
        placaInput.setText("");
        marcaInput.setText("");
        modeloInput.setText("");
        corInput.setText("");
        qtdRodasInput.setText("");
        velocMaxInput.setText("");
        qtdPistoesInput.setText("");
        potenciaInput.setText("");
    }
}