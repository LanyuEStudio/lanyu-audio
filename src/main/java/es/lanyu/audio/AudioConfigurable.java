package es.lanyu.audio;

import es.lanyu.commons.config.Configurable;

public interface AudioConfigurable extends Configurable {
    
    default String getIdVolSonido() { return "volSonido"; }

    default String getIdVolumenMusica() { return "volMusica"; }

    default String getIdSonidoActivado() { return "sonidoActivado"; }

    default String getIdMusicaActivada() { return "musicaActivada"; }

    default float getVolSonido() {
        return Float.valueOf(getPropiedades().getProperty(getIdVolSonido()));
    }

    default void setVolSonido(float volSonido) {
        getPropiedades().actualizarPropiedad(getIdVolSonido(), Float.toString(volSonido));
        actualizarVolumenes();
    }

    default float getVolMusica() {
        return Float.valueOf(getPropiedades().getProperty(getIdVolumenMusica()));
    }

    default void setVolMusica(float volMusica) {
        getPropiedades().actualizarPropiedad(getIdVolumenMusica(), Float.toString(volMusica));
        actualizarVolumenes();
    }

    default boolean isSonidoActivado() {
        return Boolean.valueOf(getPropiedades().getProperty(getIdSonidoActivado()));
    }

    default void setSonidoActivado(boolean sonidoActivado) {
        getPropiedades().actualizarPropiedad(getIdSonidoActivado(), Boolean.toString(sonidoActivado));
        actualizarVolumenes();
    }

    default boolean isMusicaActivada() {
        return Boolean.valueOf(getPropiedades().getProperty(getIdMusicaActivada()));
    }

    default void setMusicaActivada(boolean musicaActivada) {
        getPropiedades().actualizarPropiedad(getIdMusicaActivada(), Boolean.toString(musicaActivada));
        actualizarVolumenes();
    }

    default void alternarSonidoActivado() {
        setSonidoActivado(!isSonidoActivado());
    }

    default void alternarMusicaActivada() {
        setMusicaActivada(!isMusicaActivada());
    }

    default void actualizarVolumenes() {
        ReproductorSonido.establecerVolumen(isSonidoActivado() ? getVolSonido() : 0);
        ReproductorMusica.establecerVolumen(isMusicaActivada() ? getVolMusica() : 0);
    }
}
