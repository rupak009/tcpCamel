import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class Client {
    int port;
    Socket socket;
    OutputStream outputStream;
    InputStream inputStream;


    public Client(int port){this.port = port;}

    public void connect() throws IOException {
        this.socket = new Socket("localhost",this.port);
        this.outputStream = socket.getOutputStream();
        this.inputStream = socket.getInputStream();
    }

    public void write() throws IOException {
        int msgLen = 10;
        byte firstByte = (byte) (msgLen & 0b11111111);
        byte secondByte = (byte) (msgLen >> 8 & 0b11111111);
        byte messageCode = 2;
        byte[] bytes = {firstByte,secondByte,messageCode,3,98,99,100,2,98,99};
        System.out.println("Writing : "+new String(Arrays.copyOfRange(bytes,3,10)));
        outputStream.write(bytes);
    }

    public void read() throws IOException {
        byte[] readBuffer = new byte[1024];

        while (inputStream.read(readBuffer) == 1024)
            System.out.println(new String(readBuffer));
        System.out.println(new String(readBuffer));
    }


    public void run() throws IOException {
        connect();
        write();
        read();
        close();
    }

    public void close() throws IOException {
        outputStream.close();;
        inputStream.close();
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client(7000);
        client.run();
    }
}
