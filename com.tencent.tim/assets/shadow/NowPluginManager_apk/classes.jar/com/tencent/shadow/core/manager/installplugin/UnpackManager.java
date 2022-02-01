package com.tencent.shadow.core.manager.installplugin;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;

public class UnpackManager
{
  private static final String CONFIG_FILENAME = "config.json";
  private static final String DEFAULT_STORE_DIR_NAME = "ShadowPluginManager";
  private static final String UNPACK_DONE_PRE_FIX = "unpacked.";
  private final String mAppName;
  private final File mPluginUnpackedDir;
  
  public UnpackManager(File paramFile, String paramString)
  {
    this.mPluginUnpackedDir = new File(new File(paramFile, "ShadowPluginManager"), "UnpackedPlugin");
    this.mPluginUnpackedDir.mkdirs();
    this.mAppName = paramString;
  }
  
  public File getAppDir()
  {
    return AppCacheFolderManager.getAppDir(this.mPluginUnpackedDir, this.mAppName);
  }
  
  PluginConfig getDownloadedPluginInfoFromPluginUnpackedDir(File paramFile, String paramString)
  {
    paramString = new BufferedReader(new InputStreamReader(new FileInputStream(new File(paramFile, "config.json"))));
    StringBuilder localStringBuilder = new StringBuilder("");
    try
    {
      for (;;)
      {
        String str = paramString.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str).append("\n");
      }
    }
    finally
    {
      paramString.close();
    }
    return PluginConfig.parseFromJson(localStringBuilder.toString(), paramFile);
  }
  
  File getPluginUnpackDir(String paramString, File paramFile)
  {
    return new File(getVersionDir(paramString), paramFile.getName());
  }
  
  File getUnpackedTag(File paramFile)
  {
    return new File(paramFile.getParentFile(), "unpacked." + paramFile.getName());
  }
  
  File getVersionDir(String paramString)
  {
    return AppCacheFolderManager.getVersionDir(this.mPluginUnpackedDir, this.mAppName, paramString);
  }
  
  boolean isDirUnpacked(File paramFile)
  {
    return getUnpackedTag(paramFile).exists();
  }
  
  boolean isPluginUnpacked(String paramString, File paramFile)
  {
    return isDirUnpacked(getPluginUnpackDir(paramString, paramFile));
  }
  
  public PluginConfig unpackPlugin(String paramString, File paramFile)
  {
    String str = paramString;
    if (paramString == null) {
      str = MinFileUtils.md5File(paramFile);
    }
    File localFile = getPluginUnpackDir(str, paramFile);
    localFile.mkdirs();
    paramString = getUnpackedTag(localFile);
    if (isDirUnpacked(localFile)) {
      try
      {
        PluginConfig localPluginConfig = getDownloadedPluginInfoFromPluginUnpackedDir(localFile, str);
        return localPluginConfig;
      }
      catch (Exception localException)
      {
        if (!paramString.delete()) {
          throw new IOException("解析版本信息失败，且无法删除标记:" + paramString.getAbsolutePath());
        }
      }
    }
    MinFileUtils.cleanDirectory(localFile);
    SafeZipInputStream localSafeZipInputStream = new SafeZipInputStream(new FileInputStream(paramFile));
    for (;;)
    {
      try
      {
        paramFile = localSafeZipInputStream.getNextEntry();
        if (paramFile != null)
        {
          boolean bool = paramFile.isDirectory();
          if (bool) {
            continue;
          }
        }
      }
      finally
      {
        localSafeZipInputStream.close();
      }
      try
      {
        paramFile = new BufferedOutputStream(new FileOutputStream(new File(localFile, paramFile.getName())));
        try
        {
          BufferedInputStream localBufferedInputStream = new BufferedInputStream(localSafeZipInputStream);
          byte[] arrayOfByte = new byte[8192];
          int i = localBufferedInputStream.read(arrayOfByte, 0, 8192);
          if (i < 0) {
            break label236;
          }
          paramFile.write(arrayOfByte, 0, i);
          continue;
          localSafeZipInputStream.closeEntry();
        }
        finally {}
      }
      finally
      {
        paramFile = null;
        continue;
      }
      if (paramFile != null) {
        paramFile.close();
      }
      throw paramString;
      label236:
      localSafeZipInputStream.closeEntry();
      if (paramFile != null) {
        paramFile.close();
      }
    }
    paramFile = getDownloadedPluginInfoFromPluginUnpackedDir(localFile, str);
    paramString.createNewFile();
    localSafeZipInputStream.close();
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.manager.installplugin.UnpackManager
 * JD-Core Version:    0.7.0.1
 */