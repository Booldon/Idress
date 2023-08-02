package idress.hello.idress.controller;

import idress.hello.idress.domain.Member;
import idress.hello.idress.domain.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@Slf4j
public class HomeController {

    @RequestMapping("/")
    public String home(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)Member member, Model model) {

        if(member == null) {
            log.info("home controller");
            return "home";
        }

        model.addAttribute("member",member);

        return "logoutHome";
    }
}
