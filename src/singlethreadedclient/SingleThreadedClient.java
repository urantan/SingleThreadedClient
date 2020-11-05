/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlethreadedclient;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Ngozi Francis Uranta
 */
public class SingleThreadedClient {

    Socket socket;
    InputStream in;
    OutputStream out;
    int port;

    public SingleThreadedClient() {
        in = null;
        out = null;
    }

    public void StartServer(String host, int PortNum) {

        try {
            InetAddress ad = InetAddress.getByName(host);
            socket = new Socket(ad, PortNum);
            if (socket != null) {
                System.out.println("Connected");
            }
            in = socket.getInputStream();
            out = socket.getOutputStream();
        } catch (IOException e) {
            System.err.println("Cannot Connect to Server");
        }
    }

    public void StopServer() {
        try {
            socket.close();
            this.in = null;
            this.out = null;
        } catch (IOException e) {
            System.err.println("Cannot close stream or client socket; exiting");
            System.exit(1);
        }

    }

    public int getPort() {

        return socket.getLocalPort();
    }

    public void setPort(int portNum) {

        port = portNum;

    }

    public boolean sendMsgToServer(byte MsgToSend) {
        boolean returnValue = false;

        try {
            out.write(MsgToSend);
            returnValue = true;
        } catch (IOException e) {
            System.err.println("Invalid Command");
            returnValue = false;
        }
        return returnValue;
    }

    public byte GetMsgFromServer() {

        byte msg = (byte) -1;

        try {
            msg = (byte) in.read();
        } catch (IOException i) {
            System.err.println("Inputstream empty");
        } finally {
            return msg;
        }
    }
}
