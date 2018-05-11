package View;

import Model.Model;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author David Berardi
 */
public class View extends javax.swing.JFrame implements Observer{
    private Model model;
    private ImageIcon[] images;
    public List<JButton> buttons;
    private ImageIcon hidden;
    
    public View() {
        initComponents();
    }

    public View(Model model) {
        this();
        this.model = model;
        
        this.model.addObserver(this);
        
        this.setLayout(new GridLayout(4, 4));
        
        images = new ImageIcon[this.model.cards.size()];
        hidden = new ImageIcon("src/images/card8.jpeg");
        for(int i = 0; i < images.length; i++) {
            images[i] = new ImageIcon("src/images/card" + this.model.cards.get(i).getId() + ".jpeg");
        }
        
        buttons = new ArrayList<>();
        for(int i = 0; i < images.length; i++) {
            buttons.add(new JButton());
            buttons.get(i).setName("" + i);
            Component add = this.add(buttons.get(i));
        }
    }

    public void addButtonListener(ActionListener l) {
        buttons.forEach((bottone) -> {
            bottone.addActionListener(l);
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 497, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        for(int i = 0; i < model.cards.size(); i++) {
            if(model.cards.get(i).isClicked()) 
                buttons.get(i).setIcon(images[i]);
            else buttons.get(i).setIcon(hidden);
        }
        
        if(model.isRemovable()) {
            this.remove(buttons.get(model.current.get(0)));
            this.remove(buttons.get(model.current.get(1)));
        }
    }
}
