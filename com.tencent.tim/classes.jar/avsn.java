import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.startup.step.InstallPlugins;
import com.tencent.mobileqq.startup.step.InstallPlugins.a;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Servlet;
import mqq.app.ServletContainer;
import mqq.util.WeakReference;

public class avsn
{
  private static volatile Class<?> L;
  private static Method Y;
  private static volatile boolean azZ;
  private static volatile WeakReference<QQAppInterface> bp;
  private static volatile WeakReference<PluginManagerClient> bq = new WeakReference(null);
  private static volatile Constructor<?> c;
  private static volatile boolean doF;
  private static volatile boolean doG;
  private static final AtomicReference<SharedPreferences> j = new AtomicReference();
  
  @Nullable
  public static Fragment a(@NonNull Activity paramActivity, @NonNull QQAppInterface paramQQAppInterface, @NonNull String paramString)
  {
    if (!azZ) {
      QZLog.w("QZoneApiProxy", "createLebaFragment: not init yet");
    }
    for (;;)
    {
      return null;
      paramString = a(paramQQAppInterface.getApp(), paramString);
      if (paramString == null)
      {
        QZLog.e("QZoneApiProxy", "clazz==null");
        return null;
      }
      try
      {
        paramString = (Fragment)paramString.newInstance();
        if (paramString == null) {
          continue;
        }
        if ((paramString instanceof avsr))
        {
          try
          {
            ((avsr)paramString).attachQQContext(paramActivity, paramQQAppInterface);
            i = 1;
          }
          catch (Throwable paramActivity)
          {
            for (;;)
            {
              QZLog.w("QZoneApiProxy", "createLebaFragment: failed to init instance", paramActivity);
              i = 0;
              continue;
              paramString = null;
            }
          }
          if (i != 0) {
            return paramString;
          }
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          QZLog.w("QZoneApiProxy", "createLebaFragment: failed to create instance", paramString);
          paramString = null;
          continue;
          int i = 1;
        }
      }
    }
  }
  
  @Nullable
  public static avsm a(@NonNull Activity paramActivity)
  {
    if (!azZ) {
      QZLog.w("QZoneApiProxy", "createMsgFeedViewHolder: not init yet");
    }
    for (;;)
    {
      return null;
      Object localObject1 = a(paramActivity, "com.qzone.feed.ui.activity.QZoneMsgFeedViewHolder");
      if (localObject1 == null)
      {
        QZLog.w("QZoneApiProxy", "createMsgFeedViewHolder: failed to get class");
        return null;
      }
      try
      {
        localObject1 = ((Class)localObject1).getConstructor(new Class[] { Activity.class });
        if (localObject1 == null) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        try
        {
          paramActivity = (avsm)((Constructor)localObject1).newInstance(new Object[] { paramActivity });
          return paramActivity;
          localThrowable = localThrowable;
          QZLog.w("QZoneApiProxy", "createMsgFeedViewHolder failed to get constructor", localThrowable);
          Object localObject2 = null;
        }
        catch (Throwable paramActivity)
        {
          for (;;)
          {
            QZLog.w("QZoneApiProxy", "createMsgFeedViewHolder failed to create instance", paramActivity);
            paramActivity = null;
          }
        }
      }
    }
  }
  
