package lettersoup;
import java.util.Scanner;

public class LetterSoup {
        int fila;           //variable 1
        int columna;         //variable 2
        int numPal;      //variable 3    
    private String getColumna;
    // Constructor
    public LetterSoup(int fila, int columna, int numPal) {
        this.fila = fila;
        this.columna = columna;
        this.numPal = numPal;
    }
    // Metodos Set & Get
    public int getFila() {
        return fila;
    }
    public void setFila(int fila) {
        this.fila = fila;
    }
    public int getColumna() {
        return columna;
    }
    public void setColumna(int columna) {
        this.columna = columna;
    }
    public int getNumPal() {
        return numPal;
    }
    public void setNumPal(int numPal) {
        this.numPal = numPal;
    }
   
    //main principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LetterSoup casa; //Creamos el objeto casa (La sopa de letras se llama "sopa de letras de la casa")
        casa = new LetterSoup(7,6,10); //Objeto lo instanciamos con los datos pedidos en el constructor
        // En este caso, son 7 filas, 6 columnas y 10 palabras a buscar en la sopa de letras
        int fil, col, nPal;
        System.out.println("SOPA DE LETRAS (SOLUCIONADOR)");
        
        System.out.println("1. Ingrese el numero de filas de la sopa de letras");
        fil = sc.nextInt();
        System.out.println("2. Ingrese el numero de columnas de la sopa de letras");
        col = sc.nextInt();
        System.out.println("3. Ingrese el numero de palabras a buscar en la sopa de letras");
        nPal = sc.nextInt();
        
        casa.setFila(fil);
        casa.setColumna(col);
        casa.setNumPal(nPal);
        System.out.println(casa.getFila() + ", " + casa.getColumna() + ", " +casa.getNumPal());
        int tam = casa.getNumPal()+1;
        int filTotal = casa.getFila();
        int colTotal = casa.getColumna();
        String[ ]   palabra = new  String[tam];  
        int i, j = 0;
        //El usuario agrega las palabras que se van a buscar en la sopa de letras
        System.out.println("Ingrese las palabras a buscar en la sopa de letras (DE MAXIMO 21 CARACTERES):");
        for (i =0; i < (tam); i++)
        {
           palabra[i] = sc.nextLine(); 
        }
        System.out.println("Las palabras ingresadas son:");
        for (i =1; i <(tam); i++)
        {
           System.out.println(i+". "+palabra[i]); 
        }
        
