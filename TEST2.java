/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

/*
 * @author Fauzan
 * Purpose : Get an information from  NIC such as MAC address
 */

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class TEST2 {
    public static void main(String[] args){
		
	InetAddress ip;
	try 
        {	
            ip = InetAddress.getLocalHost();
            System.out.println(" IP address : " + ip.getAddress());
            System.out.println(" Host address : " + ip.getHostAddress());
            
            getHostName()
public String getCanonicalHostName()
public byte[] getAddress()
public String getHostAddress()

            

           // NetworkInterface network = NetworkInterface.getByInetAddress(ip);

          /*  byte[] mac = network.getHardwareAddress();

            System.out.print("Current MAC address : ");

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                    sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
            }
            System.out.println(sb.toString());*/
			
	} catch (UnknownHostException e) {
		
		e.printStackTrace();
		
	} catch (SocketException e){
			
		e.printStackTrace();
			
	}
	    
   }
}
