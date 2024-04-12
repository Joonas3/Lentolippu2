package lentoliput.harjoitustyo.lentoliput;
abstract class olionTiedot{
    /**
     * Metodi toteutetaan Lentolippu-luokassa
     * Asettaa matkustajan matkustusluokan, joka voi olla joko 1, tai 2
     * Jos asetetaan muuta kuin 1 tai 2, asettaa arvoksi 2
     * @param matkustusluokka matkustajan matkustusluokka
     */
    abstract void setMatkustusluokka(int matkustusluokka);

    /**
     * Metodi toteutetaan Lentolippu-luokassa
     * Palauttaa lennolle annetut lähtö -ja kohdekaupunkien välimatkan
     * @return etaisyys
     */
    abstract double etaisyysMaarittelija();
}