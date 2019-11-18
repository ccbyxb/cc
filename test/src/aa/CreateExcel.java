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
		// ����excel�ļ�
		File file = new File("C:\\Users/ASUS/Desktop/bb.xls");
		//file.createNewFile();
		// ����������
		WritableWorkbook workbook = Workbook.createWorkbook(file);
		// ����sheet,���õڶ�����..��sheet���������Ƽ���
		WritableSheet sheet = workbook.createSheet("bb", 0);
		// ����titles
		String[] titles = { "���", "�˺�", "����" };
		// ��Ԫ��
		Label label = null;
		// ����һ����������
		for (int i = 0; i < titles.length; i++) {
			// x,y,��һ�е�����
			label = new Label(i, 0, titles[i]);
			// 7����ӵ�Ԫ��
			sheet.addCell(label);
		}
		// ģ�����ݿ⵼������
		for (int i = 1; i < 10; i++) {
			// ��ӱ�ţ��ڶ��е�һ��
			label = new Label(0, i, i + "");
			sheet.addCell(label);

			// ����˺�
			label = new Label(1, i, "10010" + i);
			sheet.addCell(label);

			// �������
			label = new Label(2, i, "123456");
			sheet.addCell(label);
		}

		// д������
		workbook.write();
		// ���һ��,�رչ�����
		workbook.close();
	}

}
