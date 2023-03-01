package fes.aragon;
import static fes.aragon.Tokens.*;
%%
%class Lexico
%type Tokens
L=[a-zA-Z]
D=[0-9]
WHITE=[\t\r\n]
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace = {LineTerminator} | [ \t\f]
/* comments */
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}
TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
// Comment can be the last line of the file, without line terminator.
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent = ( [^*] | \*+ [^/*] )*
Identifier = [:jletter:] [:jletterdigit:]*
DecIntegerLiteral = 0 | [1-9][0-9]*
ENTRADA = (011)*
%state STRING
%{
	public String lexema;
%}
%%
/* keywords */
<YYINITIAL> "abstract" { return ABSTRACT; }
<YYINITIAL> "boolean" { return BOOLEAN; }
<YYINITIAL> "break" { return BREAK; }

<YYINITIAL> {
/* identifiers */
{Identifier} { return IDENTIFICADOR; }
/* literals */
{DecIntegerLiteral} { return IDENTIFICADORI; }
{ENTRADA}* {System.out.println("Correcto Salto"); yybegin(STRING);}
}
<STRING> {
(0)* {System.out.println("Correcto");}
	
}

[^] {System.out.println("palabra no encontrada");}
