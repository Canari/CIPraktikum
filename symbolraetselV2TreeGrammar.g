tree grammar symbolraetselV2TreeGrammar;

options {
    tokenVocab=symbolraetselV3; // read token types from Expr.tokens file
    ASTLabelType=CommonTree; // what is Java type of nodes?
}

prog 
	: init
	;
init
	: expr expr expr expr expr expr
	;
expr	
	: ^(EQUAL ^(SIGN LETTER LETTER) LETTER)
	;