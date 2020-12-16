package com.ningaro;

import javax.swing.JComponent;
import java.awt.*;
import java.awt.image.BufferedImage;


public class JImageDisplay extends JComponent {
    private BufferedImage img;
    public JImageDisplay (int w, int h){
        img = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        setPreferredSize(new Dimension(w,h));
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage (img, 0, 0, img.getWidth(), img.getHeight(), null);
    }
    public void clearImage() {
        for (int i = 0; i < img.getWidth(); i++){
            for (int j = 0;j< img.getHeight();j++){
                drawPixel(i,j,0);
            }
        }
    }
    public void drawPixel(int x, int y, int rgbColor){
        img.setRGB(x,y,rgbColor);
    }
}
