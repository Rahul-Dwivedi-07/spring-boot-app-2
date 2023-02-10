package com.RahulDwivedi.springbootapp.controller;

import com.RahulDwivedi.springbootapp.model.Rectangle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RectangleController {

    public Rectangle rectangle(){
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(10);
        rectangle.setBreadth(2);

        return rectangle;
    }
    @GetMapping("rectangle/{l}/{b}")
    public int area(@PathVariable int l, @PathVariable int b){
        return l*b;
    }
}
