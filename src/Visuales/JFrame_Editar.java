/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visuales;

import Modelos.ArboldeVersiones;
import Modelos.ListadeObjetos;
import Modelos.Version;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import com.threed.jpct.Primitives;
import com.threed.jpct.SimpleVector;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author G40
 */
public final class JFrame_Editar extends javax.swing.JFrame {

    /**
     * Creates new form JFrame_Editar
     */
    ArboldeVersiones arbol;
    Version versionNueva;
    int versionAnum;
    JFrame_ArbolVersiones VisuaArbol;
    JFrame_Visualizar vtodo;
    boolean cambio = false;

    ListadeObjetos listaTemporal;
    Color colorPlanoTemp;
    ListadeObjetos listaini;
    Color colorPlanoini;

    public JFrame_Editar() {
        initComponents();
        this.jColorChooser_Solido.setBounds(-90, -40, 500, 500);
        this.jColorChooser_Plano.setBounds(-90, -40, 500, 500);
        this.setLocationRelativeTo(this);
        this.setResizable(false);
        this.jButton_Guardar.setEnabled(false);
    }

    public void Modificar(ArboldeVersiones arbol, int VersionAnum) {
        this.arbol = arbol;
        this.versionAnum = VersionAnum;
        this.arbol.Ubicar(this.versionAnum);
        this.listaTemporal = (this.arbol.temp.Lista.PorValor());
        this.listaini = (this.arbol.temp.Lista.PorValor());
        this.colorPlanoTemp = this.arbol.temp.getEspacioCol();
        this.jColorChooser_Plano.setColor(this.colorPlanoTemp);
        this.colorPlanoini = this.arbol.temp.getEspacioCol();
        actualizarWorld();
//        this.listaTemporal.ubicaraUltimo();
        this.listaTemporal.temp = this.listaTemporal.cabeza;
        if (this.listaTemporal.temp != null) {
            actualizarConfig();
            mirarEn();
        }
    }

    public void actualizarWorld() {
        this.panelVisual.CrearWorld((listaTemporal.PorValor()), colorPlanoTemp, 0);
    }

    public void mirarEn() {
        this.listaTemporal.getTemp().actSV();
        this.panelVisual.mirarA(this.listaTemporal.getTemp().getSVector(), (int) this.listaTemporal.getTemp().getObjeto().getScale(), 1);
    }

    public void actualizarConfig() {
        if (this.listaTemporal.getTemp() != null) {
            this.jTextField_X.setText(this.listaTemporal.getTemp().getPosX() + "");
            this.jTextField_Y.setText(this.listaTemporal.getTemp().getPosY() + "");
            this.jTextField_Z.setText(this.listaTemporal.getTemp().getPosZ() + "");
            this.jTextField_Tamaño.setText((int) this.listaTemporal.getTemp().getObjeto().getScale() + "");
            this.jColorChooser_Solido.setColor(this.listaTemporal.getTemp().getObjeto().getAdditionalColor());
            this.jColorChooser_Plano.setColor(this.colorPlanoTemp);
            this.jComboBox_texturas.setSelectedItem((this.listaTemporal.getTemp().getTextura()));
        } else {
            this.jTextField_X.setText(0 + "");
            this.jTextField_Y.setText(0 + "");
            this.jTextField_Z.setText(0 + "");
            this.jTextField_Tamaño.setText(1 + "");
            this.jColorChooser_Solido.setColor(Color.BLUE);
            this.jColorChooser_Plano.setColor(this.colorPlanoTemp);
            this.jComboBox_texturas.setSelectedItem("predeterminada");
        }
    }

    public void flagguardar() {
        this.cambio = false;
        if (this.colorPlanoini != this.colorPlanoTemp) {
            this.cambio = true;
        } else if (this.listaTemporal.lengthlist() != this.listaini.lengthlist()) {
            this.cambio = true;
        } else {
            this.cambio = (this.listaTemporal.PorValor()).comparar(listaini.PorValor());
        }
        this.jButton_Guardar.setEnabled(this.cambio);
    }

