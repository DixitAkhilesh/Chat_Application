import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Server extends JFrame
{

	ServerSocket server;
	Socket socket;
	BufferedReader br;
	PrintWriter out;

	//GUI COMPONENTS
	JTextArea messageArea = new JTextArea();
	JTextField messageInput = new JTextField();
	Font font = new Font("Roboto",Font.BOLD,20);
	Font font1 = new Font("Roboto",Font.PLAIN,20);
	String name;
	String password;

	public Server()
	{

	}

	public Server(String name , String password){
		try
		{
			this.name = name;
			this.password = password;
			server = new ServerSocket(Integer.parseInt(password));
			createGUI();
			socket = server.accept();

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());

			handleEvents();
			Read();
		}
		catch (Exception e)
		{

		}
	}

	private void handleEvents()
	{
		messageInput.addKeyListener(new KeyListener()
		{

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
				if(e.getKeyCode() == 10)
				{
					String message = messageInput.getText();
					if(message == "exit")
					{

					}
					else
					{
						messageArea.append(name + ": " + message + "\n" );
						out.println(message);
						out.flush();
						messageInput.setText("");
						messageInput.requestFocus();
					}
				}	
			}
			
		});
	}

	public void createGUI()
	{
		
		JLabel heading = new JLabel(name + "'s Area");
		messageArea.setLineWrap(true);
		this.setTitle("CHAT APPLICATION");
		this.setSize(600,700);
		this.setLocation(200, 100);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel w = new JLabel(name + " is ready to connect ... waiting...");
		heading.setFont(font);
		messageArea.setFont(font1);
		messageInput.setFont(font1);
		w.setFont(font1);
		messageArea.setEditable(false);
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

		this.setLayout(new BorderLayout());

		add(heading, BorderLayout.NORTH);
		this.add(w);
		JScrollPane jScrollPane = new JScrollPane(messageArea);
		add(jScrollPane , BorderLayout.CENTER);
		add(messageInput, BorderLayout.SOUTH);

	}

	public void Read()
	{
		Runnable r1=()->
		{
			
			try
			{
				while(true)
				{
					String message = br.readLine();
					if(message.equals("exit"))
					{
						JOptionPane.showMessageDialog(this,"Employee Terminated the chat.");
						messageInput.setEnabled(false);
						socket.close();
						System.exit(1);
						break;		
					}

					messageArea.append("Employee: " + message + "\n");
				}
			}
			catch (Exception e)
			{
				
			}
		};

		new Thread(r1).start();
	}

	public static void main(String[] args)
	{
		new Server();
	}
}
