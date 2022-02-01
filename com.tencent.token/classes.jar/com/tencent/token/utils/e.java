package com.tencent.token.utils;

import android.content.Context;
import android.os.Environment;
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

public class e
{
  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    Object localObject = Environment.getExternalStorageState();
    try
    {
      if ("mounted".equals(localObject)) {
        paramString = new File(Environment.getExternalStorageDirectory(), paramString);
      } else {
        paramString = new File(RqdApplication.l().getFilesDir(), paramString);
      }
      if (!paramString.exists()) {
        paramString.createNewFile();
      }
      localObject = new FileOutputStream(paramString);
      ((FileOutputStream)localObject).write(paramArrayOfByte);
      ((FileOutputStream)localObject).close();
      return paramString.getAbsolutePath();
    }
    catch (Exception paramArrayOfByte)
    {
      label78:
      break label78;
    }
    return null;
  }
  
  public static void a(ZipOutputStream paramZipOutputStream, File paramFile, String paramString, byte[] paramArrayOfByte)
  {
    if ((paramZipOutputStream != null) && (paramFile != null))
    {
      if (paramFile.exists())
      {
        if (TextUtils.isEmpty(paramString))
        {
          paramString = paramFile.getName();
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append(File.separator);
          localStringBuilder.append(paramFile.getName());
          paramString = localStringBuilder.toString();
        }
        boolean bool = paramFile.isFile();
        int i = 0;
        if (bool)
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
              return;
            }
            catch (IOException paramString)
            {
              paramZipOutputStream = paramFile;
              paramFile = paramString;
            }
            a(paramZipOutputStream);
          }
          catch (IOException paramFile)
          {
            paramZipOutputStream = null;
          }
          throw paramFile;
        }
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
        return;
      }
      throw new FileNotFoundException("Target File is missing");
    }
    throw new IOException("I/O Object got NullPointerException");
  }
  
  public static boolean a(File paramFile)
  {
    int i = 0;
    if (paramFile != null)
    {
      if (paramFile.isFile())
      {
        if (!paramFile.delete())
        {
          paramFile.deleteOnExit();
          return false;
        }
        return true;
      }
      if (paramFile.isDirectory())
      {
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
      return false;
    }
    return false;
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    return a(new File[] { paramFile1 }, paramFile2);
  }
  
  public static boolean a(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
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
          break label90;
        }
        ((RandomAccessFile)paramObject).close();
      }
      return true;
      label90:
      return false;
    }
    catch (IOException paramObject) {}
    return false;
  }
  
  /* Error */
  public static boolean a(File[] paramArrayOfFile, File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +125 -> 126
    //   4: aload_0
    //   5: arraylength
    //   6: iconst_1
    //   7: if_icmplt +119 -> 126
    //   10: aload_1
    //   11: ifnonnull +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore 4
    //   22: sipush 4096
    //   25: newarray byte
    //   27: astore 6
    //   29: new 112	java/util/zip/ZipOutputStream
    //   32: dup
    //   33: new 172	java/io/BufferedOutputStream
    //   36: dup
    //   37: new 52	java/io/FileOutputStream
    //   40: dup
    //   41: aload_1
    //   42: iconst_0
    //   43: invokespecial 175	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   46: invokespecial 178	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   49: invokespecial 179	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   52: astore_1
    //   53: aload_0
    //   54: arraylength
    //   55: istore_3
    //   56: iconst_0
    //   57: istore_2
    //   58: iload_2
    //   59: iload_3
    //   60: if_icmpge +20 -> 80
    //   63: aload_1
    //   64: aload_0
    //   65: iload_2
    //   66: aaload
    //   67: aconst_null
    //   68: aload 6
    //   70: invokestatic 134	com/tencent/token/utils/e:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;[B)V
    //   73: iload_2
    //   74: iconst_1
    //   75: iadd
    //   76: istore_2
    //   77: goto -19 -> 58
    //   80: aload_1
    //   81: invokevirtual 182	java/util/zip/ZipOutputStream:flush	()V
    //   84: aload_1
    //   85: invokevirtual 185	java/util/zip/ZipOutputStream:closeEntry	()V
    //   88: aload_1
    //   89: invokestatic 125	com/tencent/token/utils/e:a	(Ljava/lang/Object;)Z
    //   92: pop
    //   93: iconst_1
    //   94: ireturn
    //   95: astore 4
    //   97: aload_1
    //   98: astore_0
    //   99: aload 4
    //   101: astore_1
    //   102: goto +10 -> 112
    //   105: goto +14 -> 119
    //   108: astore_1
    //   109: aload 4
    //   111: astore_0
    //   112: aload_0
    //   113: invokestatic 125	com/tencent/token/utils/e:a	(Ljava/lang/Object;)Z
    //   116: pop
    //   117: aload_1
    //   118: athrow
    //   119: aload_1
    //   120: invokestatic 125	com/tencent/token/utils/e:a	(Ljava/lang/Object;)Z
    //   123: pop
    //   124: iconst_0
    //   125: ireturn
    //   126: iconst_0
    //   127: ireturn
    //   128: astore_0
    //   129: aload 5
    //   131: astore_1
    //   132: goto -13 -> 119
    //   135: astore_0
    //   136: goto -31 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramArrayOfFile	File[]
    //   0	139	1	paramFile	File
    //   57	20	2	i	int
    //   55	6	3	j	int
    //   20	1	4	localObject1	Object
    //   95	15	4	localObject2	Object
    //   17	113	5	localObject3	Object
    //   27	42	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   53	56	95	finally
    //   63	73	95	finally
    //   80	88	95	finally
    //   22	53	108	finally
    //   22	53	128	java/io/IOException
    //   53	56	135	java/io/IOException
    //   63	73	135	java/io/IOException
    //   80	88	135	java/io/IOException
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 188	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 189	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore_1
    //   17: sipush 1024
    //   20: newarray byte
    //   22: astore_2
    //   23: new 24	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 190	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: astore_0
    //   32: aload_0
    //   33: invokevirtual 47	java/io/File:exists	()Z
    //   36: ifeq +58 -> 94
    //   39: aload_0
    //   40: invokevirtual 97	java/io/File:isFile	()Z
    //   43: ifeq +51 -> 94
    //   46: new 101	java/io/FileInputStream
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: astore_0
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 193	java/io/FileInputStream:read	([B)I
    //   60: iconst_m1
    //   61: if_icmpeq +11 -> 72
    //   64: aload_1
    //   65: aload_2
    //   66: invokevirtual 194	java/io/ByteArrayOutputStream:write	([B)V
    //   69: goto -14 -> 55
    //   72: aload_0
    //   73: invokevirtual 195	java/io/FileInputStream:close	()V
    //   76: aload_1
    //   77: invokevirtual 199	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   80: astore_0
    //   81: aload_1
    //   82: invokevirtual 200	java/io/ByteArrayOutputStream:close	()V
    //   85: aload_0
    //   86: areturn
    //   87: astore_1
    //   88: aload_1
    //   89: invokevirtual 203	java/io/IOException:printStackTrace	()V
    //   92: aload_0
    //   93: areturn
    //   94: aload_1
    //   95: invokevirtual 200	java/io/ByteArrayOutputStream:close	()V
    //   98: aconst_null
    //   99: areturn
    //   100: astore_0
    //   101: aload_0
    //   102: invokevirtual 203	java/io/IOException:printStackTrace	()V
    //   105: aconst_null
    //   106: areturn
    //   107: astore_0
    //   108: aload_1
    //   109: invokevirtual 200	java/io/ByteArrayOutputStream:close	()V
    //   112: goto +8 -> 120
    //   115: astore_1
    //   116: aload_1
    //   117: invokevirtual 203	java/io/IOException:printStackTrace	()V
    //   120: aload_0
    //   121: athrow
    //   122: aload_1
    //   123: invokevirtual 200	java/io/ByteArrayOutputStream:close	()V
    //   126: aconst_null
    //   127: areturn
    //   128: astore_0
    //   129: aload_0
    //   130: invokevirtual 203	java/io/IOException:printStackTrace	()V
    //   133: aconst_null
    //   134: areturn
    //   135: astore_0
    //   136: goto -14 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramString	String
    //   16	66	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   87	22	1	localIOException1	IOException
    //   115	8	1	localIOException2	IOException
    //   22	44	2	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   81	85	87	java/io/IOException
    //   94	98	100	java/io/IOException
    //   23	55	107	finally
    //   55	69	107	finally
    //   72	81	107	finally
    //   108	112	115	java/io/IOException
    //   122	126	128	java/io/IOException
    //   23	55	135	java/lang/Exception
    //   55	69	135	java/lang/Exception
    //   72	81	135	java/lang/Exception
  }
  
  public static void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.e
 * JD-Core Version:    0.7.0.1
 */