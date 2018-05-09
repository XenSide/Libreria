public class Libro {
    private String titolo, autore;
    private Double prezzo;

    Libro(String titolo, String autore, Double prezzo) {
        this.titolo = titolo;
        this.autore = autore;
        this.prezzo = prezzo;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    @Override
    public String toString() {
        return titolo+"*"+autore+"*"+prezzo;
    }
}
