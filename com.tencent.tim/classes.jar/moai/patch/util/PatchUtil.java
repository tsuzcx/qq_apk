package moai.patch.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.Adler32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import moai.patch.log.PatchLog;

public class PatchUtil
{
  private static SimpleDateFormat NOW_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
  
  public static long adler32(File paramFile)
  {
    Adler32 localAdler32 = new Adler32();
    try
    {
      paramFile = new BufferedInputStream(new FileInputStream(paramFile));
      byte[] arrayOfByte = new byte[16384];
      for (;;)
      {
        int i = paramFile.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localAdler32.update(arrayOfByte, 0, i);
      }
      paramFile.close();
      return localAdler32.getValue();
    }
    catch (Exception paramFile) {}
    return -1L;
  }
  
  private static void cleanDirectory(File paramFile)
    throws IOException
  {
    if (!paramFile.exists()) {
      throw new IllegalArgumentException(paramFile + " does not exist");
    }
    if (!paramFile.isDirectory()) {
      throw new IllegalArgumentException(paramFile + " is not a directory");
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null) {
      throw new IOException("Failed to list contents of " + paramFile);
    }
    int j = arrayOfFile.length;
    paramFile = null;
    int i = 0;
    for (;;)
    {
      File localFile;
      if (i < j) {
        localFile = arrayOfFile[i];
      }
      try
      {
        forceDelete(localFile);
        label126:
        i += 1;
        continue;
        if (paramFile != null) {
          throw paramFile;
        }
      }
      catch (IOException paramFile)
      {
        break label126;
      }
    }
  }
  
  public static void deleteDirectory(File paramFile)
    throws IOException
  {
    if (!paramFile.exists()) {}
    do
    {
      return;
      cleanDirectory(paramFile);
    } while (paramFile.delete());
    throw new IOException("Unable to delete directory " + paramFile + ".");
  }
  
  public static void forceDelete(File paramFile)
    throws IOException
  {
    if (paramFile.isDirectory()) {
      deleteDirectory(paramFile);
    }
    boolean bool;
    do
    {
      return;
      bool = paramFile.exists();
    } while (paramFile.delete());
    if (!bool) {
      throw new FileNotFoundException("File does not exist: " + paramFile);
    }
    throw new IOException("Unable to delete file: " + paramFile);
  }
  
  public static ZipEntry forceGetEntry(ZipFile paramZipFile, String paramString)
    throws IOException
  {
    paramZipFile = paramZipFile.getEntry(paramString);
    if (paramZipFile == null)
    {
      PatchLog.e(1021, "zipfile has no entry:" + paramString);
      throw new IOException("zipfile has no entry:" + paramString);
    }
    return paramZipFile;
  }
  
  public static void forceMkdir(File paramFile)
    throws IOException
  {
    if (paramFile.exists())
    {
      if (!paramFile.isDirectory()) {
        throw new IOException("File " + paramFile + " exists and is not a directory. Unable to create directory.");
      }
    }
    else if ((!paramFile.mkdirs()) && (!paramFile.isDirectory())) {
      throw new IOException("Unable to create directory " + paramFile);
    }
  }
  
  public static void forceRename(File paramFile1, File paramFile2)
    throws IOException
  {
    if (!paramFile1.renameTo(paramFile2)) {
      throw new IOException("rename " + paramFile1.getAbsolutePath() + " to " + paramFile2.getAbsolutePath() + " fail!");
    }
  }
  
