package com.odim.aiml.channels;

/**
 * Communication channel
 * @author fvargas
 * @since 04/09/18
 */
public interface Provider {
    String read();

    void write(String message);
}
