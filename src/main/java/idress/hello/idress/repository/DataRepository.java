package idress.hello.idress.repository;

import idress.hello.idress.domain.data.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DataRepository {
    private final EntityManager em;

    public void save(Data data) {
            em.persist(data);
    }

    public Data find(Long id) {
        return em.find(Data.class, id);
    }

    public Optional<Data> findByDataArea(String area) {
        return em.createQuery("select d from Data d where d.area =: area",Data.class)
                .setParameter("area",area)
                .getResultList().stream().findAny();
    }

}
