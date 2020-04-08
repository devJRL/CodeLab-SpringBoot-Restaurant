package io.study.eatgo.interfaces;

import io.study.eatgo.application.RestaurantService;
import io.study.eatgo.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
  public ResponseEntity<?> postCreate( @Valid @RequestBody Restaurant resource )
          throws URISyntaxException {
    Restaurant restaurant = Restaurant.builder()
                                      .restaurantName( resource.getRestaurantName() )
                                      .restaurantAddress( resource.getRestaurantAddress() )
                                      .build();
    restaurantService.createRestaurant( restaurant );

    URI location = new URI( "/restaurants/" + restaurant.getRestaurantId() );
    return ResponseEntity.created( location ).body( "{}" );
  }

  @PatchMapping("/restaurants/{id}")
  public Restaurant patchUpdate( @PathVariable("id") Long restaurantId,
                                 @Valid @RequestBody Restaurant restaurant ) {
    restaurantService.updateRestaurant( restaurantId,
                                        restaurant.getRestaurantName(),
                                        restaurant.getRestaurantAddress() );

    return restaurantService.getRestaurantById( restaurantId );
  }

}
