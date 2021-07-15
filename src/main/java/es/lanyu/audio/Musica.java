package es.lanyu.audio;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;

import es.lanyu.commons.identificable.AbstractNombrable;

public class Musica extends AbstractNombrable {

    static final String RUTA_MUSICA = "data/musica/";
    static AssetManager assetManager;
    transient Music medio;
    String archivo;

    public static void setAssetManager(AssetManager assetManager) {
        Musica.assetManager = assetManager;
    }

    public Music getMedio() {
        if (medio == null && !getArchivoMedio().equals(""))
            medio = assetManager.get(getArchivoMedio(), Music.class);

        return medio;
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
