import java.awt.Color;
import java.util.Random;

public class Cavalo implements Runnable {
    private static final int DISTANCIA_TOTAL = CorridaCavalosSwing.LARGURA_PISTA;
    private static final int INTERVALO_ATUALIZACAO = 100;

    private String nome;
    private int posicao;
    private Random random;
    private Color cor;

    public Cavalo(String nome, Color cor) {
        this.nome = nome;
        this.posicao = 0;
        this.random = new Random();
        this.cor = cor;
    }

    @Override
    public void run() {
        while (posicao < DISTANCIA_TOTAL && !CorridaCavalosSwing.corridaTerminou) {
            int avanco = random.nextInt(10) + 1;
            posicao += avanco;

            try {
                Thread.sleep(INTERVALO_ATUALIZACAO);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }

        if (posicao >= DISTANCIA_TOTAL) {
            CorridaCavalosSwing.declararVencedor(this);
        }
    }

    public int getPosicao() {
        return posicao;
    }

    public Color getCor() {
        return cor;
    }

    public String getNome() {
        return nome;
    }
}