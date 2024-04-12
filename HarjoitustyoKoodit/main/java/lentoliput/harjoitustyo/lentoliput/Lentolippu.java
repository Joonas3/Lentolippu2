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
     * @param nimi
     * @param pvm
     * @param matkaKohde
     * @param lahtoPaikka
     * @param matkustusluokka
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
        double etaisyys = 0.0;

        switch (lahto){

            case "Helsinki":
                switch (kohde){
                    case "Singapore":
                        etaisyys = 9259.0;
                        break;
                    case "New York":
                        etaisyys = 6614.0;
                        break;
                    case "Amsterdam":
                        etaisyys = 1499.7;
                        break;
                    case "Antalya":
                        etaisyys = 2617.8;
                        break;
                    default:
                        etaisyys = 0.0;
                }
                break;

            case "Singapore":
                switch (kohde){
                    case "Helsinki":
                        etaisyys = 9259.0;
                        break;
                    case "New York":
                        etaisyys = 15330.6;
                        break;
                    case "Amsterdam":
                        etaisyys = 10485.0;
                        break;
                    case "Antalya":
                        etaisyys = 8415.0;
                        break;
                    default:
                        etaisyys = 0.0;
                }
                break;

            case "New York":
                switch (kohde){
                    case "Helsinki":
                        etaisyys = 6614.0;
                        break;
                    case "Singapore":
                        etaisyys = 15330.6;
                        break;
                    case "Amsterdam":
                        etaisyys = 5862.0;
                        break;
                    case "Antalya":
                        etaisyys = 8473.2;
                        break;
                    default:
                        etaisyys = 0.0;
                }
                break;

            case "Amsterdam":
                switch (kohde){
                    case "Helsinki":
                        etaisyys = 1499.7;
                        break;
                    case "Singapore":
                        etaisyys = 10485.0;
                        break;
                    case "New York":
                        etaisyys = 5862.0;
                        break;
                    case "Antalya":
                        etaisyys = 2658.0;
                        break;
                    default:
                        etaisyys = 0.0;
                }
                break;

            case "Antalya":
                switch (kohde){
                    case "Helsinki":
                        etaisyys = 2617.8;
                        break;
                    case "Singapore":
                        etaisyys = 8415.0;
                        break;
                    case "New York":
                        etaisyys = 8473.2;
                        break;
                    case "Amsterdam":
                        etaisyys = 2658.0;
                        break;
                    default:
                        etaisyys = 0.0;
                }
                break;
        }
        return etaisyys;
    }
}