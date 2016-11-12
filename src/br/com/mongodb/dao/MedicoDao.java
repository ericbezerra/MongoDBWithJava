package br.com.mongodb.dao;

import br.com.mongodb.model.Consulta;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import br.com.mongodb.model.Medico;
import br.com.mongodb.util.ConnectionMDB;
import com.google.gson.Gson;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;

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
    public void insert(Medico medico) {
        this.medico = medico;
        query.put("nome", medico.getNome());
        query.put("especialidade", medico.getEspecialidade());
        collection.insert(query);
    }

    //##  Lista todos do banco  ##//
    public ArrayList<Medico> find() {
        ArrayList<Medico> list = new ArrayList<>();
        DBCursor cursor = collection.find();
        while (cursor.hasNext()) {
            BasicDBObject medicos = (BasicDBObject) cursor.next();
            Medico m = new Medico();
            m.setId(medicos.getString("_id"));
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
        queryNew.put("$set", new BasicDBObject()
                .append("nome", medicoNew.getNome())
                .append("especialidade", medicoNew.getEspecialidade()));

        collection.update(query, queryNew);
    }

    //##  Remove do banco  ##//
    public void delete(Medico medico) {
        this.medico = medico;
        query.put("nome", medico.getNome());
        query.append("especialidade", medico.getEspecialidade());
        collection.remove(query);
    }

    //##  Lista pelo id do banco  ##//
    public Medico findDocumentById(String id) {
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(id));
        DBObject dbObj = collection.findOne(query);

        medico = new Medico();

        Gson gson = new Gson();
        medico = gson.fromJson(dbObj.toString(), Medico.class);

        return medico;
    }

}
