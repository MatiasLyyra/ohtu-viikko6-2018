package laskin.komennot;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

abstract class LaskinKomento implements Komento {
    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    int edellinenArvo;

    LaskinKomento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
    }

    void asetaTulos(int tulos) {
        syotekentta.setText("");
        tuloskentta.setText("" + tulos);

        if (tulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }

    int haeSyote() {
        int arvo = 0;

        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        return arvo;
    }

    @Override
    public void peru() {
        asetaTulos(edellinenArvo);
    }

}
