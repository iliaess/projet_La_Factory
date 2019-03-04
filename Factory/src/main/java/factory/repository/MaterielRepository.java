package factory.repository;

import factory.entity.Materiel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MaterielRepository extends JpaRepository<Materiel, Long> {

}
