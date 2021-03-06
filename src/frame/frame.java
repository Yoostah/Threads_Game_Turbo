/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.Painter;
import javax.swing.UIDefaults;

/**
 *
 * @author Thulio
 */
public class frame extends javax.swing.JFrame {

    public int progresso_1;
    public int progresso_2;
    public int progresso_3;
    public int duracao;
    public int colocacao = 0;

    /**
     * Creates new form frame
     */
    public frame() {
        initComponents();
        resetar();
    }

    public void duracao(int dur) {
        jSlider_Corredor1.setMaximum(dur);
        jSlider_Corredor2.setMaximum(dur);
        jSlider_Corredor3.setMaximum(dur);

        duracao = dur;
    }

    public void mudarImagem(JLabel corredor_imagem, JLabel corredor_label, int i, JSlider slider, JLabel coloc, String n) {
        corredor_imagem.setLocation(20 + (69 * slider.getValue() / (duracao / 10)), corredor_imagem.getY());
        corredor_label.setText(Integer.toString(slider.getValue()));
        //System.out.println(corredor_imagem.getX()+" | "+n);
        if (corredor_imagem.getX() == 710){
            switch (n) {
                    case "1":
                        colocacao++;
                        //System.out.println("T1 - C"+ colocacao());
                        coloc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frame/imagens/"+colocacao()+".png")));
                        coloc.setVisible(true);
                        break;
                    case "2":
                        colocacao++;
                        //System.out.println("T2 - C"+ colocacao());
                        coloc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frame/imagens/"+colocacao()+".png")));
                        coloc.setVisible(true);
                        break;
                    case "3":
                        colocacao++;
                        //System.out.println("T3 - C"+ colocacao());
                        coloc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frame/imagens/"+colocacao()+".png")));
                        coloc.setVisible(true);
                        break;
                    default:
                        System.out.println("-");
                        break;
                }
            
        }

    }

    private int colocacao() {
        return colocacao;
    }

    public void resetar() {
        progresso_1 = 0;
        progresso_2 = 0;
        progresso_3 = 0;

        colocacao = 0;

        colocacao_3.setVisible(false);
        colocacao_1.setVisible(false);
        colocacao_2.setVisible(false);

        jSlider_Corredor1.setValue(0);
        jSlider_Corredor2.setValue(0);
        jSlider_Corredor3.setValue(0);

        jLblImagem_Corredor1.setLocation(20, 300);
        jLblImagem_Corredor2.setLocation(20, 440);
        jLblImagem_Corredor3.setLocation(20, 580);

        jLblSlider_Corredor1.setText("0");
        jLblSlider_Corredor2.setText("0");
        jLblSlider_Corredor3.setText("0");

    }

    private class Corrida implements Runnable {

        JLabel imagem;
        JLabel label;
        JLabel coloc;
        int pos;
        JSlider slider;
        String n = Thread.currentThread().getName();

        public Corrida(JLabel corredor_imagem, JLabel corredor_label, int Corredor_pos, JSlider slider, JLabel colocacao) {
            this.slider = slider;
            this.imagem = corredor_imagem;
            this.pos = Corredor_pos;
            this.label = corredor_label;
            this.coloc = colocacao;
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i <= duracao; i++) {
                    Thread.sleep((new Random().nextInt(100) + 1) * 1);
                    slider.setValue(i);
                    MudarImagem m = new MudarImagem(imagem, label, i, slider, coloc);
                    Thread t2 = new Thread(m, n);
                    t2.start();
                }

