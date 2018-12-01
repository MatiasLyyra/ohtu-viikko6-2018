package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.komennot.Komento;
import laskin.komennot.Miinus;
import laskin.komennot.Nollaa;
import laskin.komennot.Summa;

import java.util.HashMap;
import java.util.Map;

public class Tapahtumankuuntelija implements EventHandler {
    private Button undo;
    private Sovelluslogiikka sovellus;
    private Map<Button, Komento> komennot;
    private Komento edellinen;

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
        edellinen = null;
        this.undo = undo;
        this.sovellus = new Sovelluslogiikka();
        komennot = new HashMap<>();
        komennot.put(plus, new Summa(tuloskentta, syotekentta, nollaa, undo, sovellus));
        komennot.put(miinus, new Miinus(tuloskentta, syotekentta, nollaa, undo, sovellus));
        komennot.put(nollaa, new Nollaa(tuloskentta, syotekentta, nollaa, undo, sovellus));
    }
    
    @Override
    public void handle(Event event) {
        if(event.getTarget() != undo) {
            Komento komento = komennot.get((Button)event.getTarget());
            komento.suorita();
            edellinen = komento;
        } else {
            edellinen.peru();
        }
    }

}
