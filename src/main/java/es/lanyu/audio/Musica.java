package es.lanyu.audio;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.Json;

import es.lanyu.commons.identificable.AbstractNombrable;
import es.lanyu.commons.identificable.GestorIdentificables;
import es.lanyu.commons.servicios.entidad.CargadorIdentificables;
import es.lanyu.json.CargadorIdentificablesJson;

public class Musica extends AbstractNombrable {

    static final String RUTA_MUSICA = "data/musica/";
    static AssetManager assetManager;
    transient Music medio;
    String archivo;

    public static void init(GestorIdentificables gestor) {
        Json json = new Json();
        json.addClassTag("archivo", String.class);
        CargadorIdentificables cargador = new CargadorIdentificablesJson();
        cargador.cargarNombrables("data\\musicas.mus", Musica.class, Musica.class, gestor);
    }

    public static void setAssetManager(AssetManager assetManager) {
        Musica.assetManager = assetManager;
    }

    public String getArchivoMedio() {
        return RUTA_MUSICA + archivo;
    }

    public void setArchivoMedio(String ruta) {
        archivo = ruta;
    }

    public Musica() {
        super();
    }

    public Musica(String nombreArchivo) {
        this(nombreArchivo, nombreArchivo);
    }

    public Musica(String nombreArchivo, String nombre) {
        this();
        setArchivoMedio(nombreArchivo);
        setNombre(nombre);
    }

    public Music getMedio() {
        if (medio == null && !getArchivoMedio().equals(""))
            medio = assetManager.get(getArchivoMedio(), Music.class);

        return medio;
    }

    protected void play() {
        getMedio().play();
    }

    protected void pause() {
        getMedio().pause();
    }

    protected void stop() {
        getMedio().stop();
    }

    protected void dispose() {
        getMedio().dispose();
    }

    protected void setVolume(float volumen) {
        getMedio().setVolume(volumen);
    }
}
