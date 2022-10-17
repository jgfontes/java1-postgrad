public class Teste {
    public static void main(String[] args) {
        Pai novoPai = new Pai();
        novoPai.nome = "Teste Nome";
        novoPai.idade = 37;
        novoPai.salario = 37500; 


        //nome e idade -> Public
        //Salario -> Private

        //cadPai, impPai -> Public
        //CalcSalario -> Private

        novoPai.cadPai("Teste nome", 47, 37000);
        novoPai.calcSalario();
        novoPai.impPai();
    }
}