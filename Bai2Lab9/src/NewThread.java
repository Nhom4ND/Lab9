/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.net.*;
import java.io.*;
import javax.swing.*;
/**
 *
 * @author Welcome
 */
public class NewThread extends Thread{
    private int count;
    private Socket cl=null;
    BufferedReader inp = null;
    PrintWriter outp = null;
    JTextArea txa;

    public NewThread(int count,Socket cl,JTextArea txaArea ) {
        super();
        this.cl=cl;
        this.count = count;
        txa=txaArea;
        start();
    }
    public void run()
    {
        try {
            inp=new BufferedReader(new InputStreamReader(cl.getInputStream()));
            outp=new PrintWriter(cl.getOutputStream(),true);
            double r = Double.parseDouble(inp.readLine());
            InetAddress addrClient =cl.getInetAddress();
            int portClient=cl.getPort();
            double area = 3.14*r*r;
            txa.append("Luong thu: "+count+", Client: "+addrClient.getHostName()+", IP: "+addrClient.getHostAddress()+
                    ", Port: "+portClient+", r= "+r+", Area= "+area);
            outp.println(area);
            inp.close();
            outp.close();
            cl.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
}
