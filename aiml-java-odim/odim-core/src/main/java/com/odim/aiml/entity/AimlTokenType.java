package com.odim.aiml.entity;

/**
 * AimlTokenType
 *
 * @author fvargas
 * @since 04/09/18
 */
public enum AimlTokenType {
    TEMPLATE("template"),
    PATTERN("pattern"),
    TOPIC("topic"),
    WORD("word");

    private String code;

    AimlTokenType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
