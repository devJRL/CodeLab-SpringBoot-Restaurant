package io.study.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RestaurantTest {

  // Dummy Data for Test
  Long testId = 1004L;
  String testName = "BabZip";
  String testAddress = "Seoul";
  Restaurant restaurant = new Restaurant( testId, testName, testAddress );

  @Test
  public void createInstance() {
    assertThat( restaurant.getRestaurantId(), is( testId ) );
    assertThat( restaurant.getRestaurantName(), is( testName ) );
    assertThat( restaurant.getRestaurantAddress(), is( testAddress ) );
  }

  @Test
  public void getInformation() {
    assertThat(restaurant.getInformation(), is("[" + testId +"] " + testName + " in " + testAddress ) );
  }
}