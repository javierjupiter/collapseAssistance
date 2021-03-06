import java.sql.Connection;
import java.util.Scanner;

public class Formulario_Justificante_empelados {
    private String cadena;
    private Scanner leer = new Scanner(System.in);
    private Validaciones validaciones;
    private Connection connection;
    private Justificante_empelados justificanteEmpelados;
    private BD_Inserciones inserciones;//esta


    public Formulario_Justificante_empelados(Connection connection) {//estoooooooooooooooooooooo
        validaciones = new Validaciones();
        this.connection = connection; //esta
        inserciones = new BD_Inserciones(); //esta

    }

    public Formulario_Justificante_empelados() {
        validaciones = new Validaciones();
    }

    public void Formulario_Justificante_empelados  () {
        justificanteEmpelados = new Justificante_empelados();
        System.out.println("Justificante empleados:");

        do {
            System.out.println("Escriba la clave del empleado: ");
            cadena = leer.nextLine();
        } while (!validaciones.validarClave(cadena));
        justificanteEmpelados.setClave_Empleado(cadena);
        System.out.println("El get guardo:" + justificanteEmpelados.getClave_Empleado());


        do {
            System.out.println("¿Cuál es la fecha de incidencia?");
            cadena = leer.nextLine();
        } while (!validaciones.validarFecha(cadena));
        justificanteEmpelados.setFecha(Integer.parseInt(cadena.substring(0, 4)), Integer.parseInt(cadena.substring(5, 7)), Integer.parseInt(cadena.substring(8, 10)));
        System.out.println("El get guardo:" + justificanteEmpelados.getFecha_Incidencia());

        do {
            System.out.println("Escriba el ID del justificante: ");
            cadena = leer.nextLine();
        } while (!validaciones.validarBiometrico(cadena));
        justificanteEmpelados.setID_Tipo_Justificante(cadena);
        System.out.println("El get guardo:" + justificanteEmpelados.getID_Tipo_Justificante());

        do {
            System.out.println("Escriba el Status('A' 'I'): ");
            cadena = leer.nextLine();
        } while (!validaciones.validarEstatus(cadena));
        justificanteEmpelados.setStatus_Justificante(cadena);
        System.out.println("El get guardo:" + justificanteEmpelados.getStatus_Justificante());

        inserciones.hacerInsercionJustificantesEmpleados(connection, justificanteEmpelados.getClave_Empleado(), justificanteEmpelados.getFecha_Incidencia(), justificanteEmpelados.getID_Tipo_Justificante(), justificanteEmpelados.getStatus_Justificante());


    }
}
