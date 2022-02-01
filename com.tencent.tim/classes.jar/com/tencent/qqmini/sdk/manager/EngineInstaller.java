package com.tencent.qqmini.sdk.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.ZipUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

public class EngineInstaller
{
  public static final String LOG_TAG = "EngineInstaller";
  private static final String ROOT_DIR = "/xminilib/";
  private static String SP_NAME = "x_mini_engine";
  private static volatile List<InstalledEngine> sInstalledEngine;
  private static File sRootDir;
  private boolean isWorking = false;
  private List<Callback> mCallbacks = new ArrayList();
  
  /* Error */
  private static String getInstallLibDir(File paramFile, EngineVersion paramEngineVersion)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 62	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: aload_1
    //   9: invokevirtual 68	com/tencent/qqmini/sdk/manager/EngineVersion:toFolderName	()Ljava/lang/String;
    //   12: invokespecial 71	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore_0
    //   16: ldc 11
    //   18: new 73	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   25: ldc 76
    //   27: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_0
    //   31: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   34: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 92	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: invokevirtual 96	java/io/File:exists	()Z
    //   47: ifne +44 -> 91
    //   50: aload_0
    //   51: invokevirtual 99	java/io/File:mkdirs	()Z
    //   54: ifne +37 -> 91
    //   57: ldc 11
    //   59: new 73	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   66: ldc 101
    //   68: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_0
    //   72: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   75: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 104	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aconst_null
    //   85: astore_0
    //   86: ldc 2
    //   88: monitorexit
    //   89: aload_0
    //   90: areturn
    //   91: aload_0
    //   92: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   95: astore_0
    //   96: goto -10 -> 86
    //   99: astore_0
    //   100: ldc 2
    //   102: monitorexit
    //   103: aload_0
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramFile	File
    //   0	105	1	paramEngineVersion	EngineVersion
    // Exception table:
    //   from	to	target	type
    //   3	84	99	finally
    //   91	96	99	finally
  }
  
  public static ArrayList<InstalledEngine> getInstalledEngine(int paramInt)
  {
    try
    {
      updateInstalledEngine();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = sInstalledEngine.iterator();
      while (localIterator.hasNext())
      {
        InstalledEngine localInstalledEngine = (InstalledEngine)localIterator.next();
        if (localInstalledEngine.engineType == paramInt) {
          localArrayList.add(localInstalledEngine);
        }
      }
    }
    finally {}
    return localArrayList1;
  }
  
  private static File getRootDir()
  {
    if (sRootDir == null)
    {
      File localFile = new File(AppLoaderFactory.g().getMiniAppEnv().getContext().getFilesDir().getPath() + "/xminilib/");
      if ((!localFile.exists()) && (!localFile.mkdirs())) {
        QMLog.e("EngineInstaller", "[MiniEng] dir mk failed " + localFile);
      }
      sRootDir = localFile;
    }
    return sRootDir;
  }
  
  public static SharedPreferences getSp()
  {
    return AppLoaderFactory.g().getMiniAppEnv().getContext().getSharedPreferences(SP_NAME, 0);
  }
  
  private void installedFromNetwork(BaseLibInfo paramBaseLibInfo, String paramString, long paramLong, File paramFile, EngineVersion paramEngineVersion, boolean paramBoolean)
  {
    String str = AppLoaderFactory.g().getMiniAppEnv().getContext().getCacheDir() + File.separator + UUID.randomUUID() + ".zip";
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramString, null, str, 60, new EngineInstaller.2(this, paramString, paramBaseLibInfo, paramLong, paramFile, paramEngineVersion, paramBoolean));
    if (paramBaseLibInfo.baseLibType == 2) {
      MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 4, "1");
    }
  }
  
  private static boolean isCurrentPersistGameEngine(File paramFile)
  {
    EngineVersion localEngineVersion = EngineVersion.fromFolderName(paramFile.getName());
    return (localEngineVersion != null) && (localEngineVersion.equals(LocalGameEngine.g().mLocalEngineVersion)) && (isPersistGameEngine(paramFile));
  }
  
  private static boolean isPersistGameEngine(File paramFile)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFile != null)
    {
      bool1 = bool2;
      if (paramFile.exists())
      {
        bool1 = bool2;
        if (paramFile.isDirectory())
        {
          bool1 = bool2;
          if (paramFile.listFiles() != null)
          {
            paramFile = paramFile.listFiles(new EngineInstaller.1());
            if (paramFile != null)
            {
              bool1 = bool2;
              if (paramFile.length > 0) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static void removeEngine(InstalledEngine paramInstalledEngine)
  {
    if (paramInstalledEngine == null) {}
    for (;;)
    {
      return;
      try
      {
        QMLog.i("EngineInstaller", "[MiniEng] removeEngine " + paramInstalledEngine);
        paramInstalledEngine.deleteFiles();
        sInstalledEngine.remove(paramInstalledEngine);
      }
      finally {}
    }
  }
  
  public static void removeOldEngine(int paramInt)
  {
    Object localObject2;
    try
    {
      if (sInstalledEngine == null)
      {
        QMLog.e("EngineInstaller", "[MiniEng]removeOldEngine null");
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localObject2 = sInstalledEngine.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        InstalledEngine localInstalledEngine = (InstalledEngine)((Iterator)localObject2).next();
        if (localInstalledEngine.engineType == paramInt) {
          localArrayList.add(localInstalledEngine);
        }
      }
      j = localObject1.size();
    }
    finally {}
    int j;
    int i = 0;
    paramInt = 1;
    label99:
    if ((j > 1) && (i < j))
    {
      localObject2 = (InstalledEngine)localObject1.get(i);
      if (((InstalledEngine)localObject2).isPersist)
      {
        QMLog.i("EngineInstaller", "[MiniEng] removeOldEngine " + localObject2 + " isPersist, so not deleted");
      }
      else
      {
        if (paramInt == 0)
        {
          ((InstalledEngine)localObject2).deleteFiles();
          sInstalledEngine.remove(localObject2);
          break label229;
        }
        QMLog.i("EngineInstaller", "[MiniEng] removeOldEngine " + localObject2 + "  is latest, so kept");
        break label229;
      }
    }
    for (;;)
    {
      i += 1;
      break label99;
      break;
      label229:
      paramInt = 0;
    }
  }
  
  public static void removeOutDatedEngine(int paramInt)
  {
    label286:
    for (;;)
    {
      Object localObject2;
      InstalledEngine localInstalledEngine;
      try
      {
        if (sInstalledEngine == null)
        {
          QMLog.e("EngineInstaller", "[MiniEng]removeOutDatedEngine null");
          return;
        }
        localObject2 = new ArrayList();
        Iterator localIterator = sInstalledEngine.iterator();
        if (localIterator.hasNext())
        {
          localInstalledEngine = (InstalledEngine)localIterator.next();
          if (localInstalledEngine.engineType != paramInt) {
            continue;
          }
          ((List)localObject2).add(localInstalledEngine);
          continue;
        }
        if (paramInt != 2) {}
      }
      finally {}
      for (EngineVersion localEngineVersion = LocalGameEngine.g().mLocalEngineVersion;; localEngineVersion = null)
      {
        if (localEngineVersion == null) {
          break label286;
        }
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localInstalledEngine = (InstalledEngine)((Iterator)localObject2).next();
          if (localInstalledEngine.engineVersion.compareTo(localEngineVersion) < 0)
          {
            QMLog.i("EngineInstaller", "[MiniEng] removeOutDatedEngine " + localInstalledEngine + " localMinVer:" + localEngineVersion + ",engineType:" + paramInt);
            localInstalledEngine.deleteFiles();
            sInstalledEngine.remove(localInstalledEngine);
          }
          else if ((localInstalledEngine.isPersist) && (!isCurrentPersistGameEngine(new File(localInstalledEngine.engineDir))))
          {
            QMLog.i("EngineInstaller", "[MiniEng] removeOutDatedPersistEngine " + localInstalledEngine + " localMinVer:" + localEngineVersion + ",engineType:" + paramInt);
            localInstalledEngine.deleteFiles();
            sInstalledEngine.remove(localInstalledEngine);
          }
        }
        break;
      }
    }
  }
  
  /* Error */
  private static List<InstalledEngine> scanInstalledEngine()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 11
    //   5: ldc_w 332
    //   8: invokestatic 92	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: invokestatic 338	java/lang/System:currentTimeMillis	()J
    //   14: lstore 5
    //   16: new 38	java/util/ArrayList
    //   19: dup
    //   20: invokespecial 39	java/util/ArrayList:<init>	()V
    //   23: astore 7
    //   25: invokestatic 340	com/tencent/qqmini/sdk/manager/EngineInstaller:getRootDir	()Ljava/io/File;
    //   28: astore 8
    //   30: aload 8
    //   32: invokevirtual 96	java/io/File:exists	()Z
    //   35: ifeq +344 -> 379
    //   38: aload 8
    //   40: invokevirtual 259	java/io/File:isDirectory	()Z
    //   43: ifeq +336 -> 379
    //   46: aload 8
    //   48: invokevirtual 263	java/io/File:listFiles	()[Ljava/io/File;
    //   51: ifnull +328 -> 379
    //   54: aload 8
    //   56: invokevirtual 263	java/io/File:listFiles	()[Ljava/io/File;
    //   59: astore 8
    //   61: aload 8
    //   63: arraylength
    //   64: istore_2
    //   65: iconst_0
    //   66: istore_0
    //   67: iload_0
    //   68: iload_2
    //   69: if_icmpge +310 -> 379
    //   72: aload 8
    //   74: iload_0
    //   75: aaload
    //   76: astore 9
    //   78: aload 9
    //   80: invokevirtual 96	java/io/File:exists	()Z
    //   83: ifeq +289 -> 372
    //   86: aload 9
    //   88: invokevirtual 259	java/io/File:isDirectory	()Z
    //   91: ifeq +281 -> 372
    //   94: aload 9
    //   96: invokevirtual 263	java/io/File:listFiles	()[Ljava/io/File;
    //   99: astore 10
    //   101: aload 10
    //   103: ifnull +269 -> 372
    //   106: aload 9
    //   108: invokevirtual 237	java/io/File:getName	()Ljava/lang/String;
    //   111: invokestatic 346	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   114: istore_3
    //   115: aload 9
    //   117: invokevirtual 263	java/io/File:listFiles	()[Ljava/io/File;
    //   120: astore 9
    //   122: aload 9
    //   124: arraylength
    //   125: istore 4
    //   127: iconst_0
    //   128: istore_1
    //   129: iload_1
    //   130: iload 4
    //   132: if_icmpge +240 -> 372
    //   135: aload 9
    //   137: iload_1
    //   138: aaload
    //   139: astore 10
    //   141: new 128	com/tencent/qqmini/sdk/manager/InstalledEngine
    //   144: dup
    //   145: invokespecial 347	com/tencent/qqmini/sdk/manager/InstalledEngine:<init>	()V
    //   148: astore 11
    //   150: aload 11
    //   152: iload_3
    //   153: putfield 132	com/tencent/qqmini/sdk/manager/InstalledEngine:engineType	I
    //   156: aload 11
    //   158: aload 10
    //   160: invokevirtual 237	java/io/File:getName	()Ljava/lang/String;
    //   163: invokestatic 241	com/tencent/qqmini/sdk/manager/EngineVersion:fromFolderName	(Ljava/lang/String;)Lcom/tencent/qqmini/sdk/manager/EngineVersion;
    //   166: putfield 306	com/tencent/qqmini/sdk/manager/InstalledEngine:engineVersion	Lcom/tencent/qqmini/sdk/manager/EngineVersion;
    //   169: aload 11
    //   171: getfield 306	com/tencent/qqmini/sdk/manager/InstalledEngine:engineVersion	Lcom/tencent/qqmini/sdk/manager/EngineVersion;
    //   174: ifnonnull +91 -> 265
    //   177: new 349	java/lang/IllegalStateException
    //   180: dup
    //   181: new 73	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   188: ldc_w 351
    //   191: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload 10
    //   196: invokevirtual 237	java/io/File:getName	()Ljava/lang/String;
    //   199: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokespecial 352	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   208: athrow
    //   209: astore 11
    //   211: ldc 11
    //   213: new 73	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   220: ldc_w 354
    //   223: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload 10
    //   228: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   231: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload 11
    //   236: invokestatic 360	com/tencent/qqmini/sdk/utils/DebugUtil:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   239: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 92	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: aload 10
    //   250: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   253: iconst_0
    //   254: invokestatic 366	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   257: pop2
    //   258: iload_1
    //   259: iconst_1
    //   260: iadd
    //   261: istore_1
    //   262: goto -133 -> 129
    //   265: aload 11
    //   267: aload 10
    //   269: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   272: putfield 322	com/tencent/qqmini/sdk/manager/InstalledEngine:engineDir	Ljava/lang/String;
    //   275: aload 11
    //   277: aload 11
    //   279: invokestatic 370	com/tencent/qqmini/sdk/manager/EngineInstaller:verifyEngine	(Lcom/tencent/qqmini/sdk/manager/InstalledEngine;)Z
    //   282: putfield 373	com/tencent/qqmini/sdk/manager/InstalledEngine:isVerify	Z
    //   285: aload 11
    //   287: getfield 373	com/tencent/qqmini/sdk/manager/InstalledEngine:isVerify	Z
    //   290: ifne +22 -> 312
    //   293: new 349	java/lang/IllegalStateException
    //   296: dup
    //   297: ldc_w 375
    //   300: invokespecial 352	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   303: athrow
    //   304: astore 7
    //   306: ldc 2
    //   308: monitorexit
    //   309: aload 7
    //   311: athrow
    //   312: aload 11
    //   314: getfield 132	com/tencent/qqmini/sdk/manager/InstalledEngine:engineType	I
    //   317: iconst_2
    //   318: if_icmpne +32 -> 350
    //   321: aload 11
    //   323: ldc_w 377
    //   326: putfield 380	com/tencent/qqmini/sdk/manager/InstalledEngine:engineName	Ljava/lang/String;
    //   329: aload 11
    //   331: aload 10
    //   333: invokestatic 256	com/tencent/qqmini/sdk/manager/EngineInstaller:isPersistGameEngine	(Ljava/io/File;)Z
    //   336: putfield 294	com/tencent/qqmini/sdk/manager/InstalledEngine:isPersist	Z
    //   339: aload 7
    //   341: aload 11
    //   343: invokevirtual 136	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   346: pop
    //   347: goto -89 -> 258
    //   350: aload 11
    //   352: getfield 132	com/tencent/qqmini/sdk/manager/InstalledEngine:engineType	I
    //   355: iconst_3
    //   356: if_icmpne -17 -> 339
    //   359: aload 11
    //   361: ldc_w 382
    //   364: putfield 380	com/tencent/qqmini/sdk/manager/InstalledEngine:engineName	Ljava/lang/String;
    //   367: goto -28 -> 339
    //   370: astore 9
    //   372: iload_0
    //   373: iconst_1
    //   374: iadd
    //   375: istore_0
    //   376: goto -309 -> 67
    //   379: aload 7
    //   381: invokestatic 388	java/util/Collections:reverseOrder	()Ljava/util/Comparator;
    //   384: invokestatic 392	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   387: ldc 11
    //   389: new 73	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   396: ldc_w 394
    //   399: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokestatic 338	java/lang/System:currentTimeMillis	()J
    //   405: lload 5
    //   407: lsub
    //   408: invokevirtual 397	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   411: ldc_w 399
    //   414: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload 7
    //   419: invokevirtual 400	java/util/ArrayList:size	()I
    //   422: invokevirtual 319	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   425: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: invokestatic 92	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: ldc 2
    //   433: monitorexit
    //   434: aload 7
    //   436: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   66	310	0	i	int
    //   128	134	1	j	int
    //   64	6	2	k	int
    //   114	39	3	m	int
    //   125	8	4	n	int
    //   14	392	5	l	long
    //   23	1	7	localArrayList	ArrayList
    //   304	131	7	localList	List
    //   28	45	8	localObject1	Object
    //   76	60	9	arrayOfFile	File[]
    //   370	1	9	localException1	Exception
    //   99	233	10	localObject2	Object
    //   148	22	11	localInstalledEngine	InstalledEngine
    //   209	151	11	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   141	209	209	java/lang/Exception
    //   265	304	209	java/lang/Exception
    //   312	339	209	java/lang/Exception
    //   339	347	209	java/lang/Exception
    //   350	367	209	java/lang/Exception
    //   3	65	304	finally
    //   78	101	304	finally
    //   106	115	304	finally
    //   115	127	304	finally
    //   141	209	304	finally
    //   211	258	304	finally
    //   265	304	304	finally
    //   312	339	304	finally
    //   339	347	304	finally
    //   350	367	304	finally
    //   379	431	304	finally
    //   106	115	370	java/lang/Exception
  }
  
  /* Error */
  private boolean unzipEngine(File paramFile, String paramString1, EngineVersion paramEngineVersion, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 9
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_1
    //   9: aload_3
    //   10: invokestatic 405	com/tencent/qqmini/sdk/manager/EngineInstaller:getInstallLibDir	(Ljava/io/File;Lcom/tencent/qqmini/sdk/manager/EngineVersion;)Ljava/lang/String;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +27 -> 42
    //   18: aload_0
    //   19: invokespecial 46	com/tencent/qqmini/sdk/manager/EngineInstaller:workFinish	()V
    //   22: aload 4
    //   24: iconst_1
    //   25: invokestatic 366	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   28: pop2
    //   29: aload_0
    //   30: invokespecial 46	com/tencent/qqmini/sdk/manager/EngineInstaller:workFinish	()V
    //   33: iload 9
    //   35: istore 7
    //   37: aload_0
    //   38: monitorexit
    //   39: iload 7
    //   41: ireturn
    //   42: new 62	java/io/File
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 169	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: invokevirtual 96	java/io/File:exists	()Z
    //   53: ifeq +9 -> 62
    //   56: aload_1
    //   57: iconst_0
    //   58: invokestatic 366	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   61: pop2
    //   62: aload_0
    //   63: fconst_1
    //   64: ldc_w 407
    //   67: invokespecial 52	com/tencent/qqmini/sdk/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   70: aload 4
    //   72: aload_1
    //   73: invokestatic 413	com/tencent/qqmini/sdk/core/utils/ZipUtil:unZipFolder	(Ljava/lang/String;Ljava/lang/String;)I
    //   76: istore 6
    //   78: iload 6
    //   80: ifne +329 -> 409
    //   83: ldc2_w 414
    //   86: invokestatic 421	java/lang/Thread:sleep	(J)V
    //   89: aload_0
    //   90: fconst_1
    //   91: ldc_w 423
    //   94: invokespecial 52	com/tencent/qqmini/sdk/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   97: ldc2_w 414
    //   100: invokestatic 421	java/lang/Thread:sleep	(J)V
    //   103: aload_0
    //   104: aload 4
    //   106: aload_1
    //   107: invokespecial 427	com/tencent/qqmini/sdk/manager/EngineInstaller:verifyBaselib	(Ljava/lang/String;Ljava/lang/String;)Z
    //   110: istore 8
    //   112: iload 6
    //   114: ifne +102 -> 216
    //   117: iload 8
    //   119: ifeq +97 -> 216
    //   122: ldc 11
    //   124: new 73	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   131: ldc_w 429
    //   134: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_2
    //   138: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc_w 431
    //   144: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload_3
    //   148: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   151: ldc_w 433
    //   154: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_1
    //   158: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 92	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: invokestatic 109	com/tencent/qqmini/sdk/manager/EngineInstaller:updateInstalledEngine	()V
    //   170: iconst_1
    //   171: istore 7
    //   173: aload 4
    //   175: iconst_1
    //   176: invokestatic 366	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   179: pop2
    //   180: iload 7
    //   182: ifeq +22 -> 204
    //   185: iload 5
    //   187: ifeq +197 -> 384
    //   190: aload_0
    //   191: fconst_1
    //   192: ldc_w 435
    //   195: invokespecial 52	com/tencent/qqmini/sdk/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   198: ldc2_w 414
    //   201: invokestatic 421	java/lang/Thread:sleep	(J)V
    //   204: aload_0
    //   205: invokespecial 46	com/tencent/qqmini/sdk/manager/EngineInstaller:workFinish	()V
    //   208: goto -171 -> 37
    //   211: astore_1
    //   212: aload_0
    //   213: monitorexit
    //   214: aload_1
    //   215: athrow
    //   216: ldc 11
    //   218: new 73	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   225: ldc_w 437
    //   228: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_2
    //   232: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc_w 431
    //   238: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload_3
    //   242: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   245: ldc_w 433
    //   248: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload_1
    //   252: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 92	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: aload_1
    //   262: iconst_0
    //   263: invokestatic 366	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   266: pop2
    //   267: iload 6
    //   269: ifeq +77 -> 346
    //   272: aload_0
    //   273: fconst_0
    //   274: ldc_w 439
    //   277: invokespecial 52	com/tencent/qqmini/sdk/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   280: iload 10
    //   282: istore 7
    //   284: goto -111 -> 173
    //   287: astore_1
    //   288: ldc 11
    //   290: new 73	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   297: ldc_w 441
    //   300: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload_1
    //   304: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   307: aload_1
    //   308: invokestatic 360	com/tencent/qqmini/sdk/utils/DebugUtil:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   311: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 104	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: aload_0
    //   321: fconst_0
    //   322: ldc_w 443
    //   325: invokespecial 52	com/tencent/qqmini/sdk/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   328: aload 4
    //   330: iconst_1
    //   331: invokestatic 366	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   334: pop2
    //   335: aload_0
    //   336: invokespecial 46	com/tencent/qqmini/sdk/manager/EngineInstaller:workFinish	()V
    //   339: iload 9
    //   341: istore 7
    //   343: goto -306 -> 37
    //   346: iload 10
    //   348: istore 7
    //   350: iload 8
    //   352: ifne -179 -> 173
    //   355: aload_0
    //   356: fconst_0
    //   357: ldc_w 445
    //   360: invokespecial 52	com/tencent/qqmini/sdk/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   363: iload 10
    //   365: istore 7
    //   367: goto -194 -> 173
    //   370: astore_1
    //   371: aload 4
    //   373: iconst_1
    //   374: invokestatic 366	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   377: pop2
    //   378: aload_0
    //   379: invokespecial 46	com/tencent/qqmini/sdk/manager/EngineInstaller:workFinish	()V
    //   382: aload_1
    //   383: athrow
    //   384: aload_0
    //   385: fconst_1
    //   386: ldc_w 447
    //   389: invokespecial 52	com/tencent/qqmini/sdk/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   392: goto -194 -> 198
    //   395: astore 11
    //   397: goto -308 -> 89
    //   400: astore 11
    //   402: goto -299 -> 103
    //   405: astore_1
    //   406: goto -202 -> 204
    //   409: iconst_1
    //   410: istore 8
    //   412: goto -300 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	415	0	this	EngineInstaller
    //   0	415	1	paramFile	File
    //   0	415	2	paramString1	String
    //   0	415	3	paramEngineVersion	EngineVersion
    //   0	415	4	paramString2	String
    //   0	415	5	paramBoolean	boolean
    //   76	192	6	i	int
    //   35	331	7	bool1	boolean
    //   110	301	8	bool2	boolean
    //   4	336	9	bool3	boolean
    //   1	363	10	bool4	boolean
    //   395	1	11	localInterruptedException1	java.lang.InterruptedException
    //   400	1	11	localInterruptedException2	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   22	33	211	finally
    //   173	180	211	finally
    //   190	198	211	finally
    //   198	204	211	finally
    //   204	208	211	finally
    //   328	339	211	finally
    //   371	384	211	finally
    //   384	392	211	finally
    //   8	14	287	java/lang/Exception
    //   18	22	287	java/lang/Exception
    //   42	62	287	java/lang/Exception
    //   62	78	287	java/lang/Exception
    //   83	89	287	java/lang/Exception
    //   89	97	287	java/lang/Exception
    //   97	103	287	java/lang/Exception
    //   103	112	287	java/lang/Exception
    //   122	170	287	java/lang/Exception
    //   216	267	287	java/lang/Exception
    //   272	280	287	java/lang/Exception
    //   355	363	287	java/lang/Exception
    //   8	14	370	finally
    //   18	22	370	finally
    //   42	62	370	finally
    //   62	78	370	finally
    //   83	89	370	finally
    //   89	97	370	finally
    //   97	103	370	finally
    //   103	112	370	finally
    //   122	170	370	finally
    //   216	267	370	finally
    //   272	280	370	finally
    //   288	328	370	finally
    //   355	363	370	finally
    //   83	89	395	java/lang/InterruptedException
    //   97	103	400	java/lang/InterruptedException
    //   198	204	405	java/lang/InterruptedException
  }
  
  public static void updateInstalledEngine()
  {
    try
    {
      sInstalledEngine = scanInstalledEngine();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void updateMessage(float paramFloat, String paramString)
  {
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext())
    {
      Callback localCallback = (Callback)localIterator.next();
      if (localCallback != null) {
        localCallback.onMessageUpdate(paramFloat, paramString);
      }
    }
  }
  
  private boolean verifyBaselib(String paramString1, String paramString2)
  {
    long l1 = ZipUtil.getUncompressedFileSize(paramString1);
    if (l1 <= 0L)
    {
      QMLog.e("EngineInstaller", "[MiniEng] getUncompressedFileSize error " + paramString1 + ", sz=" + l1);
      return false;
    }
    long l2 = StorageUtil.getDirUsedSpace(paramString2);
    if (l2 <= 0L)
    {
      QMLog.e("EngineInstaller", "[MiniEng] getDirUsedSpace error " + paramString2 + ", sz2=" + l2);
      return false;
    }
    if (l1 == l2)
    {
      getSp().edit().putBoolean(paramString2, true).commit();
      return true;
    }
    QMLog.e("EngineInstaller", "[MiniEng] verifyBaselib failed sz1=" + l1 + ", sz2=" + l2);
    return false;
  }
  
  private static boolean verifyEngine(InstalledEngine paramInstalledEngine)
  {
    boolean bool = false;
    if (getSp() != null) {
      bool = getSp().getBoolean(paramInstalledEngine.engineDir, false);
    }
    QMLog.i("EngineInstaller", "[MiniEng]verifyEngine " + paramInstalledEngine.engineDir + " " + bool);
    return bool;
  }
  
  private void workAbort()
  {
    try
    {
      Iterator localIterator = this.mCallbacks.iterator();
      while (localIterator.hasNext())
      {
        Callback localCallback = (Callback)localIterator.next();
        if (localCallback != null) {
          localCallback.onEngineWorkAbort();
        }
      }
    }
    finally {}
  }
  
  private void workBegin()
  {
    try
    {
      this.isWorking = true;
      Iterator localIterator = this.mCallbacks.iterator();
      while (localIterator.hasNext())
      {
        Callback localCallback = (Callback)localIterator.next();
        if (localCallback != null) {
          localCallback.onEngineWorkBegin();
        }
      }
    }
    finally {}
  }
  
  private void workFinish()
  {
    try
    {
      this.isWorking = false;
      Iterator localIterator = new ArrayList(this.mCallbacks).iterator();
      while (localIterator.hasNext())
      {
        Callback localCallback = (Callback)localIterator.next();
        if (localCallback != null) {
          localCallback.onEngineWorkFinish();
        }
      }
    }
    finally {}
  }
  
  public void addCallback(Callback paramCallback)
  {
    try
    {
      this.mCallbacks.add(paramCallback);
      return;
    }
    finally
    {
      paramCallback = finally;
      throw paramCallback;
    }
  }
  
  public void installWithCallback(BaseLibInfo paramBaseLibInfo, Callback paramCallback)
  {
    Object localObject;
    File localFile;
    EngineVersion localEngineVersion;
    long l;
    label242:
    boolean bool1;
    for (;;)
    {
      try
      {
        localObject = paramBaseLibInfo.baseLibUrl;
        if (paramCallback != null) {
          addCallback(paramCallback);
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramBaseLibInfo.baseLibVersion)) && (paramBaseLibInfo.baseLibType > 0)) {
          continue;
        }
        QMLog.w("EngineInstaller", "[MiniEng] invalid BaseLibInfo " + paramBaseLibInfo);
        workAbort();
      }
      finally
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramBaseLibInfo.baseLibDesc);
          localEngineVersion = new EngineVersion(paramBaseLibInfo.baseLibVersion);
          l = localJSONObject.optLong("file_length");
          QMLog.w("EngineInstaller", "[MiniEng] installWithCallback " + paramBaseLibInfo);
          if (getSp() != null) {
            break label242;
          }
          QMLog.w("EngineInstaller", "[MiniEng] shared preference not supported");
          workAbort();
        }
        catch (Exception paramCallback)
        {
          QMLog.w("EngineInstaller", "[MiniEng] refuse installEngine " + paramBaseLibInfo.baseLibDesc + ":" + paramBaseLibInfo.baseLibVersion + paramBaseLibInfo.baseLibUrl + DebugUtil.getPrintableStackTrace(paramCallback));
          workAbort();
        }
        paramBaseLibInfo = finally;
      }
      return;
      localFile = new File(getRootDir(), String.valueOf(paramBaseLibInfo.baseLibType));
      continue;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QMLog.e("EngineInstaller", "[MiniEng] empty engine url");
        workAbort();
      }
      else if (isWorking())
      {
        QMLog.i("EngineInstaller", "[MiniEng] downloading already in progress");
        workAbort();
      }
      else
      {
        bool1 = false;
        QMLog.i("EngineInstaller", "[MiniEng] installWithCallback callback=" + paramCallback);
        if ((paramBaseLibInfo.baseLibType == 2) && (!LocalGameEngine.g().isDisabled()) && (!paramBaseLibInfo.baseLibUrl.startsWith("assets://")))
        {
          paramCallback = LocalGameEngine.g().mLocalEngineVersion;
          if (paramCallback.compareTo(localEngineVersion) >= 0)
          {
            QMLog.i("EngineInstaller", "[MiniEng] refuse install remote baselib:" + localEngineVersion + ",local:" + paramCallback);
            workAbort();
            continue;
          }
        }
        paramCallback = getInstalledEngine(paramBaseLibInfo.baseLibType);
        QMLog.i("EngineInstaller", "[MiniEng] engineForType " + paramBaseLibInfo.baseLibType + ", size=" + paramCallback.size());
        if (paramCallback.size() <= 0) {
          break;
        }
        paramCallback = (InstalledEngine)paramCallback.get(0);
        QMLog.i("EngineInstaller", "[MiniEng]latest engine for type " + paramBaseLibInfo.baseLibType + "," + paramCallback);
        if (paramCallback.engineVersion.compareTo(localEngineVersion) < 0) {
          break label1100;
        }
        QMLog.i("EngineInstaller", "[MiniEng]engine type " + paramBaseLibInfo.baseLibType + " has no update, remote:" + localEngineVersion + ",latest:" + paramCallback);
        workAbort();
      }
    }
    for (;;)
    {
      for (;;)
      {
        workBegin();
        if (bool1) {
          updateMessage(0.0F, "更新引擎(" + paramBaseLibInfo.baseLibVersion + ")");
        }
        for (;;)
        {
          QMLog.i("EngineInstaller", "[MiniEng] installEngine " + (String)localObject);
          if ((localFile.exists()) || (localFile.mkdirs())) {
            break label739;
          }
          QMLog.i("EngineInstaller", "[MiniEng] mkdir failed, is disk writable? " + localFile.getAbsolutePath());
          workFinish();
          break;
          updateMessage(0.0F, "下载引擎(" + paramBaseLibInfo.baseLibVersion + ")");
        }
        label739:
        boolean bool2 = false;
        paramCallback = null;
        if (paramBaseLibInfo.baseLibType == 2)
        {
          bool2 = paramBaseLibInfo.baseLibUrl.startsWith("assets://");
          paramBaseLibInfo.baseLibUrl.replace("assets://", "");
          paramCallback = new long[1];
          paramCallback[0] = 0L;
        }
        if (!bool2) {
          break label1083;
        }
        try
        {
          updateMessage(0.0F, "正在解压缩本地引擎");
          paramBaseLibInfo = getInstallLibDir(localFile, localEngineVersion);
          QMLog.i("EngineInstaller", "[MiniEng] installLocalEngine start url=" + (String)localObject + ",installBasePath=" + paramBaseLibInfo);
          if (TextUtils.isEmpty(paramBaseLibInfo))
          {
            updateMessage(0.0F, "本地引擎安装失败, 目录为空");
            QMLog.e("EngineInstaller", "[MiniEng] installLocalEngine failed installBasePath=" + paramBaseLibInfo);
            workFinish();
            break;
          }
        }
        finally {}
      }
      localObject = new File(paramBaseLibInfo);
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdir()))
      {
        updateMessage(0.0F, "本地引擎安装失败, 创建目录失败");
        QMLog.e("EngineInstaller", "[MiniEng] installLocalEngine failed targetPath=" + localObject);
        workFinish();
        break;
      }
      BaseLibManager.g().installMiniGameInnerJsLib();
      QMLog.i("EngineInstaller", "[MiniEng] installLocalEngine finish copied " + paramCallback[0] + "<>" + l);
      if ((paramCallback[0] == l) || (l < 0L))
      {
        getSp().edit().putBoolean(paramBaseLibInfo, true).commit();
        updateInstalledEngine();
        updateMessage(1.0F, "本地引擎安装完成");
      }
      for (;;)
      {
        workFinish();
        break;
        updateMessage(0.0F, "本地引擎安装失败");
      }
      label1083:
      installedFromNetwork(paramBaseLibInfo, (String)localObject, l, localFile, localEngineVersion, bool1);
      break;
      label1100:
      bool1 = true;
    }
  }
  
  public boolean isWorking()
  {
    try
    {
      boolean bool = this.isWorking;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void removeCallback(Callback paramCallback)
  {
    try
    {
      this.mCallbacks.remove(paramCallback);
      return;
    }
    finally
    {
      paramCallback = finally;
      throw paramCallback;
    }
  }
  
  public static abstract interface Callback
  {
    public abstract void onEngineWorkAbort();
    
    public abstract void onEngineWorkBegin();
    
    public abstract void onEngineWorkFinish();
    
    public abstract void onMessageUpdate(float paramFloat, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.EngineInstaller
 * JD-Core Version:    0.7.0.1
 */