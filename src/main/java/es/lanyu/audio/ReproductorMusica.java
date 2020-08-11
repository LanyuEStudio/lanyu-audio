package es.lanyu.audio;

import com.badlogic.gdx.audio.Music;

public class ReproductorMusica {
    static AudioConfigurable configuracion;
    static Musica reproduciendo;

    private static AudioConfigurable getConfiguracion() {
        return configuracion;
    }

    public static void setConfiguracion(AudioConfigurable configuracion) {
        ReproductorMusica.configuracion = configuracion;
    }

    public static Musica getReproduciendo() {
        return reproduciendo;
    }

    public static void setReproduciendo(Musica reproduciendo) {
        stop();
        ReproductorMusica.reproduciendo = reproduciendo;
    }

    private static float getVolumen() {
        return getConfiguracion().getVolMusica();
    }

    private ReproductorMusica() {}

    public static void reproducirMusica(Musica musica) {
        reproducirMusica(musica, true);
    }

    public static void reproducirMusica(Musica musica, boolean repetir) {
        Music m = musica.getMedio();

        if (m != null) {
            if (musica != null && musica != getReproduciendo())
                setReproduciendo(musica);
            m.setLooping(repetir);
            m.setVolume(getVolumen());
            m.play();
        }
    }

    public static void pausa() {
        if (getReproduciendo() != null)
            getReproduciendo().pause();
    }

    public static void reanudar() {
        if (getReproduciendo() != null)
            getReproduciendo().play();
    }

    public static void stop() {
        if (getReproduciendo() != null) {
            getReproduciendo().stop();
            getReproduciendo().dispose();
        }
    }

    public static void establecerVolumen(float volumen) {
        if (getReproduciendo() != null)
            getReproduciendo().setVolume(volumen);
    }

}
