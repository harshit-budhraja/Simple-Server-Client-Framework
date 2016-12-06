/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsocket;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.*;

/**
 *
 * @author arachnis
 */

public class Client {
    
    private static Socket socket;
    public static void main(String[] args){
        startClient();
    }
    public static void startClient() {
        try
        {
            String host = "localhost";
            int port = 5321;
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(address, port);
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter buffer = new BufferedWriter(osw);
            String message = JOptionPane.showInputDialog("Enter a message to send to the server");
            buffer.write(message);
            buffer.flush();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
         try
            {
                socket.close();
                System.exit(0);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }  
}
