package com.ll.sb20231114.global.rsData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor  // 모든 필드 값을 파라미터로 받는 생성자가 생성되어 컨트롤러상에서 data 값이 없어서 오류 발생
@RequiredArgsConstructor
@Getter
public class RsData<T> {
    private final String resultCode;
    private final String msg;
    private T data;   // 데이터 값이 스트링일수도 인트일수도 즉 아티클일지 목록일지 모르니까 제너릭스를 사용한다.
}
