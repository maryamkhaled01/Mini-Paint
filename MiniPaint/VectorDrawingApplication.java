/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Lab7;

import shapes.Shape;
import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import shapes.AbstractShapeClass;
import shapes.LineSegment;
import shapes.Oval;
import shapes.Rectangle;
import shapes.Triangle;

/**
 *
 * @author LENOVO
 */
public class VectorDrawingApplication extends javax.swing.JFrame implements Node {
    
    private DrawingEngine engine;
    private AddOval oval;
    private AddRectangle rectangle;
    private AddSquare square;
    private AddLineSegment line;
    private Colorize colorize;
    private AddTriangle triangle;
    private int selectedIndex = -1, resizedIndex = -1;
    private int index;
    private boolean resize;
    /**
     * Creates new form VectorDrwaingApplication
     */
    public VectorDrawingApplication() {
        initComponents();
        this.setTitle("Vector Drawing Application");
        engine = (DrawingEngine)jPanel1;
    }
    
    public void save(String absolutePath){
        JSONArray array = new JSONArray();
            Shape[] shapes = engine.getShapes();
            int i;
            for(i = 0; i<shapes.length; i++){
                JSONObject obj = new JSONObject();
                //shapes[i].saveToJsonFile(i, obj);
                AbstractShapeClass aSh;
                aSh = (AbstractShapeClass) shapes[i];
                if(aSh instanceof Rectangle){
                    Rectangle r = (Rectangle) aSh;
                    //r.saveToJsonFile(i, obj);
                    obj.put("ShapeType", "Rectangle");
                    obj.put("x", r.getPosition().x);
                    obj.put("y", r.getPosition().y);
                    obj.put("Width", r.getWidth());
                    obj.put("Height", r.getHeight());
                    obj.put("ColorRed", r.getColor().getRed());
                    obj.put("ColorGreen", r.getColor().getGreen());
                    obj.put("ColorBlue", r.getColor().getBlue());
                    obj.put("FillColorRed", r.getFillColor().getRed());
                    obj.put("FillColorGreen", r.getFillColor().getGreen());
                    obj.put("FillColorBlue", r.getFillColor().getBlue());
                }
                else if(aSh instanceof Oval){
                    Oval o = (Oval) aSh;
                    obj.put("ShapeType", "Oval");
                    obj.put("x", o.getPosition().x);
                    obj.put("y", o.getPosition().y);
                    obj.put("VerticalRadius", o.getVerticalRadius());
                    obj.put("HorizontalRadius", o.getHorizontalRadius());
                    obj.put("ColorRed", o.getColor().getRed());
                    obj.put("ColorGreen", o.getColor().getGreen());
                    obj.put("ColorBlue", o.getColor().getBlue());
                    obj.put("FillColorRed", o.getFillColor().getRed());
                    obj.put("FillColorGreen", o.getFillColor().getGreen());
                    obj.put("FillColorBlue", o.getFillColor().getBlue());
                }
                else if(aSh instanceof LineSegment){
                    LineSegment l = (LineSegment) aSh;
                    obj.put("ShapeType", "LineSegment");
                    obj.put("x", l.getPosition().x);
                    obj.put("y", l.getPosition().y);
                    obj.put("x2", l.getEndPoint().x);
                    obj.put("y2", l.getEndPoint().y);
                    obj.put("ColorRed", l.getColor().getRed());
                    obj.put("ColorGreen", l.getColor().getGreen());
                    obj.put("ColorBlue", l.getColor().getBlue());
                }
                else if(aSh instanceof Triangle){
                    Triangle t = (Triangle) aSh;
                    obj.put("ShapeType", "Triangle");
                    obj.put("x", t.getPosition().x);
                    obj.put("y", t.getPosition().y);
                    obj.put("x2", t.getPoint2().x);
                    obj.put("y2", t.getPoint2().y);
                    obj.put("x3", t.getPoint3().x);
                    obj.put("y3", t.getPoint3().y);
                    obj.put("ColorRed", t.getColor().getRed());
                    obj.put("ColorGreen", t.getColor().getGreen());
                    obj.put("ColorBlue", t.getColor().getBlue());
                    obj.put("FillColorRed", t.getFillColor().getRed());
                    obj.put("FillColorGreen", t.getFillColor().getGreen());
                    obj.put("FillColorBlue", t.getFillColor().getBlue());
                }
                array.add(obj);
            }
            index = i;
            try{
                FileWriter fw = new FileWriter(absolutePath);
                fw.write(array.toString());
                fw.flush();
            } catch (IOException ex) {
                System.out.println("Error in creating the file!");
            }
    }
    
