package text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by java on 4/26/2017.
 */
public class Word extends CompositeText {
    List<Symbol> word = new ArrayList<>();
    public Word(){
    }

    public List<Symbol> getWord() {
        return word;
    }

    public void setWord(List<Symbol> word) {
        this.word = word;
    }
}
