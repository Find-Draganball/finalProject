package com.example.spring02.model.admin;

import com.example.spring02.model.member.dto.MemberDTO;

public interface AdminDAO {
	//따로 AdminDTO를 만들지 않고 멤버변수이름이 똑같은 만큼 MemberDTO를 재활용한다.
	public String loginCheck(MemberDTO dto);

}
