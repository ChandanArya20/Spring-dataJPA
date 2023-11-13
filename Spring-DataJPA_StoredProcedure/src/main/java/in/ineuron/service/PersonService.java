package in.ineuron.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.model.Person;

@Service
public class PersonService {

    @Autowired
    EntityManager manager;

    @Transactional
    public List<Person> fetchDetailsById(Integer id) {

        StoredProcedureQuery query = manager.createStoredProcedureQuery("get_all_details_by_id",Person.class);
        
        query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
//        query.registerStoredProcedureParameter(2, String.class, ParameterMode.OUT);
//        query.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
//        query.registerStoredProcedureParameter(4, Integer.class, ParameterMode.OUT);

        query.setParameter(1, id);

        List<Person> list = query.getResultList();

        return list;
    }

}
