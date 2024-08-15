package truco;

public class Carta {

    private final int naipe;
    private final int valor;

    public Carta(int naipe, int valor) {
        this.naipe = naipe;
        this.valor = valor;
    }

    public int getNaipe() {
        return naipe;
    }

    public int getValor() {
        return valor;
    }

    public char getCharNaipe() {
        switch (this.naipe){
            case 1:
                return '♦';
            case 2:
                return '♠';
            case 3:
                return '♥';
            case 4:
                return '♣';
            default:
                return 'x';
        }
    }

    public char getCharValor() {

        switch (this.valor) {
            case 1:
                return '4';
            case 2:
                return '5';
            case 3:
                return '6';
            case 4:
                return '7';
            case 5:
                return 'Q';
            case 6:
                return 'J';
            case 7:
                return 'K';
            case 8:
                return 'A';
            case 9:
                return '2';
            case 10:
                return '3';
            default:
                return 'x';

        }
    }


}
