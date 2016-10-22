package zemian.spring.tinywebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zemian on 10/22/16.
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "/WEB-INF/jsp/index.jsp";
    }

    @RequestMapping("/hello")
    public String hello(HttpServletRequest req) {
        req.setAttribute("name", "World!");
        return "/WEB-INF/jsp/hello.jsp";
    }
}
