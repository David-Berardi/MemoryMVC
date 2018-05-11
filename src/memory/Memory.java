package memory;

import Controller.Controller;
import View.View;
import Model.Model;

/**
 *
 * @author David Berardi
 */
public class Memory {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);
        
        java.awt.EventQueue.invokeLater(() -> {
            view.setVisible(true);
        });
    }
}
