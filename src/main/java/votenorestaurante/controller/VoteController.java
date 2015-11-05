package votenorestaurante.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/protected/vote")
public class VoteController {
    @RequestMapping(method = RequestMethod.GET)
    public String welcome() {
            return "vote";
    }
}
