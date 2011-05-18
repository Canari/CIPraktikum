// $ANTLR 3.3 Nov 30, 2010 12:45:30 E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g 2011-05-18 16:26:45

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;

import org.antlr.runtime.tree.*;

public class symbolraetselV3Parser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LETTER", "SIGN", "EQUAL", "NEWLINE", "WS"
    };
    public static final int EOF=-1;
    public static final int LETTER=4;
    public static final int SIGN=5;
    public static final int EQUAL=6;
    public static final int NEWLINE=7;
    public static final int WS=8;

    // delegates
    // delegators

    public static final String[] ruleNames = new String[] {
        "invalidRule", "equals", "operators", "expr", "init", "prog"
    };
    public static final boolean[] decisionCanBacktrack = new boolean[] {
        false, // invalid decision
    };

     
        public int ruleLevel = 0;
        public int getRuleLevel() { return ruleLevel; }
        public void incRuleLevel() { ruleLevel++; }
        public void decRuleLevel() { ruleLevel--; }
        public symbolraetselV3Parser(TokenStream input) {
            this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
        }
        public symbolraetselV3Parser(TokenStream input, int port, RecognizerSharedState state) {
            super(input, state);
            DebugEventSocketProxy proxy =
                new DebugEventSocketProxy(this,port,adaptor);
            setDebugListener(proxy);
            setTokenStream(new DebugTokenStream(input,proxy));
            try {
                proxy.handshake();
            }
            catch (IOException ioe) {
                reportError(ioe);
            }
            TreeAdaptor adap = new CommonTreeAdaptor();
            setTreeAdaptor(adap);
            proxy.setTreeAdaptor(adap);
        }
    public symbolraetselV3Parser(TokenStream input, DebugEventListener dbg) {
        super(input, dbg);

         
        TreeAdaptor adap = new CommonTreeAdaptor();
        setTreeAdaptor(adap);

    }
    protected boolean evalPredicate(boolean result, String predicate) {
        dbg.semanticPredicate(result, predicate);
        return result;
    }

    protected DebugTreeAdaptor adaptor;
    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = new DebugTreeAdaptor(dbg,adaptor);

    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }


    public String[] getTokenNames() { return symbolraetselV3Parser.tokenNames; }
    public String getGrammarFileName() { return "E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g"; }


    protected static class prog_scope {
        List<Token> symbols;
        List<Token> opsRow;
        List<Token> ops;
    }
    protected Stack prog_stack = new Stack();

    public static class prog_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "prog"
    // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:9:1: prog : init ;
    public final symbolraetselV3Parser.prog_return prog() throws RecognitionException {
        prog_stack.push(new prog_scope());
        symbolraetselV3Parser.prog_return retval = new symbolraetselV3Parser.prog_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        symbolraetselV3Parser.init_return init1 = null;



         ((prog_scope)prog_stack.peek()).symbols = new ArrayList<Token>(); 
        	((prog_scope)prog_stack.peek()).opsRow = new ArrayList<Token>();
        	((prog_scope)prog_stack.peek()).ops = new ArrayList<Token>(); 
        try { dbg.enterRule(getGrammarFileName(), "prog");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(9, 1);

        try {
            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:16:2: ( init )
            dbg.enterAlt(1);

            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:16:4: init
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(16,4);
            pushFollow(FOLLOW_init_in_prog54);
            init1=init();

            state._fsp--;

            adaptor.addChild(root_0, init1.getTree());
            dbg.location(17,2);

                	    // Bsp: A - B = C
            	    //      -   +   +
            	    //      D + E = F
            	    //      =   =   =
            	    //      G + H = I
            	    
            	    int size = 3;
            	    
            	    for(int i = 0; i < ((prog_scope)prog_stack.peek()).symbols.size(); i += size) {
            		Tree equals = new CommonTree(new CommonToken(6, "=")); // =
            		Tree plus = new CommonTree(new CommonToken(6, "+")); // +
            		
            		String operator = ((prog_scope)prog_stack.peek()).ops.get(i / size).getText();
            		
            		if (operator.equals("+")) {
            		    plus.addChild(new CommonTree(((prog_scope)prog_stack.peek()).symbols.get(i))); // A
            		    plus.addChild(new CommonTree(((prog_scope)prog_stack.peek()).symbols.get(i + 1))); // B
            			
            		    equals.addChild(plus);
            	    	    equals.addChild(new CommonTree(((prog_scope)prog_stack.peek()).symbols.get(i + 2))); // C
            		}
            		else {
            		    plus.addChild(new CommonTree(((prog_scope)prog_stack.peek()).symbols.get(i + 1))); // B
            		    plus.addChild(new CommonTree(((prog_scope)prog_stack.peek()).symbols.get(i + 2))); // C
            		
            		    equals.addChild(plus);
            	    	    equals.addChild(new CommonTree(((prog_scope)prog_stack.peek()).symbols.get(i))); // A
            		}
            		
            		CommonTreeAdaptor adaptor = new CommonTreeAdaptor();
            		adaptor.addChild((init1!=null?((CommonTree)init1.tree):null), equals);
            	    }
            	    
            	    for(int i = 0; i < size; i++) {		
            		Tree equals = new CommonTree(new CommonToken(6, "=")); // =
            		Tree plus = new CommonTree(new CommonToken(6, "+")); // +
            		
            		String operator = ((prog_scope)prog_stack.peek()).opsRow.get(i).getText();
            		
            		if (operator.equals("+")) {
            		    plus.addChild(new CommonTree(((prog_scope)prog_stack.peek()).symbols.get(i))); // A
            		    plus.addChild(new CommonTree(((prog_scope)prog_stack.peek()).symbols.get(i + size * 1))); // D
            			
            		    equals.addChild(plus);
            	    	    equals.addChild(new CommonTree(((prog_scope)prog_stack.peek()).symbols.get(i + size * 2))); // G
            		}
            		else {
            		    plus.addChild(new CommonTree(((prog_scope)prog_stack.peek()).symbols.get(i + size * 1))); // D
            		    plus.addChild(new CommonTree(((prog_scope)prog_stack.peek()).symbols.get(i + size * 2))); // G
            		
            		    equals.addChild(plus);
            	    	    equals.addChild(new CommonTree(((prog_scope)prog_stack.peek()).symbols.get(i))); // A
            		}
            		
            		CommonTreeAdaptor adaptor = new CommonTreeAdaptor();
            		adaptor.addChild((init1!=null?((CommonTree)init1.tree):null), equals);
            	    }

            	    for (int i = 0; i < size; i++) {
            	       (init1!=null?((CommonTree)init1.tree):null).deleteChild(i);
            	    }

            	    System.out.println((init1!=null?((CommonTree)init1.tree):null).toStringTree());
            	

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            prog_stack.pop();
        }
        dbg.location(82, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "prog");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "prog"

    public static class init_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "init"
    // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:83:1: init : expr operators expr equals expr ;
    public final symbolraetselV3Parser.init_return init() throws RecognitionException {
        symbolraetselV3Parser.init_return retval = new symbolraetselV3Parser.init_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        symbolraetselV3Parser.expr_return expr2 = null;

        symbolraetselV3Parser.operators_return operators3 = null;

        symbolraetselV3Parser.expr_return expr4 = null;

        symbolraetselV3Parser.equals_return equals5 = null;

        symbolraetselV3Parser.expr_return expr6 = null;



        try { dbg.enterRule(getGrammarFileName(), "init");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(83, 1);

        try {
            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:84:2: ( expr operators expr equals expr )
            dbg.enterAlt(1);

            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:84:4: expr operators expr equals expr
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(84,4);
            pushFollow(FOLLOW_expr_in_init67);
            expr2=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr2.getTree());
            dbg.location(84,9);
            pushFollow(FOLLOW_operators_in_init69);
            operators3=operators();

            state._fsp--;

            adaptor.addChild(root_0, operators3.getTree());
            dbg.location(84,19);
            pushFollow(FOLLOW_expr_in_init71);
            expr4=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr4.getTree());
            dbg.location(84,24);
            pushFollow(FOLLOW_equals_in_init73);
            equals5=equals();

            state._fsp--;

            adaptor.addChild(root_0, equals5.getTree());
            dbg.location(84,31);
            pushFollow(FOLLOW_expr_in_init75);
            expr6=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr6.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(85, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "init");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "init"

    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:86:1: expr : letterA= LETTER signA= SIGN letterB= LETTER EQUAL letterC= LETTER NEWLINE ;
    public final symbolraetselV3Parser.expr_return expr() throws RecognitionException {
        symbolraetselV3Parser.expr_return retval = new symbolraetselV3Parser.expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken letterA=null;
        CommonToken signA=null;
        CommonToken letterB=null;
        CommonToken letterC=null;
        CommonToken EQUAL7=null;
        CommonToken NEWLINE8=null;

        CommonTree letterA_tree=null;
        CommonTree signA_tree=null;
        CommonTree letterB_tree=null;
        CommonTree letterC_tree=null;
        CommonTree EQUAL7_tree=null;
        CommonTree NEWLINE8_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "expr");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(86, 1);

        try {
            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:87:2: (letterA= LETTER signA= SIGN letterB= LETTER EQUAL letterC= LETTER NEWLINE )
            dbg.enterAlt(1);

            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:87:4: letterA= LETTER signA= SIGN letterB= LETTER EQUAL letterC= LETTER NEWLINE
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(87,11);
            letterA=(CommonToken)match(input,LETTER,FOLLOW_LETTER_in_expr88); 
            letterA_tree = (CommonTree)adaptor.create(letterA);
            adaptor.addChild(root_0, letterA_tree);

            dbg.location(87,24);
            signA=(CommonToken)match(input,SIGN,FOLLOW_SIGN_in_expr92); 
            signA_tree = (CommonTree)adaptor.create(signA);
            root_0 = (CommonTree)adaptor.becomeRoot(signA_tree, root_0);

            dbg.location(87,38);
            letterB=(CommonToken)match(input,LETTER,FOLLOW_LETTER_in_expr97); 
            letterB_tree = (CommonTree)adaptor.create(letterB);
            adaptor.addChild(root_0, letterB_tree);

            dbg.location(87,51);
            EQUAL7=(CommonToken)match(input,EQUAL,FOLLOW_EQUAL_in_expr99); 
            EQUAL7_tree = (CommonTree)adaptor.create(EQUAL7);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUAL7_tree, root_0);

            dbg.location(87,60);
            letterC=(CommonToken)match(input,LETTER,FOLLOW_LETTER_in_expr104); 
            letterC_tree = (CommonTree)adaptor.create(letterC);
            adaptor.addChild(root_0, letterC_tree);

            dbg.location(87,75);
            NEWLINE8=(CommonToken)match(input,NEWLINE,FOLLOW_NEWLINE_in_expr106); 
            dbg.location(88,2);

            	    ((prog_scope)prog_stack.peek()).symbols.add(letterA);
            	    ((prog_scope)prog_stack.peek()).symbols.add(letterB);
            	    ((prog_scope)prog_stack.peek()).symbols.add(letterC);
            	    ((prog_scope)prog_stack.peek()).ops.add(signA);
            	

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(94, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expr");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "expr"

    public static class operators_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "operators"
    // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:95:1: operators : signA= SIGN signB= SIGN signC= SIGN NEWLINE ;
    public final symbolraetselV3Parser.operators_return operators() throws RecognitionException {
        symbolraetselV3Parser.operators_return retval = new symbolraetselV3Parser.operators_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken signA=null;
        CommonToken signB=null;
        CommonToken signC=null;
        CommonToken NEWLINE9=null;

        CommonTree signA_tree=null;
        CommonTree signB_tree=null;
        CommonTree signC_tree=null;
        CommonTree NEWLINE9_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "operators");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(95, 1);

        try {
            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:96:2: (signA= SIGN signB= SIGN signC= SIGN NEWLINE )
            dbg.enterAlt(1);

            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:96:4: signA= SIGN signB= SIGN signC= SIGN NEWLINE
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(96,9);
            signA=(CommonToken)match(input,SIGN,FOLLOW_SIGN_in_operators122); 
            dbg.location(96,21);
            signB=(CommonToken)match(input,SIGN,FOLLOW_SIGN_in_operators127); 
            dbg.location(96,33);
            signC=(CommonToken)match(input,SIGN,FOLLOW_SIGN_in_operators132); 
            dbg.location(96,47);
            NEWLINE9=(CommonToken)match(input,NEWLINE,FOLLOW_NEWLINE_in_operators135); 
            dbg.location(97,2);
             
            	    ((prog_scope)prog_stack.peek()).opsRow.add(signA);
            	    ((prog_scope)prog_stack.peek()).opsRow.add(signB);
            	    ((prog_scope)prog_stack.peek()).opsRow.add(signC); 
            	

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(102, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "operators");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "operators"

    public static class equals_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "equals"
    // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:103:1: equals : EQUAL EQUAL EQUAL NEWLINE ;
    public final symbolraetselV3Parser.equals_return equals() throws RecognitionException {
        symbolraetselV3Parser.equals_return retval = new symbolraetselV3Parser.equals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken EQUAL10=null;
        CommonToken EQUAL11=null;
        CommonToken EQUAL12=null;
        CommonToken NEWLINE13=null;

        CommonTree EQUAL10_tree=null;
        CommonTree EQUAL11_tree=null;
        CommonTree EQUAL12_tree=null;
        CommonTree NEWLINE13_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "equals");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(103, 1);

        try {
            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:104:2: ( EQUAL EQUAL EQUAL NEWLINE )
            dbg.enterAlt(1);

            // E:\\Semester 4\\CI\\Praktikum\\symbolraetselV3.g:104:4: EQUAL EQUAL EQUAL NEWLINE
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(104,9);
            EQUAL10=(CommonToken)match(input,EQUAL,FOLLOW_EQUAL_in_equals150); 
            dbg.location(104,16);
            EQUAL11=(CommonToken)match(input,EQUAL,FOLLOW_EQUAL_in_equals153); 
            dbg.location(104,23);
            EQUAL12=(CommonToken)match(input,EQUAL,FOLLOW_EQUAL_in_equals156); 
            dbg.location(104,32);
            NEWLINE13=(CommonToken)match(input,NEWLINE,FOLLOW_NEWLINE_in_equals159); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(105, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "equals");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "equals"

    // Delegated rules


 

    public static final BitSet FOLLOW_init_in_prog54 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_init67 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_operators_in_init69 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_expr_in_init71 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_equals_in_init73 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_expr_in_init75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LETTER_in_expr88 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SIGN_in_expr92 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LETTER_in_expr97 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUAL_in_expr99 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LETTER_in_expr104 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NEWLINE_in_expr106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SIGN_in_operators122 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SIGN_in_operators127 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SIGN_in_operators132 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NEWLINE_in_operators135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUAL_in_equals150 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUAL_in_equals153 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUAL_in_equals156 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NEWLINE_in_equals159 = new BitSet(new long[]{0x0000000000000002L});

}