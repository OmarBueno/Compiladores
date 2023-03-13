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
saltoLinea= \n
retorno = \r
Espacio= " "
PuntoComa=";"
OR= "or"
AND= "and"
NOT= "not"
TRUE = "true"
FALSE = "false"
PIZ = "("
PDE = ")"
//expresiones
//ENTERO	= [0-9]+
//ID      = [A-Za-z][_0-9A-Za-z]*

%%
{OR} {
	Tokens tok=new Tokens(yytext(),Sym.OR,yyline,yycolumn);
	this.hayToken=true;
	return tok;
}
{AND} {
	Tokens tok=new Tokens(yytext(),Sym.AND,yyline,yycolumn);
	this.hayToken=true;
	return tok;
}
{NOT} {
	Tokens tok=new Tokens(yytext(),Sym.NOT,yyline,yycolumn);
	this.hayToken=true;
	return tok;
}

{TRUE} {
	Tokens tok=new Tokens(yytext(),Sym.TRUE,yyline,yycolumn);
	this.hayToken=true;
	return tok;
}
{FALSE} {
	Tokens tok=new Tokens(yytext(),Sym.FALSE,yyline,yycolumn);
	this.hayToken=true;
	return tok;
}
{PIZ} {
	Tokens tok=new Tokens(yytext(),Sym.PIZ,yyline,yycolumn);
	this.hayToken=true;
	return tok;
}
{PDE} {
	Tokens tok=new Tokens(yytext(),Sym.PDE,yyline,yycolumn);
	this.hayToken=true;
	return tok;
}
{PuntoComa} {
	Tokens tok=new Tokens(yytext(),Sym.PUNTOCOMA,yyline,yycolumn);
	this.hayToken=true;
	return tok;
}
{saltoLinea} {
	//Tokens tok=new Tokens(yytext(),Sym.SALTOLINEA,yyline,yycolumn);
	//this.hayToken=true;
	//return tok;
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
