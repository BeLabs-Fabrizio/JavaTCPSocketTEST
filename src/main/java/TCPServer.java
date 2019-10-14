
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class TCPServer {
    static ServerSocket serverSocket;
    public static void main(String[] args) throws IOException {
        serverSocket=new ServerSocket(9876);
        System.out.println("Server: w8 connections");
        Socket socket=serverSocket.accept();
        System.out.println("Server: a client is connected");

        DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
        LocalDateTime startTime=LocalDateTime.now();
        while (LocalDateTime.now().isBefore(startTime.plusMinutes(4))){
            System.out.println("scrivo ora!");
            dos.writeUTF(LocalDateTime.now().toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        dos.close();
        serverSocket.close();
    }

}
