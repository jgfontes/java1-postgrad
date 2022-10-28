import java.util.ArrayList;

public class TesteOLD {
    public static void main(String[] args) {
        ArrayList<Veiculo> veiculosArray = new ArrayList<Veiculo>();

        //Test default constructor;
        veiculosArray.add( new Carga());
        veiculosArray.add(new Passeio());
        veiculosArray.add(new Carga());
        veiculosArray.add(new Passeio());
        veiculosArray.add(new Carga(
                "LEU-4567",
                "Audi",
                "Cargavel",
                "Azul",
                100,
                8,
                new Motor(
                        8,
                        150
                ),
                8000,
                25
        ));
        veiculosArray.add(new Passeio(
                "FRX-1234",
                "Ford",
                "Ka",
                "Branco",
                200,
                4,
                new Motor(
                        6,
                        85
                ),
                5
        ));
        veiculosArray.add(new Carga(
                "LEU-5678",
                "Audi",
                "Cargavel",
                "Azul",
                100,
                8,
                new Motor(
                        8,
                        150
                ),
                8000,
                25
        ));
        veiculosArray.add(new Passeio(
                "FRX-6789",
                "Ford",
                "Ka",
                "Branco",
                200,
                4,
                new Motor(
                        6,
                        85
                ),
                5
        ));

        for (Veiculo veiculo : veiculosArray) {
            System.out.println(veiculo);
        }

        //Test using getters and setters
        Carga cargaObj5 = new Carga();
        Passeio passeioObj5 = new Passeio();

        //Testing carga setters
        cargaObj5.setPlaca("CAR-0912");
        cargaObj5.setMarca("Chevrolet");
        cargaObj5.setModelo("CargaTest");
        cargaObj5.setCor("Amarelo");
        cargaObj5.setVelocMax(100);
        cargaObj5.setQtdRodas(10);
        cargaObj5.setMotor(new Motor(
                10,
                300
        ));
        cargaObj5.setCargaMax(12000);
        cargaObj5.setTara(200);

        //Testing passeio setters
        passeioObj5.setPlaca("DEF-5678");
        passeioObj5.setMarca("Chevrolet");
        passeioObj5.setModelo("Camaro");
        passeioObj5.setCor("Amarelo");
        passeioObj5.setVelocMax(300);
        passeioObj5.setQtdRodas(4);
        passeioObj5.setMotor(new Motor(
                6,
                467
        ));
        passeioObj5.setQtdPassageiros(5);

        //Testing carga getters
        System.out.println("\nTestando getters de Carga");
        System.out.println(cargaObj5.getPlaca());
        System.out.println(cargaObj5.getMarca());
        System.out.println(cargaObj5.getModelo());
        System.out.println(cargaObj5.getCor());
        System.out.println(cargaObj5.getVelocMax());
        System.out.println(cargaObj5.getQtdRodas());
        System.out.println(cargaObj5.getMotor());
        System.out.println(cargaObj5.getCargaMax());
        System.out.println(cargaObj5.getTara());

        //Testing passeio getters
        System.out.println("\nTestando getters de Passeio");
        System.out.println(passeioObj5.getPlaca());
        System.out.println(passeioObj5.getMarca());
        System.out.println(passeioObj5.getModelo());
        System.out.println(passeioObj5.getCor());
        System.out.println(passeioObj5.getVelocMax());
        System.out.println(passeioObj5.getQtdRodas());
        System.out.println(passeioObj5.getMotor());
        System.out.println(passeioObj5.getQtdPassageiros());
    }
}
