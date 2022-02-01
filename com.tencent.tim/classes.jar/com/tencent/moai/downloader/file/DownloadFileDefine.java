package com.tencent.moai.downloader.file;

import android.os.Environment;
import java.io.File;

public class DownloadFileDefine
{
  public static final String EXTERNAL_DOWNLOAD = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
  public static final String EXTERNAL_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.file.DownloadFileDefine
 * JD-Core Version:    0.7.0.1
 */