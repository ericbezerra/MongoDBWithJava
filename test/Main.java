
import br.com.mongodb.dao.ConsultaDao;
import br.com.mongodb.dao.MedicoDao;
import br.com.mongodb.dao.PacienteDao;
import br.com.mongodb.model.Consulta;
import br.com.mongodb.model.Medico;
import br.com.mongodb.model.Paciente;

public class Main {

    static Paciente p;
    static Medico m;
    static Consulta c;
    static PacienteDao pdao;
    static MedicoDao mdao;
    static ConsultaDao cdao;

    public static void main(String[] args) {
        c = new Consulta();
        cdao = new ConsultaDao();
        
        c.setData("1/1/2016");
        c.setHora("0:0");
        
        cdao.delete(c);
    }
}