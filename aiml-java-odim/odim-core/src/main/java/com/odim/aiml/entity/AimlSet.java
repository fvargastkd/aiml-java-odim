package com.odim.aiml.entity;

import com.odim.aiml.consts.AimlTag;
import com.odim.aiml.core.Named;

import java.util.HashSet;
import java.util.Set;

/**
 * Implements AIML Sets
 * @author fvargas
 * @since 04/09/18
 */
public class AimlSet extends HashSet<String> implements Named, AimlElement {
    private final String name;

    public AimlSet(String name, Set<String> data) {
        super(data);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return AimlTag.set;
    }
}
