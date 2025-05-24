public class ejercicio1 {
    
    public static void main(String[] args) {
        /**
     
       */
        String[] opciones = {
            "Lavado basico",
            "Lavado premium",
            "Lavado completo" 
        };
    
        java.util.Scanner sc = new java.util.Scanner(System.in);
         boolean mostrarMenu = false;

         for (int intento = 1; intento <= 3; intento++) {
         System.out.println(("¿Deseas ver nuestro menú de opciones? (S/N): "));

        String respuesta = sc.nextLine().trim().toUpperCase();

        if (respuesta.equals("S")) {
            mostrarMenu = true;
            break;
        }
         else if (respuesta.equals("N")) {
         System.out.println("Gracias por tu visita!");
         return;

        } else {
       
        System.out.println("La opción ingresada es inválida");
        if (intento == 3) {
          System.out.println("Demasiados intentos. Inténtalo más tarde");
            sc.close();
            return;
          }
       }
     }

    if (mostrarMenu) { 
 
        System.out.println("\nOpciones de lavados disponibles: ");
        for (int i = 0; i < opciones.length; i++) { 
            System.out.printf("%d. %s%n", i+1, opciones[i]);
        }
       
        System. out.print("Por favor elige una opción entre 1-3): ");
        int lavado = sc.nextInt();

        switch (lavado) {
            case 1:
              System.out.println("Seleccionaste : " + opciones [1]);
                break;

            case 2: 
              System.out.println("Seleccionaste : " + opciones [2]);
              break;
              
             case 3:
               System.out.println("Seleccionaaste : " + opciones [3]);

            default:
              System.out.println("La opción seleccionada es inválida");
                break;
        }

        }

        sc.close();
    }

}

     