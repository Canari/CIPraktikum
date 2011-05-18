grammar symbolraetselV2;
	
options {
    output=AST;
    ASTLabelType=CommonTree;
    TokenLabelType=CommonToken;
}
		
prog
scope { List<Token> symbols;
	List<Token> ops; }
@init { $prog::symbols = new ArrayList<Token>(); 
	$prog::ops = new ArrayList<Token>(); } 
	: init
	{
	    int size = 3;
	    for(int i = 0; i < size; i++) {
		Tree equals = new CommonTree(new CommonToken(6, "="));
		    
		Tree plus = new CommonTree($prog::ops.get(i + size * 0));
		plus.addChild(new CommonTree($prog::symbols.get(i)));
		plus.addChild(new CommonTree($prog::symbols.get(i + size * 1)));
		    
		equals.addChild(plus);
	    	equals.addChild(new CommonTree($prog::symbols.get(i + size * 2)));
		 
		CommonTreeAdaptor adaptor = new CommonTreeAdaptor();
		adaptor.addChild($init.tree, equals);
	    }
	    
	    System.out.println($init.tree.toStringTree());
	}
	;
init
	: expr operators expr equals expr 
	;
expr	
	: letterA=LETTER SIGN^ letterB=LETTER EQUAL^ letterC=LETTER NEWLINE!
	{
	    $prog::symbols.add($letterA);
	    $prog::symbols.add($letterB);
	    $prog::symbols.add($letterC);
	}
	;
operators
	: signA=SIGN! signB=SIGN! signC=SIGN! NEWLINE!
	{ 
	    $prog::ops.add($signA);
	    $prog::ops.add($signB);
	    $prog::ops.add($signC); 
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