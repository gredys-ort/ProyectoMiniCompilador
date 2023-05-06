
package analisadorlexico3;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author
 */
public class JFrameAnalizador extends javax.swing.JFrame {

    File abreArchi;
    String[] token = new String[100];
    String cabecera1[] = {"No.", " Token ", " Tipo"};
    String palabra = "", reservado = "", ruta = "";
    String[] valor = new String[500];
    int[] pos = new int[500];
    int i, j, k, m = 0, size = 0, linea = 0, orden = 1, estado = 0, opcion;

 
    public JFrameAnalizador() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        EPane = new javax.swing.JEditorPane();
        btnAnLéxico = new javax.swing.JButton();
        btnMosTabla = new javax.swing.JButton();
        btnMosTokens = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(EPane);

        btnAnLéxico.setText("Analizador léxico");
        btnAnLéxico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnLéxicoActionPerformed(evt);
            }
        });

        btnMosTabla.setText("Mostrar Tabla");
        btnMosTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMosTablaActionPerformed(evt);
            }
        });

        btnMosTokens.setText("Mostrar Tokens");
        btnMosTokens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMosTokensActionPerformed(evt);
            }
        });

        tabla.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(btnMosTokens))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnAnLéxico)
                        .addGap(18, 18, 18)
                        .addComponent(btnMosTabla)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnLéxico)
                    .addComponent(btnMosTabla))
                .addGap(4, 4, 4)
                .addComponent(btnMosTokens)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnAnLéxicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnLéxicoActionPerformed
        k = 0;
        linea = 0;
        size = 0;
        orden = 1;
        estado = 0;
        try {
            File file3 = new File(ruta);
            FileInputStream file = new FileInputStream(file3);

            BufferedInputStream buff = new BufferedInputStream(file);
            int in = 0;
            do {
                in = buff.read();
                if (in != -1) {
                    if ((in >= 65 && in <= 90) || (in >= 97 && in <= 122)) {
                        if (estado == 0 || estado == 1) {
                            size++;
                            estado = 1;
                            palabra += (char) in;
                        } else if (estado == 7) {
                        } else {
                            estado = 8;
                        }
                    } else if (in > 47 && in < 58) {
                        if (estado == 0 || estado == 2) {
                            size++;
                            estado = 2;
                            palabra += (char) in;
                        } else if (estado == 1) {
                            size++;
                            estado = 1;
                            palabra += (char) in;
                        } else if (estado == 7) {
                        } else {
                            estado = 8;
                        }
                    } else if (in == 95) {
                        if (estado == 0 || estado == 1) {
                            if (size != m) {
                                size++;
                                estado = 1;
                                palabra += (char) in;
                            } else {
                                estado = 8;
                                m++;
                            }

                        } else {
                            estado = 8;
                        }
                    } else if (in == 42 || in == 43 || in == 45 || in == 47) {
                        if (estado == 0) {
                            estado = 3;
                            palabra += (char) in;
                        } else if (estado == 7) {
                        } else {
                            estado = 8;
                        }
                    } else if (in == 60 || in == 62 || in == 38) {
                        if (estado == 0) {
                            estado = 4;
                            palabra += (char) in;
                        } else if (estado == 7) {
                        } else {
                            estado = 8;
                        }
                    } else if (in == 61) {
                        if (estado == 0) {
                            estado = 4;
                            palabra += (char) in;
                        } else if (estado == 5) {
                            estado = 6;
                            palabra += (char) in;
                        } else if (estado == 7) {
                        } else {
                            estado = 8;
                        }
                    } else if (in == 58) {
                        if (estado == 0) {
                            estado = 5;
                            palabra += (char) in;
                        } else if (estado == 7) {
                        } else {
                            estado = 8;
                        }
                    } else if (in == 123) {
                        if (estado >= 1 || estado <= 6) {
                            estado = 7;
                        } else if (estado == 7) {
                        }
                    } else if (in == 125) {
                        if (estado == 7) {

                            estado = 0;
                        }
                    } else if (in == 9 || in == 32 || in == 10) {
                        if (in == 10) {
                            linea++;
                            if (estado == 7 && in == 125) {
                                estado = 0;
                            }
                        }

                        switch (estado) {
                            case 0:
                                estado = 0;
                                break;
                            case 1:
                                if (size > 8) {
                                    estado = 8;
                                } else {
                                    valor[k] = ""+3;
                                    FileReader file2 = new FileReader("reservados.txt");
                                    BufferedReader buff2 = new BufferedReader(file2);
                                    int in2;
                                    do {
                                        in2 = buff2.read();
                                        if (in2 != -1) {
                                            if (in2 >= 65 && in2 <= 90) {
                                                reservado += (char) in2;
                                            } else {
                                                if (reservado.equals(palabra)) {
                                                    valor[k] = ""+2;
                                                }
                                                reservado = "";
                                            }
                                        }
                                    } while (in2 != -1);
                                    buff2.close();
                                    pos[k] = orden;
                                    token[k] = palabra;
                                    palabra = "";
                                    size = 0;
                                    estado = 0;
                                    orden++;
                                    k++;
                                }
                                break;
                            case 2:
                                if (size > 7) {
                                    estado = 8;
                                } else {
                                    pos[k] = orden;
                                    valor[k] = "" + 1;
                                    token[k] = palabra;
                                    palabra = "";
                                    size = 0;
                                    estado = 0;
                                    orden++;
                                    k++;
                                }
                                break;
                            case 3:
                                pos[k] = orden;
                                valor[k] = "'" + palabra + "'";
                                token[k] = palabra;
                                palabra = "";
                                size = 0;
                                estado = 0;
                                orden++;
                                k++;
                                break;
                            case 4:
                                pos[k] = orden;
                                valor[k] = "'" + palabra + "'";
                                token[k] = palabra;
                                palabra = "";
                                size = 0;
                                estado = 0;
                                orden++;
                                k++;
                                break;
                            case 6:
                                pos[k] = orden;
                                valor[k] = "'" + palabra + "'";
                                token[k] = palabra;
                                palabra = "";
                                size = 0;
                                estado = 0;
                                orden++;
                                k++;
                                break;
                            case 7:
                                //ESte estado entra cuando son comentarios
                                estado = 7;
                                m = 0;
                                break;
                            case 8:
                                System.out.println("Error en la línea " + linea + " con la palabra " + palabra);
                                palabra = "";
                                size = 0;
                                estado = 0;
                                m = 0;
                                break;
                        }
                    }
                }

            } while (in != -1);

        } catch (IOException e) {
            System.out.println("Excpetion: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAnLéxicoActionPerformed

    private void btnMosTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMosTablaActionPerformed

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Token", "Cantidad", "Tipo"});

        System.out.println("Pos\t\tNombre\t\tClase");
        try {
            FileWriter file = new FileWriter("simbolos.txt", false);
            BufferedWriter buff = new BufferedWriter(file);
            FileReader file2 = new FileReader("reservados.txt");
            BufferedReader buff2 = new BufferedReader(file2);
            int in2;
            i = 1;
            do {
                in2 = buff2.read();
                if (in2 != -1) {
                    buff.write((char) in2);
                    if (in2 >= 65 && in2 <= 90) {
                        reservado += (char) in2;
                    }
                }
                if (in2 == 10) {
                    model.addRow(new Object[]{i, reservado, 2});
                    buff.write(i + "\t\t" + reservado + "\t\t" + valor[j] + "\n");
                    i++;
                    reservado = "";
                }

            } while (in2 != -1);
            buff2.close();
            for (j = 0; j < k; j++) {
                buff.write(i + j + "\t\t" + token[j] + "\t" + valor[j] + "\n");
                model.addRow(new Object[]{i + j, token[j], valor[j]});
            }
            buff.close();
        } catch (IOException e) {
            System.out.println("Error " + e.toString());
        }
        try {
            FileReader file = new FileReader("simbolos.txt");
            BufferedReader buff = new BufferedReader(file);
            int in2;
            do {
                in2 = buff.read();
                if (in2 != -1) {
                    System.out.print((char) in2);
                }
            } while (in2 != -1);
            buff.close();
        } catch (IOException e) {
            System.out.println("Error " + e.toString());
        }
        tabla.setModel(model);
    }//GEN-LAST:event_btnMosTablaActionPerformed

    private void btnMosTokensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMosTokensActionPerformed
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Posicion", "token", "valor"});

        for (i = 0; i <= k; i++) {
            model.addRow(new Object[]{pos[i], token[i], valor[i]});
            System.out.println(pos[i] + "\t\t" + token[i] + "\t\t" + valor[i]);
        }
        tabla.setModel(model);
    }//GEN-LAST:event_btnMosTokensActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameAnalizador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameAnalizador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameAnalizador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameAnalizador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameAnalizador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane EPane;
    private javax.swing.JButton btnAnLéxico;
    private javax.swing.JButton btnMosTabla;
    private javax.swing.JButton btnMosTokens;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
