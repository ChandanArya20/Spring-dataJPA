package in.ineuron.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.returntype.ResultView1;
import in.ineuron.returntype.View;

public interface ICoronaVaccineRepo extends CrudRepository<CoronaVaccine, Long> {
	
	public <T extends View> List<T> findByCountryOrderByPriceAsc(String country, Class<T> clazz);

}
