
package io.study.eatgo.interfaces;

import io.study.eatgo.domain.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantController {

  @GetMapping("/restaurants")
  public List<Restaurant> getList() {
    List<Restaurant> restaurantList = new ArrayList<>();

    // TempData for @Test
    String testName = "BabZip";
    String testAddress = "Seoul";
    Long testId = 1004L;
    Restaurant restaurant = new Restaurant( testId, testName, testAddress );

    restaurantList.add(restaurant);

    return restaurantList;
  }

}
