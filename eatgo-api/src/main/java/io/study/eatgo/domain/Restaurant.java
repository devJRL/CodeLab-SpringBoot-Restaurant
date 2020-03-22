package io.study.eatgo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant {

  @Id
  @GeneratedValue
  private Long restaurantId;

  private String restaurantName;
  private String restaurantAddress;

  @Transient // TODO : Remove
  private List<MenuItem> menuItemList = new ArrayList<>();

  public Restaurant() {
    // Definition For @RequestBody
  }

  public Restaurant( String restaurantName, String restaurantAddress ) {
    this.restaurantName = restaurantName;
    this.restaurantAddress = restaurantAddress;
  }

  public Restaurant( Long restaurantId, String restaurantName, String restaurantAddress ) {
    this.restaurantId = restaurantId;
    this.restaurantName = restaurantName;
    this.restaurantAddress = restaurantAddress;
  }

  public Long getRestaurantId() {
    return restaurantId;
  }

  public void setId( long restaurantId ) {
    this.restaurantId = restaurantId;
  }

  public String getRestaurantName() {
    return restaurantName;
  }

  public String getRestaurantAddress() {
    return restaurantAddress;
  }

  public String getInformation() {
    return "[" + restaurantId +"] " + restaurantName + " in " + restaurantAddress;
  }

  public void setMenuItem( List<MenuItem> menuItemList ) {
    for ( MenuItem menuItem : menuItemList )
      addMenuItem( menuItem );
  }

  public void addMenuItem( MenuItem menuItem ) {
    menuItemList.add( menuItem );
  }

  public List<MenuItem> getMenuItemList() {
    return menuItemList;
  }
}
