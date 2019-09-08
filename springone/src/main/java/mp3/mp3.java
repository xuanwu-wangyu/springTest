package mp3;


import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import sun.nio.cs.ext.EUC_TW;
import sun.nio.cs.ext.HKSCS;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.channels.FileChannel;


public class mp3 {

    String pathFile;
    public static void main(String[] args) throws Exception {
        mp3 t = new mp3();
        t.set();
    }

    public void set() throws Exception{
        get();
        String path = pathFile+"test.mp3";
        MP3File mp3File = new MP3File(path);//封装好的类
        MP3AudioHeader header = mp3File.getMP3AudioHeader();
        String bitRate = header.getBitRate();
        System.out.println(bitRate);
        System.out.println(header.getTrackLength());
        File file = new File(path);
        file.delete();
    }



    public  void get() throws Exception{
        pathFile = this.getClass().getResource("/").getPath();
        String path = "https://hifive-music.oss-cn-shanghai.aliyuncs.com/music_cp_web/mp3/testmusic.mp3";

        String path1 = "1.1";
        String[] split2 = path1.split(".");

        String[] split1 = path.split("/");


        path.replace("//",",");
        path.replace("\\","");
        String[] split = path.split(".");
        URL url = new URL(path);
        InputStream in=url.openConnection().getInputStream(); //创建连接、输入流
        FileOutputStream f = new FileOutputStream(pathFile+"test.mp3");//创建文件输出流
        byte [] bb=new byte[1024]; //接收缓存
        int len;
        while( (len=in.read(bb))>0){ //接收
            f.write(bb, 0, len); //写入文件
        }
        f.close();
        in.close();
    }

}
