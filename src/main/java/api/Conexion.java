package api;


import java.lang.annotation.Documented;
import java.util.List;

import javax.print.PrintService;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.query.Criteria;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import animales.AbstractMascota;
import animales.AbstractMascotaConSaludo;
import animales.AbstractMascotaSinSaludo;
import animales.Gato;
import animales.Pajaro;
import animales.Perro;
import animales.Pez;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.lt;
import static com.mongodb.client.model.Updates.*;

@Entity("useDiscriminator = false")
public class Conexion {
	static Gson gson = new Gson();
	static MongoClientURI uri = new MongoClientURI("mongodb://Elias:KalosKaiAgathos@animals-shard-00-00.lxizf.mongodb.net:27017,animals-shard-00-01.lxizf.mongodb.net:27017,animals-shard-00-02.lxizf.mongodb.net:27017/Animals?ssl=true&replicaSet=atlas-hwnog5-shard-0&authSource=admin&retryWrites=true&w=majority");
	static MongoClient mongoClient = new MongoClient(uri);
	static MongoDatabase AnimalesBD = mongoClient.getDatabase("AnimalesBD");
    static MongoCollection<Document> collectionAnimales = AnimalesBD.getCollection("Document");
    static Datastore datastore = new Morphia().createDatastore(mongoClient, "AnimalesBD"); 
    
    public static void main(String[] args) {
    	Conexion.quitarVida(147);
    }
    
	public static String insertarGato(Gato usuario1) {
		
	    /*String SetNombreMascota = usuario1.getNombreMascota();
	    String SetNombreDueno = usuario1.getNombreDueno();
	    int SetId = usuario1.getId();
	    String tipo = "gato";
	    Document usuarioJson = new Document();
	    usuarioJson.put("NombreMascota", SetNombreMascota);
	    usuarioJson.put("id", SetId);
	    usuarioJson.put("NombreDueno", SetNombreDueno);
	    usuarioJson.put("tipo", tipo);
	    int alegria = 0;
	    usuarioJson.put("alegria", alegria);*/
	    
	    datastore.save(usuario1);
	    return "usuario Agregado";
	}
	
	public static String insertarPajaro(Pajaro usuario1) {
	
	    /*String SetNombreMascota = usuario1.getNombreMascota();
	    String SetNombreDueno = usuario1.getNombreDueno();
	    int SetId = usuario1.getId();
	    String tipo = "pajaro";
	    Document usuarioJson = new Document();
	    usuarioJson.put("NombreMascota", SetNombreMascota);
	    usuarioJson.put("id", SetId);
	    usuarioJson.put("NombreDueno", SetNombreDueno);
	    usuarioJson.put("tipo", tipo);
	    int alegria = 0;
	    usuarioJson.put("alegria", alegria);*/
	    
	    datastore.save(usuario1);
	    return "usuario Agregado";
	}
	
	public static String insertarPerro(Perro usuario1) {
		
	    /*String SetNombreMascota = usuario1.getNombreMascota();
	    System.out.println(usuario1.getNombreMascota());
	    String SetNombreDueno = usuario1.getNombreDueno();
	    System.out.println(usuario1.getNombreDueno());
	    int SetId = usuario1.getId();
	    System.out.println(usuario1.getId());
	    String tipo = "perro";
	    
	    System.out.println("si");
	    Document usuarioJson = new Document();
	    usuarioJson.put("NombreMascota", SetNombreMascota);
	    usuarioJson.put("id", SetId);
	    usuarioJson.put("NombreDueno", SetNombreDueno);
	    usuarioJson.put("tipo", tipo);
	    int alegria = 0;
	    usuarioJson.put("alegria", alegria);
	    System.out.println("isis");*/
	    
	    datastore.save(usuario1);
	    return "usuario Agregado";
	}
	
	public static String insertarPez(Pez Animal) {
	    /*String SetNombreMascota = Animal.getNombreMascota();
	    String SetNombreDueno = Animal.getNombreDueno();
	    int SetId = Animal.getId();
	    int vidas = Animal.getVidas();
	    String tipo = "pez";
	    Document AnimalJson = new Document();
	    AnimalJson.put("NombreMascota", SetNombreMascota);
	    AnimalJson.put("id", SetId);
	    AnimalJson.put("NombreDueno", SetNombreDueno);
	    AnimalJson.put("tipo", tipo);
	    AnimalJson.put("vidas", vidas);*/
	    Animal.setVidas(10);
	    datastore.save(Animal);
	    return "usuario Agregado";
	}
	
	public static Perro encontrarPerro(int usuario1) {
		List<Perro> listaPerro = datastore.find(Perro.class).asList();
		
		    for(int i = 0; i < listaPerro.size(); i++) {
		    	if(listaPerro.get(i).getId() == usuario1) {
		    		System.out.println(listaPerro.get(i));
		    		return listaPerro.get(i); 
		    	}
		    }

	    return null;
	}
	
