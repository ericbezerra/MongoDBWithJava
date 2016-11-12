package br.com.mongodb.model;


public class Consulta {
	private Integer id;
	private String data;
	private String hora;
	private String medico;
	private String paciente;
	
	public Consulta() {	}

	public Consulta(String data, String hora, String medico, String paciente) {
		this.data = data;
		this.hora = hora;
		this.medico = medico;
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "Consulta [data=" + data + ", hora=" + hora + ", idMedico=" + medico + ", idPaciente="
				+ paciente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public String getData() {
		return data;
	}

	public String getHora() {
		return hora;
	}

	public String getMedico() {
		return medico;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	
}
