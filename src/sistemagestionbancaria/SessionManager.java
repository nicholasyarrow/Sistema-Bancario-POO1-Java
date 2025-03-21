/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemagestionbancaria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author byvel
 */
/**
 * Clase encargada de administrar la sesión y las operaciones de las cuentas bancarias.
 */
public class SessionManager {
    private static String usuarioActual;
    private static ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
    
    //constructor 
    public SessionManager() {
    }
    
    //metodos de set y get
    public static String getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(String usuario) {
        usuarioActual = usuario;
    }

    public static ArrayList<CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public static void setCuentas(ArrayList<CuentaBancaria> cuentas) {
        SessionManager.cuentas = cuentas;
    }
    /**
     * Carga las cuentas bancarias desde el archivo "cuentas.txt" al ArrayList de cuentas.
     */
    public static void cargarCuentasDesdeArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("cuentas.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");

                // Verificar si hay suficientes elementos en la línea
                if (partes.length >= 9) { // Ajustado a 9 elementos para incluir el prestamo
                    // Extracción de datos
                    String nombre = partes[0];
                    String apellido = partes[1];
                    String dni = partes[2];
                    String celular = partes[3];
                    String direccion = partes[4];
                    String usuario = partes[5];
                    String pin = partes[6];
                    double balance = Double.parseDouble(partes[7]);
                    double prestamo = Double.parseDouble(partes[8]); 

                    // Creación de la instancia de CuentaBancaria
                    CuentaBancaria cuenta = new CuentaBancaria(nombre, apellido, dni, celular, direccion, usuario, pin, balance, prestamo);
                    cuentas.add(cuenta);
                } else {
                    // Manejo de líneas con datos incompletos
                    System.out.println("Error: Datos incompletos en una línea del archivo.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de excepciones al leer el archivo
        }
    }

    /**
     * Obtiene la cuenta bancaria asociada al usuario actual.
     *
     * @return La cuenta bancaria del usuario actual o null si no se encuentra.
     */
    public static CuentaBancaria obtenerCuentaUsuarioActual() {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getUsuario().equals(usuarioActual)) {
                return cuenta; // Retorna la cuenta del usuario actual
            }
        }
        return null; // Si no se encuentra la cuenta del usuario actual
    }
}
