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

import factory.entity.Module;
import factory.entity.Ordinateur;
import factory.entity.Projecteur;
import factory.entity.Salle;
import factory.jsonviews.JsonViews;
import factory.repository.ModuleRepository;

@RestController
@RequestMapping("/module")
public class ModuleRestController {

	@Autowired
	ModuleRepository moduleRepository;
	
	@JsonView(JsonViews.CommonModule.class)
	@GetMapping(value= {"", "/"})
	public ResponseEntity<List<Module>> list() {
		return new ResponseEntity<List<Module>>(moduleRepository.findAll(), HttpStatus.OK);
	}
	
	@JsonView(JsonViews.CommonModule.class)
	@GetMapping("/{id}")
	public ResponseEntity<Module> findById(@PathVariable(name="id") Long id){
		Optional<Module> opt = moduleRepository.findById(id);
		if(opt.isPresent()) {
			return new ResponseEntity<Module>(opt.get(),HttpStatus.OK);
		}
		return new ResponseEntity<Module>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = {"","/"})
	public ResponseEntity<Void> insert(@Valid @RequestBody Module module, BindingResult br, UriComponentsBuilder uCB) {
		if(br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		moduleRepository.save(module); 
		URI uri = uCB.path("/module/{id}").buildAndExpand(module.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Module> update(@Valid @RequestBody Module module, BindingResult br, @PathVariable(name="id") Long id){
		Optional<Module> opt = moduleRepository.findById(id);
		if(opt.isPresent()) {
			Module moduleEnBase = opt.get();
			moduleEnBase.setDebut(module.getDebut());
			moduleEnBase.setFin(module.getFin());
			moduleEnBase.setFormateur(module.getFormateur());
			moduleEnBase.setMatiere(module.getMatiere());
			moduleEnBase.setPromo(module.getPromo());

			moduleRepository.save(moduleEnBase);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name="id") Long id){
		Optional<Module> opt = moduleRepository.findById(id);
		if(opt.isPresent()) {
			moduleRepository.delete(opt.get());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

