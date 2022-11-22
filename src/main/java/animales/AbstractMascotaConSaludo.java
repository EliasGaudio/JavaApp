package animales;

public abstract class AbstractMascotaConSaludo extends AbstractMascota {
    private String nombreMascota;
    private String nombreDueno;
    private int alegria;
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
	public int alimentar() {
		return 1;
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
	
	public int getAlegria() {
		return alegria;
	}
	public void setAlegria(int alegria) {
		this.alegria = alegria;
	}
}
