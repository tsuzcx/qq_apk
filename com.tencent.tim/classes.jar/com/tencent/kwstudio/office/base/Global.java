package com.tencent.kwstudio.office.base;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Executor;

public final class Global
{
  private static final String DIR_DEX = "olc/dex";
  private static final String DIR_NATIVE = "olc/native";
  private static final String DIR_PLUGIN = "olc/plugins";
  private static final String DIR_RESOURCE = "olc/resources";
  public static final String MODULE_ID_PORT = "1";
  public static final String MODULE_ID_PREVIEW = "11";
  public static final String MODULE_ID_PREVIEW_DOC = "12";
  public static final String MODULE_ID_PREVIEW_SHEET = "13";
  public static final String MODULE_ID_PREVIEW_SLIDE = "14";
  public static final String MODULE_ID_PREVIEW_VIEWER = "15";
  private static volatile IGlobal sGlobal;
  
  private static boolean assertGlobal()
  {
    if (sGlobal == null) {
      throw new IllegalStateException("Global hadn't initialized.");
    }
    return true;
  }
  
  private static String buildPaths(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return paramString1;
    }
    return paramString1 + File.separator + paramString2;
  }
  
  public static Context getApplicationContext()
  {
    assertGlobal();
    return sGlobal.getApplicationContext();
  }
  
  public static File getDexDir(String paramString)
  {
    return getDir(buildPaths("olc/dex", paramString));
  }
  
  private static File getDir(String paramString)
  {
    paramString = new File(getApplicationContext().getFilesDir(), paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramString;
  }
  
  public static Executor getExecutor()
  {
    assertGlobal();
    return sGlobal.getExecutor();
  }
  
  public static String getFileDir()
  {
    assertGlobal();
    return sGlobal.getFileDir();
  }
  
  public static File getNativeDir(String paramString)
  {
    return getDir(buildPaths("olc/native", paramString));
  }
  
  public static File getPluginDir(String paramString)
  {
    return getDir(buildPaths("olc/plugins", paramString));
  }
  
  public static InputStream getResourceAsStream(String paramString)
  {
    assertGlobal();
    return sGlobal.getResourceAsStream(paramString);
  }
  
  public static File getResourceDir(String paramString)
  {
    return getDir(buildPaths("olc/resources", paramString));
  }
  
  public static void setGlobal(IGlobal paramIGlobal)
  {
    sGlobal = paramIGlobal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.kwstudio.office.base.Global
 * JD-Core Version:    0.7.0.1
 */