
package teatro_moro_sumativa3;
import java.util.ArrayList;
import java.util.Scanner;

public class Teatro_moro_sumativa3 {
static ArrayList<Entradas> Listaboletos = new ArrayList<>();
static ArrayList<Double> descuentos = new ArrayList<>();

public static void comprarentrada(){
    Scanner teclado = new Scanner(System.in);
    while(true){
    int edad = 0, vip = 0, plateaalta = 0, palcos = 0, preciobase = 0, total = 0;
    String edades, categoria, pagar, ubicacion = null;
    double descuento = 0;

    System.out.println("    Entradas   -     Tarifas ");
    System.out.println("|  Categorias  |  Valor Entrada  |");
    System.out.println("|     Vip      |     $25.000     |");
    System.out.println("| Platea alta  |     $11.000     |");
    System.out.println("|    Palcos    |     $7.200      |");
    System.out.println("");
    System.out.println("Por favor ingresar su edad:");
        do {
            edad = teclado.nextInt();
            if (edad < 5 || edad > 100) {
                System.out.println("edad incorrecta");
            }
        } while (edad < 5 || edad > 100);

        if (edad < 18) {
            edades = "Estudiante";
        } else if (edad >= 60) {
            edades = "Tercera Edad";
        } else {
            edades = "General";
        }
        System.out.println("Su edad califica como ! " + edades + " ! ");
        System.out.println("");

      if (edades.equalsIgnoreCase("Estudiante")) {
        descuento = descuentos.get(0); 
    } else if (edades.equalsIgnoreCase("Tercera Edad")) {
        descuento = descuentos.get(1); 
    } else {
        descuento = 0;
    }
        System.out.println("");
        System.out.println("Que categoria necesitas?");
        System.out.println("- Vip");
        System.out.println("- Platea alta");
        System.out.println("- Palcos");
        teclado.nextLine();
        do {
            categoria = teclado.nextLine().toLowerCase();
            System.out.println("");
            switch (categoria) {
                case "vip":
                    vip = 25000;
                    total = (total + vip);
                    ubicacion = "Vip";
                    preciobase = 25000;
                    break;
                case "platea alta":
                    plateaalta = 11000;
                    total = (total + plateaalta);
                    ubicacion = "Platea alta";
                    preciobase = 11000;
                    break;
                case "palcos":
                    palcos = 7200;
                    total = (total + palcos);
                    ubicacion = "Palcos";
                    preciobase = 7200;
                    break;
                default:
                    System.out.println("Categoria invalida.");
                    break;
            }
        } while (!categoria.equalsIgnoreCase("vip") && !categoria.equalsIgnoreCase("platea alta") && !categoria.equalsIgnoreCase("palcos"));
        Listaboletos.add(new Entradas(edad, ubicacion, preciobase, descuento, preciobase));
        menuopciones();
        break;
                }
                            }

public static void generarboleta() {
    Scanner teclado = new Scanner(System.in);

    if (!Listaboletos.isEmpty()) {
        System.out.println("Seleccione el numero de boleto que desea generar:");
        for (int i = 0; i < Listaboletos.size(); i++) {
            System.out.println((i + 1) + "- " + Listaboletos.get(i).toString());
        }

        int numeroBoleto = teclado.nextInt();
        teclado.nextLine();

        if (numeroBoleto >= 1 && numeroBoleto <= Listaboletos.size()) {
            Entradas boleto = Listaboletos.get(numeroBoleto - 1);
            double precioBase = boleto.getpreciobase();
            double descuento = boleto.getdescuento() / 100;
            double montoDescuento = descuento * precioBase;
            double precioFinal = precioBase - montoDescuento;

            System.out.println("------------------------------------");
            System.out.println("            Teatro Moro             ");
            System.out.println("------------------------------------");
            System.out.println("Ubicacion del asiento: " + boleto.getubicacion());
            System.out.println("Precio base de la entrada: $" + precioBase);
            System.out.println("Descuento aplicado: " + boleto.getdescuento() + "%");
            System.out.println("Precio final a pagar: $" + precioFinal);
            System.out.println("------------------------------------");
            System.out.println("!Gracias por la visita al teatro moro!");
            System.out.println("------------------------------------");
            System.out.println("");
        } else {
            System.out.println("Número de boleto no valido.");
            System.out.println("");
        }
    } else {
        System.out.println("No se ha realizado ninguna compra.");
        System.out.println("");
    }
    menuopciones();
}

public static void modificarboleto() {
    Scanner teclado = new Scanner(System.in);

    if (!Listaboletos.isEmpty()) {
        System.out.println("Lista de boletos:");
        for (int i = 0; i < Listaboletos.size(); i++) {
            System.out.println((i + 1) + "- " + Listaboletos.get(i).toString());
        }

        System.out.println("Ingrese el numero de boleto que desea modificar:");
        int numeroBoleto = teclado.nextInt();
        teclado.nextLine();

        if (numeroBoleto >= 1 && numeroBoleto <= Listaboletos.size()) {
            Entradas boleto = Listaboletos.get(numeroBoleto - 1);

            System.out.println("Ingrese la nueva ubicacion del asiento:");
            String nuevaUbicacion = teclado.nextLine();
            boleto.setUbicacion(nuevaUbicacion);

            System.out.println("Ingrese el nuevo precio base:");
            int nuevoPrecioBase = teclado.nextInt();
            teclado.nextLine();
            boleto.setPreciobase(nuevoPrecioBase);

            System.out.println("Ingrese el nuevo descuento:");
            double nuevoDescuento = teclado.nextDouble();
            teclado.nextLine();
            boleto.setDescuento(nuevoDescuento);
            boleto.calcularPrecioFinal();

            System.out.println("Boleto modificado exitosamente:");
            System.out.println(boleto.toString());
            System.out.println("");
        } else {
            System.out.println("Número de boleto no válido.");
            System.out.println("");
        }
    } else {
        System.out.println("No hay boletos para modificar.");
        System.out.println("");
    }

    menuopciones();
}
public static void eliminarboleto() {
    Scanner teclado = new Scanner(System.in);

    if (!Listaboletos.isEmpty()) {
        System.out.println("Lista de boletos:");
        for (int i = 0; i < Listaboletos.size(); i++) {
            System.out.println((i + 1) + "- " + Listaboletos.get(i).toString());
        }

        System.out.println("Ingrese el numero de boleto que desea eliminar:");
        int numeroBoleto = teclado.nextInt();
        teclado.nextLine();

        if (numeroBoleto >= 1 && numeroBoleto <= Listaboletos.size()) {
            Listaboletos.remove(numeroBoleto - 1);
            System.out.println("Boleto eliminado exitosamente.");
            System.out.println("");
        } else {
            System.out.println("Numero de boleto no valido.");
            System.out.println("");
        }
    } else {
        System.out.println("No hay boletos para eliminar.");
        System.out.println("");
    }

    menuopciones();
}
public static void menuopciones(){
    Scanner Teclado =new Scanner(System.in);
    int opciones;
    do{
    System.out.println("1- Comprar Entradas");
    System.out.println("2- Generar Boleto");
    System.out.println("3- Modificar boleto");
    System.out.println("4- Eliminar boleto");
    System.out.println("5- Salir");
    opciones=Teclado.nextInt();
    Teclado.nextLine();
    switch (opciones){
        case 1:
            comprarentrada();
            break;
        case 2:
            generarboleta();
            break;
        case 3:
            modificarboleto();
            break;
        case 4:
            eliminarboleto();
            break;
        case 5:
            System.out.println("Gracias por tu visitar al teatro moro");
            break;
            
        default:
            System.out.println("Opcion no valida");
            System.out.println("");
            break;
    
    }
    } while (opciones<1||opciones>5);
                                }

    public static void main(String[] args) {
        System.out.println("Bienvenido al teatro moro");
        System.out.println("");
        descuentos.add(10.0);
        descuentos.add(15.0);
        menuopciones();
    }
    
}
