package com.company;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 10;
        circle[] circles = new circle[N];
        int R = 50;
        for(int i = 0; i<N; i++)
        {
            int x = (int)(Math.random()*(sceneWidth-2* R))+R;
            int y = (int)(Math.random()*(sceneHeight-2*R))+R;
            int vx = (int)(Math.random()*11)-5;  //生成从-5 -到 +5的随机数
            int vy = (int)(Math.random()*11)-5;
            circles[i] = new circle(x,y,R,vx,vy);
        }
        EventQueue.invokeLater(()->{
           AlgoFrame frame = new AlgoFrame("welcome",sceneWidth,sceneHeight);
           new Thread(()->{
               while(true){
                   //绘制数据
                   frame.render(circles);
                   AlgoVisHelper.Pause(20);
                   //更新数据
                   for(circle circle:circles)
                       circle.move(0, 0, sceneWidth, sceneHeight);
               }
           }).start();
        });
    }
}
