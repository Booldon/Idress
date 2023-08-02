package idress.hello.idress.controller;

import idress.hello.idress.controller.form.LoginForm;
import idress.hello.idress.controller.form.SignUpForm;
import idress.hello.idress.domain.Member;
import idress.hello.idress.domain.SessionConst;
import idress.hello.idress.service.LoginService;
import idress.hello.idress.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final LoginService loginService;
    private final MemberService memberService;
    @GetMapping("/login")
    public String login(@ModelAttribute LoginForm loginForm) {
        return "member/login";
    }
    @PostMapping("/login")
    public String loginId(@Valid LoginForm form, BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {
            return "member/login";
        }


        Member loginMember = loginService.login(form);
        /*
        * 로그인 성공 처리
        * */
        //세션이 있으면 있는 세션 변환, 없으면 신규 세션을 생성
        HttpSession session = request.getSession();
        //세션에 로그인 회원 정보 보관
        session.setAttribute(SessionConst.LOGIN_MEMBER,loginMember);

        return "redirect:/";
    }

    @GetMapping("/signUp")
    public String signUpForm(@ModelAttribute SignUpForm signUpForm) {
        return "member/signUpForm";
    }

    @PostMapping("/signUp")
    public String signUp(@Valid SignUpForm form, BindingResult result) {

        if(result.hasErrors()) {
            return "member/signUpForm";
        }

        Member member = new Member();
        member.setMemberId(form.getMemberId());
        member.setName(form.getName());
        member.setPassword(form.getPassword());

        memberService.join(member);
        return "redirect:/login";

    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

    @GetMapping("/session-info")
    public String sessionInfo(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session == null) {
            log.info("no session");
            return "redirect:/";
        }

        session.getAttributeNames().asIterator()
                .forEachRemaining(name -> log.info("session name = {}, value = {}", name, session.getAttribute(name)));

        log.info("sessionId = {}", session.getId());
        log.info("getMaxInactiveInterval = {}", session.getMaxInactiveInterval());
        log.info("creationTime = {}", new Date(session.getCreationTime()));
        log.info("lastAccessedTime = {}", new Date(session.getLastAccessedTime()));
        log.info("isNew = {}", session.isNew());

        return "redirect:/";
    }

}
