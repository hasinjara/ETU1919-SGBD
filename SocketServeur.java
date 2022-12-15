package socket.serveur;
import socket.thread.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import algo.filtre.*;
import algo.fonction.*;
import algo.langage.*;
import algo.tableRelationnelle.*;
import algo.main.*;
import algo.erreur.*;

/**
 * This class implements java Socket server
 * @author pankaj
 *
 */
public class SocketServeur {

    private ServerSocket server;
    private int port;
    private Langage langage = new Langage();

    public ServerSocket getServer() {
        return server;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public ServerSocket startServer(int port) throws Exception {
        try {
            this.server = new ServerSocket(port);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    return server;
    }

    public String getClientRequest(ObjectInputStream ois) throws Exception {
        String request = "";
        try {
            request = (String) ois.readObject();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } 
    return request;
    }

    Object responseToClientRequest(String request) throws Exception {
        Object reponse = new Object();
        try {
            //Langage langage = new Langage();
            reponse = langage.reponseToRequest(request);
            return reponse;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
       
    }

    public void sendResponseToClientRequest(String request, ObjectOutputStream oos) throws Exception {
        try {
            Object response = responseToClientRequest(request);
            System.out.println("Response to client");
            // System.out.println( response.getClass().getTypeName() );
            if(response instanceof TableRelationnelle) {
                //System.out.println("table");
                Fonction fonction = new Fonction();
                Object[][] data = fonction.toTabObjects( (TableRelationnelle) response);
                for (int i = 0; i < data.length; i++) {
                    // String model = data[i][0].toString();
                    // int len = model.length();
                    for (int j = 0; j < data[i].length; j++) {
                        System.out.print(data[i][j] + " "+ " "+ " ");
                        if(j == data[i].length - 1) {
                            System.out.println(" ");
                        }
                    }
                }
            }
            if(response instanceof Erreur) {
                //System.out.println("Erreur");
                System.out.println( ((Erreur)response).getMessage_erreur());
            }
            else if(response instanceof String){
                System.out.println(response);
            }
            oos.writeObject(response);
            oos.flush();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        
    }
    
    public static void main(String args[]) {
        try {
            SocketServeur classDefine = new SocketServeur();
            int port = 1900;
            ServerSocket server = classDefine.startServer(port);
            
            while(true){
                System.out.println("Waiting for the client request");
                Socket client = server.accept();
                MultiThread multi = new MultiThread(classDefine ,client, 10000);
                multi.start();
            }
            //System.out.println("Shutting down Socket server!!");
            //close the ServerSocket object
            //server.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
 
    }
    
}