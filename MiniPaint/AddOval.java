/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Lab7;

import shapes.Oval;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class AddOval extends javax.swing.JFrame implements Node{
    
    private Node parent;
    private Oval o;
    private DrawingEngine engine;
    private JComboBox comboBox;
    private Color fillColor, borderColor;
    
    /**
     * Creates new form CircleProperties
     * @param engine
     */

    /**
     * Creates new form CircleProperties
     * @param engine
     * @param comboBox
     */
    public AddOval(DrawingEngine engine, JComboBox comboBox) {
        initComponents();
        this.setTitle("Add Oval");
        this.engine = engine; 
        this.comboBox = comboBox; 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        xCoordinateTextField = new javax.swing.JTextField();
        yCoordinateTextField = new javax.swing.JTextField();
        verticalRadiusTextField = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        selectFillColorButton = new javax.swing.JButton();
        selectBorderColorButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        horizontalRadiusTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X-Coordinate");
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(0, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Y-Coordinate");
        jLabel2.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(0, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Vertical Radius");
        jLabel3.setOpaque(true);

        xCoordinateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        yCoordinateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        verticalRadiusTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        okButton.setBackground(new java.awt.Color(204, 255, 255));
        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        selectFillColorButton.setBackground(new java.awt.Color(204, 255, 255));
        selectFillColorButton.setText("Select Fill Color");
        selectFillColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFillColorButtonActionPerformed(evt);
            }
        });

        selectBorderColorButton.setBackground(new java.awt.Color(204, 255, 255));
        selectBorderColorButton.setText("Select Border Color");
        selectBorderColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectBorderColorButtonActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Horizontal Radius");
        jLabel4.setOpaque(true);

        horizontalRadiusTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(selectFillColorButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectBorderColorButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(xCoordinateTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(yCoordinateTextField)
                            .addComponent(verticalRadiusTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(horizontalRadiusTextField, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(xCoordinateTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yCoordinateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verticalRadiusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(horizontalRadiusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectFillColorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectBorderColorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
       
       String x = xCoordinateTextField.getText();
       String y = yCoordinateTextField.getText();
       String verticalRadius = verticalRadiusTextField.getText();
       String horizontalRadius = horizontalRadiusTextField.getText();
       
       if(x.equals("") || y.equals("") || verticalRadius.equals("") || horizontalRadius.equals("")){
            JOptionPane.showMessageDialog(null, "Some fields are empty");
        }
       else{
            try{
            int parseInt = Integer.parseInt(x);
            parseInt = Integer.parseInt(y);
            parseInt = Integer.parseInt(verticalRadius);
            parseInt = Integer.parseInt(horizontalRadius);
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "You should enter a numeric value in all the fields");
        }
       }
       if(Integer.parseInt(x)>=500 || Integer.parseInt(y)>=400){
           JOptionPane.showMessageDialog(null, "This position is out of the panel borders");
           xCoordinateTextField.setText("");
           yCoordinateTextField.setText("");
           verticalRadiusTextField.setText("");
       }
       else if(Integer.parseInt(x)<0 || Integer.parseInt(y)<0 || Integer.parseInt(verticalRadius)<=0 || Integer.parseInt(horizontalRadius)<=0){
           JOptionPane.showMessageDialog(null, "You should enter a positive number in all the fields");
       }
       else{
       o = new Oval(new Point(Integer.parseInt(x),Integer.parseInt(y)),Integer.parseInt(verticalRadius),Integer.parseInt(horizontalRadius));
       if(fillColor == null)
           o.setFillColor(Color.WHITE);
       else
           o.setFillColor(fillColor);
       if(borderColor == null)
           o.setColor(Color.BLACK);
       else
           o.setColor(borderColor);
       engine.addShape(o);
       engine.refresh(null);
       comboBox.addItem("Oval_"+comboBox.getItemCount());
       this.setVisible(false);
       ((JFrame)getParentNode()).setVisible(true);
       }
    }//GEN-LAST:event_okButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
        ((JFrame)getParentNode()).setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void selectFillColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFillColorButtonActionPerformed
        fillColor = JColorChooser.showDialog(null,"Choose Fill Color", Color.white);
    }//GEN-LAST:event_selectFillColorButtonActionPerformed

    private void selectBorderColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectBorderColorButtonActionPerformed
        borderColor = JColorChooser.showDialog(null,"Choose Border Color", Color.black);
    }//GEN-LAST:event_selectBorderColorButtonActionPerformed

    /**
     * @param args the command line arguments
     * @return 
     */
    /*public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CircleProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CircleProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CircleProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CircleProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CircleProperties().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField horizontalRadiusTextField;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton okButton;
    private javax.swing.JButton selectBorderColorButton;
    private javax.swing.JButton selectFillColorButton;
    private javax.swing.JTextField verticalRadiusTextField;
    private javax.swing.JTextField xCoordinateTextField;
    private javax.swing.JTextField yCoordinateTextField;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public Node getParentNode() {
        return parent;
    }

    @Override
    public void setParentNode(Node node) {
        this.parent = node;
    }
}
