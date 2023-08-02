package idress.hello.idress.domain.data;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter @Setter
public class Data {

    @Id
    @GeneratedValue
    Long id;

    String area;

    Double senT;
    String dress;
    String standardTime;
    public Data() {

    }

}
