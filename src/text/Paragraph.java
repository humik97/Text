package text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by java on 4/26/2017.
 */
public class Paragraph extends CompositeText {
    List<Sentence> paragraph = new ArrayList<>();

    public Paragraph() {
    }

    public List<Sentence> getParagraph() {
        return paragraph;
    }

    public void setParagraph(List<Sentence> paragraph) {
        this.paragraph = paragraph;
    }


}
