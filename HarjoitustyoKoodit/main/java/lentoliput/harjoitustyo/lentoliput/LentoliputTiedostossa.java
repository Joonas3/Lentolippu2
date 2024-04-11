package lentoliput.harjoitustyo.lentoliput;

import java.io.*;

public class LentoliputTiedostossa implements TiedostoRajapinta {
    public Lentolippu[] lentoliput = new Lentolippu[20];

    /**
     * Tiedoston lukemista sekä kirjoittamista
     */
    public LentoliputTiedostossa(){
        for (int i = 0; i < 20; i++){
            lentoliput[i] = new Lentolippu();
        }

        try {
            File tiedosto = new File("lentoliput.dat");
            if (tiedosto.exists()){
                FileInputStream lippuTiedosto = new FileInputStream("lentoliput.dat");
                ObjectInputStream oliot = new ObjectInputStream(lippuTiedosto);
                for (int i = 0; i < 20; i++){
                    lentoliput[i] = (Lentolippu) oliot.readObject();
                }
                lippuTiedosto.close();
            }
            else {
                for (int i = 0; i < 20; i++){
                    this.lentoliput[i] = new Lentolippu();
                }
                System.out.println("Luettu onnistuneesti");
            }
        }
        catch (Exception e){
            System.out.println("Lukemisessa virhe");
        }
    }

    /**
     * Metodi, jolla kirjoitetaan liput tiedostoon
     */
    public void tiedostoonKirjoitus(){
        try{
            FileOutputStream lipputiedosto = new FileOutputStream("lentoliput.dat");
            ObjectOutputStream oliot = new ObjectOutputStream(lipputiedosto);
            for (int i = 0; i < 20; i++){
                oliot.writeObject(lentoliput[i]);
            }
            lipputiedosto.close();

            System.out.println("Kirjoitus onnistui");
        }
        catch (Exception e){
            System.out.println("Virhe kirjoittaessa tiedostoon");
            System.out.println(e);
        }
    }
}
