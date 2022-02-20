package com.questao02.modelo;

import java.util.Objects;

public class Sentimento {
	
	private Integer id;
	private String status;
	
	public Sentimento() {
	}
	
	public Sentimento(Integer id, String status) {
		this.id = id;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sentimento other = (Sentimento) obj;
		return Objects.equals(id, other.id) && Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "Sentimento Id: " + id + ", status=" + status;
	}
	
	

}
