import java.util.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Methods {
    Scanner scan = new Scanner(System.in);
    Random random = new Random();
    Bicho[][] arrra = new Bicho[3][3];
    Object [][] arrt = new Object[3][3];
    String [] frase = {"hola", "Mamahuevo", "Juasjaus", "Te gane hdpta", "gluglug"};

    public void Main() {
        System.out.println("Juego de mi bicho");
        int value = random.nextInt((9 - 1) + 1) + 1;
        int controlador = 0;
        int ancho = 0, largo = 0;
        for (int j = 0; j < value; j++) {
            int value2 = random.nextInt((3 - 1) + 1) + 1;

            switch (value2) {
                case 1:
                    Bicho bn = new NormalBichos(10);
                    arrra[largo][ancho] = bn;
                    break;

                case 2:
                    Bicho bl = new AlienBicho(20);
                    arrra[largo][ancho] = bl;
                    break;

                case 3:
                    Bicho be = new EspecialBichos(30);
                    arrra[largo][ancho] = be;
                    break;
            }
            ancho++;
            if (ancho > 2) {
                ancho = 0;
                largo++;
            }
        }

        System.out.println("Menu de juego");
        boolean control = true;
        System.out.println("""
                1. Disparar una bala (eligiendo la posición sobre la cual disparar).
                   Cada bala quita 5 de sangre.
                  
                2. Activar bomba atómica. 
                   La cual mata a un bicho en una posición aleatoria automáticamente.\s
                  
                3. Activar bicho mutante. 
                                    
                4. Intercambio de posiciones.
                                    
                5. Conversión de sangre. 
                                    
                6. Bomba de fila.
                 
                7. Promedio tenebroso. 
                 
                8. La frase de la abuela.
                
                9. Termina el juego. 
                """);
        while (true) {

            this.mostrarTablero();
            if (!control) {
                System.out.println("""
                        --------------------------------
                        El juego de mi bicho a termiando
                        --------------------------------""");
                break;
            }
            System.out.println("Selecciona una opcion del menu de juego");
            int option = scan.nextInt();
            switch (option) {
                case 1:
                    this.dispararPosicion();
                    break;

                case 2:
                    this.bombaAtomica();
                    break;

                case 3:
                    this.bichoMutante();
                    break;

                case 4:
                    this.changePosicion();
                    break;

                case 5:
                    this.conversionSangre();
                    break;

                case 6:
                    this.bombaFila();
                    break;

                case 7:
                    this.promedioTenebroso();
                    break;

                case 8:
                    this.fraseAbuela();
                    break;

                case 9:
                    control = false;

                default:
                    break;
            }

            for(int i = 0; i < arrra.length ; i++){
                for(int j = 0; j < arrra[i].length; j++){
                    if(arrra[i][j] != null && arrra[i][j].getSalud() < 0){
                        controlador++;
                        if(controlador == value){
                            control = false;
                        }

                    }
                }
            }
            controlador = 0;

        }

    } // Principal;

    public void mostrarTablero() {
        System.out.println("-------------------");
        for (int i = 0; i < arrra.length; i++) {
            for (int j = 0; j < arrra[i].length; j++) {
                if (arrra[i][j] == null) {
                    System.out.printf("|%5s", "");
                } else {
                    System.out.printf("|" + arrra[i][j].toString());
                }
            }
            System.out.print("|\n-------------------\n");
        }
    } // Tablero de juego.

    public void dispararPosicion() {
        while (true) {
            System.out.println("Selecciona la fila para disparar 0-2");
            int posi1;
            while (true) {
                int pos1 = scan.nextInt();
                if (pos1 >= 3) {
                    System.out.println("Selecciona una opcion valida");
                } else {
                    posi1 = pos1;
                    break;
                }

            }
            System.out.println("");
            System.out.println("Selecciona la columna para disparar 0-2");
            int posi2;
            while (true) {
                int pos2 = scan.nextInt();
                if (pos2 >= 3) {
                    System.out.println("Selecciona una opcion valida");
                } else {
                    posi2 = pos2;
                    break;
                }

            }
            System.out.println("");
            if (arrra[posi1][posi2] != null) {
                System.out.println("Puuuum hpta");
                arrra[posi1][posi2].setSalud(arrra[posi1][posi2].getSalud() - 5);
                System.out.println("Se ha disparado a " + arrra[posi1][posi2].toString());
                break;
            } else {
                System.out.println("Selecciona un bicho existente");
            }

        }

    } // Disparar bicho.

    public void bombaAtomica() {
        while (true) {
            int value1 = random.nextInt((2 - 0) + 1) + 0;
            int value2 = random.nextInt((2 - 0) + 1) + 0;

            if (arrra[value1][value2] != null && arrra[value1][value2].getSalud() > 0) {
                arrra[value1][value2].setSalud(arrra[value1][value2].getSalud() - 1000);
                System.out.println("Se ha matado a un bicho en la posicion" + value1 + value2);
                break;
            }
        }
    } // Mata a un bicho

    public void bichoMutante() {
        int menor = arrra[0][0].getSalud();
        int x = 0, y = 0;
        for (int i = 0; i < arrra.length; i++) {
            for (int j = 0; j < arrra[i].length; j++) {
                if (arrra[i][j] != null) {
                    if (arrra[i][j].getSalud() > 0) {
                        int numeroActual = arrra[i][j].getSalud();
                        if (numeroActual < menor) {
                            menor = numeroActual;
                            x = i;
                            y = j;
                        }
                    }

                }
            }
        }
        arrra[x][y].setSalud(arrra[x][y].getSalud() * 2);

    } // Duplica vida

    public void changePosicion() {
        System.out.println("""
                Selecciona
                1. Intercambio manual. 
                2. Intercambio automatico""");
        int choose = scan.nextInt();
        switch (choose) {
            case 1:
                System.out.println("""
                        ----------------------
                        Primer bicho a cambiar
                        ----------------------
                        """);
                int p1 = 0, p2 = 0;
                while (true) {
                    System.out.println("Selecciona la fila para hacer el cambio  0-2");
                    int posi1;
                    while (true) {
                        int pos1 = scan.nextInt();
                        if (pos1 >= 3) {
                            System.out.println("Selecciona una opcion valida");
                        } else {
                            posi1 = pos1;
                            p1 = pos1;
                            break;
                        }

                    }
                    System.out.println("");
                    System.out.println("Selecciona la columna para hacer el cambio 0-2");
                    int posi2;
                    while (true) {
                        int pos2 = scan.nextInt();
                        if (pos2 >= 3) {
                            System.out.println("Selecciona una opcion valida");
                        } else {
                            posi2 = pos2;
                            p2 = pos2;
                            break;
                        }

                    }

                    System.out.println("");
                    if (arrra[posi1][posi2] != null) {
                        break;
                    } else {
                        System.out.println("Selecciona un bicho existente");
                    }

                }

                System.out.println("""
                        ----------------------
                        Segundo bicho a cambiar
                        ----------------------
                        """);
                int pp1 = 0, pp2 = 0;
                while (true) {
                    System.out.println("Selecciona la fila para hacer el cambio  0-2");
                    int posi1;
                    while (true) {
                        int pos1 = scan.nextInt();
                        if (pos1 >= 3) {
                            System.out.println("Selecciona una opcion valida");
                        } else {
                            posi1 = pos1;
                            pp1 = pos1;
                            break;
                        }

                    }
                    System.out.println("");
                    System.out.println("Selecciona la columna para hacer el cambio 0-2");
                    int posi2;
                    while (true) {
                        int pos2 = scan.nextInt();
                        if (pos2 >= 3) {
                            System.out.println("Selecciona una opcion valida");
                        } else {
                            posi2 = pos2;
                            pp2 = pos2;
                            break;
                        }

                    }

                    System.out.println("");
                    if (arrra[posi1][posi2] != null) {
                        break;
                    } else {
                        System.out.println("Selecciona un bicho existente");
                    }


                }
                System.out.println("Cambiando posicion en: \n");
                for(int i = 3; i > 0; i--){
                    System.out.println(i + "..");
                }
                arrt[0][0] = arrra [p1][p2];
                arrra[p1][p2]=arrra[pp1][pp2];
                arrra[pp1][pp2] = (Bicho) arrt[0][0];
                break;

            case 2:

                while(true){

                    int value1 = random.nextInt((2 - 0) + 1) + 0;
                    int value2 = random.nextInt((2 - 0) + 1) + 0;
                    int value11 = random.nextInt((2 - 0) + 1) + 0;
                    int value22 = random.nextInt((2 - 0) + 1) + 0;

                    if(arrra [value1][value2] != null && arrra [value11][value22] != null){
                        System.out.println("Cambiando posicion en: \n");
                        for(int i = 3; i > 0; i--){
                            System.out.println(i + "..");
                        }
                        arrt [0][0] = arrra[value1][value2];
                        arrra[value1][value2] = arrra[value11][value22];
                        arrra [value11][value22] = (Bicho) arrt[0][0];
                        break;
                    }
                }
                break;
        }
    } // Cambiar posicion.

    public void conversionSangre(){
        int menor = arrra[0][0].getSalud();
        int x = 0, y = 0;
        for (int i = 0; i < arrra.length; i++) {
            for (int j = 0; j < arrra[i].length; j++) {
                if (arrra[i][j] != null) {
                    if (arrra[i][j].getSalud() > 0) {
                        int numeroActual = arrra[i][j].getSalud();
                        if (numeroActual < menor) {
                            menor = numeroActual;
                            x = i;
                            y = j;
                        }
                    }

                }
            }
        }
        Bicho eb = new EspecialBichos (arrra[x][y].getSalud());
        arrra[x][y] = eb;
    } //Conversion a bichoespecial

    public void bombaFila(){
        int value1 = random.nextInt((2 - 0) + 1) + 0;

        for(int i = 0; i < 3; i++){
            if(arrra[value1][i] !=null)
            arrra[value1][i].setSalud(arrra[value1][i].getSalud()-1000);
        }
    } // Eliminar fila.

    public void promedioTenebroso(){
        int acumulador = 0;
        int cantidad = 0;
        for(int i = 0; i < arrra.length ; i++){
            for(int j = 0; j < arrra[i].length; j++){
                if(arrra[i][j] !=null && arrra[i][j].getSalud() > 0){
                    acumulador+=arrra[i][j].getSalud();
                    cantidad++;
                }
            }
        }
        System.out.println("El Promedio de bichos vivos es "+ (acumulador/cantidad));
    } // Promedio bichos.

    public void fraseAbuela(){
        int value1 = random.nextInt((4 - 0) + 1) + 0;
        System.out.println(frase[value1]);
    } // Frase abuela.
}



