/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import banco.CategoriaRecurso;
import main.Recurso;
import banco.TipoRecurso;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import main.ConexaoBD;

/**
 *
 * @author garym
 */
public class jfRecursos extends javax.swing.JFrame {

    /**
     * Creates new form jfRecursos
     */
    
    private ConexaoBD banco;
    
    public jfRecursos(){}
    
    public jfRecursos(ConexaoBD b) {
        initComponents();
        this.banco = b;
        preencherTabela(banco);
        preencherComboBoxTipo();
        preencherComboBoxCategoria();
    }
    
    public ConexaoBD getConexao(){
        return this.banco;
    }
    
    private void preencherTabela(ConexaoBD banco){
        DefaultTableModel dtmRecursos = (DefaultTableModel)jTRecursos.getModel();
        try{
            ResultSet dados = banco.select("SELECT RECURSO.NOME AS NOME, TIPO_RECURSO.NOME AS NOME_RECURSO, CATEGORIA_RECURSO.DESCRICAO AS DESCRICAO FROM RECURSO INNER JOIN TIPO_RECURSO ON RECURSO.ID_TIPORECURSO = TIPO_RECURSO.ID_TIPORECURSO INNER JOIN CATEGORIA_RECURSO ON RECURSO.ID_CATEGORIA = CATEGORIA_RECURSO.ID_CATEGORIA;");
            
            while(dados.next()){
                Object[] linha = {dados.getString("nome"),dados.getString("nome_recurso"),dados.getString("descricao")};
                dtmRecursos.addRow(linha);
            }
        }catch(SQLException ioe){
        }
    }
    
    private void resetTabela(){
        DefaultTableModel dtm = (DefaultTableModel)jTRecursos.getModel();
        dtm.setRowCount(0);
        this.preencherTabela(banco);
    }
    
    private void preencherComboBoxTipo(){
        ResultSet dados = banco.select("SELECT * FROM TIPO_RECURSO");
        
        try{
            while(dados.next()){
                //Recurso r = new Recurso(campoTextoNomeRecurso.getText(), comboBoxTipo.getSelectedItem(), campoTextoCategoriaRecurso.getText());
                TipoRecurso tr = new TipoRecurso(dados.getInt("id_tiporecurso"), dados.getString("nome"));
                comboBoxTipo.addItem(tr);
            }
        } catch(SQLException e){
        }
    }
    
    private void preencherComboBoxCategoria(){
        ResultSet dados = banco.select("SELECT * FROM CATEGORIA_RECURSO");
        
        try{
            while(dados.next()){
                //Recurso r = new Recurso(campoTextoNomeRecurso.getText(), comboBoxTipo.getSelectedItem(), campoTextoCategoriaRecurso.getText());
                CategoriaRecurso cr = new CategoriaRecurso(dados.getInt("id_categoria"), dados.getString("descricao"));
                comboBoxCategoria.addItem(cr);
            }
        } catch(SQLException e){
        }
    }
    
    public void resetComboBox(){
        // Reseta os dois combobox
        comboBoxTipo.removeAllItems();
        comboBoxCategoria.removeAllItems();
        preencherComboBoxTipo();
        preencherComboBoxCategoria();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTRecursos = new javax.swing.JTable();
        botaoNovoRecurso = new javax.swing.JButton();
        campoTextoNomeRecurso = new javax.swing.JTextField();
        labelRecurso = new javax.swing.JLabel();
        labelTipo = new javax.swing.JLabel();
        labelDescricao = new javax.swing.JLabel();
        botaoExcluirRecurso = new javax.swing.JButton();
        comboBoxTipo = new javax.swing.JComboBox<>();
        comboBoxCategoria = new javax.swing.JComboBox<>();
        botaoNovoTipoECat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(450, 250));

        jTRecursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Recurso", "Tipo", "Descrição"
            }
        ));
        jTRecursos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTRecursos);

        botaoNovoRecurso.setText("Cadastrar Recurso");
        botaoNovoRecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoRecursoActionPerformed(evt);
            }
        });

        labelRecurso.setText("Recurso");

        labelTipo.setText("Tipo");

        labelDescricao.setText("Categoria");

        botaoExcluirRecurso.setText("Excluir Recurso");
        botaoExcluirRecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirRecursoActionPerformed(evt);
            }
        });

        botaoNovoTipoECat.setText("Cadastrar novos tipos e categorias");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoTextoNomeRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelRecurso))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTipo)
                            .addComponent(comboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelDescricao)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(comboBoxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoExcluirRecurso))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoNovoRecurso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(botaoNovoTipoECat)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRecurso)
                    .addComponent(labelTipo)
                    .addComponent(labelDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoNomeRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoNovoRecurso)
                    .addComponent(botaoNovoTipoECat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoExcluirRecurso)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoNovoRecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoRecursoActionPerformed
        // TODO add your handling code here:
        Recurso r = new Recurso(campoTextoNomeRecurso.getText(),(TipoRecurso)comboBoxTipo.getSelectedItem(),(CategoriaRecurso)comboBoxCategoria.getSelectedItem());
        r.salvar(banco);
        this.resetTabela();
    }//GEN-LAST:event_botaoNovoRecursoActionPerformed

    private void botaoExcluirRecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirRecursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoExcluirRecursoActionPerformed

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
            java.util.logging.Logger.getLogger(jfRecursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfRecursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfRecursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfRecursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfRecursos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoExcluirRecurso;
    private javax.swing.JButton botaoNovoRecurso;
    private javax.swing.JButton botaoNovoTipoECat;
    private javax.swing.JTextField campoTextoNomeRecurso;
    private javax.swing.JComboBox<Object> comboBoxCategoria;
    private javax.swing.JComboBox<Object> comboBoxTipo;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTRecursos;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelRecurso;
    private javax.swing.JLabel labelTipo;
    // End of variables declaration//GEN-END:variables
}
