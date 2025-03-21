/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemagestionbancaria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author byvel
 */
public class RegistroTransacciones {
    /**
     * Guarda una transacción en el archivo "transacciones.txt".
     *
     * @param usuario El nombre del usuario involucrado en la transacción.
     * @param tipo    El tipo de transacción (por ejemplo, "depósito" o "retiro").
     * @param monto   El monto involucrado en la transacción.
     */
    public static void guardarTransaccion(String usuario, String tipo, double monto) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transacciones.txt", true))) {
            String registro = usuario + "," +
                              tipo + "," +
                              monto + "\n";

            writer.write(registro);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     /**
     * Obtiene todas las transacciones asociadas a un usuario específico.
     *
     * @param usuario El nombre del usuario del cual se desean obtener las transacciones.
     * @return Una lista de cadenas que representan las transacciones del usuario.
     */
    public static List<String> obtenerTransaccionesPorUsuario(String usuario) {
        List<String> transacciones = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("transacciones.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                String usuarioRegistro = partes[0];
                String tipo = partes[1];
                double monto = Double.parseDouble(partes[2]);

                if (usuarioRegistro.equals(usuario)) {
                    String transaccion = "Usuario: " + usuarioRegistro + ", Tipo: " + tipo + ", Monto: " + monto;
                    transacciones.add(transaccion);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transacciones;
    }
}
