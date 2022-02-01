package com.tencent.manager.c;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.util.e.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.UUID;

public class c
{
  private static String a = "";
  
  public static String a(Context paramContext)
  {
    if (!TextUtils.isEmpty(a)) {
      return a;
    }
    paramContext = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/now/", "DEVICE_ID");
    try
    {
      if (paramContext.exists()) {
        a = a(paramContext);
      }
      for (;;)
      {
        return a;
        a = UUID.randomUUID().toString();
        paramContext.createNewFile();
        a(paramContext, a);
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        a.b("DeviceUtil", "e=" + paramContext.toString());
      }
    }
  }
  
  private static String a(File paramFile)
  {
    paramFile = new RandomAccessFile(paramFile, "r");
    byte[] arrayOfByte = new byte[(int)paramFile.length()];
    paramFile.readFully(arrayOfByte);
    paramFile.close();
    return new String(arrayOfByte);
  }
  
  private static void a(File paramFile, String paramString)
  {
    paramFile = new FileOutputStream(paramFile);
    paramFile.write(paramString.getBytes());
    paramFile.close();
  }
  
  public static int b(Context paramContext)
  {
    return a(paramContext).hashCode() & 0x7FFFFFFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.manager.c.c
 * JD-Core Version:    0.7.0.1
 */