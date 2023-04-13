package in.ashokit.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.requestOR_DTO.SearchRequest;
import in.ashokit.service.ReportService;

@Controller
public class ReportController {
	
	@Autowired
	private ReportService service;
	
	
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response)throws Exception {
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition","attachment;filename=plans.pdf");
		service.exportPdf(response);
	}
	
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response)throws Exception {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition","attachment;filename=plans.xls");
		service.exportExcel(response);
	}
	
	@PostMapping("/search")
	public String handleSearch( SearchRequest search,Model model) {
		System.out.println("inside controller");

		System.out.println(search);
		
		List<CitizenPlan> plans=service.search(search);
		model.addAttribute("plans",plans);
		model.addAttribute("search",search);
		init(model);
		
		return "index";
		
	}
	
	//this method is used to load index page
	
	@GetMapping("/")
	public String indexPage(Model model) {
		System.out.println("in loading from method");
		model.addAttribute("search", new SearchRequest());
		init(model);
		
		return "index";
		
	}

	private void init(Model model) {
		System.out.println("in  init method");

		model.addAttribute("names", service.getPlanNames());
		model.addAttribute("status", service.getPlanStatuses());
	}

}
