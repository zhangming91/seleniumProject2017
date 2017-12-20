package Comm;

import java.io.FileInputStream;
import java.text.DecimalFormat; 

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadUserExcel {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static DecimalFormat df = new DecimalFormat("0");  
	
	//获取excel的数据到数组中
	public static Object[][] getDataToArray(String filePath,String sheet){
		String [][] arrayTable = null;
		try {
			FileInputStream ExcelFile = new FileInputStream(filePath);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheet);
			int startRow = 1;
			int startCol = 1;
			int ci=0,cj=0;
			//获取最大行数
			int totalRows = ExcelWSheet.getLastRowNum();
			System.out.println("------最大行数："+totalRows);
			//列数固定：2
			int totalCols = 2;
			arrayTable = new String[totalRows-1][totalCols];
			for (int i=startRow;i<totalRows;i++, ci++) {
				for (int j=startCol;j<=totalCols;j++, cj++) {
					arrayTable[ci][cj] = getCellData(i,j);
				}
				cj = 0;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return arrayTable;
	}
	
	//获取一个单元格的内容
	public static String getCellData(int rowNum, int colNum) {
		System.out.println(rowNum);
		try {
			Cell = ExcelWSheet.getRow(rowNum).getCell(colNum);
			String celldata = null;
			DecimalFormat df = new DecimalFormat("#");
			switch(Cell.getCellType()) {
				case XSSFCell.CELL_TYPE_STRING:
					celldata = Cell.getStringCellValue();
					break;
				case XSSFCell.CELL_TYPE_NUMERIC:
					celldata = "" + df.format(Cell.getNumericCellValue());
					break;
					
				case XSSFCell.CELL_TYPE_BOOLEAN:
					celldata = "" + Cell.getBooleanCellValue();
					break;
	
				case XSSFCell.CELL_TYPE_BLANK:
					celldata = "";
					break;
	
				case XSSFCell.CELL_TYPE_ERROR:
					celldata = "";
					break;
			}
			return celldata;
		}catch(Exception e) {
			System.out.println("单元格里面的值"+e.getMessage());
			throw (e);
		}
	}
	
}

