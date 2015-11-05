package votenorestaurante.repository;


import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import votenorestaurante.model.Ranking;

import java.util.List;

public interface RankingRepository extends JpaRepository<Ranking, Long>{
    List<Ranking> findByUseremail(String useremail);

    //List<Ranking> findByUseremailAndSort(String useremail, Sort sort);
}