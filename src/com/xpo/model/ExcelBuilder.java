package com.xpo.model;

import java.util.List;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFExtendedColor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;
 
/**
 * @author hclakb
 */
public class ExcelBuilder extends AbstractExcelView {
 
    @Override
    protected void buildExcelDocument(Map<String, Object> model,
            HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	List<EmployeeMeritDetails> empMeritDetails1  = (List<EmployeeMeritDetails>) model.get("empMeritDetails1");
         
        HSSFSheet sheet = workbook.createSheet("Exported Data");
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.DARK_GREEN.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);

        HSSFRow rowHeader = sheet.createRow(0);
        int rowHeaderCount = 0;
        rowHeader.createCell(rowHeaderCount).setCellValue("SI.NO");
        rowHeader.getCell(rowHeaderCount).setCellStyle(style);
        rowHeaderCount++;
        rowHeader.createCell(rowHeaderCount).setCellValue("Employee ID");
        rowHeader.getCell(rowHeaderCount).setCellStyle(style);
        rowHeaderCount++; 
        rowHeader.createCell(rowHeaderCount).setCellValue("First Name");
        rowHeader.getCell(rowHeaderCount).setCellStyle(style);
        rowHeaderCount++;
        rowHeader.createCell(rowHeaderCount).setCellValue("Last Name");
        rowHeader.getCell(rowHeaderCount).setCellStyle(style);
        rowHeaderCount++;
        rowHeader.createCell(rowHeaderCount).setCellValue("Direct Manager");
        rowHeader.getCell(rowHeaderCount).setCellStyle(style);
        rowHeaderCount++;
        rowHeader.createCell(rowHeaderCount).setCellValue("1st Level");
        rowHeader.getCell(rowHeaderCount).setCellStyle(style);
        rowHeaderCount++;
        rowHeader.createCell(rowHeaderCount).setCellValue("2nd Level");
        rowHeader.getCell(rowHeaderCount).setCellStyle(style);
        rowHeaderCount++;
        rowHeader.createCell(rowHeaderCount).setCellValue("3rd Level");
        rowHeader.getCell(rowHeaderCount).setCellStyle(style);
        rowHeaderCount++;
        rowHeader.createCell(rowHeaderCount).setCellValue("Job Title");
        rowHeader.getCell(rowHeaderCount).setCellStyle(style);
        rowHeaderCount++;
        rowHeader.createCell(rowHeaderCount).setCellValue("Hire Date");
        rowHeader.getCell(rowHeaderCount).setCellStyle(style);
        rowHeaderCount++;
        rowHeader.createCell(rowHeaderCount).setCellValue("Performance Survey");
        rowHeader.getCell(rowHeaderCount).setCellStyle(style);
        rowHeaderCount++;
        rowHeader.createCell(rowHeaderCount).setCellValue("Current Salary");
        rowHeader.getCell(rowHeaderCount).setCellStyle(style);
        rowHeaderCount++;
        rowHeader.createCell(rowHeaderCount).setCellValue("Target Amount");
        rowHeader.getCell(rowHeaderCount).setCellStyle(style);
        rowHeaderCount++;
        rowHeader.createCell(rowHeaderCount).setCellValue("Target Percentage");
        rowHeader.getCell(rowHeaderCount).setCellStyle(style);
        rowHeaderCount++;
        rowHeader.createCell(rowHeaderCount).setCellValue("Recommended Salary Percentage");
        rowHeader.getCell(rowHeaderCount).setCellStyle(style);
        rowHeaderCount++;
        rowHeader.createCell(rowHeaderCount).setCellValue("Recommended Salary AMT");
        rowHeader.getCell(rowHeaderCount).setCellStyle(style);
        rowHeaderCount++;
        rowHeader.createCell(rowHeaderCount).setCellValue("Salary after merit");
        rowHeader.getCell(rowHeaderCount).setCellStyle(style);
        rowHeaderCount++;
        rowHeader.createCell(rowHeaderCount).setCellValue("Last Salary Hike Date");
        rowHeader.getCell(rowHeaderCount).setCellStyle(style);
        rowHeaderCount++;
        rowHeader.createCell(rowHeaderCount).setCellValue("Merit Cycle");
        rowHeader.getCell(rowHeaderCount).setCellStyle(style);
        rowHeaderCount++;
        rowHeader.createCell(rowHeaderCount).setCellValue("Merit System");
        rowHeader.getCell(rowHeaderCount).setCellStyle(style);
        rowHeaderCount++;
        rowHeader.createCell(rowHeaderCount).setCellValue("Organization");
        rowHeader.getCell(rowHeaderCount).setCellStyle(style);
        
        int rowCount = 1;
        int serialNumber = 0;
        for (EmployeeMeritDetails elist : empMeritDetails1) {
            HSSFRow detailRow = sheet.createRow(rowCount++);
            int detailRowCount = 1;
            detailRow.createCell(0).setCellValue(++serialNumber);
            detailRow.createCell(detailRowCount++).setCellValue(elist.getEmpId());
            detailRow.createCell(detailRowCount++).setCellValue(elist.getFirstName());
            detailRow.createCell(detailRowCount++).setCellValue(elist.getLastName());
            detailRow.createCell(detailRowCount++).setCellValue(elist.getDirectManager());
            detailRow.createCell(detailRowCount++).setCellValue(elist.getL1Manager());
            detailRow.createCell(detailRowCount++).setCellValue(elist.getL2Manager());
            detailRow.createCell(detailRowCount++).setCellValue(elist.getL3Manager());
            detailRow.createCell(detailRowCount++).setCellValue(elist.getJobTitle());
            detailRow.createCell(detailRowCount++).setCellValue(elist.getHireDate());
            detailRow.createCell(detailRowCount++).setCellValue(elist.getPerformanceSurvey());
            detailRow.createCell(detailRowCount++).setCellValue(elist.getCurrentSalary());
            detailRow.createCell(detailRowCount++).setCellValue(elist.getTargetSalary());
            detailRow.createCell(detailRowCount++).setCellValue(elist.getTargetPercentage());
            detailRow.createCell(detailRowCount++).setCellValue(elist.getRecommendedSalPerc());
            detailRow.createCell(detailRowCount++).setCellValue(elist.getRecommendedSalAmt());
            detailRow.createCell(detailRowCount++).setCellValue(elist.getSalAfterMerit());
            detailRow.createCell(detailRowCount++).setCellValue(elist.getLastSalaryHikeDate());
            detailRow.createCell(detailRowCount++).setCellValue(elist.getMeritCycle());
            detailRow.createCell(detailRowCount++).setCellValue(elist.getMeritSystem());
            detailRow.createCell(detailRowCount++).setCellValue(elist.getOrganization());
        }
    }
 
}