package aa;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class CreateExcel {

	public static void main(String[] args) throws IOException, RowsExceededException, WriteException {
		// 创建excel文件
		File file = new File("C:\\Users/ASUS/Desktop/bb.xls");
		//file.createNewFile();
		// 创建工作簿
		WritableWorkbook workbook = Workbook.createWorkbook(file);
		// 创建sheet,设置第二三四..个sheet，依次类推即可
		WritableSheet sheet = workbook.createSheet("bb", 0);
		// 设置titles
		String[] titles = { "编号", "账号", "密码" };
		// 单元格
		Label label = null;
		// 给第一行设置列名
		for (int i = 0; i < titles.length; i++) {
			// x,y,第一行的列名
			label = new Label(i, 0, titles[i]);
			// 7：添加单元格
			sheet.addCell(label);
		}
		// 模拟数据库导入数据
		for (int i = 1; i < 10; i++) {
			// 添加编号，第二行第一列
			label = new Label(0, i, i + "");
			sheet.addCell(label);

			// 添加账号
			label = new Label(1, i, "10010" + i);
			sheet.addCell(label);

			// 添加密码
			label = new Label(2, i, "123456");
			sheet.addCell(label);
		}

		// 写入数据
		workbook.write();
		// 最后一步,关闭工作簿
		workbook.close();
	}

}
