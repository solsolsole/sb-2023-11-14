package com.ll.sb20231114;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
        // 이 함수의 리턴값을 그대로 브라우저에 전송곅!라는 의미
    String showMain() {
        return "안녕하세요.";
    }

    @GetMapping("/about")
    @ResponseBody
    String showAbout() {
        return "개발자 커뮤니티";
    }

    @GetMapping("/calc")
    @ResponseBody
    String showCalc(int a, int b) { // null 값을 넣을 수 없는 정수 기본형
        return "계산 : %d".formatted(a + b);  //  문자열을 형식화하는데 사용. url은 모두 문자형이기 때문에 문자열을 더해주기 위해
    }  // 스프링 부트가 문자열로 받은 숫자를 자동으로 정수화 해서 전달

    @GetMapping("/calc2")
    @ResponseBody
    String showCalc2(Integer a, Integer b) { //null 값을 넣을 수 있는 정수형
        return "a" + a + ",b" + b;   // Integer 에는 %d 사용 x
    }

    @GetMapping("/calc3")
    @ResponseBody
    String showCalc3(
            @RequestParam(defaultValue = "0") int a,  // defaultValue 는 값이 없을때만 작동
            @RequestParam(defaultValue = "0") int b) { //null 값을 넣을 수 있는 정수형
        return "a" + a + ",b" + b;   // Integer 에는 %d 사용 x
    }

    @GetMapping("/calc4")
    @ResponseBody
    String showCalc4(
            @RequestParam(defaultValue = "0") double a,  // 정수와 실수를 받을 수 있음
            @RequestParam(defaultValue = "0") double b) {
        return "계산 : %f".formatted(a + b);
    }

    @GetMapping("/calc5")
    @ResponseBody
    String showCalc5(
            @RequestParam(defaultValue = "0") String a,  // 모든 값을 받을 수 있음
            @RequestParam(defaultValue = "0") String b) {
        return String.format("계산 : %s", a + b);
    }

    @GetMapping("/calc6")
    @ResponseBody
    int showCalc6(
            int a, int b) {
        return a + b;
    }

    @GetMapping("/calc7")
    @ResponseBody
    boolean showCalc7(
            int a, int b) {
        return a > b;
    }

    @GetMapping("/calc8")
    @ResponseBody
    Person showCalc8(
            String name, int age
    ) { // String 은 null 값이 자동으로 들어감
        return new Person(name, age);
    }

    @GetMapping("/calc9")
    @ResponseBody
    Person2 showCalc9(
            String name, int age
    ) { // String 은 null 값이 자동으로 들어감 그래서 값을 지정 안해줘도 오류 발생하지 않음
        return new Person2(name, age);
    }

    @GetMapping("/calc10")
    @ResponseBody
    Map<String, Object> showCalc10(
            String name, int age
    ) { // String 은 null 값이 자동으로 들어감 그래서 값을 지정 안해줘도 오류 발생하지 않음
        Map<String, Object> personMap = Map.of(
                "name", name,
                "age", age
        );

        return personMap;
    }

    @GetMapping("/calc11")
    @ResponseBody
    List<Integer> showCalc11(
            String name, int age
    ) { // String 은 null 값이 자동으로 들어감 그래서 값을 지정 안해줘도 오류 발생하지 않음
        List<Integer> nums = new ArrayList<>() {{
            add(520);
            add(10);
            add(10010);
        }};

        return nums;
    }

    @GetMapping("/calc12")
    @ResponseBody
    List<Person2> showCalc12(
            String name, int age
    ) {
        List<Person2> persons = new ArrayList<>() {{ // 중괄호 하나는 생성자 즉 익명클래스 안에 생성자 있다는 것.
            add(new Person2(name, age));
            add(new Person2(name + "!", age + 1));
            add(new Person2(name + "!!", age + 2));
        }};

        return persons;
    }

    @GetMapping("/calc14")
    @ResponseBody
    String showCalc14() {
        String html = "";

        html += "<div>";
        html += "<input type = \"test\" placeholder = \"내용\">"; // "\"" 역슬래시를 붙여 따옴표가 문법형식으로 쓰인게 아니라는걸 표시  == " 으로 출력됨
        html += "</div>";

        return html;
    }

    @GetMapping("/calc15")
    @ResponseBody
    String showCalc15() {
        StringBuilder sb = new StringBuilder();  // 문자열을 세개네개 붙여야 할때, 문자의 불변성때문에 스트링빌더를 만들어서 사용
        String html = "";

        html += "<div>";
        html += "<input type = \"test\" placeholder = \"내용\">"; // "\"" 역슬래시를 붙여 따옴표가 문법형식으로 쓰인게 아니라는걸 표시  == " 으로 출력됨
        html += "</div>";

        return html;
    }

    @GetMapping("/calc16")
    @ResponseBody
    String showCalc16() {
        StringBuilder sb = new StringBuilder();  // 문자열을 세개네개 붙여야 할때, 문자의 불변성때문에 스트링빌더를 만들어서 사용
        String html = "<div><input type = \"test\" placeholder = \"내용\"></div>";

        return html;
    }

    @GetMapping("/calc17")
    @ResponseBody
    String showCalc17() {
        String html = """
                <div>
                    <input type = \"test\" placeholder = \"내용\">
                </div>
                               """;

        return html;
    }

    @GetMapping("/calc18")
    @ResponseBody
    String showCalc18(@RequestParam(defaultValue = "") String content) {
        // if (content == null) content = ""; 이거랑 디폴트벨류랑 같음.
        String html = """
                <div>
                    <input type = \"test\" placeholder = \"내용\" value = %s">
                </div>
                               """.formatted(content);

        return html;
    }

    @GetMapping("/calc19")
    @ResponseBody
    String showCalc19(@RequestParam(defaultValue = "") String content,
                      @RequestParam(defaultValue = "") String subject) {
        // if (content == null) content = ""; 이거랑 디폴트벨류랑 같음.
        String html = """
                <div>
                    <input type = \"test\" placeholder = \"내용\" value = %s">
                </div>
                <div>
                    <input type = \"test\" placeholder = \"내용\" value = %s">
                </div>
                               """.formatted(subject,content);

        return html;
    }  // 너무 길어지고 관리 힘들어짐으로 안에 내용은 view 에 토스.

    @GetMapping("/calc20")  // ResponseBody 안 붙이면 resources 안에 템플릿 안에 calc20이 시작됨
    String showCalc20(){
        return "calc20";
    }
// html 파일에선 자바 문법 못씀
    @GetMapping("/calc21")
    String showCalc21(Model model){ //여기서 모델이 뭥미?
        model.addAttribute("v1","안녕");
        model.addAttribute("v2","반가워");
        return "calc21";
    }
}

//json은 객체와 맵을 구별하는 능력 없음 동일하게 표현.
//객체의 문자열은 잭슨이 json 방식으로 변환

@AllArgsConstructor // 모든걸 생성자로!
class Person {
    public String name;
    public int age;
}

@AllArgsConstructor
class Person2 {
    @Getter
    private String name;
    @Getter
    private int age;
}