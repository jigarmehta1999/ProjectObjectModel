package com.assure.qa.util;


import java.util.Hashtable;



public class dataProvider {
	
	public static Object[][] getData(XLS_POI testExcelSheet, String testCaseName, String testDataTab) {
		
		Object[][] data = null;
		
		// 1st Step - Find the total of rows in the sheet
		int maxRows = testExcelSheet.getRowCount(testDataTab);
		System.out.println("maxRows = " + maxRows);
		System.out.println("testDataTab = " + testDataTab);
		System.out.println("testCaseName = " + testCaseName);
		System.out.println();
		int datatable_header_row_number = 0;
		int datatable_data_row_number = 0;
		int datatable_col_count = 0;
		// testStepCount is variable to find number of rows for a given test case i.e. testCaseName
		int testStepCount = 0;

		
		// Run the for loop till max number of rows
		for (int i = 1; i <= maxRows; i++) {

			// Verify if the cell in Col A matches the testCaseName
			if (testExcelSheet.getCellData(testDataTab, i, 1).equalsIgnoreCase(testCaseName)) {
				// If testcase name matches then start counting the teststep count from next row
				// hence j = i+1 till maxRows
				datatable_header_row_number = i + 1;
				datatable_data_row_number = i + 2;
				datatable_col_count = testExcelSheet.getColumnCount(testDataTab, datatable_header_row_number);
				
				for (int j = i + 1; j <= maxRows; j++) {
					// System.out.println("datatable.getCellData(sheetName," + j + " ,1) = "
					// + datatable.getCellData(sheetName, j, 1));

					// getCellData method in XLS_POI class returns the celldata in a sheet for a
					// particular row and column number
					// Name of the sheet, row number and column number are passed as arguments
					// returns -1 if sheet not present
					// returns -2 if the row number does not exist
					// returns -3 if column number does not exist
					// returns -4 if cell value is blank
					// returns -5 if cell is not boolean, String, Numeric, formula or blank

					// verify cell data is not blank then increment the testStepCount i.e. Number of
					// data row count for the test case by 1
					// else break the for loop that means the total number of data rows is now
					// counted
					if (!(testExcelSheet.getCellData(testDataTab, j, 1).equals("-2"))
							&& !(testExcelSheet.getCellData(testDataTab, j, 1).equals("-4"))) {
						testStepCount++;
					} else {
						break;
					}
				}
			}
		}
		System.out.println("testDataTab = " + testDataTab);
		System.out.println("testCaseName = " + testCaseName);
		System.out.println("testStepCount = " + testStepCount);
		System.out.println("datatable_header_row_number " + datatable_header_row_number);
		System.out.println("datatable_data_row_number = " + datatable_data_row_number);
		System.out.println("datatable_col_count " + datatable_col_count);

		data = new Object[testStepCount-1][1];
		int dataRow = 0;
		
		
		System.out.println("*************");
		System.out.println();
		Hashtable<String, String> hash_datatable = null;
		
		for (int i = 0; i < testStepCount-1; i++) {
			hash_datatable = new Hashtable<String, String>();
			System.out.println("datatable_data_row_number = " + datatable_data_row_number);
			System.out.println("i = " + i);
			System.out.println("testStepCount = " + testStepCount);
			System.out.println();
			for (int j = 1; j <= datatable_col_count; j++) {

//				System.out.println("Key = " + key);
//				System.out.print(" ");
//				System.out.print("Value = " + value);
///				System.out.println();
				String key = testExcelSheet.getCellData(testDataTab, datatable_header_row_number, j);
				String value = testExcelSheet.getCellData(testDataTab, datatable_data_row_number, j);

					hash_datatable.put(key, value);

				
			}
			data[dataRow][0] = hash_datatable;
			dataRow++;
			System.out.println();
			datatable_data_row_number++;
		} 

		return data;
		
	}

	
}
