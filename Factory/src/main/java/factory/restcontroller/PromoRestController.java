package factory.restcontroller;

import java.net.URI;
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

import factory.entity.Promo;
import factory.entity.Stagiaire;
import factory.jsonviews.JsonViews;
import factory.repository.PromoRepository;

@RestController
@RequestMapping("/promo")
public class PromoRestController {

	@Autowired
	private PromoRepository promoRepository;

	@JsonView(JsonViews.CommonPromo.class)
	@GetMapping(value = { "", "/" })
	public ResponseEntity<List<Promo>> list() {
		return new ResponseEntity<List<Promo>>(promoRepository.findAll(), HttpStatus.OK);
	}

////	@JsonView(JsonViews.promoWithStagiaire.class)
//	@GetMapping("/Stagiaires")
//	public ResponseEntity<List<Promo>> listWithStagiaire() {
//		return new ResponseEntity<List<Promo>>(promoRepository.findAll(), HttpStatus.OK);
//	}

	@PostMapping(value = { "", "/" })
	public ResponseEntity<Void> insert(@Valid @RequestBody Promo promo, BindingResult br, UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		promoRepository.save(promo);
		URI uri = uCB.path("/rest/promo/{id}").buildAndExpand(promo.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@JsonView(JsonViews.CommonPromo.class)
	@GetMapping("/{id}")
	public ResponseEntity<Promo> findById(@PathVariable(name = "id") Long id) {
		Optional<Promo> opt = promoRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Promo>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Promo>(HttpStatus.NOT_FOUND);
		}
	}

////@JsonView(JsonViews.promoWithStagiaire.class)
//	@GetMapping("/{id}/Stagiaire")
//	public ResponseEntity<Promo> findByIdWithStagiaire(@PathVariable(name = "id") Long id) {
//		Optional<Promo> opt = promoRepository.findById(id);
//		if (opt.isPresent()) {
//			return new ResponseEntity<Promo>(opt.get(), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<Promo>(HttpStatus.NOT_FOUND);
//		}
//	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody Promo promo, BindingResult br,
			@PathVariable(name = "id") Long id) {
		Optional<Promo> opt = promoRepository.findById(id);
		if (opt.isPresent()) {
			Promo promoEnBase = opt.get();
			promoEnBase.setListStagiaire(promo.getListStagiaire());
			promoEnBase.setListModule(promo.getListModule());
			promoEnBase.setNomPromo(promo.getNomPromo());
			promoRepository.save(promoEnBase);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
		Optional<Promo> opt = promoRepository.findById(id);
		if (opt.isPresent()) {
			promoRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
