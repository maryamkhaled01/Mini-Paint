/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author LENOVO
 */
public class Rectangle extends AbstractShapeClass{
    private int width;
    private int height;
    private int[] xPoints = new int[4]; 
    private int[] yPoints = new int[4];
    //private Point point2 = new Point(getPosition().x+width, getPosition().y);
    //private Point point3 = new Point(getPosition().x+width, getPosition().y+height);
    //private Point point4 = new Point(getPosition().x, getPosition().y+height);
    
    
    public Rectangle(Point position, int width, int height){
        super(position);
        this.width = width;
        this.height = height;
        int[] xPoints = {this.getPosition().x, this.getPosition().x+width, this.getPosition().x+width, this.getPosition().x};
        int[] yPoints = {this.getPosition().y, this.getPosition().y, this.getPosition().y+height, this.getPosition().y+height};
        this.setXPoints(xPoints);
        this.setYPoints(yPoints);
    }
    
    public void setXPoints(int[] xPoints){
        this.xPoints = xPoints;
    }
    public void setYPoints(int[] yPoints){
        this.yPoints = yPoints;
    }
    public int[] getXPoints(){
        return this.xPoints;
    }
    public int[] getYPoints(){
        return this.yPoints;
    }
    
    @Override
    public void setPosition(Point Position){
        super.setPosition(Position);
        int[] xPoints = {this.getPosition().x, this.getPosition().x+width, this.getPosition().x+width, this.getPosition().x};
        int[] yPoints = {this.getPosition().y, this.getPosition().y, this.getPosition().y+height, this.getPosition().y+height};
        this.setXPoints(xPoints);
        this.setYPoints(yPoints);
    }
    
    @Override
    public void draw(Graphics canvas) {
        //int x = getPosition().x;
        //int y = getPosition().y;
        //int[] xPoints = {getPosition().x, getPosition().x+width, getPosition().x+width, getPosition().x};
        //int[] yPoints = {getPosition().y, getPosition().y, getPosition().y+height, getPosition().y+height};      
        canvas.setColor(getFillColor());
        canvas.fillPolygon(getXPoints(), getYPoints(), 4);
        //canvas.fillRect(getPosition().x, getPosition().y, width, height);
        canvas.setColor(getColor());
        canvas.drawPolygon(getXPoints(), getYPoints(), 4);
        //canvas.drawRect(getPosition().x, getPosition().y, width, height);
    }

    @Override
    public boolean contains(Point point) {
        Point position = getPosition();
        java.awt.Rectangle r = new java.awt.Rectangle();
        r.setLocation(position);
        r.setSize(width, height);
        return r.contains(point);
    }

    @Override
    public void moveTo(Point point) {
        int x = getDraggingPoint().x;
        int y = getDraggingPoint().y;
        int xdifference = point.x - x;
        int ydifference = point.y - y;
        setPosition(new Point(getPosition().x + xdifference, getPosition().y+ ydifference));
    }

