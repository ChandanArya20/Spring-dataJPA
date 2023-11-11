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
import in.ineuron.returntype.ResultView1;
import in.ineuron.returntype.ResultView2;

@SpringBootApplication
public class SpringDataJpaApplication {

	@Autowired
	ICoronaVaccineRepo repo;
	
	public static void main(String[] args) {
		ApplicationContext beanFactory = SpringApplication.run(SpringDataJpaApplication.class, args);
		
		ICoronaVaccineRepo service = beanFactory.getBean(ICoronaVaccineRepo.class);
		
		service.findByCountryOrderByPriceAsc("USA", ResultView2.class)
			   .forEach(result->System.out.println(result.getName()+"   "+result.getCountry()+"   "+result.getPrice()));
	
				
		
	}

}
