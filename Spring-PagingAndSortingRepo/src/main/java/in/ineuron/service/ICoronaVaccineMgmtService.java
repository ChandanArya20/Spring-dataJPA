package in.ineuron.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronaVaccineMgmtService {
	public Iterable<CoronaVaccine> findDetailsBySort(Boolean flag,String... properties);
	public Iterable<CoronaVaccine> fetchDetailsByPage(int pageNo, int pageSize,boolean direction,String...properties);
	public Iterable<CoronaVaccine> fetchDetailsByPagination(int pageSize);
	public Iterable<CoronaVaccine> fetchDetailsByPageNo(int pageNo, int pageSize);
}
