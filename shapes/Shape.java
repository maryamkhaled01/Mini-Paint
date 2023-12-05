/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import org.json.simple.JSONObject;

/**
 *
 * @author LENOVO
 */
public interface Shape {
    public void setPosition(Point position);
    public Point getPosition();
    public void setColor(Color color);
    public Color getColor();
    public void setFillColor(Color color);
    public Color getFillColor();
    public void draw(Graphics canvas);
    //public void saveToJsonFile(int i, JSONObject obj);
    
    public void setSelected(boolean isSelected); 
    public boolean isSelected();
    public void drawCorners(Graphics canvas);
    //public abstract Shape copy();
   // public Point[] getCornerPoints();
    
}
