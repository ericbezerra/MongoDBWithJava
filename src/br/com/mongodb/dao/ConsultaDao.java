package br.com.mongodb.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

import br.com.mongodb.model.Consulta;
import br.com.mongodb.util.ConnectionMDB;
import com.mongodb.DBCursor;
import java.util.ArrayList;

public class ConsultaDao {
    private Consulta consulta;
    private DBCollection collection;
    private final BasicDBObject query;
    private final ConnectionMDB connection;
	
	public ConsultaDao() {
            connection = new ConnectionMDB("Sistema");
            query = new BasicDBObject();
	}

	public void create(Consulta consulta) {
		this.consulta = consulta;
        collection = connection.getDb().getCollection("consulta");
        query.put("data",consulta.getData());
        query.put("hora",consulta.getHora());
        query.put("medico",consulta.getMedico());
        query.put("paciente",consulta.getPaciente());
        collection.insert(query);
	}

	public ArrayList<Consulta> read() {
            ArrayList<Consulta> list = new ArrayList<>();
            collection = connection.getDb().getCollection("consulta");
            DBCursor cursor = collection.find();
            while (cursor.hasNext()) {
                BasicDBObject consultas = (BasicDBObject) cursor.next();
                Consulta c = new Consulta();
                c.setData(consultas.getString("data"));
                c.setHora(consultas.getString("hora"));
                c.setMedico(consultas.getString("medico"));
                c.setPaciente(consultas.getString("paciente"));
                list.add(c);
            }
        
            return list;
	}

	public void update(Consulta consulta, Consulta consultaNew) {
		this.consulta = consulta;
        query.put("hora", consulta.getHora());
        
        BasicDBObject queryNew = new BasicDBObject();
        queryNew.put("$set",  new BasicDBObject()
                .append("data", consultaNew.getData())
                .append("hora", consultaNew.getHora())
                .append("medico", consultaNew.getMedico())
                .append("paciente", consultaNew.getPaciente()));

        collection.update(query, queryNew);
	}
	
	public void remove(Consulta consulta) {
		this.consulta = consulta;
        query.put("hora", consulta.getHora());
        collection.remove(query);
	}

	public Consulta  readById(Integer id) {
		return this.consulta;
	}



}
