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
      return "Bonj " + name + "!";
    } else if ("de".equals(lang)){
      return "Hallo " + name + "!";
    } else if ("sp".equals(lang)){
      return "Hola " + name + "!";
    } else if ("itl".equals(lang)){
      return "Ciao " + name + "!";
    } else {
      return "Hiya " + name + "!";
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
              "<option value='itl'>Itallian</option>" +
            "</select>" +
            "<input type='submit' value='Greetings'>" +
          "</form>" +
        "</body>" +
      "</html>";
  }
}
