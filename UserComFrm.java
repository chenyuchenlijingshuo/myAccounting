package cn.itcast.accountinglearn.JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UserComFrm {
        private DatagramSocket socket;
        private InetAddress address;
        private int port;

        private JFrame frame;
        private JTextArea showArea;
        private JTextField inputField;
        private JButton sendButton;

        public UserComFrm(String address, int port) throws Exception {
            this.socket = new DatagramSocket();
            this.address = InetAddress.getByName(address);
            this.port = port;
            initUI();
            receiveMessages();
        }

        private void initUI() {
            frame = new JFrame("社区交流——用户");
            showArea = new JTextArea();
            showArea.setEditable(false);
            inputField = new JTextField(30);
            sendButton = new JButton("发送");

            JPanel panel = new JPanel(new BorderLayout());
            panel.add(inputField, BorderLayout.CENTER);
            panel.add(sendButton, BorderLayout.EAST);

            frame.setLayout(new BorderLayout());
            frame.setLocation(550,300);
            frame.add(new JScrollPane(showArea), BorderLayout.CENTER);
            frame.add(panel, BorderLayout.SOUTH);

            sendButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        sendMessage(inputField.getText());
                        inputField.setText("");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }

        public void sendMessage(String message) throws IOException {
            byte[] buf = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
            socket.send(packet);
            showArea.append("我: " + message + "\n");
        }
        public void receiveMessages(){
            new Thread(() -> {
                try {
                    byte[] buf = new byte[256];
                    while (true) {
                        DatagramPacket packet = new DatagramPacket(buf, buf.length);
                        socket.receive(packet);
                        String received = new String(packet.getData(), 0, packet.getLength());
                        showArea.append("管理员: " + received + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        public static void main(String[] args) throws Exception {
            new UserComFrm("localhost", 4445);
        }
    }

