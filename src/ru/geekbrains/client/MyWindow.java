package ru.geekbrains.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {

    private JTextField jTextField;

    public MyWindow() {
        setTitle("My window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300,300,400,400);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,4));
        bottomPanel.setPreferredSize(new Dimension(10,40));
        for (int i = 1; i <4; i++) {
            JButton jButton = new JButton("Action #: " + i);
            bottomPanel.add(jButton);

         jTextField = new JTextField();
        jTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(jTextField.getText());
                jTextField.setText("");
            }
        });
        bottomPanel.add(jTextField);
        }

        JPanel centerPanel = new JPanel(new BorderLayout());
        JTextArea jTextArea = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        centerPanel.add(jScrollPane);

        JButton jbNorth = new  JButton ("Print north");
        centerPanel.add(jbNorth, BorderLayout.NORTH);
        jbNorth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea.append("NORTH!" + System.lineSeparator());
            }
        });

        add(bottomPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public JTextField getjTextField() {
        return jTextField;
    }

    public void setjTextField(JTextField jTextField) {
        this.jTextField = jTextField;
        System.out.println(jTextField);
    }
}
