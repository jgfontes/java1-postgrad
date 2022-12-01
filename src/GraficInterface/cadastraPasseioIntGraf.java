package GraficInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cadastraPasseioIntGraf implements ActionListener {

    private static JFrame cadastraPasseioTela = new JFrame("Cadastra Passeio");
    //Declare JLabels -> Text Fields
    private static JLabel qtdPassageirosTxt = new JLabel("qtdPassageirosTxt");
    private static JLabel placaTxt = new JLabel("placaTxt");
    private static JLabel marcaTxt = new JLabel("marcaTxt");
    private static JLabel modeloTxt = new JLabel("modeloTxt");
    private static JLabel corTxt = new JLabel("marcaTxt");
    private static JLabel qtdRodasTxt = new JLabel("qtdRodasTxt");
    private static JLabel velocMaxTxt = new JLabel("VelocMaxTxt");
    private static JLabel qtdPistoesTxt = new JLabel("qtdPistoesTxt");
    private static JLabel potenciaTxt = new JLabel("potenciaTxt");
    //Declare JTextFields -> Input Field
    private static JTextField qtdPassageirosInput = new JTextField(10);
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
    static cadastraPasseioIntGraf janela = new cadastraPasseioIntGraf();

    public static void main(String[] args) {
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
        qtdPassageirosTxt.setText("QtdPassageiros: ");
        placaTxt.setText("Placa: ");
        marcaTxt.setText("Marca: ");
        modeloTxt.setText("Modelo: ");
        corTxt.setText("Cor: ");
        qtdRodasTxt.setText("Quantidade de Rodas: ");
        velocMaxTxt.setText("Velocidade Máxima: ");
        qtdPistoesTxt.setText("Quantidade de pistões: ");
        potenciaTxt.setText("Potência: ");

        //Add input text:
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

        if (objSource.equals(limparBtn)) {
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
        else if (objSource.equals(novoBtn)) {
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
        else if (objSource.equals(sairBtn)) {
            System.exit(0);
        }
        cadastraPasseioTela.setVisible(true);
    }


}