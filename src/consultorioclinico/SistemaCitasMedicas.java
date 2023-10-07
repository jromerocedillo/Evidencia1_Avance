package consultorioclinico;

//public class ConsultorioClinico {

//}

import java.util.*;

class Doctor {
    private String nombre;
    private String especialidad;

    public Doctor(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public String toString() {
        return "Doctor: " + nombre + " (Especialidad: " + especialidad + ")";
    }
}

class Paciente {
    private String nombre;

    public Paciente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Paciente: " + nombre;
    }
}

class Cita {
    private Date fechaHora;
    private Doctor doctor;
    private Paciente paciente;

    public Cita(Date fechaHora, Doctor doctor, Paciente paciente) {
        this.fechaHora = fechaHora;
        this.doctor = doctor;
        this.paciente = paciente;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    @Override
    public String toString() {
        return "Cita el " + fechaHora + " con " + doctor.getNombre() + " para " + paciente.getNombre();
    }
}

class Administrador {
    private String identificador;
    private String contraseña;

    public Administrador(String identificador, String contraseña) {
        this.identificador = identificador;
        this.contraseña = contraseña;
    }

    public boolean autenticar(String identificador, String contraseña) {
        return this.identificador.equals(identificador) && this.contraseña.equals(contraseña);
    }
}

public class SistemaCitasMedicas {
    private Map<String, Doctor> doctores;
    private Map<String, Paciente> pacientes;
    private List<Cita> citas;
    private List<Administrador> administradores;

    public SistemaCitasMedicas() {
        doctores = new HashMap<>();
        pacientes = new HashMap<>();
        citas = new ArrayList<>();
        administradores = new ArrayList<>();
    }

    public void agregarDoctor(Doctor doctor) {
        doctores.put(doctor.getNombre(), doctor);
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.put(paciente.getNombre(), paciente);
    }

    public void crearCita(Date fechaHora, Doctor doctor, Paciente paciente) {
        citas.add(new Cita(fechaHora, doctor, paciente));
    }

    public void relacionarCitaConDoctorPaciente(Cita cita, Doctor doctor, Paciente paciente) {
        cita = new Cita(cita.getFechaHora(), doctor, paciente);
    }

    public void agregarAdministrador(Administrador administrador) {
        administradores.add(administrador);
    }

    public boolean autenticarAdministrador(String identificador, String contraseña) {
        for (Administrador admin : administradores) {
            if (admin.autenticar(identificador, contraseña)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SistemaCitasMedicas sistema = new SistemaCitasMedicas();

        // Crear doctores y pacientes
        Doctor doctor1 = new Doctor("Dr. José Sanchez", "Traumatología");
        Doctor doctor2 = new Doctor("Dr. Alexis Vega", "Pediatría");
        Doctor doctor3 = new Doctor("Dr. Amauri Vergara", "Podología");
        Paciente paciente1 = new Paciente("David Hernandez");
        Paciente paciente2 = new Paciente("Elias Gómez");
        Paciente paciente3 = new Paciente("Javier Soto");

        sistema.agregarDoctor(doctor1);
        sistema.agregarDoctor(doctor2);
        sistema.agregarDoctor(doctor3);
        sistema.agregarPaciente(paciente1);
        sistema.agregarPaciente(paciente2);
        sistema.agregarPaciente(paciente3);

        // Crear una cita
        Calendar cal = Calendar.getInstance();
        cal.set(2023, Calendar.OCTOBER, 30, 10, 0); // Fecha y hora de la cita: 30 de Septiembre de 2023 a las 10:00 AM
        Date fechaHoraCita = cal.getTime();

        sistema.crearCita(fechaHoraCita, doctor1, paciente1);

        // Relacionar una cita con un doctor y un paciente
        Cita cita = sistema.citas.get(0);
        Doctor nuevoDoctor = doctor2;
        Paciente nuevoPaciente = paciente2;

        sistema.relacionarCitaConDoctorPaciente(cita, nuevoDoctor, nuevoPaciente);

        // Agregar administrador
        Administrador admin = new Administrador("admin", "password");
        sistema.agregarAdministrador(admin);

        // Autenticar administrador
        if (sistema.autenticarAdministrador("admin", "password")) {
            System.out.println("Administrador autenticado.");
        } else {
            System.out.println("Error de autenticación.");
        }
    }
}
