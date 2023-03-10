package fes.aragon;
import static fes.aragon.Tokens.*;
%%
%class Lexico
%type Tokens
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace = {LineTerminator} | [ \t\f]
/* comments */
Comment = {TraditionalComment} | {EndOfLineComment}
TraditionalComment = "(*" [^*] ~"*)" | "(*" "*"+ ")" | "{"{LineTerminator}* {InputCharacter}* {LineTerminator}*"}"
// Comment can be the last line of the file, without line terminator.
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?
Identifier = [:jletter:] [:jletterdigit:]*
DecIntegerLiteral = 0 | [1-9][0-9]*
%%
/* keywords */
<YYINITIAL> "ABSOLUTE" 		{ return ABSOLUTE; }
<YYINITIAL> "ARRAY" 		{ return ARRAY; }
<YYINITIAL> "BEGIN" 		{ return BEGIN; }
<YYINITIAL> "CONST" 		{ return CONST; }
<YYINITIAL> "DESTRUCTOR"	{ return DESTRUCTOR; }
<YYINITIAL> "DIV" 			{ return DIV; }
<YYINITIAL> "DOWNTO" 		{ return DOWNTO; }
<YYINITIAL> "END" 			{ return END; }
<YYINITIAL> "FOR" 			{ return FOR; }
<YYINITIAL> "FUNCTION" 		{ return FUNCTION; }
<YYINITIAL> "IF" 			{ return IF; }
<YYINITIAL> "IN" 			{ return IN; }
<YYINITIAL> "LABEL" 		{ return LABEL; }
<YYINITIAL> "NIL" 			{ return NIL; }
<YYINITIAL> "OBJECT" 		{ return OBJECT; }
<YYINITIAL> "OR" 			{ return OR; }
<YYINITIAL> "PRIVATE" 		{ return PRIVATE; }
<YYINITIAL> "PROGRAM" 		{ return PROGRAM; }
<YYINITIAL> "REPEAT" 		{ return REPEAT; }
<YYINITIAL> "SHL" 			{ return SHL; }
<YYINITIAL> "STRING" 		{ return STRING; }
<YYINITIAL> "TO" 			{ return TO; }
<YYINITIAL> "UNIT" 			{ return UNIT; }
<YYINITIAL> "USES" 			{ return USES; }
<YYINITIAL> "VIRTUAL" 		{ return VIRTUAL; }
<YYINITIAL> "WITH" 			{ return WITH; }
<YYINITIAL> "AND" 			{ return AND; }
<YYINITIAL> "ASM"           { return ASM;}
<YYINITIAL> "CASE"          { return CASE;}
<YYINITIAL> "CONSTRUCTOR"   { return CONSTRUCTOR;}
<YYINITIAL> "EXTERNAL"      { return EXTERNAL;}
<YYINITIAL> "DO"            { return DO;}
<YYINITIAL> "ELSE"          { return ELSE;}
<YYINITIAL> "FILE"          { return FILE;}
<YYINITIAL> "FORWARD"       { return FORWARD;}
<YYINITIAL> "GOTO"          { return GOTO;}
<YYINITIAL> "IMPLEMENTATION"{ return IMPLEMENTATION;}
<YYINITIAL> "INLINE"        { return INLINE;}
<YYINITIAL> "INTERRUPT"     { return INTERRUPT;}
<YYINITIAL> "MOD"           { return MOD;}
<YYINITIAL> "NOT"           { return NOT;}
<YYINITIAL> "OF"            { return OF;}
<YYINITIAL> "PACKED"        { return PACKED;}
<YYINITIAL> "PROCEDURE"     { return PROCEDURE;}
<YYINITIAL> "RECORD"        { return RECORD;}
<YYINITIAL> "SET"           { return SET;}
<YYINITIAL> "SHR"           { return SHR;}
<YYINITIAL> "THEN"          { return THEN;}
<YYINITIAL> "TYPE"          { return TYPE;}
<YYINITIAL> "UNTIL"         { return UNTIL;}
<YYINITIAL> "VAR"           { return VAR;}
<YYINITIAL> "WHILE"         { return WHILE;}
<YYINITIAL> "XOR"           { return XOR;}


<YYINITIAL> {
/* identifiers */
{Identifier} { return IDENTIFIER; }
/* literals */
{DecIntegerLiteral} { return INTEGER_LITERAL; }
/* operators */
"=" { return EQ; }
"==" { return EQEQ; }
"+" { return PLUS; }
/* comments */
{Comment} { System.out.println("Comentario"); }
/* whitespace */
{WhiteSpace} { /* ignore */ }
}
[^] {return ERROR; }