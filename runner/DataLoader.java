package in.ashokit.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repo.CitizenPlanRepository;

@Component
public class DataLoader  implements ApplicationRunner{
	@Autowired
	private CitizenPlanRepository repo;
     
	
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		//repo.deleteAll();
		System.out.println("from runner class");
		
		CitizenPlan c1=new CitizenPlan();
		
		c1.setCitizenId(10107);
		c1.setCitizenName("merry");
		c1.setGender("female");
		c1.setPlanName("employment");
		c1.setPlanStatus("terminated");
		c1.setPlanEndDate(LocalDate.now().minusMonths(4));
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenefitAmount(5000.0);
		c1.setTerminateDate(LocalDate.now());
		c1.setTerminationReason("govt job");
		
		
		CitizenPlan c2=new CitizenPlan();
		c2.setCitizenId(10108);
		c2.setCitizenName("allen");
		c2.setGender("male");
		c2.setPlanName("employment");
		c2.setPlanStatus("Denied");
		c2.setDenialReason("property income");
		
		CitizenPlan c3=new CitizenPlan();
		c3.setCitizenId(10109);
		c3.setCitizenName("scott");
		c3.setGender("male");
		c3.setPlanName("medical");
		c3.setPlanStatus("Denied");
		c3.setDenialReason("property income");
		
		
		
		
		CitizenPlan c4=new CitizenPlan();
		
		c4.setCitizenId(10107);
		c4.setCitizenName("danny");
		c4.setGender("male");
		c4.setPlanName("medical");
		c4.setPlanStatus("terminated");
		c4.setPlanEndDate(LocalDate.now().minusMonths(4));
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenefitAmount(9000.0);
		c4.setTerminateDate(LocalDate.now());
		c4.setTerminationReason("govt job");
		
		List<CitizenPlan> list= Arrays.asList(c1,c2,c3,c4);
		repo.saveAll(list);
		
		System.out.println("records inserted");
		
		
	}

}
