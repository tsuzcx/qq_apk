package com.tencent.moai.downloader;

import android.content.Context;
import com.tencent.moai.downloader.delegate.LogDelegate;
import com.tencent.moai.downloader.util.Logger;
import com.tencent.moai.downloader.util.StringUtil;

public class DownloadManager
{
  private static final String TAG = "DownloadManager";
  private static Context context;
  private static DownloadManager instance;
  
  public static DownloadManager createInstance(Context paramContext)
  {
    context = paramContext;
    instance = new DownloadManager();
    return instance;
  }
  
  public static DownloadManager shareInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new DownloadManager();
      }
      return instance;
    }
    finally {}
  }
  
  public Context getContext()
  {
    return context;
  }
  
  public void setDefaultTmpFileDir(String paramString)
  {
    if (!StringUtil.isNullOrEmpty(paramString)) {
      GlobalConfig.DEFAULT_TMP_FILE_DIR = paramString;
    }
  }
  
  public void setDefaultTmpFileSize(long paramLong)
  {
    GlobalConfig.DEFAULT_TMP_FILE_SIZE = paramLong;
  }
  
  public void setLogDelegate(LogDelegate paramLogDelegate)
  {
    Logger.setDelegate(paramLogDelegate);
  }
  
  public void setMaxThreadSize(int paramInt)
  {
    GlobalConfig.MAX_THREAD_SIZE = paramInt;
  }
  
  public void setMaxThreadTaskSize(int paramInt)
  {
    GlobalConfig.MAX_THREAD_TASK_SIZE = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.DownloadManager
 * JD-Core Version:    0.7.0.1
 */