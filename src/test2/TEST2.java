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

public class TEST2{
    public static void main(String[] args)throws InterruptedException{
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
            
            //First Request - IPV6
            /*
            System.out.println(System.getProperty("java.home"));
            System.setProperty("java.net.preferIPv6Addresses", "true");
            System.out.println(System.getProperty("java.net.preferIPv6Addresses"));
           */
            //System.out.println("Check IP address version :" + ip.isLinkLocalAddress());
            
            InetAddress[] addr = InetAddress.getAllByName(ip.getHostName());
            for (InetAddress ipv6 : addr) {
                if (ipv6 instanceof Inet6Address) {
                    System.out.println("ipv6 address is " + ipv6.getHostAddress());
                }
                else
                    System.out.println("ipv4 address is " + ipv6.getHostAddress());
            }
            
            //Threads
            /*Threads Feature
                Counting Threads, Run, Start, Join, Sleep Thread
            */
            //Determine Number of threads and count
            int numThreads = 4;
            int count = 2;
            Thread[] threads = new Thread[numThreads];
            System.out.println("Creating threads");
            
            System.out.println(threads.length+":Thread Length");
            for (int i = 0; i < threads.length; i++){
              threads[i] = new Thread(new Runner("Runner " + i, count));
            }
            System.err.println("Sleeping Thread started");
            //threads sequence
            System.out.println("Starting threads");
            for (int i = 0; i < threads.length; i++) { threads[i].start(); }
            System.out.println("Waiting for threads");
            for (int i = 0; i < threads.length; i++) { threads[i].join(); }
            System.out.println("Done");
            
            for (int i = 0; i < threads.length; i++){
              threads[i] = new SleepThread(threads[i].getName());
            }
            System.err.println("Sleeping Thread started");

        }catch (UnknownHostException e) {
		e.printStackTrace();
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
   }
}

class Runner implements Runnable {
  private final String name;
  private final int count;
  public Runner(String name, int count) {
    this.name = name; this.count = count;
  }
  public void run() {
    for (int i = 0; i < count; i++) {
      System.out.println(name + "=" + i);
      Thread.yield();
    }
  }
}

class SleepThread extends Thread{
    private int sleepTime;
    public SleepThread(String threadName) {
        super(threadName);
        sleepTime = (int) (Math.random()*5000);
        System.err.println("Name : "+threadName+"; sleep: "+ sleepTime );
    }
     
    public void run(){
        try {
            System.err.println(getName()+" going to sleep ");
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            System.err.println(e.toString());
        }
        System.err.println(getName()+" done sleeping");
    }
}

