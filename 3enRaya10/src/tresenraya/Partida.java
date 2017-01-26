
package tresenraya;

import java.io.IOException;

class Partida {
    static int [] casillas = new int [9];
    static boolean fin = false;
    static void nuevaPartida() throws IOException {
        
        int [] [] tablero = new int [3][3];
        int opcion, cont=0;
        boolean victoria=false;
        
        for (int i = 0; i < 4; i++) {
            

        opcion=eliminaCasillas(cont,tablero);
        rellenaTablero(cont,opcion,tablero);
        cont++;
        imprimeMatriz(tablero);
        }
        for (int i = 4; i < 9 && victoria==false; i++) {
            
            opcion=eliminaCasillas(cont,tablero);
            rellenaTablero(cont,opcion,tablero);
            cont++;
            victoria=comprobarVictoria(tablero);
            if (victoria) {
               System.out.println("Felicidades jugador "+((cont-1)%2+1)+"! Has ganado!"); 
               fin=true;
            }            
            imprimeMatriz(tablero);
            if (i==8 && victoria==false) {
                System.out.println("\nEmpate!!!");
                
            }
        }
    }

    private static void rellenaTablero(int cont, int opcion, int[][] tablero) {
        switch (opcion) {
            case 1:
                tablero [0][0]=(int)Math.pow(-1, cont);
                break;
            case 2:
                tablero [0][1]=(int)Math.pow(-1, cont);
                break;
            case 3:
                tablero [0][2]=(int)Math.pow(-1, cont);
                break;
            case 4:
                tablero [1][0]=(int)Math.pow(-1, cont);
                break;
            case 5:
                tablero [1][1]=(int)Math.pow(-1, cont);
                break;
            case 6:
                tablero [1][2]=(int)Math.pow(-1, cont);
                break;
            case 7:
                tablero [2][0]=(int)Math.pow(-1, cont);
                break;
            case 8:
                tablero [2][1]=(int)Math.pow(-1, cont);
                break; 
            case 9:
                tablero [2][2]=(int)Math.pow(-1, cont);
                break;               
            default:
                
        }
    }

    private static void imprimeMatriz( int [][] tablero) {
        char marca;
        if (!fin){
        System.out.println("\n Así va la partida:\nRecordemos:\n    -Jugador 1: cruces\n    -Jugador 2: circulos");                
        }
        System.out.println("- - - - - - - - -");
        for (int i = 0 ; i< tablero.length ; i++) {            
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j]>0) 
                    marca = 'x';
                else if(tablero[i][j]<0)
                    marca = 'O';
                else
                    marca = ' ';
                
                System.out.print("| "+marca + "  |");
            }
            System.out.println("");
            System.out.println("- - - - - - - - -");
        }
    }
        private static void imprimeMatrizOpcionesDisponibles( int [][] tablero) {
        char marca = 0;
        
        System.out.println("- - - - - - - - -");
        for (int i = 0 ; i< tablero.length ; i++) {            
            for (int j = 0; j < tablero.length; j++) {  
                if (tablero[i][j]>0) 
                    marca = 'x';
                else if(tablero[i][j]<0)
                    marca = 'O';
                else{
                    if (i==0 && j==0) {
                    marca = '1';
                    }
                    if (i==0 && j==1) {
                    marca = '2';
                    }
                    if (i==0 && j==2) {
                    marca = '3';
                    }
                    if (i==1 && j==0) {
                    marca = '4';
                    }
                    if (i==1 && j==1) {
                    marca = '5';
                    }
                    if (i==1 && j==2) {
                    marca = '6';
                    }
                    if (i==2 && j==0) {
                    marca = '7';
                    }
                    if (i==2 && j==1) {
                    marca = '8';
                    }
                    if (i==2 && j==2) {
                    marca = '9';
                    }
                }
                
                System.out.print("| "+marca + "  |");
            }
            System.out.println("");
            System.out.println("- - - - - - - - -");
        }
    }

    private static int eliminaCasillas(int cont, int [][] tablero) throws IOException {  
        boolean bandera;
        int opcion;
        do {
            bandera = false;
            System.out.println("\n\n\nJugador "+(cont%2+1)+": es tu turno. Elige casilla");           
            imprimeMatrizOpcionesDisponibles(tablero);
             opcion = Lectura.leerEntero("");
            if (casillas[opcion-1]>0) {
                System.out.println("Error! Esa casilla ya está ocupada");
                bandera=false;
            }
            else {
                casillas[opcion-1]++;
                System.out.println("\n\n\n");
                bandera = true;
            }
            
        } while (bandera==false);
        
        return opcion;
    }

    private static boolean comprobarVictoria(int[][] tablero){
        boolean victoria=false;
            int [] suma = new int [8];
            suma[0]=tablero[0][0]+tablero[0][1]+tablero[0][2];
            suma[1]=tablero[1][0]+tablero[1][1]+tablero[1][2];
            suma[2]=tablero[2][0]+tablero[2][1]+tablero[2][2];
            suma[3]=tablero[0][0]+tablero[1][0]+tablero[2][0];
            suma[4]=tablero[0][1]+tablero[1][1]+tablero[2][1];
            suma[5]=tablero[0][2]+tablero[1][2]+tablero[2][2];
            suma[6]=tablero[0][0]+tablero[1][1]+tablero[2][2];
            suma[7]=tablero[0][2]+tablero[1][1]+tablero[2][0];

            
            for (int i = 0; i < 8 && victoria==false; i++) {
                if (suma[i]==3 || suma[i]==-3) {
                    victoria=true;
                }
            }
        return victoria;
    }

   
    
}
