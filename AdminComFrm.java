package cn.itcast.accountinglearn.JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class AdminComFrm {
        private DatagramSocket socket;
        private int port;
        private JFrame frame;
        private JTextArea showArea;
        private JTextField inputField;
        private JButton sendButton;
        //GUI
        public AdminComFrm(int port) throws SocketException {
            this.socket = new DatagramSocket(port);
            this.port = port;
            initUI();
            receiveMessages();
        }

        private void initUI() {
            frame = new JFrame("社区交流——管理员");
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
                        sendMessage(inputField.getText(), InetAddress.getByName("localhost"), 4446);
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
        public void sendMessage(String message, InetAddress address, int port) throws IOException {
            byte[] buf = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
            socket.send(packet);
            showArea.append("我: " + message + "\n");
        }
        public void receiveMessages() {
            new Thread(() ->{
                try {
                    byte[] buf = new byte[256];
                    while (true) {
                        DatagramPacket packet = new DatagramPacket(buf, buf.length);
                        socket.receive(packet);
                        String received = new String(packet.getData(), 0, packet.getLength());
                        InetAddress address = packet.getAddress();
                        int port = packet.getPort();
                        showArea.append("用户: " + received + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        public static void main(String[] args) throws Exception {
            new AdminComFrm(4445);
        }
    }

