package com.odim.aiml.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fábio dos Santos de Vargas Classe que permite ao Linux falar qualquer
 * mensagem ao usuário, para que esta classe possa ser usada é necessário ter o
 * pacote espeak instalado na máquina. Esta classe cria um arquivo temporário
 * .sh, dá permissões de execução e executa, removendo depois.
 *
 */
public class Speak {

    private String message;

    public void speak(String message) {

        try {

            String command = ("espeak -v pt -a 90 " + "\"" + message + "\"");
            BufferedWriter saida = new BufferedWriter(new FileWriter("/home/fvargas/tmp/Fala.sh"));
            saida.write(new String(command));
            saida.newLine();
            saida.write(new String("aumix -v 50"));
            saida.close();
            Runtime.getRuntime().exec("chmod 777 /home/fvargas/tmp/Fala.sh");
            Runtime.getRuntime().exec("/home/fvargas/tmp/./Fala.sh");
            Runtime.getRuntime().exec("aumix -v 50");

        } catch (IOException ex) {
            Logger.getLogger(Speak.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @return the mensagem
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the mensagem to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
