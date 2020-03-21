package io.study.eatgo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestaurantRepository {

  private List<Restaurant> restaurantList = new ArrayList<>();

  public RestaurantRepository() {
    // Dummy Data for Test
    restaurantList.add( new Restaurant( 1004L, "BabZip", "Seoul" ) );
    restaurantList.add( new Restaurant( 2020L, "Cyber Food", "Seoul" ) );
  }

  public List<Restaurant> findAll() {
    return restaurantList;
  }

  public Restaurant findById( Long id ) {
    return
      restaurantList.stream()
        .filter( r -> r.getId().equals( id ) )
        .findFirst()
        .orElse( null );
  }
}
