package br.com.mongodb.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

import br.com.mongodb.model.Consulta;
import br.com.mongodb.util.ConnectionMDB;
import com.google.gson.Gson;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.ArrayList;
import org.bson.types.ObjectId;

public class ConsultaDao {

    private Consulta consulta;
    private DBCollection collection;
    private final BasicDBObject query;
    private final ConnectionMDB connection;

    public ConsultaDao() {
        connection = new ConnectionMDB("Sistema");
        query = new BasicDBObject();
    }

    public void insert(Consulta consulta) {
        this.consulta = consulta;
        collection = connection.getDb().getCollection("consulta");
        query.put("data", consulta.getData());
        query.put("hora", consulta.getHora());
        query.put("medicoid", consulta.getMedicoId());
        query.put("pacienteid", consulta.getPacienteId());
        collection.insert(query);
    }

    public ArrayList<Consulta> find() {
        ArrayList<Consulta> list = new ArrayList<>();
        collection = connection.getDb().getCollection("consulta");
        DBCursor cursor = collection.find();
        while (cursor.hasNext()) {
            BasicDBObject consultas = (BasicDBObject) cursor.next();
            Consulta c = new Consulta();
            c.setId(consultas.getString("_id"));
            c.setData(consultas.getString("data"));
            c.setHora(consultas.getString("hora"));
            c.setMedicoId(consultas.getString("medicoid"));
            c.setPacienteId(consultas.getString("pacienteid"));
            list.add(c);
        }

        return list;
    }

    public void update(Consulta consulta, Consulta consultaNew) {
        this.consulta = consulta;
        query.put("hora", consulta.getHora());

        BasicDBObject queryNew = new BasicDBObject();
        queryNew.put("$set", new BasicDBObject()
                .append("data", consultaNew.getData())
                .append("hora", consultaNew.getHora())
                .append("medicoid", consultaNew.getMedicoId())
                .append("pacienteid", consultaNew.getPacienteId()));

        collection.update(query, queryNew);
    }

    public void delete(Consulta consulta) {
        this.consulta = consulta;
        query.put("data", consulta.getData());
        query.append("hora", consulta.getHora());
        collection.remove(query);
        
    }

    //##  Lista pelo id do banco  ##//
    public Consulta findDocumentById(String id) {
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(id));
        DBObject dbObj = collection.findOne(query);

        consulta = new Consulta();

        Gson gson = new Gson();
        consulta = gson.fromJson(dbObj.toString(), Consulta.class);

        return consulta;
    }

}
