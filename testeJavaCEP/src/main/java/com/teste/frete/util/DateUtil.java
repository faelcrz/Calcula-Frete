package com.teste.frete.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public Date getDataConsulta() {
		Calendar calendar = Calendar.getInstance();
		
		return calendar.getTime();
	}

	public Date getDataPrevistaEntrega(Date data, int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, dias);

		return calendar.getTime();
	}

}
