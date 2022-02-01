package com.tencent.qqmail.advertise;

import android.text.TextUtils;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.File;
import java.io.FilenameFilter;

public class AdvertiseFileUtils
{
  public static final String TAG = AdvertiseFileUtils.class.getSimpleName();
  private static volatile AdvertiseFileUtils instance;
  public final FilenameFilter noMediaFilter = new AdvertiseFileUtils.1(this);
  
  public static AdvertiseFileUtils getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new AdvertiseFileUtils();
      }
      return instance;
    }
    finally {}
  }
  
  public void clearCurrAdvertiseImagePath()
  {
    QMLog.log(4, TAG, "clearCurrAdvertiseImagePath");
    File[] arrayOfFile = getInstance().listCurrAdvertiseImage();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0)) {}
    for (;;)
    {
      return;
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        arrayOfFile[i].delete();
        i += 1;
      }
    }
  }
  
  public void clearLastPushImagePath()
  {
    QMLog.log(4, TAG, "clearLastPushImagePath");
    File[] arrayOfFile = getInstance().listLastPushImage();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0)) {}
    for (;;)
    {
      return;
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        arrayOfFile[i].delete();
        i += 1;
      }
    }
  }
  
  public File[] listCurrAdvertiseImage()
  {
    String str = FileUtil.getAdvertiseImgDir();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return new File(str).listFiles(this.noMediaFilter);
  }
  
  public String[] listCurrAdvertiseImagePath()
  {
    String str = FileUtil.getAdvertiseImgDir();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return new File(str).list(this.noMediaFilter);
  }
  
  public File[] listLastPushImage()
  {
    String str = FileUtil.getLastPushAdvertiseImgDir();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return new File(str).listFiles(this.noMediaFilter);
  }
  
  public String[] listLastPushImagePath()
  {
    String str = FileUtil.getLastPushAdvertiseImgDir();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return new File(str).list(this.noMediaFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.advertise.AdvertiseFileUtils
 * JD-Core Version:    0.7.0.1
 */