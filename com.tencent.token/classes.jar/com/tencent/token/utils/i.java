package com.tencent.token.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.token.global.RqdApplication;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class i
{
  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    Object localObject = Environment.getExternalStorageState();
    try
    {
      if ("mounted".equals(localObject)) {}
      for (paramString = new File(Environment.getExternalStorageDirectory(), paramString);; paramString = new File(RqdApplication.l().getFilesDir(), paramString))
      {
        if (!paramString.exists()) {
          paramString.createNewFile();
        }
        localObject = new FileOutputStream(paramString);
        ((FileOutputStream)localObject).write(paramArrayOfByte);
        ((FileOutputStream)localObject).close();
        return paramString.getAbsolutePath();
      }
      return null;
    }
    catch (Exception paramArrayOfByte) {}
  }
  
  public static void a(ZipOutputStream paramZipOutputStream, File paramFile, String paramString, byte[] paramArrayOfByte)
  {
    int i = 0;
    if ((paramZipOutputStream == null) || (paramFile == null)) {
      throw new IOException("I/O Object got NullPointerException");
    }
    if (!paramFile.exists()) {
      throw new FileNotFoundException("Target File is missing");
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = paramFile.getName();
    }
    while (paramFile.isFile())
    {
      try
      {
        paramFile = new BufferedInputStream(new FileInputStream(paramFile));
        try
        {
          paramZipOutputStream.putNextEntry(new ZipEntry(paramString));
          for (;;)
          {
            i = paramFile.read(paramArrayOfByte, 0, paramArrayOfByte.length);
            if (-1 == i) {
              break;
            }
            paramZipOutputStream.write(paramArrayOfByte, 0, i);
          }
          a(paramFile);
        }
        catch (IOException paramZipOutputStream) {}
      }
      catch (IOException paramZipOutputStream)
      {
        for (;;)
        {
          paramFile = null;
        }
      }
      throw paramZipOutputStream;
      paramString = paramString + File.separator + paramFile.getName();
      continue;
      a(paramFile);
    }
    for (;;)
    {
      return;
      if (paramFile.isDirectory())
      {
        paramFile = paramFile.listFiles();
        int j = paramFile.length;
        while (i < j)
        {
          a(paramZipOutputStream, paramFile[i], paramString, paramArrayOfByte);
          i += 1;
        }
      }
    }
  }
  
  public static boolean a(File paramFile)
  {
    int i = 0;
    if (paramFile != null)
    {
      if (!paramFile.isFile()) {
        break label28;
      }
      if (paramFile.delete()) {
        break label26;
      }
      paramFile.deleteOnExit();
    }
    label26:
    label28:
    while (!paramFile.isDirectory())
    {
      return false;
      return true;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      while (i < j)
      {
        a(arrayOfFile[i]);
        i += 1;
      }
    }
    return paramFile.delete();
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    return a(new File[] { paramFile1 }, paramFile2);
  }
  
  public static boolean a(Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return false;
      try
      {
        if ((paramObject instanceof InputStream))
        {
          ((InputStream)paramObject).close();
        }
        else if ((paramObject instanceof OutputStream))
        {
          ((OutputStream)paramObject).close();
        }
        else if ((paramObject instanceof Reader))
        {
          ((Reader)paramObject).close();
        }
        else if ((paramObject instanceof Writer))
        {
          ((Writer)paramObject).close();
        }
        else
        {
          if (!(paramObject instanceof RandomAccessFile)) {
            continue;
          }
          ((RandomAccessFile)paramObject).close();
        }
        return true;
      }
      catch (IOException paramObject) {}
    }
    return false;
  }
  
  /* Error */
  public static boolean a(File[] paramArrayOfFile, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnull +13 -> 17
    //   7: aload_0
    //   8: arraylength
    //   9: iconst_1
    //   10: if_icmplt +7 -> 17
    //   13: aload_1
    //   14: ifnonnull +5 -> 19
    //   17: iconst_0
    //   18: ireturn
    //   19: sipush 4096
    //   22: newarray byte
    //   24: astore 5
    //   26: new 105	java/util/zip/ZipOutputStream
    //   29: dup
    //   30: new 172	java/io/BufferedOutputStream
    //   33: dup
    //   34: new 41	java/io/FileOutputStream
    //   37: dup
    //   38: aload_1
    //   39: iconst_0
    //   40: invokespecial 175	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   43: invokespecial 178	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   46: invokespecial 179	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   49: astore_1
    //   50: aload_0
    //   51: arraylength
    //   52: istore_3
    //   53: iconst_0
    //   54: istore_2
    //   55: iload_2
    //   56: iload_3
    //   57: if_icmpge +20 -> 77
    //   60: aload_1
    //   61: aload_0
    //   62: iload_2
    //   63: aaload
    //   64: aconst_null
    //   65: aload 5
    //   67: invokestatic 142	com/tencent/token/utils/i:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;[B)V
    //   70: iload_2
    //   71: iconst_1
    //   72: iadd
    //   73: istore_2
    //   74: goto -19 -> 55
    //   77: aload_1
    //   78: invokevirtual 182	java/util/zip/ZipOutputStream:flush	()V
    //   81: aload_1
    //   82: invokevirtual 185	java/util/zip/ZipOutputStream:closeEntry	()V
    //   85: aload_1
    //   86: invokestatic 118	com/tencent/token/utils/i:a	(Ljava/lang/Object;)Z
    //   89: pop
    //   90: iconst_1
    //   91: ireturn
    //   92: astore_0
    //   93: aconst_null
    //   94: astore_0
    //   95: aload_0
    //   96: invokestatic 118	com/tencent/token/utils/i:a	(Ljava/lang/Object;)Z
    //   99: pop
    //   100: iconst_0
    //   101: ireturn
    //   102: astore_0
    //   103: aload 4
    //   105: astore_1
    //   106: aload_1
    //   107: invokestatic 118	com/tencent/token/utils/i:a	(Ljava/lang/Object;)Z
    //   110: pop
    //   111: aload_0
    //   112: athrow
    //   113: astore_0
    //   114: goto -8 -> 106
    //   117: astore_0
    //   118: aload_1
    //   119: astore_0
    //   120: goto -25 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramArrayOfFile	File[]
    //   0	123	1	paramFile	File
    //   54	20	2	i	int
    //   52	6	3	j	int
    //   1	103	4	localObject	Object
    //   24	42	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   19	50	92	java/io/IOException
    //   19	50	102	finally
    //   50	53	113	finally
    //   60	70	113	finally
    //   77	85	113	finally
    //   50	53	117	java/io/IOException
    //   60	70	117	java/io/IOException
    //   77	85	117	java/io/IOException
  }
  
  public static byte[] a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    try
    {
      paramString = new File(paramString);
      if ((paramString.exists()) && (paramString.isFile()))
      {
        paramString = new FileInputStream(paramString);
        while (paramString.read(arrayOfByte) != -1) {
          localByteArrayOutputStream.write(arrayOfByte);
        }
      }
      try
      {
        localIOException1.close();
        throw paramString;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localIOException2.printStackTrace();
        }
      }
    }
    catch (Exception paramString)
    {
      paramString = paramString;
      try
      {
        localByteArrayOutputStream.close();
        return null;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      paramString.close();
      paramString = localByteArrayOutputStream.toByteArray();
      try
      {
        localByteArrayOutputStream.close();
        return paramString;
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
        return paramString;
      }
      try
      {
        localIOException1.close();
        return null;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    finally {}
  }
  
  public static void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new File(paramString);
        if ((paramString.exists()) && (paramString.isFile()) && (!paramString.delete()))
        {
          paramString.deleteOnExit();
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.i
 * JD-Core Version:    0.7.0.1
 */