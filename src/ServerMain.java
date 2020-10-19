import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerMain {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(8901);
            System.out.println("Waiting for client on port " +  serverSocket.getLocalPort() + "...");
            ExecutorService service = Executors.newCachedThreadPool();
            while (true){
                Socket clientSocket = serverSocket.accept();
                Server serverThread = new Server (clientSocket);
                service.execute(serverThread);
                System.out.println("ok");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
