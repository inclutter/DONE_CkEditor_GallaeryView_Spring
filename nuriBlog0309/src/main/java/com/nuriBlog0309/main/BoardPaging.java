package com.nuriBlog0309.main;

public class BoardPaging {
    private int startPageNo; // 시작 페이지 번호
    private int endPageNo; // 마지막 페이지
    private int countRecord; // 전체 레코드 갯수
    private int countPage; // 전체 페이지 갯수
    private int pageSize; // 한 페이지에 보여지는 레코드 갯수
    private int currentPageNo; // 현재 페이지 번호
    private int pageBlock;


    public BoardPaging(int countRecord, int currentPageNo, int number){
        int pageSize;
        if(number == 3) {
        	pageSize=12;
        }else if(number == 4) {
        	pageSize=16;
        }else {
        	pageSize=20;
        }
    	this.pageBlock = 4;
        this.pageSize = pageSize;
        this.countRecord = countRecord;
        this.currentPageNo = currentPageNo;
        //현재 페이지가 6일때 5페이지씩이니까 5로 나눠서 0이 아니면
        if(((int)(this.currentPageNo % 5)) != 0) {
            // 시작 페이지가 6/5=>1*5+1=>6이 된다.
            this.startPageNo = ((int)(this.currentPageNo/5))*5+1;
        } else {
            // 시작 페이지가 2일 경우 2/5 =0
            // 시작 페이지를 1로 설정한다.
            this.startPageNo = ((int)(this.currentPageNo/5))*5+1;
        }
        this.endPageNo = this.startPageNo + this.pageBlock;
        this.countPage = (this.countRecord + (this.pageSize -1)) / this.pageSize;
    }


    public int getStartPageNo() {
        return startPageNo;
    }

    public void setStartPageNo(int startPageNo) {
        this.startPageNo = startPageNo;
    }

    public int getEndPageNo() {
        return endPageNo;
    }

    public void setEndPageNo(int endPageNo) {
        this.endPageNo = endPageNo;
    }

    public int getCountRecord() {
        return countRecord;
    }

    public void setCountRecord(int countRecord) {
        this.countRecord = countRecord;
    }

    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public int getPageBlock() {
        return pageBlock;
    }

    public void setPageBlock(int pageBlock) {
        this.pageBlock = pageBlock;
    }
}
