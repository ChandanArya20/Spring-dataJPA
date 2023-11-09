package in.ineuron.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronaVaccineMgmtService {
	public String registerVacine(CoronaVaccine vaccine);
	public ArrayList<CoronaVaccine> registerInBatch(ArrayList<CoronaVaccine> vaccines);
	public Long getVaccinesCount();
	public Boolean checkAvailability(Long id);
	public Iterable<CoronaVaccine> fetchAllDetails();
	public Iterable<CoronaVaccine> fetchAllDetailsByID(List<Long> ids);
	public Optional<CoronaVaccine> fecthVaccineById(Long id);
	public String removeVaccineById(Long id);
	public String removeVaccineByObject(CoronaVaccine vaccine);
	public String removeVaccinesById(List<Long>ids);
	public String updateCoronaVaccine(CoronaVaccine vaccine);
}
