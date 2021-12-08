
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.Position;

import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Caller_C
{
    public static void main(String[] args)
    {
        new X();    
    }    
}


class X extends JFrame
{
    public X()
    {
        Font font1 = new Font("Calibri",Font.BOLD,30);
        Font font2 = new Font("Calibri",Font.BOLD,20);
        Font font3 = new Font("Calibri",Font.PLAIN,20);

        JPanel layout = new JPanel();
        JPanel layout1 = new JPanel();
        JPanel layout2 = new JPanel();
        JPanel layout3 = new JPanel();
        JPanel layout4 = new JPanel();
        JLabel heading = new JLabel("Login Page");
        heading.setFont(font1);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel N = new JLabel("Enter your name: "); 
        N.setFont(font2);
        N.setAlignmentX(LEFT_ALIGNMENT);
        JTextField name = new JTextField();
        name.setFont(font3);
        name.setColumns(18);
        name.setMinimumSize(new Dimension(1000, 30));
        name.setPreferredSize(new Dimension(1000, 30));
        name.setMaximumSize(new Dimension(1000, 30));

        JLabel IP = new JLabel("Enter IP Address: ");
        IP.setFont(font2);
        JTextField address = new JTextField();
        address.setFont(font3);
        address.setColumns(18);
        address.setMinimumSize(new Dimension(200, 30));
        address.setPreferredSize(new Dimension(200, 30));
        address.setMaximumSize(new Dimension(200, 30));

        JLabel P = new JLabel("Enter password(pin): ");
        P.setFont(font2);
        P.setAlignmentX(30);
        JTextField password = new JTextField();
        password.setFont(font3);
        password.setColumns(18);
        password.setMinimumSize(new Dimension(200, 30));
        password.setPreferredSize(new Dimension(200, 30));
        password.setMaximumSize(new Dimension(200, 30));


        JButton b = new JButton("Proceed");
        b.setAlignmentY(CENTER_ALIGNMENT);

        heading.setBorder(BorderFactory.createEmptyBorder(25,50,25,50));


        layout1.setBackground(Color.white);
        layout1.setBorder(BorderFactory.createEmptyBorder(100,100,25,100));
        layout1.add(N);
        layout1.add(name);

        layout2.setBackground(Color.white);
        layout2.setBorder(BorderFactory.createEmptyBorder(25,100,25,100));
        layout2.add(IP);
        layout2.add(address);

        layout3.setBackground(Color.white);
        layout3.setBorder(BorderFactory.createEmptyBorder(25,100,25,100));
        layout3.add(P);
        layout3.add(password);

        layout4.setBackground(Color.white);
        layout4.setBorder(BorderFactory.createEmptyBorder(35,100,25,100));
        layout4.add(b);

        layout.setBackground(Color.white);
        layout.add(layout1);
        layout.add(layout2);
        layout.add(layout3);
        layout.add(layout4);

        this.setTitle("CHAT APPLICATION");
        this.setLayout(new BorderLayout());
        add(heading,BorderLayout.NORTH);
        add(layout,BorderLayout.CENTER);
        
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String n = name.getText();
                String p = password.getText();
                String ip = address.getText();
                new Client(n,p,ip);
                dispose();
            }
        });

		this.setTitle("CHAT APPLICATION");
		this.setSize(600,700);
		this.setLocation(800, 100);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(layout);
    }
}