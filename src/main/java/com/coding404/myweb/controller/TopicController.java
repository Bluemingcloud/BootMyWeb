package com.coding404.myweb.controller;

import com.coding404.myweb.command.TopicVO;
import com.coding404.myweb.topic.TopicService;
import com.coding404.myweb.util.Criteria;
import com.coding404.myweb.util.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    @Qualifier("topicService")
    private TopicService topicService;

    @GetMapping("/topicDetail")
    public String topicDetail(@RequestParam("topicId") int topicId, Model model) {
        model.addAttribute("vo", topicService.getDetail(topicId));
        return "topic/topicDetail";
    }

    @GetMapping("/topicListAll")
    public String topicListAll(Model model, Criteria cri) {

        model.addAttribute("list", topicService.getList(cri));

        // PageVO
        int total = topicService.getTotal();
        PageVO pageVO = new PageVO(cri, total);
        model.addAttribute("pageVO", pageVO);

        return "topic/topicListAll";
    }

    @GetMapping("/topicListMe")
    public String topicListMe(Model model, Criteria cri) {
        String topicWriter = "admin";
        model.addAttribute("list", topicService.getListMe(topicWriter, cri));

        // PageVO
        int total = topicService.getTotalMe(topicWriter);
        PageVO pageVO = new PageVO(cri, total);
        model.addAttribute("pageVO", pageVO);

        return "topic/topicListMe";
    }

    @GetMapping("/topicModify")
    public String topicModify(@RequestParam("topicId") int topicId, Model model) {
        model.addAttribute("vo", topicService.getDetail(topicId));
        return "topic/topicModify";
    }

    @PostMapping("/topicUpdate")
    public String topicUpdate(@ModelAttribute("vo") TopicVO vo, RedirectAttributes ra) {
        int result = topicService.topicUpdate(vo);
        if(result == 1) {
            ra.addFlashAttribute("msg", "글이 수정되었습니다.");
        } else {
            ra.addFlashAttribute("msg", "글이 수정되지 않았습니다.");
            return "redirect:/topic/topicModify?topicId=" + vo.getTopicId();
        }
        return "redirect:/topic/topicListMe";
    }

    @PostMapping("/topicDelete")
    public String topicDelete(@ModelAttribute("vo") TopicVO vo, RedirectAttributes ra) {
        int result = topicService.topicDelete(vo.getTopicId());
        if(result == 1) {
            ra.addFlashAttribute("msg", "글이 삭제되었습니다.");
        } else {
            ra.addFlashAttribute("msg", "글이 삭제되지않았습니다.");
            return "redirect:/topic/topicModify?topicId=" + vo.getTopicId();
        }
        return "redirect:/topic/topicListMe";
    }

    @GetMapping("/topicReg")
    public String topicReg() {
        return "topic/topicReg";
    }

    @PostMapping("/registForm")
    public String topicRegForm(@Valid @ModelAttribute("vo") TopicVO vo, RedirectAttributes ra) {
        int result = topicService.topicInsert(vo);
        if(result == 1) {
            ra.addFlashAttribute("msg", "글이 등록 되었습니다.");
        } else {
            ra.addFlashAttribute("msg", "등록에 실패했습니다.");
            return "topic/topicReg";
        }
        return "redirect:/topic/topicListAll";
    }

}