  @Nullable
  private static <T> Class<T> a(@NonNull Context paramContext, @NonNull String paramString)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = Class.forName(paramString);
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          Object localObject2 = QzonePluginProxyActivity.c(paramContext).loadClass(paramString);
          return localObject2;
        }
        catch (Throwable paramContext)
        {
          QZLog.w("QZoneApiProxy", "createAdapter: failed to get class by qzone plugin class loader", paramContext);
        }
        localThrowable = localThrowable;
        QZLog.d("QZoneApiProxy", 2, "createAdapter: failed to get class by normal class loader", localThrowable);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {}
    return localObject1;
  }
  
  public static boolean a(@Nullable avsn.a parama)
  {
    QZLog.i("QZoneApiProxy", "needLoadQZoneEnv: is launch ? " + BaseApplicationImpl.isCurrentVersionFirstLaunch);
    boolean bool2;
    if (!aLw())
    {
      if (parama != null) {
        parama.yA(false);
      }
      bool2 = false;
      return bool2;
    }
    if ((!BaseApplicationImpl.isCurrentVersionFirstLaunch) || (azZ))
    {
      if (parama != null) {
        parama.yA(true);
      }
      return true;
    }
    PluginManagerClient localPluginManagerClient = (PluginManagerClient)bq.get();
    if (localPluginManagerClient != null)
    {
      if ((localPluginManagerClient.isPluginInstalled("qzone_plugin.apk")) && (cU(BaseApplicationImpl.getApplication()))) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (parama == null) {
          break;
        }
        parama.yA(bool1);
        return bool1;
      }
    }
    long l = System.nanoTime();
    PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getApplication(), new avso(l, parama));
    return false;
  }
  
  public static boolean aLw()
  {
    return Build.VERSION.SDK_INT != 19;
  }
  
  public static boolean aLx()
  {
    return Build.VERSION.SDK_INT > 19;
  }
  
  public static boolean aLy()
  {
    return a(null);
  }
  
  public static boolean aLz()
  {
    return !azZ;
  }
  
  public static View b(Context paramContext, AttributeSet paramAttributeSet)
  {
    boolean bool = true;
    StringBuilder localStringBuilder = new StringBuilder().append("createSchoolExtendList: ");
    if (c != null) {}
    for (;;)
    {
      QZLog.i("QZoneApiProxy", bool);
      if (c != null) {
        break;
      }
      return null;
      bool = false;
    }
    try
    {
      paramContext = (View)c.newInstance(new Object[] { paramContext, paramAttributeSet });
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      QZLog.w("QZoneApiProxy", "onCreateView: failed", paramContext);
    }
    return null;
  }
  
  public static boolean b(@Nullable Activity paramActivity, @Nullable QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramActivity != null)
    {
      if (paramQQAppInterface != null) {
        break label19;
      }
      bool1 = bool2;
    }
    label19:
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!aLy());
        if (!anlm.Vr())
        {
          QZLog.e("QZoneApiProxy", "isNowSimpleUI no");
          return false;
        }
        int i = LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 0, paramQQAppInterface.getLongAccountUin());
        if ((0x10000 & i) == 0)
        {
          QZLog.e("QZoneApiProxy", "grayMask no" + i);
          return false;
        }
        bool2 = f(paramActivity, paramQQAppInterface);
        bool1 = bool2;
      } while (!bool2);
      bool1 = bool2;
    } while (paramQQAppInterface == g());
    g(paramActivity, paramQQAppInterface);
    return bool2;
  }
  
  public static String bN(Context paramContext)
  {
    String str = m(paramContext).getString("msg_page_title", "");
    paramContext = str;
    if (TextUtils.isEmpty(str)) {
      paramContext = acfp.m(2131720732);
    }
    return paramContext;
  }
  
  public static boolean c(@Nullable Activity paramActivity, @Nullable QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = true;
    if ((paramActivity == null) || (paramQQAppInterface == null)) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      boolean bool2 = f(paramActivity, paramQQAppInterface);
      if ((bool2) && (paramQQAppInterface != g())) {
        g(paramActivity, paramQQAppInterface);
      }
      if (c == null)
      {
        paramQQAppInterface = a(paramActivity, "com.qzone.feed.ui.activity.QQSchoolExtendFeedsListView");
        if (paramQQAppInterface == null) {}
      }
      try
      {
        c = paramQQAppInterface.getConstructor(new Class[] { Context.class, AttributeSet.class });
        try
        {
          paramActivity.getLayoutInflater().inflate(2131561318, null);
          i = 1;
        }
        catch (Throwable paramActivity)
        {
          for (;;)
          {
            QZLog.w("QZoneApiProxy", "needShowSchoolExtendFeed: inflate failed", paramActivity);
            int i = 0;
          }
        }
        if ((bool2) && (c != null) && (i != 0)) {
          continue;
        }
        return false;
      }
      catch (Throwable paramQQAppInterface)
      {
        for (;;)
        {
          QZLog.w("QZoneApiProxy", "needShowSchoolExtendFeed: failed to get school extend list view constructor", paramQQAppInterface);
        }
      }
    }
  }
  
  public static boolean c(@NonNull Context paramContext, @NonNull QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    long l1 = System.nanoTime();
    QZLog.e("QZoneApiProxy", "initEnv: start");
    boolean bool1;
    if (doF) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      if (L == null) {
        L = a(paramContext, "com.qzone.app.QZoneRunInQQEnv");
      }
      QZLog.e("QZoneApiProxy", "initEnv: loadQZoneClass");
      bool1 = bool2;
      if (L == null) {
        continue;
      }
      try
      {
        paramContext = L.getMethod("init", new Class[] { QQAppInterface.class });
        bool1 = bool2;
        if (paramContext == null) {
          continue;
        }
      }
      catch (Throwable paramContext)
      {
        try
        {
          bool1 = ((Boolean)paramContext.invoke(null, new Object[] { paramQQAppInterface })).booleanValue();
          doF = bool1;
          long l2 = System.nanoTime();
          QZLog.e("QZoneApiProxy", "initEnv: end " + doF + " " + (l2 - l1));
          return doF;
          paramContext = paramContext;
          QZLog.w("QZoneApiProxy", "initEnv: failed to get init env method", paramContext);
          paramContext = null;
        }
        catch (Throwable paramContext)
        {
          for (;;)
          {
            QZLog.w("QZoneApiProxy", "initEnv: failed to init", paramContext);
            bool1 = false;
          }
        }
      }
    }
  }
  
  public static boolean cU(@NonNull Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1;
    if (doG) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      if (L == null) {
        L = a(paramContext, "com.qzone.app.QZoneRunInQQEnv");
      }
      QZLog.e("QZoneApiProxy", "isQzoneVersionRight: loadQZoneClass");
      bool1 = bool2;
      if (L == null) {
        continue;
      }
      try
      {
        paramContext = L.getMethod("isQzoneVersionRight", new Class[0]);
        bool1 = bool2;
        if (paramContext == null) {
          continue;
        }
      }
      catch (Throwable paramContext)
      {
        try
        {
          bool1 = ((Boolean)paramContext.invoke(null, new Object[0])).booleanValue();
          doG = bool1;
          return bool1;
          paramContext = paramContext;
          QZLog.w("QZoneApiProxy", "isQzoneVersionRight: failed to get init env method", paramContext);
          paramContext = null;
        }
        catch (Throwable paramContext)
        {
          for (;;)
          {
            QZLog.w("QZoneApiProxy", "isQzoneVersionRight: failed to init", paramContext);
            bool1 = false;
          }
        }
      }
    }
  }
  
  public static boolean d(@Nullable Activity paramActivity, @Nullable QQAppInterface paramQQAppInterface)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null)) {}
    while (QzoneConfig.getInstance().getConfig("QZoneSetting", "AioShowFeedList", 1) == 0) {
      return false;
    }
    return f(paramActivity, paramQQAppInterface);
  }
  
  public static boolean d(@NonNull Context paramContext, @NonNull QQAppInterface paramQQAppInterface)
  {
    k = 0;
    l1 = System.nanoTime();
    QZLog.e("QZoneApiProxy", "initServlet: start");
    if (azZ) {
      return true;
    }
    ((avfw)paramQQAppInterface.getManager(27)).installPlugin("qzone_plugin.apk");
    paramContext = a(paramContext, "com.qzone.common.servlet.QZoneServlet");
    if (paramContext == null) {
      return false;
    }
    ServletContainer localServletContainer;
    try
    {
      localObject1 = (MSFServlet)paramContext.newInstance();
      if (localObject1 == null) {
        return false;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        QZLog.w("QZoneApiProxy", "initServlet: failed to get servlet instance", paramContext);
        localObject1 = null;
      }
      try
      {
        paramContext = AppRuntime.class.getDeclaredField("mServletContainer");
        paramContext.setAccessible(true);
        localServletContainer = (ServletContainer)paramContext.get(paramQQAppInterface);
        if (localServletContainer == null) {
          return false;
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          QZLog.w("QZoneApiProxy", "initServlet: failed to get container", paramContext);
          localServletContainer = null;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramContext = ServletContainer.class.getDeclaredField("managedServlet");
        paramContext.setAccessible(true);
        paramContext = (Map)paramContext.get(localServletContainer);
        Object localObject2;
        QZLog.w("QZoneApiProxy", "initServlet: failed to get container field", localThrowable2);
      }
      catch (Throwable localThrowable2)
      {
        try
        {
          localObject2 = ServletContainer.class.getDeclaredField("actionMap");
          ((Field)localObject2).setAccessible(true);
          localObject2 = (Map)((Field)localObject2).get(localServletContainer);
          if ((paramContext != null) && (localObject2 != null)) {
            break;
          }
          return false;
        }
        catch (Throwable localThrowable3)
        {
          Object localObject3;
          Object localObject4;
          Method localMethod;
          int i;
          int m;
          Set localSet;
          long l2;
          break label200;
        }
        localThrowable2 = localThrowable2;
        paramContext = null;
      }
      label200:
      localObject3 = null;
    }
    try
    {
      localObject4 = Servlet.class.getDeclaredMethod("init", new Class[] { AppRuntime.class, ServletContainer.class });
      ((Method)localObject4).setAccessible(true);
      localMethod = Servlet.class.getDeclaredMethod("onCreate", new Class[0]);
      localMethod.setAccessible(true);
      ((Method)localObject4).invoke(localObject1, new Object[] { paramQQAppInterface, localServletContainer });
      localMethod.invoke(localObject1, new Object[0]);
      i = 1;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        QZLog.w("QZoneApiProxy", "initServlet: failed to get init method", localThrowable1);
        i = 0;
      }
      try
      {
        paramContext.put("com.qzone.common.servlet.QZoneServlet", localObject1);
        localObject4 = ((MSFServlet)localObject1).getPreferSSOCommands();
        if (localObject4 == null) {
          break label435;
        }
        m = localObject4.length;
        i = k;
        while (i < m)
        {
          localMethod = localObject4[i];
          localSet = (Set)localObject3.get(localMethod);
          localObject1 = localSet;
          if (localSet == null)
          {
            localObject1 = new HashSet();
            localObject3.put(localMethod, localObject1);
          }
          ((Set)localObject1).add("com.qzone.common.servlet.QZoneServlet");
          i += 1;
        }
        eU(paramQQAppInterface);
        l2 = System.nanoTime();
        QZLog.i("QZoneApiProxy", "initServlet: ok " + paramQQAppInterface.getCurrentUin() + " " + (l2 - l1));
        azZ = true;
        return true;
      }
      finally {}
    }
    if (i == 0) {
      return false;
    }
  }
  
  public static boolean e(@Nullable Activity paramActivity, @Nullable QQAppInterface paramQQAppInterface)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null)) {}
    while (QzoneConfig.getInstance().getConfig("QZoneSetting", "SubShowFeedList", 1) == 0) {
      return false;
    }
    if (!m(paramActivity).getBoolean("show_sub_feeds", false)) {
      QZLog.i("QZoneApiProxy", "needShowSubFeedList: close by server");
    }
    return f(paramActivity, paramQQAppInterface);
  }
  
  public static void eBM()
  {
    PublicFragmentActivity.a("com.qzone.feed.ui.activity.QQSchoolExtendFeedsListView", new avsn.b(null));
  }
  
  public static void eU(QQAppInterface paramQQAppInterface)
  {
    bp = new WeakReference(paramQQAppInterface);
  }
  
  private static boolean f(@NonNull Activity paramActivity, @NonNull QQAppInterface paramQQAppInterface)
  {
    boolean bool = true;
    int i = LocalMultiProcConfig.getInt4Uin("creditlevel", 0, paramQQAppInterface.getLongAccountUin());
    if (i == 8)
    {
      QZLog.e("QZoneApiProxy", "creditLevel" + i);
      return false;
    }
    if ((azZ) && (doF)) {
      return true;
    }
    if (!PluginUtils.getInstalledPluginPath(paramActivity, "qzone_plugin.apk").exists())
    {
      QZLog.e("QZoneApiProxy", "file not exists");
      return false;
    }
    if (BaseApplicationImpl.isCurrentVersionFirstLaunch)
    {
      if (InstallPlugins.a == null)
      {
        i = Build.VERSION.SDK_INT;
        if ((i == 21) || (i == 22))
        {
          QZLog.e("QZoneApiProxy", "isQZonePluginValid null install result");
          return false;
        }
      }
      else if (!InstallPlugins.a.cIK)
      {
        QZLog.i("QZoneApiProxy", "isQZonePluginValid qzone install failed");
        return false;
      }
      try
      {
        QzonePluginProxyActivity.c(BaseApplicationImpl.getApplication());
        if ((!d(paramActivity, paramQQAppInterface)) || (!c(paramActivity, paramQQAppInterface)))
        {
          QZLog.e("QZoneApiProxy", "initServlet erro");
          return false;
        }
      }
      catch (Throwable paramActivity)
      {
        QLog.e("QZoneApiProxy", 1, "needShowQzoneFrame", paramActivity);
        return false;
      }
      return true;
    }
    if ((d(paramActivity, paramQQAppInterface)) && (c(paramActivity, paramQQAppInterface))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static QQAppInterface g()
  {
    if (bp == null) {
      return null;
    }
    return (QQAppInterface)bp.get();
  }
  
  public static void g(@NonNull Context paramContext, @NonNull QQAppInterface paramQQAppInterface)
  {
    QZLog.i("QZoneApiProxy", "onAccountChange: " + paramQQAppInterface.getCurrentUin() + " " + doF + " " + azZ);
    if (!doF) {
      c(paramContext, paramQQAppInterface);
    }
    for (;;)
    {
      return;
      if (L == null) {
        L = a(paramContext, "com.qzone.app.QZoneRunInQQEnv");
      }
      if (L == null) {
        continue;
      }
      if (Y == null) {}
      try
      {
        Y = L.getMethod("onAccountChange", new Class[] { QQAppInterface.class });
        if (Y == null) {
          continue;
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          Y.invoke(null, new Object[] { paramQQAppInterface });
          if (!azZ) {
            continue;
          }
          azZ = false;
          d(paramContext, paramQQAppInterface);
          return;
          localThrowable1 = localThrowable1;
          QZLog.w("QZoneApiProxy", "onAccountChange: failed to get change account method", localThrowable1);
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            QZLog.w("QZoneApiProxy", "onAccountChange: failed to call change account method", localThrowable2);
          }
        }
      }
    }
  }
  
  public static void h(@NonNull Context paramContext, boolean paramBoolean, @Nullable String paramString)
  {
    QZLog.i("QZoneApiProxy", "recordShowSubFeedConfig: " + paramBoolean + " " + paramString);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    m(paramContext).edit().putBoolean("show_sub_feeds", paramBoolean).putString("msg_page_title", str).apply();
  }
  
  @NonNull
  private static SharedPreferences m(@NonNull Context paramContext)
  {
    j.compareAndSet(null, paramContext.getSharedPreferences("qzone_api_proxy_sp_name", 0));
    return (SharedPreferences)j.get();
  }
  
  public static abstract interface a
  {
    public abstract void yA(boolean paramBoolean);
  }
  
  static class b
    implements PublicFragmentActivity.a
  {
    public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
    {
      if (!"com.qzone.feed.ui.activity.QQSchoolExtendFeedsListView".equals(paramString)) {
        return null;
      }
      return avsn.b(paramContext, paramAttributeSet);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avsn
 * JD-Core Version:    0.7.0.1
 */