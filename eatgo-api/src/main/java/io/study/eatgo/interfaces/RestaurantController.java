
package io.study.eatgo.interfaces;

import io.study.eatgo.domain.Restaurant;
import io.study.eatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

  private RestaurantRepository restaurantRepository = new RestaurantRepository();

  @GetMapping("/restaurants")
  public List<Restaurant> getList() {
    List<Restaurant> restaurantList = restaurantRepository.findAll();

    return restaurantList;
  }

  @GetMapping("/restaurants/{id}")
  public Restaurant detail( @PathVariable("id") Long id  ) {
    Restaurant restaurant = restaurantRepository.findById( id );

    return restaurant;
  }
}
