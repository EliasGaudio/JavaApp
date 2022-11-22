package interfaz;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

import org.bson.Document;

import animales.Gato;
import animales.Pajaro;
import animales.Perro;
import animales.Pez;
import api.Conexion;

import java.awt.*;
import java.awt.event.*;


public class InterfazGrafica {
		private JFrame frame;
		private int exito;
		private String saludo;
	    
	    
	    public InterfazGrafica(JFrame framur) {
	    	frame = framur;
	    	exito = 0;
	    }
	   
	    public static void main(String[] argum) {
	    	JFrame frame = new JFrame("Tp");
	        InterfazGrafica si = new InterfazGrafica(frame);
	        si.pantallaPrincipal();

	    }
	    
	    
	    public void pantallaPrincipal() {
	    	JPanel panel = new JPanel();
	    	JButton button = new JButton();
	    	JButton button2 = new JButton();
	    	JButton button3 = new JButton();
	    	JButton button4 = new JButton();
	    	JButton button5 = new JButton();
	    	button.setText("Alta de Mascota");
	        button2.setText("Baja de Mascota");
	        button3.setText("Modificar Mascota");
	        button4.setText("Saludar");
	        button5.setText("Alimentar");
	        panel.setLayout(new FlowLayout());
	        button.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e){
	            	panel.removeAll();
	            	pantallaAltaMascota();
	            }
	        });
	        button2.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e){
	            	panel.removeAll();
	            	pantallaBajaMascota();
	            }
	        });
	        button3.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e){
	            	panel.removeAll();
	            	pantallaModificarMascota();
	            }
	        });
	        button4.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e){
	            	panel.removeAll();
	            	pantallaSaludar();
	            }
	        });
	        button5.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e){
	            	panel.removeAll();
	            	pantallaAlimentar();
	            }
	        });
	        panel.add(button);
	        panel.add(button2);
	        panel.add(button3);
	        panel.add(button4);
	        panel.add(button5);
	        if(exito == 1) {
	        	JLabel label = new JLabel("Exito en la operacion");
	        	panel.add(label);
	        }
	        else if(exito == 2) {
	        	JLabel label = new JLabel("Error en la operacion");
	        	panel.add(label);
	        }
	        else if(exito == 3) {
	        	JLabel label = new JLabel(this.saludo);
	        	panel.add(label);
	        }
	        frame.add(panel);
	        frame.setSize(500, 500);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	        
	    }
	    
	    
	    public void pantallaAltaMascota() {
	    	JPanel panel = new JPanel();
	    	JButton button = new JButton();
	    	final String[] texto = {new String()};
	    	final String[] texto2 = {new String()};
	    	final String[] texto3 = {new String()};
	    	final String[] texto4 = {new String()};
	    	final JTextField t1 = new JTextField("Nombre de la Mascota");
	        t1.setBounds(50,100, 200,30);
	    	final JTextField t2 = new JTextField("Nombre del Dueño");
	        t2.setBounds(50,100, 200,30);
	    	final JTextField t3 = new JTextField("Tipo de Mascota");
	        t3.setBounds(50,100, 200,30);
	        final JTextField t4 = new JTextField("Id Mascota");
	        t4.setBounds(50,100, 200,30);
	    	button.setText("Ingresar");
	        panel.setLayout(new FlowLayout());
	        button.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e){
	            	texto[0] = t1.getText();
	            	texto2[0] = t2.getText();
	            	texto3[0] = t3.getText();
	            	
	            	texto4[0] = t4.getText();
	            	int b = Integer.parseInt(texto4[0]);
	            	altaDeMascota(texto[0], texto2[0], texto3[0], b);
	            	panel.removeAll();
	            	pantallaPrincipal();
	            }
	        });
	        panel.add(button);
	        panel.add(t1);
	        panel.add(t2);
	        panel.add(t3);
	        panel.add(t4);
	        frame.add(panel);
	        frame.setSize(500, 500);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	    }
	    
	    public void pantallaBajaMascota() {
	    	JPanel panel = new JPanel();
	    	JButton button = new JButton();
	    	final String[] texto = {new String()};
	    	final JTextField t1 = new JTextField("ID de la Mascota");
	        t1.setBounds(50,100, 200,30);
	    	button.setText("Ingresar");
	        panel.setLayout(new FlowLayout());
	        button.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e){
	            	texto[0] = t1.getText();
	    			int b = Integer.parseInt(texto[0]);
	    			bajaDeMascota(b);
	            	panel.removeAll();
	            	pantallaPrincipal();
	            }
	        });
	        panel.add(button);
	        panel.add(t1);
	        frame.add(panel);
	        frame.setSize(500, 500);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	    }
	    
	    public void pantallaAlimentar() {
	    	JPanel panel = new JPanel();
	    	JButton button = new JButton();
	    	final String[] texto = {new String()};
	    	final JTextField t1 = new JTextField("ID de la Mascota");
	        t1.setBounds(50,100, 200,30);
	    	button.setText("Alimentar");
	        panel.setLayout(new FlowLayout());
	        button.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e){
	            	texto[0] = t1.getText();
	    			int b = Integer.parseInt(texto[0]);
	    			Conexion.alimentar(b);
	            	panel.removeAll();
	            	pantallaPrincipal();
	            }
	        });
	        panel.add(button);
	        panel.add(t1);
	        frame.add(panel);
	        frame.setSize(500, 500);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	    }
	    
	    public void pantallaModificarMascota() {
	    	JPanel panel = new JPanel();
	    	JButton button = new JButton();
	    	final String[] texto = {new String()};
	    	final String[] texto2 = {new String()};
	    	final String[] texto3 = {new String()};
	    	final JTextField t1 = new JTextField("ID de la Mascota");
	    	final JTextField t2 = new JTextField("Parametro a Modificar");
	    	final JTextField t3 = new JTextField("Valor a Ingresar");
	        t1.setBounds(50,100, 200,30);
	    	button.setText("Ingresar");
	        panel.setLayout(new FlowLayout());
	        button.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e){
	            	texto[0] = t1.getText();
	            	texto2[0] = t2.getText();
	            	texto3[0] = t3.getText();
	    			int b = Integer.parseInt(texto[0]);
	    			modificar(b, texto2[0], texto3[0]);
	            	panel.removeAll();
	            	pantallaPrincipal();
	            }
	        });
	        panel.add(button);
	        panel.add(t1);
	        panel.add(t2);
	        panel.add(t3);
	        frame.add(panel);
	        frame.setSize(500, 500);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	    }
	    
	    public int altaDeMascota(String nombreM, String nombreD, String tipo, int id) {
			switch (tipo)
			{
			     case "Perro":
			    	 Perro perro1 = new Perro(nombreM, nombreD, id);
			    	 Conexion.insertarPerro(perro1);
			    	 this.exito = 1;
			    	 return 1;
			     case "Gato":
			    	 Gato gato1 = new Gato(nombreM, nombreD, id);
			    	 Conexion.insertarGato(gato1);
			    	 this.exito = 1;
			    	 return 1;
			     
			     case "Pez":
			    	 Pez pez1 = new Pez(nombreM, nombreD, id);
			    	 Conexion.insertarPez(pez1);
			    	 this.exito = 1;
			    	 return 1;
			     
			     case "Pajaro":
			    	 Pajaro pajaro1 = new Pajaro(nombreM, nombreD, id);
			    	 Conexion.insertarPajaro(pajaro1);
			    	 this.exito = 1;
			    	 return 1;
				 
			    default:
			    System.out.println("err");
			    this.exito = 2;
			    return 2;
			     
			}
			
			
		}
	    
	    public void pantallaSaludar() {
	    	JPanel panel = new JPanel();
	    	JButton button = new JButton();
	    	final String[] texto = {new String()};
	    	final JTextField t1 = new JTextField("Nombre de la Mascota a Saludar");
	    	final String[] texto2 = {new String()};
	    	final JTextField t2 = new JTextField("Nombre del Saludador");
	        t1.setBounds(50,100, 200,30);
	        t2.setBounds(50,100, 200,30);
	    	button.setText("Ingresar");
	        panel.setLayout(new FlowLayout());
	        button.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e){
	            	texto[0] = t1.getText();
	            	texto2[0] = t2.getText();
	    			Saludar(texto[0], texto2[0]);
	            	panel.removeAll();
	            	pantallaPrincipal();
	            }
	        });
	        panel.add(button);
	        panel.add(t1);
	        panel.add(t2);
	        frame.add(panel);
	        frame.setSize(500, 500);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
			
			
		}
		
		public int bajaDeMascota(int id) {
			try {
				Conexion.eliminarAnimal(id);
				this.exito = 1;
				return 1;
			}
			catch(Exception e){
				System.out.println(e);
				this.exito = 2;
				return 2;
			}
			
		}
		
		public int modificar(int id, String parametro, String valor) {
			try {
				Conexion.modificarAnimal(id, valor, parametro);
				this.exito = 1;
				return 1;
			}
			catch(Exception e){
				System.out.println(e);
				this.exito = 2;
				return 2;
			}
		}
		
		public String Saludar(String nombreAnimal, String saludador) {
			String saludo = "";
			
			String nombreDueno = new String();
			int alegria = 0;
			Boolean boolDueno = false;
			int id = Conexion.encontrarIdPorNombre(nombreAnimal);
			
			try { 
				String tipo = Conexion.encontrarTipo(id);
				switch (tipo)
				{
				     case "Perro":
				    	 nombreDueno = Conexion.conseguirVariableCS(id).getNombreDueno();
				    	 alegria = Conexion.conseguirVariableCS(id).getAlegria();
				    	 boolDueno = Conexion.conseguirVariableCS(id).Saludar(saludador);
				    	 break;
				    	 
				     case "Gato":
				    	 nombreDueno = Conexion.conseguirVariableCS(id).getNombreDueno();
				    	 alegria = Conexion.conseguirVariableCS(id).getAlegria();
				    	 boolDueno = Conexion.conseguirVariableCS(id).Saludar(saludador);
				    	 break;
				     
				     case "Pez":
				    	 nombreDueno = Conexion.conseguirVariableSS(id).getNombreDueno();
				    	 boolDueno = Conexion.conseguirVariableSS(id).Saludar( saludador);
				    	 break;
				     
				     case "Pajaro":
				    	 nombreDueno = Conexion.conseguirVariableCS(id).getNombreDueno();
				    	 alegria = Conexion.conseguirVariableCS(id).getAlegria();
				    	 boolDueno = Conexion.conseguirVariableCS(id).Saludar(saludador);
				    	 break;
					 
				    default:
				    System.out.println("err");
				    this.exito = 2;
				    return "2";
				     
				}
				System.out.println(boolDueno);
				System.out.println(nombreDueno);
				if(boolDueno ) {
					System.out.println("si");
					for(int i = 0;  alegria >= i; i++) {
						System.out.println("si");
						switch (tipo)
						{
						     case "Perro":
						    	 saludo = saludo + "guau";
						    	 break;
						    	 
						     case "Gato":
						    	 saludo = saludo + "miau";
						    	 break;
						     
						     case "Pez":
						    	 Conexion.quitarVida(id);
						    	 break;
						     
						     case "Pajaro":
						    	 saludo = saludo + "pio";
						    	 break;
							 
						    default:
						    System.out.println("err");
						    this.exito = 2;
						    return "2";
						     
						}
						
					}
				}
				else {
					System.out.println("si");
					for(int i = 0; alegria >= i; i++) {
						System.out.println("si");
						switch (tipo)
						{
						     case "Perro":
						    	 saludo = saludo + "GUAU!";
						    	 break;
						    	 
						     case "Gato":
						    	 saludo = saludo + "MIAU!";
						    	 break;
						     
						     case "Pez":
						    	 Conexion.eliminarAnimal(id);
						    	 break;
						     
						     case "Pajaro":
						    	 
						    	 break;
							 
						    default:
						    System.out.println("err");
						    this.exito = 2;
						    return "2";
						     
						}
						
					}
				}

			}
			catch(Exception e){
				System.out.println(e);
				this.exito = 2;
				return "2";
			}
			this.saludo = saludo;
			this.exito = 3;
			return saludo;
			
		}
	    
	    

	}

