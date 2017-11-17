package CapaControlador;

import Cliente.Cliente;
import javax.swing.JOptionPane;

public class Controlador {

    public Controlador() {
    }
    public static final int Constante = 3;
    public static int contador = 0;

    public static final Cliente clientes_credito[] = new Cliente[Constante];
    public static final Cliente clientes_on[] = new Cliente[Constante];
    public static final Cliente clientes_empresarial[] = new Cliente[Constante];

    public void AgregarCliente(String Nombre, String Tipo) {
        if (contador > 0) {
            if (Tipo.equals("Credito")) {
                AgregarClienteCre(Nombre, Tipo);
            }
            if (Tipo.equals("Operaciones Normales")) {
                AgregarClienteON(Nombre, Tipo);
            }
            if (Tipo.equals("Empresariales")) {
                AgregarClienteEmpresarial(Nombre, Tipo);
            }
        }
        if (contador == 0) {
            Inicializar();
            if (Tipo.equals("Credito")) {
                AgregarClienteCre(Nombre, Tipo);
            }
            if (Tipo.equals("Operaciones Normales")) {
                AgregarClienteON(Nombre, Tipo);
            }
            if (Tipo.equals("Empresariales")) {
                AgregarClienteEmpresarial(Nombre, Tipo);
            }
            contador++;
        }
    }
    public void AgregarClienteCre(String Nombre, String Tipo) {
        boolean espacio = false;
        if (Tipo.equals("Credito")) {
            for (int i = 0; i < Constante; i++) {
                if (clientes_credito[i].getNombre().equals("-1")) {
                    clientes_credito[i].setNombre(Nombre);
                    clientes_credito[i].setTipo_cliente(Tipo);
                    espacio = true;
                    i = Constante;
                    JOptionPane.showMessageDialog(null, "USER CREDITO CREADO");
                }
            }
        }
        if (espacio == false) {
            JOptionPane.showMessageDialog(null, "NO HAY ESPACIO CREDITO");
        }
        Listar();
    }
    public void AgregarClienteON(String Nombre, String Tipo) {
        boolean espacio = false;
        if (Tipo.equals("Operaciones Normales")) {
            for (int i = 0; i < Constante; i++) {
                if (clientes_on[i].getNombre().equals("-1")) {
                    clientes_on[i].setNombre(Nombre);
                    clientes_on[i].setTipo_cliente(Tipo);
                    espacio = true;
                    i = Constante;
                    JOptionPane.showMessageDialog(null, "USER OPERACIONES NORMALES CREADO");
                }
            }
        }
        if (espacio == false) {
            JOptionPane.showMessageDialog(null, "NO HAY ESPACIO OPERACIONES NORMALES");
        }
        Listar();
    }
    public void AgregarClienteEmpresarial(String Nombre, String Tipo) {
        boolean espacio = false;
        if (Tipo.equals("Empresariales")) {
            for (int i = 0; i < Constante; i++) {
                if (clientes_empresarial[i].getNombre().equals("-1")) {
                    clientes_empresarial[i].setNombre(Nombre);
                    clientes_empresarial[i].setTipo_cliente(Tipo);
                    espacio = true;
                    i = Constante;
                    JOptionPane.showMessageDialog(null, "USER EMPRESARIAL CREADO");
                }
            }
        }
        if (espacio == false) {
            JOptionPane.showMessageDialog(null, "NO HAY ESPACIO EMPRESARIAL");
        }
        Listar();
    }
    public String Atender() {
        if(contador==0){
            return "NO HAY PERSONAS";
        }
        else{
            if (clientes_credito[0].getNombre().compareTo("-1")==0) {
                if (clientes_on[0].getNombre().equals("-1")) {
                    if (clientes_empresarial[0].getNombre().equals("-1")) {
                        return "NO HAY PERSONAS";
                    } else {
                        String Datos="      Nombre: " + clientes_empresarial[0].getNombre() + "       Tipo usuario:" + clientes_empresarial[0].getTipo_cliente();
                        OrganizarEmpresarial();
                        return (Datos);
                    }
                } else {
                    String Datos="Nombre: " + clientes_on[0].getNombre() + "\nTipo usuario:" + clientes_on[0].getTipo_cliente();
                    OrganizarON();
                    return (Datos);
                }
            } else {
                String Datos = "Nombre: " + clientes_credito[0].getNombre() + "\nTipo usuario:" + clientes_credito[0].getTipo_cliente();
                OrganizarCredito();
                return (Datos);
            }
        
        }
        
    }
    public void OrganizarCredito(){
        clientes_credito[0].setNombre("-1");
        clientes_credito[0].setTipo_cliente("-1");
        for(int i=0;i<Constante;i++){
            for(int j=0;j<Constante;j++){
                if(clientes_credito[i].getNombre().compareTo(clientes_credito[j].getNombre())<0){
                    
                    clientes_credito[i].setNombre(clientes_credito[j].getNombre());
                    clientes_credito[j].setNombre("-1");

                    clientes_credito[i].setTipo_cliente(clientes_credito[j].getTipo_cliente());
                    clientes_credito[j].setTipo_cliente("-1");       
                }
            }
        }
    }
    public void OrganizarON(){
        clientes_on[0].setNombre("-1");
        clientes_on[0].setTipo_cliente("-1");
        for(int i=0;i<Constante;i++){
            for(int j=0;j<Constante;j++){
                if(clientes_on[i].getNombre().compareTo(clientes_on[j].getNombre())<0){
                    String Nombre=clientes_on[i].getNombre();
                    clientes_on[i].setNombre(clientes_on[j].getNombre());
                    clientes_credito[j].setNombre(Nombre);
                    
                    String Tipo=clientes_on[i].getTipo_cliente();
                    clientes_on[i].setTipo_cliente(clientes_on[j].getTipo_cliente());
                    clientes_on[j].setTipo_cliente(Tipo);       
                }
            }
        }
    }
    public void OrganizarEmpresarial(){
        clientes_empresarial[0].setNombre("-1");
        clientes_empresarial[0].setTipo_cliente("-1");
        for(int i=0;i<Constante;i++){
            for(int j=0;j<Constante;j++){
                if(clientes_empresarial[i].getNombre().compareTo(clientes_empresarial[j].getNombre())<0){
                    String Nombre=clientes_empresarial[i].getNombre();
                    clientes_empresarial[i].setNombre(clientes_empresarial[j].getNombre());
                    clientes_empresarial[j].setNombre(Nombre);
                    
                    String Tipo=clientes_empresarial[i].getTipo_cliente();
                    clientes_empresarial[i].setTipo_cliente(clientes_empresarial[j].getTipo_cliente());
                    clientes_empresarial[j].setTipo_cliente(Tipo);       
                }
            }
        }
    }

    public void Inicializar() {
        for (int i = 0; i < Constante; i++) {
            clientes_credito[i] = new Cliente("-1", "-1");
            clientes_on[i] = new Cliente("-1", "-1");
            clientes_empresarial[i] = new Cliente("-1", "-1");
        }
    }
    public void Listar() {
        for (int i = 0; i < Constante; i++) {
            System.out.println(clientes_credito[i].getNombre() + "-" + clientes_credito[i].getTipo_cliente());
        }
        for (int i = 0; i < Constante; i++) {
            System.out.println(clientes_on[i].getNombre() + "-" + clientes_on[i].getTipo_cliente());
        }
        for (int i = 0; i < Constante; i++) {
            System.out.println(clientes_empresarial[i].getNombre() + "-" + clientes_empresarial[i].getTipo_cliente());
        }
    }

}
