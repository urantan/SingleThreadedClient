/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleThreadedClientTest;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Ngozi Francis Uranta
 */
public class SingleThreadedClientTest {
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        InetAddress ClientAddress;
        clientUserInterface.ClientUserInterface UserInterface= new clientUserInterface.ClientUserInterface();
        singlethreadedclient.SingleThreadedClient client = new singlethreadedclient.SingleThreadedClient();
        
        UserInterface.display("d:\tDisconnect\n"
                     + "t:\tTime\n"
                     + "c:\tConnect\n");
         String ToPrint = "";
        while(true){
            
            String input = UserInterface.GetString();
            
            switch(input){
                case "c":
                    client.StartServer("localhost", 5555);
                    break;
                case "d":
                    //client.StopServer();
                    // need to send d to the server
                    client.sendMsgToServer((byte) 'd');
                    UserInterface.display("The client sucessfully disconnected");
                    break;
                case "t":
                    //client.sendMsgToServer((byte) 't');
                    if(client.sendMsgToServer((byte) 't')){
                    UserInterface.display("Waiting to recieve time");}
                    else{
                    UserInterface.display("Msg not sent successfully");
                    }
                    //char [] arrayTime = new char[7];
                    var arrayList = new ArrayList<String>();

                    boolean check = true;
                    while(check){
                    
                        byte recievedValue = client.GetMsgFromServer();
                            var value = (char)recievedValue;
                            String charValue = String.valueOf(value);
                                arrayList.add(charValue);
                        if(arrayList.size() == 7)
                        {check = false;}
                    }
                    if(arrayList.size() == 7){
                       
                   for(int i =0; i< arrayList.size(); i++){
                      ToPrint +=  arrayList.get(i);
                   }
                    }
                  }
             UserInterface.display(ToPrint);
        }
       
        
        
    }
}
