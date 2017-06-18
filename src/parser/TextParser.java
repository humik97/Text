package parser;

import org.apache.log4j.xml.DOMConfigurator;
import text.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by java on 5/25/2017.
 */
public class TextParser {
    static
    {
        new DOMConfigurator().doConfigure("log4j.xml", org.apache.log4j.LogManager.getLoggerRepository());
    }

    static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TextParser.class);
    public static final String SENTENCE = "[\\.\\!\\?]";
    public static final String WORD = "\\s*(\\s|,|!|\\.)\\s*";

    public  String Read(String path) throws IOException {
        FileInputStream inFile = new FileInputStream(path);
        byte[] str = new byte[inFile.available()];
        inFile.read(str);
        String text = new String(str);
        return text;
    }

    public CompositeText parse(String path) throws IOException {
        String text = Read (path);
        CompositeText wholeText = parseToParagraph(text);
        Changewords(text);
        RemoveWord(text);
        return wholeText;}

    public CompositeText parseToParagraph(String text){
        CompositeText paragraphs = new Paragraph();
        Pattern patternparagraph = Pattern.compile("(?m)(?=^\\s{3})");
        logger.info("Start working");
        for(String paragraph:patternparagraph.split(text)){
        Leaf leaf = new Leaf(paragraph);
        logger.info("paragraphs:"+paragraph);
        paragraphs.addComponent(leaf);
        paragraphs=parseToSentence(paragraph);}
        return paragraphs;}


    public CompositeText parseToSentence (String paragraph){
        CompositeText sentences = new Sentence();
        Pattern patternsentence= Pattern.compile(SENTENCE);
        for(String sentence:patternsentence.split(paragraph)){
            Leaf leaf = new Leaf(sentence);
            logger.info("sentences:"+sentence);
            sentences.addComponent(leaf);
            sentences=parseToWord(sentence);}
        return sentences;}

    public CompositeText parseToWord (String sentence) {
        CompositeText words = new Word();
        Pattern patternword = Pattern.compile(WORD);
        for(String word:patternword.split(sentence)){
            Leaf leaf = new Leaf(word);
            logger.info(" word:"+word);
            words.addComponent(leaf);
            words =parseToSymbol(word); }
        return words;}


        public CompositeText parseToSymbol (String word) {
            CompositeText symbols = new Symbol();
            for(char symbol:word.toCharArray ()){
                String ssymbol = String.valueOf(symbol);
                Leaf leaf = new Leaf(ssymbol);
                logger.info(" symbol:"+symbol);
                symbols.addComponent(leaf);}
            return symbols;}

        public void Changewords(String text){
            Pattern pattternsentence = Pattern.compile(SENTENCE);
            String[] sentences =pattternsentence.split(text);
            Collection<String> collection=Arrays.asList(sentences);
            List<String> clt = collection
                    .stream()
                    .map((s)-> s.trim().replaceAll("(?U)^(\\w+)(.*)(\\b\\w+)([.?!]?$)", "$3$2$1$4"))
                    .collect(Collectors.toList());
                    logger.info("replace collection: "+clt);}


    public void RemoveWord(String text){
        Pattern pattternsentence = Pattern.compile(SENTENCE);
        String[] sentences =pattternsentence.split(text);
        List<String> collection=Arrays.asList(sentences);
        collection
                .stream()
                .sorted().collect(Collectors.toList());
                logger.info("sorted sentences: "+collection);}}


















