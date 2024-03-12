package br.com.gustavomorais.servicex.ordemservico.domain;

import java.sql.Date;

import br.com.gustavomorais.servicex.servico.domain.Servico;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ORDEM_SERVICO")
public class OrdemServico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ORDEM_SERVICO")
	private Long idOrdemServico;
	
	@Column(name = "DATA")
	private Date data;
	
	@Column(name = "VALOR_ORDEM_SERVICO")
	private Double valorOrdemServico;
	
	
	@ManyToOne
	//Especifica a coluna na tabela ORDEM_SERVICO que é a chave estrangeira apontando para a tabela Servico
	//O nome da coluna de chave estrangeira é ID_SERVICO.
	//Essa coluna contém os identificadores dos registros da tabela Servico aos quais as ordens de serviço estão associadas
	@JoinColumn(name = "ID_SERVICO") 
	private Servico servico;
	

}
