import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import cooperation.qqcircle.proxy.QCircleInvokeProxy;
import cooperation.qqcircle.report.QCircleReportFirstLogin;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import mqq.os.MqqHandler;

public class vgn
{
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
    ThreadManagerExecutor.getExecutorService(192).execute(new QCirclePluginEnter.1(paramContext, paramQCirclePluginInitBean));
  }
  
  public static void a(Context paramContext, ILoadPluginDelegate paramILoadPluginDelegate)
  {
    if ((paramContext != null) && (!vgw.a().a())) {
      ThreadManagerExecutor.getExecutorService(192).execute(new QCirclePluginEnter.2(paramILoadPluginDelegate, paramContext));
    }
    while (!vgw.a().a()) {
      return;
    }
    if (paramILoadPluginDelegate != null) {
      ThreadManager.getUIHandler().post(new QCirclePluginEnter.3(paramILoadPluginDelegate));
    }
    QLog.i("QCIRCLE_PLUGIN", 1, "preloadQCirclePlugin()has preload");
  }
  
  public static void a(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
    QCircleReportFirstLogin.recordFirstLoginSource(paramHashMap);
    if (a())
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "enterBySchemeAction in main process");
      QCirclePluginInitBean localQCirclePluginInitBean = new QCirclePluginInitBean();
      localQCirclePluginInitBean.setLoadAction(1003);
      QCircleSchemeBean localQCircleSchemeBean = new QCircleSchemeBean();
      localQCircleSchemeBean.setSchemeAction(paramString);
      localQCircleSchemeBean.setAttrs(paramHashMap);
      long l = System.currentTimeMillis();
      localQCircleSchemeBean.setEnterTime(l);
      localQCirclePluginInitBean.setInitBean(localQCircleSchemeBean);
      localQCirclePluginInitBean.setStartTime(l);
      if (!vgw.a().a())
      {
        QLog.i("QCIRCLE_PLUGIN", 1, "enterBySchemeAction plugin not load");
        paramString = new Intent();
        paramString.addFlags(268435456);
        paramString.setClass(BaseApplicationImpl.getContext(), PublicTransFragmentActivity.class);
        paramString.putExtra("public_fragment_class", QCirclePluginLoadingFragment.class.getCanonicalName());
        paramString.putExtra("public_fragment_window_feature", 1);
        paramString.putExtra("KEY_Q_CIRCLE_PLUGIN_INIT_BEAN", localQCirclePluginInitBean);
        paramContext.startActivity(paramString);
        return;
      }
      QLog.i("QCIRCLE_PLUGIN", 1, "enterBySchemeAction plugin is load");
      a(paramContext, localQCirclePluginInitBean);
      return;
    }
    QLog.i("QCIRCLE_PLUGIN", 1, "enterBySchemeAction not in main process, use jump activity");
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
  
  private static void b(Context paramContext, vgo paramvgo, int paramInt, QCirclePluginInitBean paramQCirclePluginInitBean)
  {
    QCircleInvokeProxy.invoke(2, 3, new Object[0]);
    Object localObject = paramvgo.a();
    Bundle localBundle = new Bundle();
    localBundle.putString("pluginZipPath", ((vgv)localObject).a());
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
      paramvgo.a(paramContext, paramInt, localBundle, null);
      return;
    }
    paramvgo.enter(paramContext, paramInt, localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgn
 * JD-Core Version:    0.7.0.1
 */