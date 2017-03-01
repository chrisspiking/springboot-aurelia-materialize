package uk.co.bitstyle.sbam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Main controller rgistering handlers for index and then default any other html file name.
 *
 * @author cspiking
 */
@Controller
public class Main {

    @RequestMapping(value={"/", "index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/src/{htmlFileName}.html")
    public String staticFileSupport(@PathVariable String htmlFileName) {
        return htmlFileName;
    }

}
