package Controller;

import View.View;
import Model.Model;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 *
 * @author David Berardi
 */
public class Controller {
    private final Model model;
    private final View view;
        
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    
        this.view.addButtonListener((ActionEvent e) -> {
            int button = Integer.parseInt(((JButton)e.getSource()).getName());
            
            if(this.model.current.size() <= 1) {
                this.model.show(button);
                this.model.current.add(button);
            }
            
            if(this.model.current.size() == 2) {
                boolean removable = this.model.isMatch();
                if(removable) this.model.setRemovable(true);
                this.model.current.clear();
                this.model.setRemovable(false);
            }
        });
    }
}
