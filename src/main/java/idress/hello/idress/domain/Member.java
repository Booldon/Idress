package idress.hello.idress.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String memberId;
    private String password;
    private String name;

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
