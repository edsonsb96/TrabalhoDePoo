
package view;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import main.ConexaoBD;

public class jfModelos extends javax.swing.JFrame {

    private ConexaoBD banco;
    
    public jfModelos(){}
    
    public jfModelos(ConexaoBD b) {
        initComponents();
        this.banco = b;
        preencherTabela(banco);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public ConexaoBD getConexao(){
        return this.banco;
    }
    
    private void preencherTabela(ConexaoBD banco){
        DefaultTableModel dtmModelos = (DefaultTableModel)jTModelos.getModel();
        try{
            ResultSet dados = banco.select("SELECT NOME FROM MODELO");
            
            while(dados.next()){
                Object[] linha = {/*dados.getInt("ID_Modelo"),*/ dados.getString("nome")};
                dtmModelos.addRow(linha);
            }
        }catch(SQLException ioe){
        }
    }
    
    public void resetTabela(){
        DefaultTableModel dtm = (DefaultTableModel) jTModelos.getModel();
        dtm.setRowCount(0);
        this.preencherTabela(banco);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTModelos = new javax.swing.JTable();
        botaoNovoModelo = new javax.swing.JButton();
        botaoEditarModelo = new javax.swing.JButton();
        botaoInstanciarModelo = new javax.swing.JButton();
        botaoExcluirModelo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modelos");
        setLocation(new java.awt.Point(450, 200));

        jTModelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Modelos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTModelos.setColumnSelectionAllowed(true);
        jTModelos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTModelos);
        jTModelos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTModelos.getColumnModel().getColumnCount() > 0) {
            jTModelos.getColumnModel().getColumn(0).setResizable(false);
        }

        botaoNovoModelo.setText("Novo Modelo");
        botaoNovoModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoModeloActionPerformed(evt);
            }
        });

        botaoEditarModelo.setText("Editar");

        botaoInstanciarModelo.setText("Novo Projeto");
        botaoInstanciarModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoInstanciarModeloActionPerformed(evt);
            }
        });

        botaoExcluirModelo.setText("Excluir Modelo");
        botaoExcluirModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirModeloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoExcluirModelo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(botaoNovoModelo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoEditarModelo)
                            .addGap(18, 18, 18)
                            .addComponent(botaoInstanciarModelo))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoNovoModelo)
                    .addComponent(botaoEditarModelo)
                    .addComponent(botaoInstanciarModelo))
                .addGap(3, 3, 3)
                .addComponent(botaoExcluirModelo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoNovoModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoModeloActionPerformed
        // TODO add your handling code here:
        jfNovoModelo obj = new jfNovoModelo(this);
        obj.setVisible(true);
    }//GEN-LAST:event_botaoNovoModeloActionPerformed

    private void botaoInstanciarModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoInstanciarModeloActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_botaoInstanciarModeloActionPerformed

    private void botaoExcluirModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirModeloActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtmModelos = (DefaultTableModel)jTModelos.getModel();
        if (jTModelos.getSelectedRow() >= 0){
            dtmModelos.removeRow(jTModelos.getSelectedRow());
            Object r = jTModelos.getSelectedRow();
            jTModelos.setModel(dtmModelos);
        }else{
            JOptionPane.showMessageDialog(null, "Favor selecionar uma linha");
        }
    }//GEN-LAST:event_botaoExcluirModeloActionPerformed

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
            java.util.logging.Logger.getLogger(jfModelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfModelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfModelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfModelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfModelos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEditarModelo;
    private javax.swing.JButton botaoExcluirModelo;
    private javax.swing.JButton botaoInstanciarModelo;
    private javax.swing.JButton botaoNovoModelo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTModelos;
    // End of variables declaration//GEN-END:variables
}
