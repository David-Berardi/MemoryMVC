package Model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

/**
 *
 * @author David Berardi
 */
public class Model extends Observable{
    public List<Card> cards;
    public ArrayList<Integer> current = new ArrayList<>();
    private boolean removable = false;
    
    public Model() {
        loadCards();
    }
    
    public void setRemovable(boolean removable) {
        this.removable = removable; 
        
        setChanged();
        notifyObservers();
    }
    
    public boolean isRemovable() {
        return this.removable;
    }
    
    public void show(int card) {
        cards.get(card).setClicked(true);
        
        setChanged();
        notifyObservers();
    }
    
    public boolean isMatch() {
        if(cards.get(current.get(0)).getId() == cards.get(current.get(1)).getId()) {
            boolean remove = cards.remove(current.get(0));
            boolean remove1 = cards.remove(current.get(1));
            return true;
        }
        else {
            cards.forEach((card) -> {
                card.setClicked(false);
            });
        }
        
        setChanged();
        notifyObservers();
        return false;
    }
    
    private void loadCards() {
        cards = new ArrayList<>();
        
        for(int i = 0; i < 8; i++) {
            cards.add(new Card(i));
            cards.add(new Card(i));
        }
        
        Collections.shuffle(cards);
    }
}
