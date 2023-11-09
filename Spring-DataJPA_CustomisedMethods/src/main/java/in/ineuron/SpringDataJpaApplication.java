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
		
		ICoronaVaccineRepo service = beanFactory.getBean(ICoronaVaccineRepo.class);
		
		List<CoronaVaccine> list = service.findByCountry("India");
		list.forEach(System.out::println);
		
		List<CoronaVaccine> list1 = service.findByCountryAndPriceGreaterThan("India", 400.0);
		list1.forEach(System.out::println);
		
		List<CoronaVaccine> list2 = service.findByPriceBetween(300.0, 500.0);
		list2.forEach(System.out::println);
		
		List<CoronaVaccine> list3 = service.findByCountryOrderByPriceAsc("USA");
		list3.forEach(System.out::println);
		
		List<CoronaVaccine> list4 = service.findByCountryNotIn(List.of("India","USA"));
		list4.forEach(System.out::println);
		
		
		
		List<ResultView> list5 = service.findByPriceGreaterThanEqualOrderByPriceDesc(400.0);
		list5.forEach(result->System.out.println(result.getName()+"  "+result.getCountry()));
		
	
				
		
	}

}
