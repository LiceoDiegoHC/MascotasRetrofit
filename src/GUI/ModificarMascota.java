package GUI;

import API.Cliente;
import Interfaces.Respuesta;
import java.util.List;
import javax.swing.JOptionPane;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModificarMascota extends javax.swing.JDialog {

    private int id;
    private List<Respuesta> res;

    public ModificarMascota(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textTipo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textEdad = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Nombre:");

        textNombre.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("Tipo");

        textTipo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setText("Edad");

        textEdad.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(textNombre)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textTipo)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textEdad)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ModificarMascota();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField textEdad;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textTipo;
    // End of variables declaration//GEN-END:variables

    public void setDatos(int id, String nombre, String tipo, int edad){
        textNombre.setText(nombre);
        textTipo.setText(tipo);
        textEdad.setText(edad+"");
        this.id = id;
    }
    
    private void ModificarMascota(){
        String nombre = textNombre.getText().trim();
        String tipo = textTipo.getText().trim();
        int edad = Integer.parseInt(textEdad.getText().toString());
        
        Call<List<Respuesta>> call = Cliente
                .getInstance()
                .getMyApi()
                .ModificarMascota(id, nombre, tipo, edad);
        
        call.enqueue(new Callback<List<Respuesta>>(){
            @Override
            public void onResponse(Call<List<Respuesta>> call, Response<List<Respuesta>> rspns) {
                if(rspns != null && rspns.isSuccessful()){
                    res = rspns.body();
                    if(res.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Error en la peticion");
                    }else{
                        JOptionPane.showMessageDialog(null, res.get(0).getRespuesta());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Respuesta>> call, Throwable thrwbl) {
                JOptionPane.showMessageDialog(null, "Error en el servidor");
            }
            
        });

    }
    
}
