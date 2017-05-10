/* Fabio Andres Aguirre Orozco
Cel:3135933672
E-mail: fabio.aguirre@udea.edu.co
Estudiante Ing. Electronica semestre 10
algoritmo para proceso de Selección PSL
2017
*/

package impresorlcd2;
import java.util.Scanner;
/*
Objetivo: Crear un programa que imprime números en estilo de una pantalla LCD
Entrada: La entrada contiene varias líneas. Cada línea contiene 2 números separados por coma. 
El primer número representa el tamaño de la impresión (entre 1 y 10, esta variable se llama “size”). 
El segundo número es el número a mostrar en la pantalla. Para terminar, se debe digitar 0,0. Esto terminará la aplicación.
Salida: Imprimir los números especificados usando el caracter “-“ para los caracteres horizontales,
y “|” para los verticales. Cada dígito debe ocupar exactamente size+2 columnas y 2*size + 3 filas.
Entre cada impresión debe haber una línea blanca.
*/

/*
El algoritmo funciona a la perfección, aunque se le pueden hacer varias mejoras, como el uso de excepciones, interfaz gráfica,
utilizar Programacion orientada a objetos de una manera eficiente, aumentar las funciones. Estas opciones no se realizaron, 
por cuestiones de tiempo. 
El algoritmo está comentado, y realiza perfectamente lo que se pide
*/
public class ImpresorLCD2 {
    private static String[ ][ ]   matriz;                   //espacio donde se guardan los numeros LCD y se mostrarán al usuario
    public static String fondo = " ";                      //llena la matriz en la que se imprimen los numeros LCD
    public static String barra = "|";                      //imprime en la matriz las "|" de los numeros LCD
    public static String guion = "_";                      //imprime en la matriz los "_" de los numeros LCD                      
    public static int col;                                 //posicion de la columna de la matriz donde se ingresan los numeros LCD 
    public static int fila;                                //posicion de la fila de la matriz donde se ingresan los numeros LCD 
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);                           
        int tam = 0;
        String final_palabra = " ";
        String[ ]   palabra = new  String[100];             //Cadena de String de tamaño 100, aquí se guardan
                                                            //todos los numeros separados por "," ingresados por usuario
        String[ ]   numeroArray = new  String[2];           //Vector de 2 posiciones que elimina la "," del ultimo numero ingresado 
                                                            //y lo divide en 2 posiciones: size y numero a mostrar en String. 
        String num = " ";
        
        boolean salir = false;                              //Variable bouleana que me dice cuando termina el programa;                                                    //Solamente se coloca true cuando el usuario ingresa "0,0"    
        
        
        do{                                                 //En este ciclo, se reciben cada uno de los numeros dados por el usuario
            System.out.println("IMPRESOR LCD");             //Solo sale del ciclo cuando termina el programa, es decir cuando el usuario ingresa "0,0"
            System.out.println("Programa que imprime números en estilo de una pantalla LCD");
            System.out.println("Ingrese 2 numeros separados por ,");
            System.out.println("El primer número entre 1 y 10, representa el tamaño de la impresión.");
            System.out.println("El segundo número es el número a mostrar en la pantalla.");
            System.out.println("Para terminar, se debe digitar 0,0. Esto terminará la aplicación.");
            palabra[tam] = sc.nextLine();                   // Se lee cada uno de los numeros dados por usuario en String; el ultimo dato que lee es "0,0"
            final_palabra = palabra[tam];
            tam++;
            if (final_palabra.equals("0,0")){
                salir = true;
            }
        }while( salir == false);
        
        int i=0;
        String[ ]   size_String = new  String[tam];         //recibe el "size" de cada uno de los numeros ingresados por usuario, es decir, 
                                                            //si el usuario ingresa "5,467", esta variable contiene a 5 (en formato String)
        String[ ]   num_mostrar_String = new  String[tam];  //recibe el "numero a mostrar" de cada uno de los numeros ingresados por usuario, es decir, 
                                                            //si el usuario ingresa "5,467", esta variable contiene a 467 (en formato String)
                                                            
        int size[]= new int[tam];                           //vector donde se guardan los datos de la variable size_String[] convertidos en enteros
        int num_mostrar[]= new int[tam];                    //vector donde se guardan los datos de la variable num_mostrar_String[] convertidos en enteros
        int num_lim=0;
        while (i != tam)                                    //ciclo donde se convierte el String ingresado por el usuario a 2 cadenas de enteros (size y numeros)
        {    
            num = palabra[i]; 
            numeroArray = num.split(",");
            size_String[i] = numeroArray[0];
            num_mostrar_String[i] = numeroArray[1];
            size[i] = Integer.parseInt(size_String[i]);
            //num_lim = num_lim + (size[i]*2 );
            num_mostrar[i] = Integer.parseInt(num_mostrar_String[i]);
            i++;
            System.out.println();
        }
        int siz = 0;                                        //variable que guarda cada uno de los numeros del vector size[] para utilizarlos
        int num_m = 0;                                      //variable que guarda cada uno de los numeros del vector num_mostrar[] para utilizarlos
        char[] nums;                                        //vector que convierte la variable num_m en un vecto de digitos, es decir 467, 
                                                             //lo convierte en un vector de 3 posiciones [4, 6, 7]
 
        int col_ini, fil_ini = 0;
        for (i =0; i < tam-1; i++){                         //Ciclo donde se realiza el proceso de crear los numeros LCD e imprimirlos en pantalla
            col = 0;
            col_ini = 0;
            num_lim = (size[i]*2)+3 ;
            matriz = new  String[num_lim][1000];            
            for (int x=0; x < matriz.length; x++) {
                for (int y=0; y < matriz[x].length; y++) {  //Inicialmente la matriz esta "vacía"
                    matriz[x][y] = fondo;
                }
            }
            siz = size[i];
            num_m = num_mostrar[i];             
            nums = num_mostrar_String[i] .toCharArray();
            for(char c: nums) {                             //El numero a mostrar se divide en cada uno de sus digitos, y e convierte a caracter
                int j, k;                                   
                switch (c){                                 //En esta estructura de control, se selecciona cada uno de los digitos del numero a 
                                                            //mostrar, y se convierte en pixeles, dependiendo del tamaño pedido por el usuario
                    case '0':                               // Convierte el 0 en un numero LCD para mostrar en pantalla
                        col = col_ini;
                        fila = fil_ini;
                        matriz[fila][col] = fondo;
                        col++;
                        col = columna_display(siz, fila, col, matriz);                        
                        col++;
                        matriz[fila][col] = fondo;
                        col = col_ini;
                        fila++;
                        for(j=0; j<((2*siz)-1); j++)
                        {
                            col++;
                            matriz[fila][col] = barra;
                            col =espacio_display(siz, fila,col, matriz);
                            col++;
                            matriz[fila][col] = barra;
                            col = col_ini;
                            fila++;
                        }
                        col++;
                        matriz[fila][col] = barra;
                        col = columna_display(siz, fila,col, matriz);
                        col++;
                        matriz[fila][col] = barra;
                        col_ini=col+2;
                        fil_ini = 0;
                        break;
                    case '1':                                               // Convierte el 1 en un numero LCD para mostrar en pantalla
                        col = col_ini;
                        fila = fil_ini;
                        matriz[fila][col] = fondo;
                        col++;
                        col = espacio_display(siz, fila, col, matriz);                        
                        col++;
                        matriz[fila][col] = fondo;
                        col = col_ini;
                        fila++;
                        for(j=0; j<((2*siz)-1); j++)
                        {
                            col++;
                            matriz[fila][col] = fondo;
                            col =espacio_display(siz, fila,col, matriz);
                            col++;
                            matriz[fila][col] = barra;
                            col = col_ini;
                            fila++;
                        }
                        col++;
                        matriz[fila][col] = fondo;
                        col = espacio_display(siz, fila,col, matriz);
                        col++;
                        matriz[fila][col] = barra;
                        col_ini=col+2;
                        fil_ini = 0;
                        break;
                        
                    case '2':                                                   // Convierte el 2 en un numero LCD para mostrar en pantalla
                        col = col_ini;
                        fila = fil_ini;                        
                        matriz[fila][col] = fondo;
                        col++;
                        col = columna_display(siz, fila, col, matriz);                        
                        col++;
                        matriz[fila][col] = fondo;
                        col = col_ini;
                        fila++;
                        for(j=0; j<((2*siz)-1); j++)
                        {
                            col++;
                            if (j <= siz-1)
                            {
                                matriz[fila][col] = fondo; 
                            }else
                            {
                                matriz[fila][col] = barra;  
                            }if (j == siz-1)
                            {
                                col = columna_display(siz, fila,col, matriz);                                
                            }else
                            {
                                col = espacio_display(siz, fila,col, matriz);                               
                            } 
                            col++;
                            if (j <= siz-1)
                            {
                                matriz[fila][col] = barra; 
                            }
                            col++;
                            matriz[fila][col] = fondo;
                            col=col_ini;
                            fila++;
                        }
                        col++;
                        matriz[fila][col] = barra;
                        col = columna_display(siz, fila,col, matriz);
                        col++;
                        matriz[fila][col] = fondo;
                        col_ini=col+2;
                        fil_ini = 0;
                        col++;            
                        break;
                        
                    case '3':                                                   // Convierte el 3 en un numero LCD para mostrar en pantalla
                        col = col_ini;
                        fila = fil_ini;
                        matriz[fila][col] = fondo;
                        col++;
                        col = columna_display(siz, fila, col, matriz);                        
                        col++;
                        matriz[fila][col] = fondo;
                        col = col_ini;
                        fila++;
                        for(j=0; j<((2*siz)-1); j++)
                        {
                            col++;
                            matriz[fila][col] = fondo;
                            if (j == siz-1)
                            {
                                col = columna_display(siz, fila,col,matriz);
                            }else
                            {
                                col = espacio_display(siz, fila,col,matriz);
                            }     
                            col++;
                            matriz[fila][col] = barra;
                            col = col_ini;
                            fila++;
                        }
                        col++;
                        matriz[fila][col] = fondo;
                        col = columna_display(siz, fila,col, matriz);
                        col++;
                        matriz[fila][col] = barra;
                        col_ini=col+2;
                        fil_ini = 0;
                        break; 
                    case '4':                                                   // Convierte el 4 en un numero LCD para mostrar en pantalla
                        col = col_ini;
                        fila = fil_ini;                        
                        matriz[fila][col] = fondo;
                        col++;
                        col = espacio_display(siz, fila, col, matriz);                        
                        col++;
                        matriz[fila][col] = fondo;
                        col = col_ini;
                        fila++;
                        for(j=0; j<((2*siz)-1); j++)
                        {
                            col++;
                            if (j > siz-1)
                            {
                                matriz[fila][col] = fondo; 
                            }else
                            {
                                matriz[fila][col] = barra; 
                            }if (j == siz-1)
                            {
                                col = columna_display(siz, fila,col, matriz);                                
                            }else
                            {
                                col = espacio_display(siz, fila,col, matriz);                               
                            } 
                            col++;                            
                            matriz[fila][col] = barra;                             
                            col++;
                            matriz[fila][col] = fondo;
                            col=col_ini;
                            fila++;
                        }
                        col++;
                        matriz[fila][col] = fondo;
                        col = espacio_display(siz, fila,col, matriz);
                        col++;
                        matriz[fila][col] = barra;
                        col_ini=col+2;
                        fil_ini = 0;
                        col++; 
                        break;
                        
                    case '5':                                                   // Convierte el 5 en un numero LCD para mostrar en pantalla
                        col = col_ini;
                        fila = fil_ini;
                        matriz[fila][col] = fondo;
                        col++;
                        col = columna_display(siz, fila, col, matriz);                        
                        col++;
                        matriz[fila][col] = fondo;
                        col = col_ini;
                        fila++;
                        for(j=0; j<((2*siz)-1); j++)
                        {
                            col++;
                            if (j > siz-1)
                            {
                                matriz[fila][col] = fondo; 
                            }else
                            {
                                matriz[fila][col] = barra; 
                            } 
                            
                            if (j == siz-1)
                            {
                                col = columna_display(siz, fila,col, matriz);                                
                            }else
                            {
                                col = espacio_display(siz, fila,col, matriz);                               
                            } 
                            col++;
                            if (j > siz-1)
                            {
                                matriz[fila][col] = barra;
                            }
                            col++;
                            matriz[fila][col] = fondo;
                            col=col_ini;
                            fila++;
                        }
                        col++;
                        matriz[fila][col] = fondo;
                        col = columna_display(siz, fila,col, matriz);
                        col++;
                        matriz[fila][col] = barra;
                        col_ini=col+2;
                        fil_ini = 0;
                        col++;            
                        break;
                        
                    case '6':                                                   // Convierte el 6 en un numero LCD para mostrar en pantalla
                        col = col_ini;
                        fila = fil_ini;                        
                        matriz[fila][col] = fondo;
                        col++;
                        col = columna_display(siz, fila, col, matriz);                        
                        col++;
                        matriz[fila][col] = fondo;
                        col = col_ini;
                        fila++;
                        for(j=0; j<((2*siz)-1); j++)
                        {
                            col++;
                            matriz[fila][col] = barra;  
                            if (j == siz-1)
                            {
                                col = columna_display(siz, fila,col, matriz);                                
                            }else
                            {
                                col = espacio_display(siz, fila,col, matriz);                               
                            } 
                            col++;
                            if (j > siz-1)
                            {
                                matriz[fila][col] = barra; 
                            }
                            col++;
                            matriz[fila][col] = fondo;
                            col=col_ini;
                            fila++;
                        }
                        col++;
                        matriz[fila][col] = barra;
                        col = columna_display(siz, fila,col, matriz);
                        col++;
                        matriz[fila][col] = barra;
                        col_ini=col+2;
                        fil_ini = 0;
                        col++;      
                        break;
                        
                    case '7':                                                   // Convierte el 7 en un numero LCD para mostrar en pantalla
                        col = col_ini;
                        fila = fil_ini;
                        matriz[fila][col] = fondo;
                        col++;
                        col = columna_display(siz, fila, col, matriz);                        
                        col++;
                        matriz[fila][col] = fondo;
                        col = col_ini;
                        fila++;
                        for(j=0; j<((2*siz)-1); j++)
                        {
                            col++;
                            matriz[fila][col] = fondo;
                            col =espacio_display(siz, fila,col, matriz);
                            col++;
                            matriz[fila][col] = barra;
                            col = col_ini;
                            fila++;
                        }
                        col++;
                        matriz[fila][col] = fondo;
                        col = espacio_display(siz, fila,col, matriz);
                        col++;
                        matriz[fila][col] = barra;
                        col_ini=col+2;
                        fil_ini = 0;
                        break; 
                        
                    case '8':                                                   // Convierte el 8 en un numero LCD para mostrar en pantalla
                        col = col_ini;
                        fila = fil_ini;
                        matriz[fila][col] = fondo;
                        col++;
                        col = columna_display(siz, fila, col, matriz);                        
                        col++;
                        matriz[fila][col] = fondo;
                        col = col_ini;
                        fila++;
                        for(j=0; j<((2*siz)-1); j++)
                        {
                            col++;
                            matriz[fila][col] = barra;
                            if (j == siz-1)
                            {
                                col = columna_display(siz, fila,col,matriz);
                            }else
                            {
                                col = espacio_display(siz, fila,col,matriz);
                            }     
                            col++;
                            matriz[fila][col] = barra;
                            col = col_ini;
                            fila++;
                        }
                        col++;
                        matriz[fila][col] = barra;
                        col = columna_display(siz, fila,col, matriz);
                        col++;
                        matriz[fila][col] = barra;
                        col_ini=col+2;
                        fil_ini = 0;
                        break;
                        
                    case '9':                                                   // Convierte el 9 en un numero LCD para mostrar en pantalla
                        col = col_ini;
                        fila = fil_ini;                        
                        matriz[fila][col] = fondo;
                        col++;
                        col = columna_display(siz, fila, col, matriz);                        
                        col++;
                        matriz[fila][col] = fondo;
                        col = col_ini;
                        fila++;
                        for(j=0; j<((2*siz)-1); j++)
                        {
                            col++;
                            if (j > siz-1)
                            {
                                matriz[fila][col] = fondo; 
                            }else
                            {
                                matriz[fila][col] = barra; 
                            }if (j == siz-1)
                            {
                                col = columna_display(siz, fila,col, matriz);                                
                            }else
                            {
                                col = espacio_display(siz, fila,col, matriz);                               
                            } 
                            col++;                            
                            matriz[fila][col] = barra;                             
                            col++;
                            matriz[fila][col] = fondo;
                            col=col_ini;
                            fila++;
                        }
                        col++;
                        matriz[fila][col] = fondo;
                        col = columna_display(siz, fila,col, matriz);
                        col++;
                        matriz[fila][col] = barra;
                        col_ini=col+2;
                        fil_ini = 0;
                        col++; 
                        break;
                        
                    default:
                            break;
                }   
            }
            imprimir_display(matriz);                                           // Muestra en pantalla la matriz de numeros LCD
            
        }   
    } 
    static int columna_display(int siz, int fila, int col, String matriz[][])   {//Crea las lineas verticales de los numeros en LCD               
        for(int i = 0; i < siz-1; i++)        {
            col++;
            matriz[fila][col] = "_";
            col++;
            matriz[fila][col] = fondo;
        }
        col++;
        matriz[fila][col] = "_";
        return col;
    }
    
    static int espacio_display(int siz, int fila, int col, String matriz[][]) {  // Rellena el fondo de los numeros en LCD con espacios    
        for(int i=0; i< siz-1; i++)        {
            col++;
            matriz[fila][col] = fondo;
            col++;
            matriz[fila][col] = fondo;
        } 
        col++;
        matriz[fila][col] = fondo;
        return col;
    } 
    
    static void imprimir_display(String matriz[][]){
            for (int x=0; x < matriz.length; x++) {                              // Muestra en pantalla la matriz de numeros LCD
            for (int y=0; y < matriz[x].length; y++) {
                System.out.print (matriz[x][y]);
            }
            System.out.println();
            }
    }
}