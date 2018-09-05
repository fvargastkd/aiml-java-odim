package com.odim.aiml.entity;

import com.odim.aiml.consts.AimlTag;
import com.odim.aiml.utils.AppUtils;

import java.util.List;

/**
 * Aiml random tag
 * @author fvargas
 * @since 04/09/18
 */
public class AimlRandom implements AimlElement {
    private final List<String> options;

    public AimlRandom(List<String> options) {
        this.options = options;
    }

    @Override
    public String getType() {
        return AimlTag.random;
    }

    public String getValue() {
        return AppUtils.getRandom(options);
    }
}
