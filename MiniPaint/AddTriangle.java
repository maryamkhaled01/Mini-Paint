/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Lab7;

import java.awt.Color;
import java.awt.Point;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import shapes.Triangle;

/**
 *
 * @author LENOVO
 */
public class AddTriangle extends javax.swing.JFrame implements Node{
    private Node parent;
    private Triangle t;
    private DrawingEngine engine;
    private JComboBox comboBox;
    private Color fillColor, borderColor;
    
    /**
     * Creates new form AddTriangle
     * @param engine
     * @param comboBox
     */
    public AddTriangle(DrawingEngine engine, JComboBox comboBox) {
        initComponents();
        this.setTitle("Add Triangle");
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

        jLabel5 = new javax.swing.JLabel();
        x1CoordinateTextField = new javax.swing.JTextField();
        y1CoordinateTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        x2CoordinateTextField = new javax.swing.JTextField();
        y2CoordinateTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        x3CoordinateTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        y3CoordinateTextField = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        selectFillColorButton = new javax.swing.JButton();
        selectBorderColorButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(0, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("X1-Coordinate");
        jLabel5.setOpaque(true);

        x1CoordinateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        y1CoordinateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setBackground(new java.awt.Color(0, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Y1-Coordinate");
        jLabel6.setOpaque(true);

        jLabel7.setBackground(new java.awt.Color(0, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("X2-Coordinate");
        jLabel7.setOpaque(true);

        x2CoordinateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        y2CoordinateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setBackground(new java.awt.Color(0, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Y2-Coordinate");
        jLabel8.setOpaque(true);

        jLabel9.setBackground(new java.awt.Color(0, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("X3-Coordinate");
        jLabel9.setOpaque(true);

        x3CoordinateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel10.setBackground(new java.awt.Color(0, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Y3-Coordinate");
        jLabel10.setOpaque(true);

        y3CoordinateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(x1CoordinateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(y1CoordinateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(x2CoordinateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(y2CoordinateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(x3CoordinateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(y3CoordinateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectFillColorButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectBorderColorButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(61, 61, 61)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(x1CoordinateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(y1CoordinateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x2CoordinateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(y2CoordinateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x3CoordinateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(y3CoordinateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectFillColorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectBorderColorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
        ((JFrame)getParentNode()).setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        String x1 = x1CoordinateTextField.getText();
        String y1 = y1CoordinateTextField.getText();
        String x2 = x2CoordinateTextField.getText();
        String y2 = y2CoordinateTextField.getText();
        String x3 = x3CoordinateTextField.getText();
        String y3 = y3CoordinateTextField.getText();
        
        if(x1.equals("") || y1.equals("") || x2.equals("") || y2.equals("") || x3.equals("") || y3.equals("")){
            JOptionPane.showMessageDialog(null, "Some fields are empty");
        }
        else{
            try{
            int parseInt = Integer.parseInt(x1);
            parseInt = Integer.parseInt(y1);
            parseInt = Integer.parseInt(x2);
            parseInt = Integer.parseInt(y2);
            parseInt = Integer.parseInt(x3);
            parseInt = Integer.parseInt(y3);
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "You should enter a numeric value in all the fields");
        }
       }
        if(Integer.parseInt(x1)>=500 || Integer.parseInt(y1)>=400 || Integer.parseInt(x2)>=500 || Integer.parseInt(y2)>=400 || Integer.parseInt(x3)>=500 || Integer.parseInt(y3)>=400){
           JOptionPane.showMessageDialog(null, "This position is out of the panel borders");
           x1CoordinateTextField.setText("");
           y1CoordinateTextField.setText("");
           x2CoordinateTextField.setText("");
           y2CoordinateTextField.setText("");
           x3CoordinateTextField.setText("");
           y3CoordinateTextField.setText("");
       }
        else if(Integer.parseInt(x1)<0 || Integer.parseInt(y1)<0 || Integer.parseInt(x2)<0 || Integer.parseInt(y2)<0 || Integer.parseInt(x3)<0 || Integer.parseInt(y3)<0){
           JOptionPane.showMessageDialog(null, "You should enter a positive number in all the fields");
       }
       else{
        t = new Triangle(new Point(Integer.parseInt(x1),Integer.parseInt(y1)),new Point(Integer.parseInt(x2),Integer.parseInt(y2)), new Point(Integer.parseInt(x3),Integer.parseInt(y3)));
        if(fillColor == null)
           t.setFillColor(Color.WHITE);
        else
           t.setFillColor(fillColor);
        if(borderColor == null)
           t.setColor(Color.BLACK);
        else
           t.setColor(borderColor);
        engine.addShape(t);
        engine.refresh(null);
        comboBox.addItem("Triangle_"+comboBox.getItemCount());
        this.setVisible(false);
        ((JFrame)getParentNode()).setVisible(true);
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void selectFillColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFillColorButtonActionPerformed
        fillColor = JColorChooser.showDialog(null,"Choose Fill Color", Color.white);
    }//GEN-LAST:event_selectFillColorButtonActionPerformed

    private void selectBorderColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectBorderColorButtonActionPerformed
        borderColor = JColorChooser.showDialog(null,"Choose Border Color", Color.black);
    }//GEN-LAST:event_selectBorderColorButtonActionPerformed

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(AddTriangle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddTriangle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddTriangle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddTriangle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddTriangle().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton okButton;
    private javax.swing.JButton selectBorderColorButton;
    private javax.swing.JButton selectFillColorButton;
    private javax.swing.JTextField x1CoordinateTextField;
    private javax.swing.JTextField x2CoordinateTextField;
    private javax.swing.JTextField x3CoordinateTextField;
    private javax.swing.JTextField y1CoordinateTextField;
    private javax.swing.JTextField y2CoordinateTextField;
    private javax.swing.JTextField y3CoordinateTextField;
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
