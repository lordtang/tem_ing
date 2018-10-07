package com.company;

public class circle {
    public int x, y;
    private int r;
    public int vx, vy;

    public circle(int x, int y, int r, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.r = r;

    }

    public int getR() {
        return r;
    }

    public void move(int minx,int miny, int maxx, int maxy){
        x += vx;
        y += vy;
        checkCollosion(minx,miny,maxx,maxy);
    }
    private void checkCollosion(int minx,int miny, int maxx, int maxy){
        if(x-r <minx){x = r;vx = -vx;}
        if(x + r >=maxx){x = maxx - r;vx = -vx;}
        if(y-r<miny){y = r; vy = -vy;}
        if(y+r>=maxy){y = maxy - r;vy = -vy;}
    }
}