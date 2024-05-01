package br.com.senac.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.interfaces.IResource;
import br.com.senac.model.Pessoa;
import br.com.senac.services.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/v1/pessoa")
@Tag(name = "pessoa", description = "documentação do resource pessoa")
public class PessoaResource implements IResource<Pessoa, Integer> {

	@Autowired
	private PessoaService pessoaService;

	/**
	 * Mètodo para criar T
	 *
	 * @param entity
	 * @return
	 */
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@Operation(summary = "Cria uma pessoa", description = "Método responsável para criar uma pessoa no sistema", tags = {
			"pessoa" })
	@ApiResponses({ @ApiResponse(responseCode = "201", content = {
			@Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
			@ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "304", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@Override
	public Pessoa create(@RequestBody Pessoa entity) {
		return pessoaService.create(entity);
	}

	/**
	 * Método para consultar T baseado no identificador N informado
	 *
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(summary = "Recupera uma pessoa baseada em um identificador", description = "Método responsável para recuperar uma pessoa no sistema baseado no identificador", tags = {
			"pessoa" })
	@ApiResponses({ @ApiResponse(responseCode = "200", content = {
			@Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
			@ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@Override
	public Pessoa get(@PathVariable("id") Integer id) {
		return pessoaService.get(id);
	}

	/**
	 * Retorna uma lista de T
	 *
	 * @return
	 */
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(summary = "Recupera uma lista de pessoas", description = "Método responsável para recuperar uma lista de pessoas", tags = {
			"pessoa" })
	@ApiResponses({ @ApiResponse(responseCode = "200", content = {
			@Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
			@ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@Override
	public List<Pessoa> get() {
		return pessoaService.get();
	}

	/**
	 * Iremos passar N(id) para buscar o registro e T(entity) para atualizar o
	 * objeto;
	 *
	 * @param id
	 * @param entity
	 * @return
	 */
	@PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@Operation(summary = "Atualiza todos os dados de uma pessoa", description = "Método responsável para atualizar todos os dados de uma pessoa.", tags = {
			"pessoa" })
	@ApiResponses({ @ApiResponse(responseCode = "200", content = {
			@Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
			@ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@Override
	public Pessoa update(@PathVariable Integer id, @RequestBody Pessoa entity) {
		return pessoaService.update(id, entity);
	}

	/**
	 * Deleta um registro com base no identificador N(id)
	 *
	 * @param id
	 */
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Delete uma pessoa com base no identificador.", description = "Método responsável para deletar uma pessoa com base no identificador.", tags = {
			"pessoa" })
	@ApiResponses({ @ApiResponse(responseCode = "206", content = {
			@Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
			@ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@Override
	public void delete(@PathVariable Integer id) {
		pessoaService.delete(id);
	}

}
