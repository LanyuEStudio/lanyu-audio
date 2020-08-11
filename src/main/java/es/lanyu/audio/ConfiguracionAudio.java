package es.lanyu.audio;

import es.lanyu.commons.config.ConfiguracionBase;
import es.lanyu.commons.config.Propiedades;

public class ConfiguracionAudio extends ConfiguracionBase implements AudioConfigurable {

    public ConfiguracionAudio(Propiedades propiedades) {
        super(propiedades);
        actualizarVolumenes();
    }

}
