// Clase que representa la tabla "evidencias" en la base de datos
public class Evidencia {

    // ID único de la evidencia (PRIMARY KEY en la tabla)
    private int idEvidencia;

    // ID del reporte al que pertenece esta evidencia (FOREIGN KEY)
    private int idReporte;

    // Ruta o URL donde se encuentra almacenado el archivo (imagen, PDF, etc.)
    private String urlArchivo;

    // Texto descriptivo sobre la evidencia (opcional)
    private String descripcion;

    // Fecha y hora en que se cargó la evidencia (se genera automáticamente en BD)
    private String fechaCarga;

    // Constructor vacío, útil cuando crearás el objeto primero y luego le asignarás valores
    public Evidencia() {}

    // Constructor con todos los campos, usado para consultas o creación de un objeto completo
    public Evidencia(int idEvidencia, int idReporte, String urlArchivo, String descripcion, String fechaCarga) {
        this.idEvidencia = idEvidencia;
        this.idReporte = idReporte;
        this.urlArchivo = urlArchivo;
        this.descripcion = descripcion;
        this.fechaCarga = fechaCarga;
    }

    // Métodos Getter y Setter para acceder o modificar los atributos

    public int getIdEvidencia() { return idEvidencia; }
    public void setIdEvidencia(int idEvidencia) { this.idEvidencia = idEvidencia; }

    public int getIdReporte() { return idReporte; }
    public void setIdReporte(int idReporte) { this.idReporte = idReporte; }

    public String getUrlArchivo() { return urlArchivo; }
    public void setUrlArchivo(String urlArchivo) { this.urlArchivo = urlArchivo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getFechaCarga() { return fechaCarga; }
    public void setFechaCarga(String fechaCarga) { this.fechaCarga = fechaCarga; }
}