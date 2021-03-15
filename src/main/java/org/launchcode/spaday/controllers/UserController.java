// 1) this file creation

package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller // 2) Add the @Controller annotation, along with @RequestMapping("user") to configure routes into the controller.
@RequestMapping("user")  // 3) auto ad code import RequestMapping and stereotype.Controller functionality
public class UserController {
    // 5) Rendering the Add User Form - create a handler method displayAddUserForm() to render the form.
    @GetMapping("add")      //5a
    public String displayAddUserForm() {  //5b
        return "/user/add"; //5c adds up the two path values above user and add
    }

    //  7) processAddUserForm copied from textbook
    @PostMapping
    // 7) text book trap -- left PostMapping out - will not display without it -- NB visit browser network inspector
    // check the form at http://localhost:8080/user/add
    public String processAddUserForm(Model model, @ModelAttribute User user, String verifyPassword) {
        // 7a add form submission handling code here
        // 7a-1 validate password match -- if match: render user/index.html, if not: render form again.
        // check equality of two user input password strings
        if (verifyPassword.equals(user.getPassword())) {
            //13.2 once a user is created via processAddUserForm() it still needs to be added to the UserData list
            //     step 14 will start with adding a file called detail.html in the resources/templates/user dir
            UserData.addUser(user);
            //if the answer is true: return "/user/index"
            //pass welcome text to the index template?   "view template with a message that welcomes the user by username.(terribly written)"
            model.addAttribute("user", user); // add all the user information to the index template
            //13.1 use model attribute UserData.getAll() to send the list of users to index.html ie return a list
            model.addAttribute("users", UserData.getAll());
            //  return "/user/index";  //lead "/" is auto added by thymeleaf
            return "user/index";
        } else {
            //  8
            model.addAttribute("user", user);
            //  9 create an attribute named "error". n.b. textbook described this as "add an error attribute name"
            //  then go to the add.html file and import the attribute before the add.html form with a th: block and th:if statement.
            model.addAttribute("error", "passwords do not match");
            //  10 after the password mismatch auto populate name & email fields with original user entries
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            //7a-1 if the answer is false redirect to:
            return "user/add";
        }
        // return ""; -- this original return copied from textbook no longer needed
    }


    //   13.3 set up a @GetMapping to link to details.html and provide the username and email-->
    @GetMapping("details/{userId}") // n.b. user as in user/detail is not needed in path because it is above, line 15
    public String displayUser(@PathVariable int userId){ //n.b. userId on this line is a match to userId one line above
            // 1. call to data layer
            User user = UserData.getById(userId);
            // 2. call to model
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            return "user/detail";
        }
}

