package com.example.spring02.controller.shop;

import java.io.File;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.shop.dto.ProductDTO;
import com.example.spring02.service.shop.ProductService;

@Controller
@RequestMapping("shop/product/*")//공통 url
public class ProductController {

	@Inject
	ProductService productService;

	@RequestMapping("list.do")//세부 rul
	public ModelAndView list(ModelAndView mav) {
		//포워딩할 뷰
		mav.setViewName("/shop/product_list");
		//전달할 데이터
		mav.addObject("list", productService.listProduct());
		return mav;
	}

	//RESTful한 uri
	@RequestMapping("detail/{product_id}")
	public ModelAndView detail(@PathVariable int product_id, ModelAndView mav) {
		//포워딩
		mav.setViewName("/shop/product_detail");
		//데이터
		mav.addObject("dto", productService.detailProduct(product_id));
		return mav;
	}

	//상품등록
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute ProductDTO dto) {
		String filename="-";
		//첨부 파일이 있으면
		if(!dto.getFile1().isEmpty()) {
			//첨부 파일의 이름
			filename=dto.getFile1().getOriginalFilename();
			try {
				//배포디렉토리
				//디렉토리 구분자 : 윈도우즈는 \, 유닉스(리눅스) /
				//" "안에다 \를 쓰면 특수문자로 알아듣기 때문에 \를 하나 더 써야함.
				String path="C:\\work\\.metadata\\.plugins\\org.eclipse.wst.server.core"
						+ "\\tmp0\\wtpwebapps\\spring02\\resouces\\images\\";
				//디렉토리가 존재하지 않으면 생성
				new File(path).mkdir();
				//임시 디렉토리에 저장된 첨부파일을 이동
				dto.getFile1().transferTo(new File(path+filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//if
		dto.setPicture_url(filename);
		productService.insertProduct(dto);//F4
		return "redirect:/shop/product/list.do";
	}

	// edit/6 => edit/{6}
	@RequestMapping("edit/{product_id}")
	public ModelAndView edit(@PathVariable("product_id") int product_id,
			ModelAndView mav) {
		mav.setViewName("shop/product_edit");//뷰
		mav.addObject("dto", productService.detailProduct(product_id));//전달할 데이터
		return mav;
	}

	//상품정보 수정
	@RequestMapping("update.do")
	public String updae(ProductDTO dto) {
		String filename="-";
		//첨부 파일이 있으면
		if(!dto.getFile1().isEmpty()) {
			//첨부 파일의 이름
			filename=dto.getFile1().getOriginalFilename();
			try {
				//배포디렉토리
				//디렉토리 구분자 : 윈도우즈는 \, 유닉스(리눅스) /
				//" "안에다 \를 쓰면 특수문자로 알아듣기 때문에 \를 하나 더 써야함.
				String path="C:\\work\\.metadata\\.plugins\\org.eclipse.wst.server.core"
						+ "\\tmp0\\wtpwebapps\\spring02\\resouces\\images\\";
				//디렉토리가 존재하지 않으면 생성
				new File(path).mkdir();
				//임시 디렉토리에 저장된 첨부파일을 이동
				dto.getFile1().transferTo(new File(path+filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
			dto.setPicture_url(filename);
		}else {//새로운 첨부 파일이 없을 때
			//기존에 첨부한 파일 정보를 가져와야함
			ProductDTO dto2=productService.detailProduct(dto.getProduct_id());
			dto.setPicture_url(dto2.getPicture_url());

		}
		//상품정보 수정
		productService.updateProduct(dto);
		return "redirect:/shop/product/list.do";
	}

	@RequestMapping("delete.do")
	public String delete(@RequestParam int product_id) {
		//첨부파일 삭제
		String filename=productService.fileInfo(product_id);//F4
		System.out.println("첨부파일 이름 : "+filename);
		if(filename != null && !filename.equals("-")) {//파일이 있으면
			String path="C:\\work\\.metadata\\.plugins\\org.eclipse.wst.server.core"
					+ "\\tmp0\\wtpwebapps\\spring02\\resouces\\images\\";
			File f=new File(path+filename);
			System.out.println("파일존재여부 : " + f.exists());
			if(f.exists()) {//파일이 존재하면
				f.delete();//파일 목록 삭제
				System.out.println("삭제되었습니다.");
			}
		}
		//레코드 삭제
		productService.deleteProduct(product_id);//F4
		//화면 이동
		return "redirect:/shop/product/list.do";
	}

}
