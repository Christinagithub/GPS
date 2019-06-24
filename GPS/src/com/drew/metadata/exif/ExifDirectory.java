package com.drew.metadata.exif;

import java.io.File;

import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.liusoft.dlog4j.test.JpegMetadataReader;

public class ExifDirectory {
	private static final String TAG_MODEL = null;
	private File jpegFile;
	Metadata metadata = JpegMetadataReader.readMetadata(jpegFile);
	Directory exif = metadata.getDirectory(ExifDirectory.class);
	String model = exif.getString(ExifDirectory.TAG_MODEL);
	
}

