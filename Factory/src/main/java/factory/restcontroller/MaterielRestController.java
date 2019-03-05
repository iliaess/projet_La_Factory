package factory.restcontroller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;

import factory.entity.Materiel;
import factory.entity.Ordinateur;
import factory.entity.Projecteur;
import factory.entity.Salle;
import factory.jsonviews.JsonViews;
import factory.repository.MaterielRepository;

@RestController
@RequestMapping("/materiel")
public class MaterielRestController {

	@Autowired
	MaterielRepository materielRepository;
	
	@JsonView(JsonViews.CommonMateriel.class)
	@GetMapping(value= {"", "/"})
	public ResponseEntity<List<Materiel>> list() {
		return new ResponseEntity<List<Materiel>>(materielRepository.findAll(), HttpStatus.OK);
	}
	
	@JsonView(JsonViews.CommonMateriel.class)
	@GetMapping(value= {"/salle"})
	public ResponseEntity<List<Materiel>> listSalle() {
		List<Materiel> liste = materielRepository.findAll();
		List<Materiel> listeSalle = new ArrayList<Materiel>();
		for(Materiel m : liste) {
			if(m.getClass().getName().equals("factory.entity.Salle")) {
				listeSalle.add(m);
			}
		}
		return new ResponseEntity<List<Materiel>>(listeSalle, HttpStatus.OK);
	}
	
	@JsonView(JsonViews.CommonMateriel.class)
	@GetMapping(value= {"/projecteur"})
	public ResponseEntity<List<Materiel>> listProjecteur() {
		List<Materiel> liste = materielRepository.findAll();
		List<Materiel> listeProjecteur = new ArrayList<Materiel>();
		for(Materiel m : liste) {
			if(m.getClass().getName().equals("factory.entity.Projecteur")) {
				listeProjecteur.add(m);
			}
		}
		return new ResponseEntity<List<Materiel>>(listeProjecteur, HttpStatus.OK);
	}
	
	@JsonView(JsonViews.CommonMateriel.class)
	@GetMapping(value= {"/ordinateur"})
	public ResponseEntity<List<Materiel>> listOrdinateur() {
		List<Materiel> liste = materielRepository.findAll();
		List<Materiel> listeOrdinateur = new ArrayList<Materiel>();
		for(Materiel m : liste) {
			if(m.getClass().getName().equals("factory.entity.Ordinateur")) {
				listeOrdinateur.add(m);
			}
		}
		return new ResponseEntity<List<Materiel>>(listeOrdinateur, HttpStatus.OK);
	}
	
	@JsonView(JsonViews.CommonMateriel.class)
	@GetMapping("/{id}")
	public ResponseEntity<Materiel> findById(@PathVariable(name="id") Long id){
		Optional<Materiel> opt = materielRepository.findById(id);
		if(opt.isPresent()) {
			return new ResponseEntity<Materiel>(opt.get(),HttpStatus.OK);
		}
		return new ResponseEntity<Materiel>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = {"","/"})
	public ResponseEntity<Void> insert(@Valid @RequestBody Materiel materiel, BindingResult br, UriComponentsBuilder uCB) {
		if(br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		materielRepository.save(materiel); 
		URI uri = uCB.path("/materiel/{id}").buildAndExpand(materiel.getCode()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Materiel> update(@Valid @RequestBody Materiel materiel, BindingResult br, @PathVariable(name="id") Long id){
		Optional<Materiel> opt = materielRepository.findById(id);
		if(opt.isPresent()) {
			Materiel materielEnBase = opt.get();
			materielEnBase.setCout(materiel.getCout());
			materielEnBase.setIsDispo(materiel.getIsDispo());
			if(materielEnBase.getClass().getName().equals("factory.entity.Salle")) {
				((Salle) materielEnBase).setCapacite(((Salle) materiel).getCapacite());
			}else if(materielEnBase.getClass().getName().equals("factory.entity.Projecteur")) {
				((Projecteur) materielEnBase).setResolution(((Projecteur) materiel).getResolution());
			}else if(materielEnBase.getClass().getName().equals("factory.entity.Ordinateur")) {
				((Ordinateur) materielEnBase).setProcesseur(((Ordinateur) materiel).getProcesseur());
				((Ordinateur) materielEnBase).setRam(((Ordinateur) materiel).getRam());
				((Ordinateur) materielEnBase).setHdd(((Ordinateur) materiel).getHdd());
				((Ordinateur) materielEnBase).setAnnee(((Ordinateur) materiel).getAnnee());
				((Ordinateur) materielEnBase).setStagiaire(((Ordinateur) materiel).getStagiaire());
			}
			materielRepository.save(materielEnBase);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name="id") Long id){
		Optional<Materiel> opt = materielRepository.findById(id);
		if(opt.isPresent()) {
			materielRepository.delete(opt.get());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
