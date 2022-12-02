import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class consultarPelaPlacaIntGraf implements ActionListener{

    private static JFrame consultarPelaPlacaTela = new JFrame("Cadastra Passeio");
    private static BDVeiculos bancoDeDadosVeiculos;

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
    private static JButton consultarBtn = new JButton();
    private static JButton excluirBtn = new JButton();
    private static JButton sairBtn = new JButton();
    static consultarPelaPlacaIntGraf janela = new consultarPelaPlacaIntGraf();

    public static void main(BDVeiculos bancoDeDados) {
        bancoDeDadosVeiculos = bancoDeDados;
        int larg = 500, alt = 500;
        consultarPelaPlacaTela.setSize(larg, alt);
        consultarPelaPlacaTela.setTitle("Cadastra Passeio");
        // “EXIT_ON_CLOSE”: fecha a aplicação toda.
        consultarPelaPlacaTela.setDefaultCloseOperation(consultarPelaPlacaTela.EXIT_ON_CLOSE);

        //Set button texts
        consultarBtn.setText("Consultar");
        excluirBtn.setText("Excluir");
        sairBtn.setText("Sair");
        consultarBtn.addActionListener((ActionListener) janela);
        excluirBtn.addActionListener((ActionListener) janela);
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
        consultarPelaPlacaTela.add(qtdPassageirosTxt);
        consultarPelaPlacaTela.add(qtdPassageirosInput);
        consultarPelaPlacaTela.add(placaTxt);
        consultarPelaPlacaTela.add(placaInput);
        consultarPelaPlacaTela.add(marcaTxt);
        consultarPelaPlacaTela.add(marcaInput);
        consultarPelaPlacaTela.add(modeloTxt);
        consultarPelaPlacaTela.add(modeloInput);
        consultarPelaPlacaTela.add(corTxt);
        consultarPelaPlacaTela.add(corInput);
        consultarPelaPlacaTela.add(qtdRodasTxt);
        consultarPelaPlacaTela.add(qtdRodasInput);
        consultarPelaPlacaTela.add(velocMaxTxt);
        consultarPelaPlacaTela.add(velocMaxInput);
        consultarPelaPlacaTela.add(qtdPistoesTxt);
        consultarPelaPlacaTela.add(qtdPistoesInput);
        consultarPelaPlacaTela.add(potenciaTxt);
        consultarPelaPlacaTela.add(potenciaInput);
        consultarPelaPlacaTela.add(consultarBtn);
        consultarPelaPlacaTela.add(excluirBtn);
        consultarPelaPlacaTela.add(sairBtn);

        consultarPelaPlacaTela.setLayout(new FlowLayout());
        consultarPelaPlacaTela.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        Object objSource = evt.getSource();

        if (objSource.equals(consultarBtn)) {

        }
        else if (objSource.equals(excluirBtn)) {

        }
        else if (objSource.equals(sairBtn)) {
            System.exit(0);
        }
    }

}
