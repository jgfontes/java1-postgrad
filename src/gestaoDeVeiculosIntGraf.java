import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gestaoDeVeiculosIntGraf implements ActionListener {

    private static JFrame gestaoDeVeiculosTela = new JFrame("Cadastra Passeio");
    static gestaoDeVeiculosIntGraf janela = new gestaoDeVeiculosIntGraf();
    static BDVeiculos bancoDeDadosVeiculos;

    //Declare Buttons
    private static JButton passeioBtn = new JButton();
    private static JButton cargaBtn = new JButton();

    public static void main(BDVeiculos bancoDeDados) {
        bancoDeDadosVeiculos = bancoDeDados;
        int larg = 500, alt = 500;
        gestaoDeVeiculosTela.setSize(larg, alt);
        gestaoDeVeiculosTela.setTitle("Cadastra Passeio");
        // “EXIT_ON_CLOSE”: fecha a aplicação toda.
        gestaoDeVeiculosTela.setDefaultCloseOperation(gestaoDeVeiculosTela.EXIT_ON_CLOSE);

        //Set button configuration
        passeioBtn.setText("PASSEIO");
        cargaBtn.setText("CARGA");
        passeioBtn.addActionListener(janela);
        cargaBtn.addActionListener(janela);

        //Add buttons into the window and let it visible
        gestaoDeVeiculosTela.add(passeioBtn);
        gestaoDeVeiculosTela.add(cargaBtn);

        gestaoDeVeiculosTela.setLayout(new FlowLayout());
        gestaoDeVeiculosTela.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent evt) {
        Object objSource = evt.getSource();

        if (objSource.equals(passeioBtn)) {
            veiculosDePasseioIntGraf.main(bancoDeDadosVeiculos);
        } else if (objSource.equals(cargaBtn)) {
            veiculosDeCargaIntGraf.main(bancoDeDadosVeiculos);
        }
    }
}
