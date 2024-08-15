package truco;

import java.util.Scanner;

public class Partida {

    Jogador humano;
    Jogador computador;

    private int md3H = 0;
    private int md3C = 0;

    boolean humanoComeca = true;

    Scanner read = new Scanner(System.in);


    public Partida(Jogador humano, Jogador computador) {
        this.humano = humano;
        this.computador = computador;
    }


    public void rodada() {

        Baralho baralho = new Baralho();

        this.humano.pegarCartas(baralho.darCartas());
        this.computador.pegarCartas(baralho.darCartas());

        Carta manilha = manilha(baralho);

        System.out.println("Manilha: "+ manilha.getCharValor());

        while (md3H < 2 && md3C < 2) {

            this.humano.imprimeMao();
            if (this.humanoComeca) {

                System.out.println("Escolha uma carta para jogar:");
                Carta jogadaH = this.humano.jogarCarta(read.nextInt()-1);
                System.out.println("Você jogou " + jogadaH.getCharValor() + " " + jogadaH.getCharNaipe());
                Carta jogadaC = this.computador.jogarCarta(read.nextInt()-1);
                System.out.println("Computador jogou " + jogadaC.getCharValor() + " " + jogadaC.getCharNaipe());

                validarVencedor(jogadaH, jogadaC, manilha);

            } else {

                Carta jogadaC = this.computador.jogarCarta(read.nextInt()-1);
                System.out.println("Computador jogou " + jogadaC.getCharValor() + " " + jogadaC.getCharNaipe());
                System.out.println("Escolha uma carta para jogar:");
                Carta jogadaH = this.humano.jogarCarta(read.nextInt()-1);
                System.out.println("Você jogou " + jogadaH.getCharValor() + " " + jogadaH.getCharNaipe());

                validarVencedor(jogadaH, jogadaC, manilha);
            }
        }
        if(md3H > md3C){
            this.humano.setPontos(this.humano.getPontos()+1);
            this.md3H = 0;
            this.md3C = 0;
            System.out.println("Jogador vence a rodada");
        } else {
            this.computador.setPontos(this.computador.getPontos()+1);
            this.md3H = 0;
            this.md3C = 0;
            System.out.println("Computador vende a rodada");
        }
        System.out.println("Pontos jogador: "+this.humano.getPontos());
        System.out.println("Pontos computador: "+this.computador.getPontos());


    }

    public void validarVencedor(Carta cartaJogador, Carta cartaComputador, Carta manilha) {
        if (cartaJogador.getValor() == cartaComputador.getValor()) {
            if (cartaJogador.getValor() == manilha.getValor()) {
                if (cartaJogador.getNaipe() > cartaComputador.getNaipe()) {
                    this.md3H += 1;
                    this.humanoComeca = true;
                    System.out.println("Jogador ganhou");
                } else {
                    this.md3C += 1;
                    this.humanoComeca = false;
                    System.out.println("Computador ganhou");
                }
            } else {
                this.md3H += 1;
                this.md3C += 1;
                System.out.println("Empachou, humano torna");
            }
        } else {
            if (cartaJogador.getValor() == manilha.getValor()) {
                this.md3H += 1;
                this.humanoComeca = true;
                System.out.println("Jogador ganhou");
            } else if (cartaComputador.getValor() == manilha.getValor()) {
                this.md3C += 1;
                this.humanoComeca = false;
                System.out.println("Computador ganhou");
            } else {
                if (cartaJogador.getValor() > cartaComputador.getValor()) {
                    this.md3H += 1;
                    this.humanoComeca = true;
                    System.out.println("Jogador ganhou");
                } else {
                    this.md3C += 1;
                    this.humanoComeca = false;
                    System.out.println("Computador ganhou");
                }
            }
        }
    }

    public Carta manilha(Baralho baralho) {

        Carta vira = baralho.cartas.pop();

        return new Carta(vira.getNaipe() + 1, vira.getValor() + 1);
    }


}
