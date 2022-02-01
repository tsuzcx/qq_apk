package com.tencent.shadow.core.manager;

import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.core.manager.installplugin.AppCacheFolderManager;
import com.tencent.shadow.core.manager.installplugin.CopySoBloc;
import com.tencent.shadow.core.manager.installplugin.InstallPluginException;
import com.tencent.shadow.core.manager.installplugin.InstalledDao;
import com.tencent.shadow.core.manager.installplugin.InstalledPlugin;
import com.tencent.shadow.core.manager.installplugin.InstalledPlugin.Part;
import com.tencent.shadow.core.manager.installplugin.InstalledPluginDBHelper;
import com.tencent.shadow.core.manager.installplugin.MinFileUtils;
import com.tencent.shadow.core.manager.installplugin.ODexBloc;
import com.tencent.shadow.core.manager.installplugin.UnpackManager;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class BasePluginManager
{
  private static final Logger mLogger = LoggerFactory.getLogger(BasePluginManager.class);
  public Context mHostContext;
  private InstalledDao mInstalledDao;
  protected Handler mUiHandler = new Handler(Looper.getMainLooper());
  private UnpackManager mUnpackManager;
  
  public BasePluginManager(Context paramContext)
  {
    this.mHostContext = paramContext.getApplicationContext();
    this.mUnpackManager = new UnpackManager(this.mHostContext.getFilesDir(), getName());
    this.mInstalledDao = new InstalledDao(new InstalledPluginDBHelper(this.mHostContext, getName()));
  }
  
  private boolean deletePart(InstalledPlugin.Part paramPart)
  {
    bool1 = true;
    boolean bool2 = true;
    paramPart = paramPart.pluginFile.getParentFile().getParentFile();
    if (paramPart.exists()) {}
    try
    {
      MinFileUtils.cleanDirectory(paramPart);
      bool1 = bool2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        bool1 = false;
      }
    }
    if (!paramPart.delete()) {
      bool1 = false;
    }
    return bool1;
  }
  
  public boolean deleteInstalledPlugin(String paramString)
  {
    Object localObject = this.mInstalledDao.getInstalledPluginByUUID(paramString);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (((InstalledPlugin)localObject).runtimeFile != null)
    {
      bool1 = bool2;
      if (!deletePart(((InstalledPlugin)localObject).runtimeFile)) {
        bool1 = false;
      }
    }
    bool2 = bool1;
    if (((InstalledPlugin)localObject).pluginLoaderFile != null)
    {
      bool2 = bool1;
      if (!deletePart(((InstalledPlugin)localObject).pluginLoaderFile)) {
        bool2 = false;
      }
    }
    localObject = ((InstalledPlugin)localObject).plugins.entrySet().iterator();
    if (((Iterator)localObject).hasNext()) {
      if (deletePart((InstalledPlugin.Part)((Map.Entry)((Iterator)localObject).next()).getValue())) {
        break label232;
      }
    }
    label203:
    label230:
    label232:
    for (bool1 = false;; bool1 = bool2)
    {
      bool2 = bool1;
      break;
      localObject = AppCacheFolderManager.getLibDir(this.mUnpackManager.getAppDir(), paramString);
      bool1 = bool2;
      if (((File)localObject).exists()) {}
      try
      {
        MinFileUtils.cleanDirectory((File)localObject);
        bool1 = bool2;
      }
      catch (IOException localIOException1)
      {
        try
        {
          MinFileUtils.cleanDirectory((File)localObject);
          bool2 = bool1;
          if (((File)localObject).delete()) {
            break label203;
          }
          bool2 = false;
          if (this.mInstalledDao.deleteByUUID(paramString) > 0) {
            break label230;
          }
          return false;
          localIOException1 = localIOException1;
          bool1 = false;
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            bool1 = false;
          }
        }
      }
      if (!((File)localObject).delete()) {
        bool1 = false;
      }
      localObject = AppCacheFolderManager.getODexDir(this.mUnpackManager.getAppDir(), paramString);
      bool2 = bool1;
      if (((File)localObject).exists()) {}
      return bool2;
    }
  }
  
  /* Error */
  public final void extractLoaderOrRunTimeSo(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: invokevirtual 176	com/tencent/shadow/core/manager/BasePluginManager:getLoaderOrRunTimePart	(Ljava/lang/String;I)Lcom/tencent/shadow/core/manager/installplugin/InstalledPlugin$Part;
    //   6: astore 4
    //   8: aload_0
    //   9: getfield 65	com/tencent/shadow/core/manager/BasePluginManager:mUnpackManager	Lcom/tencent/shadow/core/manager/installplugin/UnpackManager;
    //   12: invokevirtual 155	com/tencent/shadow/core/manager/installplugin/UnpackManager:getAppDir	()Ljava/io/File;
    //   15: astore 5
    //   17: iload_2
    //   18: iconst_3
    //   19: if_icmpne +101 -> 120
    //   22: ldc 178
    //   24: astore_3
    //   25: new 180	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   32: ldc 183
    //   34: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_0
    //   38: invokevirtual 190	com/tencent/shadow/core/manager/BasePluginManager:getAbi	()Ljava/lang/String;
    //   41: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 192
    //   46: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore 6
    //   54: aload 5
    //   56: aload_1
    //   57: invokestatic 161	com/tencent/shadow/core/manager/installplugin/AppCacheFolderManager:getLibDir	(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    //   60: astore 5
    //   62: aload 4
    //   64: getfield 87	com/tencent/shadow/core/manager/installplugin/InstalledPlugin$Part:pluginFile	Ljava/io/File;
    //   67: aload 5
    //   69: aload 5
    //   71: aload_3
    //   72: invokestatic 198	com/tencent/shadow/core/manager/installplugin/AppCacheFolderManager:getLibCopiedFile	(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    //   75: aload 6
    //   77: invokestatic 204	com/tencent/shadow/core/manager/installplugin/CopySoBloc:copySo	(Ljava/io/File;Ljava/io/File;Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    //   80: astore_3
    //   81: new 206	android/content/ContentValues
    //   84: dup
    //   85: invokespecial 207	android/content/ContentValues:<init>	()V
    //   88: astore 5
    //   90: aload 5
    //   92: ldc 209
    //   94: aload_3
    //   95: invokevirtual 212	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   98: invokevirtual 216	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload_0
    //   102: getfield 77	com/tencent/shadow/core/manager/BasePluginManager:mInstalledDao	Lcom/tencent/shadow/core/manager/installplugin/InstalledDao;
    //   105: aload_1
    //   106: iload_2
    //   107: aload 5
    //   109: invokevirtual 220	com/tencent/shadow/core/manager/installplugin/InstalledDao:updatePlugin	(Ljava/lang/String;ILandroid/content/ContentValues;)Z
    //   112: pop
    //   113: aload 4
    //   115: aload_3
    //   116: putfield 223	com/tencent/shadow/core/manager/installplugin/InstalledPlugin$Part:libraryDir	Ljava/io/File;
    //   119: return
    //   120: ldc 225
    //   122: astore_3
    //   123: goto -98 -> 25
    //   126: astore_1
    //   127: getstatic 24	com/tencent/shadow/core/manager/BasePluginManager:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   130: invokeinterface 230 1 0
    //   135: ifeq +14 -> 149
    //   138: getstatic 24	com/tencent/shadow/core/manager/BasePluginManager:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   141: ldc 232
    //   143: aload_1
    //   144: invokeinterface 236 3 0
    //   149: aload_1
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	BasePluginManager
    //   0	151	1	paramString	String
    //   0	151	2	paramInt	int
    //   24	99	3	localObject1	Object
    //   6	108	4	localPart	InstalledPlugin.Part
    //   15	93	5	localObject2	Object
    //   52	24	6	str	String
    // Exception table:
    //   from	to	target	type
    //   8	17	126	com/tencent/shadow/core/manager/installplugin/InstallPluginException
    //   25	119	126	com/tencent/shadow/core/manager/installplugin/InstallPluginException
  }
  
  public final void extractSo(String paramString1, String paramString2)
  {
    InstalledPlugin.Part localPart = getPluginPartByPartKey(paramString1, paramString2);
    try
    {
      Object localObject2 = this.mUnpackManager.getAppDir();
      Object localObject1 = "lib/" + getAbi() + "/";
      localObject2 = AppCacheFolderManager.getLibDir((File)localObject2, paramString1);
      localObject1 = CopySoBloc.copySo(localPart.pluginFile, (File)localObject2, AppCacheFolderManager.getLibCopiedFile((File)localObject2, paramString2), (String)localObject1);
      localObject2 = new ContentValues();
      ((ContentValues)localObject2).put("libPath", ((File)localObject1).getAbsolutePath());
      this.mInstalledDao.updatePlugin(paramString1, paramString2, (ContentValues)localObject2);
      localPart.libraryDir = ((File)localObject1);
      return;
    }
    catch (InstallPluginException paramString1)
    {
      if (mLogger.isErrorEnabled()) {
        mLogger.error("extractSo exception:", paramString1);
      }
      throw paramString1;
    }
  }
  
  public String getAbi()
  {
    return null;
  }
  
  protected InstalledPlugin getInstalledPlugin(String paramString)
  {
    return this.mInstalledDao.getInstalledPluginByUUID(paramString);
  }
  
  public final List<InstalledPlugin> getInstalledPlugins(int paramInt)
  {
    return this.mInstalledDao.getLastPlugins(paramInt);
  }
  
  protected InstalledPlugin.Part getLoaderOrRunTimePart(String paramString, int paramInt)
  {
    Log.i("InstalledDao", "getLoaderOrRunTimePart ");
    if ((paramInt != 3) && (paramInt != 4)) {
      throw new RuntimeException("不支持的type:" + paramInt);
    }
    paramString = this.mInstalledDao.getInstalledPluginByUUID(paramString);
    Log.i("InstalledDao", "installedPlugin hashCode = " + paramString.hashCode());
    Log.i("InstalledDao", "runtimeFile = " + paramString.runtimeFile.toString());
    Log.i("InstalledDao", "pluginLoaderFile = " + paramString.pluginLoaderFile.toString());
    if (paramInt == 4)
    {
      if (paramString.runtimeFile != null) {
        return paramString.runtimeFile;
      }
    }
    else if ((paramInt == 3) && (paramString.pluginLoaderFile != null)) {
      return paramString.pluginLoaderFile;
    }
    Log.i("InstalledDao", "throw 没有找到Part type");
    throw new RuntimeException("没有找到Part type :" + paramInt);
  }
  
  protected abstract String getName();
  
  protected InstalledPlugin.Part getPluginPartByPartKey(String paramString1, String paramString2)
  {
    paramString1 = this.mInstalledDao.getInstalledPluginByUUID(paramString1);
    if (paramString1 != null) {
      return paramString1.getPart(paramString2);
    }
    throw new RuntimeException("没有找到Part partKey:" + paramString2);
  }
  
  public final InstalledPlugin installPluginFromDir(File paramFile)
  {
    throw new UnsupportedOperationException("TODO");
  }
  
  public final InstalledPlugin installPluginFromZip(File paramFile, String paramString)
  {
    paramFile = this.mUnpackManager.unpackPlugin(paramString, paramFile);
    return this.mInstalledDao.insert(paramFile);
  }
  
  public final void oDexPlugin(String paramString1, String paramString2)
  {
    InstalledPlugin.Part localPart = getPluginPartByPartKey(paramString1, paramString2);
    try
    {
      File localFile = AppCacheFolderManager.getODexDir(this.mUnpackManager.getAppDir(), paramString1);
      localFile = ODexBloc.oDexPlugin(localPart.pluginFile, localFile, AppCacheFolderManager.getODexCopiedFile(localFile, paramString2));
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("odexPath", localFile.getAbsolutePath());
      this.mInstalledDao.updatePlugin(paramString1, paramString2, localContentValues);
      localPart.oDexDir = localFile;
      return;
    }
    catch (InstallPluginException paramString1)
    {
      if (mLogger.isErrorEnabled()) {
        mLogger.error("oDexPlugin exception:", paramString1);
      }
      throw paramString1;
    }
  }
  
  /* Error */
  public final void oDexPluginLoaderOrRunTime(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: invokevirtual 176	com/tencent/shadow/core/manager/BasePluginManager:getLoaderOrRunTimePart	(Ljava/lang/String;I)Lcom/tencent/shadow/core/manager/installplugin/InstalledPlugin$Part;
    //   6: astore 4
    //   8: aload_0
    //   9: getfield 65	com/tencent/shadow/core/manager/BasePluginManager:mUnpackManager	Lcom/tencent/shadow/core/manager/installplugin/UnpackManager;
    //   12: invokevirtual 155	com/tencent/shadow/core/manager/installplugin/UnpackManager:getAppDir	()Ljava/io/File;
    //   15: aload_1
    //   16: invokestatic 164	com/tencent/shadow/core/manager/installplugin/AppCacheFolderManager:getODexDir	(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    //   19: astore 5
    //   21: iload_2
    //   22: iconst_3
    //   23: if_icmpne +63 -> 86
    //   26: ldc 178
    //   28: astore_3
    //   29: aload 4
    //   31: getfield 87	com/tencent/shadow/core/manager/installplugin/InstalledPlugin$Part:pluginFile	Ljava/io/File;
    //   34: aload 5
    //   36: aload 5
    //   38: aload_3
    //   39: invokestatic 316	com/tencent/shadow/core/manager/installplugin/AppCacheFolderManager:getODexCopiedFile	(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    //   42: invokestatic 321	com/tencent/shadow/core/manager/installplugin/ODexBloc:oDexPlugin	(Ljava/io/File;Ljava/io/File;Ljava/io/File;)Ljava/io/File;
    //   45: astore_3
    //   46: new 206	android/content/ContentValues
    //   49: dup
    //   50: invokespecial 207	android/content/ContentValues:<init>	()V
    //   53: astore 5
    //   55: aload 5
    //   57: ldc_w 323
    //   60: aload_3
    //   61: invokevirtual 212	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   64: invokevirtual 216	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_0
    //   68: getfield 77	com/tencent/shadow/core/manager/BasePluginManager:mInstalledDao	Lcom/tencent/shadow/core/manager/installplugin/InstalledDao;
    //   71: aload_1
    //   72: iload_2
    //   73: aload 5
    //   75: invokevirtual 220	com/tencent/shadow/core/manager/installplugin/InstalledDao:updatePlugin	(Ljava/lang/String;ILandroid/content/ContentValues;)Z
    //   78: pop
    //   79: aload 4
    //   81: aload_3
    //   82: putfield 326	com/tencent/shadow/core/manager/installplugin/InstalledPlugin$Part:oDexDir	Ljava/io/File;
    //   85: return
    //   86: ldc 225
    //   88: astore_3
    //   89: goto -60 -> 29
    //   92: astore_1
    //   93: getstatic 24	com/tencent/shadow/core/manager/BasePluginManager:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   96: invokeinterface 230 1 0
    //   101: ifeq +15 -> 116
    //   104: getstatic 24	com/tencent/shadow/core/manager/BasePluginManager:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   107: ldc_w 331
    //   110: aload_1
    //   111: invokeinterface 236 3 0
    //   116: aload_1
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	BasePluginManager
    //   0	118	1	paramString	String
    //   0	118	2	paramInt	int
    //   28	61	3	localObject1	Object
    //   6	74	4	localPart	InstalledPlugin.Part
    //   19	55	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	21	92	com/tencent/shadow/core/manager/installplugin/InstallPluginException
    //   29	85	92	com/tencent/shadow/core/manager/installplugin/InstallPluginException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.manager.BasePluginManager
 * JD-Core Version:    0.7.0.1
 */