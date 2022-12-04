import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ConsultarPasseioPelaPlacaIntGraf implements ActionListener {

    private JFrame consultarPelaPlacaTela = new JFrame("Cadastra Passeio");
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
    private JButton consultarBtn = new JButton();
    private JButton excluirBtn = new JButton();
    private JButton sairBtn = new JButton();

    public void carregarJanela() {
        consultarPelaPlacaTela.setLayout(new GridBagLayout());
        consultarPelaPlacaTela.setSize(500, 500);
        consultarPelaPlacaTela.setTitle("Cadastra Passeio");
        // “EXIT_ON_CLOSE”: fecha a aplicação toda.
        consultarPelaPlacaTela.setDefaultCloseOperation(consultarPelaPlacaTela.EXIT_ON_CLOSE);

        //Set button texts
        consultarBtn.setText("Consultar pela placa");
        excluirBtn.setText("Excluir");
        sairBtn.setText("Sair");
        consultarBtn.addActionListener(this);
        excluirBtn.addActionListener(this);
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
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        consultarPelaPlacaTela.add(placaTxt, c);
        c.gridx = 1;
        c.gridy = 0;
        consultarPelaPlacaTela.add(placaInput, c);
        c.gridx = 0;
        c.gridy = 1;
        consultarPelaPlacaTela.add(qtdPassageirosTxt, c);
        c.gridx = 1;
        c.gridy = 1;
        consultarPelaPlacaTela.add(qtdPassageirosInput, c);
        c.gridx = 0;
        c.gridy = 2;
        consultarPelaPlacaTela.add(marcaTxt, c);
        c.gridx = 1;
        c.gridy = 2;
        consultarPelaPlacaTela.add(marcaInput, c);
        c.gridx = 0;
        c.gridy = 3;
        consultarPelaPlacaTela.add(modeloTxt, c);
        c.gridx = 1;
        c.gridy = 3;
        consultarPelaPlacaTela.add(modeloInput, c);
        c.gridx = 0;
        c.gridy = 4;
        consultarPelaPlacaTela.add(corTxt, c);
        c.gridx = 1;
        c.gridy = 4;
        consultarPelaPlacaTela.add(corInput, c);
        c.gridx = 0;
        c.gridy = 5;
        consultarPelaPlacaTela.add(qtdRodasTxt, c);
        c.gridx = 1;
        c.gridy = 5;
        consultarPelaPlacaTela.add(qtdRodasInput, c);
        c.gridx = 0;
        c.gridy = 6;
        consultarPelaPlacaTela.add(velocMaxTxt, c);
        c.gridx = 1;
        c.gridy = 6;
        consultarPelaPlacaTela.add(velocMaxInput, c);
        c.gridx = 0;
        c.gridy = 7;
        consultarPelaPlacaTela.add(qtdPistoesTxt, c);
        c.gridx = 1;
        c.gridy = 7;
        consultarPelaPlacaTela.add(qtdPistoesInput, c);
        c.gridx = 0;
        c.gridy = 8;
        consultarPelaPlacaTela.add(potenciaTxt, c);
        c.gridx = 1;
        c.gridy = 8;
        consultarPelaPlacaTela.add(potenciaInput, c);
        c.gridx = 0;
        c.gridy = 9;
        consultarPelaPlacaTela.add(consultarBtn, c);
        c.gridx = 1;
        c.gridy = 9;
        consultarPelaPlacaTela.add(excluirBtn, c);
        c.gridx = 2;
        c.gridy = 9;
        consultarPelaPlacaTela.add(sairBtn, c);

        consultarPelaPlacaTela.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        Object objSource = evt.getSource();

        if (objSource.equals(consultarBtn)) {
            consultaPasseio(placaInput.getText());
        }
        else if (objSource.equals(excluirBtn)) {
            excluiPasseio(placaInput.getText());
        }
        else if (objSource.equals(sairBtn)) {
            consultarPelaPlacaTela.dispose();
        }
    }

    public void consultaPasseio(String placa) {
        Veiculo passeioBusca = bancoDeDadosVeiculos.buscaVeiculoPorPlaca(
                placa,
                bancoDeDadosVeiculos.getPasseioArray());
        if(passeioBusca == null) {
            JOptionPane.showMessageDialog(null, "Veículo Passeio não encontrado. Insira outra placa.", "Erro", JOptionPane.ERROR_MESSAGE);
            limpaValores();
        } else {
            qtdPassageirosInput.setText(Integer.toString(((Passeio) passeioBusca).getQtdPassageiros()));
            placaInput.setText(passeioBusca.getPlaca());
            marcaInput.setText(passeioBusca.getMarca());
            modeloInput.setText(passeioBusca.getModelo());
            corInput.setText(passeioBusca.getCor());
            qtdRodasInput.setText(Integer.toString(passeioBusca.getQtdRodas()));
            velocMaxInput.setText(Integer.toString(passeioBusca.getQtdRodas()));
            qtdPistoesInput.setText(Integer.toString(passeioBusca.getQtdRodas()));
            potenciaInput.setText(Integer.toString(passeioBusca.getMotor().getPotencia()));
        }
    }

    public void excluiPasseio(String placa) {
        Veiculo passeioBusca = bancoDeDadosVeiculos.buscaVeiculoPorPlaca(
                placa,
                bancoDeDadosVeiculos.getPasseioArray());
        if(passeioBusca == null) {
            JOptionPane.showMessageDialog(null, "Veículo Passeio não encontrado. Insira outra placa.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            bancoDeDadosVeiculos.excluiPasseioPorPlaca(placa);
            JOptionPane.showMessageDialog(null,"Veículo excluído com sucesso!" , "SUCESSO",  JOptionPane.INFORMATION_MESSAGE);
            limpaValores();
        }
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
