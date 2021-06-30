/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visuales;

import Modelos.ListadeObjetos;
import com.threed.jpct.*;
import com.threed.jpct.FrameBuffer;
import com.threed.jpct.Object3D;
import com.threed.jpct.Primitives;
import com.threed.jpct.Texture;
import com.threed.jpct.TextureManager;
import com.threed.jpct.World;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author G40
 */
public final class PanelVisual extends javax.swing.JPanel {

    /**
     * Creates new form PanelVisual
     */
    FrameBuffer buffer;
    World world;
    Object3D Xp;
    Object3D Yp;
    Object3D Zp;
    ListadeObjetos ListaObjetosA = new ListadeObjetos();
    Color colorEspacio = java.awt.Color.WHITE;

    public PanelVisual() {
        initComponents();
        buffer = new FrameBuffer(800, 800, FrameBuffer.SAMPLINGMODE_NORMAL);
        TextureManager.getInstance().addTexture("eje", new Texture("ejes.jpg"));
        TextureManager.getInstance().addTexture("predeterminada", new Texture("box.jpg"));
        TextureManager.getInstance().addTexture("metal", new Texture("metal.jpg"));
        TextureManager.getInstance().addTexture("arrugado", new Texture("arrugado.jpg"));
        TextureManager.getInstance().addTexture("escamas", new Texture("escamas.jpg"));
        TextureManager.getInstance().addTexture("ladrillos", new Texture("ladrillos.jpg"));
        TextureManager.getInstance().addTexture("liso", new Texture("liso.jpg"));
        TextureManager.getInstance().addTexture("madera", new Texture("madera.jpg"));
        crearNuevoWorld(1);
    }

    public void crearNuevoWorld(int t) {
        if (t == 0) {
            buffer = new FrameBuffer(359, 345, FrameBuffer.SAMPLINGMODE_NORMAL);
        }
        this.world = new World();
        world.setAmbientLight(255, 255, 255);
        Xp = Primitives.getCylinder(2, 2, 1000);
        Yp = Primitives.getCylinder(2, 2, 1000);
        Zp = Primitives.getCylinder(2, 2, 1000);
        Xp.translate(2000, 0, 0);
        Yp.translate(0, 2000, 0);
        Zp.translate(0, 0, 2000);
        Xp.setTexture("eje");
        Yp.setTexture("eje");
        Zp.setTexture("eje");
        Xp.setAdditionalColor(Color.red);
        Yp.setAdditionalColor(Color.blue);
        Zp.setAdditionalColor(Color.green);
        Xp.build();
        Yp.build();
        Zp.build();
        world.addObject(Xp);
        world.addObject(Yp);
        world.addObject(Zp);
        Xp.rotateZ((float) Math.PI / 2f);
        Zp.rotateX((float) Math.PI / 2f);

        world.getCamera().setPosition(333, 112, 548);
        world.getCamera().lookAt(SimpleVector.create(0, 0, 0));
        world.getCamera().rotateCameraZ((float) Math.PI);
    }

    public void CrearWorld(ListadeObjetos listaTempA, Color colorEspacio, int t) {   
        crearNuevoWorld(t);
        this.colorEspacio = colorEspacio; 
        this.ListaObjetosA = listaTempA;
        Object3D aux;
         
        for (int i = 0; i < this.ListaObjetosA.lengthlist(); i++) {
           this.ListaObjetosA.ubicarNodo(i);
            aux = ListaObjetosA.getTemp().getObjeto();
            aux.setTexture(ListaObjetosA.getTemp().getTextura());
            aux.setEnvmapped(Object3D.ENVMAP_ENABLED);
            aux.build();
            world.addObject(aux);
        }
    }

    public void mirarA(SimpleVector objeto, int escala, int e2) {
        int escalaV = (e2 * 100) * escala;
        this.world.getCamera().setPosition((objeto.x) + (escalaV), (objeto.y) + (escalaV), (objeto.z) + (escalaV));
        this.world.getCamera().lookAt(objeto);
        world.getCamera().rotateCameraZ((float) Math.PI);
    }

    public void zoom(int z) {
        if (z == -1) {
            world.getCamera().moveCamera(2, 20f);
        } else {
            world.getCamera().moveCamera(1, 20f);
        }
    }

    public void movcam(int m) {
        switch (m) {
            case 0:
                world.getCamera().rotateCameraX(-0.05f);
                break;
            case 1:
                world.getCamera().rotateCameraX(0.05f);
                break;
            case 2:
                world.getCamera().rotateCameraZ(0.05f);
                break;
            case 3:
                world.getCamera().rotateCameraZ(-0.05f);
                break;
            case 4:
                world.getCamera().rotateCameraY(-0.05f);
                break;
            case 5:
                world.getCamera().rotateCameraY(0.05f);
                break;
            case 6:
                world.getCamera().moveCamera(1, 15f);
                break;
            case 7:
                world.getCamera().moveCamera(2, 15f);
                break;
            case 8:
                world.getCamera().moveCamera(6, 15f);
                break;
            case 9:
                world.getCamera().moveCamera(5, 15f);
                break;
            case 10:
                world.getCamera().moveCamera(3, 15f);
                break;
            case 11:
                world.getCamera().moveCamera(4, 15f);
                break;
            default:
                break;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        buffer.clear(colorEspacio);
        world.renderScene(buffer);
        world.draw(buffer);
        buffer.update();
        buffer.display(g);
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
