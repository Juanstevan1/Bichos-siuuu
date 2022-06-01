public class NormalBichos extends Bicho {
    public NormalBichos(int salud) {
        super(salud);
    }
    @Override
    public String toString(){
        if(getSalud() > 0){
            return "BN-"+getSalud();
        }
        else{
            return "  X  ";
        }
    }
}
