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
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class uyt
{
  private static WSRedDotPushMsg a()
  {
    Object localObject = vay.a();
    if (localObject != null)
    {
      localObject = ((vay)localObject).a;
      if (localObject != null)
      {
        vmp.b("WeishiActivityHelper", "transformTrendsTabConfigToPushMsg mStrategyConfig=" + ((vba)localObject).a);
        if (!TextUtils.isEmpty(((vba)localObject).a)) {
          return WSRedDotPushMsg.getInstance(((vba)localObject).a);
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
      vmp.b("WeishiActivityHelper", (String)localObject);
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
        vmp.b("WeishiActivityHelper", "TrendsTab RedDot extInfoStr : " + paramAppInfo);
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
      vmp.d("WeishiActivityHelper", "gotoVideoLayerFromTrendsTab intent is null.");
      return;
    }
    if (paramWSRedDotPushMsg != null) {
      paramIntent.putExtra("key_weishi_push_msg_data", paramWSRedDotPushMsg);
    }
    QZoneHelper.forwardToQzoneTransluentActivity(paramActivity, QZoneHelper.UserInfo.getInstance(), paramIntent);
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
    vmp.d("WeishiActivityHelper", "外部跳转微视公众号 from=" + paramString);
    if (paramContext == null)
    {
      vmp.d("WSPushLog", "WeishiActivityHelper handleJumpTargetVideoFeed, context is null.");
      return;
    }
    if (TextUtils.equals(paramString, "from_home_page"))
    {
      WSRedDotPushMsg localWSRedDotPushMsg = vnd.a();
      vkf.a(localWSRedDotPushMsg);
      vjx.a(localWSRedDotPushMsg);
      if (a(paramContext, localWSRedDotPushMsg, 2, null))
      {
        paramContext = WSPublicAccReport.getInstance();
        if (localWSRedDotPushMsg == null) {}
        for (;;)
        {
          paramContext.enterPublicAccReport(localWSRedDotPushMsg, paramInt, paramString);
          uyz.a().b();
          return;
          paramInt = localWSRedDotPushMsg.mStrategyInfo.getType();
        }
      }
    }
    if (!TextUtils.equals(paramString, "from_qq_chat")) {
      WSPublicAccReport.getInstance().enterPublicAccReport(null, 1, paramString);
    }
    WSHomeFragment.a(paramContext, 1, paramBoolean);
  }
  
  public static void a(Context paramContext, String paramString, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    MiniAppLauncher.startMiniApp(paramContext, vfa.a(paramString), 4006, paramMiniAppLaunchListener);
  }
  
  public static void a(Context paramContext, boolean paramBoolean, BusinessInfoCheckUpdate.AppInfo paramAppInfo, Intent paramIntent)
  {
    vmp.b("WeishiActivityHelper", "handleTrendsTabClick hasRedDot = " + paramBoolean);
    if (paramBoolean)
    {
      paramAppInfo = a(paramAppInfo);
      vkf.b();
    }
    for (;;)
    {
      vkf.a(paramAppInfo, paramBoolean);
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
    vmp.a("WeishiActivityHelper", "handleRedDotClick scene=" + paramInt + ", pushMsgData=" + paramWSRedDotPushMsg);
    if ((paramWSRedDotPushMsg != null) && (paramWSRedDotPushMsg.mStrategyInfo != null))
    {
      viv localviv = (viv)paramWSRedDotPushMsg.mStrategyInfo;
      paramWSRedDotPushMsg = vjg.a(paramWSRedDotPushMsg, paramInt, paramIntent);
      if (paramWSRedDotPushMsg != null) {
        return paramWSRedDotPushMsg.a(paramContext, localviv);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyt
 * JD-Core Version:    0.7.0.1
 */