	public static Gato encontrarGato(int usuario1) {
		List<Gato> listaGato = datastore.find(Gato.class).asList(); 
		
		    for(int i = 0; i < listaGato.size(); i++) {
		    	if(listaGato.get(i).getId() == usuario1) {
		    		System.out.println(listaGato.get(i));
		    		return listaGato.get(i); 
		    	}
		    }

	    return null;
	}
	
	public static Pez encontrarPez(int usuario1) {
			List<Pez> listaPez = datastore.find(Pez.class).asList();
				
		    for(int i = 0; i < listaPez.size(); i++) {
		    	if(listaPez.get(i).getId() == usuario1) {
		    		System.out.println(listaPez.get(i));
		    		return listaPez.get(i); 
		    	}
		    }

	    return null;
	}
	
	public static String encontrarTipo(int usuario1) {
		System.out.println("si");
		List<Pez> listaPez = datastore.find(Pez.class).asList();
		List<Gato> listaGato = datastore.find(Gato.class).asList(); 
		List<Perro> listaPerro = datastore.find(Perro.class).asList();
		List<Pajaro> listaPajaro = datastore.find(Pajaro.class).asList();
		
			
	    for(int i = 0; i < listaPez.size(); i++) {
	    	if(listaPez.get(i).getId() == usuario1) {
	    		return "Pez"; 
	    	}
	    }
	    
	    for(int i = 0; i < listaPajaro.size(); i++) {
		    if(listaPajaro.get(i).getId() == usuario1) {
		    	return "Pajaro"; 
		    	}
		    }
	    
	    for(int i = 0; i < listaGato.size(); i++) {
	    	if(listaGato.get(i).getId() == usuario1) {
	    		return "Gato"; 
	    	}
	    }
	    
	    for(int i = 0; i < listaPerro.size(); i++) {
	    	if(listaPerro.get(i).getId() == usuario1) {
	    		return "Perro"; 
	    	}
	    }

    return "No";
}
	

	
	public static int encontrarIdPorNombre(String usuario1) {
		System.out.println("si");
		List<Pez> listaPez = datastore.find(Pez.class).asList();
		List<Gato> listaGato = datastore.find(Gato.class).asList(); 
		List<Perro> listaPerro = datastore.find(Perro.class).asList();
		List<Pajaro> listaPajaro = datastore.find(Pajaro.class).asList();
		
			
	    for(int i = 0; i < listaPez.size(); i++) {
	    	if(listaPez.get(i).getNombreMascota().contentEquals(usuario1) ) {
	    		return listaPez.get(i).getId(); 
	    	}
	    }
	    
	    for(int i = 0; i < listaPajaro.size(); i++) {
		    if(listaPajaro.get(i).getNombreMascota().contentEquals(usuario1)) {
		    	return listaPajaro.get(i).getId(); 
		    	}
		    }
	    
	    for(int i = 0; i < listaGato.size(); i++) {
	    	if(listaGato.get(i).getNombreMascota().contentEquals(usuario1)) {
	    		return listaGato.get(i).getId(); 
	    	}
	    }
	    
	    for(int i = 0; i < listaPerro.size(); i++) {
	    	if(listaPerro.get(i).getNombreMascota().contentEquals(usuario1)) {
	    		return listaPerro.get(i).getId(); 
	    	}
	    }

    return 0;
}
	
	public static Pajaro encontrarPajaro(int usuario1) {

		List<Pajaro> listaPajaro = datastore.find(Pajaro.class).asList();
		
	    for(int i = 0; i < listaPajaro.size(); i++) {
		    if(listaPajaro.get(i).getId() == usuario1) {
		    	System.out.println(listaPajaro.get(i));
		    	return listaPajaro.get(i); 
		    	}
		    }

	    return null;
	}
	
