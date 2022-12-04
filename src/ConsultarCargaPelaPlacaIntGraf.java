import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ConsultarCargaPelaPlacaIntGraf implements ActionListener {

    private JFrame consultarPelaPlacaTela = new JFrame("Cadastra Carga");
    private BDVeiculos bancoDeDadosVeiculos = gestaoDeVeiculosIntGraf.bancoDeDadosVeiculos;

    //Declare JLabels -> Text Fields
    private JLabel taraTxt = new JLabel("taraTxt");
    private JLabel cargaMaxTxt = new JLabel("cargaTxt");
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
        consultarPelaPlacaTela.add(taraTxt, c);
        c.gridx = 1;
        c.gridy = 0;
        consultarPelaPlacaTela.add(taraInput, c);
        c.gridx = 0;
        c.gridy = 1;
        consultarPelaPlacaTela.add(cargaMaxTxt, c);
        c.gridx = 1;
        c.gridy = 1;
        consultarPelaPlacaTela.add(cargaMaxInput, c);
        c.gridx = 0;
        c.gridy = 2;
        consultarPelaPlacaTela.add(placaTxt, c);
        c.gridx = 1;
        c.gridy = 2;
        consultarPelaPlacaTela.add(placaInput, c);
        c.gridx = 0;
        c.gridy = 3;
        consultarPelaPlacaTela.add(marcaTxt, c);
        c.gridx = 1;
        c.gridy = 3;
        consultarPelaPlacaTela.add(marcaInput, c);
        c.gridx = 0;
        c.gridy = 4;
        consultarPelaPlacaTela.add(modeloTxt, c);
        c.gridx = 1;
        c.gridy = 4;
        consultarPelaPlacaTela.add(modeloInput, c);
        c.gridx = 0;
        c.gridy = 5;
        consultarPelaPlacaTela.add(corTxt, c);
        c.gridx = 1;
        c.gridy = 5;
        consultarPelaPlacaTela.add(corInput, c);
        c.gridx = 0;
        c.gridy = 6;
        consultarPelaPlacaTela.add(qtdRodasTxt, c);
        c.gridx = 1;
        c.gridy = 6;
        consultarPelaPlacaTela.add(qtdRodasInput, c);
        c.gridx = 0;
        c.gridy = 7;
        consultarPelaPlacaTela.add(velocMaxTxt, c);
        c.gridx = 1;
        c.gridy = 7;
        consultarPelaPlacaTela.add(velocMaxInput, c);
        c.gridx = 0;
        c.gridy = 8;
        consultarPelaPlacaTela.add(qtdPistoesTxt, c);
        c.gridx = 1;
        c.gridy = 8;
        consultarPelaPlacaTela.add(qtdPistoesInput, c);
        c.gridx = 0;
        c.gridy = 9;
        consultarPelaPlacaTela.add(potenciaTxt, c);
        c.gridx = 1;
        c.gridy = 9;
        consultarPelaPlacaTela.add(potenciaInput, c);
        c.gridx = 0;
        c.gridy = 10;
        consultarPelaPlacaTela.add(consultarBtn, c);
        c.gridx = 1;
        c.gridy = 10;
        consultarPelaPlacaTela.add(excluirBtn, c);
        c.gridx = 2;
        c.gridy = 10;
        consultarPelaPlacaTela.add(sairBtn, c);
        consultarPelaPlacaTela.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        Object objSource = evt.getSource();

        if (objSource.equals(consultarBtn)) {
            consultaCarga(placaInput.getText());
        }
        else if (objSource.equals(excluirBtn)) {
            excluiCarga(placaInput.getText());
        }
        else if (objSource.equals(sairBtn)) {
            consultarPelaPlacaTela.dispose();
        }
    }

    public void consultaCarga(String placa) {
        Veiculo cargaBusca = bancoDeDadosVeiculos.buscaVeiculoPorPlaca(
                placa,
                bancoDeDadosVeiculos.getCargaArray());
        if(cargaBusca == null) {
            JOptionPane.showMessageDialog(null, "Veículo Carga não encontrado. Insira outra placa.", "Erro", JOptionPane.ERROR_MESSAGE);
            limpaValores();
        } else {
            taraInput.setText(Integer.toString(((Carga) cargaBusca).getTara()));
            cargaMaxInput.setText(Integer.toString(((Carga) cargaBusca).getCargaMax()));
            placaInput.setText(cargaBusca.getPlaca());
            marcaInput.setText(cargaBusca.getMarca());
            modeloInput.setText(cargaBusca.getModelo());
            corInput.setText(cargaBusca.getCor());
            qtdRodasInput.setText(Integer.toString(cargaBusca.getQtdRodas()));
            velocMaxInput.setText(Integer.toString(cargaBusca.getQtdRodas()));
            qtdPistoesInput.setText(Integer.toString(cargaBusca.getQtdRodas()));
            potenciaInput.setText(Integer.toString(cargaBusca.getMotor().getPotencia()));
        }
    }

    public void excluiCarga(String placa) {
        Veiculo cargaBusca = bancoDeDadosVeiculos.buscaVeiculoPorPlaca(
                placa,
                bancoDeDadosVeiculos.getCargaArray());
        if(cargaBusca == null) {
            JOptionPane.showMessageDialog(null, "Veículo Carga não encontrado. Insira outra placa.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            bancoDeDadosVeiculos.excluiPasseioPorPlaca(placa);
            JOptionPane.showMessageDialog(null,"Veículo excluído com sucesso!" , "SUCESSO",  JOptionPane.INFORMATION_MESSAGE);
            limpaValores();
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
}
