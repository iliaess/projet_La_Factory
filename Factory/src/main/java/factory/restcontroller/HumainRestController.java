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

import factory.entity.Formateur;
import factory.entity.Humain;
import factory.entity.Ordinateur;
import factory.entity.Stagiaire;
import factory.jsonviews.JsonViews;
import factory.repository.HumainRepository;

@RestController
@RequestMapping("/personne")
public class HumainRestController {
	
	@Autowired
	HumainRepository humainRepository;
	
	@JsonView(JsonViews.CommonHumain.class)
	@GetMapping(value= {"", "/"})
	public ResponseEntity<List<Humain>> list() {
		return new ResponseEntity<List<Humain>>(humainRepository.findAll(), HttpStatus.OK);
	}
	
	@JsonView(JsonViews.CommonHumain.class)
	@GetMapping(value= {"/gestionnaire"})
	public ResponseEntity<List<Humain>> listGestionnaire() {
		List<Humain> liste = humainRepository.findAll();
		List<Humain> listeGestionnaire = new ArrayList<Humain>();
		for(Humain h : liste) {
			if(h.getClass().getName().equals("factory.entity.Gestionnaire")) {
				listeGestionnaire.add(h);
			}
		}
		return new ResponseEntity<List<Humain>>(listeGestionnaire, HttpStatus.OK);
	}
	
	@JsonView(JsonViews.CommonHumain.class)
	@GetMapping(value= {"/technicien"})
	public ResponseEntity<List<Humain>> listTechnicien() {
		List<Humain> liste = humainRepository.findAll();
		List<Humain> listeTechnicien = new ArrayList<Humain>();
		for(Humain h : liste) {
			if(h.getClass().getName().equals("factory.entity.Technicien")) {
				listeTechnicien.add(h);
			}
		}
		return new ResponseEntity<List<Humain>>(listeTechnicien, HttpStatus.OK);
	}
	
	@JsonView(JsonViews.CommonHumain.class)
	@GetMapping(value= {"/formateur"})
	public ResponseEntity<List<Humain>> listFormateur() {
		List<Humain> liste = humainRepository.findAll();
		List<Humain> listeFormateur = new ArrayList<Humain>();
		for(Humain h : liste) {
			if(h.getClass().getName().equals("factory.entity.Formateur")) {
				listeFormateur.add(h);
			}
		}
		return new ResponseEntity<List<Humain>>(listeFormateur, HttpStatus.OK);
	}
	
	@JsonView(JsonViews.CommonHumain.class)
	@GetMapping(value= {"/stagiaire"})
	public ResponseEntity<List<Humain>> listStagiaire() {
		List<Humain> liste = humainRepository.findAll();
		List<Humain> listeStagiaire = new ArrayList<Humain>();
		for(Humain h : liste) {
			if(h.getClass().getName().equals("factory.entity.Stagiaire")) {
				listeStagiaire.add(h);
			}
		}
		return new ResponseEntity<List<Humain>>(listeStagiaire, HttpStatus.OK);
	}
	
	
	@JsonView(JsonViews.CommonHumain.class)
	@GetMapping("/{id}")
	public ResponseEntity<Humain> findById(@PathVariable(name="id") Long id){
		Optional<Humain> opt = humainRepository.findById(id);
		if(opt.isPresent()) {
			return new ResponseEntity<Humain>(opt.get(),HttpStatus.OK);
		}
		return new ResponseEntity<Humain>(HttpStatus.NOT_FOUND);
	}
	
	@JsonView(JsonViews.CommonHumain.class)
	@GetMapping("/{id}/ordinateur")
	public ResponseEntity<Ordinateur> findByIdOrdinateur(@PathVariable(name="id") Long id){
		Optional<Humain> opt = humainRepository.findById(id);
		if(opt.isPresent()) {
			System.out.println(opt.get().toString());
			System.out.println(((Stagiaire) opt.get()).getOrdinateur());
			return new ResponseEntity<Ordinateur>(((Stagiaire) opt.get()).getOrdinateur(),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = {"","/"})
	public ResponseEntity<Void> insert(@Valid @RequestBody Humain humain, BindingResult br, UriComponentsBuilder uCB) {
		if(br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		humainRepository.save(humain); 
		URI uri = uCB.path("/humain/{id}").buildAndExpand(humain.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Humain> update(@Valid @RequestBody Humain humain, BindingResult br, @PathVariable(name="id") Long id){
		Optional<Humain> opt = humainRepository.findById(id);
		if(opt.isPresent()) {
			Humain humainEnBase = opt.get();
			humainEnBase.setNom(humain.getNom());
			humainEnBase.setPrenom(humain.getPrenom());
			humainEnBase.setEmail(humain.getEmail());
			humainEnBase.setTelephone(humain.getTelephone());
			humainEnBase.setRue(humain.getRue());
			humainEnBase.setVille(humain.getVille());
			humainEnBase.setZipcode(humain.getZipcode());
			if(humainEnBase.getClass().getName().equals("factory.entity.Formateur")) {
				((Formateur) humainEnBase).setDispenses(((Formateur) humain).getDispenses());
				((Formateur) humainEnBase).setDispensables(((Formateur) humain).getDispensables());
			}else if(humainEnBase.getClass().getName().equals("factory.entity.Projecteur")) {
				((Stagiaire) humainEnBase).setOrdinateur(((Stagiaire) humain).getOrdinateur());
			}
			humainRepository.save(humainEnBase);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name="id") Long id){
		Optional<Humain> opt = humainRepository.findById(id);
		if(opt.isPresent()) {
			humainRepository.delete(opt.get());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
