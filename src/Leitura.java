import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leitura {

    public String entDados(String mostrarMensagem) {
        System.out.println(mostrarMensagem);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in) );
        String userInput = "";

        try {
            userInput = reader.readLine();
        } catch (IOException e) {
            System.out.println("Erro do sistema na leitura de dados");
            e.printStackTrace();
        }

        return userInput;
    }
}
