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
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
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
    // Builder Pattern: @Builder of Lombok
    Restaurant restaurant = Restaurant.builder()
      .restaurantId( 1004L )
      .restaurantName( "BabZip" )
      .restaurantAddress( "Seoul" )
      .menuItemList( new ArrayList<>( ) )
      .build();
    restaurantList.add( restaurant );
    // From Mock object
    given( restaurantRepository.findAll() ).willReturn( restaurantList );
    given( restaurantRepository.findById( 1004L ) ).willReturn( Optional.of( restaurant ) );
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

  @Test
  public void createRestaurant() {
    // Save
    // Check Way 1
    Restaurant savedRestaurant = Restaurant.builder()
      .restaurantId( 1234L )
      .restaurantName( "Gosu" )
      .restaurantAddress( "Busan" )
      .build();
    given( restaurantRepository.save( any()) ).willReturn( savedRestaurant );
    // Check Way 2
    given( restaurantRepository.save( any()) ).will( invocation -> {
      Restaurant restaurant = invocation.getArgument(0);
      restaurant.setRestaurantId( 1234L );
      return restaurant;
    } );

    // Create
    Restaurant createdRestaurant = restaurantService.createRestaurant( savedRestaurant );
    assertThat( createdRestaurant.getRestaurantId(), is( 1234L ) );
  }

  @Test
  public void updateRestaurant() {
    // Before
    Restaurant targetRestaurant = Restaurant.builder()
      .restaurantId( 1234L )
      .restaurantName( "Gosu" )
      .restaurantAddress( "Busan" )
      .build();
    given( restaurantRepository.findById( 1004L ) ).willReturn( Optional.of( targetRestaurant ) );

    // Update
    restaurantService.updateRestaurant( 1004L, "SoolZip", "Busan" );
    assertThat( targetRestaurant.getRestaurantName(), is("SoolZip") );
    assertThat( targetRestaurant.getRestaurantAddress(), is("Busan") );
  }

}