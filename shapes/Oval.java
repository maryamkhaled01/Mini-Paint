/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author LENOVO
 */
public class Oval extends AbstractShapeClass{
    private int verticalRadius, horizontalRadius;
    private int[] xPoints = new int[4]; 
    private int[] yPoints = new int[4];
    
    public Oval(Point position, int verticalRadius, int horizontalRadius){
        super(position);
        this.verticalRadius = verticalRadius;
        this.horizontalRadius = horizontalRadius;
        int[] xPoints = {this.getPosition().x, this.getPosition().x+2*horizontalRadius, this.getPosition().x+2*horizontalRadius, this.getPosition().x};
        int[] yPoints = {this.getPosition().y, this.getPosition().y, this.getPosition().y+2*verticalRadius, this.getPosition().y+2*verticalRadius};
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
        int[] xPoints = {this.getPosition().x, this.getPosition().x+2*horizontalRadius, this.getPosition().x+2*horizontalRadius, this.getPosition().x};
        int[] yPoints = {this.getPosition().y, this.getPosition().y, this.getPosition().y+2*verticalRadius, this.getPosition().y+2*verticalRadius};
        this.setXPoints(xPoints);
        this.setYPoints(yPoints);
    }
    
    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(getFillColor());
        //canvas.fillOval(getPosition().x, getPosition().y, xPoints[1]-xPoints[0], yPoints[3]-yPoints[0]);
        canvas.fillOval(xPoints[0], yPoints[0], 2*horizontalRadius, 2*verticalRadius);
        canvas.setColor(getColor());
        //canvas.drawOval(xPoints[0], yPoints[0], xPoints[1]-xPoints[0], yPoints[3]-yPoints[0]); 
        canvas.drawOval(xPoints[0], yPoints[0], 2*horizontalRadius, 2*verticalRadius);
    }

    @Override
    public boolean contains(Point point) {
       int xCentre = getPosition().x+horizontalRadius;
       int yCentre = getPosition().y+verticalRadius;
       return ((point.x-xCentre)*(point.x-xCentre))/(horizontalRadius*horizontalRadius) + 
               ((point.y-yCentre)*(point.y-yCentre))/(verticalRadius*verticalRadius) <= 1;
    }

    @Override
    public void moveTo(Point point) {
        int xDifference = point.x-getDraggingPoint().x;
        int yDifference = point.y-getDraggingPoint().y;
        setPosition(new Point(getPosition().x+xDifference, getPosition().y+yDifference));
    }

    public int getVerticalRadius(){
        return verticalRadius;
    }
    
    public int getHorizontalRadius(){
        return horizontalRadius;
    }
    
    /*@Override
    public void saveToJsonFile(int i, JSONObject obj){
         JSONArray oval = new JSONArray();
         oval.add(this);
         oval.add(getPosition());
         oval.add(verticalRadius);
         oval.add(horizontalRadius);
         oval.add(getColor());
         oval.add(getFillColor());
         obj.put(i, oval);
    }*/
    
    public boolean URCorners(Point p) {
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(x + 2*horizontalRadius - 5, y - 5, 10, 10);
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
        java.awt.Rectangle r = new java.awt.Rectangle(x - 5, y+2*verticalRadius- 5, 10, 10);
        return r.contains(p.x, p.y);
    }
    
    public boolean LRCorners(Point p) {
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(x+2*horizontalRadius - 5, y+2*verticalRadius - 5, 10, 10);
        return r.contains(p.x, p.y);
    }
    
    @Override
    public void resize(Point point) {
        int x1 = getPosition().x;
        int y1 = getPosition().y;
        //int x1 = xPoints[0];
        //int y1 = yPoints[0];
        int x2 = point.x;
        int y2 = point.y;
        int lly = y1+2*verticalRadius;
        int urx = x1+2*horizontalRadius;
        int vD = 2*verticalRadius;
        int hD = 2*horizontalRadius;
        if(ULCorners(getDraggingPoint())){
            int xDiff = x1 - x2;
            int yDiff = y1 - y2;
            hD = hD + xDiff;
            vD = vD + yDiff;
            verticalRadius = vD/2;
            horizontalRadius = hD/2;
            /*if (x1 >= x2 && y1 >= y2) {
                horizontalRadius = horizontalRadius + Math.abs(x1 - x2)/2;
                verticalRadius = verticalRadius + Math.abs(y1 - y2)/2;
            } 
            else if (x1 <= x2 && y1 <= y2) {
                horizontalRadius = horizontalRadius - Math.abs(x1 - x2)/2;
                verticalRadius = verticalRadius - Math.abs(y1 - y2)/2;
            }
            else if(x2 <= x1 && y2 >= y1){
                horizontalRadius = horizontalRadius + Math.abs(x1 - x2)/2;
                verticalRadius = verticalRadius - Math.abs(y1 - y2)/2;
            }
            else if(x2 >= x1 && y2 <= y1){
                horizontalRadius = horizontalRadius - Math.abs(x1 - x2)/2;
                verticalRadius = verticalRadius + Math.abs(y1 - y2)/2;
            }*/
            setPosition(new Point(this.getPosition().x - xDiff, this.getPosition().y - yDiff));
        }
        else if(URCorners(getDraggingPoint())){
            if (urx > x2 && y1 > y2) {
                horizontalRadius = horizontalRadius - Math.abs(urx - x2)/2;
                verticalRadius = verticalRadius + Math.abs(y1 - y2)/2;
            } 
            else if (urx <= x2 && y1 <= y2) {
                horizontalRadius = horizontalRadius + Math.abs(urx - x2)/2;
                verticalRadius = verticalRadius - Math.abs(y1 - y2)/2;
            }
            else if(x2 < urx && y2 >= y1){
                horizontalRadius = horizontalRadius - Math.abs(urx - x2)/2;
                verticalRadius = verticalRadius - Math.abs(y1 - y2)/2;
            }
            else if(x2 >= urx && y2 < y1){
                horizontalRadius = horizontalRadius + Math.abs(urx - x2)/2;
                verticalRadius = verticalRadius + Math.abs(y1 - y2)/2;
            }
            xPoints[1] = x2;
            yPoints[1] = y2;
            xPoints[2] = x2;
            setPosition(new Point(x1,y2));
        }
        else if(LLCorners(getDraggingPoint())){
            if (x1 >= x2 && lly >= y2) {
                horizontalRadius = horizontalRadius + Math.abs(x1 - x2)/2;
                verticalRadius = verticalRadius - Math.abs(lly - y2)/2;
            } 
            else if (x1 <= x2 && lly <= y2) {
                horizontalRadius = horizontalRadius - Math.abs(x1 - x2)/2;
                verticalRadius = verticalRadius + Math.abs(lly - y2)/2;
            }
            else if(x2 <= x1 && y2 >= lly){
                horizontalRadius = horizontalRadius + Math.abs(x1 - x2)/2;
                verticalRadius = verticalRadius + Math.abs(lly - y2)/2;
            }
            else if(x2 >= x1 && y2 <= lly){
                horizontalRadius = horizontalRadius - Math.abs(x1 - x2)/2;
                verticalRadius = verticalRadius - Math.abs(lly - y2)/2;
            }
            xPoints[3] = x2;
            yPoints[3] = y2;
            yPoints[2] = y2;
            //xPoints[0] = x2;
            //yPoints[0] = y1;
            xPoints[0] = x2;
            setPosition(new Point(x1, y1));
            //System.out.println(xPoints[1]+" "+yPoints[1]);
            //xPoints[1] = xPoints[0]+2*horizontalRadius;
            //yPoints[1] = y1+2*verticalRadius;
        }
        else if(LRCorners(getDraggingPoint())){
            if (urx >= x2 && lly >= y2) {
                horizontalRadius = horizontalRadius - Math.abs(urx - x2)/2;
                verticalRadius = verticalRadius - Math.abs(lly - y2)/2;
            } 
            else if (urx <= x2 && lly <= y2) {
                horizontalRadius = horizontalRadius + Math.abs(urx - x2)/2;
                verticalRadius = verticalRadius + Math.abs(lly - y2)/2;
            }
            else if(x2 <= urx && y2 >= lly){
                horizontalRadius = horizontalRadius - Math.abs(urx - x2)/2;
                verticalRadius = verticalRadius + Math.abs(lly - y2)/2;
            }
            else if(x2 >= urx && y2 <= lly){
                horizontalRadius = horizontalRadius + Math.abs(urx - x2)/2;
                verticalRadius = verticalRadius - Math.abs(lly - y2)/2;
            }
            xPoints[2] = x2;
            yPoints[2] = y2;
            xPoints[1] = x2;
            yPoints[3] = y2;
        }
    }
    
   /* public void resize(Point p) {
        int x1 = getPosition().x;
        int y1 = getPosition().y;
        int x2 = p.x;
        int y2 = p.y;
        if (ULCorners(getDraggingPoint())) {
            horizontalRadius = horizontalRadius + x1 - x2;
            verticalRadius = verticalRadius + (y1 - y2)/2;
            setPosition(new Point(getPosition().x + (x2 - x1),getPosition().y + (y2 - y1)));
            //getPosition().x = getPosition().x + (x2 - x1)/2;
            //getPosition().y = getPosition().y + y2 - y1;
        } else if (URCorners(getDraggingPoint())) {
            horizontalRadius = horizontalRadius + (x2 - x1)/2;
            verticalRadius = verticalRadius + (y1 - y2)/2;
            setPosition(new Point(getPosition().x, getPosition().y + (y2 - y1)));
            //getPosition().y = getPosition().y + y2 - y1;
        } else if (LLCorners(getDraggingPoint())) {
            horizontalRadius = horizontalRadius + (x1 - x2)/2;
            verticalRadius = verticalRadius + (y2 - y1)/2;
            setPosition(new Point(x2, getPosition().y));
            //getPosition().x = x2;
        } else if (LRCorners(getDraggingPoint())) {
            horizontalRadius = horizontalRadius - (x1 + x2)/2;
            verticalRadius = verticalRadius + (y2 - y1)/2;
        }
        if (horizontalRadius < 0) {
            horizontalRadius = -1 * horizontalRadius;
            setPosition(new Point(getPosition().x - 2*horizontalRadius, getPosition().y));
            //getPosition().x -= 2*horizontalRadius;
        }
        if (verticalRadius < 0) {
            verticalRadius = -1 * verticalRadius;
            setPosition(new Point(getPosition().x, getPosition().y-2*verticalRadius));
            //getPosition().y -= 2*verticalRadius;
        }
    }*/
    
    @Override
    public void drawCorners(Graphics canvas) {
        int x = getPosition().x;
        int y = getPosition().y;
        canvas.setColor(Color.black);
        canvas.drawRect(x-5, y-5, 10, 10);
        canvas.fillRect(x-5, y-5, 10, 10);
        canvas.drawRect(x+2*horizontalRadius-5, y-5, 10, 10);
        canvas.fillRect(x+2*horizontalRadius-5, y-5, 10, 10);
        canvas.drawRect(x-5, y+2*verticalRadius-5, 10, 10);
        canvas.fillRect(x-5, y+2*verticalRadius-5, 10, 10);
        canvas.drawRect(x+2*horizontalRadius-5, y+2*verticalRadius-5, 10, 10);
        canvas.fillRect(x+2*horizontalRadius-5, y+2*verticalRadius-5, 10, 10);
    }
    
    
    /*@Override
    public Shape copy() {
        Oval o = new Oval(this.getPosition(), this.verticalRadius, this.horizontalRadius);
        o.setColor(this.getColor());
        o.setFillColor(this.getFillColor());
        return o;
    }

    @Override
    public void setIsSelected(boolean isSelected) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
