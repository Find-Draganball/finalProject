package com.example.spring02.controller.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.board.dto.ReplyDTO;
import com.example.spring02.service.board.ReplyService;

//@ResponseBody를 메소드에 쓰는 방법
@RestController // spring4.0부터 사용 가능
@RequestMapping("reply/*")
public class ReplyController {
	
	@Inject
	ReplyService replyService;
	
	@RequestMapping("insert.do")
	public void insert(ReplyDTO dto, HttpSession session) {
		//세션 아이디
		String userid=(String)session.getAttribute("userid");
		dto.setReplyer(userid);
		//댓글 테이블에 저장
		replyService.create(dto);
		//Ajax로 값만넘기고 끝나기 때문에 jsp 페이지로 포워딩하거나 데이터를 리턴하지 않음
	}
	
	@RequestMapping("list.do")
	public ModelAndView list(int bno, ModelAndView mav) {
		List<ReplyDTO> list=replyService.list(bno);//댓글 목록
		mav.setViewName("board/reply_list");//뷰로 포워딩
		mav.addObject("list", list);//뷰에 전달할 데이터
		return mav;
	}
	
	@RequestMapping("list_json.do")
	public List<ReplyDTO> list_json(int bno){
		return replyService.list(bno);
	}
	
	

}
