package in.ineuron;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.ineuron.model.Candidate;
import in.ineuron.repository.CandidateRepo;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) throws IOException {
		ApplicationContext beanfactory = SpringApplication.run(SpringDataJpaApplication.class, args);
	
		CandidateRepo repo = beanfactory.getBean(CandidateRepo.class);
		
//		FileInputStream fis=new FileInputStream("C:\\Users\\Chandan\\Documents\\Test\\mypic.jpg");
//		byte[] photoData = fis.readAllBytes();
//		
//		
//		File file = new File("C:\\Users\\Chandan\\Documents\\Test\\biodata.txt");
//		FileReader reader = new FileReader(file);
//		char[] bioDataContent= new char[(int)file.length()];
//		reader.read(bioDataContent);
//		
//		
//		repo.save(new Candidate(null,"Chadan",photoData,bioDataContent));
		
		
		Optional<Candidate> optional = repo.findById(1);
		if(optional.isPresent()) {
			Candidate candidate = optional.get();
			
			FileOutputStream fos = new FileOutputStream("C:\\Users\\Chandan\\Documents\\Test\\output\\retrieved_image.jpg");
			fos.write(candidate.getPhoto());
			fos.flush();
			
			FileWriter writer = new FileWriter(new File("C:\\Users\\Chandan\\Documents\\Test\\output\\retrieved_biodata.txt"));
			writer.write(candidate.getBioData());
			writer.flush();
			
			System.out.println("Data retrived successfully at C:\\Users\\Chandan\\Documents\\Test\\output");
			
		}
		
		
			
		
	}

}
