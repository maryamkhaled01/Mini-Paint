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
public abstract class AbstractShapeClass implements Shape, Moveable, Resizeable {
    private Point position, draggingPoint, cornerPoint;
    private Color borderColor, fillColor;
    boolean selected;
    
    public AbstractShapeClass(Point position){
        this.position = position;
    }
    
    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setColor(Color color) {
        this.borderColor = color;
    }

    @Override
    public Color getColor() {
        return borderColor;
    }

    @Override
    public void setFillColor(Color color) {
        this.fillColor = color;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }
    
    @Override
    public void setDraggingPoint(Point point){
        this.draggingPoint = point;
    }
    
    @Override
    public Point getDraggingPoint(){
        return this.draggingPoint;
    }
    
    @Override
    abstract public void draw(Graphics canvas);
    
    @Override
    public void setSelected(boolean selected){
        this.selected = selected;
    }
    
    @Override
    public boolean isSelected(){
        return selected;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    /*@Override
    abstract public void drawCorners(Graphics canvas);
    
    @Override
    public void setCornerPoint(Point point){
        this.cornerPoint = point;
    }
    
    @Override
    public Point getCornerPoint(){
        return this.cornerPoint;
    }*/
}
