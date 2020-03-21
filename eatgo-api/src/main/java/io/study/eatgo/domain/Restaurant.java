package io.study.eatgo.domain;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

  private final Long id;
  private final String name;
  private final String address;
  private List<MenuItem> menuItemList = new ArrayList<>();

  public Restaurant( Long id, String name, String address ) {
    this.id = id;
    this.name = name;
    this.address = address;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getInformation() {
    return "[" + id +"] " + name + " in " + address;
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
