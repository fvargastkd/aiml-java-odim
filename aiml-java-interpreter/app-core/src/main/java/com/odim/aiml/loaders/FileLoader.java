package com.odim.aiml.loaders;

import java.io.File;
import java.util.Map;

/**
 * File loader
 *
 * @param <T> type of result data
 * @author fvargas
 * @since 04/09/18
 */
public interface FileLoader<T> extends Loader<T, File> {
    T load(File file);

    Map<String, T> loadAll(File... files);
}
