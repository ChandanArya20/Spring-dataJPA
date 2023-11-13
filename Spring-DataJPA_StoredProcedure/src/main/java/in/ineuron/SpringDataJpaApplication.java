package in.ineuron;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.ineuron.model.Person;
import in.ineuron.service.PersonService;

@SpringBootApplication
public class SpringDataJpaApplication {
	
	public static void main(String[] args) {
		ApplicationContext beanFactory = SpringApplication.run(SpringDataJpaApplication.class, args);
		
		PersonService service = beanFactory.getBean(PersonService.class);
		
		List<Person> list = service.fetchDetailsById(2);
		
		list.forEach(result->System.out.println(result.getName()+"  "+result.getCountry()+"  "+result.getAge()));
		
		
		
		
	}

}
