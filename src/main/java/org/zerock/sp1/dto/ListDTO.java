package org.zerock.sp1.dto;


import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@ToString
@Getter
@Log4j2
public class ListDTO {

    //t tx tcw
    private int page;
    private int size;
    private String type;
    private String keyword;
    private String link;

    public ListDTO(){
        this.page = 1;
        this.size =10;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String[] getTypes(){
        if(type == null || type.trim().length() == 0)
            return new String[]{};

        return type.split("");
    }

    public String getKeyword(){
        return keyword == null || keyword.trim().length() == 0 ? null : keyword.trim();
    }

    //setter 유효성 검사
    public void setPage(int page) {
        this.page = page <= 0 ? 1 : page;
    }
    public void setSize(int size) {
        this.size = size < 10 ? 10 : size;
    }
    public int getSkip(){
        return (this.page - 1) * size;
    }

    // null 일 때 아닐 때
    public String getLink(){
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
        builder.queryParam("page" , getPage())
                .queryParam("size",getSize())
                .queryParam("type",getType())
                .queryParam("keyword",getKeyword());

//        if(type !=null ){
//            builder.queryParam("type",type);
//        }
//        if(keyword != null){
//            try {
//                String enStr = URLEncoder.encode("세종 대왕 만세","UTF-8" );
//                builder.queryParam("keyword",enStr);
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//
//        }

        return builder.build().toString();
    }
}
