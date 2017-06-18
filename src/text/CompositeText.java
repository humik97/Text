package text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by java on 4/26/2017.
 */
interface Text {
    public  void Parse();
    public  void addComponent(Text component);
    public void removeComponent(Text component);
    public Text getComponent();
}

public class CompositeText implements Text{


        private List<Text> components = new ArrayList<>() ;
    public CompositeText (){
    }

    @Override
        public void Parse() {}

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

