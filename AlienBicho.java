public class AlienBicho extends Bicho{
    public AlienBicho(int salud) {
        super(salud);
    }
    @Override
    public String toString(){
        if(getSalud() > 0){
            return "BA-"+getSalud();
        }
        else{
            return "  X  ";
        }
    }
}
