public class autolavado_2 {

    //tipo de servicio 
    private static final int lavadoBasicoAgua = 80;
    private static final int lavadoBasicoTiempo = 15;
    private static final int lavadoPremiumAgua = 120;
    private static final int lavadoPremiumTiempo = 25;
    private static final int lavadoCompletoAgua = 150;
    private static final int lavadoCompletoTiempo = 40;

    //servicio adicional
    private static final int enceradoEspecialAgua = 5;
    private static final int enceradoEspecialTiempo = 10;
    private static final int limpiezaTapiceriaAgua = 10;
    private static final int limpiezaTapiceriaTiempo = 30;
    private static final  int pulituraFarosAgua = 0;
    private static final int pulituraFarosTiempo = 15;

    private static final String [] opciones = {
            "Lavado basico" ,
            "Lavado premium",
            "Lavado completo"  
        };
   private static final String[] serviciosAdicionales = {
            "Encerado especial",
            "Limpieza de tapiceria",
            "Pulitura de faros"
       };

   public static void main(String[] args) {
      java.util.Scanner sc = new java.util.Scanner(System.in);
      
      int totalAgua = 0;
      int totalTiempo = 0;

    System.out.println("Por favor ingresa la cantidad total de los autos deseados a atender");
    int totalAutos = sc.nextInt();
    sc.nextLine();
    
    for (int i = 1; i <= totalAutos; i++) {
        System.out.println(" Auto " + i);

        System.out.println("Ingrese el tipo de servicio base que deseas (basico,premium,completo)");
        String servicioBase = sc.nextLine().toLowerCase();

        int agua = 0;
        int tiempo = 0;

    switch (servicioBase) {
        case "basico":
            agua += lavadoBasicoAgua;
            tiempo += lavadoBasicoTiempo; 
            break;
        case "premium":
            agua += lavadoPremiumAgua;
            tiempo += lavadoPremiumTiempo; 
            break;
        case "completo":
            agua += lavadoCompletoAgua;
            tiempo += lavadoCompletoTiempo; 
            break;
        default:
            System.out.println("El servicio ingresado es inválido. Se le asignará lavado básico");
            agua += lavadoBasicoAgua;
            tiempo += lavadoBasicoTiempo;
       }
         System.out.print("¿Desea Encerado Especial? (s/n): ");
            if (sc.nextLine().equalsIgnoreCase("s")) {
                agua += enceradoEspecialAgua;
                tiempo += enceradoEspecialTiempo;
            }

            System.out.print("¿Desea Limpieza de Tapicería? (s/n): ");
            if (sc.nextLine().equalsIgnoreCase("s")) {
                agua += limpiezaTapiceriaAgua;
                tiempo += limpiezaTapiceriaTiempo;
            }

            System.out.print("¿Desea Pulitura de Faros? (s/n): ");
            if (sc.nextLine().equalsIgnoreCase("s")) {
                agua += pulituraFarosAgua;
                tiempo += pulituraFarosTiempo;
            }

            // Acumuladores
            totalAgua += agua;
            totalTiempo += tiempo;
        }

        // consumo y tiempo promedio
        double promedioAgua = (double) totalAgua / totalAutos;
        double promedioTiempo = (double) totalTiempo / totalAutos;

        
        System.out.println("\n--- Total Final ---");
        System.out.println("Total de vehículos procesados: " + totalAutos);
        System.out.println("Consumo total de agua: " + totalAgua + " litros");
        System.out.println("Tiempo total de trabajo: " + totalTiempo + " minutos");
        System.out.printf("Consumo promedio de agua por vehículo: %.2f litros%n", promedioAgua);
        System.out.printf("Tiempo promedio de trabajo por vehículo: %.2f minutos%n", promedioTiempo);
        
        sc.close(); 
}
}


    

