package com.rxl.socialbooks.domain;

public class Erros {
	
	private String titulo;
	
	private Long status;
	
	private Long timesTamp;
	
	private String mensagem;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getTimesTamp() {
		return timesTamp;
	}

	public void setTimesTamp(Long timesTamp) {
		this.timesTamp = timesTamp;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
