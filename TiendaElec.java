
package tiendaelec;
import java.util.Scanner;
import java.util.Random;
import java.time.LocalTime;
import java.time.LocalDate;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TiendaElec {
public static void main(String[] args) {

Scanner teclado = new Scanner (System.in);
Random aleatorio = new Random ();

//Valor Estandar de los productos

double valoraudifonos = 80000;
double valormouse = 60000;
double valorteclado = 100000;

//Defino las constantes de cantidad que se van a sumar +1 cada vez q presione su opcion
int cantAudi= 0;
int cantMouse = 0;
int cantTeclado = 0;
        
String continuar = "Tienda";

while (continuar.equalsIgnoreCase ("Tienda")){
    //CREAR MENU
    
   System.out.println("===============================================");
   System.out.println ("Tienda Elec Cortes");
   System.out.println ("===============================================");
   System.out.println ("1. Audifonos - $80.000");
   System.out.println();
   System.out.println("2. Mouse Inalambrico - $60.000");
   System.out.println();
   System.out.println("3. Teclado - $100.000");
   System.out.println ("===============================================");
   
   
   //El usuario selecciona que objeto u objetos comprar por teclado
   System.out.println("USUARIO SELECCIONE QUE ARTICULO COMPRAR (1-3)");
   int opcion = teclado.nextInt();

   
   boolean opcionValida = false;
   if (opcion==1){
       cantAudi = cantAudi + 1;
       opcionValida = true;
       
   }
   
   if (opcion==2){
       cantMouse = cantMouse + 1;
       opcionValida = true;
   }
   if (opcion==3){
       cantTeclado = cantTeclado + 1;
       opcionValida = true;
       
   }
   
   //Agrego mensajes segun la opcion sea verdadera o falsa
   if (opcionValida==false){
       System.out.println("OPCION INVALIDA. LA SELECCION DE ARTICULOS ES DEL 1 AL 3");
   }
   if (opcionValida==true){
       System.out.println("+Articulo agregado con exito al carro!!!");
   }    
   //El sistema le hace una pregunta al usuario para continuar con la compra
   System.out.println("USUARIO DESEA REALIZAR OTRA COMPRA: (Escribe Tienda para continuar / otra palabra para salir");
   continuar = teclado.next();
   System.out.println();
   }
   //Generacion del numero de referencia
   int referencia = 100000 + aleatorio.nextInt(9000000);

   //Calculos para facturacion de la compra
   
   double totalAudi= (cantAudi)*(valoraudifonos);
   double totalMouse = (cantMouse)*(valormouse);
   double totalTeclado = (cantTeclado)*(valorteclado);
   double valortotal = totalAudi +totalMouse +totalTeclado;
   
   //Creacion de la factura
   
   System.out.println("===============================================");
   System.out.println("              FACTURA DE COMPRA            ");
   System.out.println("===============================================");
   System.out.println("Numero unico de la factura:   "  + referencia);
   System.out.println("===============================================");
   
   if (cantAudi >0){
       System.out.println("Producto: Audifonos");
       System.out.println ("Cantidad comprada:  "  + cantAudi);
       System.out.println("Precio unitario:  "  + valoraudifonos);
       System.out.println("Total por producto:  " + totalAudi);
       }
   
   if (cantMouse>0){
       System.out.println("Producto: Mouse Inalambrico");
       System.out.println("Cantidad comprada:  "  + cantMouse);
       System.out.println("Valor Unitario:  "  + valormouse);
       System.out.println("Total por producto:  "  + totalMouse);
       }
   if (cantTeclado>0){
       System.out.println("Producto: Teclado");
       System.out.println("Cantidad comprada:  " + cantTeclado);
       System.out.println("Valor Unitario:  "  + valorteclado);
       System.out.println("Total por producto:  " + totalTeclado);
       }
   if (valortotal ==0){
    System.out.println("No se registraron articulos en esta compra");
    System.out.println("----------------------------------------------");
       }
   System.out.println("VALOR TOTAL DE LA COMPRA:  " +valortotal);
   System.out.println("===============================================");
   System.out.println("GRACIAS POR SU COMPRA EN LA TIENDA ELEC CORTES!!!!!");
   System.out.println("===============================================");
   
   //CREO LAS VARIABLES DE HORA Y TIEMPO PARA AGREGARLAS EN MI RESPALDO TXT
   LocalDate fecha = LocalDate.now();
   LocalTime hora = LocalTime.now();
   
   //Creo mi archivo txt usando la variable try
   try {
   FileWriter fw = new FileWriter ("C:\\Users\\Janus\\OneDrive\\Desktop\\Prueba4.txt");
   BufferedWriter bw = new BufferedWriter (fw);
   bw.write("===================================\n");
   bw.write("          FACTURA DE COMPRA      " + "\n");
   bw.write("===================================\n");
   bw.write("Numero de factura:  " + referencia + "\n");
   bw.write("===================================\n");
   bw.write("Fecha capturada:  " + fecha + "\n");
   bw.write("Hora capturada:  "  + hora + "\n");
   bw.write("===================================\n");
   
   bw.write ("Audifonos: Cantidad  " + cantAudi + " Valor total  " + totalAudi +"\n");
   bw.write ("Mouse: Cantidad  " + cantMouse + " Valor total  " + totalMouse + "\n");
   bw.write ("Teclado: Cantidad  " + cantTeclado + " Valor total  " + totalTeclado + "\n");
   
   bw.write("===================================\n");
   bw.write("TOTAL GENERAL DE LA COMPRA:  $" + valortotal +"\n");
   bw.write ("=================================\n");
   bw.write("GRACIAS POR COMPRAR EN LA TIENDA ELEC CORTES" +"\n");
   bw.write("==================================");
   bw.close();
   fw.close();
   }
   
   catch (IOException error){
       System.out.println("ALERTA VERIFICAR RESPALDO"  + error.getMessage());
       teclado.close();
   } 
   }
   }
