package io.study.eatgo.interfaces;

import io.study.eatgo.application.RestaurantService;
import io.study.eatgo.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

  @Autowired
  private RestaurantService restaurantService;

  @GetMapping("/restaurants")
  public List<Restaurant> getList() {
    List<Restaurant> restaurantList = restaurantService.getRestaurantList();
    return restaurantList;
  }

  @GetMapping("/restaurants/{id}")
  public Restaurant detail( @PathVariable("id") Long  restaurantId ) {
    Restaurant restaurant = restaurantService.getRestaurantById( restaurantId );
    return restaurant;
  }

}
