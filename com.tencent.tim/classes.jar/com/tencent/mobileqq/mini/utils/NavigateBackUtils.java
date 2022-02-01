package com.tencent.mobileqq.mini.utils;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class NavigateBackUtils
{
  public static final String NAVIGATE_BACK_APPID_FILE_PATH = PATH_WXAPKG_ROOT + "navigateback_appid";
  public static final String PATH_WXAPKG_ROOT = BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/mini/";
  public static final String TAG = "NavigateBackUtils";
  
  public static void clearTag()
  {
    File localFile = new File(NAVIGATE_BACK_APPID_FILE_PATH);
    if (localFile.exists()) {
      localFile.delete();
    }
  }
  
  public static String getTagAppid()
  {
    Object localObject = new File(NAVIGATE_BACK_APPID_FILE_PATH);
    if (((File)localObject).exists())
    {
      try
      {
        localBufferedReader = new BufferedReader(new FileReader((File)localObject));
        QLog.e("NavigateBackUtils", 2, "getTagAppid exception!", localException1);
      }
      catch (Exception localException1)
      {
        try
        {
          localObject = localBufferedReader.readLine();
          localBufferedReader.close();
          return localObject;
        }
        catch (Exception localException3)
        {
          BufferedReader localBufferedReader;
          break label48;
        }
        localException1 = localException1;
        localBufferedReader = null;
      }
      label48:
      if (localBufferedReader == null) {}
    }
    try
    {
      localBufferedReader.close();
      label65:
      return "";
    }
    catch (Exception localException2)
    {
      break label65;
    }
  }
  
  public static void writeTagAppid(String paramString)
  {
    Object localObject = new File(NAVIGATE_BACK_APPID_FILE_PATH);
    do
    {
      try
      {
        localObject = new BufferedWriter(new FileWriter((File)localObject));
        QDLog.e("NavigateBackUtils", "getTagAppid exception!", paramString);
      }
      catch (Exception paramString)
      {
        try
        {
          ((BufferedWriter)localObject).write(paramString);
          ((BufferedWriter)localObject).close();
          return;
        }
        catch (Exception paramString)
        {
          continue;
        }
        paramString = paramString;
        localObject = null;
      }
    } while (localObject == null);
    try
    {
      ((BufferedWriter)localObject).close();
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.NavigateBackUtils
 * JD-Core Version:    0.7.0.1
 */