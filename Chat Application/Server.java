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
	private JLabel heading = new JLabel("Server Area");
	private JTextArea messageArea = new JTextArea();
	private JTextField messageInput = new JTextField();
	private Font font = new Font("Roboto",Font.BOLD,20);
	private Font font1 = new Font("Roboto",Font.PLAIN,20);

	public Server(){
		try
		{
			// server = new ServerSocket(7777);
			// System.out.println("Server is ready to connect...");
			// System.out.println("waiting...");
			// socket = server.accept();
			// System.out.println("Succcessfully Connected!");

			// br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// out = new PrintWriter(socket.getOutputStream());

			createGUI();
			handleEvents();
			Read();
			// Write();
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
						messageArea.append("Me: " + message + "\n" );
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
		this.setTitle("CHAT APPLICATION");
		this.setSize(600,700);
		this.setLocation(200, 100);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon Image = new ImageIcon("icon.png");
		heading.setFont(font);
		messageArea.setFont(font1);
		messageInput.setFont(font1);
		messageArea.setEditable(false);
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

		this.setLayout(new BorderLayout());

		add(heading, BorderLayout.NORTH);
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
						System.out.println("Client Terminated the Chat!");
						JOptionPane.showMessageDialog(this,"Client Terminated the chat.");
						messageInput.setEnabled(false);
						socket.close();
						System.exit(1);
						break;		
					}

					messageArea.append("Client: " + message + "\n");
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