import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.webbundle.sdk.WebBundleConfig;
import com.tencent.webbundle.sdk.WebBundleManager;
import cooperation.comic.VipComicHelper.1;
import cooperation.comic.VipComicHelper.2;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class avcv
{
  public static AtomicLong L = new AtomicLong(0L);
  public static avcv.a a;
  public static String actionId;
  public static String cJs;
  public static String cJt;
  public static String cJu;
  public static String cJv;
  public static String cJw;
  public static String cJx;
  public static String cJy;
  private static boolean dmv;
  private static boolean dmw = true;
  public static String ext8;
  public static AtomicReference<String> h = new AtomicReference("");
  
  static
  {
    cJs = "";
    actionId = "";
    cJt = "";
    cJu = "";
    cJv = "";
    cJw = "";
    cJx = "0";
    ext8 = "";
    a = new avcv.a();
    cJy = "";
  }
  
  public static String FL()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = BaseApplicationImpl.getApplication().getSharedPreferences("ComicGlobalConfig_" + str, 0).getString("defaultComicTab", null);
    if (QLog.isColorLevel()) {
      QLog.d("ComicHelper", 2, "[ComicGlobalConfig] get default tab is " + str);
    }
    return str;
  }
  
  public static void ZI(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences("ComicGlobalConfig_" + (String)localObject, 0);
    String str = ((SharedPreferences)localObject).getString("defaultComicTab", null);
    if (TextUtils.isEmpty(paramString)) {
      if (!TextUtils.isEmpty(str))
      {
        ((SharedPreferences)localObject).edit().remove("defaultComicTab").apply();
        if (QLog.isColorLevel()) {
          QLog.d("ComicHelper", 2, "[ComicGlobalConfig] erase default tab");
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (paramString.equals(str));
      ((SharedPreferences)localObject).edit().putString("defaultComicTab", paramString).apply();
    } while (!QLog.isColorLevel());
    QLog.d("ComicHelper", 2, "[ComicGlobalConfig] update default tab to " + paramString);
  }
  
  public static AppRuntime b(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    if ((paramBaseApplicationImpl.getRuntime().getRunningModuleSize() > 0) && (avdb.cr.get() != 2)) {
      avdb.cr.set(3);
    }
    try
    {
      Class localClass1 = Class.forName("com.qqcomic.app.VipComicPluginRuntime");
      if (localClass1 != null) {}
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        try
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ComicHelper", 2, "createCOMICRuntime: load class failed");
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          ClassLoader localClassLoader;
          paramBaseApplicationImpl.printStackTrace();
        }
        localClassNotFoundException = localClassNotFoundException;
        localClassLoader = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "comic_plugin.apk");
        Class localClass2 = localClassLoader.loadClass("com.qqcomic.app.VipComicPluginRuntime");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
        continue;
        do
        {
          return null;
          paramBaseApplicationImpl = localClass2.getDeclaredConstructor(new Class[] { BaseApplicationImpl.class, String.class }).newInstance(new Object[] { paramBaseApplicationImpl, paramString });
        } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
        paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
        return paramBaseApplicationImpl;
      }
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
    return null;
  }
  
  public static boolean d(String paramString, Intent paramIntent)
  {
    int i = 100;
    boolean bool3 = false;
    Object localObject;
    boolean bool1;
    if (paramString != null)
    {
      localObject = Uri.parse(paramString);
      if ((localObject != null) && (((Uri)localObject).isHierarchical()))
      {
        bool1 = "1".equals(((Uri)localObject).getQueryParameter("init_player"));
        paramString = ((Uri)localObject).getQueryParameter("id");
        localObject = ((Uri)localObject).getQueryParameter("type");
      }
    }
    for (;;)
    {
      try
      {
        int j = Integer.parseInt((String)localObject);
        i = j;
      }
      catch (Exception localException)
      {
        boolean bool2;
        continue;
      }
      bool2 = bool3;
      if (!TextUtils.isEmpty(paramString))
      {
        bool2 = bool3;
        if (bool1)
        {
          paramIntent.putExtra("key_comic_id", paramString);
          paramIntent.putExtra("key_type", i);
          paramIntent.putExtra("key_is_fullscreen", false);
          paramIntent.putExtra("params_remote_connect_at_launch", true);
          bool2 = true;
        }
      }
      return bool2;
      paramString = null;
      bool1 = false;
    }
  }
  
  public static void eh(Intent paramIntent)
  {
    paramIntent.setComponent(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserActivity"));
    paramIntent.putExtra("fragmentStyle", 1);
    paramIntent.putExtra("tabBarStyle", 1);
    paramIntent.putExtra("titleBarStyle", 1);
    paramIntent.putExtra("hide_operation_bar", true);
    paramIntent.putExtra("hide_more_button", true);
    paramIntent.putExtra("isScreenOrientationPortrait", true);
    paramIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    if (!paramIntent.hasExtra("big_brother_source_key")) {
      paramIntent.putExtra("big_brother_source_key", "biz_src_zz_bodong");
    }
  }
  
  public static void ezv()
  {
    cJu = "";
    cJv = "";
    cJw = "NULL_NULL_NULL_NULL_NULL~NULL_NULL_NULL_NULL_NULL";
    cJx = "0";
    ext8 = "NULL";
    avcv.a.a(a).clear();
    cJy = "";
  }
  
  public static void gi(Context paramContext)
  {
    if (paramContext == null) {
      QLog.e("WebBundle.Comic", 2, "init webbundle failed because context is null.");
    }
    do
    {
      return;
      if (!dmw)
      {
        QLog.w("WebBundle.Comic", 2, "init webbundle failed because jsApi forbid.");
        return;
      }
      localObject = (aemz)aeif.a().o(534);
      if ((localObject == null) || (!((aemz)localObject).a.ahm()))
      {
        QLog.w("WebBundle.Comic", 2, "init webbundle failed because config forbid.");
        return;
      }
    } while (WebBundleManager.getInstance("comic").isInit());
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("webbundle", 4);
    if (!localSharedPreferences.getBoolean("webbundle_enable", true))
    {
      QLog.w("WebBundle.Comic", 2, "init webbundle failed because local config forbid.");
      return;
    }
    paramContext = new avel(paramContext);
    Object localObject = new WebBundleConfig().setCarrierActivityClass(QQBrowserActivity.class).setPreloadUrl(((aemz)localObject).a.preloadUrl).setLogListener(new avcy()).setOptionListener(new avcx(localSharedPreferences));
    WebBundleManager.getInstance("comic").init(paramContext, (WebBundleConfig)localObject);
    WebBundleManager.getInstance("comic").triggerPreload(1500L);
  }
  
  public static void h(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if ((paramActivity == null) || (paramIntent == null)) {
      return;
    }
    eh(paramIntent);
    try
    {
      paramActivity.startActivityForResult(paramIntent, paramInt);
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("ComicHelper", 2, "openQQBrowserActivityForComic", paramActivity);
    }
  }
  
  public static void n(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (!aqiw.isNetworkAvailable(paramQQAppInterface.getApplication()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ComicHelper", 2, "no network. skip update offline pkg. entry = " + paramInt);
      }
      return;
    }
    ThreadManager.post(new VipComicHelper.1(new WeakReference(paramQQAppInterface), paramInt), 5, null, false);
  }
  
  public static void setWebBundleOption(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 1) {}
    for (;;)
    {
      dmw = bool;
      if (!dmw) {
        ThreadManager.getUIHandler().post(new VipComicHelper.2());
      }
      QLog.d("WebBundle.Comic", 2, "handle setWebBundleOption enable = " + dmw);
      return;
      bool = false;
    }
  }
  
  public static void t(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime == null) || (dmv)) {
      return;
    }
    MagnifierSDK.setUin(paramAppRuntime.getLongAccountUin());
    try
    {
      QLog.i("ComicHelper", 4, "MagnifierSDK is enable, current process is QQComic");
      ReporterMachine.a();
      UnifiedMonitor.a().start();
      dmv = true;
      return;
    }
    catch (Exception paramAppRuntime)
    {
      for (;;)
      {
        QLog.e("ComicHelper", 4, "[Magnifier startMachine error]" + paramAppRuntime);
      }
    }
  }
  
  public static class a
  {
    private static final HashMap<String, Integer> qs = new HashMap();
    private final ConcurrentHashMap<String, Pair<Integer, String>> jV = new ConcurrentHashMap();
    private int mMaxIndex;
    
    static
    {
      qs.put("obj_ownerid", Integer.valueOf(11));
      qs.put("obj_pos", Integer.valueOf(12));
      qs.put("mod", Integer.valueOf(16));
      qs.put("land_page", Integer.valueOf(42));
      qs.put("detailpage_from", Integer.valueOf(43));
      qs.put("algo_id", Integer.valueOf(44));
    }
    
    public a a()
    {
      a locala = new a();
      locala.jV.putAll(this.jV);
      return locala;
    }
    
    public void ak(String paramString1, int paramInt, String paramString2)
    {
      if ((TextUtils.isEmpty(paramString1)) || (paramInt <= 8)) {
        return;
      }
      this.jV.put(paramString1, new Pair(Integer.valueOf(paramInt), paramString2));
    }
    
    public List<String> bx(List<String> paramList)
    {
      Object localObject;
      if (paramList == null)
      {
        localObject = null;
        return localObject;
      }
      if (paramList.size() > this.mMaxIndex + 1) {}
      for (;;)
      {
        Iterator localIterator = this.jV.entrySet().iterator();
        for (;;)
        {
          localObject = paramList;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (Map.Entry)localIterator.next();
          if (!qs.containsKey(((Map.Entry)localObject).getKey())) {
            paramList.set(((Integer)((Pair)((Map.Entry)localObject).getValue()).first).intValue(), ((Pair)((Map.Entry)localObject).getValue()).second);
          }
        }
        localObject = new ArrayList(this.mMaxIndex + 1);
        ((List)localObject).addAll(paramList);
        paramList = (List<String>)localObject;
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = aurn.d();
      Iterator localIterator = this.jV.entrySet().iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (!TextUtils.isEmpty((CharSequence)((Pair)localEntry.getValue()).second))
        {
          if (i > 0) {
            localStringBuilder.append('&');
          }
          localStringBuilder.append((String)localEntry.getKey());
          localStringBuilder.append('_');
          localStringBuilder.append(((Integer)((Pair)localEntry.getValue()).first).intValue() + 2);
          localStringBuilder.append('=');
          localStringBuilder.append((String)((Pair)localEntry.getValue()).second);
          i += 1;
        }
      }
      return URLEncoder.encode(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avcv
 * JD-Core Version:    0.7.0.1
 */