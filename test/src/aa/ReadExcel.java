package aa;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {
	
	public static void main(String[] args) {
		try {
			Workbook workbook = Workbook.getWorkbook(new File("C:\\Users\\ASUS\\Desktop/test.xls"));
			System.out.println("-----------------");
			Sheet sheet = workbook.getSheet(0);
			int rows = sheet.getRows();
			Cell[] cells = null;
			for (int i = 0; i < rows; i++) {
				cells = sheet.getRow(i);
				System.out.println(cells[0].getContents() + "\t" +cells[1].getContents() + "\t" + cells[2].getContents());
			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
