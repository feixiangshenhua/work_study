package com.sand.image;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class ImgHelper {

	/**
     * TODO:将byte数组以Base64方式编码为字符串
     * @param bytes 待编码的byte数组
     * @return 编码后的字符串
     * */
    public static String encode(byte[] bytes){
        return new BASE64Encoder().encode(bytes);
    }
    
    /**
     * TODO:将以Base64方式编码的字符串解码为byte数组
     * @param encodeStr 待解码的字符串
     * @return 解码后的byte数组
     * @throws IOException 
     * */
    public static byte[] decode(String encodeStr) throws IOException{
        byte[] bt = null;  
        BASE64Decoder decoder = new BASE64Decoder();  
        bt = decoder.decodeBuffer(encodeStr);
        return bt;
    }
    
    /**
     * TODO:将两个byte数组连接起来后，返回连接后的Byte数组
     * @param front 拼接后在前面的数组
     * @param after 拼接后在后面的数组
     * @return 拼接后的数组
     * */
    public static byte[] connectBytes(byte[] front, byte[] after){
        byte[] result = new byte[front.length + after.length];
        System.arraycopy(front, 0, result, 0, after.length);
        System.arraycopy(after, 0, result, front.length, after.length);
        return result;
    }
    
    /**
     * 把字节数组转换为字节流
     * @param bytes
     * @return
     */
    public static InputStream bytes2InputStream(byte[] bytes) {
        InputStream input = new ByteArrayInputStream(bytes);        
        return input;
    }
    
    /**
     * TODO:将图片以Base64方式编码为字符串
     * @param imgUrl 图片的绝对路径（例如：D:\\jsontest\\abc.jpg）
     * @return 编码后的字符串
     * @throws IOException 
     * */
    public static String encodeImage(String imgUrl) throws IOException{
        FileInputStream fis = new FileInputStream(imgUrl);
        byte[] rs = new byte[fis.available()];
        fis.read(rs);
        fis.close();
        return encode(rs);
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        String str;
        try {
            str = encodeImage("D:\\a.png");
            //c9x8O8k48AjGQbPInw5X0YwCVJwA6HgbwjBMGBwcyDPEer/B7QGmUY6rd9EAAAAAElFTkSuQmCC
            System.out.println(str);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
