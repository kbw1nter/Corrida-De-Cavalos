import javax.swing.*;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

public class CorridaCavalosSwing {
    public static final int LARGURA_PISTA = 1000;
    public static volatile boolean corridaTerminou = false;

    private static final int NUM_CAVALOS = 5;
    private static Cavalo vencedor = null;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Corrida de Cavalos com Threads");
        frame.setSize(LARGURA_PISTA + 100, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Cavalo[] cavalos = new Cavalo[NUM_CAVALOS];
        cavalos[0] = new Cavalo("Alazão", Color.RED);
        cavalos[1] = new Cavalo("Trovão", Color.BLUE);
        cavalos[2] = new Cavalo("Estrela", Color.GREEN);
        cavalos[3] = new Cavalo("Fúria", Color.ORANGE);
        cavalos[4] = new Cavalo("Campeão", Color.MAGENTA);

        PainelCorrida painel = new PainelCorrida(cavalos);
        frame.add(painel);

        frame.setVisible(true);

        for (Cavalo cavalo : cavalos) {
            new Thread(cavalo).start();
        }

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(() -> painel.repaint());
                if (corridaTerminou) {
                    timer.cancel();
                }
            }
        }, 0, 60);
    }

    public static synchronized void declararVencedor(Cavalo cavalo) {
        if (!corridaTerminou) {
            corridaTerminou = true;
            vencedor = cavalo;
            SwingUtilities.invokeLater(() -> {
                JOptionPane.showMessageDialog(null, "O vencedor é " + vencedor.getNome() + "!", "Fim da Corrida", JOptionPane.INFORMATION_MESSAGE);
            });
        }
    }
}