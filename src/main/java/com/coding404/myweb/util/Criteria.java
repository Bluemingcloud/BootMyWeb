package com.coding404.myweb.util;

import lombok.Data;

@Data // getter, setter, toString, hashAndEquals
public class Criteria {

    // 화면에 전달할 값들을 가지고 다니는 클래스
    private int page; // 현재 조회하는 페이지
    private int amount; // 한 페이지에 보여줄 데이터 개수

    // 검색 키워드
    // product
    private String searchName; // 상품명
    private String searchContent; // 상품내용
    private String searchPrice; // 정렬방식
    private String startDate; // 판매 시작일
    private String endDate; // 판매 종료일

    // topic
    private String searchTitle;
    private String searchWriter;

    public Criteria() {
        this(1, 10);
    }

    public Criteria(int page, int amount) {
        this.page = page;
        this.amount = amount;
    }

    // offset - limit 함수 매개변수 중 앞에 전달될 값
    public int getPageStart() {
        return (page - 1) * amount;
    }

}
