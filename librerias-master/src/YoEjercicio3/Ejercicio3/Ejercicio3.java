package YoEjercicio3.Ejercicio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio3 {
private static final Scanner SCIN= new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {

        List<String> nombres=new ArrayList<>();
            Scanner sc = new Scanner(new File("Fichero/nombres.txt"));


        System.out.println("Continuación de programa");



        while (sc.hasNextLine()){
            String nombre = sc.nextLine();
            nombres.add(nombre.toLowerCase());
        }
        System.out.printf("Lista con %d nombres %s%n",nombres.size() ,nombres);
        System.out.printf("%n----------------------------------------------------------------%n");
        List<String> nombress =obtenerNombreAcabanConsonante(nombres);
        /*System.out.printf(" Lista de nombres que acaban en consonante %s%n",nombress);*/
        mostrarNombresDeLaListaAcabadosConsonantes(nombress);

        String letraa="";
      do {
          System.out.println("Dime la primera letra con la que empieza");
          letraa = SCIN.nextLine();
      }while( ! letraa.toLowerCase().matches("[a-záéíóúñ]+"));

        List<String> nombreComienzaLetra = obtenerListaEmpizaPorLetra(nombres,letraa);

        System.out.println(nombreComienzaLetra);
//----------------------------------------------------------------------------------------------------//

        System.out.println("Dime una palabra para comprobar si la contiene algun nombre del fichero");
        String palabra = SCIN.nextLine();


        boolean existe = existePalabra(nombres,palabra);

        if (existe ){
            System.out.printf(" %s, Sí se encuentra en nombres del fichero %n", palabra);
        }else {
            System.out.printf("%s, No se encuentra en nombres del fichero %n" , palabra);
        }

        System.out.println();

        //------------------------------------------------------------------------------------//

        System.out.println("Dime otra palabra para buscar y devolverte la lista de los nombres");
        String palabra2 = SCIN.nextLine();


        List<String>listaNombresP = obtenerListaQueContenganPalabra(nombres,palabra2);

        System.out.println(listaNombresP.toString());

        sc.close();

    }

    private static List<String> obtenerNombreAcabanConsonante(List<String> listas){
        List<String> nombress=new ArrayList<>();

        for (String lista:listas ) {

            if (lista.toLowerCase().matches(".*[^aeiouáéíóú]")){
                nombress.add(lista);
            }

        }
        /*System.out.println(nombress);*/

        return nombress;
    }

    private static void mostrarNombresDeLaListaAcabadosConsonantes( List<String> nombress){
        for (String nom:nombress ) {
            System.out.println(nom);

        }
    }

    private static List<String> obtenerListaEmpizaPorLetra(List<String> listas, String letraa){

        List<String> listaEmpiezaLetra= new ArrayList<>();

        for (String lista:listas ) {

            if (lista.toLowerCase().startsWith(letraa.toLowerCase())){
                listaEmpiezaLetra.add(lista);
            }

        }


        return listaEmpiezaLetra;
    }


    private static boolean existePalabra(List<String> lista , String palabra){

        return lista.contains(palabra.toLowerCase());
    }

    private static List<String> obtenerListaQueContenganPalabra(List<String> lista , String palabra2){

        List<String> contienenPalabra = new ArrayList<>();

        for (String nombre:lista ) {

            if (nombre.contains(palabra2.toLowerCase())){
                contienenPalabra.add(nombre);
            }
        }



        return contienenPalabra;
    }

}
