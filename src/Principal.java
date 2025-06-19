import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        int opcionElegida = 0;
        double valor = 0;
        double cotizacion = 0;
        double resultado = 0;
        String resultadoRedondeado = "";

        ApiExchangeRate cargarMonedas = new ApiExchangeRate();
        MonedasRecord dataMonedas = cargarMonedas.getDataMonedas();
        Monedas monedas = new Monedas(dataMonedas);

        while (opcionElegida != 7){
            System.out.println("*");
            System.out.println("**************************************************************************************");
            System.out.println("*********** Bienvenido al Conversor de Monedas, por favor elige una opción: ***********");
            System.out.println("1) Dolar => Peso Argentino");
            System.out.println("2) Peso Argentino => Dolar");
            System.out.println("3) Dolar => Real Brasileño");
            System.out.println("4) Real Brasileño => Dolar");
            System.out.println("5) Dolar => Peso Colombiano");
            System.out.println("6) Peso Colombiano => Dolar");
            System.out.println("7) Salir");
            System.out.println("************************** Elija una opción valida: **********************************");
            System.out.println("**************************************************************************************");

            opcionElegida = Integer.parseInt(scanner.nextLine());

            switch (opcionElegida){
                case 1:
                    System.out.println("Usted selecciono la conversión de Dolar a Pesos Argentinos");
                    System.out.println("Ingrese el valor que desea convertir:");

                    valor = Double.parseDouble(scanner.nextLine());
                    cotizacion = monedas.getPesoArg();
                    resultado = monedas.usdToArg(valor);
                    resultadoRedondeado = String.format("%.2f", resultado);

                    System.out.println("*");
                    System.out.println("El valor proporcionado (" + valor + " USD) corresponde a (" + resultadoRedondeado + " ARS) a una cotización de ("
                            + cotizacion+ " ARS) por cada Dolar.");
                    break;

                case 2:
                    System.out.println("Usted selecciono la conversión de Pesos Argentinos a Dolares");
                    System.out.println("Ingrese el valor que desea convertir:");

                    valor = Double.parseDouble(scanner.nextLine());
                    cotizacion = monedas.getPesoArg();
                    resultado = monedas.argToUsd(valor);
                    resultadoRedondeado = String.format("%.2f", resultado);

                    System.out.println("*");
                    System.out.println("El valor proporcionado (" + valor + " ARS) corresponde a (" + resultadoRedondeado + " USD) a una cotización de ("
                            + cotizacion+ " ARS) por cada Dolar.");
                    break;

                case 3:
                    System.out.println("Usted selecciono la conversión de Dolar a Reales Brasileños");
                    System.out.println("Ingrese el valor que desea convertir:");

                    valor = Double.parseDouble(scanner.nextLine());
                    cotizacion = monedas.getRealBr();
                    resultado = monedas.usdToBr(valor);
                    resultadoRedondeado = String.format("%.2f", resultado);

                    System.out.println("*");
                    System.out.println("El valor proporcionado (" + valor + " USD) corresponde a (" + resultadoRedondeado
                            + " BRL) a una cotización de (" + cotizacion + " BRL) por cada Dolar.");
                    break;

                case 4:
                    System.out.println("Usted selecciono la conversión de Reales Brasileños a Dolar");
                    System.out.println("Ingrese el valor que desea convertir:");

                    valor = Double.parseDouble(scanner.nextLine());
                    cotizacion = monedas.getRealBr();
                    resultado = monedas.brToUsd(valor);
                    resultadoRedondeado = String.format("%.2f", resultado);

                    System.out.println("*");
                    System.out.println("El valor proporcionado (" + valor + " BRL) corresponde a (" + resultadoRedondeado
                            + " USD) a una cotización de (" + cotizacion + " BRL) por cada Dolar.");
                    break;

                case 5:
                    System.out.println("Usted selecciono la conversión de Dolar a Pesos Colombianos");
                    System.out.println("Ingrese el valor que desea convertir:");

                    valor = Double.parseDouble(scanner.nextLine());
                    cotizacion = monedas.getPesoCol();
                    resultado = monedas.usdToCol(valor);
                    resultadoRedondeado = String.format("%.2f", resultado);

                    System.out.println("*");
                    System.out.println("El valor proporcionado (" + valor + " USD) corresponde a (" + resultadoRedondeado
                            + " COP) a una cotización de (" + cotizacion + " COP) por cada Dolar.");
                    break;

                case 6:
                    System.out.println("Usted selecciono la conversión de Pesos Colombianos a Dolar");
                    System.out.println("Ingrese el valor que desea convertir:");

                    valor = Double.parseDouble(scanner.nextLine());
                    cotizacion = monedas.getPesoCol();
                    resultado = monedas.colToUsd(valor);
                    resultadoRedondeado = String.format("%.2f", resultado);

                    System.out.println("*");
                    System.out.println("El valor proporcionado (" + valor + " COP) corresponde a (" + resultadoRedondeado
                            + " USD) a una cotización de (" + cotizacion + " COP) por cada Dolar.");
                    break;

                case 7:
                    System.out.println("*");
                    System.out.println("Saliendo de la aplicación...");
                    break;

                default:
                    System.out.println("*");
                    System.out.println("Opción no valida, intentelo de nuevo.");
            }
        }

        System.out.println("***");
        System.out.println("**");
        System.out.println("*");
        System.out.println("****** Gracias por usar el Conversor de Monedas! ******");

        scanner.close();

    }
}
