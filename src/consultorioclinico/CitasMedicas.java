package consultorioclinico;

import javax.swing.JOptionPane;

import java.awt.Component;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CitasMedicas {
	
	private ArrayList<Cita> Citas;
	
	//Instrucciones de gestores de doctor y pacientes
	private GestorDoctor doctores;
	private GestorPaciente pacientes;
	
	public void GestorCita (GestorDoctor gestDoc, GestorPaciente gestPaci) {
		citas = new ArrayList<Cita> ();
		doctores = gestDoc;
		pacientes = gestPaci;
	}
	
	public boolean nuevoCita() {
		String id = JOptionPane.showInputDialog(null, "Ingresa el ID de la cita: ","Nueva Cita", JOptionPane.QUESTION_MESSAGE);
		String fecha = JOptionPane.showInputDialog(null, "Fecha","Nueva fecha: ", JOptionPane.QUESTION_MESSAGE);
		String hora = JOptionPane.showInputDialog(null, "Hora: ","Nueva hora", JOptionPane.QUESTION_MESSAGE);
		String motivo = JOptionPane.showInputDialog(null, "Motivo: ","Nuevo Motivo", JOptionPane.QUESTION_MESSAGE);
		String iDdoctor = JOptionPane.showInputDialog(null, "ID del Doctor: ","Nuevo Doctor", JOptionPane.QUESTION_MESSAGE);
		String iDpaciente = JOptionPane.showInputDialog(null, "ID del Paciente: ","Nuevo Paciente", JOptionPane.QUESTION_MESSAGE);
		
		//Solicitar datos a los gestores que se tienen
		Doctor doctor = doctores.getDoctor(iDdoctor);
		Paciente paciente = pacientes.getPaciente (iDPaciente);
		
		Cita nuevoCita = new Cita (id, fecha, hora, motivo, iDdoctor, iDpaciente );
		return citas.add()nuevoCita;
		//Regresa True si se insertó correctamente, False si no se pudo insertar
	}	
}

class GestorDoctor {
	
	public void crearCSV() {
		
		File archivo = new File ("C:\\Users\\Ideapad\\eclipse-workspace\\ConsultorioClinico");
		
		try {
			//Si no existe archivo, intentamos crearlo
			boolean primeraVez = false;
			if (!archivo.exists()) {
				File carpeta = archivo.getParentFile();
				carpeta.mkdirs();
				archivo.createNewFile();
				primeraVez = true; 
				//Primera vez que trabajamos en este archivo
			}
			
			FileWriter escritor = new FileWriter (archivo, true);
			//encabezado para datos del CSV, sólo si es la primera vez
			if (primeraVez)
				escritor.append("#ID;Nombre;Apellidos;Especialidad\n");
			Component doctores;
			//Datos del ultimo doctor registrado
			int ultimo = doctores.size () - 1;
				escritor.append(((List<Cita>) doctores).get(ultimo) .generaLineaCSV());	//Insertar linea CSV
				
			escritor.close();		
		} catch (IOException e) {
			System.out.println("Error de acceso a: " + archivo.getAbsolutePath());
		}
	}
}

class GestorPasciente {
	
	private ArrayList <Pacientes>pacientes;
	
	public void crearCSV() {
		
		File archivo = new File ("C:\\Users\\Ideapad\\eclipse-workspace\\ConsultorioClinico");
		
		try {
			//Si no existe archivo, intentamos crearlo
			boolean primeraVez = false;
			if (!archivo.exists()) {
				File carpeta = archivo.getParentFile();
				carpeta.mkdirs();
				archivo.createNewFile();
				primeraVez = true; 
				//Primera vez que trabajamos en este archivo
			}
			
			FileWriter escritor = new FileWriter (archivo, true);
			//encabezado para datos del CSV, sólo si es la primera vez
			if (primeraVez)
				escritor.append("#ID;Nombre;Apellidos;Especialidad\n");
			//Datos del ultimo doctor registrado
			int ultimo = pacientes.size () - 1;
				escritor.append(pacientes.get(ultimo) .generaLineaCSV());	//Insertar linea CSV
				
			escritor.close();		
		} catch (IOException e) {
			System.out.println("Error de acceso a: " + archivo.getAbsolutePath());
		}
	}
}

