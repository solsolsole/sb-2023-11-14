package com.ll.sb20231114.global.rsData;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RsData<T> {
    private String resultCode;
    private String msg;
    private T data;   // 데이터 값이 스트링일수도 인트일수도 즉 아티클일지 목록일지 모르니까 제너릭스를 사용한다.
}
