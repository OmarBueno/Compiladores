package fes.aragon;
import static fes.aragon.tokens.Tokens.*;
import fes.aragon.tokens.Tokens;
%%
%class Analizador
%type Tokens
L = [a-zA-z_]
D =[0,9]
WHITE = [\t\r\n]
%{
    public String lexema;
%}
%%
{WHITE}         {/*NO HACER NADA */}
"="             {return ASSIGN;}
.               {return ERROR;}