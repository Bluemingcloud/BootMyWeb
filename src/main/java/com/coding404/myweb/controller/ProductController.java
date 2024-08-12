package com.coding404.myweb.controller;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.product.ProductService;
import com.coding404.myweb.util.Criteria;
import com.coding404.myweb.util.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    @Qualifier("productService")
    private ProductService productService;

//    // 목록
//    @GetMapping("/productList")
//    public String productList(Model model, Criteria cri) {
//        // 현재 로그인되어있는 사람 아이디가 admin 이라고 가정
//        String userId = "admin";
//
//        List<ProductVO> list = productService.getList(userId, cri);
//        model.addAttribute("list", list);
//
//        // PageVO
//        int total = productService.getTotal(userId); // 전체 게시글 수
//        PageVO pageVO = new PageVO(cri, total); // 페이지네이션
//        model.addAttribute("pageVO", pageVO);
//
//        return "product/productList";
//    }

    // step1. criteria 같은 객체에 검색 키워드 추가
    // step2. 목록 sql, 전체개수 sql 모두 동적쿼리로 변경
    // step3. 화면에서 사용자가 검색버튼을 누를때, 다시 page번호를 1번, amount 를 10으로
    // step4. 검색값의 유지
    // step5. 페이지네이션을 누를때, 검색 키워드를 같이 넘겨줘야 함
    @GetMapping("/productList")
    public String productList(Model model, Criteria cri) {
        // 현재 로그인되어있는 사람 아이디가 admin 이라고 가정
        String userId = "admin";

        List<ProductVO> list = productService.getList(userId, cri);
        model.addAttribute("list", list);

        // PageVO
        int total = productService.getTotal(userId, cri); // 전체 게시글 수
        PageVO pageVO = new PageVO(cri, total); // 페이지네이션
        model.addAttribute("pageVO", pageVO);

        return "product/productList";
    }

    // 상세
    @GetMapping("/productDetail")
    public String productDetail(@RequestParam("prodId") int prodId, Model model) {
        ProductVO vo = productService.getDetail(prodId);
        model.addAttribute("vo", vo);
        return "product/productDetail";
    }
    // 등록
    @GetMapping("/productReg")
    public String productReg() {
        return "product/productReg";
    }
    // 등록요청처리
    @PostMapping("/registForm")
    public String registForm(ProductVO vo, RedirectAttributes ra) {
        // 서버측 유효성 검사 진행 가능
        int result = productService.productInsert(vo);

        if(result == 1) {
            ra.addFlashAttribute("msg", "정상 등록되었습니다.");
        } else {
            ra.addFlashAttribute("msg", "등록에 실패했습니다.");
        }

        return "redirect:/product/productList";
    }
    // 상품 수정기능
    @PostMapping("/productUpdate")
    public String productUpdate(ProductVO vo, RedirectAttributes ra) {

        int result = productService.productUpdate(vo);

        if(result == 1) {
            ra.addFlashAttribute("msg", "수정되었습니다.");
        } else {
            ra.addFlashAttribute("msg", "수정에 실패했습니다.");
        }

        return "redirect:/product/productDetail?prodId=" + vo.getProdId();
    }
    // 상품 삭제기능
    @PostMapping("/productDelete")
    public String productDelete(int prodId, RedirectAttributes ra) {
        int result = productService.productDelete(prodId);
        if(result == 1) {
            ra.addFlashAttribute("msg", "삭제되었습니다.");
        } else {
            ra.addFlashAttribute("msg", "삭제에 실패했습니다.");
            return "redirect:/product/productDetail?prodId=" + prodId;
        }
        return "redirect:/product/productList";
    }

}
