
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
        mdao = new MedicoDao();
        String medico = "Mauricio de Souza";
       for(int i = 0; i < mdao.find().size(); i++){
           if(mdao.find().get(i).getNome().equalsIgnoreCase("Mauricio de Souza")){
               System.out.println(mdao.find().get(i).getId());
           }
           
       }
       //58272ee13fc0701bec2fae5b
    }
}