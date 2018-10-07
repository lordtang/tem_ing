package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class AlgoFrame extends JFrame {
    private int canvasWidth,canvasHigth;
    public AlgoFrame(String title,int canvasWidth,int canvasHeight){
        super(title);
        this.canvasWidth  =  canvasWidth;
        this.canvasHigth = canvasHeight;


        AlogoCanvas canvas = new AlogoCanvas();
        setContentPane(canvas);
        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //设置默认窗口大小
    public AlgoFrame(String title){
        this(title,1024,768);
    }
    public int getCanvasWidth(){return  canvasWidth;}
    public int getCanvasHigth(){return  canvasHigth;}
    private circle[] circles;
    public void render(circle[] circles){
        this.circles = circles;
        repaint();
    }

    //创建画布类，用内部类实现
    private class AlogoCanvas extends JPanel{
        //打开双缓存机制
        public AlogoCanvas(){
            super(true);
        }
        @Override  //帮助检测下面的代码是否已经覆盖父类
        //绘制的上下文，底层和面板，具体绘制还得看g
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D)g;

            //抗锯齿
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);
            //具体绘制
            AlgoVisHelper.setStrokeWidth(g2d,1);
            AlgoVisHelper.setColor(g2d,Color.red);
            for(circle circle:circles){
                AlgoVisHelper.strokeCircle(g2d, circle.x, circle.y, circle.getR());
            }
        }

        }
        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth,canvasHigth);
        }
    }
