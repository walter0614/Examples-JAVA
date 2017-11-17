
package Cliente;


public class Cliente {
    
    private String nombre;
    private String tipo_cliente;
    
    public Cliente(String nombre, String tipo_cliente){
        this.nombre=nombre;
        this.tipo_cliente=tipo_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(String tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", tipo_cliente=" + tipo_cliente + '}';
    }
    
    
    
}
