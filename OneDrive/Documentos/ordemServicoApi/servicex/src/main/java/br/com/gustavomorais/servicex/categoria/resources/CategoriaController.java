package br.com.gustavomorais.servicex.categoria.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavomorais.servicex.categoria.domain.Categoria;
import br.com.gustavomorais.servicex.categoria.services.CategoriaService;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping
	public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria){
		return new ResponseEntity<Categoria>(categoriaService.criarCategoria(categoria),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Categoria>> buscarTodasCategorias(){
		return new ResponseEntity<List<Categoria>>(categoriaService.recuperarTodasCategoria(),HttpStatus.FOUND);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Categoria>> buscarCategoriasPorId(@PathVariable Long id){
		return new ResponseEntity<Optional<Categoria>>(categoriaService.recuperarCategoriaPorId(id), HttpStatus.FOUND);
	}
	
	
}