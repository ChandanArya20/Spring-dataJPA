package in.ineuron;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.ineuron.dao.Employee;
import in.ineuron.repository.EmployeeRepository;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext beanfactory = SpringApplication.run(SpringDataJpaApplication.class, args);
	
		EmployeeRepository repo = beanfactory.getBean(EmployeeRepository.class);
		
//		repo.save(new Employee("Chandan Kumar",LocalDate.of(2023, 8, 7),LocalDateTime.of(2002, 8, 10, 4, 30, 0)));
//		repo.save(new Employee("Shivam Singh",LocalDate.of(2021, 6, 15),LocalDateTime.of(2001, 2, 12, 12, 00, 0)));
//		System.out.println("Employee saved...");
		
		Employee emp = repo.findById(1).orElse(null);
		System.out.println(emp);
		
		
	}

}
