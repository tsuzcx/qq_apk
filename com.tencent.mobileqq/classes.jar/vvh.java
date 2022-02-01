import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitBean;
import com.tencent.biz.qcircleshadow.lib.delegate.ILoadPluginDelegate;
import com.tencent.biz.qcircleshadow.local.QCirclePluginEnter.1;
import com.tencent.biz.qcircleshadow.local.QCirclePluginEnter.2;
import com.tencent.biz.qcircleshadow.local.QCirclePluginEnter.3;
import com.tencent.biz.qcircleshadow.local.fragment.QCirclePluginLoadingFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import cooperation.qqcircle.proxy.QCircleInvokeProxy;
import cooperation.qqcircle.report.QCircleReportFirstLogin;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.os.MqqHandler;

public class vvh
{
  private static Handler a;
  
  static
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("qcircle_plugin_enter", 0);
    localHandlerThread.start();
    a = new Handler(localHandlerThread.getLooper());
  }
  
  private static String a(String paramString, HashMap<String, String> paramHashMap)
  {
    paramString = new StringBuilder("mqqapi://qcircle/" + paramString + "?");
    if (paramHashMap != null)
    {
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramHashMap.get(str1);
        paramString.append(str1).append("=").append(str2).append("&");
      }
    }
    return paramString.toString();
  }
  
  public static void a(Context paramContext, QCirclePluginInitBean paramQCirclePluginInitBean)
  {
    if (a == null) {
      return;
    }
    a.post(new QCirclePluginEnter.1(paramQCirclePluginInitBean, paramContext));
  }
  
  public static void a(Context paramContext, ILoadPluginDelegate paramILoadPluginDelegate)
  {
    if ((paramContext != null) && (!vvq.a().a()) && (a != null)) {
      a.post(new QCirclePluginEnter.2(paramILoadPluginDelegate, paramContext));
    }
    while (!vvq.a().a()) {
      return;
    }
    if (paramILoadPluginDelegate != null) {
      ThreadManager.getUIHandler().post(new QCirclePluginEnter.3(paramILoadPluginDelegate));
    }
    QLog.i("QCIRCLE_PLUGIN", 1, "preloadQCirclePlugin()has preload");
  }
  
  public static void a(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
    a(paramContext, paramString, paramHashMap, null);
  }
  
  public static void a(Context paramContext, String paramString, HashMap<String, String> paramHashMap, HashMap<String, byte[]> paramHashMap1)
  {
    QCircleReportFirstLogin.recordFirstLoginSource(paramHashMap);
    if (a())
    {
      QCirclePluginInitBean localQCirclePluginInitBean = new QCirclePluginInitBean();
      localQCirclePluginInitBean.setLoadAction(1003);
      QCircleSchemeBean localQCircleSchemeBean = new QCircleSchemeBean();
      localQCircleSchemeBean.setSchemeAction(paramString);
      localQCircleSchemeBean.setAttrs(paramHashMap);
      long l = System.currentTimeMillis();
      localQCircleSchemeBean.setEnterTime(l);
      if (paramHashMap1 != null) {
        localQCircleSchemeBean.setByteAttrs(paramHashMap1);
      }
      localQCirclePluginInitBean.setInitBean(localQCircleSchemeBean);
      localQCirclePluginInitBean.setStartTime(l);
      if (!vvq.a().a())
      {
        paramString = new Intent();
        paramString.addFlags(268435456);
        paramString.setClass(BaseApplicationImpl.getContext(), PublicTransFragmentActivity.class);
        paramString.putExtra("public_fragment_class", QCirclePluginLoadingFragment.class.getCanonicalName());
        paramString.putExtra("public_fragment_window_feature", 1);
        paramString.putExtra("KEY_Q_CIRCLE_PLUGIN_INIT_BEAN", localQCirclePluginInitBean);
        paramContext.startActivity(paramString);
        return;
      }
      a(paramContext, localQCirclePluginInitBean);
      return;
    }
    b(paramContext, paramString, paramHashMap);
  }
  
  public static boolean a()
  {
    return BaseApplicationImpl.sProcessId == 1;
  }
  
  private static void b(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Intent localIntent = new Intent(paramContext, JumpActivity.class);
    localIntent.setData(Uri.parse(a(paramString, paramHashMap)));
    paramContext.startActivity(localIntent);
  }
  
  private static void b(Context paramContext, vvi paramvvi, int paramInt, QCirclePluginInitBean paramQCirclePluginInitBean)
  {
    QCircleInvokeProxy.invoke(2, 3, new Object[0]);
    Object localObject = paramvvi.a();
    Bundle localBundle = new Bundle();
    localBundle.putString("pluginZipPath", ((vvp)localObject).a());
    localBundle.putString("KEY_PLUGIN_PART_KEY", "qcircle-plugin");
    localBundle.putString("KEY_ACTIVITY_CLASSNAME", "com.tencent.qcircle.activity.QCircleSplashActivity");
    if (paramQCirclePluginInitBean != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putSerializable("KEY_Q_CIRCLE_PLUGIN_INIT_BEAN", paramQCirclePluginInitBean);
      localBundle.putBundle("KEY_EXTRAS", (Bundle)localObject);
    }
    if (paramInt == 1000)
    {
      paramvvi.a(paramContext, paramInt, localBundle, null);
      return;
    }
    paramvvi.enter(paramContext, paramInt, localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvh
 * JD-Core Version:    0.7.0.1
 */