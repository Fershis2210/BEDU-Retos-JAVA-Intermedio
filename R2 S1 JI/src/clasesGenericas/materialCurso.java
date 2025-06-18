package clasesGenericas;

public abstract class materialCurso {
    private final String titulo;
    private final String autor;

    public materialCurso (String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }

    public abstract void mostrarDetalle();
}
