package hello.hellospring.controller;

import hello.hellospring.MemberService;
import hello.hellospring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/miniproject")
@Controller
public class WebController {

    private final MemberService memberService;

    //MemberController 가 생성될때 MemberService 타입의 memberService가 들어감.
    @Autowired
    //@Autowired를 이용하면 memberService를 연결시켜준다.
    public WebController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/best")
    public String best() {
        return "best";
    }

    @GetMapping("/best2")
    public String best2() {
        return "best2";
    }

    @GetMapping("/complit")
    public String complit() {
        return "complit";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/rentbook")
    public String rentbook() {
        return "rentbook";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }

    @PostMapping(value = "/signin")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        member.setId(form.getId());
        member.setPw(form.getPw());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
