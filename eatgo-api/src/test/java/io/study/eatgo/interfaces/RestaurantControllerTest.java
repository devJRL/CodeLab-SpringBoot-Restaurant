package io.study.eatgo.interfaces;

import io.study.eatgo.application.RestaurantService;
import io.study.eatgo.domain.MenuItem;
import io.study.eatgo.domain.Restaurant;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith( SpringRunner.class )
@WebMvcTest( RestaurantController.class )
public class RestaurantControllerTest {

  @Autowired
  private MockMvc mvc;

  // Mock object : Application
  @MockBean
  private RestaurantService restaurantService;

  // Dummy Data : Domain - Restaurant
  Long testRestaurantId = 1004L;
  String testRestaurantName = "BabZip";
  String testRestaurantAddress = "Seoul";
  Restaurant restaurant;
  List<Restaurant> restaurantList;

  // Dummy Data : Domain - Menu
  String testMenuName = "Kimchi";
  MenuItem menuItem;
  List<MenuItem> menuItemList;

  // Run before @Test
  @Before
  public void setUp() {
    // Dummy Menu
    menuItemList = new ArrayList<>();
    menuItem = new MenuItem( testMenuName );
    menuItemList.add( menuItem );

    // Dummy Restaurant
    restaurantList = new ArrayList<>();
    restaurant = new Restaurant( testRestaurantId, testRestaurantName, testRestaurantAddress );
    restaurant.setMenuItem( menuItemList );
    restaurantList.add( restaurant );
  }

  @Test
  public void getList() throws Exception {
    // From Mock object
    given( restaurantService.getRestaurantList() ).willReturn( restaurantList );

    // Check Data
    mvc.perform( get( "/restaurants") )
      .andExpect( status().isOk() )
      .andExpect( content().string( containsString( "\"restaurantId\":" + testRestaurantId ) ) )
      .andExpect( content().string( containsString( "\"restaurantName\":\""+ testRestaurantName +"\"" ) ) );
  }

  @Test
  public void getDetail() throws Exception {
    // Mock object
    given( restaurantService.getRestaurantById( testRestaurantId ) ).willReturn( restaurant );

    // Check Data
    mvc.perform( get( "/restaurants/"+testRestaurantId ) )
      .andExpect( status().isOk() )
      .andExpect( content().string( containsString( "\"restaurantId\":" + testRestaurantId ) ) )
      .andExpect( content().string( containsString( "\"restaurantName\":\"" + testRestaurantName + "\"" ) ) )
      .andExpect( content().string( containsString( "{\"menuName\":\"" + testMenuName  + "\"}" ) ) );
  }

}
