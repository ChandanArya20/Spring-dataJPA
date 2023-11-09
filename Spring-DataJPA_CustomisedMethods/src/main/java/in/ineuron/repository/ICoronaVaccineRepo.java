package in.ineuron.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.returntype.ResultView;

public interface ICoronaVaccineRepo extends CrudRepository<CoronaVaccine, Long> {
	
	List<CoronaVaccine> findByCountry(String country);
	List<CoronaVaccine> findByCountryAndPriceGreaterThan(String country, Double price);
	List<CoronaVaccine> findByPriceBetween(Double price1,Double price2);
	List<CoronaVaccine> findByCountryOrderByPriceAsc(String country);
	List<CoronaVaccine> findByCountryNotIn(List<String> countries);
	
	List<ResultView> findByPriceGreaterThanEqualOrderByPriceDesc(Double price);	

}
