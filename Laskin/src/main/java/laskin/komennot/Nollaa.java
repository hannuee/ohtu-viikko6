/**
 * @author Hannu
 */
package laskin.komennot;

import laskin.Sovelluslogiikka;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa implements Komento {
    
    private TextField tuloskentta; 
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    private int nollattu;

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }
    
    @Override
    public void suorita() {
        nollattu = sovellus.tulos();
        sovellus.nollaa();
        
        int laskunTulos = sovellus.tulos();
        
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        
        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }
    
    @Override
    public void peru() {
        sovellus.plus(nollattu);
        
        int laskunTulos = sovellus.tulos();
        
        tuloskentta.setText("" + laskunTulos);
        
        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        
        undo.disableProperty().set(true);
    }
    
}
