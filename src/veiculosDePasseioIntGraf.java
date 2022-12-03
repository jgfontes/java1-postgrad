import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class VeiculosDePasseioIntGraf implements ActionListener {

    private static JFrame veiculosDePasseioTela = new JFrame("Cadastra Passeio");

    //Declare text fields
    private JLabel cadastrarTxt = new JLabel("cadastrarTxt");
    private JLabel consultarTxt = new JLabel("consultarTxt");
    private JLabel imprimirTxt = new JLabel("imprimirTxt");
    private JLabel sairTxt = new JLabel("sairTxt");

    //Declare Buttons
    private JButton cadastrarBtn = new JButton();
    private JButton consultarBtn = new JButton();
    private JButton imprimirBtn = new JButton();
    private JButton sairBtn = new JButton();

    public void carregarTela() {
        int larg = 500, alt = 500;
        veiculosDePasseioTela.setSize(larg, alt);
        veiculosDePasseioTela.setTitle("Veiculos de Passeio");
        // “EXIT_ON_CLOSE”: fecha a aplicação toda.
        veiculosDePasseioTela.setDefaultCloseOperation(veiculosDePasseioTela.EXIT_ON_CLOSE);

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
        cadastrarBtn.addActionListener(this);
        consultarBtn.addActionListener(this);
        imprimirBtn.addActionListener(this);
        sairBtn.addActionListener(this);

        //Add buttons into the window and let it visible
        veiculosDePasseioTela.add(cadastrarBtn);
        veiculosDePasseioTela.add(cadastrarTxt);
        veiculosDePasseioTela.add(consultarBtn);
        veiculosDePasseioTela.add(consultarTxt);
        veiculosDePasseioTela.add(imprimirBtn);
        veiculosDePasseioTela.add(imprimirTxt);
        veiculosDePasseioTela.add(sairBtn);
        veiculosDePasseioTela.add(sairTxt);

        veiculosDePasseioTela.setLayout(new FlowLayout());
        veiculosDePasseioTela.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object objSource = evt.getSource();

        if(objSource.equals(cadastrarBtn)) {
            CadastraPasseioIntGraf cadastraPasseioIntGraf = new CadastraPasseioIntGraf();
            cadastraPasseioIntGraf.carregarJanela();
        } else if(objSource.equals(consultarBtn)) {
            ConsultarPasseioPelaPlacaIntGraf consultarPasseioPelaPlacaIntGraf = new ConsultarPasseioPelaPlacaIntGraf();
            consultarPasseioPelaPlacaIntGraf.carregarJanela();
        } else if(objSource.equals(imprimirBtn)) {
            ImprimirTodosPasseioIntGraf imprimirTodosPasseioIntGraf = new ImprimirTodosPasseioIntGraf();
            imprimirTodosPasseioIntGraf.carregarJanela();
        } else if(objSource.equals(sairBtn)) {
            veiculosDePasseioTela.dispose();
        }

    }
}
