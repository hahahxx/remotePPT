package xh.PPT.control;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PPTServer {

	private static int key;
	//注意这里用的输入输出流的对象
	private static ObjectInputStream fromClient;
	private static ObjectOutputStream fromServer;
	
	public static void main(String[] args) throws IOException,	ClassNotFoundException, AWTException, InterruptedException{
	ServerSocket sSocket = new ServerSocket(9999);
	System.out.println("waiting a connection from the client");
	Robot robot = new Robot();
	Socket sock = sSocket.accept();
	System.out.println("recv a connection");
	fromClient = new ObjectInputStream(sock.getInputStream());
	fromServer = new ObjectOutputStream(sock.getOutputStream());
	do{
	String strSwitch = (String)fromClient.readObject();
	System.out.println("what we receive is" + strSwitch);
/*	Choices choice = (Choices)fromClient.readObject();
	System.out.println("the flag is " + choice.getKey());
	key = choice.getKey();*/
	switch(strSwitch){

	case "start":
	System.out.println("the flag is S5");
	robot.keyPress(KeyEvent.VK_SHIFT);
	Thread.sleep(20);
	robot.keyPress(KeyEvent.VK_F5);
	Thread.sleep(10);
	robot.keyRelease(KeyEvent.VK_F5);
	robot.keyRelease(KeyEvent.VK_SHIFT);
	Thread.sleep(10);
	
	break;
	
	case "back":
	System.out.println("the flag is left");
	robot.keyPress(KeyEvent.VK_LEFT);
	Thread.sleep(10);
	robot.keyRelease(KeyEvent.VK_LEFT);
	Thread.sleep(10);
	break;
	
	case "next":
	System.out.println("the flag is right");
	robot.keyPress(KeyEvent.VK_RIGHT);
	Thread.sleep(10);
	robot.keyRelease(KeyEvent.VK_RIGHT);
	Thread.sleep(10);

	break;

	case "stop":
	System.out.println("the flag is esc");
	robot.keyPress(KeyEvent.VK_ESCAPE);
	Thread.sleep(10);
	robot.keyPress(KeyEvent.VK_ESCAPE);
	Thread.sleep(10);
	break;

	default:
	break;
	}
	}
	while(key != -1);
	System.out.println("exit the app");
	fromClient.close();
	fromServer.close();
	sock.close();
	sSocket.close();
	}
}

