package animales;

public class Perro extends AbstractMascotaConSaludo {

	public Perro(){
	    setId(0);
	    setNombreMascota("Ategelbalto");
	    setNombreDueno("Romuleo");
	}
	public Perro(int id2, String nombreMascota2, String nombreDueno2){
	    setId(id2);
	    setNombreMascota(nombreMascota2);
	    setNombreDueno(nombreDueno2);
	}
	public Perro(String nombreMascota2, String nombreDueno2, int id){
	    setNombreMascota(nombreMascota2);
	    setNombreDueno(nombreDueno2);
	    setId(id);
	}
}
