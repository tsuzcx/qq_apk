import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class ueg
{
  private static WSRedDotPushMsg a()
  {
    Object localObject = ugh.a();
    if (localObject != null)
    {
      localObject = ((ugh)localObject).a;
      if (localObject != null)
      {
        uqf.b("WeishiActivityHelper", "transformTrendsTabConfigToPushMsg mStrategyConfig=" + ((ugj)localObject).a);
        if (!TextUtils.isEmpty(((ugj)localObject).a)) {
          return WSRedDotPushMsg.getInstance(((ugj)localObject).a);
        }
      }
    }
    return null;
  }
  
  private static WSRedDotPushMsg a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("TrendsTab RedDot Msg : ");
    if (paramAppInfo != null) {}
    for (Object localObject = paramAppInfo.buffer.get();; localObject = "appInfo is null.")
    {
      uqf.b("WeishiActivityHelper", (String)localObject);
      if ((paramAppInfo == null) || (TextUtils.isEmpty(paramAppInfo.buffer.get()))) {
        break label154;
      }
      try
      {
        localObject = new JSONObject(paramAppInfo.buffer.get());
        paramAppInfo = ((JSONObject)localObject).optString("_show_mission");
        localObject = ((JSONObject)localObject).optJSONObject("msg");
        if ((localObject == null) || (TextUtils.isEmpty(paramAppInfo))) {
          break label154;
        }
        paramAppInfo = ((JSONObject)localObject).optJSONObject(paramAppInfo);
        if (paramAppInfo == null) {
          break label154;
        }
        paramAppInfo = paramAppInfo.optString("extinfo");
        uqf.b("WeishiActivityHelper", "TrendsTab RedDot extInfoStr : " + paramAppInfo);
        paramAppInfo = WSRedDotPushMsg.getInstance(paramAppInfo);
        return paramAppInfo;
      }
      catch (JSONException paramAppInfo)
      {
        paramAppInfo.printStackTrace();
      }
    }
    label154:
    return null;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    if (paramIntent == null)
    {
      uqf.d("WeishiActivityHelper", "gotoVideoLayerFromTrendsTab intent is null.");
      return;
    }
    if (paramWSRedDotPushMsg != null) {
      paramIntent.putExtra("key_weishi_push_msg_data", paramWSRedDotPushMsg);
    }
    bmtd.a(paramActivity, bmtk.a(), paramIntent);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    localIntent.putExtra("big_brother_source_key", "biz_src_gzh_weishi");
    localIntent.putExtra("url", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    paramInt = 1;
    uqf.d("WeishiActivityHelper", "外部跳转微视公众号 from=" + paramString);
    if (paramContext == null)
    {
      uqf.d("WSPushLog", "WeishiActivityHelper handleJumpTargetVideoFeed, context is null.");
      return;
    }
    if (TextUtils.equals(paramString, "from_home_page"))
    {
      paramString = uqt.a();
      unx.a(paramString);
      uno.a(paramString);
      if (a(paramContext, paramString, 2, null))
      {
        paramContext = WSPublicAccReport.getInstance();
        if (paramString == null) {}
        for (;;)
        {
          paramContext.enterPublicAccReport(paramString, paramInt);
          uem.a().b();
          return;
          paramInt = paramString.mStrategyInfo.getType();
        }
      }
    }
    WSPublicAccReport.getInstance().enterPublicAccReport(null, 1);
    WSHomeFragment.a(paramContext, 1, paramBoolean);
  }
  
  public static void a(Context paramContext, String paramString, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    MiniAppLauncher.startMiniApp(paramContext, ujx.a(paramString), 4006, paramMiniAppLaunchListener);
  }
  
  public static void a(Context paramContext, boolean paramBoolean, BusinessInfoCheckUpdate.AppInfo paramAppInfo, Intent paramIntent)
  {
    uqf.b("WeishiActivityHelper", "handleTrendsTabClick hasRedDot = " + paramBoolean);
    if (paramBoolean)
    {
      paramAppInfo = a(paramAppInfo);
      unx.b();
    }
    for (;;)
    {
      unx.a(paramAppInfo, paramBoolean);
      WSPublicAccReport.getInstance().enterTrendsTabReport(paramAppInfo, paramBoolean);
      if (!a(paramContext, paramAppInfo, 6, paramIntent)) {
        break;
      }
      return;
      paramAppInfo = a();
    }
    a((Activity)paramContext, paramIntent, paramAppInfo);
  }
  
  private static boolean a(Context paramContext, WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt, Intent paramIntent)
  {
    uqf.a("WeishiActivityHelper", "handleRedDotClick scene=" + paramInt + ", pushMsgData=" + paramWSRedDotPushMsg);
    if ((paramWSRedDotPushMsg != null) && (paramWSRedDotPushMsg.mStrategyInfo != null))
    {
      umo localumo = (umo)paramWSRedDotPushMsg.mStrategyInfo;
      paramWSRedDotPushMsg = umz.a(paramWSRedDotPushMsg, paramInt, paramIntent);
      if (paramWSRedDotPushMsg != null) {
        return paramWSRedDotPushMsg.a(paramContext, localumo);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ueg
 * JD-Core Version:    0.7.0.1
 */