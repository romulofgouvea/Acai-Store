package br.com.ufv.projeto_loja.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//http://docs.oracle.com/javase/6/docs/api/java/text/SimpleDateFormat.html
public class meuCalendar {

	static Calendar c = Calendar.getInstance();
	
//	private static Date hora = c.getTime();
	private static long hora = c.get(Calendar.HOUR_OF_DAY);	
	private static long dia = c.get(Calendar.DAY_OF_MONTH);
	private static long mes = c.get(Calendar.MONTH);
	private static long ano = c.get(Calendar.YEAR);
	public String data;
	
	public static String modficaData(int tipo,int dia,int mes,int ano){
		String data = null;
		if(dia != 0 ){//0 a 31
			c.set(Calendar.DAY_OF_MONTH, dia);
		}
		if(mes != 0){//0 a 11
			c.set(Calendar.MONTH, mes);
		}
		if(ano != 0){//0 a 1969
			c.set(Calendar.YEAR, ano);
		}
		
		if(tipo == 0){
			DateFormat f = DateFormat.getDateInstance(DateFormat.FULL);
			data =  f.format(c.getTime());
		}else if(tipo == 1){
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
			data =  f.format(c.getTime());
		}
		
		return data;
	}
	
//	pegar data e usar
//	Long.toHexString(Double.doubleToLongBits(Math.random()))
//	Date data2 = f.parse("12/01/1995");
//	System.out.println(data2);
	
	
	public static long getHora() {
		return hora;
	}
	public static void setHora(long hora) {
		meuCalendar.hora = hora;
	}
	public static long getDia() {
		return dia;
	}
	public static void setDia(long dia) {
		meuCalendar.dia = dia;
	}
	public static long getMes() {
		return mes;
	}
	public static void setMes(long mes) {
		meuCalendar.mes = mes;
	}
	public static long getAno() {
		return ano;
	}
	public static void setAno(long ano) {
		meuCalendar.ano = ano;
	}
	

	
	
}
