package lentoliput.harjoitustyo.lentoliput;

import java.io.Serializable;
import java.util.Date;

public class Lentolippu extends olionTiedot implements Serializable {
    private String nimi;
    private Date pvm;
    private String matkaKohde;
    private String lahtoPaikka;
    private int matkustusluokka;

    /**
     * Parametriton alustaja, asettaa alkuarvot lentolipun tiedoille
     */
    public Lentolippu(){
        this.nimi = "";
        this.pvm = new Date();
        this.matkaKohde = "";
        this.lahtoPaikka = "";
        this.matkustusluokka = 2;
    }

    /**
     * Luo lentolipun annetuilla parametreilla
     * @param nimi matkustajan nimi
     * @param pvm lipun luontipäivämäärä
     * @param matkaKohde lennon kohdekaupunki
     * @param lahtoPaikka lennon lähtökaupunki
     * @param matkustusluokka makustajan matkustusluokka
     */
    public Lentolippu(String nimi, Date pvm, String matkaKohde,
                      String lahtoPaikka, int matkustusluokka){
        this.nimi = nimi;
        this.pvm = pvm;
        this.matkaKohde = matkaKohde;
        this.lahtoPaikka = lahtoPaikka;
        this.matkustusluokka = matkustusluokka;
    }

    /**
     * Palauttaa matkustajan nimen
     * @return nimi
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * Palauttaa lennon lähtöpäivämäärän
     * @return pvm
     */
    public Date getPvm() {
        return pvm;
    }

    /**
     * Palauttaa kaupungin, joka on lennon kohteena
     * @return matkaKohde
     */
    public String getMatkaKohde() {
        return matkaKohde;
    }

    /**
     * Palauttaa kaupungin, josta lento lähtee
     * @return lahtoPaikka
     */
    public String getLahtoPaikka() {
        return lahtoPaikka;
    }

    /**
     * Palauttaa matkustajan matkustusluokan
     * @return matkustusluokka
     */
    public int getMatkustusluokka() {
        return matkustusluokka;
    }

    /**
     * Asettaa matkustajan nimen
     * @param nimi matkustajan nimi
     */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    /**
     * Asettaa lennon lähtöpäivämäärän
     * @param pvm lennon lähtöpäivämäärä
     */
    public void setPvm(Date pvm) {
        this.pvm = pvm;
    }

    /**
     * Asettaa kaupungin, joka on lennon kohteena
     * @param matkaKohde lennon kohde
     */
    public void setMatkaKohde(String matkaKohde) {
        this.matkaKohde = matkaKohde;
    }

    /**
     * Asettaa lähtökaupungin lennolle
     * @param lahtoPaikka lennon lähtökaupunki
     */
    public void setLahtoPaikka(String lahtoPaikka) {
        this.lahtoPaikka = lahtoPaikka;
    }

    /**
     * Asettaa matkustajan matkustusluokan, joka voi olla joko 1, tai 2
     * Jos asetetaan muuta kuin 1 tai 2, asettaa arvoksi 2
     * @param matkustusluokka matkustajan matkustusluokka
     */
    public void setMatkustusluokka(int matkustusluokka) {
        if (matkustusluokka == 1 || matkustusluokka == 2){
            this.matkustusluokka = matkustusluokka;
        }
        else{
            this.matkustusluokka = 2;
        }
    }

    /**
     * Palauttaa lennolle annetut lähtö -ja kohdekaupunkien välimatkan
     * @return etaisyys
     */
    public double etaisyysMaarittelija(){
        String lahto = getLahtoPaikka();
        String kohde = getMatkaKohde();

        double etaisyys = switch (lahto) {
            case "Helsinki" -> switch (kohde) {
                case "Singapore" -> 9259.0;
                case "New York" -> 6614.0;
                case "Amsterdam" -> 1499.7;
                case "Antalya" -> 2617.8;
                default -> 0.0;
            };
            case "Singapore" -> switch (kohde) {
                case "Helsinki" -> 9259.0;
                case "New York" -> 15330.6;
                case "Amsterdam" -> 10485.0;
                case "Antalya" -> 8415.0;
                default -> 0.0;
            };
            case "New York" -> switch (kohde) {
                case "Helsinki" -> 6614.0;
                case "Singapore" -> 15330.6;
                case "Amsterdam" -> 5862.0;
                case "Antalya" -> 8473.2;
                default -> 0.0;
            };
            case "Amsterdam" -> switch (kohde) {
                case "Helsinki" -> 1499.7;
                case "Singapore" -> 10485.0;
                case "New York" -> 5862.0;
                case "Antalya" -> 2658.0;
                default -> 0.0;
            };
            case "Antalya" -> switch (kohde) {
                case "Helsinki" -> 2617.8;
                case "Singapore" -> 8415.0;
                case "New York" -> 8473.2;
                case "Amsterdam" -> 2658.0;
                default -> 0.0;
            };
            default -> 0.0;
        };

        return etaisyys;
    }
}