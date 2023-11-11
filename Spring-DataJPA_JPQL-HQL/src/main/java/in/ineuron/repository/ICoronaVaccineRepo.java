package in.ineuron.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronaVaccineRepo extends CrudRepository<CoronaVaccine, Long> {
	
//	@Query("FROM CoronaVaccine WHERE country=:coun")
//	@Query("FROM in.ineuron.bo.CoronaVaccine WHERE country=:coun")
//	@Query(value="SELECT * FROM Corona_vaccine WHERE country=:coun",nativeQuery = true)
//	List<CoronaVaccine> fetchAllRecordByCountry(@Param("coun") String country);

//	@Query("FROM CoronaVaccine WHERE country=?1")
	@Query("FROM CoronaVaccine WHERE country=:country")
	List<CoronaVaccine> fetchAllRecordByCountry( String country);
	
	
	@Query("SELECT name,country,price FROM CoronaVaccine WHERE price BETWEEN :lowprice AND :highprice")
	List<Object[]> fetchRecordByPriceRange( double lowprice, double highprice);
	
	@Query("SELECT name FROM CoronaVaccine WHERE country IN(:country1 ,:country2)")
	List<String> fetchVaccineNameByCountry( String country1, String country2);

	
	@Modifying
	@Transactional
	@Query(value="INSERT INTO corona_vaccine(name, company, country, price, requiredDoseCount) VALUES(:name, :company, :country, :price, :requiredDoseCount)",nativeQuery = true )
	int insertRecord(String name, String company, String country, double price, int requiredDoseCount);
	
	@Modifying
	@Transactional
	@Query("UPDATE CoronaVaccine SET price=:newPrice WHERE id=:id")
	int updateRecord(double newPrice, Long id);

	@Modifying
	@Transactional
	@Query("DELETE FROM CoronaVaccine WHERE country=:country")
	int deleteRecordByCountry(String country);
	
	
	
}











