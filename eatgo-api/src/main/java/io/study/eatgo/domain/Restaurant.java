package io.study.eatgo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

  @Id
  @GeneratedValue
  @Setter
  private Long restaurantId;

  private String restaurantName;

  private String restaurantAddress;

  @Transient
  private List<MenuItem> menuItemList;

  public String getInformation() {
    return "[" + restaurantId +"] " + restaurantName + " in " + restaurantAddress;
  }

  public void setMenuItem( List<MenuItem> menuItemList ) {
    this.menuItemList = new ArrayList<>( menuItemList );
  }

  public void updateInformation( String restaurantName, String restaurantAddress ) {
    this.restaurantName = restaurantName;
    this.restaurantAddress = restaurantAddress;
  }

}
