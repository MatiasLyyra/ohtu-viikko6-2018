package laskin.komennot;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

public class Summa extends LaskinKomento {
    private Sovelluslogiikka sovellus;

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo);
        this.sovellus = sovellus;
    }

    @Override
    public void suorita() {
        edellinenArvo = sovellus.tulos();
        sovellus.plus(haeSyote());
        asetaTulos(sovellus.tulos());
    }
}
