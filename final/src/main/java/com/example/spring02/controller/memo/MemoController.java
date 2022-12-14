package com.example.spring02.controller.memo;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.memo.dto.MemoDTO;
import com.example.spring02.service.memo.MemoService;

@Controller //스프링에게 컨트롤러 빈으로 등록
@RequestMapping("memo/*")
public class MemoController {
	
	@Inject
	MemoService memoService;
	
	@RequestMapping("list.do")
	public ModelAndView list(ModelAndView mav) {
		List<MemoDTO> items=memoService.list();
		mav.setViewName("memo/memo_list"); //포워딩할 뷰의 이름(View)
		mav.addObject("list", items); //전달할 데이터(Model)
		return mav;
	}
	
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute MemoDTO dto) {
		memoService.insert(dto);//F4
		return "redirect:/memo/list.do";
	}
	
	//RESTful한 uri방식으로 요청이 들어올땐 반드시 @PathVariable을 쓴다.
	@RequestMapping("view/{idx}")
	public ModelAndView view(@PathVariable int idx, ModelAndView mav) {
		//포워딩할 뷰의 이름
		mav.setViewName("memo/view");
		//전달할 데이터
		mav.addObject("dto", memoService.memo_view(idx));
		return mav;
	}
	
	@RequestMapping("update/{idx}")
	public String update(@PathVariable int idx, @ModelAttribute MemoDTO dto) {
		//메모 수정
		memoService.update(dto);
		//수정완료 후 목록으로 이동
		return "redirect:/memo/list.do";
	}
	
	@RequestMapping("delete/{idx}")
	public String delete(@PathVariable int idx) {
		//레코드 삭제 처리
		memoService.delete(idx);
		//삭제완료 후 목록으로 이동
		return "redirect:/memo/list.do";
	}
	

}
