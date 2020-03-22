package io.study.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RestaurantRepositoryImplTest {

  // Temporary Test before using JPA
  @Test
  public void save() {
    // Check : Does 'newRestaurnat' have ID after saving?
    RestaurantRepository restaurantRepository = new RestaurantRepositoryImpl();
    int oldCount = restaurantRepository.findAll().size();
    Restaurant newRestaurant = new Restaurant( "Gosu", "Busan" );
    restaurantRepository.save( newRestaurant );
    assertThat( newRestaurant.getRestaurantId(), is( 1234L ) );

    // Check : Is 'restaurantRepository' success to save 'newRestaurant'?
    int newCount = restaurantRepository.findAll().size();
    assertThat( newCount - oldCount, is( 1 ) );
  }

}