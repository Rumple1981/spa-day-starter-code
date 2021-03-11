// 1) this file creation

package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 2) Add the @Controller annotation, along with @RequestMapping("user") to configure routes into the controller.
@RequestMapping("user")  // 3) auto ad code import RequestMapping and stereotype.Controller functionality
public class UserController {
//    5) Rendering the Add User Form - create a handler method displayAddUserForm() to render the form.
    @GetMapping("add")      //5a
    public String displayAddUserForm() {  //5b
        return "/user/add"; //5c adds up the two path values above user and add
    }
//    7) processAddUserForm copied from textbook
    @PostMapping // 7) text book trap -- left PostMapping out - will not display without it -- NB visit browser network inspector
                    // check the form at http://localhost:8080/user/add
    public String processAddUserForm(Model model, @ModelAttribute User user, String verifyPassword) {
        // 7a add form submission handling code here
        // 7a-1 validate password match -- if match: render user/index.html, if not: render form again.
        // check equality of two user input password strings
        if (verifyPassword.equals(user.getPassword())) {
            //if the answer is true: return "/user/index"
            //pass welcome text to the index template?   "view template with a message that welcomes the user by username.(terribly written)"
            model.addAttribute("user", user); // add all the user information to the index template
            return "/user/index";
        } else {
            //if the answer is false
            return "/user/add";
        }
            // return ""; -- this return copied from textbook no longer needed
    }

}
