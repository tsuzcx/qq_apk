package com.tencent.qflutter.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileUtils
{
  public static final String TAG = "FileUtils";
  
  public static void UnZipFolder(String paramString1, String paramString2)
    throws Exception
  {
    paramString1 = new ZipInputStream(new FileInputStream(paramString1));
    for (;;)
    {
      Object localObject2 = paramString1.getNextEntry();
      if (localObject2 == null) {
        break;
      }
      Object localObject1 = ((ZipEntry)localObject2).getName();
      if (((ZipEntry)localObject2).isDirectory())
      {
        localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString2);
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append((String)localObject1);
        new File(((StringBuilder)localObject2).toString()).mkdirs();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString2);
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append((String)localObject1);
        Log.e("FileUtils", ((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString2);
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject2 = new File(((StringBuilder)localObject2).toString());
        if (!((File)localObject2).exists())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Create the file:");
          localStringBuilder.append(paramString2);
          localStringBuilder.append(File.separator);
          localStringBuilder.append((String)localObject1);
          Log.e("FileUtils", localStringBuilder.toString());
          ((File)localObject2).getParentFile().mkdirs();
          ((File)localObject2).createNewFile();
        }
        localObject1 = new FileOutputStream((File)localObject2);
        localObject2 = new byte[1024];
        for (;;)
        {
          int i = paramString1.read((byte[])localObject2);
          if (i == -1) {
            break;
          }
          ((FileOutputStream)localObject1).write((byte[])localObject2, 0, i);
          ((FileOutputStream)localObject1).flush();
        }
        ((FileOutputStream)localObject1).close();
      }
    }
    paramString1.close();
  }
  
  public static void copyAssetFiles(Context paramContext, String paramString1, String paramString2)
  {
    int i = 0;
    try
    {
      String[] arrayOfString = paramContext.getAssets().list(paramString1);
      if (arrayOfString.length > 0)
      {
        new File(paramString2).mkdirs();
        int j = arrayOfString.length;
        while (i < j)
        {
          String str = arrayOfString[i];
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append("/");
          ((StringBuilder)localObject).append(str);
          localObject = ((StringBuilder)localObject).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString2);
          localStringBuilder.append("/");
          localStringBuilder.append(str);
          copyAssetFiles(paramContext, (String)localObject, localStringBuilder.toString());
          i += 1;
        }
      }
      paramContext = paramContext.getAssets().open(paramString1);
      paramString1 = new FileOutputStream(new File(paramString2));
      paramString2 = new byte[1024];
      for (;;)
      {
        i = paramContext.read(paramString2);
        if (i == -1) {
          break;
        }
        paramString1.write(paramString2, 0, i);
      }
      paramString1.flush();
      paramContext.close();
      paramString1.close();
      return;
    }
    catch (Exception paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qflutter.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */