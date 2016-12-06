/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsocket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author arachnis
 */

public class Server {
    
    private static Socket socket;
    public static void main(String[] args){
        startServer();
    }
    public static void startServer() {
         try
        {
            int port = 5321;
            System.out.println("*******************LOGS********************");
            System.out.println("Attempting to start server on localhost:" + String.valueOf(port));
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("SERVER STARTED");
            System.out.println("Waiting for clients to be connected");
            while(true)
            {
                socket=serverSocket.accept();
                System.out.println("CLIENT CONNECTED");
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader buffer = new BufferedReader(isr);
                System.out.println("Waiting for incoming message");
                String message = buffer.readLine();
                if(message.equalsIgnoreCase("godexit")){
                    System.out.println("Received EXIT command\nSwitching off the socket and exitting...");
                    socket.close();
                    System.exit(0);
                }
                System.out.println("Incoming message from a client...");
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Incoming Message from Client:-\n" + message);
                System.out.println("Message displayed successfully... \"" + message + "\"");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                socket.close();
                System.exit(0);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }    
}
