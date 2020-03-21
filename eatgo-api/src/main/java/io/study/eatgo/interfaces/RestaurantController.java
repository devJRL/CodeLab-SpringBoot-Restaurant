
package io.study.eatgo.interfaces;

import io.study.eatgo.domain.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantController {

  // TempData for @Test
  Long testId = 1004L;
  String testName = "BabZip";
  String testAddress = "Seoul";

  @GetMapping("/restaurants")
  public List<Restaurant> getList() {
    List<Restaurant> restaurantList = new ArrayList<>();
    Restaurant restaurant = new Restaurant( testId, testName, testAddress );
    restaurantList.add(restaurant);

    return restaurantList;
  }

  @GetMapping("/restaurants/{id}")
  public Restaurant detail( @PathVariable("id") Long id  ) {
    List<Restaurant> restaurantList = new ArrayList<>();
    restaurantList.add( new Restaurant( id, testName, testAddress ) );
    restaurantList.add( new Restaurant( 2020L, "Cyber Food", testAddress ) );

    Restaurant restaurant =
      restaurantList.stream()
        .filter( r -> r.getId().equals( id ) )
        .findFirst()
        .orElse( null );

    return restaurant;
  }
}
