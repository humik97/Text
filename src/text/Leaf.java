package text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by java on 5/25/2017.
 */
public class Leaf implements Text {
    String str;
    private List<Text> components = new ArrayList<>() ;

    public Leaf(String str) {
        this.str = str;
    }

    @Override
    public void Parse() {
    }
    @Override
    public void addComponent(Text component){
        components.add(component);
    }

    @Override
    public void removeComponent(Text component){
        components.remove(component);
    }



    @Override
    public Text getComponent() {
        return null;
    }
}

