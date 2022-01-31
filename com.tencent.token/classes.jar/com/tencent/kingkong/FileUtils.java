package com.tencent.kingkong;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtils
{
  private static final Pattern SAFE_FILENAME_PATTERN = Pattern.compile("[\\w%+,./=_-]+");
  public static final int S_IRGRP = 32;
  public static final int S_IROTH = 4;
  public static final int S_IRUSR = 256;
  public static final int S_IRWXG = 56;
  public static final int S_IRWXO = 7;
  public static final int S_IRWXU = 448;
  public static final int S_IWGRP = 16;
  public static final int S_IWOTH = 2;
  public static final int S_IWUSR = 128;
  public static final int S_IXGRP = 8;
  public static final int S_IXOTH = 1;
  public static final int S_IXUSR = 64;
  private static final String TAG = "FileUtils";
  
  /* Error */
  public static long checksumCrc32(File paramFile)
    throws java.io.FileNotFoundException, IOException
  {
    // Byte code:
    //   0: new 61	java/util/zip/CRC32
    //   3: dup
    //   4: invokespecial 62	java/util/zip/CRC32:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_3
    //   11: new 64	java/util/zip/CheckedInputStream
    //   14: dup
    //   15: new 66	java/io/FileInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 69	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: aload 4
    //   25: invokespecial 72	java/util/zip/CheckedInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Checksum;)V
    //   28: astore_0
    //   29: sipush 128
    //   32: newarray byte
    //   34: astore_3
    //   35: aload_0
    //   36: aload_3
    //   37: invokevirtual 76	java/util/zip/CheckedInputStream:read	([B)I
    //   40: ifge -5 -> 35
    //   43: aload 4
    //   45: invokevirtual 80	java/util/zip/CRC32:getValue	()J
    //   48: lstore_1
    //   49: aload_0
    //   50: ifnull +7 -> 57
    //   53: aload_0
    //   54: invokevirtual 83	java/util/zip/CheckedInputStream:close	()V
    //   57: lload_1
    //   58: lreturn
    //   59: astore_0
    //   60: aload_3
    //   61: ifnull +7 -> 68
    //   64: aload_3
    //   65: invokevirtual 83	java/util/zip/CheckedInputStream:close	()V
    //   68: aload_0
    //   69: athrow
    //   70: astore_0
    //   71: lload_1
    //   72: lreturn
    //   73: astore_3
    //   74: goto -6 -> 68
    //   77: astore 4
    //   79: aload_0
    //   80: astore_3
    //   81: aload 4
    //   83: astore_0
    //   84: goto -24 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramFile	File
    //   48	24	1	l	long
    //   10	55	3	arrayOfByte	byte[]
    //   73	1	3	localIOException	IOException
    //   80	1	3	localFile	File
    //   7	37	4	localCRC32	java.util.zip.CRC32
    //   77	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	29	59	finally
    //   53	57	70	java/io/IOException
    //   64	68	73	java/io/IOException
    //   29	35	77	finally
    //   35	49	77	finally
  }
  
  public static boolean copyFile(File paramFile1, File paramFile2)
  {
    try
    {
      paramFile1 = new FileInputStream(paramFile1);
      try
      {
        boolean bool = copyToFile(paramFile1, paramFile2);
        return bool;
      }
      finally
      {
        paramFile1.close();
      }
      return false;
    }
    catch (IOException paramFile1) {}
  }
  
  /* Error */
  public static boolean copyToFile(InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 99	java/io/File:exists	()Z
    //   4: ifeq +8 -> 12
    //   7: aload_1
    //   8: invokevirtual 102	java/io/File:delete	()Z
    //   11: pop
    //   12: new 104	java/io/FileOutputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 105	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   20: astore_1
    //   21: sipush 4096
    //   24: newarray byte
    //   26: astore_3
    //   27: aload_0
    //   28: aload_3
    //   29: invokevirtual 106	java/io/InputStream:read	([B)I
    //   32: istore_2
    //   33: iload_2
    //   34: iflt +31 -> 65
    //   37: aload_1
    //   38: aload_3
    //   39: iconst_0
    //   40: iload_2
    //   41: invokevirtual 110	java/io/FileOutputStream:write	([BII)V
    //   44: goto -17 -> 27
    //   47: astore_0
    //   48: aload_1
    //   49: invokevirtual 113	java/io/FileOutputStream:flush	()V
    //   52: aload_1
    //   53: invokevirtual 117	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   56: invokevirtual 122	java/io/FileDescriptor:sync	()V
    //   59: aload_1
    //   60: invokevirtual 123	java/io/FileOutputStream:close	()V
    //   63: aload_0
    //   64: athrow
    //   65: aload_1
    //   66: invokevirtual 113	java/io/FileOutputStream:flush	()V
    //   69: aload_1
    //   70: invokevirtual 117	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   73: invokevirtual 122	java/io/FileDescriptor:sync	()V
    //   76: aload_1
    //   77: invokevirtual 123	java/io/FileOutputStream:close	()V
    //   80: iconst_1
    //   81: ireturn
    //   82: astore_3
    //   83: goto -24 -> 59
    //   86: astore_0
    //   87: goto -11 -> 76
    //   90: astore_0
    //   91: iconst_0
    //   92: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramInputStream	InputStream
    //   0	93	1	paramFile	File
    //   32	9	2	i	int
    //   26	13	3	arrayOfByte	byte[]
    //   82	1	3	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   21	27	47	finally
    //   27	33	47	finally
    //   37	44	47	finally
    //   52	59	82	java/io/IOException
    //   69	76	86	java/io/IOException
    //   0	12	90	java/io/IOException
    //   12	21	90	java/io/IOException
    //   48	52	90	java/io/IOException
    //   59	65	90	java/io/IOException
    //   65	69	90	java/io/IOException
    //   76	80	90	java/io/IOException
  }
  
  public static void deleteOlderFiles(File paramFile, int paramInt, long paramLong)
  {
    if ((paramInt < 0) || (paramLong < 0L)) {
      throw new IllegalArgumentException("Constraints must be positive or 0");
    }
    paramFile = paramFile.listFiles();
    if (paramFile == null) {}
    for (;;)
    {
      return;
      Arrays.sort(paramFile, new Comparator()
      {
        public int compare(File paramAnonymousFile1, File paramAnonymousFile2)
        {
          return (int)(paramAnonymousFile2.lastModified() - paramAnonymousFile1.lastModified());
        }
      });
      while (paramInt < paramFile.length)
      {
        Object localObject = paramFile[paramInt];
        if (System.currentTimeMillis() - localObject.lastModified() > paramLong)
        {
          Log.d("FileUtils", "Deleting old file " + localObject);
          localObject.delete();
        }
        paramInt += 1;
      }
    }
  }
  
  public static boolean isFilenameSafe(File paramFile)
  {
    return SAFE_FILENAME_PATTERN.matcher(paramFile.getPath()).matches();
  }
  
  public static String readTextFile(File paramFile, int paramInt, String paramString)
    throws IOException
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    BufferedInputStream localBufferedInputStream = new BufferedInputStream(localFileInputStream);
    for (;;)
    {
      long l;
      try
      {
        l = paramFile.length();
        if (paramInt <= 0) {
          if ((l > 0L) && (paramInt == 0))
          {
            break label465;
            paramFile = new byte[i + 1];
            paramInt = localBufferedInputStream.read(paramFile);
            if (paramInt <= 0) {
              return "";
            }
            if (paramInt <= i)
            {
              paramFile = new String(paramFile, 0, paramInt);
              return paramFile;
            }
            if (paramString == null)
            {
              paramFile = new String(paramFile, 0, i);
              return paramFile;
            }
            paramFile = new String(paramFile, 0, i) + paramString;
            return paramFile;
          }
          else
          {
            if (paramInt < 0)
            {
              int j = 0;
              Object localObject2 = null;
              paramFile = null;
              i = j;
              if (localObject2 != null) {
                i = 1;
              }
              File localFile = paramFile;
              Object localObject1 = localObject2;
              if (localObject2 == null)
              {
                j = -paramInt;
                localObject1 = new byte[j];
              }
              int k = localBufferedInputStream.read((byte[])localObject1);
              paramFile = (File)localObject1;
              localObject2 = localFile;
              j = i;
              if (k == localObject1.length) {
                continue;
              }
              if ((localFile == null) && (k <= 0)) {
                return "";
              }
              if (localFile == null)
              {
                paramFile = new String((byte[])localObject1, 0, k);
                return paramFile;
              }
              if (k <= 0) {
                break label495;
              }
              i = 1;
              System.arraycopy(localFile, k, localFile, 0, localFile.length - k);
              System.arraycopy(localObject1, 0, localFile, localFile.length - k, k);
              break label495;
              paramFile = new String(localFile);
              return paramFile;
              paramFile = paramString + new String(localFile);
              return paramFile;
            }
            paramFile = new ByteArrayOutputStream();
            paramString = new byte[1024];
            paramInt = localBufferedInputStream.read(paramString);
            if (paramInt > 0) {
              paramFile.write(paramString, 0, paramInt);
            }
            if (paramInt == paramString.length) {
              continue;
            }
            paramFile = paramFile.toString();
            return paramFile;
          }
        }
      }
      finally
      {
        localBufferedInputStream.close();
        localFileInputStream.close();
      }
      label465:
      int i = paramInt;
      if (l > 0L) {
        if (paramInt != 0)
        {
          i = paramInt;
          if (l >= paramInt) {}
        }
        else
        {
          i = (int)l;
          continue;
          label495:
          if (paramString != null) {
            if (i != 0) {}
          }
        }
      }
    }
  }
  
  public static native int setPermissions(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public static void stringToFile(String paramString1, String paramString2)
    throws IOException
  {
    paramString1 = new FileWriter(paramString1);
    try
    {
      paramString1.write(paramString2);
      return;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  public static boolean sync(FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream != null) {}
    try
    {
      paramFileOutputStream.getFD().sync();
      return true;
    }
    catch (IOException paramFileOutputStream) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.FileUtils
 * JD-Core Version:    0.7.0.1
 */