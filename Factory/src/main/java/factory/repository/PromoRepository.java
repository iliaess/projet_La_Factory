package factory.repository;

import factory.entity.Promo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PromoRepository extends JpaRepository<Promo, Long> {

}