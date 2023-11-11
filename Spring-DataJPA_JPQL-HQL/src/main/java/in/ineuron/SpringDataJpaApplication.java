package in.ineuron;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.repository.ICoronaVaccineRepo;
import in.ineuron.returntype.ResultView;

@SpringBootApplication
public class SpringDataJpaApplication {

	@Autowired
	ICoronaVaccineRepo repo;
	
	public static void main(String[] args) {
		ApplicationContext beanFactory = SpringApplication.run(SpringDataJpaApplication.class, args);
		
		ICoronaVaccineRepo repo = beanFactory.getBean(ICoronaVaccineRepo.class);
		
		
//		repo.fetchAllRecordByCountry("India").forEach(System.out::println);
//		
//		repo.fetchRecordByPriceRange(400.0, 700.0).forEach(objArr->{
//			
//			for(Object obj:objArr) {
//				System.out.print(obj+" ");
//			}
//			System.out.println();
//		});
//		
//		repo.fetchVaccineNameByCountry("India", "Russia").forEach(System.out::println);
		
		
//		int count=repo.insertRecord("CO-Vax", "TitoForm", "USA", 850.0, 2);
//		System.out.println(count);
		
//		int updatedRecord = repo.updateRecord(900.0, 18L);
//		System.out.println("Updated record : "+updatedRecord);
		
		int deletedRecord= repo.deleteRecordByCountry("Maxico");
		System.out.println("Deleted records : "+deletedRecord);
		
	
				
		
	}

}
