import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("**************************************************************************************");
        System.out.println("Bienvenido al Conversor de Monedas, por favor elige una opción:");

        Scanner scanner = new Scanner(System.in);
        int opcionElegida = Integer.parseInt(scanner.nextLine());
        double valor = 0;

        ApiExchangeRate cargarMonedas = new ApiExchangeRate();
        MonedasRecord dataMonedas = cargarMonedas.getDataMonedas();
        Monedas monedas = new Monedas(dataMonedas);

        switch (opcionElegida){
            case 1:
                System.out.println("Usted selecciono la conversión de Dolar a Pesos Argentinos");
                System.out.println("Ingrese el valor que desea convertir:");

                valor = Double.parseDouble(scanner.nextLine());
                double resultado = monedas.usdToArg(valor);

                System.out.println("El valor proporcionado ( " + valor + " USD) corresponde a ( " + resultado + " ARS)");

        }



    }
}
