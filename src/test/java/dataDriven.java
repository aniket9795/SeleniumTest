import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
	
	public ArrayList<String> getData(String testcaseName) throws IOException{
		
		
		/*	Steps,
			1. Create Object of XSSFWrokBook class 
			2.Get Access of Sheet
			3.Sheet have no of rows so all rows from sheet
			4.Access to specifc rows from rows
			5.Get a access all cells of rows
			6.Access the data from excel to arrays */
			
			ArrayList<String> a=new ArrayList<String>();   //which acceepts only string

		
			FileInputStream fis=new FileInputStream("E://My_data//selenium_setup//mars_workspace//mars_workspace//ExcelDriven//Data1.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(fis);  //Step 1 note : its accepts file input stream arguments so create before this

			int numberofsheet=workbook.getNumberOfSheets();  // Step 2 To get how many sheets present in the excel 
			
			//Here my case is i want find the case which i want using the name so
			
			for(int i=0;i<numberofsheet;i++){       
				
				// Name of the test sheet which am looking for
				if(workbook.getSheetName(i).equalsIgnoreCase("testdata")){
					 				
					XSSFSheet sheet=workbook.getSheetAt(i);
					
					/*Steps,
					 a.To identify your " testcases " column by scanning the entire list of row. note: doing this becoz later this testcase column might be in 3rd or 10th position script will fail.  
					 b.Once column is identified then scan entire testcase column to identify " Purchase " row from testase
					 c.After you grab purchase row pull the data of that row and feed into test. 
					 
					  */
					
					Iterator<Row> rows=sheet.iterator();   //sheet collection of rows Step a
					Row firstrow=rows.next(); 		 //comes to first row if u added next again then shifts to next row note: Row return type u will get it easily while adding .next() 
					
				    Iterator<Cell> cells=firstrow.cellIterator();  		 // rows is collection of cells so need move cell from of frist row 
					int k=0;
					int col = 0;
				    while(cells.hasNext())
				    {
				    	Cell value=cells.next();
				    	if(value.getStringCellValue().equalsIgnoreCase("Testcases")){
				    		
				    		col=k;
				    	}
				    	
				    	k++;   //added becoz it will increment till he did found the text which we given 
				    }
				    
				   // System.out.println(col);
				    
				    //Step b
				    
				   while(rows.hasNext()){
					   
					   Row r=rows.next();
					   if(r.getCell(col).getStringCellValue().equalsIgnoreCase(testcaseName)){
						   
						   // Step c
						   Iterator<Cell> cll=r.cellIterator();
						   
						   while(cll.hasNext()){
							
							   //Here what happening actaully we are taking only string but suppose int or numeric values comes in sheet then script will fail
							  //Need check cell type and add into array
							  
							   Cell c=cll.next();
							   if(c.getCellType()==CellType.STRING){
								   
							     a.add(c.getStringCellValue());       
							   }else{
								   
								   a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								   	//a.add(c.getNumericCellValue());  // failing becoz at top we mentioned araylist accepts only String so numeric to string methid present lets do that
							   }
						   }
						   
					   }
				   }
				   
				}
			}
			
			return a;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
	}
}
