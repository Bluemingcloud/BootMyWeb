package com.coding404.myweb.util;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data 
public class PageVO {

    // 화면에 그려질 pageNation을 계산하는 클래스
    private int start; // 시작 페이지 번호
    private int end; // 마지막 페이지 번호
    private boolean prev; // 이전 버튼 활성화
    private boolean next; // 다음 버튼 활성화

    private int page; // 현재 조회하는 페이지 번호 <-- cri
    private int amount; // 현재 조회하는 데이터 개수 <-- cri

    private int total; // 전체 게시글 수
    private int realEnd; // 맨 마지막 페이지에 도달했을 때, 다시 계산하는 실제 끝 번호

    private Criteria cri;
    private List<Integer> pageList; // 페이지 네이션 번호를 list 로 생성

    private int pageSize = 5; // 페이지네이션 크기

    // 생성자 - 생성될 때 creteria 객체, 전체 게시글 수를 받습니다.
    public PageVO(Criteria cri, int total) {
        this.page = cri.getPage();
        this.amount = cri.getAmount();
        this.cri = cri;
        this.total = total;

        // 끝 페이지 번호 계산
        // 끝페이지 = 올림(현재조회하는 페이지 / 페이지네이션 개수) * 페이지네이션 개수
        this.end = (int)Math.ceil(this.page / (double)this.pageSize) * this.pageSize;

        // 시작 페이지 번호 계산
        this.start = end - this.pageSize + 1;

        // 실제 끝 번호 재 계산
        // 실제끝번호 = 올림(총 게시물 개수 / 조회하는 데이터수)
        this.realEnd = (int)Math.ceil(total / (double)this.amount);
        this.end = Math.min(end, realEnd);

        // prev, next 버튼 활성화
        this.prev = this.start > 1;
        this.next = this.end < this.realEnd;

        // 페이지네이션 생성
        this.pageList = IntStream.rangeClosed(this.start, this.end).boxed().collect(Collectors.toList());

    }
}
