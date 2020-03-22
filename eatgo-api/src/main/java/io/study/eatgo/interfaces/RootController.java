package io.study.eatgo.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

  @GetMapping( "/" )
  public String getRoot() {
    return "Hello world!";
  }

}
