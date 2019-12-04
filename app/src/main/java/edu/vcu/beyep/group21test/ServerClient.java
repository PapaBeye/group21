package edu.vcu.beyep.group21test;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.FileUtils;

import java.io.File;
import android.os.FileUtils;
import android.util.Log;
import android.widget.ProgressBar;

import androidx.core.app.ActivityCompat;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;


public class ServerClient extends Thread implements SeverInterface{
    public static homeScreen contxt;
    public  ServerClient(homeScreen pt){
       contxt = pt;
    }
    @Override
    public void run(){
        main();
    }

    @Override
    public void main() {
        try {

            File directory = new File(Environment.DIRECTORY_DOWNLOADS+File.separator+"REvents");
            if (!directory.exists()){
                System.out.println(directory.toString());
                directory.mkdir();
            }
            Socket Cls = new Socket("34.68.33.7",8999);
            int numfs = 1;
            int i = 0;
            while(i!=numfs) {
                byte[] contents;
                byte[] RheartB = new byte[2000];
                InputStream is = Cls.getInputStream();
                OutputStream os = Cls.getOutputStream();
                is.read(RheartB, 0, RheartB.length);
                String hb = new String(RheartB, StandardCharsets.UTF_8);
                String[] phb =  hb.split("-");
                numfs = Integer.parseInt(phb[1]);
                hb = phb[0];
                String shb = hb + "-";
                byte[] heartB = shb.getBytes();
                int s = Integer.parseInt(hb);
                contents = new byte[s];
                System.out.println(s);
                os.write(heartB, 0, heartB.length);
                is.read(contents, 0, contents.length);
                String ev = new String(contents);
                contxt.Events.add(ev);
                System.out.println(new String(contents));
                os.flush();
                i++;

            }
            Cls.close();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

}

