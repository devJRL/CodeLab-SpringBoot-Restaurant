package io.study.eatgo.interfaces;

import io.study.eatgo.application.RestaurantService;
import io.study.eatgo.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin
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

  @PostMapping("/restaurants")
  public ResponseEntity<?> postCreate( @RequestBody Restaurant resource )
          throws URISyntaxException {
    Restaurant restaurant = new Restaurant( resource.getRestaurantName(),
                                            resource.getRestaurantAddress() );
    restaurantService.createRestaurant( restaurant );

    URI location = new URI( "/restaurants/" + restaurant.getRestaurantId() );
    return ResponseEntity.created( location ).body( "{}" );
  }
}
