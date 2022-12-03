import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ImprimirTodosPasseioIntGraf implements ActionListener {

    private JFrame imprimeTodosPasseioTela = new JFrame();
    private BDVeiculos bancoDeDadosVeiculos = gestaoDeVeiculosIntGraf.bancoDeDadosVeiculos;

    //Declare Buttons
    private JButton imprimirTodosBtn = new JButton();
    private JButton excluirTodosBtn = new JButton();
    private JButton sairBtn = new JButton();
    //Declare Table
    private String[] colunas = {"Placa", "Marca", "Modelo", "Cor", "Qtd. Rodas", "Veoc. Max", "Qtd. Pistões", "Potência", "QtdPassageiros"};
    private DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
    private JTable tabelaDados = new JTable(modelo);
    private JScrollPane barraRolagemLista = new JScrollPane(tabelaDados);

    public void carregarJanela() {
        imprimeTodosPasseioTela.setSize(700, 500);
        imprimeTodosPasseioTela.setTitle("Cadastra Passeio");
        barraRolagemLista.setPreferredSize(new Dimension(650,400));
        // “EXIT_ON_CLOSE”: fecha a aplicação toda.
        imprimeTodosPasseioTela.setDefaultCloseOperation(imprimeTodosPasseioTela.EXIT_ON_CLOSE);

        imprimirTodosBtn.setText("Imprimir Todos");
        excluirTodosBtn.setText("Excluir Todos");
        sairBtn.setText("Sair");
        imprimirTodosBtn.addActionListener(this);
        excluirTodosBtn.addActionListener(this);
        sairBtn.addActionListener(this);

        imprimeTodosPasseioTela.add(barraRolagemLista);
        imprimeTodosPasseioTela.add(imprimirTodosBtn);
        imprimeTodosPasseioTela.add(excluirTodosBtn);
        imprimeTodosPasseioTela.add(sairBtn);

        imprimeTodosPasseioTela.setLayout(new FlowLayout());
        imprimeTodosPasseioTela.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object objSource = e.getSource();

        if (objSource.equals(imprimirTodosBtn)) {
            imprimeDadosPasseio();
        } else if (objSource.equals(excluirTodosBtn)) {
            excluiDadosPasseio();
        } else if(objSource.equals(sairBtn)) {
            imprimeTodosPasseioTela.dispose();
        }
    }

    public void imprimeDadosPasseio() {
        if(bancoDeDadosVeiculos.getPasseioArray().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Não há Veículos Passeio cadastrados." , "ERRO",  JOptionPane.ERROR_MESSAGE);
        } else {
            modelo = new DefaultTableModel(colunas,0);

            for (Veiculo passeioElemento : bancoDeDadosVeiculos.getPasseioArray()) {
                String[] dados = {
                        passeioElemento.getPlaca(),
                        passeioElemento.getMarca(),
                        passeioElemento.getModelo(),
                        passeioElemento.getCor(),
                        Integer.toString(passeioElemento.getQtdRodas()),
                        Float.toString(passeioElemento.getVelocMax()),
                        Integer.toString(passeioElemento.getMotor().getPotencia()),
                        Integer.toString(((Passeio) passeioElemento).getQtdPassageiros())
                };
                modelo.addRow(dados);
            }
            tabelaDados.setModel(modelo);
        }
    }

    public void excluiDadosPasseio() {
        if(bancoDeDadosVeiculos.getPasseioArray().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Não há Veículos Passeio a serem excluídos." , "ERRO",  JOptionPane.ERROR_MESSAGE);
        } else {
            bancoDeDadosVeiculos.excluiTodosPasseio();
            JOptionPane.showMessageDialog(null,"Veículos excluídos com sucesso!" , "SUCESSO",  JOptionPane.INFORMATION_MESSAGE);
            modelo = new DefaultTableModel(colunas,0);
            tabelaDados.setModel(modelo);
        }
    }
}
