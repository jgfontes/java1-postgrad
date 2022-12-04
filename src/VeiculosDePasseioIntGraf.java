import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class VeiculosDePasseioIntGraf implements ActionListener {

    private JFrame veiculosDePasseioTela = new JFrame("Cadastra Passeio");

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
        veiculosDePasseioTela.setLayout(new GridBagLayout());
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
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        veiculosDePasseioTela.add(cadastrarBtn, c);
        c.gridx = 1;
        c.gridy = 0;
        veiculosDePasseioTela.add(cadastrarTxt, c);
        c.gridx = 0;
        c.gridy = 1;
        veiculosDePasseioTela.add(consultarBtn, c);
        c.gridx = 1;
        c.gridy = 1;
        veiculosDePasseioTela.add(consultarTxt, c);
        c.gridx = 0;
        c.gridy = 2;
        veiculosDePasseioTela.add(imprimirBtn, c);
        c.gridx = 1;
        c.gridy = 2;
        veiculosDePasseioTela.add(imprimirTxt, c);
        c.gridx = 0;
        c.gridy = 3;
        veiculosDePasseioTela.add(sairBtn, c);
        c.gridx = 1;
        c.gridy = 3;
        veiculosDePasseioTela.add(sairTxt, c);
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
