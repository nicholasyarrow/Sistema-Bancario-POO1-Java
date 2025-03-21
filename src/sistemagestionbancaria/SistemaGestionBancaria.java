/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemagestionbancaria;


/**
 *
 * @author byvel
 * 
 */
/**
 * Esta aplicación de gestión bancaria permite a los usuarios realizar operaciones bancarias
 * como registro de cuentas, depósitos, retiros y consultas de saldo.
 * 
 * Características:
 * - Registro de cuentas bancarias con información personal y acceso seguro.
 * - Realización de transacciones: depósitos, retiros y consultas de saldo.
 * - Interfaz gráfica intuitiva para la interacción del usuario.
 * - Gestión de sesiones para múltiples usuarios.
 */
public class SistemaGestionBancaria {

    /**
     * Punto de entrada de la aplicación.
     * Carga las cuentas existentes desde el archivo y muestra la ventana de inicio de sesión.
     * 
     * @param args Los argumentos de la línea de comandos (no se utilizan en esta aplicación)
     */
    public static void main(String[] args) {
        // Cargar cuentas bancarias existentes desde el archivo al iniciar la aplicación
        SessionManager.cargarCuentasDesdeArchivo();
        
        // Mostrar la ventana de inicio de sesión para que los usuarios accedan a sus cuentas
        LogIn logIn=new LogIn();
        logIn.setVisible(true);
    }
    
}