class Citas {
	
	private String id;
	private String fecha;
	private String hora;
	private String motivo;
	private Doctor doctor;
	private Paciente paciente;
	
	public Citas (String id,String fecha, String hora, String motivo, Doctor doctor, Paciente paciente) {
		
		this.id = id;//
		this.fecha=fecha;//
		this.hora = hora;//
		this.motivo = motivo;//
		this.doctor = doctor;//
		this.paciente = paciente;//
	}
	
	public CharSequence generaLineaCSV() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getId () {
		return id;
	}
	
	public void setId (String id) {
		this.id = id;
	}
	
	public String getPacFecha () {
		return fecha;
	}
	
	public void setFecha (String fecha) {
		this.fecha=fecha;
	}
	
	public String getHora () {
		return hora;
	}
	
	public void setHora (String hora) {
		this.hora=hora;
	}
	
	public String getMotivo () {
		return motivo;
	}
	
	public void setMotivo (String motivo) {
		this.motivo=motivo;
	}
	
	public Doctor getDoctor () {
		return doctor;
	}
	
	public void setDoctor (Doctor doctor) {
		this.doctor = doctor;
	}
	
	public Paciente getPaciente () {
		return paciente;
	}
	
	public void setPaciente (Paciente paciente) {
		this.paciente=paciente;
	}
	
}

class Administrador {
	
	private String nombre;
	private String password;
	
	public Administrador (String nom, String pass) {
		nombre=nom;
		password=pass;
	}
	
	@Override
	public boolean equals (Object objeto) {
		if (objeto instanceof Administrador) { //objeto si es clase Administrador
			//Castear objeto a Administrador
			Administrador otroAdmin=(Administrador)objeto;
			//Comparamos si coinciden nombre y password
			if (nombre.equals(otroAdmin.nombre) && password.equals(otroAdmin.password))
				return true; //Coinciden ambos, los objetos representan al mismo Administrador
			else
				return false; //Nombre o contraseña no coinciden, son Administradores diferentes.
			}
		else //
			return false;
	}
}

class Paciente {
	
	private String id;
	private String nombre;
	private String apellidos;
	
	public String generaLineaCSV() {
		return String.format("%s;%s;%s;%s\n", id, nombre, apellidos);
	}
	
	public Paciente (String id, String nombre, String apellidos) {
		this.id=id;
		this.nombre=nombre;
		this.apellidos=apellidos;
	}
}

class Doctor {
	
	private String id;
	private String nombre;
	private String apellidos;
	private String especialidad;
	
		public Doctor (String id, String nombre, String apellidos, String especialidad) {
		this.id=id;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.especialidad=especialidad;
	}
		
		public String getId () {
			return id;
		}
		
		public void setId (String id) {
			this.id = id;
		}
		
		public String getNombre () {
			return nombre;
		}
		
		public void setNombre (String nombre) {
			this.nombre=nombre;
		}
		
		public String getApellidos () {
			return apellidos;
		}
		
		public void setApellidos (String apellidos) {
			this.apellidos=apellidos;
		}
		
		public String getespecialidad () {
			return especialidad;
		}
		
		public void setEspecialidad (String especialidad) {
			this.especialidad=especialidad;
		}
		
		/****	Muestra el panel de todos los doctores	****/
		
		public void mostrar() {
			String mensaje = "ID doctor: "+ id + "\nNombre: " + nombre + "\nApellidos: " + apellidos + "\nEspecialidad: " + especialidad;
			JOptionPane.showMessageDialog(null, mensaje, "Mostrar doctor", JOptionPane.INFORMATION_MESSAGE);
		}
		
		public Doctor getDoctor (String id) {
			for (Doctor doc: doctores)
				if (doc.getId().equals(id))
					return doc; //Doctor encontrado
			//Si el bucle no ha retornado ningún Doctor, es que no existe se ID
			return null;
		}
		
}



	//MINUTO 9:54