    private void load(String absolutePath) throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader fr = new FileReader(absolutePath);
        Object obj = parser.parse(fr);
        JSONArray shapes = (JSONArray) obj;
        for (int i = 0; i < shapes.size(); i++) {
            JSONObject j = (JSONObject) shapes.get(i);
            Color color = new Color((int)((long) j.get("ColorRed")), (int)((long) j.get("ColorGreen")), (int)((long) j.get("ColorBlue")));
            Point position = new Point((int)((long) j.get("x")), (int)((long) j.get("y")));
            String shape = (String) j.get("ShapeType");
            if(shape.equals("Rectangle")){
                Rectangle r = new Rectangle(position, (int)((long)j.get("Width")), (int)((long)j.get("Height")));
                Color fillColor = new Color((int)((long) j.get("FillColorRed")), (int)((long) j.get("FillColorGreen")), (int)((long) j.get("FillColorBlue")));
                r.setColor(color);
                r.setFillColor(fillColor);
                engine.addShape(r);
                engine.refresh(null);
                jComboBox1.addItem("Rectangle_"+jComboBox1.getItemCount());
            }
            else if(shape.equals("Oval")){
                Oval o = new Oval(position, (int)((long)j.get("VerticalRadius")), (int)((long)j.get("HorizontalRadius")));
                Color fillColor = new Color((int)((long) j.get("FillColorRed")), (int)((long) j.get("FillColorGreen")), (int)((long) j.get("FillColorBlue")));
                o.setColor(color);
                o.setFillColor(fillColor);
                engine.addShape(o);
                engine.refresh(null);
                jComboBox1.addItem("Oval_"+jComboBox1.getItemCount());
            }
            else if(shape.equals("LineSegment")){
                Point endPoint = new Point((int)((long) j.get("x2")), (int)((long) j.get("y2")));
                LineSegment l = new LineSegment(position, endPoint);
                l.setColor(color);
                engine.addShape(l);
                engine.refresh(null);
                jComboBox1.addItem("Line_"+jComboBox1.getItemCount());
            }
            else if(shape.equals("Triangle")){
                Point point2 = new Point((int)((long) j.get("x2")), (int)((long) j.get("y2")));
                Point point3 = new Point((int)((long) j.get("x3")), (int)((long) j.get("y3")));
                Triangle t = new Triangle(position, point2, point3);
                Color fillColor = new Color((int)((long) j.get("FillColorRed")), (int)((long) j.get("FillColorGreen")), (int)((long) j.get("FillColorBlue")));
                t.setColor(color);
                t.setFillColor(fillColor);
                engine.addShape(t);
                engine.refresh(null);
                jComboBox1.addItem("Triangle_"+jComboBox1.getItemCount());
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ovalButton = new javax.swing.JButton();
        lineSegmentButton = new javax.swing.JButton();
        squareButton = new javax.swing.JButton();
        rectangleButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        colorizeButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jPanel1 = new MyPanel();
        triangleButton = new javax.swing.JButton();
        copyButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        saveMenuItem = new javax.swing.JMenuItem();
        loadMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ovalButton.setBackground(new java.awt.Color(204, 255, 255));
        ovalButton.setText("Oval");
        ovalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ovalButtonActionPerformed(evt);
            }
        });

        lineSegmentButton.setBackground(new java.awt.Color(204, 255, 255));
        lineSegmentButton.setText("Line Segment");
        lineSegmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineSegmentButtonActionPerformed(evt);
            }
        });

        squareButton.setBackground(new java.awt.Color(204, 255, 255));
        squareButton.setText("Square");
        squareButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                squareButtonActionPerformed(evt);
            }
        });

        rectangleButton.setBackground(new java.awt.Color(204, 255, 255));
        rectangleButton.setText("Rectangle");
        rectangleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectangleButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Select Shape");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        colorizeButton.setBackground(new java.awt.Color(204, 255, 255));
        colorizeButton.setText("Colorize");
        colorizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorizeButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(204, 255, 255));
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 153)));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 400));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 293, Short.MAX_VALUE)
        );

        triangleButton.setBackground(new java.awt.Color(204, 255, 255));
        triangleButton.setText("Triangle");
        triangleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                triangleButtonActionPerformed(evt);
            }
        });

        copyButton.setBackground(new java.awt.Color(204, 255, 255));
        copyButton.setText("Copy");
        copyButton.setPreferredSize(new java.awt.Dimension(74, 23));
        copyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyButtonActionPerformed(evt);
            }
        });

        jMenuBar1.setOpaque(true);

        jMenu1.setText("File");

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveMenuItem.setText("Save");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(saveMenuItem);

        loadMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        loadMenuItem.setText("Load");
        loadMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(loadMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(colorizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(106, 106, 106)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(copyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ovalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lineSegmentButton)
                        .addGap(18, 18, 18)
                        .addComponent(squareButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rectangleButton)
                        .addGap(18, 18, 18)
                        .addComponent(triangleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ovalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lineSegmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(squareButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rectangleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(triangleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(colorizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(copyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rectangleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectangleButtonActionPerformed
        this.setVisible(false);
        rectangle = new AddRectangle(engine, jComboBox1);
        rectangle.setVisible(true);
        rectangle.setParentNode(this);
    }//GEN-LAST:event_rectangleButtonActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void squareButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squareButtonActionPerformed
        this.setVisible(false);
        square = new AddSquare(engine, jComboBox1);
        square.setVisible(true);
        square.setParentNode(this);
    }//GEN-LAST:event_squareButtonActionPerformed

    private void lineSegmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineSegmentButtonActionPerformed
        this.setVisible(false);
        line = new AddLineSegment(engine, jComboBox1);
        line.setVisible(true);
        line.setParentNode(this);
    }//GEN-LAST:event_lineSegmentButtonActionPerformed

    private void ovalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ovalButtonActionPerformed
        this.setVisible(false);
        oval = new AddOval(engine, jComboBox1);
        oval.setVisible(true);
        oval.setParentNode(this);
    }//GEN-LAST:event_ovalButtonActionPerformed

    private void colorizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorizeButtonActionPerformed
        if(jComboBox1.getSelectedItem() != null){
            String[] str = jComboBox1.getSelectedItem().toString().split("_");
            int index = jComboBox1.getSelectedIndex();
            if(str[0].equals("Line")){
               Shape shapes[] = engine.getShapes();
               Color color = JColorChooser.showDialog(null,"Choose Color", Color.black);
               shapes[index].setColor(color);
               engine.refresh(null);
            }
            else{
                this.setVisible(false);
                colorize = new Colorize(engine, index);
                colorize.setVisible(true);
                colorize.setParentNode(this);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "The Combobox is empty!");
        }
    }//GEN-LAST:event_colorizeButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if(jComboBox1.getSelectedItem() != null){
        int index = jComboBox1.getSelectedIndex();
        jComboBox1.removeItemAt(index);
        Shape shapes[] = engine.getShapes();
        Shape shape = shapes[index];
        engine.removeShape(shape);
        engine.refresh(null);
        selectedIndex = -1;
        }
        else{
            JOptionPane.showMessageDialog(null, "The Combobox is empty!");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void triangleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_triangleButtonActionPerformed
        this.setVisible(false);
        triangle = new AddTriangle(engine, jComboBox1);
        triangle.setVisible(true);
        triangle.setParentNode(this);
    }//GEN-LAST:event_triangleButtonActionPerformed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
       Point point = evt.getPoint();
       Shape[] shapes = engine.getShapes();
       AbstractShapeClass aSh;
       if(resize == true){
           aSh = (AbstractShapeClass) shapes[selectedIndex];
           aSh.resize(point);
           aSh.setDraggingPoint(point);
           engine.refresh(null);
       }
       else if(selectedIndex != -1){
           aSh = (AbstractShapeClass) shapes[selectedIndex];
           //if(aSh.getDraggingPoint() != null){
           aSh.moveTo(point);
           aSh.setDraggingPoint(point);
           //}
           engine.refresh(null);
       }
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        Point point = evt.getPoint();
        Shape[] shapes = engine.getShapes();
        AbstractShapeClass aSh;
        if(selectedIndex != -1){
            resize = false;
            if(shapes[selectedIndex] instanceof Rectangle){
                Rectangle r = (Rectangle) shapes[selectedIndex];
                if (r.ULCorners(point) || r.URCorners(point) || r.LLCorners(point) || r.LRCorners(point)) {
                    r.setDraggingPoint(point);
                    //resizedIndex = selectedIndex;
                    resize = true;
                    return;
                }
            }
            else if(shapes[selectedIndex] instanceof Triangle){
                Triangle t = (Triangle) shapes[selectedIndex];
                if (t.corner1(point) || t.corner2(point) || t.corner3(point)) {
                    t.setDraggingPoint(point);
                    //resizedIndex = selectedIndex;
                    resize = true;
                    return;
                }
            }
            else if(shapes[selectedIndex] instanceof LineSegment){
                LineSegment l = (LineSegment) shapes[selectedIndex];
                if (l.corner1(point) || l.corner2(point)) {
                    l.setDraggingPoint(point);
                    //resizedIndex = selectedIndex;
                    resize = true;
                    return;
                }
            }
            else if(shapes[selectedIndex] instanceof Oval){
                Oval o = (Oval) shapes[selectedIndex];
                if (o.ULCorners(point) || o.URCorners(point) || o.LLCorners(point) || o.LRCorners(point)) {
                    o.setDraggingPoint(point);
                    //resizedIndex = selectedIndex;
                    resize = true;
                    return;
                }
            }
        }
        //resizedIndex = -1;
        if(selectedIndex != -1){
            shapes[selectedIndex].setSelected(false);
            engine.refresh(null);
        }
        /*for(int i = 0; i<shapes.length;i++){
            shapes[i].setSelected(false);
            engine.refresh(null);
        }*/
        for(int i=shapes.length-1; i>=0; i--){
            aSh = (AbstractShapeClass) shapes[i];
            if(aSh.contains(point)){
                selectedIndex = i;
                jComboBox1.setSelectedIndex(i);
                aSh.setDraggingPoint(point);
                aSh.setSelected(true);
                engine.refresh(null);
                return;
            }
            //aSh.setSelected(false);
            //engine.refresh(null);
        }
        selectedIndex = -1;
        jComboBox1.setSelectedIndex(-1);
    }//GEN-LAST:event_jPanel1MousePressed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(new File("."));
        int response = jFileChooser.showSaveDialog(null);
        if(response == JFileChooser.APPROVE_OPTION){
            save(jFileChooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void loadMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadMenuItemActionPerformed
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(new File("."));
        int response = jFileChooser.showOpenDialog(null);
        if(response == JFileChooser.APPROVE_OPTION){
            Shape[] shapes = engine.getShapes();
            if(shapes.length != 0){
                    for (int i = 0; i<shapes.length; i++) {
                        jComboBox1.removeAllItems();
                        engine.removeShape(shapes[i]);
                        engine.refresh(null);
                        selectedIndex = -1;
                    }
                }
            try{
                load(jFileChooser.getSelectedFile().getAbsolutePath());
            }catch(IOException e){
                System.out.println("IOException!");
            }catch(ParseException e){
                System.out.println("ParseException!");
            }
        }
    }//GEN-LAST:event_loadMenuItemActionPerformed

    private void copyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyButtonActionPerformed
        if(jComboBox1.getSelectedItem() != null){
        int index = jComboBox1.getSelectedIndex();
        String[] str = jComboBox1.getSelectedItem().toString().split("_");
        Shape shapes[] = engine.getShapes();
        //AbstractShapeClass aSh;
        //aSh = (AbstractShapeClass) shapes[index];
        if(shapes[index] instanceof Rectangle){
            Rectangle r = new Rectangle(shapes[index].getPosition(), ((Rectangle) shapes[index]).getWidth(), ((Rectangle) shapes[index]).getHeight());
            r.setColor(shapes[index].getColor());
            r.setFillColor(shapes[index].getFillColor());
            engine.addShape(r);
            engine.refresh(null);
        }
        else if(shapes[index] instanceof Oval){
            Oval o = new Oval(shapes[index].getPosition(), ((Oval) shapes[index]).getVerticalRadius(), ((Oval) shapes[index]).getHorizontalRadius());
            o.setColor(shapes[index].getColor());
            o.setFillColor(shapes[index].getFillColor());
            engine.addShape(o);
            engine.refresh(null);
        }
        else if(shapes[index] instanceof LineSegment){
            LineSegment l = new LineSegment(shapes[index].getPosition(), ((LineSegment) shapes[index]).getEndPoint());
            l.setColor(shapes[index].getColor());
            l.setFillColor(shapes[index].getFillColor());
            engine.addShape(l);
            engine.refresh(null);
        }
        else if(shapes[index] instanceof Triangle){
            Triangle t = new Triangle(shapes[index].getPosition(), ((Triangle) shapes[index]).getPoint2(), ((Triangle) shapes[index]).getPoint3());
            t.setColor(shapes[index].getColor());
            t.setFillColor(shapes[index].getFillColor());
            engine.addShape(t);
            engine.refresh(null);
        }
        //Shape shape = aSh.copy();
        
        jComboBox1.addItem(str[0]+"_"+jComboBox1.getItemCount());
        }
        else{
            JOptionPane.showMessageDialog(null, "The Combobox is empty!");
        }
    }//GEN-LAST:event_copyButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VectorDrawingApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VectorDrawingApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VectorDrawingApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VectorDrawingApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VectorDrawingApplication().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton colorizeButton;
    private javax.swing.JButton copyButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton lineSegmentButton;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JButton ovalButton;
    private javax.swing.JButton rectangleButton;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JButton squareButton;
    private javax.swing.JButton triangleButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public Node getParentNode() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParentNode(Node node) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
