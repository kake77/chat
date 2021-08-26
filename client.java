import java.io.IOException;
import java.net.Socket;

public class client {
    public static void main(String[] args) {
        try{
            Socket socket=new Socket(config.IP,config.PORT);
            sender s=new sender(socket);
            s.start();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
