package ventanas;

import java.util.Scanner;

public class Ventanas {

    public static void main(String[] args) {
        int num=10, num2, i, j, k, tam;
        int cont=0, contPrimo=0;
        double result=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Numeros Primos");
        System.out.println("Ingrese un numero para saber cuantos numeros primos existen hasta dicho numero y cuantos son:");
        num2 = sc.nextInt();
        //tam = num/2;
        while(num < num2){ 
            tam = num;
            
            for(i=2; i < tam; i++){
                for(j=2; j < tam; j++){
                    result = i*j;
                    if (result == num){
                        //System.out.println("El numero "+num+" es divisible por "+i+" y "+j);
                        j= tam;
                        i= tam;
                        cont++;                         
                    }
                }            
            }
            if (cont == 0)
            {
                System.out.println("El numero "+num+" es primo");
                contPrimo++;
            }
            num++;
            cont=0;
        } 
        System.out.println("Entre 0 y "+num+" existen "+contPrimo+" numeros primos");
    }
}
