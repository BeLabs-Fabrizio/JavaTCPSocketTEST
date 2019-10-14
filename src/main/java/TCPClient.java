import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",9876);

        DataInputStream dis=new DataInputStream(socket.getInputStream());
        LocalDateTime start=LocalDateTime.now();
        while (start.plusMinutes(2).isAfter(LocalDateTime.now())){
           try{
               System.out.println(dis.readUTF());
           }catch (EOFException e){
               System.out.println("no data!  w8");
               try {
                   Thread.sleep(500);
               } catch (InterruptedException ex) {
                   ex.printStackTrace();
               }
           }
        }
        dis.close();
        socket.close();
    }
}
