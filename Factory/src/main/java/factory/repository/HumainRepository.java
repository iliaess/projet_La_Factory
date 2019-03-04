package factory.repository;

import factory.entity.Humain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HumainRepository extends JpaRepository<Humain, Long> {

}