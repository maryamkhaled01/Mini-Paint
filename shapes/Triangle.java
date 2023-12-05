/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author LENOVO
 */
public class Triangle extends AbstractShapeClass{
    Point point2, point3;

    public Triangle(Point point1, Point point2, Point point3){
        super(point1);
        this.point2 = point2;
        this.point3 = point3;  
    }
    
    @Override
    public void draw(Graphics canvas) {
        int[] xPoints = {getPosition().x,point2.x,point3.x};
        int[] yPoints = {getPosition().y,point2.y,point3.y};
        canvas.setColor(getFillColor());
        canvas.fillPolygon(xPoints, yPoints, 3);
        canvas.setColor(getColor());
        canvas.drawPolygon(xPoints, yPoints, 3);
    }

    @Override
    public boolean contains(Point point) {
        int[] xPoints = {getPosition().x,point2.x,point3.x}; 
        int[] yPoints = {getPosition().y,point2.y,point3.y};
        Polygon pol = new Polygon(xPoints, yPoints, 3);
        return pol.contains(point);
    }

    @Override
    public void moveTo(Point point) {
        int xDifference = point.x-getDraggingPoint().x;
        int yDifference = point.y-getDraggingPoint().y;
        point2 = new Point (point2.x+xDifference, point2.y+yDifference);
        point3 = new Point (point3.x+xDifference, point3.y+yDifference);
        setPosition(new Point(getPosition().x+xDifference,getPosition().y+yDifference));
    }

    public Point getPoint2(){
        return point2;
    }
    
    public Point getPoint3(){
        return point3;
    }
    
    public boolean corner1(Point p){
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(x - 5, y - 5, 10, 10);
        return r.contains(p.x, p.y);
    }
    
    public boolean corner2(Point p){
        int x = point2.x;
        int y = point2.y;
        java.awt.Rectangle r = new java.awt.Rectangle(x - 5, y - 5, 10, 10);
        return r.contains(p.x, p.y);
    }
    
    public boolean corner3(Point p){
        int x = point3.x;
        int y = point3.y;
        java.awt.Rectangle r = new java.awt.Rectangle(x - 5, y - 5, 10, 10);
        return r.contains(p.x, p.y);
    }
    
    @Override
    public void resize(Point point) {
        if(corner1(getDraggingPoint())){
            setPosition(point);
        }
        else if(corner2(getDraggingPoint())){
            point2 = point;
        }
        else if(corner3(getDraggingPoint())){
            point3 = point;
        }
    }
    
    @Override
    public void drawCorners(Graphics canvas) {
        int x1 = getPosition().x;
        int y1 = getPosition().y;
        int x2 = point2.x;
        int y2 = point2.y;
        int x3 = point3.x;
        int y3 = point3.y;
        canvas.setColor(Color.black);
        canvas.drawRect(x1-5, y1-5, 10, 10);
        canvas.fillRect(x1-5, y1-5, 10, 10);
        canvas.drawRect(x2-5, y2-5, 10, 10);
        canvas.fillRect(x2-5, y2-5, 10, 10);
        canvas.drawRect(x3-5, y3-5, 10, 10);
        canvas.fillRect(x3-5, y3-5, 10, 10);
    }
    
    /*@Override
    public void saveToJsonFile(int i, JSONObject obj){
         JSONArray tri = new JSONArray();
         tri.add(this);
         tri.add(getPosition());
         tri.add(point2);
         tri.add(point3);
         tri.add(getColor());
         tri.add(getFillColor());
         obj.put(i, tri);
    }*/
    
    
    
    /*@Override
    public Shape copy() {
       Triangle t = new Triangle(this.getPosition(), this.point2, this.point3);
       t.setColor(this.getColor());
       t.setFillColor(this.getFillColor());
       return t;
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
