package fes.aragon.inicio;
import static fes.aragon.tokens.Tokens.*;
import fes.aragon.tokens.Tokens;
%%
%class Analizador2
%type Tokens
L = [a-zA-z_]
D =[0,9]
WHITE = [\t\r\n]
TAREA = (011)*0*1*|" "
%{
    public String lexema;
%}
%%
{WHITE}         {/*NO HACER NADA */}
"="             {return ASSIGN;}
.               {return ERROR;}
{TAREA}			{return TAREA;}