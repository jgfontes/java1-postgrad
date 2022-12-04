import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastraCargaIntGraf implements ActionListener {

    private JFrame cadastraCargaTela = new JFrame("Cadastra Passeio");
    private BDVeiculos bancoDeDadosVeiculos = gestaoDeVeiculosIntGraf.bancoDeDadosVeiculos;

    //Declare JLabels -> Text Fields
    private JLabel taraTxt = new JLabel("taraTxt");
    private JLabel cargaMaxTxt = new JLabel("cargaMaxTxt");
    private JLabel placaTxt = new JLabel("placaTxt");
    private JLabel marcaTxt = new JLabel("marcaTxt");
    private JLabel modeloTxt = new JLabel("modeloTxt");
    private JLabel corTxt = new JLabel("marcaTxt");
    private JLabel qtdRodasTxt = new JLabel("qtdRodasTxt");
    private JLabel velocMaxTxt = new JLabel("VelocMaxTxt");
    private JLabel qtdPistoesTxt = new JLabel("qtdPistoesTxt");
    private JLabel potenciaTxt = new JLabel("potenciaTxt");
    //Declare JTextFields -> Input Field
    private JTextField taraInput = new JTextField(10);
    private JTextField cargaMaxInput = new JTextField(10);
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

    public void carregarTela() {
        cadastraCargaTela.setLayout(new GridBagLayout());
        cadastraCargaTela.setSize(500, 500);
        cadastraCargaTela.setTitle("Cadastra Passeio");
        // “EXIT_ON_CLOSE”: fecha a aplicação toda.
        cadastraCargaTela.setDefaultCloseOperation(cadastraCargaTela.EXIT_ON_CLOSE);

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
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        cadastraCargaTela.add(taraTxt, c);
        c.gridx = 1;
        c.gridy = 0;
        cadastraCargaTela.add(taraInput, c);
        c.gridx = 0;
        c.gridy = 1;
        cadastraCargaTela.add(cargaMaxTxt, c);
        c.gridx = 1;
        c.gridy = 1;
        cadastraCargaTela.add(cargaMaxInput, c);
        c.gridx = 0;
        c.gridy = 2;
        cadastraCargaTela.add(placaTxt, c);
        c.gridx = 1;
        c.gridy = 2;
        cadastraCargaTela.add(placaInput, c);
        c.gridx = 0;
        c.gridy = 3;
        cadastraCargaTela.add(marcaTxt, c);
        c.gridx = 1;
        c.gridy = 3;
        cadastraCargaTela.add(marcaInput, c);
        c.gridx = 0;
        c.gridy = 4;
        cadastraCargaTela.add(modeloTxt, c);
        c.gridx = 1;
        c.gridy = 4;
        cadastraCargaTela.add(modeloInput, c);
        c.gridx = 0;
        c.gridy = 5;
        cadastraCargaTela.add(corTxt, c);
        c.gridx = 1;
        c.gridy = 5;
        cadastraCargaTela.add(corInput, c);
        c.gridx = 0;
        c.gridy = 6;
        cadastraCargaTela.add(qtdRodasTxt, c);
        c.gridx = 1;
        c.gridy = 6;
        cadastraCargaTela.add(qtdRodasInput, c);
        c.gridx = 0;
        c.gridy = 7;
        cadastraCargaTela.add(velocMaxTxt, c);
        c.gridx = 1;
        c.gridy = 7;
        cadastraCargaTela.add(velocMaxInput, c);
        c.gridx = 0;
        c.gridy = 8;
        cadastraCargaTela.add(qtdPistoesTxt, c);
        c.gridx = 1;
        c.gridy = 8;
        cadastraCargaTela.add(qtdPistoesInput, c);
        c.gridx = 0;
        c.gridy = 9;
        cadastraCargaTela.add(potenciaTxt, c);
        c.gridx = 1;
        c.gridy = 9;
        cadastraCargaTela.add(potenciaInput, c);
        c.gridx = 0;
        c.gridy = 10;
        cadastraCargaTela.add(cadastrarBtn, c);
        c.gridx = 1;
        c.gridy = 10;
        cadastraCargaTela.add(limparBtn, c);
        c.gridx = 2;
        c.gridy = 10;
        cadastraCargaTela.add(novoBtn, c);
        c.gridx = 3;
        c.gridy = 10;
        cadastraCargaTela.add(sairBtn, c);
        cadastraCargaTela.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        Object objSource = evt.getSource();

        if (objSource.equals(cadastrarBtn)) {
            cadastraCarga();
        } else if (objSource.equals(limparBtn)) {
            limpaValores();
        }
        else if (objSource.equals(novoBtn)) {
            limpaValores();
        }
        else if (objSource.equals(sairBtn)) {
            cadastraCargaTela.dispose();
        }
    }

    public void cadastraCarga() {
        if(validaCamposVazios()) {
            JOptionPane.showMessageDialog(null,"Todos os campos precisam estar preenchidos." , "ERRO",  JOptionPane.ERROR_MESSAGE);
            return;
        }

        Carga novoVeiculoCarga = new Carga();
        novoVeiculoCarga.setPlaca(placaInput.getText());
        novoVeiculoCarga.setMarca(marcaInput.getText());
        novoVeiculoCarga.setModelo(modeloInput.getText());
        novoVeiculoCarga.setCor(corInput.getText());
        try {
            novoVeiculoCarga.setVelocMax(Float.parseFloat(velocMaxInput.getText()));
        } catch (VelocException e) {
            JOptionPane.showMessageDialog(null,"A velocidade não pode ser menor que 80 km/h e maior que 100 km/h.\n" +
                    "Por padrão, a velocidade máxima de 100 Km/h será atribuída ao Veículo passeio." ,
                    "ERRO",
                    JOptionPane.WARNING_MESSAGE);
            try {
                novoVeiculoCarga.setVelocMax(100);
            } catch (VelocException ex) {}
        }
        novoVeiculoCarga.setQtdRodas(Integer.parseInt(qtdRodasInput.getText()));
        novoVeiculoCarga.getMotor().setQtdPist(Integer.parseInt(qtdPistoesInput.getText()));
        novoVeiculoCarga.getMotor().setPotencia(Integer.parseInt(potenciaInput.getText()));
        novoVeiculoCarga.setCargaMax(Integer.parseInt(cargaMaxInput.getText()));
        novoVeiculoCarga.setTara(Integer.parseInt(taraInput.getText()));

        //Try to add Veiculo in the Database class
        try {
            bancoDeDadosVeiculos.cadastraCarga(novoVeiculoCarga);
            JOptionPane.showMessageDialog(null,"Veículo Cadastrado com sucesso!" , "SUCESSO",  JOptionPane.INFORMATION_MESSAGE);
        } catch (VeicExistException e) {
            JOptionPane.showMessageDialog(null,"Um veículo com esta placa já existe. Tente novamente." , "ERRO",  JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limpaValores() {
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

    public boolean validaCamposVazios() {
        JTextField[] camposArray = {taraInput, cargaMaxInput, placaInput, marcaInput, modeloInput, corInput, qtdRodasInput, velocMaxInput, qtdPistoesInput, potenciaInput};
        for (JTextField campo : camposArray) {
            if (campo.getText().isBlank()) {
                return true;
            }
        }
        return false;
    }
}