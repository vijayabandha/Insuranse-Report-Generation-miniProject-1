package in.ashokit.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repo.CitizenPlanRepository;

@Component
public class ExcelGenerator {
	
	//private CitizenPlanRepository planRepo;
	
	public void generate(HttpServletResponse response,List<CitizenPlan> records , File file)throws Exception {
		
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("plans-data");
		Row headerRow = sheet.createRow(0);
		
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Citizen Name");
		headerRow.createCell(2).setCellValue(" Plan Name");
		headerRow.createCell(3).setCellValue("Plan status");
		headerRow.createCell(4).setCellValue("Plan Start Date");
		headerRow.createCell(5).setCellValue("Plan End Date");
		headerRow.createCell(6).setCellValue("Benefit Amount");
		
		//List<CitizenPlan> records = planRepo.findAll();
		   
		int dataRowIndex = 1;
		  
		for(CitizenPlan plan : records) {
			Row dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(plan.getCitizenId());
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(2).setCellValue(plan.getPlanName());
			dataRow.createCell(3).setCellValue(plan.getPlanStatus());
			
			if(null != plan.getPlanEndDate()) {
				dataRow.createCell(4).setCellValue(plan.getPlanEndDate()+"");
				
			}else {
				dataRow.createCell(4).setCellValue("N/A");
			}
			
			if(null != plan.getPlanEndDate()) {
				dataRow.createCell(5).setCellValue(plan.getPlanEndDate()+"");
				
			}else {
				dataRow.createCell(5).setCellValue("N/A");
			}
			/*dataRow.createCell(4).setCellValue(plan.getPlan_start_date()+"");
			dataRow.createCell(5).setCellValue(plan.getPlan_end_date()+"");
			dataRow.createCell(6).setCellValue(plan.getBenefit_amount());
			   */
			if(null!=plan.getBenefitAmount()) {
				dataRow.createCell(6).setCellValue(plan.getBenefitAmount());
				
			}else {
				dataRow.createCell(6).setCellValue("N/A");
			}
			
			  dataRowIndex++;


			
		}
		
		FileOutputStream fos = new FileOutputStream( file );
		workbook.write(fos);
		fos.close();
		
		 ServletOutputStream outputStream = response.getOutputStream();
		 workbook.write(outputStream);
		 workbook.close();
		//return true;
		 
		
	}

		
	}


