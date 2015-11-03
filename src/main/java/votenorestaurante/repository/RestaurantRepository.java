package votenorestaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import votenorestaurante.model.Restaurant;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByType(String type);
}
