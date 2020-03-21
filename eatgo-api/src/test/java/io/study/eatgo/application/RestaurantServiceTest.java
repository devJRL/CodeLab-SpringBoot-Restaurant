package io.study.eatgo.application;

import io.study.eatgo.domain.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RestaurantServiceTest {

  // Application Layer
  private RestaurantService restaurantService;
  // Domain Layer
  private RestaurantRepository restaurantRepository;
  private MenuItemRepository menuItemRepository;

  @Before // run before @Test
  public void setUp() {
    // TestInstances of Domain Layer
    restaurantRepository = new RestaurantRepositoryImpl();
    menuItemRepository = new MenuItemRepositoryImp();
    // TestInstances of Application Layer
    restaurantService = new RestaurantService( restaurantRepository, menuItemRepository );
  }

  @Test
  public void getRestaurantList() {
    List<Restaurant> restaurantList = restaurantService.getRestaurantList();
    Restaurant restaurant = restaurantList.get(0);
    assertThat( restaurant.getId(), is(1004L) );
  }

  @Test
  public void getRestaurantById() {
    Restaurant restaurant = restaurantService.getRestaurantById(1004L);
    assertThat( restaurant.getId(), is( 1004L) );

    MenuItem menuItem = restaurant.getMenuItemList().get( 0 );
    assertThat( menuItem.getMenuName(), is( "Kimchi" ) );
  }

}