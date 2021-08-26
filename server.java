import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    public static void main(String[] args) {
        ServerSocket serverSocket=null;
        try{
            System.out.println("接続待機中");
            serverSocket=new ServerSocket(config.PORT);
            Socket socket=serverSocket.accept();
            sender s=new sender(socket);
            s.start();

            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
