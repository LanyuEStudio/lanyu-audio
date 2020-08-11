package es.lanyu.audio;

import es.lanyu.meta.AbstractPresentable;

public class SonidoPresentable extends AbstractPresentable<Sonido> {

    public SonidoPresentable(String id, Sonido presentable) {
        super(id);
        objetoParaPresentar = presentable;
        presentador = p -> ReproductorSonido.reproducirSonido(p.getObjetoParaPresentar());
    }

}
