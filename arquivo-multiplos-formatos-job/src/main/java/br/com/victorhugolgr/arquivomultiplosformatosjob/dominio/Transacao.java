package br.com.victorhugolgr.arquivomultiplosformatosjob.dominio;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Transacao {
	public String id;
	public String descricao;
	public Double valor;
}
