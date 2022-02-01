package com.tencent.token;

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

public final class aai
{
  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    Object localObject = Environment.getExternalStorageState();
    try
    {
      if ("mounted".equals(localObject)) {
        paramString = new File(RqdApplication.b().getExternalFilesDir(null), paramString);
      } else {
        paramString = new File(RqdApplication.p().getFilesDir(), paramString);
      }
      if (!paramString.exists()) {
        paramString.createNewFile();
      }
      localObject = new FileOutputStream(paramString);
      ((FileOutputStream)localObject).write(paramArrayOfByte);
      ((FileOutputStream)localObject).close();
      return paramString.getAbsolutePath();
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  private static void a(ZipOutputStream paramZipOutputStream, File paramFile, String paramString, byte[] paramArrayOfByte)
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
  
  private static boolean a(Object paramObject)
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
    //   1: ifnull +120 -> 121
    //   4: aload_0
    //   5: arraylength
    //   6: ifgt +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: aconst_null
    //   12: astore 5
    //   14: aconst_null
    //   15: astore 4
    //   17: sipush 4096
    //   20: newarray byte
    //   22: astore 6
    //   24: new 116	java/util/zip/ZipOutputStream
    //   27: dup
    //   28: new 173	java/io/BufferedOutputStream
    //   31: dup
    //   32: new 56	java/io/FileOutputStream
    //   35: dup
    //   36: aload_1
    //   37: iconst_0
    //   38: invokespecial 176	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   41: invokespecial 179	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   44: invokespecial 180	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   47: astore_1
    //   48: aload_0
    //   49: arraylength
    //   50: istore_3
    //   51: iconst_0
    //   52: istore_2
    //   53: iload_2
    //   54: iload_3
    //   55: if_icmpge +20 -> 75
    //   58: aload_1
    //   59: aload_0
    //   60: iload_2
    //   61: aaload
    //   62: aconst_null
    //   63: aload 6
    //   65: invokestatic 138	com/tencent/token/aai:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;[B)V
    //   68: iload_2
    //   69: iconst_1
    //   70: iadd
    //   71: istore_2
    //   72: goto -19 -> 53
    //   75: aload_1
    //   76: invokevirtual 183	java/util/zip/ZipOutputStream:flush	()V
    //   79: aload_1
    //   80: invokevirtual 186	java/util/zip/ZipOutputStream:closeEntry	()V
    //   83: aload_1
    //   84: invokestatic 129	com/tencent/token/aai:a	(Ljava/lang/Object;)Z
    //   87: pop
    //   88: iconst_1
    //   89: ireturn
    //   90: astore 4
    //   92: aload_1
    //   93: astore_0
    //   94: aload 4
    //   96: astore_1
    //   97: goto +10 -> 107
    //   100: goto +14 -> 114
    //   103: astore_1
    //   104: aload 4
    //   106: astore_0
    //   107: aload_0
    //   108: invokestatic 129	com/tencent/token/aai:a	(Ljava/lang/Object;)Z
    //   111: pop
    //   112: aload_1
    //   113: athrow
    //   114: aload_1
    //   115: invokestatic 129	com/tencent/token/aai:a	(Ljava/lang/Object;)Z
    //   118: pop
    //   119: iconst_0
    //   120: ireturn
    //   121: iconst_0
    //   122: ireturn
    //   123: astore_0
    //   124: aload 5
    //   126: astore_1
    //   127: goto -13 -> 114
    //   130: astore_0
    //   131: goto -31 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramArrayOfFile	File[]
    //   0	134	1	paramFile	File
    //   52	20	2	i	int
    //   50	6	3	j	int
    //   15	1	4	localObject1	Object
    //   90	15	4	localObject2	Object
    //   12	113	5	localObject3	Object
    //   22	42	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   48	51	90	finally
    //   58	68	90	finally
    //   75	83	90	finally
    //   17	48	103	finally
    //   17	48	123	java/io/IOException
    //   48	51	130	java/io/IOException
    //   58	68	130	java/io/IOException
    //   75	83	130	java/io/IOException
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 189	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 190	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore_1
    //   17: sipush 1024
    //   20: newarray byte
    //   22: astore_2
    //   23: new 24	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 191	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: astore_0
    //   32: aload_0
    //   33: invokevirtual 51	java/io/File:exists	()Z
    //   36: ifeq +58 -> 94
    //   39: aload_0
    //   40: invokevirtual 101	java/io/File:isFile	()Z
    //   43: ifeq +51 -> 94
    //   46: new 105	java/io/FileInputStream
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 106	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: astore_0
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 194	java/io/FileInputStream:read	([B)I
    //   60: iconst_m1
    //   61: if_icmpeq +11 -> 72
    //   64: aload_1
    //   65: aload_2
    //   66: invokevirtual 195	java/io/ByteArrayOutputStream:write	([B)V
    //   69: goto -14 -> 55
    //   72: aload_0
    //   73: invokevirtual 196	java/io/FileInputStream:close	()V
    //   76: aload_1
    //   77: invokevirtual 200	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   80: astore_0
    //   81: aload_1
    //   82: invokevirtual 201	java/io/ByteArrayOutputStream:close	()V
    //   85: aload_0
    //   86: areturn
    //   87: astore_1
    //   88: aload_1
    //   89: invokevirtual 204	java/io/IOException:printStackTrace	()V
    //   92: aload_0
    //   93: areturn
    //   94: aload_1
    //   95: invokevirtual 201	java/io/ByteArrayOutputStream:close	()V
    //   98: aconst_null
    //   99: areturn
    //   100: astore_0
    //   101: aload_0
    //   102: invokevirtual 204	java/io/IOException:printStackTrace	()V
    //   105: aconst_null
    //   106: areturn
    //   107: astore_0
    //   108: aload_1
    //   109: invokevirtual 201	java/io/ByteArrayOutputStream:close	()V
    //   112: goto +8 -> 120
    //   115: astore_1
    //   116: aload_1
    //   117: invokevirtual 204	java/io/IOException:printStackTrace	()V
    //   120: aload_0
    //   121: athrow
    //   122: aload_1
    //   123: invokevirtual 201	java/io/ByteArrayOutputStream:close	()V
    //   126: aconst_null
    //   127: areturn
    //   128: astore_0
    //   129: aload_0
    //   130: invokevirtual 204	java/io/IOException:printStackTrace	()V
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
      if ((paramString.exists()) && (paramString.isFile()) && (!paramString.delete())) {
        paramString.deleteOnExit();
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aai
 * JD-Core Version:    0.7.0.1
 */