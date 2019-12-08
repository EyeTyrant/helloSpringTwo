package org.launchcode.hellospringtwo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody

public class HelloControllerExercise {

  @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "getName")
  public String getName(@RequestParam(defaultValue = "Jo Shmo") String name,
                        @RequestParam(defaultValue = "en") String lang){

    if ("fr".equals(lang)){
      return "<h1 style=\"text-align: center;color: red\">Bonj " + name + "!</h1>";
    } else if ("de".equals(lang)){
      return "<h1 style=\"text-align: center;color: gold\">Hallo " + name + "!</h1>";
    } else if ("sp".equals(lang)){
      return "<h1 style=\"text-align: center;color: orange\">Hola " + name + "!</h1>";
    } else if ("itl".equals(lang)){
      return "<h1 style=\"text-align: center;color: green\">Ciao " + name + "!</h1>";
    } else {
      return "<h1 style=\"text-align: center;color blue\">Hiya " + name + "!</h1>";
    }
  }

  @GetMapping("hiyaForm")
  public String hiyaForm(){
  return
      "<html>" +
        "<body>" +
          "<form action='getName' method='post'>" +
            "<input type='text' name='name'>" +
            "<select name='lang'>" +
              "<option value='en'>English</option>" +
              "<option value='fr'>French</option>" +
              "<option value='de'>German</option>" +
              "<option value='sp'>Spanish</option>" +
              "<option value='itl'>Italian</option>" +
            "</select>" +
            "<input type='submit' value='Greetings'>" +
          "</form>" +
        "</body>" +
      "</html>";
  }
}
