package io.study.eatgo.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuItemRepositoryImp implements MenuItemRepository {

  private List<MenuItem> menuItemList;

  public MenuItemRepositoryImp() {
    // Dummy Data for Test
    menuItemList = new ArrayList<>();
    menuItemList.add( new MenuItem( "Kimchi" ) );
  }

  @Override
  public List<MenuItem> findAllByRestaurantId( Long restaurantId ) {
    return menuItemList;
  }

}
