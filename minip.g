grammar minip;

options {
    output=AST;
    ASTLabelType=CommonTree;
}

tokens {VARDEF; BODY; COMPARE; IF; THEN; ELSE; PRINTLN; WHILE; DO; READ;}

prog	
    : 'program' (dec)* 'begin' (expr)+ 'end' -> ^(VARDEF (dec)*) ^(BODY (expr)+)
    ;
dec	
    : TYPES (ID ',')* ID';' -> ^(TYPES (ID)*)
    ;	
expr
    : assignment ';'!
    | arithmeticExpr ';'!
    | compare ';'!
    | ifExpr ';'!
    | whileExpr ';'!
    | printExpr ';'!
    | readExpr ';'!
    ;

assignment
    : ID ':=' arithmeticExpr	-> ^(':=' ID arithmeticExpr)
    | ID ':=' STRING		-> ^(':=' ID STRING)
    | ID ':=' compare 		-> ^(':=' ID compare) 
    ;
    
// Alte Version
assignment2
    : ID ':=' (arithmeticExpr | STRING | compare) 
    ;
    
compare
    : ID COMPOP ID		-> ^(COMPOP ID ID)
    | constant COMPOP constant	-> ^(COMPOP constant constant)
    ;

arithmeticExpr
    : t (LINEOP^ t)* 
    ;
    
t
    : f (POINTOP^ f)*
    ;
    
f
    : (numeric)
    | (ID)
    | '('! arithmeticExpr ')'!
    ;

    
/*arithmeticExpr
    : t arithmeticExpr2
    ;
    
arithmeticExpr2
    : LINEOP t arithmeticExpr2  -> ^(LINEOP t)
    |
    ;
 
t
    : f t2
    ;
    
t2
    : POINTOP f t2 -> ^(POINTOP f t2)
    |
    ;
 
// Alt
f2
    : (numeric | ID) | ('(' arithmeticExpr ')')
    ;
    
f
    : (numeric) 		-> ^(numeric)
    | (ID) 			-> ^(ID)
    | '(' arithmeticExpr ')'
    ;*/
    
ifExpr
    : 'if' compare 'then' expr ('else' expr)? 'fi' -> ^(IF ^(COMPARE compare) ^(THEN expr) ^(ELSE expr)?) 
    ;
    
whileExpr
    : 'while' compare 'do' expr 'od' -> ^(WHILE ^(COMPARE compare) ^(DO expr)) 
    ;
    
readExpr
    : 'read' '(' ID ')' -> ^(READ ID)
    ;
    
printExpr
    : 'println' '(' STRING ')' 	-> ^(PRINTLN STRING)
    | 'println' '(' ID ')' 	-> ^(PRINTLN ID)
    ;

constant
    :   STRING | numeric
    ;

numeric
    :   INT | REAL
    ;	

LINEOP
    :   '+' | '-'
    ;

POINTOP
    :   '*' | '/'
    ;
    
COMPOP
    :   '=' | '<>' | '>' | '<' | '>-' | '<-'
    ;	

TYPES
    :	'integer' | 'real' | 'string' | 'boolean'
    ;

ID  :	('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	'0'..'9'+
    ;

REAL
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   '.' ('0'..'9')+ EXPONENT?
    |   ('0'..'9')+ EXPONENT
    ;

COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

STRING
    :   '\'' ( ESC_SEQ | ~('\\'|'\'') )* '\''
    ;
    
WS  :   ( ' '
    | '\t'
    ) {$channel=HIDDEN;}
;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
