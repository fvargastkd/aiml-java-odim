package com.odim.aiml.consts;

import java.io.File;

/**
 * Aiml constants
 * @author fvargas
 * @since 04/09/18
 */
public class AimlConst {

    public static final String AIML_FILE_SUFFIX = ".aiml";
    
    private static String root_path = System.getProperty("user.dir") + File.separator + "bots";
    public static final String default_bot_name = "alice2";
    public static final String error_bot_response = "Desculpe, deve ter algo de errado comigo.";
    public static final String default_bot_response = "Eu não tenho uma resposta para isso.";
    public static final String default_topic = "unknown";
    public static final String default_that = "unknown";
    public static final String null_input = "#NORESP";
    public static boolean debug = false;

    public static String getRootPath() {
        return root_path;
    }

    public static void setRootPath(String newRootPath) {
        root_path = newRootPath;
    }
}