package io.study.eatgo.interfaces;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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
      .andExpect( content().string( containsString( "\"name\":\"BabZip\"" ) ) );

  }

}
