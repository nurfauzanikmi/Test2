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

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TEST2 {
    public static void main(String[] args){
	try 
        {	
            //get NIC information
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("IP address : " + Arrays.toString(ip.getAddress()));
            System.out.println("Host address : " + ip.getHostAddress());
            System.out.println("Host Name : " + ip.getHostName());
            System.out.println("Canonical Host Name : "+ip.getCanonicalHostName());
                        
            /*byte[] iptest = new byte[] { 127, 0, 0, 1};
            InetAddress addr = InetAddress.getByAddress(iptest);
            String HostNameCanonical = addr.getCanonicalHostName();
            System.out.println("Canonical Host Name (127.0.0.1) : "+HostNameCanonical);
            */        
            
            //get MAC Address
            NetworkInterface nic = NetworkInterface.getByInetAddress(ip);
            byte[] MACaddr = nic.getHardwareAddress();
            //print out mac address
            System.out.print("Current MAC address : ");
            //convert byte to hexadecimal
            /*
                % starts a format spec
                0 means left-pad with zero
                2 means 2 digits wide
                X means hexadecimal output
                s means string
            */
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < MACaddr.length; i++) {
                if(i < MACaddr.length - 1)
                    sb.append(String.format("%02X%s", MACaddr[i], "-"));		
                else
                     sb.append(String.format("%02X%s", MACaddr[i], "-"));
            }
            System.out.println(sb.toString());

        }catch (UnknownHostException e) {
		e.printStackTrace();
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
   }
}
