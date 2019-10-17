package org.css.in;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Read {
	public static void main(String[] args) {
		List<HashMap<String,String>> mdd=new ArrayList<HashMap<String,String>>();	
		try {	
		File f=new File("D:\\SATHYA ECLIPSE FILES\\MacCosmetics\\files\\Book2.xlsx");
		FileInputStream loc=new FileInputStream(f);
		Workbook  w= new XSSFWorkbook(loc);
			Sheet s = w.getSheet("Sheet1");
			Row fr = s.getRow(0);
			System.out.println(s.getPhysicalNumberOfRows());
			for (int i = 0; i <s.getPhysicalNumberOfRows(); i++) {
				Row cr = s.getRow(i);
				//System.out.println(cr.getPhysicalNumberOfCells());
				HashMap<String,String> md=new HashMap<String,String>();
				for (int j = 0; j <fr.getPhysicalNumberOfCells(); j++) {
					Cell cc = cr.getCell(j);
					switch(cc.getCellType()) {
					case Cell.CELL_TYPE_STRING:
					md.put(fr.getCell(j).getStringCellValue(),cc.getStringCellValue());
					break;
					case Cell.CELL_TYPE_NUMERIC:
						md.put(fr.getCell(j).getStringCellValue(),String.valueOf(cc.getNumericCellValue()));
						break;	
					}	}
					mdd.add(md);
			}}catch(Exception e) {
						e.printStackTrace();		}
		System.out.println(mdd.size());
		for (HashMap<String, String> hashMap : mdd) {
			Set<Entry<String, String>> entrySet = hashMap.entrySet();
			for (Entry<String, String> a: entrySet) {
				System.out.println(a);
			}
			
		}
		}

	

}
