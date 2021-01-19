package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping(value = "/phone")
public class PhoneController {

	// (메소드 단위로 기능을 정의)

	// 피드
	// 생성자
	// 메소드 g/s

	/** 메소드 일반**메소드 마다 기능 1개씩 ->기능마다 url부여 **/

	// 리스트
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {

		System.out.println("list");
		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> personList = phoneDao.getPersonList();

		// model --> data 를 보내는 방법-->담아놓으면 된다
		model.addAttribute("pList", personList);

		System.out.println(personList.toString());

		return "/WEB-INF/views/List.jsp"; // 포워드시킴
	}

	// 등록폼
	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {

		System.out.println("writeForm");

		return "/WEB-INF/views/WriteForm.jsp";
	}

	// 등록
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@RequestParam("name") String name, @RequestParam("hp") String hp,
			@RequestParam("company") String company) {
		System.out.println("write");
		System.out.println(name + "," + hp + "," + company);

		PersonVo pvo = new PersonVo(name, hp, company);
		System.out.println(pvo.toString());

		PhoneDao pdao = new PhoneDao();
		pdao.personInsert(pvo);
		return "redirect:/phone/list";

	}

	// 삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("id") int id) {
		System.out.println("delete");

		PhoneDao pdao = new PhoneDao();
		pdao.PersonDelete(id);

		return "redirect:/phone/list";

	}

	// 수정폼
	@RequestMapping(value = "/modifyForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@RequestParam("id") int id, Model model) {

		System.out.println("modifyForm");

		PhoneDao pdao = new PhoneDao();
		PersonVo pvo = pdao.getPerson(id);

		model.addAttribute("pvo", pvo);
		System.out.println(pvo);

		return "/WEB-INF/views/modifyForm.jsp";
	}

	// 수정
	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("hp") String hp, @RequestParam("company") String company) {
		System.out.println("modify");
		
		PersonVo pvo = new PersonVo(id, name, hp, company);
		PhoneDao pdao = new PhoneDao();
		
		pdao.personUpdate(pvo);
		
		return "redirect:/phone/list";

	}

}
