package io.study.eatgo.interfaces;

import io.study.eatgo.domain.MenuItem;
import io.study.eatgo.domain.MenuItemRepository;
import io.study.eatgo.domain.Restaurant;
import io.study.eatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

  @Autowired private RestaurantRepository restaurantRepository;
  @Autowired private MenuItemRepository menuItemRepository;

  @GetMapping("/restaurants")
  public List<Restaurant> getList() {
    List<Restaurant> restaurantList = restaurantRepository.findAll();

    return restaurantList;
  }

  @GetMapping("/restaurants/{id}")
  public Restaurant detail( @PathVariable("id") Long id  ) {
    Restaurant restaurant = restaurantRepository.findById( id );
    List<MenuItem> menuItemList = menuItemRepository.findAllByRestaurantId( id );
    restaurant.setMenuItem( menuItemList );

    return restaurant;
  }
}
