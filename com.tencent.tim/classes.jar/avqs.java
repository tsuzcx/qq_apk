import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.FileObserver;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class avqs
{
  private static aixa<avqs, Void> e = new avqt();
  private volatile boolean acL;
  private FileObserver b;
  private final byte bG = 2;
  private final byte bH = 1;
  private volatile boolean dnY;
  private Handler handler = new avqu(this, ThreadManager.getSubThreadLooper());
  
  @NonNull
  private static Pair<Integer, Throwable> a(Context paramContext, String paramString)
  {
    if (isArt())
    {
      File localFile = PluginUtils.getOptimizedDexPath(paramContext);
      paramContext = a(PluginUtils.getInstalledPluginPath(paramContext, paramString), localFile);
      if (paramContext.exists()) {
        return avsa.a(paramContext);
      }
      QLog.w("QZoneStartupMonitor", 1, "qzone_plugin.dex不存在");
      return new Pair(Integer.valueOf(-9), new IOException("pluginid: " + paramString + ",path:" + paramContext + " not found"));
    }
    QLog.i("QZoneStartupMonitor", 1, "非ART机器");
    return new Pair(Integer.valueOf(0), null);
  }
  
  public static avqs a()
  {
    return (avqs)e.get(null);
  }
  
  private static File a(File paramFile1, File paramFile2)
  {
    String str = paramFile1.getName();
    paramFile1 = str;
    int i;
    if (!str.endsWith(".dex"))
    {
      i = str.lastIndexOf(".");
      if (i >= 0) {
        break label57;
      }
    }
    for (paramFile1 = str + ".dex";; paramFile1 = paramFile1.toString())
    {
      return new File(paramFile2, paramFile1);
      label57:
      paramFile1 = new StringBuilder(i + 4);
      paramFile1.append(str, 0, i);
      paramFile1.append(".dex");
    }
  }
  
  public static boolean deleteFile(File paramFile)
  {
    boolean bool = false;
    int i = 0;
    if (paramFile.exists())
    {
      int j;
      do
      {
        bool = paramFile.delete();
        j = i + 1;
        if (bool) {
          break;
        }
        i = j;
      } while (j < 2);
    }
    return bool;
  }
  
  public static void eBC()
  {
    File localFile;
    if (BaseApplicationImpl.sProcessId == 2)
    {
      QLog.i("QZoneStartupMonitor", 1, "beforeLoadPlugin");
      localFile = new File(BaseApplicationImpl.getApplication().getDir("qzone_monitor_dir", 0), "qzone_startup_monitor");
      if (localFile.exists()) {}
    }
    try
    {
      localFile.createNewFile();
      return;
    }
    catch (IOException localIOException)
    {
      QLog.w("QZoneStartupMonitor", 1, "", localIOException);
    }
  }
  
  private void eBD()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneStartupMonitor", 2, "backupQZoneDex:ExternalStorageState():" + Environment.getExternalStorageState().equals("mounted") + ",canWrite:" + Environment.getExternalStorageDirectory().canWrite());
    }
    File localFile1 = new File(avtc.cNx);
    boolean bool1;
    if (!localFile1.exists())
    {
      boolean bool2 = localFile1.mkdirs();
      bool1 = bool2;
      if (!bool2) {
        bool1 = localFile1.mkdirs();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneStartupMonitor", 2, "创建或者删除目标是否成功：" + bool1);
      }
      if (bool1)
      {
        File localFile2 = PluginUtils.getOptimizedDexPath(BaseApplicationImpl.getContext());
        localFile2 = a(PluginUtils.getInstalledPluginPath(BaseApplicationImpl.getContext(), "qzone_plugin.apk"), localFile2);
        localFile1 = new File(localFile1, "qzone_plugin_" + avpq.getQUA3());
        QLog.i("QZoneStartupMonitor", 1, "copy from " + localFile2.getPath() + " to " + localFile1.getPath());
        aqhq.copyFile(localFile2, localFile1);
      }
      return;
      if (!localFile1.isDirectory()) {
        bool1 = deleteFile(localFile1);
      } else {
        bool1 = true;
      }
    }
  }
  
  private void eBE()
  {
    if (!QzonePluginProxyActivity.aLs())
    {
      Object localObject1 = BaseApplicationImpl.sApplication.getRuntime();
      if ((localObject1 == null) || (!(localObject1 instanceof QQAppInterface))) {
        QLog.i("QZoneStartupMonitor", 1, "非手q 进程，不进行卸载");
      }
      do
      {
        return;
        localObject1 = (QQAppInterface)localObject1;
        localObject2 = (avfw)((QQAppInterface)localObject1).getManager(27);
        QLog.i("QZoneStartupMonitor", 1, "reInstallQzone cancelInstall:qzone_plugin.apk");
        ((avfw)localObject2).cancelInstall("qzone_plugin.apk");
      } while (((avfw)localObject2).isPlugininstalled("qzone_plugin.apk"));
      Object localObject2 = PluginUtils.getOptimizedDexPath(BaseApplicationImpl.getContext());
      localObject2 = a(PluginUtils.getInstalledPluginPath(BaseApplicationImpl.getContext(), "qzone_plugin.apk"), (File)localObject2);
      QLog.i("QZoneStartupMonitor", 1, "reInstallQzone delete odex:" + ((File)localObject2).getPath());
      deleteFile((File)localObject2);
      avpw.bp((QQAppInterface)localObject1, "reInstallQzone");
      return;
    }
    QLog.i("QZoneStartupMonitor", 1, "qzone 进程存在，什么都不要做");
  }
  
  private static boolean isArt()
  {
    String str = System.getProperty("java.vm.version");
    if ((str != null) && (str.startsWith("2"))) {}
    for (int i = 1; (i != 0) && (Build.VERSION.SDK_INT >= 21); i = 0) {
      return true;
    }
    return false;
  }
  
  private void j(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramBoolean) && (paramInt2 < 1)) {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneStartupMonitor", 2, "oat 合法，启动成功不上报");
      }
    }
    Object localObject;
    label126:
    do
    {
      do
      {
        return;
        if (isArt()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QZoneStartupMonitor", 2, "非 art 不上报");
      return;
      localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localObject != null) {}
      for (localObject = ((AppRuntime)localObject).getAccount();; localObject = null)
      {
        if (paramInt2 >= 1) {
          anpc.a(BaseApplication.getContext()).collectPerformance((String)localObject, "qzoneRecovery", paramBoolean, 0L, 0L, null, "");
        }
        if (!this.acL) {
          break label126;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QZoneStartupMonitor", 2, "已经上报过，不再上报");
        return;
      }
    } while (TextUtils.isEmpty((CharSequence)localObject));
    this.acL = true;
    HashMap localHashMap = new HashMap();
    int j;
    int i;
    label162:
    label176:
    anpc localanpc;
    if (paramInt1 == 0)
    {
      j = 2;
      if (!paramBoolean) {
        break label320;
      }
      i = 1;
      int k = j | i;
      if (paramInt1 != 0) {
        break label326;
      }
      j = 0;
      localHashMap.put("oatValid", String.valueOf(j));
      localHashMap.put("param_FailCode", String.valueOf(k));
      localHashMap.put("recoveryCount", String.valueOf(paramInt2));
      localHashMap.put("type", String.valueOf(k));
      localHashMap.put("errorCode", String.valueOf(paramInt1));
      localHashMap.put("startupSuccess", String.valueOf(i));
      if (paramInt2 <= 0) {
        break label337;
      }
      if (!paramBoolean) {
        break label332;
      }
      paramInt1 = 1;
      label268:
      localHashMap.put("recovery", String.valueOf(paramInt1));
      localanpc = anpc.a(BaseApplication.getContext());
      if (k != 0) {
        break label342;
      }
    }
    label320:
    label326:
    label332:
    label337:
    label342:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localanpc.collectPerformance((String)localObject, "qzoneOdexCheck", paramBoolean, 0L, 0L, localHashMap, "");
      return;
      j = 0;
      break;
      i = 0;
      break label162;
      j = 1;
      break label176;
      paramInt1 = 0;
      break label268;
      paramInt1 = -1;
      break label268;
    }
  }
  
  /* Error */
  public void monitor()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 428	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   7: ldc_w 430
    //   10: ldc_w 432
    //   13: iconst_1
    //   14: invokevirtual 436	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   17: iconst_1
    //   18: if_icmpne +19 -> 37
    //   21: iload_1
    //   22: ifne +20 -> 42
    //   25: ldc 80
    //   27: iconst_1
    //   28: ldc_w 438
    //   31: invokestatic 129	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: iconst_0
    //   38: istore_1
    //   39: goto -18 -> 21
    //   42: aload_0
    //   43: getfield 440	avqs:b	Landroid/os/FileObserver;
    //   46: ifnonnull -12 -> 34
    //   49: invokestatic 201	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   52: ldc 203
    //   54: iconst_0
    //   55: invokevirtual 207	com/tencent/common/app/BaseApplicationImpl:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   58: astore_2
    //   59: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +32 -> 94
    //   65: ldc 80
    //   67: iconst_2
    //   68: new 100	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   75: ldc_w 442
    //   78: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_2
    //   82: invokevirtual 278	java/io/File:getPath	()Ljava/lang/String;
    //   85: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: aload_0
    //   95: new 444	avqv
    //   98: dup
    //   99: aload_0
    //   100: aload_2
    //   101: invokevirtual 278	java/io/File:getPath	()Ljava/lang/String;
    //   104: sipush 768
    //   107: invokespecial 447	avqv:<init>	(Lavqs;Ljava/lang/String;I)V
    //   110: putfield 440	avqs:b	Landroid/os/FileObserver;
    //   113: aload_0
    //   114: getfield 440	avqs:b	Landroid/os/FileObserver;
    //   117: invokevirtual 452	android/os/FileObserver:startWatching	()V
    //   120: goto -86 -> 34
    //   123: astore_2
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_2
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	avqs
    //   1	38	1	i	int
    //   58	43	2	localFile	File
    //   123	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	21	123	finally
    //   25	34	123	finally
    //   42	94	123	finally
    //   94	120	123	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avqs
 * JD-Core Version:    0.7.0.1
 */