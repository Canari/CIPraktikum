grammar symbolraetselV3;
	
options {
    output=AST;
    ASTLabelType=CommonTree;
    TokenLabelType=CommonToken;
}

prog
scope { List<Token> symbols;
	List<Token> opsRow;
	List<Token> ops; }
@init { $prog::symbols = new ArrayList<Token>(); 
	$prog::opsRow = new ArrayList<Token>();
	$prog::ops = new ArrayList<Token>(); } 
	: init
	{
    	    // Bsp: A - B = C
	    //      -   +   +
	    //      D + E = F
	    //      =   =   =
	    //      G + H = I
	    
	    int size = 3;
	    
	    for(int i = 0; i < $prog::symbols.size(); i += size) {
		Tree equals = new CommonTree(new CommonToken(6, "=")); // =
		Tree plus = new CommonTree(new CommonToken(6, "+")); // +
		
		String operator = $prog::ops.get(i / size).getText();
		
		if (operator.equals("+")) {
		    plus.addChild(new CommonTree($prog::symbols.get(i))); // A
		    plus.addChild(new CommonTree($prog::symbols.get(i + 1))); // B
			
		    equals.addChild(plus);
	    	    equals.addChild(new CommonTree($prog::symbols.get(i + 2))); // C
		}
		else {
		    plus.addChild(new CommonTree($prog::symbols.get(i + 1))); // B
		    plus.addChild(new CommonTree($prog::symbols.get(i + 2))); // C
		
		    equals.addChild(plus);
	    	    equals.addChild(new CommonTree($prog::symbols.get(i))); // A
		}
		
		CommonTreeAdaptor adaptor = new CommonTreeAdaptor();
		adaptor.addChild($init.tree, equals);
	    }
	    
	    for(int i = 0; i < size; i++) {		
		Tree equals = new CommonTree(new CommonToken(6, "=")); // =
		Tree plus = new CommonTree(new CommonToken(6, "+")); // +
		
		String operator = $prog::opsRow.get(i).getText();
		
		if (operator.equals("+")) {
		    plus.addChild(new CommonTree($prog::symbols.get(i))); // A
		    plus.addChild(new CommonTree($prog::symbols.get(i + size * 1))); // D
			
		    equals.addChild(plus);
	    	    equals.addChild(new CommonTree($prog::symbols.get(i + size * 2))); // G
		}
		else {
		    plus.addChild(new CommonTree($prog::symbols.get(i + size * 1))); // D
		    plus.addChild(new CommonTree($prog::symbols.get(i + size * 2))); // G
		
		    equals.addChild(plus);
	    	    equals.addChild(new CommonTree($prog::symbols.get(i))); // A
		}
		
		CommonTreeAdaptor adaptor = new CommonTreeAdaptor();
		adaptor.addChild($init.tree, equals);
	    }

	    for (int i = 0; i < size; i++) {
	       $init.tree.deleteChild(i);
	    }

	    System.out.println($init.tree.toStringTree());
	}
	;
init
	: expr operators expr equals expr
	;
expr	
	: letterA=LETTER signA=SIGN^ letterB=LETTER EQUAL^ letterC=LETTER NEWLINE!
	{
	    $prog::symbols.add($letterA);
	    $prog::symbols.add($letterB);
	    $prog::symbols.add($letterC);
	    $prog::ops.add($signA);
	}
	;
operators
	: signA=SIGN! signB=SIGN! signC=SIGN! NEWLINE!
	{ 
	    $prog::opsRow.add($signA);
	    $prog::opsRow.add($signB);
	    $prog::opsRow.add($signC); 
	}
	;
equals	
	: EQUAL! EQUAL! EQUAL! NEWLINE!
	;
	
LETTER  : ('A'..'Z')+;
SIGN 	: ('+'|'-');
NEWLINE : ('\r'? '\n');
EQUAL  	: '=';
WS  	: (' '|'\t'|NEWLINE)+ {skip();};