                if (jSlider_Corredor1.getValue() == duracao && jSlider_Corredor2.getValue() == duracao && jSlider_Corredor3.getValue() == duracao) {
                    jButton1.setEnabled(true);
                }
            } catch (InterruptedException ex) {

            }
        }

    }

    private class MudarImagem implements Runnable {

        JLabel imagem;
        JLabel label;
        JLabel coloc;
        int pos;
        JSlider slider;
        String n = Thread.currentThread().getName();

        public MudarImagem(JLabel corredor_imagem, JLabel corredor_label, int i, JSlider slider, JLabel colocacao) {
            this.label = corredor_label;
            this.imagem = corredor_imagem;
            this.coloc = colocacao;
            this.pos = i;
            this.slider = slider;
        }

        @Override
        public void run() {
            mudarImagem(imagem, label, pos, slider, coloc, n);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        colocacao_3 = new javax.swing.JLabel();
        colocacao_1 = new javax.swing.JLabel();
        colocacao_2 = new javax.swing.JLabel();
        jSlider_Corredor1 = new javax.swing.JSlider();
        jLblImagem_Corredor1 = new javax.swing.JLabel();
        jLblSlider_Corredor1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLblImagem_Corredor2 = new javax.swing.JLabel();
        jSlider_Corredor2 = new javax.swing.JSlider();
        jLblSlider_Corredor2 = new javax.swing.JLabel();
        jLblImagem_Corredor3 = new javax.swing.JLabel();
        jLblSlider_Corredor3 = new javax.swing.JLabel();
        jSlider_Corredor3 = new javax.swing.JSlider();
        ComboDuracao = new javax.swing.JComboBox<>();
        lblDuracao = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setMinimumSize(new java.awt.Dimension(916, 780));
        setPreferredSize(new java.awt.Dimension(916, 780));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(912, 780));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        colocacao_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frame/imagens/1.png"))); // NOI18N
        jPanel1.add(colocacao_3);
        colocacao_3.setBounds(870, 610, 35, 50);

        colocacao_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frame/imagens/1.png"))); // NOI18N
        jPanel1.add(colocacao_1);
        colocacao_1.setBounds(870, 340, 35, 50);

        colocacao_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frame/imagens/1.png"))); // NOI18N
        jPanel1.add(colocacao_2);
        colocacao_2.setBounds(870, 470, 35, 50);

        jSlider_Corredor1.setBackground(new java.awt.Color(51, 102, 255));
        jSlider_Corredor1.setForeground(new java.awt.Color(51, 102, 255));
        jSlider_Corredor1.setMaximum(1000);
        UIDefaults d = new UIDefaults();
        d.put("Slider:SliderTrack[Enabled].backgroundPainter", new Painter<JSlider>() {
            @Override
            public void paint(Graphics2D g, JSlider c, int w, int h) {
                int arc = 10;
                int trackHeight = 8;
                int trackWidth = w - 2;
                int fillTop = 4;
                int fillLeft = 1;

                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
                g.setStroke(new BasicStroke(1.5f));
                g.setColor(Color.GRAY);
                g.fillRoundRect(fillLeft, fillTop, trackWidth, trackHeight, arc, arc);

                int fillBottom = fillTop + trackHeight;
                int fillRight = xPositionForValue(
                    c.getValue(), c,
                    new Rectangle(fillLeft, fillTop, trackWidth, fillBottom - fillTop));

                g.setColor(Color.BLUE);
                g.fillRect(fillLeft + 1, fillTop + 1, fillRight - fillLeft, fillBottom - fillTop);

                g.setColor(Color.WHITE);
                g.drawRoundRect(fillLeft, fillTop, trackWidth, trackHeight, arc, arc);
            }
            //@see javax/swing/plaf/basic/BasicSliderUI#xPositionForValue(int value)

            protected int xPositionForValue(int value, JSlider slider, Rectangle trackRect) {
                int min = slider.getMinimum();
                int max = slider.getMaximum();
                int trackLength = trackRect.width;
                double valueRange = (double) max - (double) min;
                double pixelsPerValue = (double) trackLength / valueRange;
                int trackLeft = trackRect.x;
                int trackRight = trackRect.x + (trackRect.width - 1);
                int xPosition;

                xPosition = trackLeft;
                xPosition += Math.round(pixelsPerValue * ((double) value - min));

                xPosition = Math.max(trackLeft, xPosition);
                xPosition = Math.min(trackRight, xPosition);

                return xPosition;
            }
        });
        jSlider_Corredor1.putClientProperty("Nimbus.Overrides", d);
        jPanel1.add(jSlider_Corredor1);
        jSlider_Corredor1.setBounds(60, 410, 710, 26);

        jLblImagem_Corredor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frame/imagens/moto_1.png"))); // NOI18N
        jPanel1.add(jLblImagem_Corredor1);
        jLblImagem_Corredor1.setBounds(20, 300, 110, 110);

        jLblSlider_Corredor1.setBackground(new java.awt.Color(51, 102, 255));
        jLblSlider_Corredor1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLblSlider_Corredor1.setForeground(new java.awt.Color(255, 255, 255));
        jLblSlider_Corredor1.setText("0");
        jPanel1.add(jLblSlider_Corredor1);
        jLblSlider_Corredor1.setBounds(10, 410, 50, 30);

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CORRER!");
        jButton1.setBorder(null);
        jButton1.setMaximumSize(new java.awt.Dimension(89, 21));
        jButton1.setMinimumSize(new java.awt.Dimension(89, 21));
        jButton1.setOpaque(false);
        jButton1.setPreferredSize(new java.awt.Dimension(89, 21));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(680, 185, 170, 55);

        jLblImagem_Corredor2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frame/imagens/moto_2.png"))); // NOI18N
        jPanel1.add(jLblImagem_Corredor2);
        jLblImagem_Corredor2.setBounds(20, 440, 110, 110);

        jSlider_Corredor2.setBackground(new java.awt.Color(255, 0, 0));
        jSlider_Corredor2.setMaximum(1000);
        UIDefaults v = new UIDefaults();
        v.put("Slider:SliderTrack[Enabled].backgroundPainter", new Painter<JSlider>() {
            @Override
            public void paint(Graphics2D g, JSlider c, int w, int h) {
                int arc = 10;
                int trackHeight = 8;
                int trackWidth = w - 2;
                int fillTop = 4;
                int fillLeft = 1;

                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
                g.setStroke(new BasicStroke(1.5f));
                g.setColor(Color.GRAY);
                g.fillRoundRect(fillLeft, fillTop, trackWidth, trackHeight, arc, arc);

                int fillBottom = fillTop + trackHeight;
                int fillRight = xPositionForValue(
                    c.getValue(), c,
                    new Rectangle(fillLeft, fillTop, trackWidth, fillBottom - fillTop));

                g.setColor(Color.RED);
                g.fillRect(fillLeft + 1, fillTop + 1, fillRight - fillLeft, fillBottom - fillTop);

                g.setColor(Color.WHITE);
                g.drawRoundRect(fillLeft, fillTop, trackWidth, trackHeight, arc, arc);
            }
            //@see javax/swing/plaf/basic/BasicSliderUI#xPositionForValue(int value)

            protected int xPositionForValue(int value, JSlider slider, Rectangle trackRect) {
                int min = slider.getMinimum();
                int max = slider.getMaximum();
                int trackLength = trackRect.width;
                double valueRange = (double) max - (double) min;
                double pixelsPerValue = (double) trackLength / valueRange;
                int trackLeft = trackRect.x;
                int trackRight = trackRect.x + (trackRect.width - 1);
                int xPosition;

                xPosition = trackLeft;
                xPosition += Math.round(pixelsPerValue * ((double) value - min));

                xPosition = Math.max(trackLeft, xPosition);
                xPosition = Math.min(trackRight, xPosition);

                return xPosition;
            }
        });
        jSlider_Corredor2.putClientProperty("Nimbus.Overrides", v);
        jPanel1.add(jSlider_Corredor2);
        jSlider_Corredor2.setBounds(60, 550, 710, 26);

        jLblSlider_Corredor2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLblSlider_Corredor2.setForeground(new java.awt.Color(255, 255, 255));
        jLblSlider_Corredor2.setText("0");
        jPanel1.add(jLblSlider_Corredor2);
        jLblSlider_Corredor2.setBounds(10, 550, 50, 30);

        jLblImagem_Corredor3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frame/imagens/moto_3.png"))); // NOI18N
        jPanel1.add(jLblImagem_Corredor3);
        jLblImagem_Corredor3.setBounds(20, 580, 110, 110);

        jLblSlider_Corredor3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLblSlider_Corredor3.setForeground(new java.awt.Color(255, 255, 255));
        jLblSlider_Corredor3.setText("0");
        jPanel1.add(jLblSlider_Corredor3);
        jLblSlider_Corredor3.setBounds(10, 690, 50, 30);

        jSlider_Corredor3.setBackground(new java.awt.Color(0, 204, 51));
        jSlider_Corredor3.setMaximum(1000);
        UIDefaults e = new UIDefaults();
        e.put("Slider:SliderTrack[Enabled].backgroundPainter", new Painter<JSlider>() {
            @Override
            public void paint(Graphics2D g, JSlider c, int w, int h) {
                int arc = 10;
                int trackHeight = 8;
                int trackWidth = w - 2;
                int fillTop = 4;
                int fillLeft = 1;

                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
                g.setStroke(new BasicStroke(1.5f));
                g.setColor(Color.GRAY);
                g.fillRoundRect(fillLeft, fillTop, trackWidth, trackHeight, arc, arc);

                int fillBottom = fillTop + trackHeight;
                int fillRight = xPositionForValue(
                    c.getValue(), c,
                    new Rectangle(fillLeft, fillTop, trackWidth, fillBottom - fillTop));

                g.setColor(Color.GREEN);
                g.fillRect(fillLeft + 1, fillTop + 1, fillRight - fillLeft, fillBottom - fillTop);

                g.setColor(Color.WHITE);
                g.drawRoundRect(fillLeft, fillTop, trackWidth, trackHeight, arc, arc);
            }
            //@see javax/swing/plaf/basic/BasicSliderUI#xPositionForValue(int value)

            protected int xPositionForValue(int value, JSlider slider, Rectangle trackRect) {
                int min = slider.getMinimum();
                int max = slider.getMaximum();
                int trackLength = trackRect.width;
                double valueRange = (double) max - (double) min;
                double pixelsPerValue = (double) trackLength / valueRange;
                int trackLeft = trackRect.x;
                int trackRight = trackRect.x + (trackRect.width - 1);
                int xPosition;

                xPosition = trackLeft;
                xPosition += Math.round(pixelsPerValue * ((double) value - min));

                xPosition = Math.max(trackLeft, xPosition);
                xPosition = Math.min(trackRight, xPosition);

                return xPosition;
            }
        });
        jSlider_Corredor3.putClientProperty("Nimbus.Overrides", e);
        jPanel1.add(jSlider_Corredor3);
        jSlider_Corredor3.setBounds(60, 690, 710, 26);

        ComboDuracao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "( Selecione a duração )", "10 METROS", "100 METROS", "1000 METROS" }));
        ComboDuracao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboDuracaoItemStateChanged(evt);
            }
        });
        jPanel1.add(ComboDuracao);
        ComboDuracao.setBounds(20, 40, 190, 20);

        lblDuracao.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblDuracao.setForeground(new java.awt.Color(255, 255, 255));
        lblDuracao.setText("DURAÇÃO DA CORRIDA:");
        jPanel1.add(lblDuracao);
        lblDuracao.setBounds(20, 20, 210, 18);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frame/imagens/bg.png"))); // NOI18N
        jPanel1.add(bg);
        bg.setBounds(0, 0, 910, 750);

        jPanel1.setBackground(Color.DARK_GRAY);
        jPanel1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 910, 750);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (ComboDuracao.getSelectedIndex() != 0) {
            jButton1.setEnabled(false);
            resetar();
            Corrida c1 = new Corrida(jLblImagem_Corredor1, jLblSlider_Corredor1, progresso_1, jSlider_Corredor1, colocacao_1);
            Corrida c2 = new Corrida(jLblImagem_Corredor2, jLblSlider_Corredor2, progresso_2, jSlider_Corredor2, colocacao_2);
            Corrida c3 = new Corrida(jLblImagem_Corredor3, jLblSlider_Corredor3, progresso_3, jSlider_Corredor3, colocacao_3);
            Thread t1 = new Thread(c1, "1");
            Thread t2 = new Thread(c2, "2");
            Thread t3 = new Thread(c3, "3");
            t1.start();
            t2.start();
            t3.start();
        } else {
            JOptionPane.showMessageDialog(this, "Escolha a duração da corrida !!!");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void ComboDuracaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboDuracaoItemStateChanged
        switch (ComboDuracao.getSelectedIndex()) {
            case 1:
                resetar();
                duracao(10);
                break;
            case 2:
                resetar();
                duracao(100);
                break;
            case 3:
                resetar();
                duracao(1000);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_ComboDuracaoItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboDuracao;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel colocacao_1;
    private javax.swing.JLabel colocacao_2;
    private javax.swing.JLabel colocacao_3;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLblImagem_Corredor1;
    private javax.swing.JLabel jLblImagem_Corredor2;
    private javax.swing.JLabel jLblImagem_Corredor3;
    private javax.swing.JLabel jLblSlider_Corredor1;
    private javax.swing.JLabel jLblSlider_Corredor2;
    private javax.swing.JLabel jLblSlider_Corredor3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlider_Corredor1;
    private javax.swing.JSlider jSlider_Corredor2;
    private javax.swing.JSlider jSlider_Corredor3;
    private javax.swing.JLabel lblDuracao;
    // End of variables declaration//GEN-END:variables
}
