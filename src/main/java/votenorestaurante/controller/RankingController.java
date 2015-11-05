package votenorestaurante.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import votenorestaurante.model.Ranking;
import votenorestaurante.model.Restaurant;
import votenorestaurante.service.RankingService;

import java.util.List;

@Controller
@RequestMapping(value = "/protected/ranking")
public class RankingController {

    @Autowired
    RankingService rankingService;

    @RequestMapping(method = RequestMethod.GET)
    public String welcome() {
        return "ranking";
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> loadAllUserRestaurants(@RequestParam String userEmail){
        List<Ranking> ranking = rankingService.findByUseremail(userEmail);
        return new ResponseEntity<List<Ranking>>(ranking, HttpStatus.OK);
    }
}