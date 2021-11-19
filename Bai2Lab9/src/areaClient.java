/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.net.*;
import java.io.*;
/**
 *
 * @author Welcome
 */
public class areaClient {
    public static void main(String[] args) {
        Socket cl =null;
        BufferedReader inp=null;
        PrintWriter outp = null;
        BufferedReader key = null;
        String ipServer = "127.0.0.1";
        int portServer=3456;
        String r ;
        try {
            cl=new Socket(ipServer,portServer);
            inp=new BufferedReader(new InputStreamReader(cl.getInputStream()));
            outp=new PrintWriter(cl.getOutputStream(),true);
            key=new  BufferedReader(new InputStreamReader(System.in));
            System.out.print("r= ");
            r=key.readLine().trim();
            outp.println(r);
            System.out.println("Area: "+inp.readLine());
            if(inp!=null)
                inp.close();
            if(key!=null)
                key.close();
            if(outp!=null)
                outp.close();
            if(cl!=null)
                cl.close();
        } catch (IOException e) {
            System.out.print(e);
        }
    }
}
