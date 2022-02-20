package dev.mkready.controllerdemo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/rest") //prefix mapping을 사용..
public class SampleRestController {
    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @GetMapping("/sample-payload")
     public SamplePayload samplePayload(){
        logger.info("hiyoyo");
        return new SamplePayload("mkready22", 1022, "developer22");
        //return new SamplePayload("mkready", 10, "developer");

    }

    @GetMapping(
            value ="/sample-image",
            produces = MediaType.IMAGE_PNG_VALUE
    )

    public byte[] sampleImage() throws IOException{
        InputStream inputStream = getClass().getResourceAsStream("/static/img.png");
       // inputStream = new FileInputStream(new File(""));

        return inputStream.readAllBytes();
    }
}
