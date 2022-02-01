package com.tencent.moai.downloader;

import com.tencent.moai.downloader.file.DownloadFileDefine;

public class GlobalConfig
{
  public static int CONNECT_TIME_OUT = 32000;
  public static String DEFAULT_TMP_FILE_DIR = DownloadFileDefine.EXTERNAL_DOWNLOAD + "/tmp";
  public static long DEFAULT_TMP_FILE_SIZE = 2097152L;
  public static int MAX_THREAD_SIZE = 0;
  public static int MAX_THREAD_TASK_SIZE = 0;
  public static final int READ_TIME_OUT = 50000;
  public static final Integer RECEIVE_BUFF_LEN_INTEGER;
  public static final Integer SEND_BUFF_LEN_INTEGER = Integer.valueOf(32768);
  private static final int SIZE_UNIT = 1024;
  public static final int WRITE_TIME_OUT = 50000;
  
  static
  {
    RECEIVE_BUFF_LEN_INTEGER = Integer.valueOf(32768);
    MAX_THREAD_SIZE = 15;
    MAX_THREAD_TASK_SIZE = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.GlobalConfig
 * JD-Core Version:    0.7.0.1
 */