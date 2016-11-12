package br.com.mongodb.dao;

import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import br.com.mongodb.model.Medico;
import br.com.mongodb.util.ConnectionMDB;

public class MedicoDao {
	private Medico medico;
    private DBCollection collection;
    private final BasicDBObject query;
    private final ConnectionMDB connection;
	
	public MedicoDao() {
		connection = new ConnectionMDB("Sistema");
                collection = connection.getDb().getCollection("medico");
        query = new BasicDBObject();
	}

	//##  Insere no banco  ##//
	public void create(Medico medico) {
		this.medico = medico;
        query.put("nome",medico.getNome());
        query.put("especialidade",medico.getEspecialidade());
        collection.insert(query);
	}
	
	//##  Lista todos do banco  ##//
	public ArrayList<Medico> read() {
            ArrayList<Medico> list = new ArrayList<>();
            DBCursor cursor = collection.find();
            while (cursor.hasNext()) {
                BasicDBObject medicos = (BasicDBObject) cursor.next();
                Medico m = new Medico();
                m.setNome(medicos.getString("nome"));
                m.setEspecialidade(medicos.getString("especialidade"));
                list.add(m);
            }

            return list;
	}
	
	//##  Atualiza no banco  ##//
	public void update(Medico medico, Medico medicoNew) {
		this.medico = medico;
        query.put("nome", medico.getNome());
        query.append("especialidade", medico.getEspecialidade());
        
        BasicDBObject queryNew = new BasicDBObject();
        queryNew.put("$set",  new BasicDBObject()
                .append("nome", medicoNew.getNome())
                .append("especialidade", medicoNew.getEspecialidade()));

        collection.update(query, queryNew);
	}

	//##  Remove do banco  ##//
	public void remove(Medico medico) {
		this.medico = medico;
        query.put("nome", medico.getNome());
        collection.remove(query);
	}
	
	//##  Lista pelo id do banco  ##//
	public Medico readById(Integer id) {
		return this.medico;
	}


}
