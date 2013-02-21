package wyz.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PptclientActivity extends Activity {
    /** Called when the activity is first created. */
	private ImageButton start;
	private ImageButton escape;
	private ImageButton forward;
	private ImageButton back;
	private Socket sock;
	private ObjectOutputStream fromClient;
	private ObjectInputStream fromServer;
	private final static int RIGHT = 1;
	private final static int LEFT = 2;
	private final static int SHIFTF5 = 0;
	private final static int ESC = 3;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        forward = (ImageButton)this.findViewById(R.id.next);
        back = (ImageButton)this.findViewById(R.id.back);
        forward.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
	        	try {
	        	
	        	System.out.println("send the escape");
	        	} catch (IOException e) {
	        	e.printStackTrace();
	        	}
	        	
			}
		});
    }
}