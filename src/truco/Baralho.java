package truco;

import java.util.*;

public class Baralho {

    Stack<Carta> cartas = new Stack<>();

    public Baralho() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 4; j++) {
                this.cartas.push(new Carta(j, i));
            }
        }
        Collections.shuffle(cartas);

    }

    public List<Carta> darCartas(){

        List<Carta> mao = new ArrayList<>();

        mao.add(this.cartas.pop());
        mao.add(this.cartas.pop());
        mao.add(this.cartas.pop());

        return mao;

    }



}
