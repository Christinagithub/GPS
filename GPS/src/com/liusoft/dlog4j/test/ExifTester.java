
package com.liusoft.dlog4j.test;
 
import java.io.File;
import java.util.Iterator;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifDirectory;
 
/**
 * 测试用于读取图片的EXIF信息
 * @author Winter Lau
 */
public class ExifTester {
	public static void main(String[] args) throws Exception {
	File jpegFile = new File("‪C:\\Users\\LENOVO\\Pictures\\Saved Pictures\\20190624090418.jpg");
    Metadata metadata = JpegMetadataReader.readMetadata(jpegFile);
    Directory exif = metadata.getDirectory(ExifDirectory.class);
    Iterator tags = exif.getTagIterator();
    while (tags.hasNext()) {
        Tag tag = (Tag)tags.next();
        System.out.println(tag);
    }
    }
}

