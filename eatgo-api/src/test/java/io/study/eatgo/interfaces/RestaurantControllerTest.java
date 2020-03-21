package io.study.eatgo.interfaces;

import io.study.eatgo.domain.MenuItemRepository;
import io.study.eatgo.domain.MenuItemRepositoryImp;
import io.study.eatgo.domain.RestaurantRepository;
import io.study.eatgo.domain.RestaurantRepositoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith( SpringRunner.class )
@WebMvcTest( RestaurantController.class )
public class RestaurantControllerTest {

  @Autowired
  private MockMvc mvc;

  @SpyBean( RestaurantRepositoryImpl.class )
  private RestaurantRepository restaurantRepository;

  @SpyBean( MenuItemRepositoryImp.class )
  private MenuItemRepository menuItemRepository;

  @Test
  public void getList() throws Exception {
    mvc.perform( get( "/restaurants") )
      .andExpect( status().isOk() )
      .andExpect( content().string( containsString( "\"id\":1004" ) ) )
      .andExpect( content().string( containsString( "\"name\":\"BabZip\"" ) ) );
  }

  @Test
  public void getDetail() throws Exception {
    mvc.perform( get( "/restaurants/1004" ) )
      .andExpect( status().isOk() )
      .andExpect( content().string( containsString( "\"id\":1004" ) ) )
      .andExpect( content().string( containsString( "\"name\":\"BabZip\"" ) ) )
      .andExpect( content().string( containsString( "Kimchi" ) ) );

  }

}
