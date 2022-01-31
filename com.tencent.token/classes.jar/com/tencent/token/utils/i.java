package com.tencent.token.utils;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.token.global.RqdApplication;
import java.io.BufferedInputStream;
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

public final class i
{
  private static long a(String paramString)
  {
    try
    {
      StatFs localStatFs = new StatFs(paramString);
      localStatFs.restat(paramString);
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      return l * i;
    }
    catch (IllegalArgumentException paramString) {}
    return 0L;
  }
  
  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    Object localObject = Environment.getExternalStorageState();
    try
    {
      if ("mounted".equals(localObject)) {}
      for (paramString = new File(Environment.getExternalStorageDirectory(), paramString);; paramString = new File(RqdApplication.i().getFilesDir(), paramString))
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
  
  private static void a(ZipOutputStream paramZipOutputStream, File paramFile, String paramString, byte[] paramArrayOfByte)
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
  
  public static boolean a()
  {
    if ("mounted".equals(Environment.getExternalStorageState())) {}
    for (File localFile = new File(Environment.getExternalStorageDirectory(), "video");; localFile = new File(RqdApplication.i().getFilesDir(), "video")) {
      try
      {
        localFile.mkdirs();
        localFile = File.createTempFile("tmppp", null, localFile);
        if (localFile.exists()) {
          break;
        }
        return false;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
    }
    localException.delete();
    return true;
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
  
  private static boolean a(Object paramObject)
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
    //   4: ifnull +12 -> 16
    //   7: aload_0
    //   8: arraylength
    //   9: ifle +7 -> 16
    //   12: aload_1
    //   13: ifnonnull +5 -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: sipush 4096
    //   21: newarray byte
    //   23: astore 5
    //   25: new 123	java/util/zip/ZipOutputStream
    //   28: dup
    //   29: new 200	java/io/BufferedOutputStream
    //   32: dup
    //   33: new 63	java/io/FileOutputStream
    //   36: dup
    //   37: aload_1
    //   38: iconst_0
    //   39: invokespecial 203	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   42: invokespecial 206	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   45: invokespecial 207	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   48: astore_1
    //   49: aload_0
    //   50: arraylength
    //   51: istore_3
    //   52: iconst_0
    //   53: istore_2
    //   54: iload_2
    //   55: iload_3
    //   56: if_icmpge +20 -> 76
    //   59: aload_1
    //   60: aload_0
    //   61: iload_2
    //   62: aaload
    //   63: aconst_null
    //   64: aload 5
    //   66: invokestatic 159	com/tencent/token/utils/i:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;[B)V
    //   69: iload_2
    //   70: iconst_1
    //   71: iadd
    //   72: istore_2
    //   73: goto -19 -> 54
    //   76: aload_1
    //   77: invokevirtual 210	java/util/zip/ZipOutputStream:flush	()V
    //   80: aload_1
    //   81: invokevirtual 213	java/util/zip/ZipOutputStream:closeEntry	()V
    //   84: aload_1
    //   85: invokestatic 136	com/tencent/token/utils/i:a	(Ljava/lang/Object;)Z
    //   88: pop
    //   89: iconst_1
    //   90: ireturn
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_1
    //   94: aload_1
    //   95: invokestatic 136	com/tencent/token/utils/i:a	(Ljava/lang/Object;)Z
    //   98: pop
    //   99: iconst_0
    //   100: ireturn
    //   101: astore_0
    //   102: aload 4
    //   104: astore_1
    //   105: aload_1
    //   106: invokestatic 136	com/tencent/token/utils/i:a	(Ljava/lang/Object;)Z
    //   109: pop
    //   110: aload_0
    //   111: athrow
    //   112: astore_0
    //   113: goto -8 -> 105
    //   116: astore_0
    //   117: goto -23 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramArrayOfFile	File[]
    //   0	120	1	paramFile	File
    //   53	20	2	i	int
    //   51	6	3	j	int
    //   1	102	4	localObject	Object
    //   23	42	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   18	49	91	java/io/IOException
    //   18	49	101	finally
    //   49	52	112	finally
    //   59	69	112	finally
    //   76	84	112	finally
    //   49	52	116	java/io/IOException
    //   59	69	116	java/io/IOException
    //   76	84	116	java/io/IOException
  }
  
  public static long b()
  {
    if ("mounted".equals(Environment.getExternalStorageState())) {}
    for (File localFile = new File(Environment.getExternalStorageDirectory(), "video");; localFile = new File(RqdApplication.i().getFilesDir(), "video")) {
      return a(localFile.getAbsolutePath());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.i
 * JD-Core Version:    0.7.0.1
 */