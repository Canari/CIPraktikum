// $ANTLR 3.3 Nov 30, 2010 12:45:30 E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g 2011-05-18 16:26:45

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class symbolraetselV3Lexer extends Lexer {
    public static final int EOF=-1;
    public static final int LETTER=4;
    public static final int SIGN=5;
    public static final int EQUAL=6;
    public static final int NEWLINE=7;
    public static final int WS=8;

    // delegates
    // delegators

    public symbolraetselV3Lexer() {;} 
    public symbolraetselV3Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public symbolraetselV3Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g"; }

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            int _type = LETTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:107:9: ( ( 'A' .. 'Z' )+ )
            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:107:11: ( 'A' .. 'Z' )+
            {
            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:107:11: ( 'A' .. 'Z' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='A' && LA1_0<='Z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:107:12: 'A' .. 'Z'
            	    {
            	    matchRange('A','Z'); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "SIGN"
    public final void mSIGN() throws RecognitionException {
        try {
            int _type = SIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:108:7: ( ( '+' | '-' ) )
            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:108:9: ( '+' | '-' )
            {
            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SIGN"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:109:9: ( ( ( '\\r' )? '\\n' ) )
            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:109:11: ( ( '\\r' )? '\\n' )
            {
            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:109:11: ( ( '\\r' )? '\\n' )
            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:109:12: ( '\\r' )? '\\n'
            {
            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:109:12: ( '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:109:12: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:110:9: ( '=' )
            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:110:11: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:111:6: ( ( ' ' | '\\t' | NEWLINE )+ )
            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:111:8: ( ' ' | '\\t' | NEWLINE )+
            {
            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:111:8: ( ' ' | '\\t' | NEWLINE )+
            int cnt3=0;
            loop3:
            do {
                int alt3=4;
                switch ( input.LA(1) ) {
                case ' ':
                    {
                    alt3=1;
                    }
                    break;
                case '\t':
                    {
                    alt3=2;
                    }
                    break;
                case '\n':
                case '\r':
                    {
                    alt3=3;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:111:9: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;
            	case 2 :
            	    // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:111:13: '\\t'
            	    {
            	    match('\t'); 

            	    }
            	    break;
            	case 3 :
            	    // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:111:18: NEWLINE
            	    {
            	    mNEWLINE(); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:1:8: ( LETTER | SIGN | NEWLINE | EQUAL | WS )
        int alt4=5;
        switch ( input.LA(1) ) {
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
            {
            alt4=1;
            }
            break;
        case '+':
        case '-':
            {
            alt4=2;
            }
            break;
        case '\r':
            {
            int LA4_3 = input.LA(2);

            if ( (LA4_3=='\n') ) {
                int LA4_4 = input.LA(3);

                if ( ((LA4_4>='\t' && LA4_4<='\n')||LA4_4=='\r'||LA4_4==' ') ) {
                    alt4=5;
                }
                else {
                    alt4=3;}
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 3, input);

                throw nvae;
            }
            }
            break;
        case '\n':
            {
            int LA4_4 = input.LA(2);

            if ( ((LA4_4>='\t' && LA4_4<='\n')||LA4_4=='\r'||LA4_4==' ') ) {
                alt4=5;
            }
            else {
                alt4=3;}
            }
            break;
        case '=':
            {
            alt4=4;
            }
            break;
        case '\t':
        case ' ':
            {
            alt4=5;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 4, 0, input);

            throw nvae;
        }

        switch (alt4) {
            case 1 :
                // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:1:10: LETTER
                {
                mLETTER(); 

                }
                break;
            case 2 :
                // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:1:17: SIGN
                {
                mSIGN(); 

                }
                break;
            case 3 :
                // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:1:22: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 4 :
                // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:1:30: EQUAL
                {
                mEQUAL(); 

                }
                break;
            case 5 :
                // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:1:36: WS
                {
                mWS(); 

                }
                break;

        }

    }


 

}