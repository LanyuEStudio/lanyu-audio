package es.lanyu.audio;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;

import es.lanyu.commons.identificable.AbstractNombrable;

public class Sonido extends AbstractNombrable {

    static final String RUTA_SONIDO = "data/sonidos/";
    static AssetManager assetManager;
    transient Sound medio;
    String archivo;

    public static void setAssetManager(AssetManager assetManager) {
        Sonido.assetManager = assetManager;
    }

    public Sound getMedio() {
        if (medio == null && assetManager != null) {
            medio = assetManager.get(getArchivoMedio(), Sound.class);
        }

        return medio;
    }
    
    public String getArchivoMedio() {
        return RUTA_SONIDO + archivo;
    }

    public void setArchivoMedio(String ruta) {
        archivo = ruta;
    }

    public Sonido() {
        super();
    }

    public Sonido(String nombreArchivo) {
        this(nombreArchivo, nombreArchivo);
    }

    public Sonido(String nombreArchivo, String nombre) {
        super();
        setArchivoMedio(nombreArchivo);
        setIdentificador(nombre);
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

}
