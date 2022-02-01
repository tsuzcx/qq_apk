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
    Object localObject1;
    int i;
    label25:
    Object localObject2;
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      localObject1 = new byte[1024];
      int j = paramFile.length;
      i = 0;
      if (i >= j) {
        return;
      }
      localObject2 = paramFile[i];
      if (!((File)localObject2).isDirectory()) {
        break label118;
      }
      paramZipOutputStream.putNextEntry(new ZipEntry(((File)localObject2).getPath().substring(paramString.length() + 1) + "/"));
      a((File)localObject2, paramString, paramZipOutputStream);
    }
    for (;;)
    {
      i += 1;
      break label25;
      localObject1 = new File[1];
      localObject1[0] = paramFile;
      paramFile = (File)localObject1;
      break;
      label118:
      String str = ((File)localObject2).getPath().substring(paramString.length() + 1);
      localObject2 = new FileInputStream((File)localObject2);
      BufferedInputStream localBufferedInputStream = new BufferedInputStream((InputStream)localObject2);
      paramZipOutputStream.putNextEntry(new ZipEntry(str));
      for (;;)
      {
        int k = localBufferedInputStream.read((byte[])localObject1, 0, 1024);
        if (k == -1) {
          break;
        }
        paramZipOutputStream.write((byte[])localObject1, 0, k);
      }
      localBufferedInputStream.close();
      ((InputStream)localObject2).close();
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
      try
      {
        paramFile.close();
        return true;
      }
      catch (IOException paramFile) {}
    }
    catch (Throwable paramFile)
    {
      break label16;
    }
    catch (ZipException paramFile)
    {
      label16:
      break label16;
    }
    return false;
  }
  
  public static void zip(String paramString1, String paramString2)
  {
    paramString2 = new FileOutputStream(paramString2);
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(paramString2);
    ZipOutputStream localZipOutputStream = new ZipOutputStream(localBufferedOutputStream);
    File localFile = new File(paramString1);
    if (localFile.isDirectory()) {}
    for (paramString1 = localFile.getPath();; paramString1 = localFile.getParent())
    {
      a(localFile, paramString1, localZipOutputStream);
      localZipOutputStream.closeEntry();
      localZipOutputStream.close();
      localBufferedOutputStream.close();
      paramString2.close();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.utils.ZipUtils
 * JD-Core Version:    0.7.0.1
 */