    public boolean esValido(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (Exception e) {
            return false;
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

        jButton_Visualizar = new javax.swing.JButton();
        jButton_Guardar = new javax.swing.JButton();
        jButton_Cancelar = new javax.swing.JButton();
        panelVisual = new Visuales.PanelVisual();
        jButton_Siguiente = new javax.swing.JButton();
        jBotton_Anterior = new javax.swing.JButton();
        jButton_Crear = new javax.swing.JButton();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jTextField_X = new javax.swing.JTextField();
        jTextField_Y = new javax.swing.JTextField();
        jTextField_Z = new javax.swing.JTextField();
        jComboBox_texturas = new javax.swing.JComboBox<>();
        jLabel_X = new javax.swing.JLabel();
        jLabel_Y = new javax.swing.JLabel();
        jLabel_Z = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton_RX = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField_Tamaño = new javax.swing.JTextField();
        jButton_RZ = new javax.swing.JButton();
        jButton_RY = new javax.swing.JButton();
        jButton_info = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jColorChooser_Solido = new javax.swing.JColorChooser();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jColorChooser_Plano = new javax.swing.JColorChooser();
        jButton_Actualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton_Eliminar = new javax.swing.JButton();
        jButton_zoom1 = new javax.swing.JButton();
        jButton_zoom = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Panel de edición");

        jButton_Visualizar.setText("Visualizar todo");
        jButton_Visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_VisualizarActionPerformed(evt);
            }
        });

        jButton_Guardar.setText("Guardar");
        jButton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarActionPerformed(evt);
            }
        });

        jButton_Cancelar.setText("Cancelar");
        jButton_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelVisualLayout = new javax.swing.GroupLayout(panelVisual);
        panelVisual.setLayout(panelVisualLayout);
        panelVisualLayout.setHorizontalGroup(
            panelVisualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
        );
        panelVisualLayout.setVerticalGroup(
            panelVisualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );

        jButton_Siguiente.setText("Siguiente");
        jButton_Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SiguienteActionPerformed(evt);
            }
        });

        jBotton_Anterior.setText("Anterior");
        jBotton_Anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotton_AnteriorActionPerformed(evt);
            }
        });

        jButton_Crear.setText("Crear nuevo solido");
        jButton_Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CrearActionPerformed(evt);
            }
        });

        jComboBox_texturas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "predeterminada", "metal", "liso", "madera", "ladrillos", "arrugado", "escamas" }));

        jLabel_X.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_X.setText("X");

        jLabel_Y.setForeground(new java.awt.Color(0, 102, 255));
        jLabel_Y.setText("Y");

        jLabel_Z.setForeground(new java.awt.Color(0, 204, 0));
        jLabel_Z.setText("Z");

        jLabel5.setText("Coordenadas:");

        jLabel6.setText("Texturas");

        jLabel7.setText("Rotación en:");

        jButton_RX.setText("eje X");
        jButton_RX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RXActionPerformed(evt);
            }
        });

        jLabel8.setText("Escala de tamaño");

        jButton_RZ.setText("eje Z");
        jButton_RZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RZActionPerformed(evt);
            }
        });

        jButton_RY.setText("eje Y");
        jButton_RY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RYActionPerformed(evt);
            }
        });

        jButton_info.setText("info");
        jButton_info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_infoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_X)
                            .addComponent(jLabel_Z)
                            .addComponent(jLabel_Y))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField_Y, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                            .addComponent(jTextField_X)
                            .addComponent(jTextField_Z, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jComboBox_texturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton_info)
                                .addContainerGap())))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTextField_Tamaño, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(jButton_RX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_RY))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_RZ)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5))
                    .addComponent(jButton_info))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_X, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_X)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Y)
                    .addComponent(jComboBox_texturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Z, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Z))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Tamaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_RX)
                    .addComponent(jButton_RY)
                    .addComponent(jButton_RZ))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Solido", jPanel2);

        jScrollPane1.setViewportView(jColorChooser_Solido);

        jTabbedPane.addTab("Color de Solido", jScrollPane1);

        jScrollPane2.setViewportView(jColorChooser_Plano);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("Color del plano", jPanel1);

        jButton_Actualizar.setText("Actualizar");
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });

        jLabel1.setText("Edición");

        jButton_Eliminar.setText("Eliminar");
        jButton_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EliminarActionPerformed(evt);
            }
        });

        jButton_zoom1.setText("Zoom+");
        jButton_zoom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_zoom1ActionPerformed(evt);
            }
        });

        jButton_zoom.setText("Zoom-");
        jButton_zoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_zoomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelVisual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jBotton_Anterior)
                        .addGap(100, 100, 100)
                        .addComponent(jButton_Siguiente)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(154, 154, 154)
                                        .addComponent(jButton_Crear))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(200, 200, 200)
                                        .addComponent(jLabel1)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jButton_Actualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Eliminar)
                        .addGap(86, 86, 86))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jButton_zoom)
                .addGap(18, 18, 18)
                .addComponent(jButton_Visualizar)
                .addGap(18, 18, 18)
                .addComponent(jButton_zoom1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_Guardar)
                .addGap(5, 5, 5)
                .addComponent(jButton_Cancelar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Visualizar)
                    .addComponent(jButton_Guardar)
                    .addComponent(jButton_Cancelar)
                    .addComponent(jButton_zoom1)
                    .addComponent(jButton_zoom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton_Crear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(panelVisual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_Siguiente)
                            .addComponent(jBotton_Anterior)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_Actualizar)
                            .addComponent(jButton_Eliminar))
                        .addGap(13, 13, 13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed
        this.colorPlanoTemp = this.jColorChooser_Plano.getColor();
        if (this.listaTemporal.getTemp() != null) {
            int aux;
            this.listaTemporal.getTemp().getObjeto().setAdditionalColor(this.jColorChooser_Solido.getColor());
            this.listaTemporal.getTemp().setTextura(this.jComboBox_texturas.getSelectedItem().toString());
            if (esValido(this.jTextField_X.getText())) {
                aux = Integer.parseInt(this.jTextField_X.getText());
                if (aux < 0) {
                    aux = 0;
                }
                if (aux != this.listaTemporal.getTemp().getPosX()) {
                    this.listaTemporal.getTemp().getObjeto().translate(-this.listaTemporal.temp.getPosX(), -this.listaTemporal.temp.getPosY(), -this.listaTemporal.temp.getPosZ());
                    this.listaTemporal.getTemp().setPosX(aux);
                    this.listaTemporal.getTemp().getObjeto().translate(this.listaTemporal.getTemp().SVector);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El numero que digito en X: No es Valido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (esValido(this.jTextField_Y.getText())) {
                aux = Integer.parseInt(this.jTextField_Y.getText());
                if (aux < 0) {
                    aux = 0;
                }
                if (aux != this.listaTemporal.getTemp().getPosY()) {
                    this.listaTemporal.getTemp().getObjeto().translate(-this.listaTemporal.temp.getPosX(), -this.listaTemporal.temp.getPosY(), -this.listaTemporal.temp.getPosZ());
                    this.listaTemporal.getTemp().setPosY(aux);
                    this.listaTemporal.getTemp().getObjeto().translate(this.listaTemporal.getTemp().SVector);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El numero que digito en Y: No es Valido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (esValido(this.jTextField_Z.getText())) {
                aux = Integer.parseInt(this.jTextField_Z.getText());
                if (aux < 0) {
                    aux = 0;
                }
                if (aux != this.listaTemporal.getTemp().getPosZ()) {
                    this.listaTemporal.getTemp().getObjeto().translate(-this.listaTemporal.temp.getPosX(), -this.listaTemporal.temp.getPosY(), -this.listaTemporal.temp.getPosZ());
                    this.listaTemporal.getTemp().setPosZ(aux);
                    this.listaTemporal.getTemp().getObjeto().translate(this.listaTemporal.getTemp().SVector);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El numero que digito en Z: No es Valido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (esValido(this.jTextField_Tamaño.getText()) && (Integer.parseInt(this.jTextField_Tamaño.getText())) > 0) {
                aux = (Integer.parseInt(this.jTextField_Tamaño.getText()));
                if (aux < 1) {
                    aux = 1;
                } else if (aux > 5) {
                    aux = 5;
                }
                this.listaTemporal.getTemp().Tamaño(aux);
            } else {
                JOptionPane.showMessageDialog(null, "El tamaño: NO es Valido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            actualizarWorld();
            mirarEn();
            actualizarConfig();
        } else {
            actualizarWorld();
        }
        flagguardar();
    }//GEN-LAST:event_jButton_ActualizarActionPerformed

    private void jButton_CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CrearActionPerformed
        int n = -1;
        n = JOptionPane.showOptionDialog(null, "Elija el tipo de solido que desea crear: ", "Creación de solido", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Cubo", "Piraminde", "Cilindro", "Esfera", "cono", "Doble cono", "Elipsoide"}, "Elegir");
        switch (n) {
            case 0:
                this.listaTemporal.IngresarObjeto(Primitives.getCube(50));
                break;
            case 1:
                this.listaTemporal.IngresarObjeto(Primitives.getPyramide(50));
                break;
            case 2:
                this.listaTemporal.IngresarObjeto(Primitives.getCylinder(50));
                break;
            case 3:
                this.listaTemporal.IngresarObjeto(Primitives.getSphere(50));
                break;
            case 4:
                this.listaTemporal.IngresarObjeto(Primitives.getCone(50));
                break;
            case 5:
                this.listaTemporal.IngresarObjeto(Primitives.getDoubleCone(50));
                break;
            case 6:
                this.listaTemporal.IngresarObjeto(Primitives.getEllipsoid(50, 1.5f));
                break;
        }
        if (n != -1) {
            this.jButton_Guardar.setEnabled(true);
            this.listaTemporal.ubicaraUltimo();
            this.listaTemporal.getTemp().getObjeto().rotateX((float) Math.PI);
            actualizarConfig();
            actualizarWorld();
            mirarEn();
        }
    }//GEN-LAST:event_jButton_CrearActionPerformed

    private void jButton_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelarActionPerformed
        this.VisuaArbol = new JFrame_ArbolVersiones();
        this.VisuaArbol.IniciarArbolVersiones(this.arbol, this.versionAnum);
        this.VisuaArbol.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton_CancelarActionPerformed

    private void jButton_VisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_VisualizarActionPerformed
        vtodo = new JFrame_Visualizar();
        vtodo.inicializar((listaTemporal.PorValor()), colorPlanoTemp);
        if (!this.listaTemporal.estaVacia()) {
            vtodo.mirarEn(this.listaTemporal.getUltimo().getSVector(), ((int) this.listaTemporal.getUltimo().getObjeto().getScale()), 2);
        }
        vtodo.setVisible(true);
    }//GEN-LAST:event_jButton_VisualizarActionPerformed

    private void jButton_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_infoActionPerformed
        JOptionPane.showMessageDialog(null, "Posición en X, Y y Z debe ser mayor que 0 \n La escala de tamaño debe ser entre 1 y 5 \n\n\n\nRecomendaciones: \n Usar colores oscuros para las texturas arrugado y madera", "Información", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton_infoActionPerformed

    private void jButton_RXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RXActionPerformed
        if (this.listaTemporal.getTemp() != null) {
            this.listaTemporal.getTemp().getObjeto().rotateX((float) Math.PI / 4f);
            this.jButton_Guardar.setEnabled(true);
        }
    }//GEN-LAST:event_jButton_RXActionPerformed

    private void jButton_RYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RYActionPerformed
        if (this.listaTemporal.getTemp() != null) {
            this.listaTemporal.getTemp().getObjeto().rotateY((float) Math.PI / 4f);
            this.jButton_Guardar.setEnabled(true);
        }
    }//GEN-LAST:event_jButton_RYActionPerformed

    private void jButton_RZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RZActionPerformed
        if (this.listaTemporal.getTemp() != null) {
            this.listaTemporal.getTemp().getObjeto().rotateZ((float) Math.PI / 4f);
            this.jButton_Guardar.setEnabled(true);
        }
    }//GEN-LAST:event_jButton_RZActionPerformed

    private void jButton_SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SiguienteActionPerformed
        if (this.listaTemporal.getTemp() != null) {
            this.listaTemporal.pasarSig();
            mirarEn();
            actualizarConfig();
        }
    }//GEN-LAST:event_jButton_SiguienteActionPerformed

    private void jBotton_AnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotton_AnteriorActionPerformed
        if (this.listaTemporal.getTemp() != null) {
            this.listaTemporal.pasarant();
            mirarEn();
            actualizarConfig();
        }
    }//GEN-LAST:event_jBotton_AnteriorActionPerformed

    private void jButton_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminarActionPerformed
        if (this.listaTemporal.getTemp() != null) {
            this.listaTemporal.eliminar();
            this.actualizarWorld();
            this.actualizarConfig();
            flagguardar();
        }
    }//GEN-LAST:event_jButton_EliminarActionPerformed

    private void jButton_zoom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_zoom1ActionPerformed
        this.panelVisual.zoom(1);
    }//GEN-LAST:event_jButton_zoom1ActionPerformed

    private void jButton_zoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_zoomActionPerformed
        this.panelVisual.zoom(-1);
    }//GEN-LAST:event_jButton_zoomActionPerformed

    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarActionPerformed
        versionNueva = new Version(colorPlanoTemp);
        versionNueva.setLista((this.listaTemporal.PorValor()));
        this.arbol.Actualizar(this.versionAnum, versionNueva);
        this.VisuaArbol = new JFrame_ArbolVersiones();
        this.VisuaArbol.IniciarArbolVersiones(this.arbol, this.arbol.ultimaV);
        this.VisuaArbol.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton_GuardarActionPerformed

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
            java.util.logging.Logger.getLogger(JFrame_Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame_Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame_Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame_Editar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotton_Anterior;
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_Cancelar;
    private javax.swing.JButton jButton_Crear;
    private javax.swing.JButton jButton_Eliminar;
    private javax.swing.JButton jButton_Guardar;
    private javax.swing.JButton jButton_RX;
    private javax.swing.JButton jButton_RY;
    private javax.swing.JButton jButton_RZ;
    private javax.swing.JButton jButton_Siguiente;
    private javax.swing.JButton jButton_Visualizar;
    private javax.swing.JButton jButton_info;
    private javax.swing.JButton jButton_zoom;
    private javax.swing.JButton jButton_zoom1;
    private javax.swing.JColorChooser jColorChooser_Plano;
    private javax.swing.JColorChooser jColorChooser_Solido;
    private javax.swing.JComboBox<String> jComboBox_texturas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_X;
    private javax.swing.JLabel jLabel_Y;
    private javax.swing.JLabel jLabel_Z;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTextField jTextField_Tamaño;
    private javax.swing.JTextField jTextField_X;
    private javax.swing.JTextField jTextField_Y;
    private javax.swing.JTextField jTextField_Z;
    private Visuales.PanelVisual panelVisual;
    // End of variables declaration//GEN-END:variables
}
