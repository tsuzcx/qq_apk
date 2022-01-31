package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;

public class FileUtil
{
  private static final String APK_ASSETS = "assets/";
  private static final String APK_LIB = "lib/";
  private static final int APK_LIB_LEN = "lib/".length();
  private static final int DEFAULT_BUFFER_SIZE = 4096;
  public static final int ENU_NEW_TBS_BACKUP_PATH = 2;
  public static final int ENU_OLD_TBS_BACKUP_PATH = 1;
  public static final int ENU_TBS_LOCALINSTALL = 3;
  private static final String LIB_SUFFIX = ".so";
  public static final FileComparator SIMPLE_COMPARATOR = new FileComparator()
  {
    public boolean equals(File paramAnonymousFile1, File paramAnonymousFile2)
    {
      return (paramAnonymousFile1.length() == paramAnonymousFile2.length()) && (paramAnonymousFile1.lastModified() == paramAnonymousFile2.lastModified());
    }
  };
  private static final String TAG = "FileHelper";
  public static final String TBSLOG_PATH = getTbsLogPath();
  public static final String TBS_CORE_PRIVATE = "core_private";
  public static final String TBS_FILE_CORE_SHARE = "core_share";
  public static final String TBS_FILE_SHARE = "share";
  private static final String TBS_SDCARD_DIR = "tbs";
  private static final String TBS_SDCARD_SHARE_DIR = ".tbs";
  public static final int ZIP_BUFFER_SIZE = 4096;
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable)
    {
      paramCloseable.printStackTrace();
    }
  }
  
  public static int copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException, OutOfMemoryError
  {
    long l = copyLarge(paramInputStream, paramOutputStream);
    if (l > 2147483647L) {
      return -1;
    }
    return (int)l;
  }
  
  /* Error */
  private static boolean copyFileIfChanged(InputStream paramInputStream, ZipEntry paramZipEntry, String paramString1, String paramString2)
    throws Exception
  {
    // Byte code:
    //   0: new 111	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokestatic 118	com/tencent/smtt/utils/FileUtil:ensureDirectory	(Ljava/io/File;)Z
    //   11: pop
    //   12: new 120	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   19: aload_2
    //   20: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: getstatic 128	java/io/File:separator	Ljava/lang/String;
    //   26: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_3
    //   30: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore 7
    //   38: new 111	java/io/File
    //   41: dup
    //   42: aload 7
    //   44: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore 6
    //   49: aconst_null
    //   50: astore_2
    //   51: aconst_null
    //   52: astore 5
    //   54: new 133	java/io/FileOutputStream
    //   57: dup
    //   58: aload 6
    //   60: invokespecial 136	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   63: astore_3
    //   64: sipush 8192
    //   67: newarray byte
    //   69: astore_2
    //   70: aload_0
    //   71: aload_2
    //   72: invokevirtual 142	java/io/InputStream:read	([B)I
    //   75: istore 4
    //   77: iload 4
    //   79: ifle +66 -> 145
    //   82: aload_3
    //   83: aload_2
    //   84: iconst_0
    //   85: iload 4
    //   87: invokevirtual 146	java/io/FileOutputStream:write	([BII)V
    //   90: goto -20 -> 70
    //   93: astore_1
    //   94: aload_3
    //   95: astore_0
    //   96: aload_0
    //   97: astore_2
    //   98: aload 6
    //   100: invokestatic 149	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   103: aload_0
    //   104: astore_2
    //   105: new 101	java/io/IOException
    //   108: dup
    //   109: new 120	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   116: ldc 151
    //   118: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload 6
    //   123: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: aload_1
    //   130: invokespecial 157	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   133: athrow
    //   134: astore_0
    //   135: aload_2
    //   136: ifnull +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   143: aload_0
    //   144: athrow
    //   145: aload_3
    //   146: ifnull +7 -> 153
    //   149: aload_3
    //   150: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   153: aload 7
    //   155: aload_1
    //   156: invokevirtual 164	java/util/zip/ZipEntry:getSize	()J
    //   159: aload_1
    //   160: invokevirtual 167	java/util/zip/ZipEntry:getTime	()J
    //   163: aload_1
    //   164: invokevirtual 170	java/util/zip/ZipEntry:getCrc	()J
    //   167: invokestatic 174	com/tencent/smtt/utils/FileUtil:isFileDifferent	(Ljava/lang/String;JJJ)Z
    //   170: ifeq +30 -> 200
    //   173: ldc 39
    //   175: new 120	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   182: ldc 176
    //   184: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload 7
    //   189: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 182	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: iconst_0
    //   199: ireturn
    //   200: aload 6
    //   202: aload_1
    //   203: invokevirtual 167	java/util/zip/ZipEntry:getTime	()J
    //   206: invokevirtual 186	java/io/File:setLastModified	(J)Z
    //   209: ifne +28 -> 237
    //   212: ldc 39
    //   214: new 120	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   221: ldc 188
    //   223: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload 6
    //   228: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 182	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: iconst_1
    //   238: ireturn
    //   239: astore_0
    //   240: aload_3
    //   241: astore_2
    //   242: goto -107 -> 135
    //   245: astore_1
    //   246: aload 5
    //   248: astore_0
    //   249: goto -153 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	paramInputStream	InputStream
    //   0	252	1	paramZipEntry	ZipEntry
    //   0	252	2	paramString1	String
    //   0	252	3	paramString2	String
    //   75	11	4	i	int
    //   52	195	5	localObject	Object
    //   47	180	6	localFile	File
    //   36	152	7	str	String
    // Exception table:
    //   from	to	target	type
    //   64	70	93	java/io/IOException
    //   70	77	93	java/io/IOException
    //   82	90	93	java/io/IOException
    //   54	64	134	finally
    //   98	103	134	finally
    //   105	134	134	finally
    //   64	70	239	finally
    //   70	77	239	finally
    //   82	90	239	finally
    //   54	64	245	java/io/IOException
  }
  
  public static boolean copyFiles(File paramFile1, File paramFile2)
    throws Exception
  {
    return copyFiles(paramFile1, paramFile2, null);
  }
  
  public static boolean copyFiles(File paramFile1, File paramFile2, FileFilter paramFileFilter)
    throws Exception
  {
    return copyFiles(paramFile1, paramFile2, paramFileFilter, SIMPLE_COMPARATOR);
  }
  
  public static boolean copyFiles(File paramFile1, File paramFile2, FileFilter paramFileFilter, FileComparator paramFileComparator)
    throws Exception
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramFile1 != null)
    {
      if (paramFile2 != null) {
        break label22;
      }
      bool2 = bool1;
    }
    label22:
    do
    {
      do
      {
        return bool2;
        bool2 = bool1;
      } while (!paramFile1.exists());
      if (paramFile1.isFile()) {
        return performCopyFile(paramFile1, paramFile2, paramFileFilter, paramFileComparator);
      }
      paramFile1 = paramFile1.listFiles();
      bool2 = bool1;
    } while (paramFile1 == null);
    bool1 = true;
    int j = paramFile1.length;
    int i = 0;
    for (;;)
    {
      bool2 = bool1;
      if (i >= j) {
        break;
      }
      paramFileComparator = paramFile1[i];
      if (!copyFiles(paramFileComparator, new File(paramFile2, paramFileComparator.getName()), paramFileFilter)) {
        bool1 = false;
      }
      i += 1;
    }
  }
  
  public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException, OutOfMemoryError
  {
    long l2;
    if (paramInputStream == null)
    {
      l2 = -1L;
      return l2;
    }
    byte[] arrayOfByte = new byte[4096];
    int i;
    for (long l1 = 0L;; l1 += i)
    {
      i = paramInputStream.read(arrayOfByte);
      l2 = l1;
      if (-1 == i) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static boolean copyTbsFilesIfNeeded(File paramFile1, File paramFile2)
    throws Exception
  {
    return copyTbsFilesIfNeeded(paramFile1.getPath(), paramFile2.getPath());
  }
  
  @SuppressLint({"InlinedApi"})
  public static boolean copyTbsFilesIfNeeded(String paramString1, String paramString2)
    throws Exception
  {
    String str2 = Build.CPU_ABI;
    if (Build.VERSION.SDK_INT >= 8) {}
    for (String str1 = Build.CPU_ABI2;; str1 = null) {
      return copyTbsFilesIfNeeded(paramString1, paramString2, str2, str1, PropertyUtils.getQuickly("ro.product.cpu.upgradeabi", "armeabi"));
    }
  }
  
  private static boolean copyTbsFilesIfNeeded(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws Exception
  {
    iterateOverTbsFiles(paramString1, paramString3, paramString4, paramString5, new IterateHandler()
    {
      public boolean handleEntry(InputStream paramAnonymousInputStream, ZipEntry paramAnonymousZipEntry, String paramAnonymousString)
        throws Exception
      {
        try
        {
          boolean bool = FileUtil.copyFileIfChanged(paramAnonymousInputStream, paramAnonymousZipEntry, this.val$dstDir, paramAnonymousString);
          return bool;
        }
        catch (Exception paramAnonymousInputStream)
        {
          throw new Exception("copyFileIfChanged Exception", paramAnonymousInputStream);
        }
      }
    });
  }
  
  public static void delete(File paramFile)
  {
    delete(paramFile, false);
  }
  
  public static void delete(File paramFile, boolean paramBoolean)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    do
    {
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
      while (i < j)
      {
        delete(arrayOfFile[i], paramBoolean);
        i += 1;
      }
    } while (paramBoolean);
    paramFile.delete();
  }
  
  public static boolean ensureDirectory(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    if ((paramFile.exists()) && (paramFile.isDirectory())) {
      return true;
    }
    delete(paramFile);
    return paramFile.mkdirs();
  }
  
  public static long getFreeSpace(String paramString)
  {
    try
    {
      StatFs localStatFs = new StatFs(paramString);
      localStatFs.restat(paramString);
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      return l * i;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  public static File getSDcardDir()
  {
    try
    {
      File localFile = Environment.getExternalStorageDirectory();
      return localFile;
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
    }
    return null;
  }
  
  public static String getTBSSdcardFilePath(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return "";
    }
    switch (paramInt)
    {
    default: 
      return "";
    }
    try
    {
      return Environment.getExternalStorageDirectory() + File.separator + "tencent" + File.separator + "tbs" + File.separator + paramContext.getApplicationInfo().packageName;
    }
    catch (SecurityException paramContext)
    {
      paramContext.printStackTrace();
    }
    return Environment.getExternalStorageDirectory() + File.separator + "tbs" + File.separator + "backup" + File.separator + paramContext.getApplicationInfo().packageName;
    paramContext = Environment.getExternalStorageDirectory() + File.separator + "tbs" + File.separator + paramContext.getApplicationInfo().packageName;
    return paramContext;
    return "";
  }
  
  private static String getTbsLogPath()
  {
    try
    {
      String str = Environment.getExternalStorageDirectory() + File.separator + "tbs" + File.separator + "tbslog";
      return str;
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
    }
    return "";
  }
  
  public static File getTbsSdcardShareDir()
  {
    File localFile = new File(getSDcardDir().getAbsolutePath() + "/" + ".tbs");
    if ((localFile != null) && (!localFile.exists())) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public static boolean hasSDcard()
  {
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      return bool;
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
    }
    return false;
  }
  
  private static boolean isFileDifferent(String paramString, long paramLong1, long paramLong2, long paramLong3)
    throws Exception
  {
    File localFile = new File(paramString);
    if (localFile.length() != paramLong1) {
      TbsLog.e("FileHelper", "file size doesn't match: " + localFile.length() + " vs " + paramLong1);
    }
    label126:
    do
    {
      return true;
      CRC32 localCRC32 = null;
      try
      {
        paramString = new FileInputStream(localFile);
        try
        {
          localCRC32 = new CRC32();
          byte[] arrayOfByte = new byte[8192];
          for (;;)
          {
            int i = paramString.read(arrayOfByte);
            if (i <= 0) {
              break;
            }
            localCRC32.update(arrayOfByte, 0, i);
          }
          if (paramString == null) {
            break label126;
          }
        }
        finally {}
      }
      finally
      {
        for (;;)
        {
          paramString = localObject1;
          Object localObject2 = localObject3;
        }
      }
      paramString.close();
      throw localObject1;
      paramLong1 = localObject1.getValue();
      TbsLog.i("FileHelper", "" + localFile.getName() + ": crc = " + paramLong1 + ", zipCrc = " + paramLong3);
      if (paramLong1 == paramLong3) {
        break;
      }
    } while (paramString == null);
    paramString.close();
    return true;
    if (paramString != null) {
      paramString.close();
    }
    return false;
  }
  
  public static boolean isFileValid(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists()) && (paramFile.isFile()) && (paramFile.length() > 0L);
  }
  
  /* Error */
  private static boolean iterateOverTbsFiles(String paramString1, String paramString2, String paramString3, String paramString4, IterateHandler paramIterateHandler)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: new 370	java/util/zip/ZipFile
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 371	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: iconst_0
    //   13: istore 6
    //   15: iconst_0
    //   16: istore 5
    //   18: aload_0
    //   19: invokevirtual 375	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   22: astore 10
    //   24: aload 10
    //   26: invokeinterface 380 1 0
    //   31: ifeq +314 -> 345
    //   34: aload 10
    //   36: invokeinterface 384 1 0
    //   41: checkcast 160	java/util/zip/ZipEntry
    //   44: astore 11
    //   46: aload 11
    //   48: invokevirtual 385	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   51: astore 13
    //   53: aload 13
    //   55: ifnull -31 -> 24
    //   58: aload 13
    //   60: ldc 21
    //   62: invokevirtual 389	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   65: ifne +13 -> 78
    //   68: aload 13
    //   70: ldc 18
    //   72: invokevirtual 389	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   75: ifeq -51 -> 24
    //   78: aload 13
    //   80: aload 13
    //   82: bipush 47
    //   84: invokevirtual 393	java/lang/String:lastIndexOf	(I)I
    //   87: invokevirtual 397	java/lang/String:substring	(I)Ljava/lang/String;
    //   90: astore 12
    //   92: iload 6
    //   94: istore 7
    //   96: iload 5
    //   98: istore 8
    //   100: aload 12
    //   102: ldc 34
    //   104: invokevirtual 400	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   107: ifeq +45 -> 152
    //   110: aload 13
    //   112: getstatic 66	com/tencent/smtt/utils/FileUtil:APK_LIB_LEN	I
    //   115: aload_1
    //   116: iconst_0
    //   117: aload_1
    //   118: invokevirtual 64	java/lang/String:length	()I
    //   121: invokevirtual 404	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   124: ifeq +80 -> 204
    //   127: aload 13
    //   129: getstatic 66	com/tencent/smtt/utils/FileUtil:APK_LIB_LEN	I
    //   132: aload_1
    //   133: invokevirtual 64	java/lang/String:length	()I
    //   136: iadd
    //   137: invokevirtual 408	java/lang/String:charAt	(I)C
    //   140: bipush 47
    //   142: if_icmpne +62 -> 204
    //   145: iconst_1
    //   146: istore 7
    //   148: iload 5
    //   150: istore 8
    //   152: aload_0
    //   153: aload 11
    //   155: invokevirtual 412	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   158: astore 13
    //   160: aload 4
    //   162: aload 13
    //   164: aload 11
    //   166: aload 12
    //   168: iconst_1
    //   169: invokevirtual 397	java/lang/String:substring	(I)Ljava/lang/String;
    //   172: invokeinterface 416 4 0
    //   177: istore 9
    //   179: iload 9
    //   181: ifne +174 -> 355
    //   184: aload 13
    //   186: ifnull +8 -> 194
    //   189: aload 13
    //   191: invokevirtual 417	java/io/InputStream:close	()V
    //   194: aload_0
    //   195: ifnull +7 -> 202
    //   198: aload_0
    //   199: invokevirtual 418	java/util/zip/ZipFile:close	()V
    //   202: iconst_0
    //   203: ireturn
    //   204: aload_2
    //   205: ifnull +56 -> 261
    //   208: aload 13
    //   210: getstatic 66	com/tencent/smtt/utils/FileUtil:APK_LIB_LEN	I
    //   213: aload_2
    //   214: iconst_0
    //   215: aload_2
    //   216: invokevirtual 64	java/lang/String:length	()I
    //   219: invokevirtual 404	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   222: ifeq +39 -> 261
    //   225: aload 13
    //   227: getstatic 66	com/tencent/smtt/utils/FileUtil:APK_LIB_LEN	I
    //   230: aload_2
    //   231: invokevirtual 64	java/lang/String:length	()I
    //   234: iadd
    //   235: invokevirtual 408	java/lang/String:charAt	(I)C
    //   238: bipush 47
    //   240: if_icmpne +21 -> 261
    //   243: iconst_1
    //   244: istore 8
    //   246: iconst_1
    //   247: istore 5
    //   249: iload 6
    //   251: istore 7
    //   253: iload 6
    //   255: ifeq -103 -> 152
    //   258: goto -234 -> 24
    //   261: aload_3
    //   262: ifnull -238 -> 24
    //   265: aload 13
    //   267: getstatic 66	com/tencent/smtt/utils/FileUtil:APK_LIB_LEN	I
    //   270: aload_3
    //   271: iconst_0
    //   272: aload_3
    //   273: invokevirtual 64	java/lang/String:length	()I
    //   276: invokevirtual 404	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   279: ifeq -255 -> 24
    //   282: aload 13
    //   284: getstatic 66	com/tencent/smtt/utils/FileUtil:APK_LIB_LEN	I
    //   287: aload_3
    //   288: invokevirtual 64	java/lang/String:length	()I
    //   291: iadd
    //   292: invokevirtual 408	java/lang/String:charAt	(I)C
    //   295: bipush 47
    //   297: if_icmpne -273 -> 24
    //   300: iload 6
    //   302: ifne -278 -> 24
    //   305: iload 6
    //   307: istore 7
    //   309: iload 5
    //   311: istore 8
    //   313: iload 5
    //   315: ifeq -163 -> 152
    //   318: goto -294 -> 24
    //   321: astore_1
    //   322: aload 13
    //   324: ifnull +8 -> 332
    //   327: aload 13
    //   329: invokevirtual 417	java/io/InputStream:close	()V
    //   332: aload_1
    //   333: athrow
    //   334: astore_1
    //   335: aload_0
    //   336: ifnull +7 -> 343
    //   339: aload_0
    //   340: invokevirtual 418	java/util/zip/ZipFile:close	()V
    //   343: aload_1
    //   344: athrow
    //   345: aload_0
    //   346: ifnull +7 -> 353
    //   349: aload_0
    //   350: invokevirtual 418	java/util/zip/ZipFile:close	()V
    //   353: iconst_1
    //   354: ireturn
    //   355: iload 7
    //   357: istore 6
    //   359: iload 8
    //   361: istore 5
    //   363: aload 13
    //   365: ifnull -341 -> 24
    //   368: aload 13
    //   370: invokevirtual 417	java/io/InputStream:close	()V
    //   373: iload 7
    //   375: istore 6
    //   377: iload 8
    //   379: istore 5
    //   381: goto -357 -> 24
    //   384: astore_1
    //   385: aload 10
    //   387: astore_0
    //   388: goto -53 -> 335
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	paramString1	String
    //   0	391	1	paramString2	String
    //   0	391	2	paramString3	String
    //   0	391	3	paramString4	String
    //   0	391	4	paramIterateHandler	IterateHandler
    //   16	364	5	i	int
    //   13	363	6	j	int
    //   94	280	7	k	int
    //   98	280	8	m	int
    //   177	3	9	bool	boolean
    //   1	385	10	localEnumeration	java.util.Enumeration
    //   44	121	11	localZipEntry	ZipEntry
    //   90	77	12	str	String
    //   51	318	13	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   160	179	321	finally
    //   18	24	334	finally
    //   24	53	334	finally
    //   58	78	334	finally
    //   78	92	334	finally
    //   100	145	334	finally
    //   152	160	334	finally
    //   189	194	334	finally
    //   208	243	334	finally
    //   265	300	334	finally
    //   327	332	334	finally
    //   332	334	334	finally
    //   368	373	334	finally
    //   3	12	384	finally
  }
  
  public static FileInputStream openInputStream(File paramFile)
    throws IOException
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        throw new IOException("File '" + paramFile + "' exists but is a directory");
      }
      if (!paramFile.canRead()) {
        throw new IOException("File '" + paramFile + "' cannot be read");
      }
    }
    else
    {
      throw new FileNotFoundException("File '" + paramFile + "' does not exist");
    }
    return new FileInputStream(paramFile);
  }
  
  public static FileOutputStream openOutputStream(File paramFile)
    throws IOException
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        throw new IOException("File '" + paramFile + "' exists but is a directory");
      }
      if (!paramFile.canWrite()) {
        throw new IOException("File '" + paramFile + "' cannot be written to");
      }
    }
    else
    {
      File localFile = paramFile.getParentFile();
      if ((localFile != null) && (!localFile.exists()) && (!localFile.mkdirs())) {
        throw new IOException("File '" + paramFile + "' could not be created");
      }
    }
    return new FileOutputStream(paramFile);
  }
  
  private static boolean performCopyFile(File paramFile1, File paramFile2, FileFilter paramFileFilter, FileComparator paramFileComparator)
    throws Exception
  {
    if ((paramFile1 == null) || (paramFile2 == null)) {
      return false;
    }
    if ((paramFileFilter != null) && (!paramFileFilter.accept(paramFile1))) {
      return false;
    }
    Object localObject3 = null;
    Object localObject2 = null;
    paramFileFilter = localObject2;
    Object localObject1 = localObject3;
    try
    {
      boolean bool;
      if (paramFile1.exists())
      {
        paramFileFilter = localObject2;
        localObject1 = localObject3;
        bool = paramFile1.isFile();
        if (bool) {}
      }
      else
      {
        if (0 != 0) {
          throw new NullPointerException();
        }
        if (0 != 0) {
          throw new NullPointerException();
        }
        return false;
      }
      paramFileFilter = localObject2;
      localObject1 = localObject3;
      if (paramFile2.exists())
      {
        if (paramFileComparator != null)
        {
          paramFileFilter = localObject2;
          localObject1 = localObject3;
          bool = paramFileComparator.equals(paramFile1, paramFile2);
          if (bool)
          {
            if (0 != 0) {
              throw new NullPointerException();
            }
            if (0 != 0) {
              throw new NullPointerException();
            }
            return true;
          }
        }
        paramFileFilter = localObject2;
        localObject1 = localObject3;
        delete(paramFile2);
      }
      paramFileFilter = localObject2;
      localObject1 = localObject3;
      paramFileComparator = paramFile2.getParentFile();
      paramFileFilter = localObject2;
      localObject1 = localObject3;
      if (paramFileComparator.isFile())
      {
        paramFileFilter = localObject2;
        localObject1 = localObject3;
        delete(paramFileComparator);
      }
      paramFileFilter = localObject2;
      localObject1 = localObject3;
      if (!paramFileComparator.exists())
      {
        paramFileFilter = localObject2;
        localObject1 = localObject3;
        bool = paramFileComparator.mkdirs();
        if (!bool)
        {
          if (0 != 0) {
            throw new NullPointerException();
          }
          if (0 != 0) {
            throw new NullPointerException();
          }
          return false;
        }
      }
      paramFileFilter = localObject2;
      localObject1 = localObject3;
      paramFile1 = new FileInputStream(paramFile1).getChannel();
      paramFileFilter = localObject2;
      localObject1 = paramFile1;
      paramFileComparator = new FileOutputStream(paramFile2).getChannel();
      paramFileFilter = paramFileComparator;
      localObject1 = paramFile1;
      long l = paramFile1.size();
      paramFileFilter = paramFileComparator;
      localObject1 = paramFile1;
      if (paramFileComparator.transferFrom(paramFile1, 0L, l) != l)
      {
        paramFileFilter = paramFileComparator;
        localObject1 = paramFile1;
        delete(paramFile2);
        if (paramFile1 != null) {
          paramFile1.close();
        }
        if (paramFileComparator != null) {
          paramFileComparator.close();
        }
        return false;
      }
    }
    finally
    {
      if (localObject1 != null) {
        ((FileChannel)localObject1).close();
      }
      if (paramFileFilter != null) {
        paramFileFilter.close();
      }
    }
    if (paramFile1 != null) {
      paramFile1.close();
    }
    if (paramFileComparator != null) {
      paramFileComparator.close();
    }
    return true;
  }
  
  public static byte[] read(File paramFile)
    throws OutOfMemoryError
  {
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject2;
    if (paramFile == null) {
      localObject2 = localObject4;
    }
    for (;;)
    {
      return localObject2;
      File localFile = null;
      localObject2 = null;
      Object localObject1 = null;
      try
      {
        paramFile = openInputStream(paramFile);
        localObject1 = paramFile;
        localFile = paramFile;
        localObject2 = paramFile;
        byte[] arrayOfByte = toByteArrayOutputStream(paramFile).toByteArray();
        localObject1 = arrayOfByte;
        localObject2 = localObject1;
        if (paramFile == null) {
          continue;
        }
        closeQuietly(paramFile);
        return localObject1;
      }
      catch (Exception paramFile)
      {
        for (;;)
        {
          localObject2 = localObject1;
          paramFile.printStackTrace();
          localObject2 = localObject4;
          if (localObject1 == null) {
            break;
          }
          paramFile = (File)localObject1;
          localObject1 = localObject3;
        }
      }
      catch (OutOfMemoryError paramFile)
      {
        localObject2 = localFile;
        paramFile.printStackTrace();
        localObject2 = localFile;
        throw paramFile;
      }
      finally
      {
        if (localObject2 != null) {
          closeQuietly((Closeable)localObject2);
        }
      }
    }
  }
  
  public static boolean removeTbsFiles(File paramFile)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (paramFile.exists())
    {
      paramFile = paramFile.listFiles();
      bool2 = bool3;
      if (paramFile != null)
      {
        int i = 0;
        bool2 = bool1;
        if (i < paramFile.length)
        {
          if (!paramFile[i].delete()) {
            TbsLog.w("FileHelper", "Could not delete native binary: " + paramFile[i].getPath());
          }
          for (;;)
          {
            i += 1;
            break;
            bool1 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  public static boolean removeTbsFiles(String paramString)
  {
    return removeTbsFiles(new File(paramString));
  }
  
  public static byte[] toByteArray(InputStream paramInputStream)
    throws IOException, OutOfMemoryError
  {
    return toByteArrayOutputStream(paramInputStream).toByteArray();
  }
  
  public static ByteArrayOutputStream toByteArrayOutputStream(InputStream paramInputStream)
    throws IOException, OutOfMemoryError
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream;
  }
  
  public static abstract interface FileComparator
  {
    public abstract boolean equals(File paramFile1, File paramFile2);
  }
  
  public static abstract interface IterateHandler
  {
    public abstract boolean handleEntry(InputStream paramInputStream, ZipEntry paramZipEntry, String paramString)
      throws Exception;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.FileUtil
 * JD-Core Version:    0.7.0.1
 */