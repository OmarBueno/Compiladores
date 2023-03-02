package fes.aragon;
import static fes.aragon.Tokens.*;
%%
%class Lexico
%type Tokens
%{
String string = "";
%}
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
%state STRING
%%
/* keywords */
<YYINITIAL> "abstract" { return ABSTRACT; }
<YYINITIAL> "boolean" { return BOOLEAN; }
<YYINITIAL> "break" { return BREAK; }
<YYINITIAL> {
/* identifiers */
{Identifier} { return IDENTIFIER; }
/* literals */
{DecIntegerLiteral} { return INTEGER_LITERAL; }
\" {yybegin(STRING); }
/* operators */
"=" { return EQ; }
"==" { return EQEQ; }
"+" { return PLUS; }
/* comments */
{Comment} { /* ignore */ }
/* whitespace */
{WhiteSpace} { /* ignore */ }
}
<STRING> {
\" { yybegin(YYINITIAL); return STRING_LITERAL;}
[^\n\r\"\\]+  { string+=yytext(); }
\\t { string+=("\t"); System.out.println("string "+string);}
\\n { string+=("\n"); System.out.println("string "+string););}
\\r { string+=("\r"); System.out.println("string "+string);}
\\ { string+=("\\"); }
}
/* error fallback */
[^] {System.out.println("string "+string); return ERROR; }