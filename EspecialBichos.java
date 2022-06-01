public class EspecialBichos extends  Bicho{
    public EspecialBichos(int salud) {
        super(salud);
    }
    @Override
    public String toString(){
        if(getSalud() > 0){
            return "BE-"+getSalud();
        }
        else{
            return "  X  ";
        }
    }
}
