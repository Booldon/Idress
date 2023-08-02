package idress.hello.idress.controller;

import idress.hello.idress.domain.Member;
import idress.hello.idress.domain.SessionConst;
import idress.hello.idress.domain.data.Data;
import idress.hello.idress.exception.NoLoginException;
import idress.hello.idress.service.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@Slf4j
@RequiredArgsConstructor
public class IdressController {

    private final DataService dataService;

    @GetMapping("/idress")
    public String idress(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member member, Model model){


        if(member == null) {
            throw new NoLoginException("Need Login");
        }

        model.addAttribute("member",member);

        return "business/idress";
    }

    @GetMapping("/idress/{area}")
    public String seoul(@PathVariable("area") String area, Model model){
        Data data = dataService.findOne(area);
        model.addAttribute("data",data);

        return "business/view";
    }
}
