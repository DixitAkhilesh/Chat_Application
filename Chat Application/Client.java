import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Client extends JFrame
{
	ServerSocket server;
	Socket socket;
	BufferedReader br;
	PrintWriter out;

	private JTextArea messageArea = new JTextArea();
	private JTextField messageInput = new JTextField();
	private Font font = new Font("Roboto",Font.BOLD,20);
	private Font font1 = new Font("Roboto",Font.PLAIN,20);
	String name;
	String password;
	String ip;

	public Client()
	{

	}
	public Client(String name, String password, String ip)
	{
		try
		{
			this.name = name;
			this.password = password;
			this.ip = ip;
			socket = new Socket(ip,Integer.parseInt(password));

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());

			createGUI();
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
						System.exit(1);
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
		JLabel heading = new JLabel(name + "'s Area");
		messageArea.setLineWrap(true);
		this.setTitle("CHAT APPLICATION");
		this.setSize(600,700);
		this.setLocation(800, 150);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		heading.setFont(font);
		messageArea.setFont(font1);
		messageArea.setEditable(false);
		messageInput.setFont(font1);
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
		Runnable r1 =()->
		{
			try
			{
				while(true)
				{
					String message = br.readLine();
					if(message.equals("exit"))
					{
						JOptionPane.showMessageDialog(this,"Boss Terminated the chat.");
						socket.close();
						System.exit(1);
						break;
					}
					messageArea.append("Boss: " + message + "\n");
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
		new Client();
	}
}
