import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args){

        /**
         * Ho creato la variabile today per chiedere al sistema operativo di dirmi l'ora.
         * Ho poi assegnato la variabile today a time formattadola nel modo che voglio visualizzarla
         */
        LocalDateTime today = LocalDateTime.now();
        String time = today.format(DateTimeFormatter.ofPattern("dd-MMM-YY HH:mm"));

        /**
         * Ho poi creato il nuovo file nella cartella src di questo progetto
         */
        File file = new File("./src/file.txt");

        try {
            /**
             * All'interno del try catch ho creato un if che controllasse se c'e oppure no un file nella cartella
             * src, se non c'e, stampera che e stato creato un nuovo file, invece se e presente, stampera Overwrite.
             */
            if(file.createNewFile()){
                System.out.println("New file created");
            } else {
                System.out.println("Overwrite");
            }

            /**
             * Ho creato un oggetto fw di tipo FileWriter per poter scrivere dentro al file la data e l'ora di oggi
             * ed ho chiuso poi il file per essere sicura che il sistema opertivo scrivesse il file.
             */
            FileWriter fw = new FileWriter(file);
            fw.write(time);
            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}