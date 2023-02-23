
package construccion;


public class Edificio {
    private String direccion, pobla;
    private int numero,cod_postal,n_pisos,contador, helpbucle;
    private Piso [] pisos;
    private boolean hay_edificio = false;

public Edificio (){
    
}  
public Edificio (String direccion, String pobla, int numero, int cod_postal, int n_pisos){
    if (!this.hay_edificio){
    this.direccion = direccion;
    this.pobla = pobla;
    this.numero = numero;
    this.cod_postal = cod_postal;
    this.n_pisos = n_pisos;
    this.contador = 0;
    this.pisos = new Piso [n_pisos];    
    this.hay_edificio = true;
    }
}

public String getDireccion (){
    return this.direccion;
}
public String getPobla () {
    return this.pobla;
}
public int getNumero (){
    return this.numero;
}
public int getCod_Postal () {
    return this.cod_postal;
}
public int getN_Pisos () {
    return this.n_pisos;
}
public int getContador () {
    return this.contador;
}

public Piso[] getPisos() {
        return this.pisos;
    }


public void setDireccion (String direccion){
    this.direccion = direccion;
}
public void getPobla (String pobla) {
    this.pobla = pobla;
}
public void getNumero (int numero){
    this.numero = numero;
}
public void getCod_Postal (int cod_postal) {
    this.cod_postal = cod_postal;
}
public void getN_Pisos (int n_pisos) {
    this.n_pisos = n_pisos;
}
public void getContador (int contador) {
    this.contador = contador;
}

public int buscaPiso(int planta, String puerta){
    for (int i = 0; i < contador; i++){          
            if (planta == this.pisos[i].getPlanta() && puerta.equals(this.pisos[i].getPuerta()))
                return i;
    }
    return -1;
}
public int insertarPiso (String propietario, String puerta, int planta, int metros, int n_habitaciones){
    if (arrLleno()){
        return -1;
    }

    else {
        if (buscaPiso (planta,puerta) != -1)
            return -2;
        else{
            Piso p = new Piso (propietario, puerta,planta,metros,n_habitaciones);    
            this.pisos [this.contador] = p;
            this.contador ++;
            return 0;
        }
    }    
}

public void listaPisos () {
    for (int i = 0; i < this.contador; i++){
        System.out.println (this.pisos[i]);
    }
}

public void listaEdificio(){
    System.out.println ("Dirección : "+this.direccion+"\nNúmero : "+this.numero+"\nCod Postal : "+this.cod_postal+"\nPoblación : "+this.pobla+"\nNúmero de pisos : "+this.n_pisos+"\nPisos :\n");
    listaPisos();
}

public boolean actualizaPro(int planta, String puerta, String propietario){
    if (buscaPiso(planta,puerta) == -1){
        return false;
    }
    else{
        int i = buscaPiso (planta,puerta);
        this.pisos [i].setPropietario(propietario);
        return true;
    }
    
}

public boolean borraPiso (int planta, String puerta){
    if (buscaPiso(planta,puerta) == -1){
        return false;
    }
    else {
        int i = buscaPiso(planta,puerta);
        for (int j = i; j < this.contador; j++){
            if ((j+1) == contador)
                this.pisos[j] = null;
            else
            this.pisos[j] = this.pisos[j+1];
        }
        this.contador--;
        return true;
    }
}

public boolean arrLleno (){
    if (this.contador == this.pisos.length)
        return true;
    else
        return false;
}

}
