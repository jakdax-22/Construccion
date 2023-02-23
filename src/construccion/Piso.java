
package construccion;

import java.util.Objects;


public class Piso {
    private String propietario, puerta;
    private int planta,metros,n_habitaciones;
    
    public Piso () {
        
    }
    public Piso (String propietario, String puerta, int planta, int metros, int n_hab){
        this.propietario = propietario;
        this.puerta = puerta;
        this.planta = planta;
        this.metros = metros;
        this.n_habitaciones =  n_hab;
    }
    public String getPropietario(){
        return this.propietario;
    }  
    public String getPuerta(){
        return this.puerta;
    }
    public int getPlanta (){
        return this.planta;
    }
    public int getMetros(){
        return this.metros;
    }
    public int getHabitaciones(){
        return this.n_habitaciones;
    }
    public void setPropietario(String propietario){
        this.propietario = propietario;
    }
    public void setPuerta (String puerta){
        this.puerta = puerta;
    }
    public void setPlanta (int planta){
        this.planta = planta;
    }
    public void setMetros (int metros){
        this.metros = metros;
    }
    public void setHabitaciones (int habitaciones){
        this.n_habitaciones = habitaciones;
    }

    @Override
    public String toString() {
        return "Piso{" + "propietario=" + propietario + ", puerta=" + puerta + ", planta=" + planta + ", metros=" + metros + ", n_habitaciones=" + n_habitaciones + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.propietario);
        hash = 79 * hash + Objects.hashCode(this.puerta);
        hash = 79 * hash + this.planta;
        hash = 79 * hash + this.metros;
        hash = 79 * hash + this.n_habitaciones;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Piso other = (Piso) obj;
        return true;
    }
    
    
}
