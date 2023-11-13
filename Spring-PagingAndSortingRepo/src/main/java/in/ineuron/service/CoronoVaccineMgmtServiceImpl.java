package in.ineuron.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;

@Service("service")
public class CoronoVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public Iterable<CoronaVaccine> findDetailsBySort(Boolean flag, String... properties) {
		Sort sort=Sort.by(flag?Direction.ASC:Direction.DESC,properties);
		return repo.findAll(sort);
	}

	@Override
	public Iterable<CoronaVaccine> fetchDetailsByPage(int pageNo, int pageSize, boolean direction,
			String... properties) {
		
		Pageable pageable = PageRequest.of(pageNo, pageSize, direction?Direction.ASC:Direction.DESC,properties);
		Page<CoronaVaccine> page = repo.findAll(pageable);
		List<CoronaVaccine> content = page.getContent();
		return content;
	}

	@Override
	public Iterable<CoronaVaccine> fetchDetailsByPagination(int pageSize) {
		
		Long totalRecord=repo.count();
		
		Long pagesCount=totalRecord/pageSize;
		pagesCount=totalRecord%pageSize==0?pagesCount:++pagesCount;
		
		for(int i=0;i<pagesCount;i++) {
			
			Pageable pageable = PageRequest.of(i,pageSize);
			Page<CoronaVaccine> page = repo.findAll(pageable);
			page.getContent().forEach(System.out::println);
			System.out.println(i+1+" of "+page.getTotalPages());
		}System.out.println();
		
		
		
		return null;
	}

	@Override
	public Iterable<CoronaVaccine> fetchDetailsByPageNo(int pageNo, int pageSize) {
		
		Pageable pageable=PageRequest.of(pageNo, pageSize);
		Page<CoronaVaccine> page = repo.findAll(pageable);
		return page.getContent();
	}

	
	
}
