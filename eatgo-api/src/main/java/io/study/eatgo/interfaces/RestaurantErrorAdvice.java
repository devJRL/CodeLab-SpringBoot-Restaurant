package io.study.eatgo.interfaces;

import io.study.eatgo.domain.RestaurantNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestaurantErrorAdvice {

  @ResponseStatus( HttpStatus.NOT_FOUND ) // 404
  @ResponseBody
  @ExceptionHandler( RestaurantNotFoundException.class )
  public String handelNotFound() {

    return "{}";
  }

}
