package text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by java on 4/26/2017.
 */
public class Sentence extends CompositeText {
    List<Word> sentence = new ArrayList<>();

    public Sentence(){

    }

    public List<Word> getSentence() {
        return sentence;
    }

    public void setSentence(List<Word> sentence) {
        this.sentence = sentence;
    }
}
