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
		
		
//		Iterable<CoronaVaccine> entities = service.findDetailsBySort(true, "price","name");
//		entities.forEach(vaccine->System.out.println(vaccine.getPrice()+" == "+vaccine.getName()));
		
		
//		service.fetchDetailsByPage(1, 3, true, "price","name").
//		forEach(vaccine->System.out.println(vaccine.getName()+" "+vaccine.getPrice()));
		
//		service.fetchDetailsByPagination(2);
		
		
		final int pageSize=2;		
		service.fetchDetailsByPageNo(2, pageSize).
				forEach(System.out::println);
		
		((ConfigurableApplicationContext) context).close();
		
		
		
		
	}

}
