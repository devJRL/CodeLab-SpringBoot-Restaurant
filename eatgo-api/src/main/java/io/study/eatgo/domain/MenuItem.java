package io.study.eatgo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MenuItem {

  @Id
  @GeneratedValue
  private Long id;

  private Long restaurantId;

  private final String menuName;

  public MenuItem( String menuName ) {
    this.menuName = menuName;
  }

  public String getMenuName() {
    return menuName;
  }

}