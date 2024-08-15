package truco;

import java.util.ArrayList;
import java.util.List;

public class Jogador {

    private String nome;
    private List<Carta> mao = new ArrayList<>();
    private int pontos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void pegarCartas(List<Carta> mao) {
        this.mao = mao;
    }

    public void imprimeMao() {

        System.out.println("Suas cartas:");
        for (int i = 0; i < this.mao.size(); i++) {
            System.out.println(i+1 + " - " + this.mao.get(i).getCharValor() + " " + this.mao.get(i).getCharNaipe());
        }
    }

    public Carta jogarCarta(int carta) {

        switch (carta) {
            case 0:
                return this.mao.remove(0);

            case 1:
                return this.mao.remove(1);

            case 2:
                return this.mao.remove(2);

            default:
                return null;

        }
    }

}
