import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        symbolraetselV3Lexer lex = new symbolraetselV3Lexer(new ANTLRFileStream("E:\\Semester 4\\CI\\Praktikum\\output\\__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        symbolraetselV3Parser g = new symbolraetselV3Parser(tokens, 49100, null);
        try {
            g.prog();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}