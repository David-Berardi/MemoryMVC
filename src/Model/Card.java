package Model;

/**
 *
 * @author David Berardi
 */
public class Card {
    private final int id;
    private boolean clicked = false;
    
    public Card(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }
    
    public boolean isClicked() {
        return this.clicked;
    }
    
    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
}
