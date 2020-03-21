package io.study.eatgo.domain;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {

  public List<Restaurant> findAll() {
    // Dummy Data for Test
    List<Restaurant> restaurantList = new ArrayList<>();
    restaurantList.add( new Restaurant( 1004L, "BabZip", "Seoul" ) );
    restaurantList.add( new Restaurant( 2020L, "Cyber Food", "Seoul" ) );

    return restaurantList;
  }
}
