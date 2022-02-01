import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import android.util.SparseArray;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.weiyun.utils.NetworkUtils;
import com.weiyun.sdk.IWyFileSystem;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public final class awph
{
  private static IWyFileSystem b;
  private static String cRW;
  private static String cRX;
  private static String cRY;
  private static String cRZ;
  private static boolean dre = false;
  private static final SparseArray<String> ec;
  private static final Map<Integer, String> qs;
  
  static
  {
    cRW = "";
    cRX = "";
    qs = new HashMap();
    qs.put(Integer.valueOf(0), "16*16");
    qs.put(Integer.valueOf(1), "32*32");
    qs.put(Integer.valueOf(2), "64*64");
    qs.put(Integer.valueOf(3), "128*128");
    qs.put(Integer.valueOf(4), "320*320");
    qs.put(Integer.valueOf(5), "384*384");
    qs.put(Integer.valueOf(6), "640*640");
    qs.put(Integer.valueOf(7), "750*750");
    qs.put(Integer.valueOf(8), "1024*1024");
    ec = new SparseArray(9);
    ec.put(0, "/16");
    ec.put(1, "/32");
    ec.put(2, "/64");
    ec.put(3, "/128");
    ec.put(4, "/320");
    ec.put(5, "/384");
    ec.put(6, "/640");
    ec.put(7, "/750");
    ec.put(8, "/1024");
  }
  
  public static String Hk()
  {
    return cRY;
  }
  
  public static String Hl()
  {
    QLog.d("Weiyun.AlbumBackup", 2, "weiyun shapce payurl : " + "https://jump.weiyun.com/?from=3047");
    return "https://jump.weiyun.com/?from=3047";
  }
  
  public static PluginRuntime a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    try
    {
      Class localClass = Class.forName("com.weiyun.plugin.app.WeiyunRuntime");
      paramBaseApplicationImpl = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      try
      {
        ClassLoader localClassLoader = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "WeiyunPlugin.apk");
        paramBaseApplicationImpl = localClassLoader.loadClass("com.weiyun.plugin.app.WeiyunRuntime");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
      catch (ClassNotFoundException paramBaseApplicationImpl)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
      do
      {
        return null;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof PluginRuntime)));
      paramBaseApplicationImpl = (PluginRuntime)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    if (paramBaseApplicationImpl == null) {
      return null;
    }
  }
  
  public static Pair<Pair<String, String>, Long> a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new Pair(new Pair(paramString, paramString), Long.valueOf(0L));
    }
    String str = (String)qs.get(Integer.valueOf(paramInt));
    paramString = new StringBuilder(paramString);
    if (paramBoolean)
    {
      str = (String)ec.get(paramInt);
      if (!TextUtils.isEmpty(str)) {
        paramString.append(str);
      }
      paramString = paramString.toString();
      l = paramString.hashCode() * 31;
      return new Pair(new Pair(paramString, paramString), Long.valueOf(l));
    }
    paramInt = NetworkUtils.getNetworkType(BaseApplicationImpl.getApplication());
    paramString.append("&nettype=").append(paramInt);
    if (!TextUtils.isEmpty(str)) {
      paramString.append("&size=").append(str);
    }
    paramString = paramString.toString();
    str = paramString.replaceFirst("cn=\\d", "").replaceFirst("nettype=\\d", "");
    long l = str.hashCode() * 31;
    return new Pair(new Pair(paramString, str), Long.valueOf(l));
  }
  
  /* Error */
  public static IWyFileSystem a()
  {
    // Byte code:
    //   0: getstatic 252	awph:b	Lcom/weiyun/sdk/IWyFileSystem;
    //   3: ifnonnull +83 -> 86
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 252	awph:b	Lcom/weiyun/sdk/IWyFileSystem;
    //   12: ifnonnull +71 -> 83
    //   15: invokestatic 257	com/weiyun/sdk/WyFileSystemFactory:getWyFileSystem	()Lcom/weiyun/sdk/IWyFileSystem;
    //   18: astore_0
    //   19: invokestatic 226	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   22: invokevirtual 261	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   25: astore_1
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 266	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   31: aload_1
    //   32: invokevirtual 269	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   35: invokestatic 274	awpr:a	()Lawpr;
    //   38: invokestatic 279	atvx:a	()Latvx;
    //   41: new 281	com/weiyun/sdk/WyConfiguration
    //   44: dup
    //   45: invokestatic 286	ahaf:a	()Lahaf;
    //   48: invokevirtual 289	ahaf:vZ	()Ljava/lang/String;
    //   51: invokespecial 290	com/weiyun/sdk/WyConfiguration:<init>	(Ljava/lang/String;)V
    //   54: invokeinterface 296 6 0
    //   59: aload_0
    //   60: putstatic 252	awph:b	Lcom/weiyun/sdk/IWyFileSystem;
    //   63: invokestatic 302	com/weiyun/sdk/Global:isInit	()Z
    //   66: ifne +17 -> 83
    //   69: aload_1
    //   70: invokevirtual 266	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   73: new 304	awpi
    //   76: dup
    //   77: invokespecial 305	awpi:<init>	()V
    //   80: invokestatic 309	com/weiyun/sdk/Global:init	(Landroid/content/Context;Lcom/weiyun/sdk/Global$HostInterface;)V
    //   83: ldc 2
    //   85: monitorexit
    //   86: getstatic 252	awph:b	Lcom/weiyun/sdk/IWyFileSystem;
    //   89: areturn
    //   90: astore_0
    //   91: ldc_w 311
    //   94: iconst_1
    //   95: aload_0
    //   96: invokevirtual 312	java/lang/Exception:toString	()Ljava/lang/String;
    //   99: invokestatic 315	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: goto -19 -> 83
    //   105: astore_0
    //   106: ldc 2
    //   108: monitorexit
    //   109: aload_0
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	42	0	localIWyFileSystem	IWyFileSystem
    //   90	6	0	localException	Exception
    //   105	5	0	localObject	Object
    //   25	45	1	localAppRuntime	AppRuntime
    // Exception table:
    //   from	to	target	type
    //   26	83	90	java/lang/Exception
    //   9	26	105	finally
    //   26	83	105	finally
    //   83	86	105	finally
    //   91	102	105	finally
    //   106	109	105	finally
  }
  
  public static String[] ad()
  {
    return new String[] { cRW, cRX };
  }
  
  private static void c(Application paramApplication)
  {
    cRY = ahaf.a().vZ();
    if ("mounted".equals(Environment.getExternalStorageState())) {}
    for (paramApplication = new File(aqul.getSDKPrivatePath(acbn.SDCARD_PATH));; paramApplication = paramApplication.getCacheDir())
    {
      cRZ = new File(paramApplication, "diskcache").getAbsolutePath();
      return;
    }
  }
  
  public static String cy(String paramString1, String paramString2)
  {
    paramString1 = String.format("https://jump.weiyun.com/?from=30001&aid=%s", new Object[] { paramString2 });
    QLog.d("Weiyun.AlbumBackup", 2, "weiyun vip payurl : " + paramString1);
    return paramString1;
  }
  
  public static String cz(String paramString1, String paramString2)
  {
    paramString1 = String.format("https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&aid=%s", new Object[] { paramString2 });
    QLog.d("Weiyun.AlbumBackup", 2, "qq vip payurl : " + paramString1);
    return paramString1;
  }
  
  public static void eEK()
  {
    if (!dre) {
      try
      {
        if (!dre)
        {
          BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
          awov.a(localBaseApplicationImpl, false);
          awpx.gB(localBaseApplicationImpl);
          c(localBaseApplicationImpl);
          dre = true;
        }
        return;
      }
      finally {}
    }
  }
  
  public static void eEL()
  {
    if (dre) {
      try
      {
        if (dre)
        {
          awov.T(false, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
          dre = false;
        }
        return;
      }
      finally {}
    }
  }
  
  public static void eEM()
  {
    cRW = "";
    cRX = "";
  }
  
  public static void gA(Context paramContext)
  {
    paramContext.sendBroadcast(new Intent("exit_file_assit"), "com.tencent.tim.msg.permission.pushnotify");
  }
  
  public static void gz(Context paramContext)
  {
    paramContext.sendBroadcast(new Intent("enter_file_assit"), "com.tencent.tim.msg.permission.pushnotify");
  }
  
  public static void jI(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      cRW = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      cRX = paramString2;
    }
  }
  
  public static void v(Context paramContext, long paramLong)
  {
    awpx.v(paramContext, paramLong);
  }
  
  public static String wb()
  {
    return cRZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awph
 * JD-Core Version:    0.7.0.1
 */