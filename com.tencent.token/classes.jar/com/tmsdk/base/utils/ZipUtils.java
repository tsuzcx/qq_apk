package com.tmsdk.base.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipUtils
{
  public static final String TAG = "ZipUtils";
  
  private static void a(File paramFile, String paramString, ZipOutputStream paramZipOutputStream)
  {
    if (paramFile.isDirectory()) {
      paramFile = paramFile.listFiles();
    } else {
      paramFile = new File[] { paramFile };
    }
    byte[] arrayOfByte = new byte[1024];
    int j = paramFile.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = paramFile[i];
      Object localObject1;
      if (((File)localObject2).isDirectory())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(((File)localObject2).getPath().substring(paramString.length() + 1));
        ((StringBuilder)localObject1).append("/");
        paramZipOutputStream.putNextEntry(new ZipEntry(((StringBuilder)localObject1).toString()));
        a((File)localObject2, paramString, paramZipOutputStream);
      }
      else
      {
        localObject1 = ((File)localObject2).getPath().substring(paramString.length() + 1);
        localObject2 = new FileInputStream((File)localObject2);
        BufferedInputStream localBufferedInputStream = new BufferedInputStream((InputStream)localObject2);
        paramZipOutputStream.putNextEntry(new ZipEntry((String)localObject1));
        for (;;)
        {
          int k = localBufferedInputStream.read(arrayOfByte, 0, 1024);
          if (k == -1) {
            break;
          }
          paramZipOutputStream.write(arrayOfByte, 0, k);
        }
        localBufferedInputStream.close();
        ((InputStream)localObject2).close();
      }
      i += 1;
    }
  }
  
  public static boolean checkValidZipFiles(List<File> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (!verifyZipFile((File)paramList.next())) {
        return false;
      }
    }
    return true;
  }
  
  public static void unZip(String paramString1, String paramString2)
  {
    paramString1 = new ZipFile(paramString1);
    Enumeration localEnumeration = paramString1.entries();
    byte[] arrayOfByte = new byte[1024];
    while (localEnumeration.hasMoreElements())
    {
      Object localObject1 = (ZipEntry)localEnumeration.nextElement();
      if (!((ZipEntry)localObject1).getName().contains("../")) {
        if (((ZipEntry)localObject1).isDirectory())
        {
          new File(paramString2, ((ZipEntry)localObject1).getName()).mkdirs();
        }
        else
        {
          BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramString1.getInputStream((ZipEntry)localObject1));
          localObject1 = new File(paramString2, ((ZipEntry)localObject1).getName());
          Object localObject2 = ((File)localObject1).getParentFile();
          if ((localObject2 != null) && (!((File)localObject2).exists())) {
            ((File)localObject2).mkdirs();
          }
          localObject1 = new FileOutputStream((File)localObject1);
          localObject2 = new BufferedOutputStream((OutputStream)localObject1, 1024);
          for (;;)
          {
            int i = localBufferedInputStream.read(arrayOfByte, 0, 1024);
            if (i == -1) {
              break;
            }
            ((FileOutputStream)localObject1).write(arrayOfByte, 0, i);
          }
          ((BufferedOutputStream)localObject2).flush();
          ((BufferedOutputStream)localObject2).close();
          ((FileOutputStream)localObject1).close();
          localBufferedInputStream.close();
        }
      }
    }
    paramString1.close();
  }
  
  public static boolean verifyZipFile(File paramFile)
  {
    try
    {
      paramFile = new ZipFile(paramFile);
      paramFile.close();
      return true;
    }
    catch (ZipException|Throwable|IOException paramFile)
    {
      label15:
      break label15;
    }
    return false;
  }
  
  public static void zip(String paramString1, String paramString2)
  {
    paramString2 = new FileOutputStream(paramString2);
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(paramString2);
    ZipOutputStream localZipOutputStream = new ZipOutputStream(localBufferedOutputStream);
    File localFile = new File(paramString1);
    if (localFile.isDirectory()) {
      paramString1 = localFile.getPath();
    } else {
      paramString1 = localFile.getParent();
    }
    a(localFile, paramString1, localZipOutputStream);
    localZipOutputStream.closeEntry();
    localZipOutputStream.close();
    localBufferedOutputStream.close();
    paramString2.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.utils.ZipUtils
 * JD-Core Version:    0.7.0.1
 */