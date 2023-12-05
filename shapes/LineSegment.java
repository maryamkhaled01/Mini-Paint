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
public class LineSegment extends AbstractShapeClass{
    private Point endPoint;
    private boolean isSelected;
    
    public LineSegment(Point startPoint,Point endPoint){
        super(startPoint);
        this.endPoint = endPoint;
    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(getColor());
        canvas.drawLine(getPosition().x, getPosition().y, endPoint.x, endPoint.y);
    }
    
    @Override
    public void drawCorners(Graphics canvas){
        //canvas.setColor(getColor());
        //canvas.drawLine(getPosition().x, getPosition().y, endPoint.x, endPoint.y);
        /*canvas.setColor(Color.black);
        int[] xPoints1 = {getPosition().x-5, getPosition().x+5,getPosition().x+5, getPosition().x-5};
        int[] yPoints1 = {getPosition().y-5, getPosition().y-5, getPosition().y+5, getPosition().y+5};
        canvas.drawPolygon(xPoints1, yPoints1, 4);
        canvas.fillPolygon(xPoints1, yPoints1, 4);
        int[] xPoints2 = {endPoint.x-5, endPoint.x+5, endPoint.x+5, endPoint.x-5};
        int[] yPoints2 = {endPoint.y-5, endPoint.y-5, endPoint.y+5, endPoint.y+5};
        canvas.drawPolygon(xPoints2, yPoints2, 4);
        canvas.fillPolygon(xPoints2, yPoints2, 4);*/
        int x1 = getPosition().x;
        int y1 = getPosition().y;
        int x2 = endPoint.x;
        int y2 = endPoint.y;
        canvas.setColor(Color.black);
        canvas.drawRect(x1-5, y1-5, 10, 10);
        canvas.fillRect(x1-5, y1-5, 10, 10);
        canvas.drawRect(x2-5, y2-5, 10, 10);
        canvas.fillRect(x2-5, y2-5, 10, 10);
    }

    @Override
    public boolean contains(Point point) {
        return (point.y-getPosition().y)*(endPoint.x-getPosition().x) == (endPoint.y-getPosition().y)*(point.x-getPosition().x); 
    }

    @Override
    public void moveTo(Point point) {
        int xdifference = point.x - getDraggingPoint().x;
        int ydifference = point.y - getDraggingPoint().y;
        endPoint = new Point(endPoint.x + xdifference, endPoint.y + ydifference);
        setPosition(new Point(getPosition().x + xdifference, getPosition().y + ydifference));
    }

    public Point getEndPoint(){
        return endPoint;
    }
    
    public boolean corner1(Point p){
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(x - 5, y - 5, 10, 10);
        return r.contains(p.x, p.y);
    }
    
    public boolean corner2(Point p){
        int x = endPoint.x;
        int y = endPoint.y;
        java.awt.Rectangle r = new java.awt.Rectangle(x - 5, y - 5, 10, 10);
        return r.contains(p.x, p.y);
    }
    
    /*@Override
    public void saveToJsonFile(int i, JSONObject obj){
         JSONArray line = new JSONArray();
         line.add(this);
         line.add(getPosition());
         line.add(endPoint);
         line.add(getColor());
         obj.put(i, line);
    }*/
    
    public void resize(Point point) {
       /* int xDifference = point.x - getCornerPoint().x;
        int yDifference = point.y - getCornerPoint().y;
        Point position1 = new Point(getPosition().x-5, getPosition().y-5);
        java.awt.Rectangle r1 = new java.awt.Rectangle();
        r1.setLocation(position1);
        r1.setSize(10, 10);
        Point position2 = new Point(endPoint.x-5, endPoint.y-5);
        java.awt.Rectangle r2 = new java.awt.Rectangle();
        r2.setLocation(position2);
        r2.setSize(10, 10);
        if(r1.contains(getCornerPoint()))
            setPosition(new Point(getPosition().x+xDifference, getPosition().y+yDifference));
        else if(r2.contains(getCornerPoint()))
            endPoint = new Point(endPoint.x+xDifference, endPoint.y+yDifference);*/
       if(corner1(getDraggingPoint())){
            setPosition(point);
        }
        else if(corner2(getDraggingPoint())){
            endPoint = point;
        }
    }
    
    /*@Override
    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    
    @Override
    public boolean getIsSelected(){
        return isSelected;
    }
    
    public boolean inResizeRange(Point point){
        Point position1 = new Point(getPosition().x-5, getPosition().y-5);
        java.awt.Rectangle r1 = new java.awt.Rectangle();
        r1.setLocation(position1);
        r1.setSize(10, 10);
        Point position2 = new Point(endPoint.x-5, endPoint.y-5);
        java.awt.Rectangle r2 = new java.awt.Rectangle();
        r2.setLocation(position2);
        r2.setSize(10, 10);
        return r1.contains(point) || r2.contains(point);
    }
    
    
    
    
    
    @Override
    public Shape copy() {
        LineSegment l = new LineSegment(this.getPosition(), this.endPoint);
        l.setColor(this.getColor());
        return l;
    }
    
    @Override
    public Point[] getCornerPoints(){
        Point[] points = {getPosition(), endPoint};
        return points;        
    }*/
    
}