    /*@Override
    public Shape copy() {
        Rectangle r = new Rectangle(this.getPosition(), this.width, this.height);
        r.setColor(this.getColor());
        r.setFillColor(this.getFillColor());
        return r;
    } */

    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
         return height;
    }
    
    /*@Override
    public void saveToJsonFile(int i, JSONObject obj){
         JSONArray rect = new JSONArray();
         rect.add(this);
         rect.add(getPosition());
         rect.add(width);
         rect.add(height);
         rect.add(getColor());
         rect.add(getFillColor());
         obj.put(i, rect);
    }*/
    
    @Override
    public void drawCorners(Graphics canvas) {
        int x = getPosition().x;
        int y = getPosition().y;
        canvas.setColor(Color.black);
        canvas.drawRect(x-5, y-5, 10, 10);
        canvas.fillRect(x-5, y-5, 10, 10);
        canvas.drawRect(x+width-5, y-5, 10, 10);
        canvas.fillRect(x+width-5, y-5, 10, 10);
        canvas.drawRect(x-5, y+height-5, 10, 10);
        canvas.fillRect(x-5, y+height-5, 10, 10);
        canvas.drawRect(x+width-5, y+height-5, 10, 10);
        canvas.fillRect(x+width-5, y+height-5, 10, 10);
    }
    
    public boolean URCorners(Point p) {
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(x + width - 5, y - 5, 10, 10);
        return r.contains(p.x, p.y);
    }

    public boolean ULCorners(Point p) {
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(x - 5, y - 5, 10, 10);
        return r.contains(p.x, p.y);
    }
    
    public boolean LLCorners(Point p) {
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(x - 5, y+height - 5, 10, 10);
        return r.contains(p.x, p.y);
    }
    
    public boolean LRCorners(Point p) {
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(x+width - 5, y+height - 5, 10, 10);
        return r.contains(p.x, p.y);
    }
    
    /*@Override
    public void resize(Point point) {
        int x1 = getPosition().x;
        int y1 = getPosition().y;
        int x2 = point.x;
        int y2 = point.y;
        if(ULCorners(getDraggingPoint())){
            if (x1 >= x2 && y1 >= y2) {
                width = width + Math.abs(x1 - x2);
                height = height + Math.abs(y1 - y2);
                setPosition(point);
            } 
            else if (x1 <= x2 && y1 <= y2) {
                width = width - Math.abs(x1 - x2);
                height = height - Math.abs(y1 - y2);
                setPosition(point);
            }
            else if(x2 <= x1 && y2 >= y1){
                width = width + Math.abs(x1 - x2);
                height = height - Math.abs(y1 - y2);
                setPosition(point);
            }
            else if(x2 >= x1 && y2 <= y1){
                width = width - Math.abs(x1 - x2);
                height = height + Math.abs(y1 - y2);
                setPosition(point);
            }
        }
        else if(URCorners(getDraggingPoint())){
            
            if (x1+width >= x2 && y1 >= y2) {
                width = width - Math.abs(x1+width - x2);
                height = height + Math.abs(y1 - y2);
                //System.out.println(x2+" "+y2);
                //xPoints[1] = x2;
                //yPoints[1] = y2;
                
                setPosition(point);
                //point2 = point;
            } 
            else if (x1+width <= x2 && y1 <= y2) {
                width = width + Math.abs(x1+width - x2);
                height = height - Math.abs(y1 - y2);
                
                xPoints[1] = x2;
                yPoints[1] = y2;
                //setPosition(point);
                //point2 = point;
            }
            else if(x2 <= x1+width && y2 >= y1){
                width = width - Math.abs(x1+width - x2);
                height = height + Math.abs(y1 - y2);
                
                xPoints[1] = x2;
                yPoints[1] = y2;
                //setPosition(point);
                //point2 = point;
            }
            else if(x2 >= x1+width && y2 <= y1){
                width = width + Math.abs(x1+width - x2);
                height = height - Math.abs(y1 - y2);
                
                xPoints[1] = x2;
                yPoints[1] = y2;
                //setPosition(point);
                //point2 = point;
            }
        }
        else if(LLCorners(getDraggingPoint())){
            if (x1 >= x2 && y1+height >= y2) {
                width = width + Math.abs(x1 - x2);
                height = height - Math.abs(y1+height - y2);
                xPoints[3] = x2;
                yPoints[3] = y2;
                //point4 = point;
            } 
            else if (x1 <= x2 && y1+height <= y2) {
                width = width - Math.abs(x1 - x2);
                height = height + Math.abs(y1+height - y2);
                xPoints[3] = x2;
                yPoints[3] = y2;
                //point4 = point;
            }
            else if(x2 <= x1 && y2 >= y1+height){
                width = width + Math.abs(x1 - x2);
                height = height + Math.abs(y1+height - y2);
                xPoints[3] = x2;
                yPoints[3] = y2;
                //point4 = point;
            }
            else if(x2 >= x1 && y2 <= y1+height){
                width = width - Math.abs(x1 - x2);
                height = height - Math.abs(y1+height - y2);
                xPoints[3] = x2;
                yPoints[3] = y2;
                //point4 = point;
            }
        }
        else if(LRCorners(getDraggingPoint())){
            if (x1+width >= x2 && y1+height >= y2) {
                width = width - Math.abs(x1+width - x2);
                height = height - Math.abs(y1+height - y2);
                xPoints[2] = x2;
                yPoints[2] = y2;
                //point3 = point;
            } 
            else if (x1+width <= x2 && y1+height <= y2) {
                width = width + Math.abs(x1+width - x2);
                height = height + Math.abs(y1+height - y2);
                xPoints[2] = x2;
                yPoints[2] = y2;
                //point3 = point;
            }
            else if(x2 <= x1+width && y2 >= y1+height){
                width = width - Math.abs(x1+width - x2);
                height = height + Math.abs(y1+height - y2);
                xPoints[2] = x2;
                yPoints[2] = y2;
                //point3 = point;
            }
            else if(x2 >= x1+width && y2 <= y1+height){
                width = width + Math.abs(x1+width - x2);
                height = height - Math.abs(y1+height - y2);
                xPoints[2] = x2;
                yPoints[2] = y2;
                //point3 = point;
            }
        }
    }*/
    
    @Override
    public void resize(Point point) {
        int x1 = getPosition().x;
        int y1 = getPosition().y;
        int x2 = point.x;
        int y2 = point.y;
        int lly = y1+height;
        int urx = x1+width;
        if(ULCorners(getDraggingPoint())){
            if (x1 >= x2 && y1 >= y2) {
                width = width + Math.abs(x1 - x2);
                height = height + Math.abs(y1 - y2);
            }
            else if (x1 <= x2 && y1 <= y2) {
                width = width - Math.abs(x1 - x2);
                height = height - Math.abs(y1 - y2);
            }
            else if(x2 <= x1 && y2 >= y1){
                width = width + Math.abs(x1 - x2);
                height = height - Math.abs(y1 - y2);
            }
            else if(x2 >= x1 && y2 <= y1){
                width = width - Math.abs(x1 - x2);
                height = height + Math.abs(y1 - y2);
            }
            setPosition(point);
        }
        else if(URCorners(getDraggingPoint())){
            if (urx > x2 && y1 > y2) { // x dec y dec
                width = width - Math.abs(urx - x2);
                height = height + Math.abs(y1 - y2);
                //point2 = point;
            } 
            else if (urx <= x2 && y1 <= y2) { // x inc y inc
                width = width + Math.abs(urx - x2);
                height = height - Math.abs(y1 - y2);
                //point2 = point;
            }
            else if(x2 < urx && y2 >= y1){ // x dec y inc
                width = width - Math.abs(urx - x2);
                height = height - Math.abs(y1 - y2);
                //point2 = point;
            }
            else if(x2 >= urx && y2 < y1){ // x inc y dec
                width = width + Math.abs(urx - x2);
                height = height + Math.abs(y1 - y2);
                //point2 = point;
            }
            xPoints[1] = x2;
            yPoints[1] = y2;
            xPoints[2] = x2;
            setPosition(new Point(x1,y2));
        }
        else if(LLCorners(getDraggingPoint())){
            if (x1 >= x2 && lly >= y2) {
                width = width + Math.abs(x1 - x2);
                height = height - Math.abs(lly - y2);
                //point4 = point;
            } 
            else if (x1 <= x2 && lly <= y2) {
                width = width - Math.abs(x1 - x2);
                height = height + Math.abs(lly - y2);
                //point4 = point;
            }
            else if(x2 <= x1 && y2 >= lly){
                width = width + Math.abs(x1 - x2);
                height = height + Math.abs(lly - y2);
                //point4 = point;
            }
            else if(x2 >= x1 && y2 <= lly){
                width = width - Math.abs(x1 - x2);
                height = height - Math.abs(lly - y2);
                //point4 = point;
            }
            xPoints[3] = x2;
            yPoints[3] = y2;
            yPoints[2] = y2;
            setPosition(new Point(x2, y1));
        }
        else if(LRCorners(getDraggingPoint())){
            if (urx >= x2 && lly >= y2) {
                width = width - Math.abs(urx - x2);
                height = height - Math.abs(lly - y2);
                //point3 = point;
            } 
            else if (urx <= x2 && lly <= y2) {
                width = width + Math.abs(urx - x2);
                height = height + Math.abs(lly - y2);
                //point3 = point;
            }
            else if(x2 <= urx && y2 >= lly){
                width = width - Math.abs(urx - x2);
                height = height + Math.abs(lly - y2);
                //point3 = point;
            }
            else if(x2 >= urx && y2 <= lly){
                width = width + Math.abs(urx - x2);
                height = height - Math.abs(lly - y2);
                //point3 = point;
            }
            xPoints[2] = x2;
            yPoints[2] = y2;
            xPoints[1] = x2;
            yPoints[3] = y2;
        }
    }
    
    /*public void resize(Point p) {
        int x1 = getDraggingPoint().x;
        int y1 = getDraggingPoint().y;
        int x2 = p.x;
        int y2 = p.y;
        if (ULCorners(getDraggingPoint())) {
            width = width + x1 - x2;
            height = height + y1 - y2;
            setPosition(new Point(getPosition().x + x2 - x1,getPosition().y + y2 - y1));
            //getPosition().x = getPosition().x + x2 - x1;
            //getPosition().y = getPosition().y + y2 - y1;
        } else if (URCorners(getDraggingPoint())) {
            width = width + x2 - x1;
            height = height + y1 - y2;
            setPosition(new Point(getPosition().x, getPosition().y + y2 - y1));
            //getPosition().y = getPosition().y + y2 - y1;
        } else if (LLCorners(getDraggingPoint())) {
            width = width + x1 - x2;
            height = height + y2 - y1;
            setPosition(new Point(x2, getPosition().y));
            //getPosition().x = x2;
        } else if (LRCorners(getDraggingPoint())) {
            width = width - x1 + x2;
            height = height + y2 - y1;
        }
        if (width < 0) {
            width = -1 * width;
            setPosition(new Point(getPosition().x - width, getPosition().y));
            //getPosition().x -= width;
        }
        if (height < 0) {
            height = -1 * height;
            setPosition(new Point(getPosition().x, getPosition().y-height));
            //getPosition().y -= height;
        }
    }*/
    
    /*@Override
    public void setIsSelected(boolean isSelected) {
       /* if(point.x <= getPosition().x-10 && point.y <= getPosition().y-10)
            return true;
        else if(point.x <= getPosition().x-10 && point.y >= getPosition().y+height+10)
            return true;
        else if(point.x >= getPosition().x+width+10 && point.y <= getPosition().y-10)
            return true;
        else if(point.x >= getPosition().x+width+10 && point.y >= getPosition().y+height+10)
            return true;
        else return false;
            
    }

    

    @Override
    public Point[] getCornerPoints() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    @Override
    public boolean getIsSelected() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean inResizeRange(Point point) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
    
    
}
