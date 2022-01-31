package com.qzone.utils;

import android.content.Context;
import android.content.res.AssetManager;
import com.qzone.common.logging.QDLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileUtil
{
  private static final BytesBufferPool sBytesBufferPool = new BytesBufferPool(4, 8192);
  
  public static void copyAssets(Context paramContext, String paramString1, String paramString2)
  {
    copyAssets(paramContext, paramString1, paramString2, null);
  }
  
  public static void copyAssets(Context paramContext, String paramString1, String paramString2, FilePathFilter paramFilePathFilter)
  {
    if (isEmpty(paramString2)) {}
    for (;;)
    {
      return;
      String str1 = paramString1;
      if (paramString1 == null) {
        str1 = "";
      }
      paramString1 = paramContext.getAssets();
      String str2 = null;
      try
      {
        paramString1 = paramString1.list(str1);
        if (paramString1 == null) {
          continue;
        }
        if ((paramString1.length == 0) && (str1.length() > 0)) {
          copyAssetsFile(paramContext, str1, paramString2, paramFilePathFilter);
        }
        int j = paramString1.length;
        int i = 0;
        while (i < j)
        {
          str2 = paramString1[i];
          if (!isEmpty(str2)) {
            break label122;
          }
          i += 1;
        }
      }
      catch (FileNotFoundException paramString1)
      {
        for (;;)
        {
          paramString1 = str2;
          if (str1.length() > 0)
          {
            copyAssetsFile(paramContext, str1, paramString2, paramFilePathFilter);
            paramString1 = str2;
          }
        }
        if (str1.length() == 0) {}
        for (paramFilePathFilter = str2;; paramFilePathFilter = str1 + File.separator + str2)
        {
          copyAssets(paramContext, paramFilePathFilter, paramString2 + File.separator + str2);
          break;
        }
      }
      catch (IOException paramString1)
      {
        for (;;)
        {
          label122:
          paramString1 = str2;
        }
      }
    }
  }
  
  /* Error */
  private static void copyAssetsFile(Context paramContext, String paramString1, String paramString2, FilePathFilter paramFilePathFilter)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 35	com/qzone/utils/FileUtil:isEmpty	(Ljava/lang/String;)Z
    //   4: ifne +10 -> 14
    //   7: aload_2
    //   8: invokestatic 35	com/qzone/utils/FileUtil:isEmpty	(Ljava/lang/String;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: aload_3
    //   16: ifnull +13 -> 29
    //   19: aload_3
    //   20: aload_1
    //   21: invokeinterface 88 2 0
    //   26: ifeq -12 -> 14
    //   29: aload_0
    //   30: invokevirtual 43	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   33: astore 8
    //   35: new 69	java/io/File
    //   38: dup
    //   39: aload_2
    //   40: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore_3
    //   44: aload_3
    //   45: invokevirtual 93	java/io/File:exists	()Z
    //   48: istore 5
    //   50: iload 5
    //   52: ifeq +95 -> 147
    //   55: iconst_0
    //   56: istore 4
    //   58: aload 8
    //   60: aload_1
    //   61: invokevirtual 97	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   64: astore 9
    //   66: aload_3
    //   67: invokevirtual 100	java/io/File:length	()J
    //   70: aload 9
    //   72: invokevirtual 105	android/content/res/AssetFileDescriptor:getLength	()J
    //   75: lcmp
    //   76: ifeq -62 -> 14
    //   79: aload_3
    //   80: invokestatic 109	com/qzone/utils/FileUtil:delete	(Ljava/io/File;)V
    //   83: iload 4
    //   85: ifeq +62 -> 147
    //   88: aload 8
    //   90: aload_1
    //   91: invokevirtual 113	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   94: astore 9
    //   96: aload_3
    //   97: invokevirtual 100	java/io/File:length	()J
    //   100: lstore 6
    //   102: aload 9
    //   104: invokevirtual 118	java/io/InputStream:available	()I
    //   107: istore 4
    //   109: lload 6
    //   111: iload 4
    //   113: i2l
    //   114: lcmp
    //   115: ifne +23 -> 138
    //   118: aload 9
    //   120: invokevirtual 121	java/io/InputStream:close	()V
    //   123: return
    //   124: astore_0
    //   125: aload_2
    //   126: invokestatic 123	com/qzone/utils/FileUtil:delete	(Ljava/lang/String;)V
    //   129: return
    //   130: astore 9
    //   132: iconst_1
    //   133: istore 4
    //   135: goto -52 -> 83
    //   138: aload_3
    //   139: invokestatic 109	com/qzone/utils/FileUtil:delete	(Ljava/io/File;)V
    //   142: aload 9
    //   144: invokevirtual 121	java/io/InputStream:close	()V
    //   147: aload_3
    //   148: invokevirtual 127	java/io/File:getParentFile	()Ljava/io/File;
    //   151: astore 9
    //   153: aload 9
    //   155: invokevirtual 130	java/io/File:isFile	()Z
    //   158: ifeq +8 -> 166
    //   161: aload 9
    //   163: invokestatic 109	com/qzone/utils/FileUtil:delete	(Ljava/io/File;)V
    //   166: aload 9
    //   168: invokevirtual 93	java/io/File:exists	()Z
    //   171: ifne +11 -> 182
    //   174: aload 9
    //   176: invokevirtual 133	java/io/File:mkdirs	()Z
    //   179: ifne -165 -> 14
    //   182: aload 8
    //   184: aload_1
    //   185: invokevirtual 113	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   188: astore_1
    //   189: new 135	java/io/BufferedOutputStream
    //   192: dup
    //   193: aload_0
    //   194: aload_3
    //   195: invokestatic 139	com/qzone/utils/FileUtil:getWorldReadableOutputStream	(Landroid/content/Context;Ljava/io/File;)Ljava/io/FileOutputStream;
    //   198: invokespecial 142	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   201: astore_0
    //   202: sipush 1024
    //   205: newarray byte
    //   207: astore_3
    //   208: aload_1
    //   209: aload_3
    //   210: invokevirtual 146	java/io/InputStream:read	([B)I
    //   213: istore 4
    //   215: iload 4
    //   217: ifgt +30 -> 247
    //   220: aload_1
    //   221: invokevirtual 121	java/io/InputStream:close	()V
    //   224: aload_0
    //   225: invokevirtual 149	java/io/OutputStream:close	()V
    //   228: return
    //   229: astore 10
    //   231: aload 9
    //   233: invokevirtual 121	java/io/InputStream:close	()V
    //   236: goto -89 -> 147
    //   239: astore_0
    //   240: aload 9
    //   242: invokevirtual 121	java/io/InputStream:close	()V
    //   245: aload_0
    //   246: athrow
    //   247: aload_0
    //   248: aload_3
    //   249: iconst_0
    //   250: iload 4
    //   252: invokevirtual 153	java/io/OutputStream:write	([BII)V
    //   255: goto -47 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	paramContext	Context
    //   0	258	1	paramString1	String
    //   0	258	2	paramString2	String
    //   0	258	3	paramFilePathFilter	FilePathFilter
    //   56	195	4	i	int
    //   48	3	5	bool	boolean
    //   100	10	6	l	long
    //   33	150	8	localAssetManager	AssetManager
    //   64	55	9	localObject	Object
    //   130	13	9	localIOException1	IOException
    //   151	90	9	localFile	File
    //   229	1	10	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   35	50	124	java/lang/Throwable
    //   58	83	124	java/lang/Throwable
    //   88	96	124	java/lang/Throwable
    //   118	123	124	java/lang/Throwable
    //   142	147	124	java/lang/Throwable
    //   147	166	124	java/lang/Throwable
    //   166	182	124	java/lang/Throwable
    //   182	208	124	java/lang/Throwable
    //   208	215	124	java/lang/Throwable
    //   220	228	124	java/lang/Throwable
    //   231	236	124	java/lang/Throwable
    //   240	247	124	java/lang/Throwable
    //   247	255	124	java/lang/Throwable
    //   58	83	130	java/io/IOException
    //   96	109	229	java/io/IOException
    //   138	142	229	java/io/IOException
    //   96	109	239	finally
    //   138	142	239	finally
  }
  
  private static void copyFile(String paramString1, String paramString2, FilePathFilter paramFilePathFilter)
  {
    if ((isEmpty(paramString1)) || (isEmpty(paramString2))) {}
    for (;;)
    {
      return;
      if ((paramFilePathFilter == null) || (paramFilePathFilter.accept(paramString1))) {
        try
        {
          paramFilePathFilter = new File(paramString1);
          if ((paramFilePathFilter.exists()) && (paramFilePathFilter.isFile()))
          {
            File localFile = new File(paramString2);
            if (localFile.exists())
            {
              if (paramFilePathFilter.length() != localFile.length()) {
                delete(localFile);
              }
            }
            else
            {
              paramFilePathFilter = localFile.getParentFile();
              if (paramFilePathFilter.isFile()) {
                delete(paramFilePathFilter);
              }
              if ((paramFilePathFilter.exists()) || (paramFilePathFilter.mkdirs()))
              {
                paramString1 = new FileInputStream(paramString1).getChannel();
                paramFilePathFilter = new FileOutputStream(paramString2).getChannel();
                paramFilePathFilter.transferFrom(paramString1, 0L, paramString1.size());
                paramString1.close();
                paramFilePathFilter.close();
                return;
              }
            }
          }
        }
        catch (Throwable paramString1)
        {
          delete(paramString2);
        }
      }
    }
  }
  
  /* Error */
  public static boolean copyFile(String paramString, java.io.OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +7 -> 11
    //   7: aload_1
    //   8: ifnonnull +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aconst_null
    //   14: astore 6
    //   16: aconst_null
    //   17: astore 5
    //   19: getstatic 19	com/qzone/utils/FileUtil:sBytesBufferPool	Lcom/qzone/utils/BytesBufferPool;
    //   22: invokevirtual 186	com/qzone/utils/BytesBufferPool:get	()Lcom/qzone/utils/BytesBufferPool$BytesBuffer;
    //   25: astore 7
    //   27: aload 6
    //   29: astore 4
    //   31: new 69	java/io/File
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore_0
    //   40: aload 6
    //   42: astore 4
    //   44: aload_0
    //   45: invokevirtual 93	java/io/File:exists	()Z
    //   48: ifeq +16 -> 64
    //   51: aload 6
    //   53: astore 4
    //   55: aload_0
    //   56: invokevirtual 130	java/io/File:isFile	()Z
    //   59: istore_3
    //   60: iload_3
    //   61: ifne +26 -> 87
    //   64: getstatic 19	com/qzone/utils/FileUtil:sBytesBufferPool	Lcom/qzone/utils/BytesBufferPool;
    //   67: aload 7
    //   69: invokevirtual 190	com/qzone/utils/BytesBufferPool:recycle	(Lcom/qzone/utils/BytesBufferPool$BytesBuffer;)V
    //   72: iconst_0
    //   73: ifeq -62 -> 11
    //   76: new 192	java/lang/NullPointerException
    //   79: dup
    //   80: invokespecial 193	java/lang/NullPointerException:<init>	()V
    //   83: athrow
    //   84: astore_0
    //   85: iconst_0
    //   86: ireturn
    //   87: aload 6
    //   89: astore 4
    //   91: new 157	java/io/FileInputStream
    //   94: dup
    //   95: aload_0
    //   96: invokespecial 195	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   99: astore_0
    //   100: aload_0
    //   101: aload 7
    //   103: getfield 201	com/qzone/utils/BytesBufferPool$BytesBuffer:data	[B
    //   106: iconst_0
    //   107: aload 7
    //   109: getfield 201	com/qzone/utils/BytesBufferPool$BytesBuffer:data	[B
    //   112: arraylength
    //   113: invokevirtual 204	java/io/InputStream:read	([BII)I
    //   116: istore_2
    //   117: iload_2
    //   118: ifgt +21 -> 139
    //   121: getstatic 19	com/qzone/utils/FileUtil:sBytesBufferPool	Lcom/qzone/utils/BytesBufferPool;
    //   124: aload 7
    //   126: invokevirtual 190	com/qzone/utils/BytesBufferPool:recycle	(Lcom/qzone/utils/BytesBufferPool$BytesBuffer;)V
    //   129: aload_0
    //   130: ifnull +7 -> 137
    //   133: aload_0
    //   134: invokevirtual 121	java/io/InputStream:close	()V
    //   137: iconst_1
    //   138: ireturn
    //   139: aload_1
    //   140: aload 7
    //   142: getfield 201	com/qzone/utils/BytesBufferPool$BytesBuffer:data	[B
    //   145: iconst_0
    //   146: iload_2
    //   147: invokevirtual 153	java/io/OutputStream:write	([BII)V
    //   150: goto -50 -> 100
    //   153: astore_1
    //   154: aload_0
    //   155: astore 4
    //   157: ldc 206
    //   159: ldc 208
    //   161: aload_1
    //   162: invokestatic 214	com/qzone/common/logging/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   165: getstatic 19	com/qzone/utils/FileUtil:sBytesBufferPool	Lcom/qzone/utils/BytesBufferPool;
    //   168: aload 7
    //   170: invokevirtual 190	com/qzone/utils/BytesBufferPool:recycle	(Lcom/qzone/utils/BytesBufferPool$BytesBuffer;)V
    //   173: aload_0
    //   174: ifnull -163 -> 11
    //   177: aload_0
    //   178: invokevirtual 121	java/io/InputStream:close	()V
    //   181: iconst_0
    //   182: ireturn
    //   183: astore_0
    //   184: iconst_0
    //   185: ireturn
    //   186: astore_0
    //   187: getstatic 19	com/qzone/utils/FileUtil:sBytesBufferPool	Lcom/qzone/utils/BytesBufferPool;
    //   190: aload 7
    //   192: invokevirtual 190	com/qzone/utils/BytesBufferPool:recycle	(Lcom/qzone/utils/BytesBufferPool$BytesBuffer;)V
    //   195: aload 4
    //   197: ifnull +8 -> 205
    //   200: aload 4
    //   202: invokevirtual 121	java/io/InputStream:close	()V
    //   205: aload_0
    //   206: athrow
    //   207: astore_1
    //   208: goto -3 -> 205
    //   211: astore_0
    //   212: goto -75 -> 137
    //   215: astore_1
    //   216: aload_0
    //   217: astore 4
    //   219: aload_1
    //   220: astore_0
    //   221: goto -34 -> 187
    //   224: astore_1
    //   225: aload 5
    //   227: astore_0
    //   228: goto -74 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	paramString	String
    //   0	231	1	paramOutputStream	java.io.OutputStream
    //   116	31	2	i	int
    //   59	2	3	bool	boolean
    //   29	189	4	localObject1	Object
    //   17	209	5	localObject2	Object
    //   14	74	6	localObject3	Object
    //   25	166	7	localBytesBuffer	BytesBufferPool.BytesBuffer
    // Exception table:
    //   from	to	target	type
    //   76	84	84	java/lang/Throwable
    //   100	117	153	java/lang/Throwable
    //   139	150	153	java/lang/Throwable
    //   177	181	183	java/lang/Throwable
    //   31	40	186	finally
    //   44	51	186	finally
    //   55	60	186	finally
    //   91	100	186	finally
    //   157	165	186	finally
    //   200	205	207	java/lang/Throwable
    //   133	137	211	java/lang/Throwable
    //   100	117	215	finally
    //   139	150	215	finally
    //   31	40	224	java/lang/Throwable
    //   44	51	224	java/lang/Throwable
    //   55	60	224	java/lang/Throwable
    //   91	100	224	java/lang/Throwable
  }
  
  public static void copyFiles(String paramString1, String paramString2)
  {
    copyFiles(paramString1, paramString2, null);
  }
  
  public static void copyFiles(String paramString1, String paramString2, FilePathFilter paramFilePathFilter)
  {
    if ((isEmpty(paramString1)) || (isEmpty(paramString2))) {}
    for (;;)
    {
      return;
      File localFile = new File(paramString1);
      if (localFile.exists())
      {
        if (localFile.isFile())
        {
          copyFile(paramString1, paramString2, paramFilePathFilter);
          return;
        }
        paramString1 = localFile.list();
        if (paramString1 != null)
        {
          int j = paramString1.length;
          int i = 0;
          while (i < j)
          {
            localFile = paramString1[i];
            copyFiles(localFile, paramString2 + File.separator + getPathName(localFile), paramFilePathFilter);
            i += 1;
          }
        }
      }
    }
  }
  
  public static void delete(File paramFile)
  {
    delete(paramFile, false);
  }
  
  public static void delete(File paramFile, boolean paramBoolean)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    File[] arrayOfFile;
    do
    {
      return;
      if (paramFile.isFile())
      {
        paramFile.delete();
        return;
      }
      arrayOfFile = paramFile.listFiles();
    } while (arrayOfFile == null);
    int j = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        if (paramBoolean) {
          break;
        }
        paramFile.delete();
        return;
      }
      delete(arrayOfFile[i], paramBoolean);
      i += 1;
    }
  }
  
  public static void delete(String paramString)
  {
    delete(paramString, false);
  }
  
  public static void delete(String paramString, boolean paramBoolean)
  {
    if (isEmpty(paramString)) {
      return;
    }
    delete(new File(paramString), paramBoolean);
  }
  
  private static String getPathName(String paramString)
  {
    String str;
    if (isEmpty(paramString)) {
      str = "";
    }
    int i;
    do
    {
      return str;
      i = paramString.lastIndexOf(File.separator);
      str = paramString;
    } while (i < 0);
    return paramString.substring(i + 1, paramString.length());
  }
  
  private static FileOutputStream getWorldReadableOutputStream(Context paramContext, File paramFile)
    throws FileNotFoundException
  {
    if (paramFile == null) {
      return null;
    }
    Object localObject = paramContext.getFilesDir();
    if ((localObject != null) && (((File)localObject).equals(paramFile.getParentFile())))
    {
      localObject = paramFile.getName();
      try
      {
        paramContext = paramContext.openFileOutput((String)localObject, 1);
        return paramContext;
      }
      catch (FileNotFoundException paramContext)
      {
        QDLog.e(null, null, paramContext);
      }
    }
    return new FileOutputStream(paramFile);
  }
  
  private static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static abstract interface FilePathFilter
  {
    public abstract boolean accept(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.utils.FileUtil
 * JD-Core Version:    0.7.0.1
 */