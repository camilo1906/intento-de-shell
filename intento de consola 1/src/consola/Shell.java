package consola;

import java.io.BufferedInputStream;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 *
 * @author K-milo
 */
public class Shell extends javax.swing.JFrame{

    /**
     * Creates new form NewJFrame
     */
    public Shell() {
        initComponents();
        setTitle("Consola en "+System.getProperty("os.name"));
        setResizable(false); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     
        public void ShellLinux(){
       Process proc; 
       InputStream is_in;
       String s_aux;
       BufferedReader br;
       try{
           proc = Runtime.getRuntime().exec(TxtComando.getText());
	   is_in=proc.getInputStream();
	   br=new BufferedReader (new InputStreamReader (is_in));
	   s_aux = br.readLine();
           while (s_aux!=null){
               tResultado.setText(tResultado.getText()+s_aux+"\n");
               s_aux = br.readLine();
           } 
       }catch(Exception e){
           e.getMessage();
       }   
   }
        
   public void Shellwindows() throws IOException{
       BufferedReader stdOutErr = null;
       Process        p  = null;
       ProcessBuilder pb = null;
       ArrayList <String> orden = new ArrayList <String> ();
       String linea="",MostrarTodoElResultado="";
       orden.add (TxtComando.getText());
       pb = new ProcessBuilder (orden);
       pb.redirectErrorStream (true);
       try{
           p = pb.start ();
       }catch (java.io.IOException ie){
           ie.printStackTrace ();
       }try{
           stdOutErr = new BufferedReader (new InputStreamReader (p.getInputStream (), "utf-8"));
       }catch (UnsupportedEncodingException uee){
           uee.printStackTrace ();
       }try{
            while ((linea = stdOutErr.readLine ()) != null){
                tResultado.setText(tResultado.getText()+linea+"\n");
            }
       }catch (IOException ie){
           ie.printStackTrace ();
       }
        System.out.println(MostrarTodoElResultado);   
   }
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TxtComando = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tResultado = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TxtComando.setBackground(new java.awt.Color(153, 153, 153));
        TxtComando.setFont(new java.awt.Font("Vrinda", 0, 14)); // NOI18N
        TxtComando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtComandoActionPerformed(evt);
            }
        });
        TxtComando.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtComandoKeyPressed(evt);
            }
        });

        tResultado.setBackground(new java.awt.Color(0, 0, 0));
        tResultado.setColumns(20);
        tResultado.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        tResultado.setForeground(new java.awt.Color(0, 255, 0));
        tResultado.setLineWrap(true);
        tResultado.setRows(5);
        jScrollPane1.setViewportView(tResultado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(TxtComando, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtComando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtComandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtComandoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtComandoActionPerformed

    private void TxtComandoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtComandoKeyPressed

        tResultado.setText("");	
       
        if(System.getProperty("os.name").charAt(0)=='W'){
            try {                
               Shellwindows();
            } catch (IOException ex) {
                Logger.getLogger(Shell.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            ShellLinux();
    }//GEN-LAST:event_TxtComandoKeyPressed

    
    /**
     * @param args the command line arguments
     */
   
    
    public static void main(String args[]) {
    try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
             java.awt.EventQueue.invokeLater(new Runnable() {
                 public void run() {
                     new Shell().setVisible(true);
                 }
             });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Shell.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Shell.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Shell.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Shell.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Shell().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtComando;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea tResultado;
    // End of variables declaration//GEN-END:variables
}
