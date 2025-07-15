import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class PainelCorrida extends JPanel {
    private Cavalo[] cavalos;

    public PainelCorrida(Cavalo[] cavalos) {
        this.cavalos = cavalos;
        this.setBackground(new Color(34, 139, 34));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        for (int i = 0; i <= cavalos.length; i++) {
            int y = 60 + i * 60;
            g.drawLine(10, y, CorridaCavalosSwing.LARGURA_PISTA + 50, y);
        }

        g.setColor(Color.BLACK);
        g.fillRect(CorridaCavalosSwing.LARGURA_PISTA, 60, 5, cavalos.length * 60);

        for (int i = 0; i < cavalos.length; i++) {
            Cavalo cavalo = cavalos[i];
            g.setColor(cavalo.getCor());
            int y = 75 + i * 60;
            int x = cavalo.getPosicao();

            g.fillOval(x, y, 30, 30);

            g.setColor(Color.BLACK);
            g.drawString(cavalo.getNome(), x + 35, y + 20);
        }
    }
}