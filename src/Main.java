import java.util.Scanner;

public class Main {
    public static void main (String[] ars){
        int []num = numeroPensador();
        Pensador pensador = new Pensador(num);
        System.out.println(pensador.toString());
        pensador.mostrarNumero(num);
        Scanner leer = new Scanner(System.in);
        int result=0;
        do{
            System.out.println("Ingrese un número de 4 cifras.");
            char vec [] = leer.next().toCharArray();
            char miVec [] =agregarCero(vec);
            if(!verificarNumero(miVec)){
                System.out.println("\n====================");
                result =pensador.verificarRespuesta(miVec,pensador.toString().toCharArray());
                System.out.println("====================\n");
            }else{
                System.out.println("El número ingresado posee dígitos repetidos. Ingrese un nuevo número :)");
            }

        }while(result<4);


    }

    public static char[] agregarCero(char numAdivinador[]){
        char numConCero [] = new char[4];
        if(numAdivinador.length==3){
            for (int i = 0;i<3;i++){
                numConCero[i+1]=numAdivinador[i];
            }
            numConCero[0] = '0';
            return numConCero;
        }else{
            return numAdivinador;
        }
    }

    public static int[] numeroPensador(){
        int[] num = new int[4];
        for(int i = 0;i<num.length;i++){
            num[i] =(int) Math.floor(Math.random()*10);
        }
        for(int i = 0;i<num.length;i++){
            for(int j =0;j<num.length;j++){
                if(num[i] == num[j]&&i!=j){
                    num[i]=(int) Math.floor(Math.random()*10);
                    i=0;
                }
            }
        }
        return num;
    }

    public static boolean verificarNumero(char numeroAdivinador[]){
        boolean repetido = false;
        for(int i = 0;i<numeroAdivinador.length;i++){
            for(int j =0;j<numeroAdivinador.length;j++){
                if(numeroAdivinador[i] == numeroAdivinador[j]&&i!=j){
                    repetido = true;
                    i=j=numeroAdivinador.length;
                }
            }
        }
        return repetido;
    }

}
