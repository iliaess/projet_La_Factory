package factory.repository;

import factory.entity.Matiere;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Long> {
	Optional<Matiere> findByTitre(String titre);

}