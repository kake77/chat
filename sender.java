import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class sender {
    private Socket socket;

    private Scanner stdin;
    private ObjectOutputStream out;
    private reciever thread;

    public sender(Socket socket){
        this.socket =socket;
    }
    public void start(){
        try{
            out=new ObjectOutputStream(socket.getOutputStream());
            thread=new reciever(socket,this);
            thread.start();
            stdin = new Scanner(System.in);
            while (stdin.hasNextLine()) {
                String line = stdin.nextLine();
                out.writeObject(line);
                if(line.equals("exit"))exit();
            }  
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    public void exit(){
        try{
            stdin.close();
            out.close();
            thread.in.close();
            socket.close();
            System.exit(0);
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
