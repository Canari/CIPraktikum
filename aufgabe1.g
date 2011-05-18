grammar aufgabe1;

options {
    output=AST;
    ASTLabelType=CommonTree;
}

start	
	: expr operators expr equals expr
	;
expr	
	: LETTER SIGN^ LETTER EQUAL^ LETTER NEWLINE!
	;
operators
	: SIGN SIGN SIGN NEWLINE!;		
equals	
	: EQUAL EQUAL EQUAL NEWLINE!;	

LETTER  :   ('A'..'Z')+;
SIGN :   ('+'|'-');
NEWLINE :'\r'? '\n';
EQUAL  :   '=';
WS  :   (' '|'\t'|NEWLINE)+ {skip();} ;