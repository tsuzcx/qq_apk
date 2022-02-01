package moai.patch.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import moai.patch.log.PatchLog;
import moai.patch.util.ExtractUtil;

final class MultiDexExtractor
{
  private static final int BUFFER_SIZE = 16384;
  private static final String DEX_PREFIX = "classes";
  private static final String DEX_SUFFIX = ".dex";
  private static final String EXTRACTED_NAME_EXT = ".classes";
  private static final String EXTRACTED_SUFFIX = ".zip";
  private static final String KEY_CRC = "crc";
  private static final String KEY_DEX_NUMBER = "dex.number";
  private static final String KEY_TIME_STAMP = "timestamp";
  private static final int MAX_EXTRACT_ATTEMPTS = 3;
  private static final long NO_VALUE = -1L;
  private static final String PREFS_FILE = "multidex.version";
  private static Method sApplyMethod;
  
  static
  {
    try
    {
      sApplyMethod = SharedPreferences.Editor.class.getMethod("apply", new Class[0]);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      sApplyMethod = null;
    }
  }
  
  private static void apply(SharedPreferences.Editor paramEditor)
  {
    if (sApplyMethod != null) {}
    try
    {
      sApplyMethod.invoke(paramEditor, new Object[0]);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      paramEditor.commit();
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label20:
      break label20;
    }
  }
  
  static SharedPreferences getMultiDexPreferences(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 11) {}
    for (int i = 0;; i = 4) {
      return paramContext.getSharedPreferences("multidex.version", i);
    }
  }
  
  private static long getTimeStamp(File paramFile)
  {
    long l2 = paramFile.lastModified();
    long l1 = l2;
    if (l2 == -1L) {
      l1 = l2 - 1L;
    }
    return l1;
  }
  
  private static long getZipCrc(File paramFile)
    throws IOException
  {
    long l2 = ZipUtil.getZipCrc(paramFile);
    long l1 = l2;
    if (l2 == -1L) {
      l1 = l2 - 1L;
    }
    return l1;
  }
  
  private static boolean isModified(Context paramContext, File paramFile, long paramLong)
  {
    paramContext = getMultiDexPreferences(paramContext);
    return (paramContext.getLong("timestamp", -1L) != getTimeStamp(paramFile)) || (paramContext.getLong("crc", -1L) != paramLong);
  }
  
  static List<File> load(Context paramContext, ApplicationInfo paramApplicationInfo, File paramFile, boolean paramBoolean)
    throws IOException
  {
    PatchLog.d("MultiDexExtractor.load(" + paramApplicationInfo.sourceDir + ", " + paramBoolean + ")");
    File localFile = new File(paramApplicationInfo.sourceDir);
    long l = getZipCrc(localFile);
    if ((!paramBoolean) && (!isModified(paramContext, localFile, l))) {}
    for (;;)
    {
      try
      {
        paramApplicationInfo = loadExistingExtractions(paramContext, localFile, paramFile);
        paramContext = paramApplicationInfo;
      }
      catch (IOException paramApplicationInfo)
      {
        PatchLog.w(9004, "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", paramApplicationInfo);
        paramApplicationInfo = performExtractions(localFile, paramFile);
        putStoredApkInfo(paramContext, getTimeStamp(localFile), l, paramApplicationInfo.size() + 1);
        paramContext = paramApplicationInfo;
        continue;
      }
      PatchLog.d("load found " + paramContext.size() + " secondary dex files");
      return paramContext;
      PatchLog.d("Detected that extraction must be performed.");
      paramApplicationInfo = performExtractions(localFile, paramFile);
      putStoredApkInfo(paramContext, getTimeStamp(localFile), l, paramApplicationInfo.size() + 1);
      paramContext = paramApplicationInfo;
    }
  }
  
  private static List<File> loadExistingExtractions(Context paramContext, File paramFile1, File paramFile2)
    throws IOException
  {
    PatchLog.d("loading existing secondary dex files");
    paramFile1 = paramFile1.getName() + ".classes";
    int j = getMultiDexPreferences(paramContext).getInt("dex.number", 1);
    paramContext = new ArrayList(j);
    int i = 2;
    while (i <= j)
    {
      File localFile = new File(paramFile2, paramFile1 + i + ".zip");
      PatchLog.d("loadExistingExtractions: " + localFile + ",file exist:" + localFile.exists());
      if (localFile.isFile())
      {
        paramContext.add(localFile);
        if (!verifyZipFile(localFile))
        {
          PatchLog.i(9004, "Invalid zip file: " + localFile);
          throw new IOException("Invalid ZIP file.");
        }
      }
      else
      {
        throw new IOException("Missing extracted secondary dex file '" + localFile.getPath() + "'");
      }
      i += 1;
    }
    return paramContext;
  }
  
  private static List<File> performExtractions(File paramFile1, File paramFile2)
    throws IOException
  {
    prepareDexDir(paramFile2, paramFile1.getName() + ".classes");
    long l = System.currentTimeMillis();
    paramFile1 = ExtractUtil.subZip(paramFile1.getAbsolutePath(), "classes.dex", ".dex", paramFile2.getAbsolutePath() + File.separator + paramFile1.getName() + ".");
    PatchLog.d("extract: +" + (System.currentTimeMillis() - l) + "ms");
    return paramFile1;
  }
  
  private static void prepareDexDir(File paramFile, String paramString)
  {
    paramString = paramFile.listFiles(new MultiDexExtractor.1(paramString));
    if (paramString == null)
    {
      PatchLog.w(9004, "Failed to list secondary dex dir content (" + paramFile.getPath() + ").");
      return;
    }
    int j = paramString.length;
    int i = 0;
    label58:
    if (i < j)
    {
      paramFile = paramString[i];
      PatchLog.i(9004, "Trying to delete old file " + paramFile.getPath() + " of size " + paramFile.length());
      if (paramFile.delete()) {
        break label152;
      }
      PatchLog.w(9004, "Failed to delete old file " + paramFile.getPath());
    }
    for (;;)
    {
      i += 1;
      break label58;
      break;
      label152:
      PatchLog.i(9004, "Deleted old file " + paramFile.getPath());
    }
  }
  
  private static void putStoredApkInfo(Context paramContext, long paramLong1, long paramLong2, int paramInt)
  {
    paramContext = getMultiDexPreferences(paramContext).edit();
    paramContext.putLong("timestamp", paramLong1);
    paramContext.putLong("crc", paramLong2);
    paramContext.putInt("dex.number", paramInt);
    apply(paramContext);
  }
  
  static boolean verifyZipFile(File paramFile)
  {
    try
    {
      ZipFile localZipFile = new ZipFile(paramFile);
      try
      {
        localZipFile.close();
        return true;
      }
      catch (IOException localIOException1)
      {
        PatchLog.w(9004, "Failed to close zip file: " + paramFile.getAbsolutePath());
      }
    }
    catch (ZipException localZipException)
    {
      for (;;)
      {
        PatchLog.w(9004, "File " + paramFile.getAbsolutePath() + " is not a valid zip file.", localZipException);
      }
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        PatchLog.w(9004, "Got an IOException trying to open zip file: " + paramFile.getAbsolutePath(), localIOException2);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.multidex.MultiDexExtractor
 * JD-Core Version:    0.7.0.1
 */