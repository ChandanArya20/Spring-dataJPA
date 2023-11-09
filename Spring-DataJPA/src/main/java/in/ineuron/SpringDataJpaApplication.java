package in.ineuron;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
		
		ICoronaVaccineMgmtService service = context.getBean(ICoronaVaccineMgmtService.class);
		
//		CoronaVaccine vaccine1 = new CoronaVaccine(null,"Covaxin","Bharat-Biotech","India",500.0,3);	
//		System.out.println(service.registerVacine(vaccine1));
		
		ArrayList<CoronaVaccine> vaccines = new ArrayList<CoronaVaccine>();	
		vaccines.add(new CoronaVaccine(null, "sputnik", "russie", "Russia", 567.0, 2));
		vaccines.add(new CoronaVaccine(null, "pyzer", "pyzwer", "USA", 678.0, 2));
		vaccines.add(new CoronaVaccine(null, "moderena", "moderena", "USA",1200.0, 2));
		service.registerInBatch(vaccines);
		
		
//		System.out.println(service.getVaccinesCount());
//		System.out.println(service.checkAvailability(6L));

//		service.fetchAllDetails().forEach(System.out::println);
		
		
//		service.fetchAllDetailsByID(Arrays.asList(5L,9L,11L,13L)).forEach(System.out::println);
		
//		Optional<CoronaVaccine> optional = service.fecthVaccineById(121L);
//		if(optional.isPresent())
//			System.out.println(optional.get());
//		else
//			System.out.println("Data not found...");
		
//		System.out.println(service.fecthVaccineById(13L).orElse(new CoronaVaccine()));
		
		
//		System.out.println(service.updateCoronaVaccine(new CoronaVaccine(54L, "sputnik", "russieVac", "Russia", 550.0, 2)));
		
//		System.out.println(service.removeVaccineById(5L));
		
		
//		try {
////			System.out.println(service.removeVaccineByObject(new CoronaVaccine(null,"sputnik", "russieVac", "Russia", 550.0, 2)));
//			System.out.println(service.removeVaccineByObject(new CoronaVaccine(72L,"sputnik", "russieVac", "Russia", 550.0, 2)));
//			
//		}catch(Exception e) {
//			System.out.println("Id can,t be null");
//			System.out.println("Data not deleted...");
//		}
//		
		
		
		
//		System.out.println(service.removeVaccinesById(Arrays.asList(8L,9L,10L)));
		
		
		
		
		
		
		
		
		
		
		
		
		
		((ConfigurableApplicationContext) context).close();
	}

}
