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

import factory.entity.Matiere;
import factory.jsonviews.JsonViews;
import factory.repository.MatiereRepository;

@RestController
@RequestMapping("/matiere")
public class MatiereRestController {
	
	@Autowired
	MatiereRepository matiereRepository;
	
	@JsonView(JsonViews.IMatiere.class)
	@GetMapping(value= {"", "/"})
	public ResponseEntity<List<Matiere>> list() {
		return new ResponseEntity<List<Matiere>>(matiereRepository.findAll(), HttpStatus.OK);
	}
	
	@JsonView(JsonViews.IMatiere.class)
	@GetMapping("/{titre}")
	public ResponseEntity<Matiere> findByTitre(@PathVariable(name="titre") String titre){
		Optional<Matiere> opt = matiereRepository.findByTitre(titre);
		if(opt.isPresent()) {
			return new ResponseEntity<Matiere>(opt.get(),HttpStatus.OK);
		}
		return new ResponseEntity<Matiere>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = {"","/"})
	public ResponseEntity<Void> insert(@Valid @RequestBody Matiere matiere, BindingResult br, UriComponentsBuilder uCB) {
		if(br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		matiereRepository.save(matiere); 
		URI uri = uCB.path("/matiere/{titre}").buildAndExpand(matiere.getTitre()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{titre}")
	public ResponseEntity<Matiere> update(@Valid @RequestBody Matiere matiere, BindingResult br, @PathVariable(name="titre") String titre){
		Optional<Matiere> opt = matiereRepository.findByTitre(titre);
		if(opt.isPresent()) {
			Matiere matiereEnBase = opt.get();
			matiereEnBase.setObjectif(matiere.getObjectif());
			matiereEnBase.setPrerequis(matiere.getPrerequis());
			matiereEnBase.setContenu(matiere.getContenu());
			matiereRepository.save(matiereEnBase);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{titre}")
	public ResponseEntity<Void> delete(@PathVariable(name="titre") String titre){
		Optional<Matiere> opt = matiereRepository.findByTitre(titre);
		if(opt.isPresent()) {
			matiereRepository.delete(opt.get());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


}
