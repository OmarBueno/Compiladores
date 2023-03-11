package fes.aragon.codigo;
%%
%public
%class Lexico
%line
%char
%column
%full
%type Tokens
%{
private boolean hayToken=false;
public boolean getHayToken(){
	return this.hayToken;
}
%}
%type Tokens
%init{
	/*Codigo que se ejecuta en el constructor de la clase*/
%init}
%eof{
	/*Codigo que se ejecuta al terminar el analisis*/
	this.hayToken=false;
%eof}
saltoLinea= \n|\r\n
retorno = \r
Espacio= " "
PuntoComa=";"
IGUAL= "="
MAS= "+"
MENOS= "-"
//expresiones
ENTERO	= [0-9]+
ID      = [A-Za-z][_0-9A-Za-z]*

%%
{IGUAL} {
	Tokens tok=new Tokens(yytext(),Sym.IGUAL,yyline,yycolumn);
	this.hayToken=true;
	return tok;
}
{MAS} {
	Tokens tok=new Tokens(yytext(),Sym.MAS,yyline,yycolumn);
	this.hayToken=true;
	return tok;
}
{MENOS} {
	Tokens tok=new Tokens(yytext(),Sym.MENOS,yyline,yycolumn);
	this.hayToken=true;
	return tok;
}

{ENTERO} {
	Tokens tok=new Tokens(yytext(),Sym.ENTERO,yyline,yycolumn);
	this.hayToken=true;
	return tok;
}
{ID} {
	Tokens tok=new Tokens(yytext(),Sym.ID,yyline,yycolumn);
	this.hayToken=true;
	return tok;
}

{PuntoComa} {
	Tokens tok=new Tokens(yytext(),Sym.PUNTOCOMA,yyline,yycolumn);
	this.hayToken=true;
	return tok;
}
{saltoLinea} {
	Tokens tok=new Tokens(yytext(),Sym.SALTOLINEA,yyline,yycolumn);
	this.hayToken=true;
	return tok;
}
{retorno} {

}
{Espacio} {
	
}

. {
        String errLex = "Error lexico : '"+yytext()+"' en la linea: "
		+(yyline+1)+" y columna: "+(yycolumn+1);
        System.out.println(errLex);
	this.hayToken=false;
}
