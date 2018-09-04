package scripts;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import genericMethods.Configuration;
import genericMethods.Data;
import genericMethods.EventMethods;



public class GetExcelObjectsIntoHashMap extends Configuration {
	
	//Create thread safe instance of class
    private static ThreadLocal<GetExcelObjectsIntoHashMap> GetExcelData = new ThreadLocal<GetExcelObjectsIntoHashMap>();

    //Set and Get methods for thread safe instance
    public static void set(GetExcelObjectsIntoHashMap objectNames)
    {
    	GetExcelData.set(objectNames);
    }    
    
    public static GetExcelObjectsIntoHashMap get()
    {
    	return GetExcelData.get(); 
    } 
	
	public GetExcelObjectsIntoHashMap(){
		EventMethods.set(new EventMethods());
	}
	
	public HashMap<String, String> getDataIntoHashMap(){
		Data.Common.objectDataInformation= new HashMap<>();
		XSSFWorkbook work;
		try {
			work = new XSSFWorkbook(Data.Common.repositoryFilePath);
			XSSFSheet oSheet=getSheet(work, Data.Common.repositorySheetName );
			int TotalRows = oSheet.getLastRowNum();
			
			for (int RowNum = 1; RowNum<= TotalRows; RowNum++) {		
		
					XSSFRow row = oSheet.getRow(RowNum);
					
					if (row != null) {
						String objectName = row.getCell(getColumnNumberbyHeader(oSheet,"Object Name")).getStringCellValue();
						//System.out.println(objectName.length());
						String propName = row.getCell(getColumnNumberbyHeader(oSheet, "Locator Name")).getStringCellValue();
						String propVal = row.getCell(getColumnNumberbyHeader(oSheet, "Value")).getStringCellValue();						
						Data.Common.objectDataInformation.put(objectName, propName + ":="+propVal);			
						//System.out.println(propVal+"\n"+propName);
					}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Data.Common.objectDataInformation;
	}

	
	public By getBy(String objectName) {
		By by = null; 
		Data.Common.objectDataInformation= GetExcelObjectsIntoHashMap.get().getDataIntoHashMap();
		if (Data.Common.objectDataInformation.containsKey(objectName)) {
			String keyValue = Data.Common.objectDataInformation.get(objectName);
			String[] propNameandValue = keyValue.split(":=");


			switch (propNameandValue[0].toLowerCase()) {
			case "name":
				by = By.name(propNameandValue[1]);
				break;
			case "id":
				by = By.id(propNameandValue[1]);
				break;
			case "xpath":
				by = By.xpath(propNameandValue[1]);
				break;
			case "linkText":
				by = By.linkText(propNameandValue[1]);
				break;
			case "classname":
				by = By.className(propNameandValue[1]);
				break;
			
			case "partiallinktext":
				by = By.partialLinkText(propNameandValue[1]);
				break;
			case "cssselector":
				by = By.cssSelector(propNameandValue[1]);
				break;
			case "tagname":
				by = By.tagName(propNameandValue[1]);
				break;
			default:
				System.out.println("Please provide Possible locator Name. Please check given locator Name"+propNameandValue[0]);
				break;
			}
		}
		return by;	
	}
		
public XSSFSheet getSheet(XSSFWorkbook oWorkBook,String strSheetName) {
		
		int totalSheets = oWorkBook.getNumberOfSheets();
		XSSFSheet oSheet = null;
		boolean sheetFound = false;
			
		for (int index=0;index<totalSheets;index++) {
			 oSheet = oWorkBook.getSheetAt(index);			 
			 String actSheetName = oSheet.getSheetName();			 
			 if (actSheetName.trim().equalsIgnoreCase(strSheetName.trim())) {
				 sheetFound = true;
				 break;				 
			 }			 
		}
		
		if (!sheetFound) {			
			System.out.println("ERROR : the given sheet " + strSheetName + " not found in the given workbook.");
			oSheet = null;
			}
		
		return oSheet;
	
	}
/**
 * @author SMunagala
 * @param sheet
 * @param columnHeader
 * @return columnNumber
 * Return the ColumnHeader Number based on Header Name
 */
public int getColumnNumberbyHeader(XSSFSheet sheet, String columnHeader) {
	int columnNumber = -1;
	
	if (!columnHeader.isEmpty()) {
		
		
		XSSFRow row = sheet.getRow(0);
		int totalColumns = row.getPhysicalNumberOfCells();
		for (int icolNum=0 ; icolNum < totalColumns;icolNum++) {				
			String actColHeader = row.getCell(icolNum).getStringCellValue();
			if (actColHeader != null) {
				if (actColHeader.trim().equalsIgnoreCase(columnHeader.trim())) {
					columnNumber = icolNum;
					break;					
				}
			}
		}
		
		if (columnNumber == -1) {
			System.out.println("ERROR : the column : " + columnHeader + " is not found in the sheet "+ sheet.getSheetName());
		}
		
	} else {
		System.out.println(" ERROR : Unable to get the column number from sheet as empty column header is provided.");
	}
	return columnNumber;
	
}

}
