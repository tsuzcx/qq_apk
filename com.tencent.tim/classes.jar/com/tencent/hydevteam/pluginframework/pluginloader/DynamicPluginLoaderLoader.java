package com.tencent.hydevteam.pluginframework.pluginloader;

import com.tencent.hydevteam.common.classloader.ApkClassLoader;
import com.tencent.hydevteam.pluginframework.pluginloader.exceptions.DynamicPluginLoaderLoadException;
import java.io.File;

class DynamicPluginLoaderLoader
{
  private final File a;
  private final String b;
  private final String c;
  private final String[] d;
  
  DynamicPluginLoaderLoader(String paramString1, File paramFile, String paramString2, String[] paramArrayOfString)
  {
    this.b = paramString1;
    this.a = paramFile;
    this.c = paramString2;
    this.d = paramArrayOfString;
  }
  
  final PluginLoader a()
    throws DynamicPluginLoaderLoadException
  {
    if (!this.a.exists()) {
      throw new DynamicPluginLoaderLoadException("文件" + this.a.getAbsolutePath() + "不存在");
    }
    if (!this.a.canRead()) {
      throw new DynamicPluginLoaderLoadException("文件" + this.a.getAbsolutePath() + "不可读");
    }
    Object localObject = new File(this.a.getParent(), "DynamicPluginLoader_" + this.b);
    if ((((File)localObject).exists()) && (!((File)localObject).isDirectory())) {
      throw new DynamicPluginLoaderLoadException("odexDir目标路径" + ((File)localObject).getAbsolutePath() + "已被其他文件占用");
    }
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdir())) {
      throw new DynamicPluginLoaderLoadException("odexDir目标路径" + ((File)localObject).getAbsolutePath() + "创建目录失败");
    }
    File localFile = new File(this.a.getParent(), "DynamicPluginLoader_lib_" + this.b);
    if ((!localFile.exists()) && (!localFile.mkdirs())) {
      throw new DynamicPluginLoaderLoadException("libDir目标路径" + localFile.getAbsolutePath() + "创建目录失败");
    }
    localObject = new ApkClassLoader(this.a.getAbsolutePath(), ((File)localObject).getAbsolutePath(), localFile.getAbsolutePath(), DynamicPluginLoaderLoader.class.getClassLoader(), this.d);
    try
    {
      localObject = (PluginLoader)((ApkClassLoader)localObject).a(PluginLoader.class, this.c);
      return localObject;
    }
    catch (Exception localException)
    {
      throw new DynamicPluginLoaderLoadException(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginloader.DynamicPluginLoaderLoader
 * JD-Core Version:    0.7.0.1
 */