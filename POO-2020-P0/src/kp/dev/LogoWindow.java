/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.dev;

import java.awt.Graphics;

/**
 *
 * @author Marc
 */
public final class LogoWindow extends javax.swing.JFrame
{
    private Logo logo;
    private Program prog;
    
    /**
     * Creates new form LogoWindow
     */
    public LogoWindow()
    {
        initComponents();
        
        this.logo = new Logo(800, 600);
        this.prog = twoSquareProgram();
        
        setSize(logo.getWidth(), logo.getHeight());
    }
    
    @Override
    public final void paint(Graphics g)
    {
        super.paint(g);
        logo.execute(prog, g);
    }
    
    private Program twoSquareProgram()
    {
        Program p = new Program("Two Square");
        
        // Go to first square //
        p.addInstruction("FWD", 100);
        p.addInstruction("ROT", 90);
        p.addInstruction("FWD", 200);
        
        // Create first square //
        p.addInstruction("PEN", 1);
        p.addInstruction("FWD", 200);
        p.addInstruction("ROT", -90);
        p.addInstruction("FWD", 200);
        p.addInstruction("ROT", -90);
        p.addInstruction("FWD", 200);
        p.addInstruction("ROT", -90);
        p.addInstruction("FWD", 200);
        p.addInstruction("PEN", 0);
        
        // Go to second square //
        p.addInstruction("ROT", 180);
        p.addInstruction("FWD", 400);
        
        // Create second square //
        p.addInstruction("PEN", 1);
        p.addInstruction("FWD", 200);
        p.addInstruction("ROT", 90);
        p.addInstruction("FWD", 200);
        p.addInstruction("ROT", 90);
        p.addInstruction("FWD", 200);
        p.addInstruction("ROT", 90);
        p.addInstruction("FWD", 200);
        p.addInstruction("PEN", 0);
        
        return p;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(LogoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LogoWindow().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
