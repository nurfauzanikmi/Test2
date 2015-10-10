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
import java.util.Arrays;

public class TEST2 {
    public static void main(String[] args){
		
	InetAddress ip;
	try 
        {	
            //get NIC information
            ip = InetAddress.getLocalHost();
            System.out.println(" IP address : " + Arrays.toString(ip.getAddress()));
            System.out.println(" Host address : " + ip.getHostAddress());
            System.out.println(" Host Name : " + ip.getHostName());
            
        }catch (UnknownHostException e) {
		
		e.printStackTrace();
        }
   }
}
