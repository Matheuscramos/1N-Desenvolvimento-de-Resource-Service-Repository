package br.com.senac.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "disciplinas")
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo;
	@Column(name = "matricula", length = 100, nullable = false)
	private String descricao;
	@Column(name = "carga_horaria", nullable = false)
	private Integer cargaHoraria;
	@Column(name = "emenda", length = 100, nullable = false)
	private String emenda;
	@Column(name = "blibliografia", length = 100, nullable = false)
	private String blibliografia;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getEmenda() {
		return emenda;
	}

	public void setEmenda(String emenda) {
		this.emenda = emenda;
	}

	public String getBlibliografia() {
		return blibliografia;
	}

	public void setBlibliografia(String blibliografia) {
		this.blibliografia = blibliografia;
	}

}
