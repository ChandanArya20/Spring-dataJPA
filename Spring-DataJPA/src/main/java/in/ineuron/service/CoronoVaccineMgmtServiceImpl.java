package in.ineuron.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;

@Service("service")
public class CoronoVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public String registerVacine(CoronaVaccine vaccine) {
		
		CoronaVaccine savedVaccine = null;		
		if (vaccine != null) {
			savedVaccine = repo.save(vaccine);
		}
		return savedVaccine != null ? "vaccine registered succesfully with " + savedVaccine.getRegNo()
				: "vaccine registration failed";
	}

	@Override
	public ArrayList<CoronaVaccine> registerInBatch(ArrayList<CoronaVaccine> vaccines) {
			
			return (ArrayList<CoronaVaccine>) repo.saveAll(vaccines);
	}

	@Override
	public Long getVaccinesCount() {
		return repo.count();	
	}

	@Override
	public Boolean checkAvailability(Long id) {
		return repo.existsById(id);
	}

	@Override
	public Iterable<CoronaVaccine> fetchAllDetails() {
		return repo.findAll();
	}

	@Override
	public Iterable<CoronaVaccine> fetchAllDetailsByID(List<Long> ids) {
		return repo.findAllById(ids);
	}

	@Override
	public Optional<CoronaVaccine> fecthVaccineById(Long id) {
		return repo.findById(id);
	}

	@Override
	public String removeVaccineById(Long id) {
		boolean flag = repo.existsById(id);
		if(flag) {
			repo.deleteById(id);
			return "Data deleted successfully...";
		}else
			return "Data not found";
	}

	@Override
	public String removeVaccineByObject(CoronaVaccine vaccine) {
		boolean flag = repo.existsById(vaccine.getRegNo());
		if(flag) {
			repo.delete(vaccine);
			return "Data deleted successfully...";
		}else
			return "Data not found";
	}

	@Override
	public String removeVaccinesById(List<Long> ids) {
		Iterable<CoronaVaccine> listEntities = repo.findAllById(ids);
		int count=ids.size();
		if(count==((List<CoronaVaccine>) listEntities).size()) {
			repo.deleteAllById(ids);
			return "Records deleted successfully...";
		}else
			return "Problem in deleting records..., Reason: For every id data is not available";
	}

	@Override
	public String updateCoronaVaccine(CoronaVaccine vaccine) {
		boolean flag = repo.existsById(vaccine.getRegNo());
		if(flag) {
			repo.save(vaccine);
			return "Data updated successfully...";
		}else
			return "Data not found...";
	}

	
}
