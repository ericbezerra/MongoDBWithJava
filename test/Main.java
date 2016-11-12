
import br.com.mongodb.dao.ConsultaDao;
import br.com.mongodb.dao.MedicoDao;
import br.com.mongodb.dao.PacienteDao;
import br.com.mongodb.model.Consulta;
import br.com.mongodb.model.Medico;
import br.com.mongodb.model.Paciente;
import java.util.ArrayList;

public class Main {

    static Paciente p;
    static Medico m;
    static Consulta c;
    static PacienteDao pdao;
    static MedicoDao mdao;
    static ConsultaDao cdao;

    public static void main(String[] args) {
        p = new Paciente();
        ArrayList<Paciente> pl;
        m = new Medico();
        ArrayList<Medico> ml;
        pdao = new PacienteDao();
        mdao = new MedicoDao();
        
        ml = mdao.find();
        
        for(int i = 0; i < ml.size(); i++){
            if(ml.get(i).getNome().equalsIgnoreCase("Mauricio de Souza")){
                m = ml.get(i);
            }
        }
        System.out.println(m.getId());
    }
}