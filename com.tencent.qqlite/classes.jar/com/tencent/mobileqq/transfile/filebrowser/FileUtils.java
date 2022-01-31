package com.tencent.mobileqq.transfile.filebrowser;

import android.net.Uri;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Video.Media;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils
{
  public static final int a = 0;
  static final String a = "FileUtils";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  
  public static int a(String paramString1, String paramString2)
  {
    Object localObject = null;
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0)) {
      return 1;
    }
    if (!c(paramString1)) {
      return 2;
    }
    for (;;)
    {
      try
      {
        paramString1 = new FileInputStream(paramString1);
      }
      catch (IOException paramString1)
      {
        paramString1 = null;
        paramString2 = str;
        continue;
      }
      try
      {
        paramString2 = new FileOutputStream(paramString2);
        try
        {
          byte[] arrayOfByte = new byte[1024];
          int i = paramString1.read(arrayOfByte);
          if (i > 0)
          {
            paramString2.write(arrayOfByte, 0, i);
            continue;
            if (paramString2 == null) {}
          }
        }
        catch (IOException localIOException)
        {
          str = paramString2;
          paramString2 = paramString1;
          paramString1 = str;
        }
      }
      catch (IOException paramString2)
      {
        str = null;
        paramString2 = paramString1;
        paramString1 = str;
        continue;
      }
      try
      {
        paramString2.close();
        if (paramString1 != null) {
          paramString1.close();
        }
      }
      catch (Exception paramString1)
      {
        continue;
      }
      return 3;
      paramString1.close();
      try
      {
        paramString2.close();
        return 0;
      }
      catch (IOException paramString1)
      {
        paramString1 = paramString2;
        paramString2 = str;
      }
    }
  }
  
  public static Uri a(File paramFile)
  {
    return Uri.parse("file://" + paramFile.getAbsolutePath());
  }
  
  public static File a(Uri paramUri)
  {
    if (paramUri != null)
    {
      String str = paramUri.toString();
      paramUri = str;
      if (str.startsWith("file://")) {
        paramUri = str.substring(7);
      }
      return new File(paramUri);
    }
    return null;
  }
  
  public static File a(File paramFile)
  {
    if (paramFile != null)
    {
      if (paramFile.isDirectory()) {
        return paramFile;
      }
      String str = paramFile.getName();
      paramFile = paramFile.getAbsolutePath();
      str = paramFile.substring(0, paramFile.length() - str.length());
      paramFile = str;
      if (str.endsWith("/")) {
        paramFile = str.substring(0, str.length() - 1);
      }
      return new File(paramFile);
    }
    return null;
  }
  
  public static File a(File paramFile, String paramString)
  {
    return a(paramFile.getAbsolutePath(), paramString);
  }
  
  public static File a(String paramString1, String paramString2)
  {
    String str = "/";
    if (paramString1.endsWith("/")) {
      str = "";
    }
    return new File(paramString1 + str + paramString2);
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramString.lastIndexOf(".");
    if (i >= 0) {
      return paramString.substring(i);
    }
    return "";
  }
  
  public static boolean a(String paramString)
  {
    return (paramString != null) && (!paramString.startsWith("http://"));
  }
  
  public static boolean b(String paramString)
  {
    return (paramString.startsWith(MediaStore.Audio.Media.INTERNAL_CONTENT_URI.toString())) || (paramString.startsWith(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI.toString())) || (paramString.startsWith(MediaStore.Video.Media.INTERNAL_CONTENT_URI.toString())) || (paramString.startsWith(MediaStore.Video.Media.EXTERNAL_CONTENT_URI.toString()));
  }
  
  public static boolean c(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() <= 0) {}
    }
    try
    {
      bool1 = new File(paramString).exists();
      return bool1;
    }
    catch (Exception paramString)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Tools.isFileExists", 2, "" + paramString.getMessage());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.filebrowser.FileUtils
 * JD-Core Version:    0.7.0.1
 */