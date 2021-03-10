package org.launchcode.spaday.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@Controller
public class SpaDayController {

    public boolean checkSkinType(String skinType, String facialType) {
        if (skinType.equals("oily")) {
            if (facialType.equals("Microdermabrasion") || facialType.equals("Rejuvenating")) {
                return true;
            }
            else {
                return false;
            }
        }
        else if (skinType.equals("combination")) {
            if (facialType.equals("Microdermabrasion") || facialType.equals("Rejuvenating") || facialType.equals("Enzyme Peel")) {
                return true;
            }
            else {
                return false;
            }
        }
        else if (skinType.equals("normal")) {
            return true;
        }
        else if (skinType.equals("dry")) {
            if (facialType.equals("Rejuvenating") || facialType.equals("Hydrofacial")) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return true;
        }
    }

    @GetMapping(value="")
    @ResponseBody
    public String customerForm () {
//      String html = "<form               method = 'post'>" +
        String html = "<form action='menu' method = 'post'>" + // bonus 3
                "Name: <br>" +
                "<input type = 'text' name = 'name'>" +
                "<br>Skin type: <br>" +
                "<select name = 'skintype'>" +
                "<option value = 'oily'>Oily</option>" +
                "<option value = 'combination'>Combination</option>" +
                "<option value = 'normal'>Normal</option>" +
                "<option value = 'dry'>Dry</option>" +
                "</select><br>" +
                "Manicure or Pedicure? <br>" +
                "<select name = 'manipedi'>" +
                "<option value = 'manicure'>Manicure</option>" +
                "<option value = 'pedicure'>Pedicure</option>" +
                "<option value = 'both'>Both</option>" +
                "</select><br>" +
                "<input type = 'submit' value = 'Submit'>" +
                "</form>";
        return html;
    }
//    // bonus 3
    @GetMapping("menu")
    public String redirectToForm() {
        return "redirect:";    // tymeleaf code to go to index.html
    }

//    @PostMapping(value="")
    @PostMapping(value="menu") // bonus 3
    public String spaMenu(@RequestParam String name, @RequestParam String skintype, @RequestParam String manipedi, Model model) {

        //variables creation section -ek
        ArrayList<String> facials = new ArrayList<String>();
        facials.add("Microdermabrasion");
        facials.add("Hydrofacial");
        facials.add("Rejuvenating");
        facials.add("Enzyme Peel");

        //logic section-ek
        ArrayList<String> appropriateFacials = new ArrayList<String>();
        for (int i = 0; i < facials.size(); i ++) {
            if (checkSkinType(skintype,facials.get(i))) {
                appropriateFacials.add(facials.get(i));
            }
        }

        // attribute section-ek
        model.addAttribute("customerName",name);
        model.addAttribute("customerSkinType",skintype);
        model.addAttribute("customerNailType",manipedi);
        model.addAttribute("facialOptions",appropriateFacials);
        return "menu";
    }
}
