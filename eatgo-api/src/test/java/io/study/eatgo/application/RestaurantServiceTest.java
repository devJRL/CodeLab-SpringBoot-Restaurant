package io.study.eatgo.application;

import io.study.eatgo.domain.MenuItem;
import io.study.eatgo.domain.MenuItemRepository;
import io.study.eatgo.domain.Restaurant;
import io.study.eatgo.domain.RestaurantRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

public class RestaurantServiceTest {

  // Test object : Application
  private RestaurantService restaurantService;

  // Mockito object : Domain ( on Plain Java )
  @Mock
  private RestaurantRepository restaurantRepository;
  @Mock
  private MenuItemRepository menuItemRepository;

  // Run before @Test
  @Before
  public void setUp() {
    // Init Mock object
    MockitoAnnotations.initMocks( this );
    // Fill the Null(Mock object) with Dummy Data
    mockRestaurantRepository();
    mockMenuRepository();
    // TestInstances of Application Layer
    restaurantService = new RestaurantService( restaurantRepository, menuItemRepository );
  }

  private void mockRestaurantRepository() {
    // Dummy Data : Domain - Restaurant
    List<Restaurant> restaurantList = new ArrayList<>();
    Restaurant restaurant = new Restaurant( 1004L, "BabZip", "Seoul" );
    restaurantList.add( restaurant );
    // From Mock object
    given( restaurantRepository.findAll() ).willReturn( restaurantList );
    given( restaurantRepository.findById( 1004L ) ).willReturn( restaurant );
  }

  private void mockMenuRepository() {
    // Dummy Data : Domain - MenuItem
    List<MenuItem> menuItemList = new ArrayList<>();
    MenuItem menuItem = new MenuItem( "Kimchi" );
    menuItemList.add( menuItem );
    // From Mock object
    given( menuItemRepository.findAllByRestaurantId( 1004L ) ).willReturn( menuItemList );
  }

  @Test
  public void getRestaurantList() {
    List<Restaurant> restaurantList = restaurantService.getRestaurantList();
    Restaurant restaurant = restaurantList.get(0);
    assertThat( restaurant.getRestaurantId(), is(1004L) );
  }

  @Test
  public void getRestaurantById() {
    Restaurant restaurant = restaurantService.getRestaurantById(1004L);
    assertThat( restaurant.getRestaurantId(), is( 1004L) );

    MenuItem menuItem = restaurant.getMenuItemList().get( 0 );
    assertThat( menuItem.getMenuName(), is( "Kimchi" ) );
  }

}