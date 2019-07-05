package com.drew.metadata.exif;

import java.io.File;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

public class SampleUsage {
	  public static void main(String[] args) throws Exception, Exception{  
        File file = new File("C:\\\\Users\\\\LENOVO\\\\Pictures\\\\Saved Pictures\\\\20190624090418.jpg");  
        printImageTags(file);
}
	private static void printImageTags(File file) throws ImageProcessingException, Exception{  
        Metadata metadata = ImageMetadataReader.readMetadata(file);  
        for (Directory directory : metadata.getDirectories()) {  
            for (Tag tag : directory.getTags()) {  
                String tagName = tag.getTagName();  //标签名
                String desc = tag.getDescription(); //标签信息
                if (tagName.equals("Image Height")) {  
                    System.out.println("图片高度: "+desc);
                } else if (tagName.equals("Image Width")) {  
                    System.out.println("图片宽度: "+desc);
                } else if (tagName.equals("Date/Time Original")) {  
                    System.out.println("拍摄时间: "+desc);
                }else if (tagName.equals("GPS Latitude")) {  
                    System.err.println("纬度 : "+desc);
//                    System.err.println("纬度(度分秒格式) : "+pointToLatlong(desc));
                } else if (tagName.equals("GPS Longitude")) {  
                    System.err.println("经度: "+desc);
//                    System.err.println("经度(度分秒格式): "+pointToLatlong(desc));
         }
  }  
       }  
	}
}