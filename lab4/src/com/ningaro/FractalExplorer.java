package com.ningaro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

public class FractalExplorer {

    private int windowWidth;
    private int windowHeight;

    private JImageDisplay updateDisplay;
    private FractalGenerator gen;
    private Rectangle2D.Double range;


    public FractalExplorer(int w, int h){
        windowWidth = w;
        windowHeight = h;
        gen = new Mandelbrot();
        range = new Rectangle2D.Double();
        gen.getInitialRange(range);

    }

    private void createAndShowGUI(){
        JFrame myFrame = new JFrame("Визуалиация фрактала");
        updateDisplay = new JImageDisplay(windowWidth, windowHeight);
        JButton myBtn = new JButton("Сборос приближения");

        myBtn.setActionCommand("reset");
        myBtn.addActionListener(new MyActionListener());

        myFrame.getContentPane().add(updateDisplay, BorderLayout.CENTER);
        myFrame.getContentPane().add(myBtn, BorderLayout.SOUTH);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Выход из приложения при закрытие

        myFrame.getContentPane().addMouseListener(new MyMouseListener());

        myFrame.pack ();
        myFrame.setVisible (true);
        myFrame.setResizable (false);
    }

    private void drawFractal (){
        for (int x = 0; x < windowWidth; x++) {
            for (int y = 0; y < windowHeight; y++) {
                double xCoord = gen.getCoord(range.x, range.x + range.width, windowWidth, x);
                double yCoord = gen.getCoord(range.y, range.y + range.width, windowWidth, y);

                double numIters = gen.numIterations(xCoord, yCoord);

                int rgbColor = 0;
                if (numIters != -1){
                    float hue = 0.7f + (float) numIters / 200f;
                    rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                }

                updateDisplay.drawPixel(x, y, rgbColor);
                updateDisplay.repaint();
            }
        }

    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() == "reset") {
                gen.getInitialRange(range);
                drawFractal();

            }
        }
    }

    public class MyMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            double xCoord = gen.getCoord(range.x, range.x + range.width, windowWidth, e.getX());
            double yCoord = gen.getCoord(range.y, range.y + range.height, windowWidth, e.getY());
            gen.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            drawFractal();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public static void main(String[] args) {
        FractalExplorer MainExploer = new FractalExplorer(600,600);
        MainExploer.createAndShowGUI();
        MainExploer.drawFractal();

    }
}
