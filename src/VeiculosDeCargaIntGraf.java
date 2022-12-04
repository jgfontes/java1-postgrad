import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class VeiculosDeCargaIntGraf implements ActionListener {

    private JFrame veiculosDeCargaTela = new JFrame("Cadastra Carga");

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
        veiculosDeCargaTela.setLayout(new GridBagLayout());
        veiculosDeCargaTela.setSize(500, 500);
        veiculosDeCargaTela.setTitle("Veiculos de Carga");
        // “EXIT_ON_CLOSE”: fecha a aplicação toda.
        veiculosDeCargaTela.setDefaultCloseOperation(veiculosDeCargaTela.EXIT_ON_CLOSE);

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
        veiculosDeCargaTela.add(cadastrarBtn, c);
        c.gridx = 1;
        c.gridy = 0;
        veiculosDeCargaTela.add(cadastrarTxt, c);
        c.gridx = 0;
        c.gridy = 1;
        veiculosDeCargaTela.add(consultarBtn, c);
        c.gridx = 1;
        c.gridy = 1;
        veiculosDeCargaTela.add(consultarTxt, c);
        c.gridx = 0;
        c.gridy = 2;
        veiculosDeCargaTela.add(imprimirBtn, c);
        c.gridx = 1;
        c.gridy = 2;
        veiculosDeCargaTela.add(imprimirTxt, c);
        c.gridx = 0;
        c.gridy = 3;
        veiculosDeCargaTela.add(sairBtn, c);
        c.gridx = 1;
        c.gridy = 3;
        veiculosDeCargaTela.add(sairTxt, c);
        veiculosDeCargaTela.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object objSource = evt.getSource();

        if(objSource.equals(cadastrarBtn)) {
            CadastraCargaIntGraf cadastraCargaIntGraf = new CadastraCargaIntGraf();
            cadastraCargaIntGraf.carregarTela();
        } else if(objSource.equals(consultarBtn)) {
            ConsultarCargaPelaPlacaIntGraf consultarCargaPelaPlacaIntGraf = new ConsultarCargaPelaPlacaIntGraf();
            consultarCargaPelaPlacaIntGraf.carregarJanela();
        } else if(objSource.equals(imprimirBtn)) {
            ImprimirTodosCargaIntGraf imprimirTodosCargaIntGraf = new ImprimirTodosCargaIntGraf();
            imprimirTodosCargaIntGraf.carregarJanela();
        } else if(objSource.equals(sairBtn)) {
            veiculosDeCargaTela.dispose();
        }

    }
}
