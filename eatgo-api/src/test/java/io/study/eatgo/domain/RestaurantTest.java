package io.study.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RestaurantTest {

  @Test
  public void creation() {
    String testName = "BabZip";
    String testAddress = "Seoul";
    Restaurant restaurant = new Restaurant(testName, testAddress);

    assertThat( restaurant.getName(), is(testName) );
    assertThat( restaurant.getAddress(), is(testAddress) );
  }
}