package votenorestaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import votenorestaurante.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
