import java.io.*;
import java.net.*;


public class Crawler{
	public static void main(String[] args) throws IOException {
 
        //新建一個url物件 通過構造方法傳入url值
        URL url = new URL("https://tcssh.tc.edu.tw/");
        //建立Java和url的一個連線，相當於我們訪問網址，不同的是Java返回的是connection 我們肉眼返回的是網頁內容
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //通過相應狀態碼判斷是否訪問成功
        int code = connection.getResponseCode();
        if (code != 200) {
            return;
        }
        //獲取connection對網頁訪問之後 的一個輸入流，該流中包含了網頁的資訊內容
        InputStream stream = connection.getInputStream();
        //通過BufferedReader 獲取流中的資訊
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "utf-8"));
        //輸出資訊
        String r = null;

        FileWriter fw = new FileWriter("C:/Users/user/Desktop/text.txt");
		
		

        while ((r = reader.readLine()) != null) {
            fw.write(r+"\n");
        }

        fw.flush();
		fw.close();
    }    
}
