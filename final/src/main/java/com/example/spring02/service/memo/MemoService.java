package com.example.spring02.service.memo;

import java.util.List;

import com.example.spring02.model.memo.dto.MemoDTO;

public interface MemoService {
	
	public List<MemoDTO> list();//목록보기
	public void insert(MemoDTO dto);//insert 기능
	public MemoDTO memo_view(int idx);//상세화면 보기 
	public void update(MemoDTO dto);//수정
	public void delete(int idx);//delete

}
