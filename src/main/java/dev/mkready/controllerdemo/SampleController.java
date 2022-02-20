package dev.mkready.controllerdemo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("view")
public class SampleController {

    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @GetMapping("/sample-jsp")
    public String sampleJsp(Model model){

        logger.info("in sample jsp");
        List<SamplePayload> profiles = new ArrayList<>();
        profiles.add(new SamplePayload("DESK", 20, "STUDENT"));
        profiles.add(new SamplePayload("SON", 21, "NURSE"));
        profiles.add(new SamplePayload("KANE", 22, "SOCCER PLAYER"));

        logger.info("check : " + profiles);
        model.addAttribute("profiles", profiles);

        return "view_jsp";
    }
}
