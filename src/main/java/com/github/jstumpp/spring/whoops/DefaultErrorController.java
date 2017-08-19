package com.github.jstumpp.spring.whoops;

import com.mitchellbosecke.pebble.error.PebbleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class DefaultErrorController implements ErrorController {

    private static final String PATH = "/error";
    @Autowired
    private ErrorAttributes errorAttributes;

    private Whoops whoops = new Whoops();

    @RequestMapping(value = PATH)
    public String error(HttpServletRequest request, HttpServletResponse response) throws IOException, PebbleException {
        return whoops.prettyPage(errorAttributes, request, response);
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}