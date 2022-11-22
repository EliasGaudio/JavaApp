package animales;

public class AbstractMascotaSinSaludo extends AbstractMascota  {
    private String nombreMascota;
    private String nombreDueno;
    private int vidas;
	public String getNombreMascota() {
		return nombreMascota;
	}
	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}
	public String getNombreDueno() {
		return nombreDueno;
	}
	public void setNombreDueno(String nombreDueno) {
		this.nombreDueno = nombreDueno;
	}
	
	public boolean Saludar( String saludador) {
		System.out.println(nombreDueno);
		System.out.println(saludador);
		if(nombreDueno.contentEquals(saludador)) {
			System.out.println(nombreDueno.contentEquals(saludador));
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getVidas() {
		return vidas;
	}
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
}

