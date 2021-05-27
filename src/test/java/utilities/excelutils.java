package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelutils {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream file=new FileInputStream("./src/test/java/testdata/sprintuser.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");  //proving sheet name
		//XSSFSheet sheet=workbook.getSheetAt(index)(0);  //proving sheet index
		
		//this code is to read and show data in console
		int rowcount=sheet.getLastRowNum();  //return the row count
		int columncount=sheet.getRow(0).getLastCellNum();
		for(int i=0;i<rowcount;i++)
		{
			XSSFRow crntrow=sheet.getRow(i);   //focus on current row
			for(int j=0;j<columncount;j++)
			{
				String value=crntrow.getCell(j).toString();//read the value from cell
				System.out.print("  " +value);
			}
			System.out.println(" ");
		}
		
		
		//this is to work on data from paticular row
		
		int rowcnt=sheet.getLastRowNum();
		for(int i=1;i<=rowcnt;i++)
		{
			XSSFRow currentrow=sheet.getRow(i);
			
			String firstname=currentrow.getCell(0).getStringCellValue();
			String Lastname=currentrow.getCell(1).getStringCellValue();
			String Country=currentrow.getCell(2).getStringCellValue();
			String State=currentrow.getCell(3).getStringCellValue();
			String city=currentrow.getCell(4).getStringCellValue();
			String mobiletype=currentrow.getCell(5).getStringCellValue();
			String skypeid=currentrow.getCell(6).getStringCellValue();
			String mobile=currentrow.getCell(7).getStringCellValue();
			String landline=currentrow.getCell(8).getStringCellValue();
		}
		

}
}