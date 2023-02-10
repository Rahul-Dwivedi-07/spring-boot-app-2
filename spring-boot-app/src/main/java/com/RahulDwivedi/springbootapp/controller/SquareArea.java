package com.RahulDwivedi.springbootapp.controller;

import com.RahulDwivedi.springbootapp.model.Square;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SquareArea {

    public Square square(){
        Square square = new Square();
        square.setSide(10);
        return square;
    }
    @GetMapping("area/{s}")
    public int area(@PathVariable int s){
        return s*s;
    }

}
