package api;



import static spark.Spark.get;
import static spark.Spark.put;
import static spark.Spark.delete;
import static spark.Spark.post;

import org.bson.Document;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.google.gson.Gson;

import animales.Gato;
import animales.Pajaro;
import animales.Perro;
import animales.Pez;


public class Takiego {

	public static Conexion conexion= new Conexion();

	public static void main(String[] args) {

		Gson gson = new Gson();

		// el pepe (devuelve el pepe)
		get("/elpepe", (req, res) -> {
			res.type("application/json");
			return "elpepe";
		}, gson::toJson);
		
		post("/agregarGato", (req, res) -> {
			res.type("application/json");
			Gato animal = gson.fromJson(req.body(), Gato.class);
			return Conexion.insertarGato(animal);
		}, gson::toJson);
		
		post("/agregarPajaro", (req, res) -> {
			res.type("application/json");
			Pajaro animal = gson.fromJson(req.body(), Pajaro.class);
			return Conexion.insertarPajaro(animal);
		}, gson::toJson);
		
		post("/agregarPerro", (req, res) -> {
			System.out.println("si");
			res.type("application/json");
			Perro animal = gson.fromJson(req.body(), Perro.class);
			return Conexion.insertarPerro(animal);
		}, gson::toJson);
		
		post("/agregarPez", (req, res) -> {
			res.type("application/json");
			Pez animal = gson.fromJson(req.body(), Pez.class);
			return Conexion.insertarPez(animal);
		}, gson::toJson);
		
		put("/altaMascota", (req, res) -> {
			res.type("application/json");
			Document informacion = gson.fromJson(req.body(), Document.class);
			
			switch ( (String) informacion.get("tipo") )
			{
			     case "Perro":
			    	 Perro perro1 = new Perro((int)informacion.get("id"), (String) informacion.get("nombreMascota"), (String) informacion.get("nombreDueno"));
					return Conexion.insertarPerro(perro1);
					
			     case "Gato":
			    	Gato gato1 = new Gato( (String) informacion.get("nombreMascota"), (String) informacion.get("nombreDueno"), (int)informacion.get("id"));
					return Conexion.insertarGato(gato1);
			    	
			     case "Pez":
			    	Pez pez1 = new Pez( (String) informacion.get("nombreMascota"), (String) informacion.get("nombreDueno"), (int)informacion.get("id"));
					return Conexion.insertarPez(pez1);
			    	 
			    	 
			     
			     case "Pajaro":
			    	Pajaro pajaro1 = new Pajaro( (String) informacion.get("nombreMascota"), (String) informacion.get("nombreDueno"), (int)informacion.get("id"));
					return Conexion.insertarPajaro(pajaro1);
			    	 
				 
			    default:
			    	
			    System.out.println("err");
			    return null;
			    
			     
			}
			
		}, gson::toJson);
		
		delete("/bajaMascota", (req, res) -> {
			res.type("application/json");
			int id = gson.fromJson(req.body(), int.class);
			return Conexion.eliminarAnimal(id);
			
		}, gson::toJson);
		
		post("/modificarMascota", (req, res) -> {
			res.type("application/json");
			Document informacion = gson.fromJson(req.body(), Document.class);
			return Conexion.modificarAnimal( (int) informacion.get("idAnimal"), (String) informacion.get("valor"), (String) informacion.get("variable"));
			
		}, gson::toJson);
		


	}

}