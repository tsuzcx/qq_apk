package com.tencent.qqmini.sdk.core.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.content.FileProvider;
import android.system.Os;
import android.system.StructStat;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import org.json.JSONObject;

public class FileUtils
{
  private static final String TAG = "FileUtils";
  public static String sAuthority = null;
  public static Boolean sIsTargetThanN = null;
  
  public static void broadcastCarmera(Context paramContext, File paramFile)
  {
    FileProvider7Helper.savePhotoToSysAlbum(paramContext, paramFile);
  }
  
  public static boolean checkDirAndCreate(String paramString)
  {
    File localFile = new File(paramString);
    if ((!localFile.exists()) && (!localFile.mkdirs()))
    {
      QMLog.w("FileUtils", "mkdirs failed, path: " + paramString);
      return false;
    }
    return true;
  }
  
  public static void copyFile(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  /* Error */
  public static boolean copyFile(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: iconst_0
    //   10: istore 4
    //   12: aload_1
    //   13: invokevirtual 43	java/io/File:exists	()Z
    //   16: ifeq +8 -> 24
    //   19: aload_1
    //   20: invokevirtual 88	java/io/File:delete	()Z
    //   23: pop
    //   24: new 90	java/io/FileOutputStream
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 93	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   32: astore_1
    //   33: new 95	java/io/BufferedInputStream
    //   36: dup
    //   37: new 97	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 98	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: invokespecial 101	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: astore_0
    //   49: sipush 1024
    //   52: newarray byte
    //   54: astore 5
    //   56: aload_0
    //   57: aload 5
    //   59: invokevirtual 102	java/io/BufferedInputStream:read	([B)I
    //   62: istore_2
    //   63: iload_2
    //   64: iconst_m1
    //   65: if_icmpeq +52 -> 117
    //   68: aload_1
    //   69: aload 5
    //   71: iconst_0
    //   72: iload_2
    //   73: invokevirtual 103	java/io/FileOutputStream:write	([BII)V
    //   76: aload_1
    //   77: invokevirtual 106	java/io/FileOutputStream:flush	()V
    //   80: goto -24 -> 56
    //   83: astore 5
    //   85: aload_0
    //   86: astore 5
    //   88: aload_1
    //   89: astore_0
    //   90: aload 5
    //   92: astore_1
    //   93: aload_0
    //   94: ifnull +7 -> 101
    //   97: aload_0
    //   98: invokevirtual 109	java/io/FileOutputStream:close	()V
    //   101: iload 4
    //   103: istore_3
    //   104: aload_1
    //   105: ifnull +10 -> 115
    //   108: aload_1
    //   109: invokevirtual 110	java/io/BufferedInputStream:close	()V
    //   112: iload 4
    //   114: istore_3
    //   115: iload_3
    //   116: ireturn
    //   117: iconst_1
    //   118: istore_3
    //   119: aload_1
    //   120: ifnull +7 -> 127
    //   123: aload_1
    //   124: invokevirtual 109	java/io/FileOutputStream:close	()V
    //   127: aload_0
    //   128: ifnull -13 -> 115
    //   131: aload_0
    //   132: invokevirtual 110	java/io/BufferedInputStream:close	()V
    //   135: iconst_1
    //   136: ireturn
    //   137: astore_0
    //   138: iconst_1
    //   139: ireturn
    //   140: astore_0
    //   141: aconst_null
    //   142: astore_1
    //   143: aload 7
    //   145: astore_0
    //   146: aload_1
    //   147: ifnull +7 -> 154
    //   150: aload_1
    //   151: invokevirtual 109	java/io/FileOutputStream:close	()V
    //   154: iload 4
    //   156: istore_3
    //   157: aload_0
    //   158: ifnull -43 -> 115
    //   161: aload_0
    //   162: invokevirtual 110	java/io/BufferedInputStream:close	()V
    //   165: iconst_0
    //   166: ireturn
    //   167: astore_0
    //   168: iconst_0
    //   169: ireturn
    //   170: astore_0
    //   171: aconst_null
    //   172: astore_1
    //   173: aload_1
    //   174: ifnull +7 -> 181
    //   177: aload_1
    //   178: invokevirtual 109	java/io/FileOutputStream:close	()V
    //   181: aload 5
    //   183: ifnull +8 -> 191
    //   186: aload 5
    //   188: invokevirtual 110	java/io/BufferedInputStream:close	()V
    //   191: aload_0
    //   192: athrow
    //   193: astore_1
    //   194: goto -67 -> 127
    //   197: astore_0
    //   198: goto -97 -> 101
    //   201: astore_0
    //   202: iconst_0
    //   203: ireturn
    //   204: astore_1
    //   205: goto -51 -> 154
    //   208: astore_1
    //   209: goto -28 -> 181
    //   212: astore_1
    //   213: goto -22 -> 191
    //   216: astore_0
    //   217: goto -44 -> 173
    //   220: astore 6
    //   222: aload_0
    //   223: astore 5
    //   225: aload 6
    //   227: astore_0
    //   228: goto -55 -> 173
    //   231: astore_0
    //   232: aload 7
    //   234: astore_0
    //   235: goto -89 -> 146
    //   238: astore 5
    //   240: goto -94 -> 146
    //   243: astore_0
    //   244: aconst_null
    //   245: astore_0
    //   246: aload 6
    //   248: astore_1
    //   249: goto -156 -> 93
    //   252: astore_0
    //   253: aload_1
    //   254: astore_0
    //   255: aload 6
    //   257: astore_1
    //   258: goto -165 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramFile1	File
    //   0	261	1	paramFile2	File
    //   62	11	2	i	int
    //   103	54	3	bool1	boolean
    //   10	145	4	bool2	boolean
    //   4	66	5	arrayOfByte	byte[]
    //   83	1	5	localIOException	IOException
    //   86	138	5	localFile	File
    //   238	1	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   7	1	6	localObject1	Object
    //   220	36	6	localObject2	Object
    //   1	232	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   49	56	83	java/io/IOException
    //   56	63	83	java/io/IOException
    //   68	80	83	java/io/IOException
    //   131	135	137	java/io/IOException
    //   12	24	140	java/lang/OutOfMemoryError
    //   24	33	140	java/lang/OutOfMemoryError
    //   161	165	167	java/io/IOException
    //   12	24	170	finally
    //   24	33	170	finally
    //   123	127	193	java/io/IOException
    //   97	101	197	java/io/IOException
    //   108	112	201	java/io/IOException
    //   150	154	204	java/io/IOException
    //   177	181	208	java/io/IOException
    //   186	191	212	java/io/IOException
    //   33	49	216	finally
    //   49	56	220	finally
    //   56	63	220	finally
    //   68	80	220	finally
    //   33	49	231	java/lang/OutOfMemoryError
    //   49	56	238	java/lang/OutOfMemoryError
    //   56	63	238	java/lang/OutOfMemoryError
    //   68	80	238	java/lang/OutOfMemoryError
    //   12	24	243	java/io/IOException
    //   24	33	243	java/io/IOException
    //   33	49	252	java/io/IOException
  }
  
  public static boolean copyFile(String paramString1, String paramString2)
  {
    boolean bool = false;
    paramString1 = new File(paramString1);
    if (paramString1.exists()) {}
    try
    {
      bool = copyFile(paramString1, createFile(paramString2));
      return bool;
    }
    catch (IOException paramString1) {}
    return false;
  }
  
  public static File createFile(String paramString)
    throws IOException
  {
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      if ((paramString.getParentFile() == null) || (paramString.getParentFile().exists())) {
        break label50;
      }
      if (paramString.getParentFile().mkdirs()) {
        paramString.createNewFile();
      }
    }
    return paramString;
    label50:
    paramString.createNewFile();
    return paramString;
  }
  
