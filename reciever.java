import java.io.IOError;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.xml.catalog.Catalog;

public class reciever extends Thread{
    private Socket socket;
    public boolean disconnectFlag;
    ObjectInputStream in;
    sender s;

    public reciever(Socket socket,sender s){
        this.socket=socket;
        this.s=s;
        System.out.println("connected");

        this.disconnectFlag=false;
    }

    public void run(){

        in=null;
        try{
            in=new ObjectInputStream(this.socket.getInputStream());

            String recieveData;
            while(true){
                recieveData=(String)in.readObject();
                System.out.println(recieveData);
                if(recieveData.equals("exit"))s.exit();
            }
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
