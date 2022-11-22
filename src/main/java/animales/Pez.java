package animales;

public class Pez extends AbstractMascotaSinSaludo {

	public Pez(String nombreMascota2, String nombreDueno2, int id){
	    setNombreMascota(nombreMascota2);
	    setNombreDueno(nombreDueno2);
	    setId(id);
	}
	public Pez(){
	    setNombreMascota("Karol");
	    setNombreDueno("Kisil");
	    setId(5);
	}
}
