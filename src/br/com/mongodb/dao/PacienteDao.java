package br.com.mongodb.dao;

import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

import br.com.mongodb.model.Paciente;
import br.com.mongodb.util.ConnectionMDB;
import com.google.gson.Gson;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;

public class PacienteDao {
	private Paciente paciente;
    private DBCollection collection;
    private final BasicDBObject query;
    private final ConnectionMDB connection;

	public PacienteDao() {
		connection = new ConnectionMDB("Sistema");
        collection = connection.getDb().getCollection("paciente");
        query = new BasicDBObject();
	}

	
	//##  Insere no banco  ##//
	public void insert(Paciente paciente) {
		this.paciente = paciente;
        query.put("nome",paciente.getNome());
        query.put("sexo",paciente.getSexo());
        query.put("idade",paciente.getIdade());
        collection.insert(query);
	}

	//##  Lista todos do banco  ##//
	public ArrayList<Paciente> find() {
            ArrayList<Paciente> list = new ArrayList<>();
            collection = connection.getDb().getCollection("paciente");
            DBCursor cursor = collection.find();
            while (cursor.hasNext()) {
                BasicDBObject pacientes = (BasicDBObject) cursor.next();
                Paciente p = new Paciente();
                p.setId(pacientes.getString("_id"));
                p.setNome(pacientes.getString("nome"));
                p.setSexo(pacientes.getString("sexo"));
                p.setIdade(pacientes.getInt("idade"));
                list.add(p);
            }

            return list;
	}

	//##  Atualiza no banco  ##//
	public void update(Paciente paciente, Paciente pacienteNew) {
		this.paciente = paciente;
        query.put("nome", paciente.getNome());
        query.append("sexo", paciente.getSexo());
        query.append("idade", paciente.getIdade());
        
        BasicDBObject queryNew = new BasicDBObject();
        queryNew.put("$set",  new BasicDBObject()
                .append("nome", pacienteNew.getNome())
                .append("sexo", pacienteNew.getSexo())
                .append("idade", pacienteNew.getIdade()));

        collection.update(query, queryNew);
	}

	//##  Remove do banco  ##//
	public void delete(Paciente paciente) {
		this.paciente = paciente;
        query.put("nome", paciente.getNome());
        query.append("sexo", paciente.getSexo());
        query.append("idade", paciente.getIdade());
        collection.remove(query);
	}

	//##  Lista pelo id do banco  ##//
        public Paciente findDocumentById(String id) {
            BasicDBObject query = new BasicDBObject();
            query.put("_id", new ObjectId(id));
            DBObject dbObj = collection.findOne(query);
            
            paciente = new Paciente();
            
            Gson gson = new Gson();
            paciente = gson.fromJson(dbObj.toString(), Paciente.class);
            
            return paciente;
        }
}
