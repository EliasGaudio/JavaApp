package animales;

public class Pajaro extends AbstractMascotaConSaludo {

	public Pajaro(String nombreMascota2, String nombreDueno2, int id){
	    setNombreMascota(nombreMascota2);
	    setNombreDueno(nombreDueno2);
	    setId(id);
	}
	
	public Pajaro(){
	    setNombreMascota("Kestril");
	    setNombreDueno("Annuni");
	    setId(6);
	}
	

}
