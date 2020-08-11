package es.lanyu.audio;

import com.badlogic.gdx.audio.Sound;

public final class ReproductorSonido {
    static ConfiguracionAudio configuracion;
    static float volumen = 1;

    public static void setConfiguracion(ConfiguracionAudio configuracion) {
        ReproductorSonido.configuracion = configuracion;
        volumen = configuracion.getVolSonido();
    }

    private ReproductorSonido() {}

    public static void reproducirSonido(Sonido sonido) {
        Sound s = sonido.getMedio();
        if (s != null) s.play(volumen);
    }

    public static void establecerVolumen(float volumen) {
        ReproductorSonido.volumen = volumen;
    }

}
