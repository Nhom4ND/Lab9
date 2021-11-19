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
public class AreaThreadServer {
    public static void main(String[] args) {
        int count;
        ServerSocket svr =null;
        Socket cl=null;
        int portServer = 3456;
        try {
            svr=new ServerSocket(portServer);
            count=0;
            while (true) {                
                cl=svr.accept();
                new NewThread(count,cl);
                count++;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
