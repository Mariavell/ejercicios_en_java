public class autolavado {

     public double descuento1 =0; 
     public double descuento2 = 0;
     public double subtotal=0;
     public double totalFinalporAuto;
     public int precioLavado;
     public double litrosConsumidos;
     public int autos;
     public double tiempoTrabajado;
     public double [] litrosPorServicio = {80,120,150};
     public double [] litrosPorAdicional = {5,10,0};
     public double [] trabajoPorServicio = {15,25,40};
     public double [] trabajoPorAdicional = {10,30,15};
     public String [] opciones = {
            "Lavado basico" ,
            "Lavado premium",
            "Lavado completo" 
        };
     public String[] serviciosAdicionales = {
            "Encerado especial",
            "Limpieza de tapiceria",
            "Pulitura de faros"
        };

      public int []precioServiciosAdicionales = {50,95,55};
      
      public boolean[] adicionalesSeleccionados = new boolean[3]; //{ false,false,false}

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

 public void calcularDescuentos(int lavadoSeleccionado, boolean[] adicionalesSeleccionados, int totalAdicionales) {
    if (lavadoSeleccionado==3)
          {
            for (boolean sel : adicionalesSeleccionados)
            {
              if (sel)
              {
          
                this.descuento1=( this.precioLavado+totalAdicionales )* 0.10;
                break; 
              }
            }
          }
          subtotal = (this.precioLavado + totalAdicionales) - descuento1 ;

          if (subtotal>250)
          {
            this.descuento2= subtotal * 0.05;
          }

          this.totalFinalporAuto = subtotal - descuento2;
}

   public void calcularConsumoyTiempo () {





   }

  
    public static void main(String[] args) {
        /**
       */
        autolavado e = new autolavado();
        java.util.Scanner sc = new java.util.Scanner(System.in);
        boolean mostrarMenu = false;

        boolean siguiente = true;
       System.out.println("Ingresa la cantidad de autos para este turno");
       e.autos = Integer.parseInt(sc.nextLine().trim());
       for (int y=0; y<e.autos;y++) {

        while (siguiente) {
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
           siguiente = false;
           sc.close();
            return;
          }
       }
     }

    if (mostrarMenu) { 
        System.out.println("\nOpciones de lavados disponibles: ");
        for (int i = 0; i < e.opciones.length; i++) { 
            System.out.printf("%d. %s%n", i+1, e.opciones[i]);
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

        e.precioLavado = e.calcularPrecioLavado(lavado);
        int totalAdicionales = 0;
        System.out.println("\nDesea agregar un serivio adicional?(S/N) ");

        for (int i = 0; i < e.serviciosAdicionales.length; i++) {
            System.out.printf("%d. %s (Precio: %d)%n", i+1, e.serviciosAdicionales[i], e.precioServiciosAdicionales[i]);
            String respuesta = sc.nextLine().trim().toUpperCase();  

            if (respuesta.equals("S")) {
                e.adicionalesSeleccionados[i] = true;
                totalAdicionales += e.precioServiciosAdicionales[i];}
            }
        e.calcularDescuentos(lavado, e.adicionalesSeleccionados, totalAdicionales);
          System.out.println("\nResumen de tu pedido:");
          System.out.println("Servicio base: " + e.opciones[lavado - 1] + " (Precio: " + e.precioLavado + ")");

          for (int i = 0; i < e.serviciosAdicionales.length; i++) {
            if (e.adicionalesSeleccionados[i]) {
                System.out.printf("Servicio adicional: %s (Precio: %d)%n", e.serviciosAdicionales[i], e.precioServiciosAdicionales[i]);
            }
          }
          System.out.printf("Subtotal: %.2f Bs%n",(double)e.precioLavado+totalAdicionales);  
          System.out.printf("Descuento por lavado completo: %.2f Bs%n", e.descuento1);
          System.out.printf("Descuento por subtotal mayor a 250 Bs: %.2f Bs%n", e.descuento2);
          System.out.printf("Total a pagar: %.2f Bs%n", e.totalFinalporAuto);
        };
      }
      }
        }
      }

    