package io.study.eatgo.application;

import io.study.eatgo.domain.MenuItemRepository;
import io.study.eatgo.domain.Restaurant;
import io.study.eatgo.domain.RestaurantNotFoundException;
import io.study.eatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

  @Autowired
  private  RestaurantRepository restaurantRepository;

  @Autowired
  private  MenuItemRepository menuItemRepository;

  public RestaurantService( RestaurantRepository restaurantRepository,
                            MenuItemRepository menuItemRepository ) {
    this.restaurantRepository = restaurantRepository;
    this.menuItemRepository = menuItemRepository;
  }

  public List<Restaurant> getRestaurantList() {
    List<Restaurant> restaurantList = restaurantRepository.findAll();
    return restaurantList;
  }

  public  Restaurant getRestaurantById ( Long restaurantId ) {
    Restaurant restaurant
      = restaurantRepository.findById( restaurantId )
        .orElseThrow( ( ) -> new RestaurantNotFoundException( restaurantId ) );
    restaurant.setMenuItem( menuItemRepository.findAllByRestaurantId( restaurantId ) );
    return restaurant;
  }

  public Restaurant createRestaurant( Restaurant restaurant ) {
    return restaurantRepository.save( restaurant );
  }

  public Restaurant updateRestaurant( long restaurantId, String restaurantName, String restaurantAddress ) {
    Restaurant restaurant = restaurantRepository.findById( restaurantId ).orElse( null );
    restaurant.updateInformation( restaurantName, restaurantAddress );
    restaurantRepository.save( restaurant );
    return restaurant;
  }

}