        // El usuario crea la sopa de letras
         char[][] sopa = new char[filTotal+2][colTotal+2];
         //sopa= null;         
         char letra;
         int k1, l1, k, l;
         // La Sopa de Letras nicialmente es una matriz de | (son los bordes de la S.L.)
        for (k =0; k <(filTotal+2); k++)
        {
            for (l = 0; l <(colTotal+2); l++)
            {
                sopa[k][l] = '|'; 
            }        
        }
        for (k =1; k <(filTotal+1); k++)
        {
            for (l = 1; l <(colTotal+1); l++)
            {    
                System.out.println("Ingrese la letra posicionada en  "+k+" fila y "+l+" columna:"); 
                letra = sc.next().charAt(0);            
                sopa[k][l] = letra;
            }        
        }
         // Posicion es una matriz del tamaño de la sopa de letras pero con valores en 0
         char[][] posicion = new char[filTotal+2][colTotal+2];
         for (k =0; k <(filTotal+2); k++)
        {
            for (l = 0; l <(colTotal+2); l++)
            {            
                posicion[k][l] = ' ';                  
            }        
        }
         // Mostrar sopa de letras en pantalla
         for (k =0;k <(filTotal+2); k++)
        { 
            for (l = 0; l <(colTotal+2); l++)
            {
                System.out.print(sopa[k][l]+" ");                            
            }
            System.out.println();
        }
         // Comparacion entre cada una de las palabras a buscar y la sopa de letras
        String palabraBuscada;
        int ciclo_principal;
        int[][] ultima = new int[i][4];
        i =1;
        boolean resp = false;   
        while((i < tam)&&(resp == false)) // Ciclo para tomar cada una de las palabras a buscar en la SL
        {
            j = 0;
            ciclo_principal = 0;
            palabraBuscada = palabra[i];
            System.out.println("PALABRA ELEGIDA A BUSCAR ="+palabraBuscada);
            char[] letras_palabra = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
            letras_palabra = palabraBuscada.toCharArray();
            int letra_final = palabraBuscada.length();
            
                     
            int a, b, opcion, aum;
            char[] pos_busqueda = {' ',' ',' ',' ',' ',' ',' ',' ', ' '};
            k=1;
            l=1;
            while (ciclo_principal == 0)  // Solo sale del ciclo si se termina de buscar una palabra
            {    
//                System.out.println(sopa[k][l]);
                if(letras_palabra[j] == sopa[k][l]) // Encuentra la primera letra de la palabra buscada en la S.L.
                {
                    a= 1;
                    b=1;
                    opcion =0; 
                    pos_busqueda[0] = sopa[k-a][l-b];
                    pos_busqueda[1] = sopa[k-a][l];
                    pos_busqueda[2] = sopa[k-a][l+b];
                    pos_busqueda[3] = sopa[k][l-b];
                    pos_busqueda[4] = sopa[k][l+b];
                    pos_busqueda[5] = sopa[k+a][l-b];
                    pos_busqueda[6] = sopa[k+a][l];
                    pos_busqueda[7] = sopa[k+a][l+b];
                    pos_busqueda[8] = ' ';
                    
                    while(opcion <= 7)      //hay 8 opciones diferentes para encontrar la segunda letra de la S.L.
                    {
//                        System.out.print("LETRA ENCONTRADA: ");
//                        System.out.println(pos_busqueda[opcion]);
//                        System.out.print("    LETRA DE PALABRA: "+letras_palabra[j]);
//                        System.out.println("     Opcion: "+opcion);
                        int opcion2 = opcion;
                        switch(opcion) //Busqueda de las letras de una palabra en la S.L. a partir de la segunda letra
                        {
                            case 0:     //Posicion "Diagonal Arriba Izquierda" de la primera letra encontrada
                                aum = 0;
                                j=1;
                                while((letras_palabra[j+aum] == sopa[k-a][l-b])&&(opcion < 8)) 
                                {
//                                    System.out.println("Letra " +letras_palabra[j+aum]+ " encontrada");
//                                    System.out.println("Posicion " +opcion2);
//                                    System.out.println("DIRECCION DIAGONAL ARRIBA IZQUIERDA" );
//                                    System.out.println("Busqueda: " +sopa[k-a][l-b]);
//                                    System.out.println("FILA: " +k);
//                                    System.out.println("A: " +a);
//                                    System.out.println("COLUMNA: " +l);
//                                    System.out.println("B: " +b);
//                                    System.out.println("j: " +j);
                                    aum++;
                                    a++;
                                    b++;
//                                    System.out.println("Letra a seguir: " +letras_palabra[j+aum]);
//                                    System.out.println("Compara con: " +sopa[k-a][l-b]);
                                    if(j+aum==letra_final-1)  //Ultima letra de la palabra buscada concuerda
                                    {
                                        //resp= true; //Respuesta es True cuando la palabra es igual 
                                        opcion = 9;
                                        ultima[i][0]=k;
                                        ultima[i][1]=l;
                                        ultima[i][2]=letra_final;
                                        ultima[i][3]=0;
                                        System.out.println("Palabra " +palabra[i]+ " encontrada");
                                        System.out.println("Su primera letra esta en la fila " +ultima[i][0] + " y columna "+ultima[i][1]);
                                        System.out.println("Tiene  " +ultima[i][2]+ " letras");
                                        System.out.println("Esta en DIRECCION DIAGONAL ARRIBA IZQUIERDA");
                                        System.out.println();
                                        if(i == tam-1)  //Pregunta si es la ultima palabra a buscar en la S.L.
                                        {
                                            //i= tam+1;
                                            resp= true;
                                        }else         // Si no es la ultima palabra a buscar, actualiza todo, y busca la proxima palabra en la misma direccion en la S.l.
                                        {
                                            i++;
                                            j=0;
                                            k=1;
                                            l=1;
                                        }
                                        ciclo_principal = 1;  //Me saca de todos los ciclos, y va a buscar la palabra siguiente
                                        l = i-1;
//                                        System.out.println("Palabra " +palabra[l]+ " encontrada");
                                        l = 1; 
                                        aum = 0;
                                        a = 1;
                                        b = 1;
                                        break;
                                    }  
                                }    
                                if(opcion < 8)   //Si todas las letras no concuerdan con la palabra buscada, busco en la siguiente direccion
                                {
                                    opcion = 1;
                                    j=0;
                                    a=1;
                                    b=1;
                                    
                                }
                                break;
//                                
                            case 1:    //Posicion "Arriba" de la primera letra encontrada
                                aum = 0;
                                j=1;
                                while((letras_palabra[j+aum] == sopa[k-a][l])&&(opcion < 8)) 
                                {
//                                    System.out.println("Letra " +letras_palabra[j+aum]+ " encontrada");
//                                    System.out.println("Posicion " +opcion2);
//                                    System.out.println("DIRECCION ARRIBA" );
//                                    System.out.println("Busqueda: " +sopa[k-a][l]);
//                                    System.out.println("FILA: " +k);
//                                    System.out.println("A: " +a);
//                                    System.out.println("COLUMNA: " +l);
//                                    System.out.println("B: " +b);
//                                    System.out.println("j: " +j);
                                    aum++;
                                    a++;
                                    b++;
//                                    System.out.println("Letra a seguir: " +letras_palabra[j+aum]);
//                                    System.out.println("Compara con: " +sopa[k-a][l]);
                                    if(j+aum==letra_final-1)  //Ultima letra de la palabra buscada concuerda
                                    {
                                        //resp= true; //Respuesta es True cuando la palabra es igual 
                                        opcion = 9;
                                        ultima[i][0]=k;
                                        ultima[i][1]=l;
                                        ultima[i][2]=letra_final;
                                        ultima[i][3]=0;
                                        System.out.println("Palabra " +palabra[i]+ " encontrada");
                                        System.out.println("Su primera letra esta en la fila " +ultima[i][0] + " y columna "+ultima[i][1]);
                                        System.out.println("Tiene  " +ultima[i][2]+ " letras");
                                        System.out.println("Esta en DIRECCION ARRIBA");
                                        System.out.println();
                                        if(i == tam-1)  //Pregunta si es la ultima palabra a buscar en la S.L.
                                        {
                                            //i= tam+1;
                                            resp= true;
                                        }else         // Si no es la ultima palabra a buscar, actualiza todo, y busca la proxima palabra en la misma direccion en la S.l.
                                        {
                                            i++;
                                            j=0;
                                            k=1;
                                            l=1;
                                        }
                                        ciclo_principal = 1;  //Me saca de todos los ciclos, y va a buscar la palabra siguiente
                                        l = i-1;
//                                        System.out.println("Palabra " +palabra[l]+ " encontrada");
                                        l = 1;
                                        aum = 0;
                                        a = 1;
                                        b = 1;
                                        break;
                                    }  
                                }    
                                if(opcion < 8)   //Si todas las letras no concuerdan con la palabra buscada, busco en la siguiente direccion
                                {
                                    opcion = 2;
                                    j=0;
                                    a=1;
                                    b=1;
                                    
                                }
                                break;
//                                
                            case 2:     //Posicion "Diagonal Arriba Derecha" de la primera letra encontrada
                                aum = 0;
                                j=1;
                                while((letras_palabra[j+aum] == sopa[k-a][l+b])&&(opcion < 8)) 
                                {
//                                    System.out.println("Letra " +letras_palabra[j+aum]+ " encontrada");
//                                    System.out.println("Posicion " +opcion2);
//                                    System.out.println("DIRECCION DIAGONAL ARRIBA DERECHA" );
//                                    System.out.println("Busqueda: " +sopa[k-a][l+b]);
//                                    System.out.println("FILA: " +k);
//                                    System.out.println("A: " +a);
//                                    System.out.println("COLUMNA: " +l);
//                                    System.out.println("B: " +b);
//                                    System.out.println("j: " +j);
                                    aum++;
                                    a++;
                                    b++;
//                                    System.out.println("Letra a seguir: " +letras_palabra[j+aum]);
//                                    System.out.println("Compara con: " +sopa[k-a][l+b]);
                                    if(j+aum==letra_final-1)  //Ultima letra de la palabra buscada concuerda
                                    {
                                        //resp= true; //Respuesta es True cuando la palabra es igual 
                                        opcion = 9;
                                        ultima[i][0]=k;
                                        ultima[i][1]=l;
                                        ultima[i][2]=letra_final;
                                        ultima[i][3]=0;
                                        System.out.println("Palabra " +palabra[i]+ " encontrada");
                                        System.out.println("Su primera letra esta en la fila " +ultima[i][0] + " y columna "+ultima[i][1]);
                                        System.out.println("Tiene  " +ultima[i][2]+ " letras");
                                        System.out.println("Esta en DIRECCION DIAGONAL ARRIBA DERECHA");
                                        System.out.println();
                                        if(i == tam-1)  //Pregunta si es la ultima palabra a buscar en la S.L.
                                        {
                                            //i= tam+1;
                                            resp= true;
                                        }else         // Si no es la ultima palabra a buscar, actualiza todo, y busca la proxima palabra en la misma direccion en la S.l.
                                        {
                                            i++;
                                            j=0;
                                            k=1;
                                            l=1;
                                        }
                                        ciclo_principal = 1;  //Me saca de todos los ciclos, y va a buscar la palabra siguiente
                                        l = i-1;
//                                        System.out.println("Palabra " +palabra[l]+ " encontrada");
                                        l = 1;
                                        aum = 0;
                                        a = 1;
                                        b = 1;
                                        break;
                                    }  
                                }    
                                if(opcion < 8)   //Si todas las letras no concuerdan con la palabra buscada, busco en la siguiente direccion
                                {
                                    opcion = 3;
                                    j=0;
                                    a=1;
                                    b=1;
                                    
                                }
                                break;
//                                
                            case 3:     //Posicion "Izquierda" de la primera letra encontrada
                                aum = 0;
                                j=1;
                                while((letras_palabra[j+aum] == sopa[k][l-b]) &&(opcion < 8))
                                {
//                                    System.out.println("Letra " +letras_palabra[j+aum]+ " encontrada");
//                                    System.out.println("Posicion " +opcion2);
//                                    System.out.println("DIRECCION IZQUIERDA" );
//                                    System.out.println("Busqueda: " +sopa[k][l-b]);
//                                    System.out.println("FILA: " +k);
//                                    System.out.println("A: " +a);
//                                    System.out.println("COLUMNA: " +l);
//                                    System.out.println("B: " +b);
//                                    System.out.println("j: " +j);
                                    aum++;
                                    a++;
                                    b++;
//                                    System.out.println("Letra a seguir: " +letras_palabra[j+aum]);
//                                    System.out.println("Compara con: " +sopa[k][l-b]);
                                    if(j+aum==letra_final-1)  //Ultima letra de la palabra buscada concuerda
                                    {
                                        //resp= true; //Respuesta es True cuando la palabra es igual 
                                        opcion = 9;
                                        ultima[i][0]=k;
                                        ultima[i][1]=l;
                                        ultima[i][2]=letra_final;
                                        ultima[i][3]=0;
                                        System.out.println("Palabra " +palabra[i]+ " encontrada");
                                        System.out.println("Su primera letra esta en la fila " +ultima[i][0] + " y columna "+ultima[i][1]);
                                        System.out.println("Tiene  " +ultima[i][2]+ " letras");
                                        System.out.println("Esta en DIRECCION IZQUIERDA");
                                        System.out.println();
                                        if(i == tam-1)  //Pregunta si es la ultima palabra a buscar en la S.L.
                                        {
                                            //i= tam+1;
                                            resp= true;
                                        }else         // Si no es la ultima palabra a buscar, actualiza todo, y busca la proxima palabra en la misma direccion en la S.l.
                                        {
                                            i++;
                                            j=0;
                                            k=1;
                                            l=1;
                                        }
                                        ciclo_principal = 1;  //Me saca de todos los ciclos, y va a buscar la palabra siguiente
                                        l = i-1;
//                                        System.out.println("Palabra " +palabra[l]+ " encontrada");
                                        l = 1;
                                        aum = 0;
                                        a = 1;
                                        b = 1;
                                        break;
                                    }  
                                }    
                                if(opcion < 8)   //Si todas las letras no concuerdan con la palabra buscada, busco en la siguiente direccion
                                {
                                    opcion = 4;
                                    j=0;
                                    a=1;
                                    b=1;
                                    
                                }
                                break;
//                                
                            case 4:     //Posicion "Derecha" de la primera letra encontrada
                                aum = 0;
                                j=1;
                                while((letras_palabra[j+aum] == sopa[k][l+b]) &&(opcion < 8))
                                {
//                                    System.out.println("Letra " +letras_palabra[j+aum]+ " encontrada");
//                                    System.out.println("Posicion " +opcion2);
//                                    System.out.println("DIRECCION DERECHA" );
//                                    System.out.println("Busqueda: " +sopa[k][l+b]);
//                                    System.out.println("FILA: " +k);
//                                    System.out.println("A: " +a);
//                                    System.out.println("COLUMNA: " +l);
//                                    System.out.println("B: " +b);
//                                    System.out.println("j: " +j);
                                    aum++;
                                    a++;
                                    b++;
//                                    System.out.println("Letra a seguir: " +letras_palabra[j+aum]);
//                                    System.out.println("Compara con: " +sopa[k][l+b]);
                                    if(j+aum==letra_final-1)  //Ultima letra de la palabra buscada concuerda
                                    {
                                        //resp= true; //Respuesta es True cuando la palabra es igual 
                                        opcion = 9;
                                        ultima[i][0]=k;
                                        ultima[i][1]=l;
                                        ultima[i][2]=letra_final;
                                        ultima[i][3]=0;
                                        System.out.println("Palabra " +palabra[i]+ " encontrada");
                                        System.out.println("Su primera letra esta en la fila " +ultima[i][0] + " y columna "+ultima[i][1]);
                                        System.out.println("Tiene  " +ultima[i][2]+ " letras");
                                        System.out.println("Esta en DIRECCION DERECHA");
                                        System.out.println();
                                        if(i == tam-1)  //Pregunta si es la ultima palabra a buscar en la S.L.
                                        {
                                            //i= tam+1;
                                            resp= true;
                                        }else         // Si no es la ultima palabra a buscar, actualiza todo, y busca la proxima palabra en la misma direccion en la S.l.
                                        {
                                            i++;
                                            j=0;
                                            k=1;
                                            l=1;
                                        }
                                        ciclo_principal = 1;  //Me saca de todos los ciclos, y va a buscar la palabra siguiente
                                        l = i-1;
//                                        System.out.println("Palabra " +palabra[l]+ " encontrada");
                                        l = 1;
                                        aum = 0;
                                        a = 1;
                                        b = 1;
                                        break;
                                    }  
                                }    
                                if(opcion < 8)   //Si todas las letras no concuerdan con la palabra buscada, busco en la siguiente direccion
                                {
                                    opcion = 5;
                                    j=0;
                                    a=1;
                                    b=1;
                                    
                                }
                                break;
//                                
                            case 5:     //Posicion "Diagonal Abajo Izquierda" de la primera letra encontrada
                                aum = 0;
                                j=1;
                                while((letras_palabra[j+aum] == sopa[k+a][l-b]) &&(opcion < 8))
                                {
//                                    System.out.println("Letra " +letras_palabra[j+aum]+ " encontrada");
//                                    System.out.println("Posicion " +opcion2);
//                                    System.out.println("Posicion DIRECCION ABAJO IZQUIERDA" );
//                                    System.out.println("Busqueda: " +sopa[k+a][l-b]);
//                                    System.out.println("FILA: " +k);
//                                    System.out.println("A: " +a);
//                                    System.out.println("COLUMNA: " +l);
//                                    System.out.println("B: " +b);
//                                    System.out.println("j: " +j);
                                    aum++;
                                    a++;
                                    b++;
//                                    System.out.println("Letra a seguir: " +letras_palabra[j+aum]);
//                                    System.out.println("Compara con: " +sopa[k+a][l-b]);
                                    if(j+aum==letra_final-1)  //Ultima letra de la palabra buscada concuerda
                                    {
                                        //resp= true; //Respuesta es True cuando la palabra es igual 
                                        opcion = 9;
                                        ultima[i][0]=k;
                                        ultima[i][1]=l;
                                        ultima[i][2]=letra_final;
                                        ultima[i][3]=0;
                                        System.out.println("Palabra " +palabra[i]+ " encontrada");
                                        System.out.println("Su primera letra esta en la fila " +ultima[i][0] + " y columna "+ultima[i][1]);
                                        System.out.println("Tiene  " +ultima[i][2]+ " letras");
                                        System.out.println("Esta en DIRECCION DIAGONAL ABAJO IZQUIERDA");
                                        System.out.println();
                                        if(i == tam-1)  //Pregunta si es la ultima palabra a buscar en la S.L.
                                        {
                                            //i= tam+1;
                                            resp= true;
                                        }else         // Si no es la ultima palabra a buscar, actualiza todo, y busca la proxima palabra en la misma direccion en la S.l.
                                        {
                                            i++;
                                            j=0;
                                            k=1;
                                            l=1;
                                        }
                                        ciclo_principal = 1;  //Me saca de todos los ciclos, y va a buscar la palabra siguiente
                                        l = i-1;
//                                        System.out.println("Palabra " +palabra[l]+ " encontrada");
                                        l = 1;
                                        aum = 0;
                                        a = 1;
                                        b = 1;
                                        break;
                                    }  
                                }    
                                if(opcion < 8)   //Si todas las letras no concuerdan con la palabra buscada, busco en la siguiente direccion
                                {
                                    opcion = 6;
                                    j=0;
                                    a=1;
                                    b=1;
                                    
                                }
                                break;
//                                
                            case 6:     //Posicion "Abajo" de la primera letra encontrada
                                aum = 0;
                                j=1;
                                while((letras_palabra[j+aum] == sopa[k+a][l])&&(opcion < 8))
                                {
//                                    System.out.println("Letra " +letras_palabra[j+aum]+ " encontrada");
//                                    System.out.println("Posicion " +opcion2);
//                                    System.out.println("DIRECCION ABAJO" );
//                                    System.out.println("Busqueda: " +sopa[k+a][l]);
//                                    System.out.println("FILA: " +k);
//                                    System.out.println("A: " +a);
//                                    System.out.println("COLUMNA: " +l);
//                                    System.out.println("B: " +b);
//                                    System.out.println("j: " +j);
                                    aum++;
                                    a++;
                                    b++;
//                                    System.out.println("Letra a seguir: " +letras_palabra[j+aum]);
//                                    System.out.println("Compara con: " +sopa[k+a][l]);
                                    if(j+aum==letra_final-1)  //Ultima letra de la palabra buscada concuerda
                                    {
                                        //resp= true; //Respuesta es True cuando la palabra es igual 
                                        opcion = 9;
                                        ultima[i][0]=k;
                                        ultima[i][1]=l;
                                        ultima[i][2]=letra_final;
                                        ultima[i][3]=0;
                                        System.out.println("Palabra " +palabra[i]+ " encontrada");
                                        System.out.println("Su primera letra esta en la fila " +ultima[i][0] + " y columna "+ultima[i][1]);
                                        System.out.println("Tiene  " +ultima[i][2]+ " letras");
                                        System.out.println("Esta en DIRECCION ABAJO");
                                        System.out.println();
                                        if(i == tam-1)  //Pregunta si es la ultima palabra a buscar en la S.L.
                                        {
                                            //i= tam+1;
                                            resp= true;
                                        }else         // Si no es la ultima palabra a buscar, actualiza todo, y busca la proxima palabra en la misma direccion en la S.l.
                                        {
                                            i++;
                                            j=0;
                                            k=1;
                                            l=1;
                                        }
                                        ciclo_principal = 1;  //Me saca de todos los ciclos, y va a buscar la palabra siguiente
                                        l = i-1;
//                                        System.out.println("Palabra " +palabra[l]+ " encontrada");
                                        l = 1;
                                        aum = 0;
                                        a = 1;
                                        b = 1;
                                        break;
                                    }  
                                }    
                                if(opcion < 8)   //Si todas las letras no concuerdan con la palabra buscada, busco en la siguiente direccion
                                {
                                    opcion = 7;
                                    j=0;
                                    a=1;
                                    b=1;
                                    
                                }
                                break;
                                
                            case 7:     //Posicion "Diagonal Abajo Derecha" de la primera letra encontrada
                                aum = 0;
                                j=1;
                                while((letras_palabra[j+aum] == sopa[k+a][l+b]) &&(opcion < 8))
                                {
//                                    System.out.println("Letra " +letras_palabra[j+aum]+ " encontrada");
//                                    System.out.println("Posicion " +opcion2);
//                                    System.out.println("DIRECCION DIAGONAL ABAJO DERECHA" );
//                                    System.out.println("Busqueda: " +sopa[k+a][l+b]);
//                                    System.out.println("FILA: " +k);
//                                    System.out.println("A: " +a);
//                                    System.out.println("COLUMNA: " +l);
//                                    System.out.println("B: " +b);
//                                    System.out.println("j: " +j);
                                    aum++;
                                    a++;
                                    b++;
//                                    System.out.println("Letra a seguir: " +letras_palabra[j+aum]);
//                                    System.out.println("Compara con: " +sopa[k+a][l+b]);
                                    if(j+aum==letra_final-1)  //Ultima letra de la palabra buscada concuerda
                                    {
                                        //resp= true; //Respuesta es True cuando la palabra es igual 
                                        opcion = 9;
                                        ultima[i][0]=k;
                                        ultima[i][1]=l;
                                        ultima[i][2]=letra_final;
                                        ultima[i][3]=0;
                                        System.out.println("Palabra " +palabra[i]+ " encontrada");
                                        System.out.println("Su primera letra esta en la fila " +ultima[i][0] + " y columna "+ultima[i][1]);
                                        System.out.println("Tiene  " +ultima[i][2]+ " letras");
                                        System.out.println("Esta en DIRECCION DIAGONAL ABAJO DERECHA");
                                        System.out.println();
                                        if(i == tam-1)  //Pregunta si es la ultima palabra a buscar en la S.L.
                                        {
                                            //i= tam+1;
                                            resp= true;
                                        }else         // Si no es la ultima palabra a buscar, actualiza todo, y busca la proxima palabra en la misma direccion en la S.l.
                                        {
                                            i++;
                                            j=0;
                                            k=1;
                                            l=1;
                                        }
                                        ciclo_principal = 1;  //Me saca de todos los ciclos, y va a buscar la palabra siguiente
                                        l = i-1;
//                                        System.out.println("Palabra " +palabra[l]+ " encontrada");
                                        l = 1;
                                        aum = 0;
                                        a = 1;
                                        b = 1;
                                        break;
                                    }  
                                }    
                                if(opcion < 8)   //Si todas las letras no concuerdan con la palabra buscada, busco en la siguiente direccion
                                {
                                    opcion = 8;
                                    j=0;
                                    a=1;
                                    b=1;
                                    aum = 0;
                                }
                                break;

                            default:
                                break;
                        }
                    }
                    if (opcion == 8)
                    {
                       l++;
                        if (l == colTotal+1)  // Busqueda de la primera de letra de cada palabra en cada una de las columnas de la S.L
                        {
                            if(k == filTotal+1) // Busqueda de la primera de letra de cada palabra en cada una de las filas de la S.L
                            {
                                System.out.println("Error: Palabra NO Encontrada");
                                if(i== tam-1)
                                {
                                    //i= tam+1;
                                    resp= true;
                                }else
                                {
                                    i++;
                                    j=0;
                                    k=1;
                                    l=1;
                                }
                            ciclo_principal = 1;
                            }else
                            {
                                k++;
                                l=1;
                                j=0;
                                a = 1;
                                b = 1;
                            }    
                        }
                    }
                }
                //if (resp == false)
                else
                {
                    l++;
                    if (l == colTotal+1)  // Busqueda de la primera de letra de cada palabra en cada una de las columnas de la S.L
                    {
                        if(k == filTotal+1) // Busqueda de la primera de letra de cada palabra en cada una de las filas de la S.L
                        {
                            System.out.println("Error: Palabra NO Encontrada");
                            if(i== tam-1)
                            {
                                //i= tam+1;
                                resp= true;
                            }else
                            {
                                i++;
                                j=0;
                                k=1;
                                l=1;
                            }
                            ciclo_principal = 1;
                        }else
                        {
                            k++;
                            l=1;
                        }  
                        a = 1;
                        b = 1;
                    }
                }
            }
            
        }
    }
}
