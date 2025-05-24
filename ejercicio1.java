public class ejercicio1 {
    

  public int calcularPrecioLavado(int opcion) {
    int precio = 0;
    switch (opcion) {
        case 1:
            precio = 100; 
            break;
        case 2:
            precio = 120; 
            break;
        case 3:
            precio = 200; 
            break;
        default:
            System.out.println("Opción inválida");
            break;
    }
    return precio;
}



    public static void main(String[] args) {
        /**
     
       */
       double descuento1 =0;
       double descuento2 = 0;
       double subtotal=0;
       double totalFinal;
        String [] opciones = {
            "Lavado basico" ,
            "Lavado premium",
            "Lavado completo" 
        };
        String[] serviciosAdicionales = {
            "Encerado especial",
            "Limpieza de tapiceria",
            "Pulitura de faros"
        };

        int []precioServiciosAdicionales = {50,95,55};

        boolean[] adicionalesSeleccionados = new boolean[3]; 
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

      ejercicio1 e = new ejercicio1();
 
        System.out.println("\nOpciones de lavados disponibles: ");
        for (int i = 0; i < opciones.length; i++) { 
            System.out.printf("%d. %s%n", i+1, opciones[i]);
        }
       
        System. out.print("Por favor elige una opción entre 1-3): ");
        int lavado = sc.nextInt();
        sc.nextLine();

        if (lavado < 1 || lavado >3)
        {
            System.out.println("Opción inválida. Por favor, elige una opción entre 1-3.");
            sc.close();
            return;
        }

        int precioLavado = e.calcularPrecioLavado(lavado);
        int totalAdicionales = 0;
        System.out.println("\nDesea agregar un serivio adicional?(S/N) ");

        for (int i = 0; i < serviciosAdicionales.length; i++) {
            System.out.printf("%d. %s (Precio: %d)%n", i+1, serviciosAdicionales[i], precioServiciosAdicionales[i]);
            String respuesta = sc.nextLine().trim().toUpperCase();  

            if (respuesta.equals("S")) {
                adicionalesSeleccionados[i] = true;
                totalAdicionales += precioServiciosAdicionales[i];}
            }
        
          if (lavado==3)
          {
            for (boolean sel : adicionalesSeleccionados)
            {
              if (sel)
              {

                descuento1=( precioLavado+totalAdicionales )* 0.10;
                break; 
              }


            }

          }
          subtotal = (precioLavado + totalAdicionales) - descuento1 ;


          if (subtotal>250)
          {
            descuento2= subtotal * 0.05;
          }

          totalFinal = subtotal - descuento2;

          System.out.println("\nResumen de tu pedido:");
          System.out.println("Servicio base: " + opciones[lavado - 1] + " (Precio: " + precioLavado + ")");

          for (int i = 0; i < serviciosAdicionales.length; i++) {
            if (adicionalesSeleccionados[i]) {
                System.out.printf("Servicio adicional: %s (Precio: %d)%n", serviciosAdicionales[i], precioServiciosAdicionales[i]);
            }

      
          }

          System.out.printf("Subtotal: %.2f Bs%n",(double)precioLavado+totalAdicionales);  
          System.out.printf("Descuento por lavado completo: %.2f Bs%n", descuento1);
          System.out.printf("Descuento por subtotal mayor a 250 Bs: %.2f Bs%n", descuento2);
          System.out.printf("Total a pagar: %.2f Bs%n", totalFinal);


        
            
        };
    





      





        }

      

  



      }

      

      

   




  



     