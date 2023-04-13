package in.ashokit.service;


import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repo.CitizenPlanRepository;
import in.ashokit.requestOR_DTO.SearchRequest;
import in.ashokit.util.EmailUtils;
import in.ashokit.util.ExcelGenerator;
import in.ashokit.util.PdfGenerator;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private CitizenPlanRepository planRepo;
    
	@Autowired
	private ExcelGenerator excelgenerator;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private EmailUtils emailUtils;
	
	public List<String> getPlanNames() {
	  
		List<String> planNames=planRepo.getPlanName();
		return planNames;
	}

	public List<String> getPlanStatuses() {
		// TODO Auto-generated method stub
		
		List<String> planStatuses = planRepo.getPlanStatus();
		return planStatuses;
	}

	public List<CitizenPlan> search(SearchRequest request) {
		System.out.println("inside the service method");
		CitizenPlan entity=new CitizenPlan();
		if(null!=request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		
		if(null!=request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if(null!=request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		
		List<CitizenPlan> citizenPlans =planRepo.findAll(Example.of(entity));
		System.out.println(citizenPlans);
		return planRepo.findAll(Example.of(entity));
		
	}

	public boolean exportExcel(HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		File f = new File("Plans.xls");
		List<CitizenPlan> plans = planRepo.findAll();
		excelgenerator.generate(response,plans , f);
		
		String subject = "Test mail Subject";
		String body = "<h1>Test mail body</h1>";
		String to = "vijayabandha22@gmail.com";
		
		//File f = new File("Plans.xls");
		
		emailUtils.sendEmail(subject, body, to,f);
		
		f.delete();
		
		return true;
		
		//List<CitizenPlan> records = planRepo.findAll();
		
		/*Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("plans-data");
		Row headerRow = sheet.createRow(0);
		
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Citizen Name");
		headerRow.createCell(2).setCellValue(" Plan Name");
		headerRow.createCell(3).setCellValue("Plan status");
		headerRow.createCell(4).setCellValue("Plan Start Date");
		headerRow.createCell(5).setCellValue("Plan End Date");
		headerRow.createCell(6).setCellValue("Benefit Amount");
		
		List<CitizenPlan> records = planRepo.findAll();
		   
		int dataRowIndex = 1;
		  
		for(CitizenPlan plan : records) {
			Row dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(plan.getCitizenId());
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(2).setCellValue(plan.getPlanName());
			dataRow.createCell(3).setCellValue(plan.getPlanStatus());
			
			if(null != plan.getPlan_start_date()) {
				dataRow.createCell(4).setCellValue(plan.getPlan_start_date()+"");
				
			}else {
				dataRow.createCell(4).setCellValue("N/A");
			}
			
			if(null != plan.getPlan_end_date()) {
				dataRow.createCell(5).setCellValue(plan.getPlan_end_date()+"");
				
			}else {
				dataRow.createCell(5).setCellValue("N/A");
			}
			dataRow.createCell(4).setCellValue(plan.getPlan_start_date()+"");
			dataRow.createCell(5).setCellValue(plan.getPlan_end_date()+"");
			dataRow.createCell(6).setCellValue(plan.getBenefit_amount());
			   
			if(null!=plan.getBenefit_amount()) {
				dataRow.createCell(6).setCellValue(plan.getBenefit_amount());
				
			}else {
				dataRow.createCell(6).setCellValue("N/A");
			}
			
			  dataRowIndex++;


			
		}
		
		FileOutputStream fos = new FileOutputStream(new File ("plans.xls"));
		workbook.write(fos);
		workbook.close();
		
		 ServletOutputStream outputStream = response.getOutputStream();
		 workbook.write(outputStream);
		 workbook.close();
		return true;
		 */
		
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		File f = new File("Plans.pdf");
		
		List<CitizenPlan> plans = planRepo.findAll();
		
		pdfGenerator.generate(response, plans , f);
		String subject = "Test mail Subject";
		String body = "<h1>Test mail body</h1>";
		String to = "vijayabandha22@gmail.com";
		
		//File f = new File("Plans.xls");
		
		emailUtils.sendEmail(subject, body, to,f);
		
		f.delete();
		
		return true;
		
		/*Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		Paragraph p = new Paragraph("Citizen plans Info");
		document.add(p);
		PdfPTable table = new PdfPTable(6);
		
		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Plan Start Date");
		table.addCell("Plan End Date");
		
		List<CitizenPlan> plans = planRepo.findAll();
		
		for(CitizenPlan plan : plans) {
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getPlan_start_date()+"");
			table.addCell(plan.getPlan_end_date()+"");
			
			
		}
		document.add(table);
		
		document.close();	
		
		return true;
	}
*/
}
}
