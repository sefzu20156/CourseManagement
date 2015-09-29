package com.excelcl;

import java.io.File;
import jxl.Workbook;

public class ExcelImport {

	public ExcelImport() throws Exception{
		
	}
	
	Workbook workbook=Workbook.getWorkbook(new File("d:/courses.xls"));
	
}
