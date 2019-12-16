package org.launchcode.hellospringtwo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloControllerTwo {
  @RequestMapping(value = "helloNameTwo", method = {RequestMethod.GET, RequestMethod.POST})
  public String helloWithQueryParam(@RequestParam String aName, Model model){
    String theGreeting = "Hello " + aName + "!";
    model.addAttribute("greeting", theGreeting); // first parameter attributeName: "greeting" matches html attribute inside tag ${greeting}
                                                              // second parameter attributeValue: theGreeting is the variable that appears on the page
    return "hello"; // return the name of the template
  }

  // @PathVariable Handles requests formatted as localhost:8080/hello/helloName/name
  @GetMapping("helloName/{name}")
  public String helloWithPathParam(@PathVariable String name, Model model){
    model.addAttribute("greeting", "Hello " +  name + "!"); // attributeValue: can also be typed in directly
    return "hello";
  }


  // lives at /hello/formThyme
  @GetMapping("formThymeTwo")
  // @ResponseBody not needed when using templates
  public String helloFormThyme(){
    return "form";  // return the name of the template, extension not needed, Thymeleaf knows it's a template
  }
  @GetMapping("hello-names")
  public String helloNames(Model cheese){
    List<String> names = new ArrayList<>();
    names.add("Jo");
    names.add("Mo");
    names.add("Bo");

    cheese.addAttribute("names", names);
    return "hello-list";
  }

}