  public static long delete(String paramString, boolean paramBoolean)
  {
    long l1 = 0L;
    long l2;
    if (paramString == null) {
      l2 = l1;
    }
    do
    {
      File[] arrayOfFile;
      do
      {
        do
        {
          do
          {
            return l2;
            paramString = new File(paramString);
            l2 = l1;
          } while (paramString == null);
          l2 = l1;
        } while (!paramString.exists());
        if (paramString.isFile())
        {
          l1 = paramString.length();
          paramString.delete();
          return l1;
        }
        arrayOfFile = paramString.listFiles();
        l2 = l1;
      } while (arrayOfFile == null);
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        l2 = delete(arrayOfFile[i].getAbsolutePath(), paramBoolean);
        i += 1;
        l1 = l2 + l1;
      }
      l2 = l1;
    } while (paramBoolean);
    paramString.delete();
    return l1;
  }
  
  public static long deleteDirectory(String paramString)
  {
    long l1 = 0L;
    if ((paramString == null) || (paramString.trim().length() == 0)) {
      return 0L;
    }
    paramString = new File(paramString);
    File[] arrayOfFile = paramString.listFiles();
    long l2 = l1;
    if (arrayOfFile != null)
    {
      l2 = l1;
      if (arrayOfFile.length > 0)
      {
        int i = 0;
        l2 = l1;
        if (i < arrayOfFile.length)
        {
          if (arrayOfFile[i].isDirectory()) {
            l1 += deleteDirectory(arrayOfFile[i].getAbsolutePath());
          }
          for (;;)
          {
            i += 1;
            break;
            l1 += arrayOfFile[i].length();
            arrayOfFile[i].delete();
          }
        }
      }
    }
    paramString.delete();
    return l2;
  }
  
  public static boolean deleteFile(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          deleteFile(arrayOfFile[i]);
          i += 1;
        }
      }
    }
    return paramFile.delete();
  }
  
  public static boolean deleteFile(String paramString)
  {
    boolean bool = true;
    paramString = new File(paramString);
    if (paramString.exists()) {
      bool = paramString.delete();
    }
    return bool;
  }
  
  public static long deleteFilesInDirectory(String paramString)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramString != null)
    {
      if (paramString.trim().length() != 0) {
        break label25;
      }
      l2 = l1;
    }
    label25:
    int i;
    do
    {
      do
      {
        do
        {
          return l2;
          paramString = new File(paramString).listFiles();
          l2 = l1;
        } while (paramString == null);
        l2 = l1;
      } while (paramString.length <= 0);
      i = 0;
      l2 = l1;
    } while (i >= paramString.length);
    if (paramString[i].isDirectory()) {
      l1 += deleteDirectory(paramString[i].getAbsolutePath());
    }
    for (;;)
    {
      i += 1;
      break;
      l1 += paramString[i].length();
      paramString[i].delete();
    }
  }
  
  public static void deleteSubFile(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      if ((paramFile != null) && (paramFile.length > 0))
      {
        int i = 0;
        while (i < paramFile.length)
        {
          deleteFile(paramFile[i]);
          i += 1;
        }
      }
    }
  }
  
  public static boolean fileExists(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((paramString == null) || (!paramString.exists()));
    return true;
  }
  
  /* Error */
  public static byte[] fileToBytes(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 43	java/io/File:exists	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 95	java/io/BufferedInputStream
    //   12: dup
    //   13: new 97	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 98	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: invokespecial 101	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   24: astore 5
    //   26: aload_0
    //   27: invokevirtual 132	java/io/File:length	()J
    //   30: lstore_3
    //   31: lload_3
    //   32: ldc2_w 168
    //   35: lcmp
    //   36: ifgt +9 -> 45
    //   39: lload_3
    //   40: lconst_0
    //   41: lcmp
    //   42: ifgt +46 -> 88
    //   45: ldc 11
    //   47: new 48	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   54: ldc 171
    //   56: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: lload_3
    //   60: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   63: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 177	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload 5
    //   71: ifnull -64 -> 7
    //   74: aload 5
    //   76: invokevirtual 178	java/io/InputStream:close	()V
    //   79: aconst_null
    //   80: areturn
    //   81: astore_0
    //   82: aload_0
    //   83: invokevirtual 181	java/lang/Throwable:printStackTrace	()V
    //   86: aconst_null
    //   87: areturn
    //   88: lload_3
    //   89: l2i
    //   90: istore_1
    //   91: iload_1
    //   92: newarray byte
    //   94: astore 6
    //   96: iconst_0
    //   97: istore_1
    //   98: iload_1
    //   99: aload 6
    //   101: arraylength
    //   102: if_icmpge +28 -> 130
    //   105: aload 5
    //   107: aload 6
    //   109: iload_1
    //   110: aload 6
    //   112: arraylength
    //   113: iload_1
    //   114: isub
    //   115: invokevirtual 184	java/io/InputStream:read	([BII)I
    //   118: istore_2
    //   119: iload_2
    //   120: iflt +10 -> 130
    //   123: iload_1
    //   124: iload_2
    //   125: iadd
    //   126: istore_1
    //   127: goto -29 -> 98
    //   130: iload_1
    //   131: aload 6
    //   133: arraylength
    //   134: if_icmpge +27 -> 161
    //   137: ldc 11
    //   139: new 48	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   146: ldc 186
    //   148: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_0
    //   152: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 177	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload 5
    //   163: ifnull +8 -> 171
    //   166: aload 5
    //   168: invokevirtual 178	java/io/InputStream:close	()V
    //   171: aload 6
    //   173: areturn
    //   174: astore_0
    //   175: aload_0
    //   176: invokevirtual 181	java/lang/Throwable:printStackTrace	()V
    //   179: goto -8 -> 171
    //   182: astore 5
    //   184: aconst_null
    //   185: astore 5
    //   187: ldc 11
    //   189: new 48	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   196: ldc 191
    //   198: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_0
    //   202: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 177	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload 5
    //   213: ifnull -206 -> 7
    //   216: aload 5
    //   218: invokevirtual 178	java/io/InputStream:close	()V
    //   221: aconst_null
    //   222: areturn
    //   223: astore_0
    //   224: aload_0
    //   225: invokevirtual 181	java/lang/Throwable:printStackTrace	()V
    //   228: aconst_null
    //   229: areturn
    //   230: astore_0
    //   231: aconst_null
    //   232: astore 5
    //   234: aload 5
    //   236: ifnull +8 -> 244
    //   239: aload 5
    //   241: invokevirtual 178	java/io/InputStream:close	()V
    //   244: aload_0
    //   245: athrow
    //   246: astore 5
    //   248: aload 5
    //   250: invokevirtual 181	java/lang/Throwable:printStackTrace	()V
    //   253: goto -9 -> 244
    //   256: astore_0
    //   257: goto -23 -> 234
    //   260: astore_0
    //   261: goto -27 -> 234
    //   264: astore 6
    //   266: goto -79 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	paramFile	File
    //   90	45	1	i	int
    //   118	8	2	j	int
    //   30	59	3	l	long
    //   24	143	5	localBufferedInputStream	java.io.BufferedInputStream
    //   182	1	5	localThrowable1	Throwable
    //   185	55	5	localObject	Object
    //   246	3	5	localThrowable2	Throwable
    //   94	78	6	arrayOfByte	byte[]
    //   264	1	6	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   74	79	81	java/lang/Throwable
    //   166	171	174	java/lang/Throwable
    //   9	26	182	java/lang/Throwable
    //   216	221	223	java/lang/Throwable
    //   9	26	230	finally
    //   239	244	246	java/lang/Throwable
    //   26	31	256	finally
    //   45	69	256	finally
    //   91	96	256	finally
    //   98	119	256	finally
    //   130	161	256	finally
    //   187	211	260	finally
    //   26	31	264	java/lang/Throwable
    //   45	69	264	java/lang/Throwable
    //   91	96	264	java/lang/Throwable
    //   98	119	264	java/lang/Throwable
    //   130	161	264	java/lang/Throwable
  }
  
  public static ArrayList<String> getChildFiles(String paramString, boolean paramBoolean)
  {
    Object localObject = new File(paramString);
    paramString = new ArrayList();
    localObject = ((File)localObject).listFiles();
    int i = 0;
    for (;;)
    {
      try
      {
        int j = localObject.length;
        if (i < j) {
          if (localObject[i].isDirectory())
          {
            if (paramBoolean) {
              paramString.add(localObject[i].getCanonicalPath());
            }
            paramString.addAll(getChildFiles(localObject[i].getCanonicalPath(), paramBoolean));
          }
          else
          {
            paramString.add(localObject[i].getCanonicalPath());
          }
        }
      }
      catch (Exception localException)
      {
        QMLog.e("FileUtils.getChildFiles", "getChildFiles error. " + localException);
      }
      return paramString;
      i += 1;
    }
  }
  
  public static String getExtension(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if (paramString.endsWith(".rename") == true)
    {
      String str = paramString.replace(".rename", "");
      i = str.lastIndexOf(".");
      if (i == -1) {
        return "";
      }
      if (str.substring(i).replaceAll("[0-9]*", "").replace("(", "").replace(")", "").equalsIgnoreCase(".apk") == true) {
        return ".apk.rename";
      }
    }
    int i = paramString.lastIndexOf(".");
    if (i >= 0) {
      return paramString.substring(i);
    }
    return "";
  }
  
  public static long getFileOrFolderSize(String paramString)
  {
    long l2 = 0L;
    paramString = new File(paramString);
    long l1 = l2;
    if (paramString.exists())
    {
      if (!paramString.isFile()) {
        break label36;
      }
      l1 = paramString.length();
    }
    label36:
    int j;
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return l1;
            l1 = l2;
          } while (!paramString.isDirectory());
          paramString = paramString.listFiles();
          l1 = l2;
        } while (paramString == null);
        l1 = l2;
      } while (paramString.length <= 0);
      j = paramString.length;
      i = 0;
      l1 = l2;
    } while (i >= j);
    Object localObject = paramString[i];
    l1 = l2;
    if (localObject != null)
    {
      l1 = l2;
      if (localObject.exists())
      {
        if (!localObject.isDirectory()) {
          break label133;
        }
        l1 = l2 + getFileOrFolderSize(localObject.getAbsolutePath());
      }
    }
    for (;;)
    {
      i += 1;
      l2 = l1;
      break;
      label133:
      l1 = l2;
      if (localObject.isFile()) {
        l1 = l2 + localObject.length();
      }
    }
  }
  
  public static long getFileSizes(String paramString)
  {
    try
    {
      long l = new File(paramString).length();
      return l;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  public static ArrayList<FileInfo> getFiles(String paramString, boolean paramBoolean, int paramInt)
  {
    try
    {
      paramString = new File(paramString).listFiles();
      if (paramString == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < paramString.length)
      {
        Object localObject = paramString[i];
        if ((!paramBoolean) && (localObject.getName().startsWith("."))) {}
        for (;;)
        {
          i += 1;
          break;
          if ((localObject.isDirectory()) || (localObject.length() != 0L))
          {
            FileInfo localFileInfo = new FileInfo();
            localFileInfo.setName(localObject.getName());
            localFileInfo.setDirectory(localObject.isDirectory());
            localFileInfo.setPath(localObject.getPath());
            localFileInfo.setSize(localObject.length());
            localFileInfo.setDate(localObject.lastModified());
            localArrayList.add(localFileInfo);
          }
        }
      }
      if (paramInt == 0) {
        Collections.sort(localArrayList, new MyFileCompare());
      }
      for (;;)
      {
        return localArrayList;
        Collections.sort(localArrayList, new FileCompare());
      }
      return null;
    }
    catch (Exception paramString) {}
  }
  
  public static JSONObject getStats(String paramString)
  {
    JSONObject localJSONObject;
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        paramString = Os.stat(paramString);
        localJSONObject = new JSONObject();
        localJSONObject.put("mode", paramString.st_mode);
        localJSONObject.put("size", paramString.st_size);
        localJSONObject.put("lastAccessedTime", paramString.st_atime);
        localJSONObject.put("lastModifiedTime", paramString.st_mtime);
        return localJSONObject;
      }
      catch (Exception paramString)
      {
        QMLog.e("FileUtils.getStats", "getStats error. " + paramString);
      }
    }
    for (;;)
    {
      return null;
      try
      {
        paramString = new File(paramString);
        localJSONObject = new JSONObject();
        localJSONObject.put("mode", 0);
        localJSONObject.put("size", paramString.length());
        localJSONObject.put("lastAccessedTime", paramString.lastModified());
        localJSONObject.put("lastModifiedTime", paramString.lastModified());
        return localJSONObject;
      }
      catch (Exception paramString)
      {
        QMLog.e("FileUtils.getStats", "getStats error. " + paramString);
      }
    }
  }
  
  public static JSONObject getStatsByDir(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("/", getStats(paramString));
      Object localObject = getChildFiles(paramString, true);
      paramString = new File(paramString);
      paramString = paramString.getCanonicalPath() + "/";
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localJSONObject.put(str.replace(paramString, ""), getStats(str));
      }
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      QMLog.e("FileUtils.getStatsByDir", "getStatsByDir error. " + paramString);
      return null;
    }
  }
  
  public static Uri getUriForFile(Context paramContext, File paramFile)
  {
    if (isTargetBeyondN(paramContext)) {
      return getUriForFile24(paramContext, paramFile);
    }
    return Uri.fromFile(paramFile);
  }
  
  private static Uri getUriForFile24(Context paramContext, File paramFile)
  {
    if (sAuthority == null) {
      sAuthority = paramContext.getApplicationContext().getPackageName() + ".fileprovider";
    }
    return FileProvider.getUriForFile(paramContext, sAuthority, paramFile);
  }
  
  public static boolean isTargetBeyondN(Context paramContext)
  {
    if (sIsTargetThanN == null) {
      if ((Build.VERSION.SDK_INT < 24) || (paramContext.getApplicationContext().getApplicationInfo().targetSdkVersion < 24)) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      sIsTargetThanN = Boolean.valueOf(bool);
      return sIsTargetThanN.booleanValue();
    }
  }
  
  /* Error */
  public static String readFileFromAssets(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 439	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: aload_1
    //   5: invokevirtual 445	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: aload_1
    //   12: invokevirtual 448	java/io/InputStream:available	()I
    //   15: newarray byte
    //   17: astore_2
    //   18: aload_1
    //   19: astore_0
    //   20: aload_1
    //   21: aload_2
    //   22: invokevirtual 75	java/io/InputStream:read	([B)I
    //   25: pop
    //   26: aload_1
    //   27: astore_0
    //   28: new 145	java/lang/String
    //   31: dup
    //   32: aload_2
    //   33: ldc_w 450
    //   36: invokespecial 453	java/lang/String:<init>	([BLjava/lang/String;)V
    //   39: astore_2
    //   40: aload_1
    //   41: ifnull +7 -> 48
    //   44: aload_1
    //   45: invokevirtual 178	java/io/InputStream:close	()V
    //   48: aload_2
    //   49: areturn
    //   50: astore_0
    //   51: ldc 11
    //   53: new 48	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   60: ldc_w 455
    //   63: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_0
    //   67: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 218	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_2
    //   77: areturn
    //   78: astore_2
    //   79: aconst_null
    //   80: astore_1
    //   81: aload_1
    //   82: astore_0
    //   83: ldc 11
    //   85: new 48	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   92: ldc_w 457
    //   95: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_2
    //   99: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 218	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_1
    //   109: ifnull +7 -> 116
    //   112: aload_1
    //   113: invokevirtual 178	java/io/InputStream:close	()V
    //   116: aconst_null
    //   117: areturn
    //   118: astore_0
    //   119: ldc 11
    //   121: new 48	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   128: ldc_w 455
    //   131: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_0
    //   135: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 218	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: goto -28 -> 116
    //   147: astore_1
    //   148: aconst_null
    //   149: astore_0
    //   150: aload_0
    //   151: ifnull +7 -> 158
    //   154: aload_0
    //   155: invokevirtual 178	java/io/InputStream:close	()V
    //   158: aload_1
    //   159: athrow
    //   160: astore_0
    //   161: ldc 11
    //   163: new 48	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 455
    //   173: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_0
    //   177: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 218	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: goto -28 -> 158
    //   189: astore_1
    //   190: goto -40 -> 150
    //   193: astore_2
    //   194: goto -113 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramContext	Context
    //   0	197	1	paramString	String
    //   17	60	2	localObject	Object
    //   78	21	2	localException1	Exception
    //   193	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   44	48	50	java/io/IOException
    //   0	9	78	java/lang/Exception
    //   112	116	118	java/io/IOException
    //   0	9	147	finally
    //   154	158	160	java/io/IOException
    //   11	18	189	finally
    //   20	26	189	finally
    //   28	40	189	finally
    //   83	108	189	finally
    //   11	18	193	java/lang/Exception
    //   20	26	193	java/lang/Exception
    //   28	40	193	java/lang/Exception
  }
  
  public static String readFileToStr(File paramFile)
  {
    if (paramFile != null) {
      try
      {
        if (paramFile.exists())
        {
          paramFile = readFileToString(paramFile);
          return paramFile;
        }
      }
      catch (Throwable paramFile)
      {
        paramFile.printStackTrace();
        return "";
      }
    }
    return null;
  }
  
  /* Error */
  public static String readFileToString(File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +8 -> 12
    //   7: aload 4
    //   9: astore_3
    //   10: aload_3
    //   11: areturn
    //   12: aload_0
    //   13: invokevirtual 43	java/io/File:exists	()Z
    //   16: ifeq +85 -> 101
    //   19: aload_0
    //   20: invokevirtual 154	java/io/File:isDirectory	()Z
    //   23: ifeq +37 -> 60
    //   26: new 69	java/io/IOException
    //   29: dup
    //   30: new 48	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 464
    //   40: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_0
    //   44: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   47: ldc_w 466
    //   50: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokespecial 467	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   59: athrow
    //   60: aload_0
    //   61: invokevirtual 470	java/io/File:canRead	()Z
    //   64: ifne +71 -> 135
    //   67: new 69	java/io/IOException
    //   70: dup
    //   71: new 48	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   78: ldc_w 464
    //   81: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_0
    //   85: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   88: ldc_w 472
    //   91: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokespecial 467	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   100: athrow
    //   101: new 474	java/io/FileNotFoundException
    //   104: dup
    //   105: new 48	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 464
    //   115: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   122: ldc_w 476
    //   125: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokespecial 477	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   134: athrow
    //   135: new 97	java/io/FileInputStream
    //   138: dup
    //   139: aload_0
    //   140: invokespecial 98	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   143: astore_3
    //   144: new 479	java/io/InputStreamReader
    //   147: dup
    //   148: aload_3
    //   149: ldc_w 481
    //   152: invokespecial 484	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   155: astore_2
    //   156: aload_0
    //   157: invokevirtual 132	java/io/File:length	()J
    //   160: l2i
    //   161: istore_1
    //   162: iload_1
    //   163: sipush 12288
    //   166: if_icmple +100 -> 266
    //   169: sipush 4096
    //   172: newarray char
    //   174: astore_0
    //   175: new 48	java/lang/StringBuilder
    //   178: dup
    //   179: sipush 12288
    //   182: invokespecial 487	java/lang/StringBuilder:<init>	(I)V
    //   185: astore 5
    //   187: aload_2
    //   188: aload_0
    //   189: invokevirtual 490	java/io/InputStreamReader:read	([C)I
    //   192: istore_1
    //   193: iconst_m1
    //   194: iload_1
    //   195: if_icmpeq +42 -> 237
    //   198: aload 5
    //   200: aload_0
    //   201: iconst_0
    //   202: iload_1
    //   203: invokevirtual 493	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: goto -20 -> 187
    //   210: astore_0
    //   211: aload_2
    //   212: astore_0
    //   213: aload_3
    //   214: ifnull +7 -> 221
    //   217: aload_3
    //   218: invokevirtual 178	java/io/InputStream:close	()V
    //   221: aload 4
    //   223: astore_3
    //   224: aload_0
    //   225: ifnull -215 -> 10
    //   228: aload_0
    //   229: invokevirtual 494	java/io/InputStreamReader:close	()V
    //   232: aconst_null
    //   233: areturn
    //   234: astore_0
    //   235: aconst_null
    //   236: areturn
    //   237: aload 5
    //   239: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: astore_0
    //   243: aload_3
    //   244: ifnull +7 -> 251
    //   247: aload_3
    //   248: invokevirtual 178	java/io/InputStream:close	()V
    //   251: aload_0
    //   252: astore_3
    //   253: aload_2
    //   254: ifnull -244 -> 10
    //   257: aload_2
    //   258: invokevirtual 494	java/io/InputStreamReader:close	()V
    //   261: aload_0
    //   262: areturn
    //   263: astore_2
    //   264: aload_0
    //   265: areturn
    //   266: iload_1
    //   267: newarray char
    //   269: astore_0
    //   270: new 145	java/lang/String
    //   273: dup
    //   274: aload_0
    //   275: iconst_0
    //   276: aload_2
    //   277: aload_0
    //   278: invokevirtual 490	java/io/InputStreamReader:read	([C)I
    //   281: invokespecial 497	java/lang/String:<init>	([CII)V
    //   284: astore_0
    //   285: goto -42 -> 243
    //   288: astore_0
    //   289: aconst_null
    //   290: astore_3
    //   291: aconst_null
    //   292: astore_2
    //   293: aload_3
    //   294: ifnull +7 -> 301
    //   297: aload_3
    //   298: invokevirtual 178	java/io/InputStream:close	()V
    //   301: aload_2
    //   302: ifnull +7 -> 309
    //   305: aload_2
    //   306: invokevirtual 494	java/io/InputStreamReader:close	()V
    //   309: aload_0
    //   310: athrow
    //   311: astore_3
    //   312: goto -61 -> 251
    //   315: astore_2
    //   316: goto -95 -> 221
    //   319: astore_3
    //   320: goto -19 -> 301
    //   323: astore_2
    //   324: goto -15 -> 309
    //   327: astore_0
    //   328: aconst_null
    //   329: astore_2
    //   330: goto -37 -> 293
    //   333: astore_0
    //   334: goto -41 -> 293
    //   337: astore_0
    //   338: aconst_null
    //   339: astore_0
    //   340: aconst_null
    //   341: astore_3
    //   342: goto -129 -> 213
    //   345: astore_0
    //   346: aconst_null
    //   347: astore_0
    //   348: goto -135 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramFile	File
    //   161	106	1	i	int
    //   155	103	2	localInputStreamReader	java.io.InputStreamReader
    //   263	14	2	localException1	Exception
    //   292	14	2	localObject1	Object
    //   315	1	2	localException2	Exception
    //   323	1	2	localException3	Exception
    //   329	1	2	localObject2	Object
    //   9	289	3	localObject3	Object
    //   311	1	3	localException4	Exception
    //   319	1	3	localException5	Exception
    //   341	1	3	localObject4	Object
    //   1	221	4	localObject5	Object
    //   185	53	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   156	162	210	java/lang/Exception
    //   169	187	210	java/lang/Exception
    //   187	193	210	java/lang/Exception
    //   198	207	210	java/lang/Exception
    //   237	243	210	java/lang/Exception
    //   266	285	210	java/lang/Exception
    //   228	232	234	java/lang/Exception
    //   257	261	263	java/lang/Exception
    //   135	144	288	finally
    //   247	251	311	java/lang/Exception
    //   217	221	315	java/lang/Exception
    //   297	301	319	java/lang/Exception
    //   305	309	323	java/lang/Exception
    //   144	156	327	finally
    //   156	162	333	finally
    //   169	187	333	finally
    //   187	193	333	finally
    //   198	207	333	finally
    //   237	243	333	finally
    //   266	285	333	finally
    //   135	144	337	java/lang/Exception
    //   144	156	345	java/lang/Exception
  }
  
  public static boolean rename(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return false;
      paramString1 = new File(paramString1);
    } while (!paramString1.exists());
    return paramString1.renameTo(new File(paramString2));
  }
  
  public static boolean renameFile(File paramFile1, File paramFile2)
  {
    boolean bool1 = true;
    if (paramFile2.exists()) {
      bool1 = paramFile2.delete();
    }
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = paramFile1.renameTo(paramFile2);
    }
    return bool2;
  }
  
  public static boolean renameFile(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    return renameFile(new File(paramString1), new File(paramString2));
  }
  
  public static boolean saveVideoToAlbum(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {
      return false;
    }
    paramString2 = new File(paramString2);
    String str = paramString2.getParent();
    if (str != null) {
      checkDirAndCreate(str);
    }
    boolean bool = copyFile(paramString1, paramString2);
    QMLog.i("FileUtils", "saveVideoToAlbum: " + bool);
    broadcastCarmera(paramContext, paramString2);
    return true;
  }
  
  public static boolean writeFile(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!paramString1.exists()) {}
    try
    {
      paramString1.createNewFile();
      bool1 = bool2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          label39:
          paramString1.close();
          return bool2;
        }
        catch (IOException paramString1) {}
        localIOException = localIOException;
        bool1 = false;
      }
    }
    try
    {
      paramString1 = new FileOutputStream(paramString1, false);
      bool2 = bool1;
    }
    catch (FileNotFoundException paramString1)
    {
      bool2 = false;
      paramString1 = null;
      break label39;
    }
    bool1 = bool2;
    if (paramString1 != null) {}
    try
    {
      paramString1.write(paramString2.getBytes());
      bool1 = bool2;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        bool1 = false;
      }
    }
    bool2 = bool1;
    if (paramString1 != null) {}
    try
    {
      paramString1.flush();
      bool2 = bool1;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        bool2 = false;
      }
    }
    if (paramString1 != null) {}
    return false;
  }
  
  public static boolean writeFile(String paramString, byte[] paramArrayOfByte)
  {
    return writeFile(paramString, paramArrayOfByte, false);
  }
  
  public static boolean writeFile(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return writeFile(paramString, paramArrayOfByte, paramBoolean, paramArrayOfByte.length);
  }
  
  /* Error */
  public static boolean writeFile(String paramString, byte[] paramArrayOfByte, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 36	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_0
    //   16: invokevirtual 43	java/io/File:exists	()Z
    //   19: ifne +26 -> 45
    //   22: aload_0
    //   23: invokevirtual 121	java/io/File:getParentFile	()Ljava/io/File;
    //   26: invokevirtual 43	java/io/File:exists	()Z
    //   29: ifne +11 -> 40
    //   32: aload_0
    //   33: invokevirtual 121	java/io/File:getParentFile	()Ljava/io/File;
    //   36: invokevirtual 46	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: aload_0
    //   41: invokevirtual 124	java/io/File:createNewFile	()Z
    //   44: pop
    //   45: new 90	java/io/FileOutputStream
    //   48: dup
    //   49: aload_0
    //   50: iload_2
    //   51: invokespecial 531	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   54: astore_0
    //   55: aload_0
    //   56: aload_1
    //   57: iconst_0
    //   58: iload_3
    //   59: invokevirtual 103	java/io/FileOutputStream:write	([BII)V
    //   62: aload_0
    //   63: invokevirtual 106	java/io/FileOutputStream:flush	()V
    //   66: aload_0
    //   67: ifnull +7 -> 74
    //   70: aload_0
    //   71: invokevirtual 109	java/io/FileOutputStream:close	()V
    //   74: iconst_1
    //   75: istore_2
    //   76: iload_2
    //   77: ireturn
    //   78: astore_0
    //   79: aconst_null
    //   80: astore_0
    //   81: iload 4
    //   83: istore_2
    //   84: aload_0
    //   85: ifnull -9 -> 76
    //   88: aload_0
    //   89: invokevirtual 109	java/io/FileOutputStream:close	()V
    //   92: iconst_0
    //   93: ireturn
    //   94: astore_0
    //   95: iconst_0
    //   96: ireturn
    //   97: astore_0
    //   98: aload 5
    //   100: astore_1
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 109	java/io/FileOutputStream:close	()V
    //   109: aload_0
    //   110: athrow
    //   111: astore_0
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_1
    //   115: goto -6 -> 109
    //   118: astore 5
    //   120: aload_0
    //   121: astore_1
    //   122: aload 5
    //   124: astore_0
    //   125: goto -24 -> 101
    //   128: astore_1
    //   129: goto -48 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramString	String
    //   0	132	1	paramArrayOfByte	byte[]
    //   0	132	2	paramBoolean	boolean
    //   0	132	3	paramInt	int
    //   1	81	4	bool	boolean
    //   4	95	5	localObject1	Object
    //   118	5	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   15	40	78	java/io/IOException
    //   40	45	78	java/io/IOException
    //   45	55	78	java/io/IOException
    //   88	92	94	java/io/IOException
    //   15	40	97	finally
    //   40	45	97	finally
    //   45	55	97	finally
    //   70	74	111	java/io/IOException
    //   105	109	114	java/io/IOException
    //   55	66	118	finally
    //   55	66	128	java/io/IOException
  }
  
  public static boolean writeFile(byte[] paramArrayOfByte, String paramString)
  {
    return writeFile(paramArrayOfByte, paramString, false);
  }
  
  public static boolean writeFile(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
  {
    return writeFile(paramArrayOfByte, paramString, paramBoolean, paramArrayOfByte.length);
  }
  
  /* Error */
  public static boolean writeFile(byte[] paramArrayOfByte, String paramString, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 36	java/io/File
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_1
    //   15: aload_1
    //   16: invokevirtual 43	java/io/File:exists	()Z
    //   19: ifne +26 -> 45
    //   22: aload_1
    //   23: invokevirtual 121	java/io/File:getParentFile	()Ljava/io/File;
    //   26: invokevirtual 43	java/io/File:exists	()Z
    //   29: ifne +11 -> 40
    //   32: aload_1
    //   33: invokevirtual 121	java/io/File:getParentFile	()Ljava/io/File;
    //   36: invokevirtual 46	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: aload_1
    //   41: invokevirtual 124	java/io/File:createNewFile	()Z
    //   44: pop
    //   45: new 90	java/io/FileOutputStream
    //   48: dup
    //   49: aload_1
    //   50: iload_2
    //   51: invokespecial 531	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   54: astore_1
    //   55: aload_1
    //   56: aload_0
    //   57: iconst_0
    //   58: iload_3
    //   59: invokevirtual 103	java/io/FileOutputStream:write	([BII)V
    //   62: aload_1
    //   63: invokevirtual 106	java/io/FileOutputStream:flush	()V
    //   66: aload_1
    //   67: ifnull +7 -> 74
    //   70: aload_1
    //   71: invokevirtual 109	java/io/FileOutputStream:close	()V
    //   74: iconst_1
    //   75: istore_2
    //   76: iload_2
    //   77: ireturn
    //   78: astore_0
    //   79: aconst_null
    //   80: astore_0
    //   81: iload 4
    //   83: istore_2
    //   84: aload_0
    //   85: ifnull -9 -> 76
    //   88: aload_0
    //   89: invokevirtual 109	java/io/FileOutputStream:close	()V
    //   92: iconst_0
    //   93: ireturn
    //   94: astore_0
    //   95: iconst_0
    //   96: ireturn
    //   97: astore_0
    //   98: aload 5
    //   100: astore_1
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 109	java/io/FileOutputStream:close	()V
    //   109: aload_0
    //   110: athrow
    //   111: astore_0
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_1
    //   115: goto -6 -> 109
    //   118: astore_0
    //   119: goto -18 -> 101
    //   122: astore_0
    //   123: aload_1
    //   124: astore_0
    //   125: goto -44 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramArrayOfByte	byte[]
    //   0	128	1	paramString	String
    //   0	128	2	paramBoolean	boolean
    //   0	128	3	paramInt	int
    //   1	81	4	bool	boolean
    //   4	95	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	40	78	java/io/IOException
    //   40	45	78	java/io/IOException
    //   45	55	78	java/io/IOException
    //   88	92	94	java/io/IOException
    //   15	40	97	finally
    //   40	45	97	finally
    //   45	55	97	finally
    //   70	74	111	java/io/IOException
    //   105	109	114	java/io/IOException
    //   55	66	118	finally
    //   55	66	122	java/io/IOException
  }
  
  public static class MyFileCompare
    implements Comparator<FileInfo>
  {
    public int compare(FileInfo paramFileInfo1, FileInfo paramFileInfo2)
    {
      if (paramFileInfo1.isDirectory()) {
        if (paramFileInfo2.isDirectory()) {
          break label25;
        }
      }
      label25:
      while (paramFileInfo1.getDate() > paramFileInfo2.getDate())
      {
        return -1;
        if (paramFileInfo2.isDirectory()) {
          return 1;
        }
      }
      if (paramFileInfo1.getDate() == paramFileInfo2.getDate()) {
        return 0;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */