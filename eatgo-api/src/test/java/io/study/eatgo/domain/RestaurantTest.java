package io.study.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RestaurantTest {

  String testName = "BabZip";
  String testAddress = "Seoul";

  Restaurant restaurant = new Restaurant( testName, testAddress );

  @Test
  public void createInstance() {
    assertThat( restaurant.getName(), is( testName ) );
    assertThat( restaurant.getAddress(), is( testAddress ) );
  }

  @Test
  public void getInformation() {
    assertThat(restaurant.getInformation(), is(testName + " in " + testAddress));
  }
}