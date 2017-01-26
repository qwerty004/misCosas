package tresenraya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lectura {
     static  InputStreamReader flujo=new InputStreamReader(System.in);
    static  BufferedReader teclado=new BufferedReader(flujo);

    public static String leerString(String texto){
        try{
            System.out.println(texto);
            texto= teclado.readLine();
        }catch(IOException e){
            System.out.println("error I/O");
        }
        catch(Exception e){
            System.out.println("error genérico");
        }
        return texto;
    }
    
    public static byte leerByte(String texto) throws IOException{
        byte numero = 0;
        System.out.println(texto);
            boolean bandera;
        do {
            bandera=true;        
         try {
             numero= Byte.parseByte(teclado.readLine());
         } catch ( NumberFormatException e) {
             System.out.println("ERROR! Formato erróneo. Introduzca de nuevo");
             bandera=false;
         }     
         } while (bandera==false);
        return numero;
    }
    
    public static int leerEntero(String texto) throws IOException {
       int numero = 0;   
               System.out.println(texto);
       boolean bandera;
        do {
            bandera=true;        
         try {
             numero= Integer.parseInt(teclado.readLine());
         } catch ( NumberFormatException e) {
             System.out.println("ERROR! Formato erróneo. Introduzca de nuevo");
             bandera=false;
         }     
         } while (bandera==false);
        return numero;
    }
    public static float leerFloat(String texto) throws IOException{
        float numero = 0;   
    
        System.out.println(texto);
        boolean bandera;
        do {
            bandera=true;        
         try {
             numero= Float.parseFloat(teclado.readLine());
         } catch ( NumberFormatException e) {
             System.out.println("ERROR! Formato erróneo. Introduzca de nuevo");
             bandera=false;
         }     
         } while (bandera==false);
        return numero;

    }
    public static double leerDouble(String texto) throws IOException{
        double numero = 0;
                System.out.println(texto);
            boolean bandera;
        do {
            bandera=true;        
         try {
             numero= Double.parseDouble(teclado.readLine());
         } catch ( NumberFormatException e) {
             System.out.println("ERROR! Formato erróneo. Introduzca de nuevo");
             bandera=false;
         }     
         } while (bandera==false);
        return numero;
    }    
}