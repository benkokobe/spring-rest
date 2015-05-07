package com.bko.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bko.domain.Member;

@Controller
public class MemberController {
	@RequestMapping(value="/member/{name}", method = RequestMethod.GET)
    public String getMember(@PathVariable String name, ModelMap model) {
  
        Member member = new Member();
        member.setName(name);
        member.setEmail("ben@gmail.com");
        model.addAttribute("member", member);  
        return "member";
  
    }

}
