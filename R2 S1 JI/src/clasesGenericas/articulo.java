package clasesGenericas;

public class articulo extends materialCurso {
    private final int palabras;

    public articulo(String titulo, String autor, int palabras) {
        super(titulo, autor);
        this.palabras = palabras;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Artículo: " + getTitulo() + " - Autor: " + getAutor() + " - Palabras: " + palabras);
    }
}
