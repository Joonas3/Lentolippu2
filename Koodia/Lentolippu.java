import java.util.Date;

public class Lentolippu {
    private String nimi;
    private Date lentoPvm;
    private String matkaKohde;
    private String lahtoPaikka;
    private int matkustusluokka;

    /**
     * Parametriton alustaja, asettaa alkuarvot lentolipun tiedoille
     */
    public Lentolippu(){
        this.nimi = "";
        this.lentoPvm = new Date();
        this.matkaKohde = "";
        this.lahtoPaikka = "";
        this.matkustusluokka = 2;
    }

    /**
     * Luo lentolipun annetuilla parametreilla
     * @param nimi
     * @param lentoPvm
     * @param matkaKohde
     * @param lahtoPaikka
     * @param matkustusluokka
     */
    public Lentolippu(String nimi, Date lentoPvm, String matkaKohde,
                      String lahtoPaikka, int matkustusluokka){
        this.nimi = nimi;
        this.lentoPvm = lentoPvm;
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
     * @return lentoPvm
     */
    public Date getLentoPvm() {
        return lentoPvm;
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
     * @param lentoPvm lennon lähtöpäivämäärä
     */
    public void setLentoPvm(Date lentoPvm) {
        this.lentoPvm = lentoPvm;
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
}