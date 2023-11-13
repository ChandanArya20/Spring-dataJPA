package in.ineuron.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.Candidate;

public interface CandidateRepo extends JpaRepository<Candidate, Integer> {

}
