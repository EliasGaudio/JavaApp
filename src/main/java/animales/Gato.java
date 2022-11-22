package animales;

public class Gato extends AbstractMascotaConSaludo {

	public Gato(){
	    int id = 0;
	    String nombreMascota = "Ambiramus";
	    String nombreDueno = "Epona";
	}

	public Gato(String nombreMascota2, String nombreDueno2, int id){
	    setNombreMascota(nombreMascota2);
	    setNombreDueno(nombreDueno2);
	    setId(id);
	}
}
