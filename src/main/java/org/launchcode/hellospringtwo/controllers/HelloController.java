package org.launchcode.hellospringtwo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
/*
 For every GET request made to the provided path, the controller method will be called.
 The path is defined with @GetMapping("pathname").
 If the pathname value is null, then the path used is the index path, or /.
*/

  // Handles request at path /hello
  @GetMapping("hello")
  @ResponseBody
  public String hello(){
    return "Hello, Spring!";
  }

  // Handles request at path /goodbye
  @GetMapping("goodbye")
  @ResponseBody
  public String goodbye(){
    return "Goodbye, Spring!";
  }
}
