package org.hillel.springdatahw.exeption;

public class NoSuchOrderException extends RuntimeException {

  public NoSuchOrderException(String message) {
    super(message);
  }
}
