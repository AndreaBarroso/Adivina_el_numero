public class Pensador {

    int[] numero;

    public Pensador(int numero[]){
        this.numero = numero;
    }


    public void mostrarNumero(int[] num){
        for(int i = 0; i <num.length;i++) {
            System.out.println("Posición " + i + ": " + num[i]);
        }
    }

    @Override
    public String toString() {
        return ""+numero[0]+numero[1]+numero[2]+numero[3]+"";
    }


    public int verificarRespuesta(char numJugador[], char[]num){
        int bien = 0;
        int regular = 0;
        for(int v = 0; v < num.length;v++){
            if(numJugador[v]==num[v]){
                bien++;
            }
        }

        for(int a = 0; a < num.length;a++) {
            for (int b = 0; b < num.length; b++) {
                if (numJugador[a] == num[b]) {
                    regular++;
                }
            }
        }

        if(bien==4){
            System.out.println("  JUEGO TERMINADO!");
        }else{
            System.out.println("Posiciones correctas: "+bien);
            System.out.println("Posiciones regulares: "+(regular-bien));
        }
        return bien;
    }

}
