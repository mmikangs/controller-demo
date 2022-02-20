package dev.mkready.controllerdemo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class SampleController {
    //하나의 클래스 안에 로거를 만든다고 하면 저렇게 한다.
    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    //request mapping 을 사용
    //spring boot을 사용하면서 어떠한 경로에 어떠한 함수가 들어갈지 결정할 때 : Requestmapping

    @RequestMapping(
            //url에서 경로 설정하는 값이 들어가는 부분을 value
            value = "hello",//요청의 url 의 path 로
            method = RequestMethod.GET //http request method에서 get
            //브라우저에서 주소를 넣으면서 새로운 페이지를 가져오는 것은 기본적으로 GET
    )
    //반환 타입을 string으로 함.
    //requestparam을 사용하게 되면, url에서 query parameter의 내용을 가져오는데 사용할 수 있음.
    public String hello(@RequestParam(name = "id", required = false, defaultValue = "") String id){
        logger.info("path : hello , query param id : " + id);
        return "/hello.html";
    }

    //method가 get으로 고정되어있는 것 !
    @GetMapping(
        value = "/hello/{id}"
    )

    public String helloPath(@PathVariable("id") String id){
        logger.info("path variable is : " + id);
        return "/hello.html";
    }

    @GetMapping(
            "/get-profile"
    )

    //view를 찾는게 아니라 data 자체를 responsebody로 !! @responsebody
    public @ResponseBody SamplePayload getProfile(){
        logger.info("hiready");
        return new SamplePayload("mkready", 10, "developer");
    }


}
