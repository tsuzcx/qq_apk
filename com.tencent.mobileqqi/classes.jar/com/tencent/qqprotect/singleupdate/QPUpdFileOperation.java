package com.tencent.qqprotect.singleupdate;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class QPUpdFileOperation
{
  public static final int a = 2048;
  
  public static String a(String paramString)
  {
    String str = paramString;
    int i;
    if (a(paramString)) {
      i = paramString.length() - 1;
    }
    for (;;)
    {
      if ((i < 0) || (paramString.charAt(i) == '\\') || (paramString.charAt(i) == '/'))
      {
        str = paramString.substring(i + 1);
        return str;
      }
      i -= 1;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    paramString1 = new FileInputStream(paramString1);
    ZipInputStream localZipInputStream = new ZipInputStream(new BufferedInputStream(paramString1));
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = localZipInputStream.getNextEntry();
        if (localObject1 == null) {
          break;
        }
        Object localObject2 = ((ZipEntry)localObject1).getName();
        if ((localObject2 == null) || (((String)localObject2).contains("../"))) {
          continue;
        }
        localObject2 = new byte[2048];
        localObject1 = new BufferedOutputStream(new FileOutputStream(paramString2 + "/" + ((ZipEntry)localObject1).getName()), 2048);
        int i = localZipInputStream.read((byte[])localObject2, 0, 2048);
        if (i != -1)
        {
          ((BufferedOutputStream)localObject1).write((byte[])localObject2, 0, i);
          continue;
        }
        ((BufferedOutputStream)localObject1).flush();
      }
      finally
      {
        paramString1.close();
        localZipInputStream.close();
      }
      ((BufferedOutputStream)localObject1).close();
    }
    paramString1.close();
    localZipInputStream.close();
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    if (!paramFile2.exists()) {}
    label110:
    for (;;)
    {
      return false;
      boolean bool;
      if (paramFile1.exists()) {
        bool = paramFile1.delete();
      }
      for (;;)
      {
        for (;;)
        {
          if (!bool) {
            break label110;
          }
          try
          {
            bool = paramFile1.createNewFile();
            if (!bool) {
              break;
            }
            int i;
            bool = true;
          }
          catch (IOException localIOException)
          {
            try
            {
              paramFile2 = new FileInputStream(paramFile2);
              paramFile1 = new FileOutputStream(paramFile1);
              for (;;)
              {
                i = paramFile2.read();
                if (i == -1) {
                  break;
                }
                paramFile1.write((byte)i);
              }
            }
            catch (FileNotFoundException paramFile1)
            {
              paramFile1.printStackTrace();
              for (;;)
              {
                return true;
                localIOException = localIOException;
                localIOException.printStackTrace();
                break;
                paramFile2.close();
                paramFile1.close();
              }
            }
            catch (IOException paramFile1)
            {
              for (;;)
              {
                paramFile1.printStackTrace();
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if ((paramString.charAt(i) == '\\') || (paramString.charAt(i) == '/')) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean b(File paramFile1, File paramFile2)
  {
    if (!a(paramFile1, paramFile2)) {}
    while (!paramFile2.delete()) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPUpdFileOperation
 * JD-Core Version:    0.7.0.1
 */