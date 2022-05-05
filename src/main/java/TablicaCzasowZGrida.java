class TablicaCzasowZGrida {

    public static void main(String[] args) {

        Modul[][] tablica = new Modul[3] [5];

        for (int i = 0; i < tablica.length; i++) {
            for (int j = 0; j < tablica[i].length; j++) {

                tablica[i][j] = new Modul();
                tablica[i][j].setTyp("H");
                System.out.print(" "+i+j);
            }
            System.out.println(System.lineSeparator());
        }


        for (int y = 0; y < tablica.length; y++) {
            for (int x = 0; x < tablica[y].length; x++) {

                //polaczenia poziome
                if(x< tablica[y].length-1){
                    System.out.println(y+""+x+" "+y+""+(x+1)+" czas"+tablica[y][x].getTyp());
                }
                //TODO - pobiez wiekszy czas, jeżeli czas mniejszy od XXXX to dodaj moduł

                //polaczenia pionowe
                if(y< tablica.length-1){
                    System.out.println(y+""+x+" "+(y+1)+""+x+" czas");
                }
            }
        }
    }
}
