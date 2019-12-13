package org.launchcode.hellospringtwo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@ResponseBody // can be placed before the class if every method in the class will have a @ResponseBody
@RequestMapping("hello") /* makes /hello root in path for all methods in the class when @RequestMapping is placed before the class
                            @RequestMapping can be used on the class.
                            @GetMapping and @PostMapping cannot be applied at the class level. */

public class HelloController {
/*
 For every GET request made to the provided path, the controller method will be called.
 The path is defined with @GetMapping("pathname").
 If the pathname value is null, then the path used is the index path, or /.
*/

  // Handles request at path /hello/hello
  @GetMapping("hello")
  public String hello(){
    return "Hello, Spring!";
  }

  // Handles request at path /hello/goodbye
  @GetMapping("goodbye")
  public String goodbye(){
    return "Goodbye, Spring!";
  }

  // @RequestMapping can handle more than one method i.e. GET and POST at the same path
  // @RequestParam Handles request formatted as localhost:8080/hello/helloName?aName=aName
  @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "helloName")
  @ResponseBody
  public String helloWithQueryParam(@RequestParam String aName){
    return "Hello " + aName + "!";
  }

  // @PathVariable Handles requests formatted as localhost:8080/hello/helloName/name
  @GetMapping("helloName/{name}")
  public String helloWithPathParam(@PathVariable String name){
    return "Hello " +  name + "!";
  }
/*
  Also know that you can redirect a user by removing the @ResponseBody annotation
  from the controller and returning "redirect:/DESIREDPATH".
*/

  // lives at /hello/form
  @GetMapping("form")
  @ResponseBody
  public String helloForm(){
    return
      "<html>" +
        "<body>" +
          "<form action='helloName' method='post'>" +  // submit a request to /hello/helloName method
            "<input type='text' name='aName'>" +  // 'aName' is the argument that matches the required parameter passed to helloName method
            "<input type='submit' value='Greet me!'>" +
          "</form>" +
        "</body>" +
      "</html>";
  }
  
  
  // lives at /hello/formThyme
  @GetMapping("formThyme")
  // @ResponseBody not needed when using templates
  public String helloFormThyme(){
    return "form";  // return the name of the template, extension not needed, Thymeleaf knows it's a template
  }

}