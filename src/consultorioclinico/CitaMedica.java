package consultorioclinico;
/*****
public class CitaMedica {

}
****/

import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CitaMedica {

    private ArrayList<Cita> citas;
    private GestorDoctor gestorDoctores;
    private GestorPaciente gestorPacientes;
    private Administrador admin;

    public CitaMedica(GestorDoctor gestorDoctores, GestorPaciente gestorPacientes, Administrador admin) {
        this.citas = new ArrayList<>();
        this.gestorDoctores = gestorDoctores;
        this.gestorPacientes = gestorPacientes;
        this.admin = admin;
    }

    public void iniciarSistema() {
        String usuario = JOptionPane.showInputDialog(null, "Ingrese el usuario: ");
        String password = JOptionPane.showInputDialog(null, "Ingrese la contraseña: ");

        if (admin.autenticar(usuario, password)) {
            menuPrincipal();
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no autorizado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void menuPrincipal() {
        String[] opciones = {"Dar de alta doctor", "Dar de alta paciente", "Crear cita", "Salir"};
        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú Principal",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

        switch (seleccion) {
            case 0:
                gestorDoctores.registrarDoctor();
                break;
            case 1:
                gestorPacientes.registrarPaciente();
                break;
            case 2:
                nuevaCita();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public void nuevaCita() {
        String id = JOptionPane.showInputDialog(null, "Ingresa el ID de la cita: ", "Nueva Cita", JOptionPane.QUESTION_MESSAGE);
        String fecha = JOptionPane.showInputDialog(null, "Fecha: ", "Nueva fecha", JOptionPane.QUESTION_MESSAGE);
        String hora = JOptionPane.showInputDialog(null, "Hora: ", "Nueva hora", JOptionPane.QUESTION_MESSAGE);
        String motivo = JOptionPane.showInputDialog(null, "Motivo: ", "Nuevo Motivo", JOptionPane.QUESTION_MESSAGE);
        String iDdoctor = JOptionPane.showInputDialog(null, "ID del Doctor: ", "Nuevo Doctor", JOptionPane.QUESTION_MESSAGE);
        String iDpaciente = JOptionPane.showInputDialog(null, "ID del Paciente: ", "Nuevo Paciente", JOptionPane.QUESTION_MESSAGE);

        Doctor doctor = gestorDoctores.getDoctor(iDdoctor);
        Paciente paciente = gestorPacientes.getPaciente(iDpaciente);

        if (doctor != null && paciente != null) {
            Cita nuevaCita = new Cita(id, fecha, hora, motivo, doctor, paciente);
            citas.add(nuevaCita);
            JOptionPane.showMessageDialog(null, "Cita registrada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Doctor o Paciente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        GestorDoctor gestorDoctores = new GestorDoctor();
        gestorDoctores.crearCSV(); // Crear CSV de doctores

        GestorPaciente gestorPacientes = new GestorPaciente();
        gestorPacientes.crearCSV(); // Crear CSV de pacientes

        Administrador admin = new Administrador("admin", "password");
        CitaMedica sistema = new CitaMedica(gestorDoctores, gestorPacientes, admin);

        sistema.iniciarSistema();
    }
}

class GestorDoctor {

	public void crearCSV() {
		// TODO Auto-generated method stub
		
	}
    // Implementación del GestorDoctor
    // ...

	public void registrarDoctor() {
		// TODO Auto-generated method stub
		
	}

	public Doctor getDoctor(String iDdoctor) {
		// TODO Auto-generated method stub
		return null;
	}
}

class GestorPaciente {

	public void crearCSV() {
		// TODO Auto-generated method stub
		
	}
    // Implementación del GestorPaciente
    // ...

	public void registrarPaciente() {
		// TODO Auto-generated method stub
		
	}

	public Paciente getPaciente(String iDpaciente) {
		// TODO Auto-generated method stub
		return null;
	}
}

class Cita {
    // Implementación de la clase Cita
    // ...
}

class Administrador {
    private String nombre;
    private String password;

    public Administrador(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    public boolean autenticar(String identificador, String contraseña) {
        return this.nombre.equals(identificador) && this.password.equals(contraseña);
    }
}

class Paciente {
    // Implementación de la clase Paciente
    // ...
}

class Doctor {
    // Implementación de la clase Doctor
    // ...
}