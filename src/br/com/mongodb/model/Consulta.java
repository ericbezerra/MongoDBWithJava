package br.com.mongodb.model;

public class Consulta {

    private String id;
    private String data;
    private String hora;
    private String medicoId;
    private String pacienteId;

    public Consulta() {
    }

    public Consulta(String id, String data, String hora, String medico, String paciente) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.medicoId = medico;
        this.pacienteId = paciente;
    }

    @Override
    public String toString() {
        return "Consulta [id=" + id + ", data=" + data + ", hora=" + hora + ", idMedico=" + medicoId + ", idPaciente="
                + pacienteId + "]";
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
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Consulta other = (Consulta) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    public String getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getMedicoId() {
        return medicoId;
    }

    public String getPacienteId() {
        return pacienteId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setMedicoId(String medicoId) {
        this.medicoId = medicoId;
    }

    public void setPacienteId(String pacienteId) {
        this.pacienteId = pacienteId;
    }

}
