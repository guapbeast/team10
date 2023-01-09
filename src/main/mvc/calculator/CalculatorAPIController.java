package com.nighthawk.spring_portfolio.mvc.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorAPIController {

    @GetMapping("/{expression}")
    public ResponseEntity<String> getResult(@PathVariable String expression) {
        try {
        Calculator a = new Calculator(expression);
        String result = a.toString();
        if (result != null) {
            return new ResponseEntity<String>(result, HttpStatus.OK);
        }} catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);       
    }

}