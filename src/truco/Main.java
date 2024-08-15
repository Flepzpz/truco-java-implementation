package truco;

public class Main {

    public static void main(String[] args){

        Partida partida = new Partida(new Jogador(), new Jogador());

        while(partida.humano.getPontos() < 12 && partida.computador.getPontos() < 12){
            partida.rodada();
        }
        if(partida.humano.getPontos() > partida.computador.getPontos()){
            System.out.println("Jogador venceu a partida, você é o senhor do truco");
        } else {
            System.out.println("Computador venceu a partida, você não é o senhor do truco");
        }

    }

}
