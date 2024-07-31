package com.example.firstproject.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class SecondController {
    @GetMapping("/random-quote")
    public String randomQuote(Model model) {
        String[] quotes = {
            "가장 작은 것, 가장 조용한 것, 가장 가벼운 것, 바스락거리는 도마뱀 몸짓, 숨결 하나, 휙 하는 소리, 한 순간. 작은 게 최상의 행복을 만든다." +
                    "-니체-",
            "피할수 없으면 즐겨라 " + " -로버트 엘리엇-",
            "자신감 있는 표정을 지으면 자신감이 생긴다." + "-찰스다윈-",
            "사랑은 천국과도 같지만, 지옥처럼 아플 수도 있어요." + "- -"
        };
        int randInt = (int) (Math.random() * quotes.length);
        model.addAttribute("randomQuote", quotes[randInt]);
        return "quote";
    }
}