  public static long getAvailableInternalMemorySize()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getAvailableBlocks() * l;
  }
  
  public static long getDirSize(File paramFile)
  {
    long l1 = 0L;
    if (paramFile.exists())
    {
      long l2;
      if (paramFile.isDirectory())
      {
        paramFile = paramFile.listFiles();
        l2 = l1;
        if (paramFile != null)
        {
          int j = paramFile.length;
          int i = 0;
          for (;;)
          {
            l2 = l1;
            if (i >= j) {
              break;
            }
            l2 = getDirSize(paramFile[i]);
            i += 1;
            l1 = l2 + l1;
          }
        }
      }
      else
      {
        l2 = paramFile.length();
      }
      return l2;
    }
    throw new RuntimeException("dir not exist:" + paramFile.getAbsolutePath());
  }
  
  private static boolean isApplicationActive(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return isApplicationActive_v21(paramContext);
    }
    return isApplicationActive_v20(paramContext);
  }
  
  private static boolean isApplicationActive_v20(Context paramContext)
  {
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity.getPackageName();
      return paramContext.getPackageName().equals(localObject);
    }
    return false;
  }
  
  private static boolean isApplicationActive_v21(Context paramContext)
  {
    try
    {
      Field localField1 = ActivityManager.class.getDeclaredField("PROCESS_STATE_TOP");
      localField1.setAccessible(true);
      Field localField2 = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
      localField2.setAccessible(true);
      Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if ((paramContext.getPackageName().equals(localRunningAppProcessInfo.processName)) && (localRunningAppProcessInfo.importance == 100) && (localRunningAppProcessInfo.importanceReasonCode == 0))
        {
          int i = localField2.getInt(localRunningAppProcessInfo);
          int j = localField1.getInt(null);
          return i == j;
        }
      }
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean isBackground(Context paramContext)
  {
    return !isApplicationActive(paramContext);
  }
  
  public static boolean isNotEmpty(String paramString)
  {
    return (paramString != null) && (!paramString.equals(""));
  }
  
  /* Error */
  public static String md5(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: aload_2
    //   7: areturn
    //   8: aload_0
    //   9: invokevirtual 314	java/io/File:isFile	()Z
    //   12: ifeq -6 -> 6
    //   15: ldc_w 309
    //   18: astore_2
    //   19: aload_0
    //   20: invokevirtual 70	java/io/File:exists	()Z
    //   23: ifeq -17 -> 6
    //   26: ldc_w 316
    //   29: invokestatic 322	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   32: astore_2
    //   33: new 36	java/io/BufferedInputStream
    //   36: dup
    //   37: new 38	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 41	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: invokespecial 44	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: astore_0
    //   49: sipush 16384
    //   52: newarray byte
    //   54: astore_3
    //   55: aload_0
    //   56: aload_3
    //   57: invokevirtual 325	java/io/InputStream:read	([B)I
    //   60: istore_1
    //   61: iload_1
    //   62: iconst_m1
    //   63: if_icmpeq +25 -> 88
    //   66: aload_2
    //   67: aload_3
    //   68: iconst_0
    //   69: iload_1
    //   70: invokevirtual 326	java/security/MessageDigest:update	([BII)V
    //   73: goto -18 -> 55
    //   76: astore_2
    //   77: aload_0
    //   78: invokevirtual 327	java/io/InputStream:close	()V
    //   81: aload_2
    //   82: athrow
    //   83: astore_0
    //   84: ldc_w 309
    //   87: areturn
    //   88: aload_0
    //   89: invokevirtual 327	java/io/InputStream:close	()V
    //   92: aload_2
    //   93: invokevirtual 331	java/security/MessageDigest:digest	()[B
    //   96: invokestatic 335	moai/patch/util/PatchUtil:toHexString	([B)Ljava/lang/String;
    //   99: astore_0
    //   100: aload_0
    //   101: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramFile	File
    //   60	10	1	i	int
    //   1	66	2	localObject1	Object
    //   76	17	2	localObject2	Object
    //   54	14	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   55	61	76	finally
    //   66	73	76	finally
    //   26	55	83	java/lang/Exception
    //   77	83	83	java/lang/Exception
    //   88	100	83	java/lang/Exception
  }
  
  public static String now()
  {
    return NOW_TIME_FORMAT.format(new Date(System.currentTimeMillis()));
  }
  
  public static <T> T[] toArray(List<T> paramList)
  {
    if (paramList == null) {
      return null;
    }
    Object[] arrayOfObject = new Object[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfObject[i] = paramList.get(i);
      i += 1;
    }
    return (Object[])arrayOfObject;
  }
  
  private static String toHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfByte.length;
    int i = 0;
    if (i < j)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuilder.append("0").append(str);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(str);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static boolean unzip(String paramString1, String paramString2)
    throws IOException
  {
    Object localObject1 = new File(paramString1);
    if (!((File)localObject1).exists()) {
      throw new IllegalArgumentException("file " + paramString1 + " not exist");
    }
    localObject3 = new File(paramString2);
    if (((File)localObject3).isFile()) {
      throw new IllegalArgumentException("dest is file:" + paramString2);
    }
    for (;;)
    {
      Object localObject4;
      try
      {
        if (!((File)localObject3).exists()) {
          forceMkdir((File)localObject3);
        }
        localObject1 = new ZipInputStream(new BufferedInputStream(new FileInputStream((File)localObject1)));
        localObject3 = ((ZipInputStream)localObject1).getNextEntry();
        if (localObject3 == null) {
          break label362;
        }
        localObject4 = ((ZipEntry)localObject3).getName();
        if (((String)localObject4).contains("../"))
        {
          PatchLog.w(1031, "name:" + (String)localObject4);
          continue;
        }
        localObject4 = new File(paramString2 + File.separator + (String)localObject4);
      }
      catch (Exception localException1)
      {
        PatchLog.e(9000, "extract fail:" + paramString1 + ",dest:" + paramString2);
        return false;
      }
      if (((ZipEntry)localObject3).isDirectory())
      {
        forceMkdir((File)localObject4);
        continue;
      }
      forceMkdir(((File)localObject4).getParentFile());
      localObject3 = new BufferedOutputStream(new FileOutputStream((File)localObject4));
      try
      {
        localObject4 = new byte[8192];
        for (;;)
        {
          int i = localException1.read((byte[])localObject4, 0, 8192);
          if (i == -1) {
            break;
          }
          ((BufferedOutputStream)localObject3).write((byte[])localObject4, 0, i);
        }
        try
        {
          ((BufferedOutputStream)localObject3).close();
          throw localObject2;
          try
          {
            ((BufferedOutputStream)localObject3).close();
          }
          catch (Exception localException2) {}
          continue;
          localObject2.close();
          return true;
        }
        catch (Exception localException3)
        {
          break label347;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.util.PatchUtil
 * JD-Core Version:    0.7.0.1
 */