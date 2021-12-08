
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

public class Caller
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
  
        JLabel P = new JLabel("Set password(pin): ");
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
        layout2.add(P);
        layout2.add(password);

        layout3.setBackground(Color.white);
        layout3.setBorder(BorderFactory.createEmptyBorder(35,100,25,100));
        layout3.add(b);

        layout.setBackground(Color.white);
        layout.add(layout1);
        layout.add(layout2);
        layout.add(layout3);


        this.setTitle("CHAT APPLICATION");
        this.setLayout(new BorderLayout());
        add(heading,BorderLayout.NORTH);
        add(layout,BorderLayout.CENTER);
        
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
                dispose();
                String n = name.getText();
                String p = password.getText();
                new Server(n,p);
            }
        });

		this.setTitle("CHAT APPLICATION");
		this.setSize(600,700);
		this.setLocation(200, 100);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(layout);
    }
}