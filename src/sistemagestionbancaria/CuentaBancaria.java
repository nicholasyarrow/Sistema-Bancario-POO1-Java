/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemagestionbancaria;
/**
 *
 * @author byvel
 */
public class CuentaBancaria {
    private String nombre;
    private String apellido;
    private String dni;
    private String celular;
    private String direccion;
    private double balance;
    private double prestamo;
    //atributos para el log in del usuario
    private String usuario;
    private String pin;
    
    //constructor
    public CuentaBancaria(String nombre, String apellido, String dni, String celular, String direccion, String usuario, String pin, double balance, double prestamo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.celular = celular;
        this.direccion = direccion;
        this.usuario = usuario;
        this.pin = pin;
        this.balance=balance;// Nuevo balance al crear la cuenta
        this.prestamo=prestamo;
    }
    
    //metodos de set y get

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(double prestamo) {
        this.prestamo = prestamo;
    }
    
    // Metodo que retorna una representación en String para los objetos de cuenta bancaria
    public String aFormatoArchivo() {
    return String.format(
        "%s,%s,%s,%s,%s,%s,%s,%s,%s",
        this.nombre, this.apellido, this.dni, this.celular, this.direccion, this.usuario, this.pin, this.balance, this.prestamo);
    }

    
    // Métodos para manejar el balance
    public void depositar(double cantidad) {
        balance += cantidad;
    }

    public void retirar(double cantidad) {
        if (cantidad <= balance) {
            balance -= cantidad;
        } else {
            // Manejo de caso en el que no hay suficiente saldo
            System.out.println("Saldo insuficiente");
        }
    }

}
