import parser.TextParser;
import text.CompositeText;

import java.io.IOException;


/**
 * Created by java on 5/2/2017.
 */
public class Run {
    public static void main(String[] args) throws IOException {
        String path = "text.txt";
        TextParser textParser = new parser.TextParser();
        CompositeText wholetext =textParser.parse(path);

                }
    }

