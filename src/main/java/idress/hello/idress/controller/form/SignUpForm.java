package idress.hello.idress.controller.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class SignUpForm {

    @NotEmpty(message = "이름을 입력해 주세요.")
    private String name;

    @NotEmpty(message = "ID를 입력해 주세요.")
    private String memberId;

    @NotEmpty(message = "비밀번호를 입력해 주세요.")
    private String password;


}
