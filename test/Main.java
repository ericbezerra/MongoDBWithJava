
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
        PacienteDao dao = new PacienteDao();
        
        System.out.println(dao.findDocumentById("581df16563a45313643216cc"));
    }
    
    public static void test2(){
        mdao = new MedicoDao();
       
       Object [] medicoColuna = 
            {"Nome","Especialidade"};
       
       int rows = mdao.read().size();
       int collums = medicoColuna.length;
       
       Object[][] dados = new Object[rows][collums];
       
       
       
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < collums; j++) {
                if(j == 0){
                    dados[i][j] = mdao.read().get(i).getNome();
                    dados[i][j] = mdao.read().get(i).getEspecialidade();
                }
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < collums; j++) {
                System.out.print(dados[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
    
    public static void test(){
        int qntdAtributos = 4;
        cdao = new ConsultaDao();
        Object[][] dados = new Object[cdao.read().size()][qntdAtributos];
        
        for(int i = 0; i < cdao.read().size(); i++){
            for(int j = 0; j < qntdAtributos; j++){
                if(j == 0){
                    dados[i][0] = cdao.read().get(i).getData();
                    dados[i][1] = cdao.read().get(i).getHora();
                    dados[i][2] = cdao.read().get(i).getPaciente();
                    dados[i][3] = cdao.read().get(i).getMedico();
                }
            }
        }
        
        for(int i = 0; i < dados.length; i++){
            for(int j = 0; j < dados[i].length; j++){
                System.out.print(dados[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
    
    public static void paciente() {

        p.setId(1);
        p.setNome("Paulo");
        p.setSexo("M");
        p.setIdade(43);

        pdao.create(p);
        pdao.read();
        Paciente pn = p;
        pn.setIdade(32);

        pdao.update(p, pn);
        pdao.readById(p.getId());
        pdao.remove(p);

        System.out.println(p);
        System.out.println("############FIM DO PACIENTE##############");
    }

    public static void medico() {
        m.setId(1);
        m.setNome("Mauricio");
        m.setEspecialidade("Clinico Geral");

        mdao.create(m);
        mdao.read();

        Medico mn = m;
        mn.setEspecialidade("Oftalmologista");

        mdao.update(m, mn);
        mdao.readById(m.getId());
        mdao.remove(m);

        System.out.println(m);
        System.out.println("############FIM DO MEDICO##############");
    }

    public static void consulta() {
        c.setId(1);
        c.setData("21/12/1993");
        c.setHora("14:30");
        c.setMedico("Mauricio");
        c.setPaciente("Eric");

        cdao.create(c);
        cdao.read();

        Consulta cn = c;
        cn.setHora("13:00");

        cdao.update(c, cn);
        cdao.readById(c.getId());
        cdao.remove(c);

        System.out.println(c);
        System.out.println("############FIM DA CONSULTA##############");
    }
}