	public static WriteResult eliminarAnimal(int animal) {
		
		String tipo = Conexion.encontrarTipo(animal);
		System.out.println(tipo);
		switch (tipo)
		{
		     case "Perro":
		    	 Query<Perro> query = datastore.createQuery(Perro.class).field("id").equal(animal);
		    	 return datastore.delete(query);
		    	 
		     case "Gato":
		    	 Query<Gato> query2 = datastore.createQuery(Gato.class).field("id").equal(animal);
		    	 return datastore.delete(query2);
		    	 
		    	 
		     
		     case "Pez":
		    	 Query<Pez> query3 = datastore.createQuery(Pez.class).field("id").equal(animal);
		    	 return datastore.delete(query3);
		    	 
		    	 
		     
		     case "Pajaro":
		    	 Query<Pajaro> query4 = datastore.createQuery(Pajaro.class).field("id").equal(animal);
		    	 return datastore.delete(query4);
		    	 
			 
		    default:
		    	
		    System.out.println("err");
		    return null;
		    
		     
		}
		
	    
	    
	}
	

	
	public static String modificarAnimal(int animal, String valor, String variable) {

		String tipo = Conexion.encontrarTipo(animal);
		System.out.println(tipo);
		switch (tipo)
		{
		     case "Perro":
		    	 Query<Perro> query =  datastore.find(Perro.class).field("id").equal(animal);
		    	 System.out.println("si");
		    	 UpdateOperations<Perro> ops = datastore.createUpdateOperations(Perro.class).set(variable, valor);
		    	 System.out.println("si");
		    	 datastore.update(query, ops); 
		    	 break;
		    	 
		     case "Gato":
		    	 Query<Gato> query2 =  datastore.find(Gato.class).field("id").equal(animal);
		    	 System.out.println("si");
		    	 UpdateOperations<Gato> ops2 = datastore.createUpdateOperations(Gato.class).set(variable, valor);
		    	 System.out.println("si");
		    	 datastore.update(query2, ops2);
		    	 break;
		    	 
		    	 
		     
		     case "Pez":
		    	 Query<Pez> query3 =  datastore.find(Pez.class).field("id").equal(animal);
		    	 System.out.println("si");
		    	 UpdateOperations<Pez> ops3 = datastore.createUpdateOperations(Pez.class).set(variable, valor);
		    	 System.out.println("si");
		    	 datastore.update(query3, ops3); 
		    	 break;
		    	 
		    	 
		     
		     case "Pajaro":
		    	 Query<Pajaro> query4 =  datastore.find(Pajaro.class).field("id").equal(animal);
		    	 System.out.println("si");
		    	 UpdateOperations<Pajaro> ops4 = datastore.createUpdateOperations(Pajaro.class).set(variable, valor);
		    	 System.out.println("si"); 
		    	 datastore.update(query4, ops4);
		    	 break;
		    	 
			 
		    default:
		    	
		    System.out.println("err");
		    return null;
		    
		     
		}
		return "si";
		
		


		
	  
	    
	}
	

	
	public static String quitarVida(int animal) {
		String tipo = Conexion.encontrarTipo(animal);
		System.out.println(tipo);
		switch (tipo)
		{
			case "Pez":
				Pez pez1 = (Pez) Conexion.conseguirVariableSS(animal);
				Conexion.modificarAnimal(animal, Integer.toString(pez1.getVidas() - 1), "vidas");
				if(Conexion.conseguirVariableSS(animal).getVidas() <= 0) {
					Conexion.eliminarAnimal(animal);
				}
				
				return "1";
			default:
		    	
			    System.out.println("err");
			    return null;
		}

	    
	}
	
	public static String alimentar(int animal) {

		String tipo = Conexion.encontrarTipo(animal);
		
		switch (tipo)
		{
		     case "Perro":
		    	 Perro perro1 = (Perro) Conexion.conseguirVariableCS(animal);
		    	 Conexion.modificarAnimal(animal, Integer.toString(perro1.getAlegria() + 1), "alegria");
		    	 break;
		    	 
		     case "Gato":
		    	 Gato gato1 = (Gato) Conexion.conseguirVariableCS(animal);
		    	 Conexion.modificarAnimal(animal, Integer.toString(gato1.getAlegria() + 1), "alegria");
		    	 break;
		    	 
		     
		     case "Pez":
		    	 Pez pez1 = (Pez) Conexion.conseguirVariableSS(animal);
		    	 Conexion.modificarAnimal(animal, Integer.toString(pez1.getVidas() + 1), "vidas");
		    	 break;
		    	 
		    	 
		     
		     case "Pajaro":
		    	 Pajaro pajaro1 = (Pajaro) Conexion.conseguirVariableCS(animal);
		    	 Conexion.modificarAnimal(animal, Integer.toString(pajaro1.getAlegria() + 1), "alegria");
		    	 break;
			 
		    default:
		    	
		    System.out.println("err");
		    return null;
		    
		     
		}
		return "si";
	    
	}
	
	public static AbstractMascotaConSaludo conseguirVariableCS(int usuario1) {

		
		List<Gato> listaGato = datastore.find(Gato.class).asList(); 
		List<Perro> listaPerro = datastore.find(Perro.class).asList();
		List<Pajaro> listaPajaro = datastore.find(Pajaro.class).asList();
		
			
	    
	    
	    for(int i = 0; i < listaPajaro.size(); i++) {
		    if(listaPajaro.get(i).getId() == usuario1) {
		    	return listaPajaro.get(i); 
		    	}
		    }
	    
	    for(int i = 0; i < listaGato.size(); i++) {
	    	if(listaGato.get(i).getId() == usuario1) {
	    		return listaGato.get(i); 
	    	}
	    }
	    
	    for(int i = 0; i < listaPerro.size(); i++) {
	    	if(listaPerro.get(i).getId() == usuario1) {
	    		return listaPerro.get(i); 
	    	}
	    }
		
	    return null;
	}
	
	public static AbstractMascotaSinSaludo conseguirVariableSS(int usuario1) {
		List<Pez> listaPez = datastore.find(Pez.class).asList();
		for(int i = 0; i < listaPez.size(); i++) {
			if(listaPez.get(i).getId() == usuario1) {
				return listaPez.get(i); 
			    }
			}

	    return null;
	}


}

