import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class veiculosDeCargaIntGraf implements ActionListener {

    private static JFrame gestaoDeVeiculosTela = new JFrame("Cadastra Carga");
    static veiculosDeCargaIntGraf janela = new veiculosDeCargaIntGraf();
    static BDVeiculos bancoDeDadosVeiculos;

    //Declare text fields
    private static JLabel cadastrarTxt = new JLabel("cadastrarTxt");
    private static JLabel consultarTxt = new JLabel("consultarTxt");
    private static JLabel imprimirTxt = new JLabel("imprimirTxt");
    private static JLabel sairTxt = new JLabel("sairTxt");

    //Declare Buttons
    private static JButton cadastrarBtn = new JButton();
    private static JButton consultarBtn = new JButton();
    private static JButton imprimirBtn = new JButton();
    private static JButton sairBtn = new JButton();

    public static void main(BDVeiculos bancoDeDados) {
        bancoDeDadosVeiculos = bancoDeDados;
        int larg = 500, alt = 500;
        gestaoDeVeiculosTela.setSize(larg, alt);
        gestaoDeVeiculosTela.setTitle("Veiculos de Carga");
        // “EXIT_ON_CLOSE”: fecha a aplicação toda.
        gestaoDeVeiculosTela.setDefaultCloseOperation(gestaoDeVeiculosTela.EXIT_ON_CLOSE);

        //Set text fields configuration
        cadastrarTxt.setText("Cadastrar");
        consultarTxt.setText("Consultar / Excluir pela placa");
        imprimirTxt.setText("Imprimir / Excluir todos");
        sairTxt.setText("Sair");

        //Set button configuration
        cadastrarBtn.setText("1");
        consultarBtn.setText("2");
        imprimirBtn.setText("3");
        sairBtn.setText("4");
        cadastrarBtn.addActionListener(janela);
        consultarBtn.addActionListener(janela);
        imprimirBtn.addActionListener(janela);
        sairBtn.addActionListener(janela);

        //Add buttons into the window and let it visible
        gestaoDeVeiculosTela.add(cadastrarBtn);
        gestaoDeVeiculosTela.add(cadastrarTxt);
        gestaoDeVeiculosTela.add(consultarBtn);
        gestaoDeVeiculosTela.add(consultarTxt);
        gestaoDeVeiculosTela.add(imprimirBtn);
        gestaoDeVeiculosTela.add(imprimirTxt);
        gestaoDeVeiculosTela.add(sairBtn);
        gestaoDeVeiculosTela.add(sairTxt);

        gestaoDeVeiculosTela.setLayout(new FlowLayout());
        gestaoDeVeiculosTela.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object objSource = evt.getSource();

        if(objSource.equals(cadastrarBtn)) {
            cadastraCargaIntGraf.main(bancoDeDadosVeiculos);
        } else if(objSource.equals(consultarBtn)) {
            consultarPelaPlacaIntGraf.main(bancoDeDadosVeiculos);
        } else if(objSource.equals(imprimirBtn)) {

        } else if(objSource.equals(sairBtn)) {

        }

    }
}
