package votenorestaurante.service;

import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import votenorestaurante.model.Ranking;
import votenorestaurante.repository.RankingRepository;

import java.util.List;

@Service
public class RankingService {

    @Autowired
    private RankingRepository rankingRepository;

    public void save(Ranking ranking){
        rankingRepository.save(ranking);
    }

    public List<Ranking> findByUseremail(String userEmail){
        return rankingRepository.findByUseremail(userEmail);
        //return rankingRepository.findByUseremailAndSort(userEmail, new Sort(Sort.Direction.DESC, "grade"));
    }
}
