package es.lanyu.audio;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.Json;

import es.lanyu.commons.identificable.AbstractNombrable;
import es.lanyu.commons.identificable.GestorIdentificables;
import es.lanyu.commons.servicios.entidad.CargadorIdentificables;
import es.lanyu.json.CargadorIdentificablesJson;

public class Sonido extends AbstractNombrable {

    static final String RUTA_SONIDO = "data/sonidos/";
    transient Sound medio;
    String archivo;

    public static void init(GestorIdentificables gestor) {
        Json json = new Json();
        json.addClassTag("archivo", String.class);
        CargadorIdentificables cargador = new CargadorIdentificablesJson();
        cargador.cargarNombrables("data\\sonidos.son", Sonido.class, Sonido.class, gestor);
    }

    static AssetManager assetManager;

    public static void setAssetManager(AssetManager assetManager) {
        Sonido.assetManager = assetManager;
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

    public Sound getMedio() {
        if (medio == null && !getArchivoMedio().equals(""))
            medio = assetManager.get(getArchivoMedio(), Sound.class);

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

}
